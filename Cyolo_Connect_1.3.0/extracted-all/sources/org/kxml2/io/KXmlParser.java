package org.kxml2.io;

import androidx.core.os.EnvironmentCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class KXmlParser implements XmlPullParser {
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final int LEGACY = 999;
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    private static final int XML_DECL = 998;
    private int attributeCount;
    private int column;
    private boolean degenerated;
    private int depth;
    private String encoding;
    private Hashtable entityMap;
    private String error;
    private boolean isWhitespace;
    private int line;
    private Object location;
    private String name;
    private String namespace;
    private int peekCount;
    private String prefix;
    private boolean processNsp;
    private Reader reader;
    private boolean relaxed;
    private char[] srcBuf;
    private int srcCount;
    private int srcPos;
    private Boolean standalone;
    private boolean token;
    private int txtPos;
    private int type;
    private boolean unresolved;
    private String version;
    private boolean wasCR;
    private String[] elementStack = new String[16];
    private String[] nspStack = new String[8];
    private int[] nspCounts = new int[4];
    private char[] txtBuf = new char[128];
    private String[] attributes = new String[16];
    private int stackMismatch = 0;
    private int[] peek = new int[2];

    public KXmlParser() {
        this.srcBuf = new char[Runtime.getRuntime().freeMemory() >= 1048576 ? 8192 : 128];
    }

    private final boolean adjustNsp() throws XmlPullParserException {
        int i;
        String strSubstring;
        int i2 = 0;
        boolean z = false;
        while (true) {
            i = this.attributeCount;
            if (i2 >= (i << 2)) {
                break;
            }
            String str = this.attributes[i2 + 2];
            int iIndexOf = str.indexOf(58);
            if (iIndexOf != -1) {
                String strSubstring2 = str.substring(0, iIndexOf);
                strSubstring = str.substring(iIndexOf + 1);
                str = strSubstring2;
            } else {
                if (str.equals("xmlns")) {
                    strSubstring = null;
                }
                i2 += 4;
            }
            if (str.equals("xmlns")) {
                int[] iArr = this.nspCounts;
                int i3 = this.depth;
                int i4 = iArr[i3];
                iArr[i3] = i4 + 1;
                int i5 = i4 << 1;
                String[] strArrEnsureCapacity = ensureCapacity(this.nspStack, i5 + 2);
                this.nspStack = strArrEnsureCapacity;
                strArrEnsureCapacity[i5] = strSubstring;
                String[] strArr = this.attributes;
                int i6 = i2 + 3;
                strArrEnsureCapacity[i5 + 1] = strArr[i6];
                if (strSubstring != null && strArr[i6].equals("")) {
                    error("illegal empty namespace");
                }
                String[] strArr2 = this.attributes;
                int i7 = this.attributeCount - 1;
                this.attributeCount = i7;
                System.arraycopy(strArr2, i2 + 4, strArr2, i2, (i7 << 2) - i2);
                i2 -= 4;
            } else {
                z = true;
            }
            i2 += 4;
        }
        if (z) {
            for (int i8 = (i << 2) - 4; i8 >= 0; i8 -= 4) {
                int i9 = i8 + 2;
                String str2 = this.attributes[i9];
                int iIndexOf2 = str2.indexOf(58);
                if (iIndexOf2 == 0 && !this.relaxed) {
                    throw new RuntimeException(new StringBuffer("illegal attribute name: ").append(str2).append(" at ").append(this).toString());
                }
                if (iIndexOf2 != -1) {
                    String strSubstring3 = str2.substring(0, iIndexOf2);
                    String strSubstring4 = str2.substring(iIndexOf2 + 1);
                    String namespace = getNamespace(strSubstring3);
                    if (namespace == null && !this.relaxed) {
                        throw new RuntimeException(new StringBuffer("Undefined Prefix: ").append(strSubstring3).append(" in ").append(this).toString());
                    }
                    String[] strArr3 = this.attributes;
                    strArr3[i8] = namespace;
                    strArr3[i8 + 1] = strSubstring3;
                    strArr3[i9] = strSubstring4;
                }
            }
        }
        int iIndexOf3 = this.name.indexOf(58);
        if (iIndexOf3 == 0) {
            error(new StringBuffer("illegal tag name: ").append(this.name).toString());
        }
        if (iIndexOf3 != -1) {
            this.prefix = this.name.substring(0, iIndexOf3);
            this.name = this.name.substring(iIndexOf3 + 1);
        }
        String namespace2 = getNamespace(this.prefix);
        this.namespace = namespace2;
        if (namespace2 == null) {
            if (this.prefix != null) {
                error(new StringBuffer("undefined prefix: ").append(this.prefix).toString());
            }
            this.namespace = "";
        }
        return z;
    }

    private final String[] ensureCapacity(String[] strArr, int i) {
        if (strArr.length >= i) {
            return strArr;
        }
        String[] strArr2 = new String[i + 16];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private final void error(String str) throws XmlPullParserException {
        if (!this.relaxed) {
            exception(str);
        } else if (this.error == null) {
            this.error = new StringBuffer("ERR: ").append(str).toString();
        }
    }

    private final void exception(String str) throws XmlPullParserException {
        if (str.length() >= 100) {
            str = new StringBuffer().append(str.substring(0, 100)).append(IOUtils.LINE_SEPARATOR_UNIX).toString();
        }
        throw new XmlPullParserException(str, this, null);
    }

    private final String get(int i) {
        return new String(this.txtBuf, i, this.txtPos - i);
    }

    private final boolean isProp(String str, boolean z, String str2) {
        if (str.startsWith("http://xmlpull.org/v1/doc/")) {
            return str.substring(z ? 42 : 40).equals(str2);
        }
        return false;
    }

    private final void nextImpl() throws XmlPullParserException, IOException {
        int legacy;
        if (this.reader == null) {
            exception("No Input specified");
        }
        if (this.type == 3) {
            this.depth--;
        }
        do {
            this.attributeCount = -1;
            if (this.degenerated) {
                this.degenerated = false;
                this.type = 3;
                return;
            }
            if (this.error != null) {
                for (int i = 0; i < this.error.length(); i++) {
                    push(this.error.charAt(i));
                }
                this.error = null;
                this.type = 9;
                return;
            }
            if (this.relaxed && (this.stackMismatch > 0 || (peek(0) == -1 && this.depth > 0))) {
                int i2 = (this.depth - 1) << 2;
                this.type = 3;
                String[] strArr = this.elementStack;
                this.namespace = strArr[i2];
                this.prefix = strArr[i2 + 1];
                this.name = strArr[i2 + 2];
                if (this.stackMismatch != 1) {
                    this.error = new StringBuffer("missing end tag /").append(this.name).append(" inserted").toString();
                }
                int i3 = this.stackMismatch;
                if (i3 > 0) {
                    this.stackMismatch = i3 - 1;
                    return;
                }
                return;
            }
            this.prefix = null;
            this.name = null;
            this.namespace = null;
            int iPeekType = peekType();
            this.type = iPeekType;
            if (iPeekType == 1) {
                return;
            }
            if (iPeekType == 2) {
                parseStartTag(false);
                return;
            }
            if (iPeekType == 3) {
                parseEndTag();
                return;
            }
            if (iPeekType == 4) {
                pushText(60, !this.token);
                if (this.depth == 0 && this.isWhitespace) {
                    this.type = 7;
                    return;
                }
                return;
            }
            if (iPeekType == 6) {
                pushEntity();
                return;
            } else {
                legacy = parseLegacy(this.token);
                this.type = legacy;
            }
        } while (legacy == XML_DECL);
    }

    private final void parseDoctype(boolean z) throws XmlPullParserException, IOException {
        int i = 1;
        boolean z2 = false;
        while (true) {
            int i2 = read();
            if (i2 == -1) {
                error(UNEXPECTED_EOF);
                return;
            }
            if (i2 == 39) {
                z2 = !z2;
            } else if (i2 != 60) {
                if (i2 == 62 && !z2 && i - 1 == 0) {
                    return;
                }
            } else if (!z2) {
                i++;
            }
            if (z) {
                push(i2);
            }
        }
    }

    private final void parseEndTag() throws XmlPullParserException, IOException {
        read();
        read();
        this.name = readName();
        skip();
        read(Typography.greater);
        int i = this.depth;
        int i2 = (i - 1) << 2;
        if (i == 0) {
            error("element stack empty");
            this.type = 9;
            return;
        }
        int i3 = i2 + 3;
        if (!this.name.equals(this.elementStack[i3])) {
            error(new StringBuffer("expected: /").append(this.elementStack[i3]).append(" read: ").append(this.name).toString());
            int i4 = i2;
            while (i4 >= 0 && !this.name.toLowerCase().equals(this.elementStack[i4 + 3].toLowerCase())) {
                this.stackMismatch++;
                i4 -= 4;
            }
            if (i4 < 0) {
                this.stackMismatch = 0;
                this.type = 9;
                return;
            }
        }
        String[] strArr = this.elementStack;
        this.namespace = strArr[i2];
        this.prefix = strArr[i2 + 1];
        this.name = strArr[i2 + 2];
    }

    private final int parseLegacy(boolean z) throws XmlPullParserException, IOException {
        String string;
        String str;
        int i;
        int i2;
        Boolean bool;
        read();
        int i3 = read();
        if (i3 != 63) {
            if (i3 != 33) {
                string = new StringBuffer("illegal: <").append(i3).toString();
            } else if (peek(0) == 45) {
                str = "--";
                i = 45;
                i2 = 9;
            } else if (peek(0) == 91) {
                str = "[CDATA[";
                z = true;
                i = 93;
                i2 = 5;
            } else {
                str = "DOCTYPE";
                i = -1;
                i2 = 10;
            }
            error(string);
            return 9;
        }
        if ((peek(0) == 120 || peek(0) == 88) && (peek(1) == 109 || peek(1) == 77)) {
            if (z) {
                push(peek(0));
                push(peek(1));
            }
            read();
            read();
            if ((peek(0) == 108 || peek(0) == 76) && peek(1) <= 32) {
                if (this.line != 1 || this.column > 4) {
                    error("PI must not start with xml");
                }
                parseStartTag(true);
                int i4 = 2;
                if (this.attributeCount < 1 || !"version".equals(this.attributes[2])) {
                    error("version expected");
                }
                String[] strArr = this.attributes;
                this.version = strArr[3];
                if (1 >= this.attributeCount || !"encoding".equals(strArr[6])) {
                    i4 = 1;
                } else {
                    this.encoding = this.attributes[7];
                }
                if (i4 < this.attributeCount) {
                    int i5 = i4 * 4;
                    if ("standalone".equals(this.attributes[i5 + 2])) {
                        String str2 = this.attributes[i5 + 3];
                        if ("yes".equals(str2)) {
                            bool = new Boolean(true);
                        } else {
                            if ("no".equals(str2)) {
                                bool = new Boolean(false);
                            } else {
                                error(new StringBuffer("illegal standalone value: ").append(str2).toString());
                            }
                            i4++;
                        }
                        this.standalone = bool;
                        i4++;
                    }
                }
                if (i4 != this.attributeCount) {
                    error("illegal xmldecl");
                }
                this.isWhitespace = true;
                this.txtPos = 0;
                return XML_DECL;
            }
        }
        str = "";
        i = 63;
        i2 = 8;
        for (int i6 = 0; i6 < str.length(); i6++) {
            read(str.charAt(i6));
        }
        if (i2 != 10) {
            int i7 = 0;
            while (true) {
                int i8 = read();
                if (i8 == -1) {
                    string = UNEXPECTED_EOF;
                    break;
                }
                if (z) {
                    push(i8);
                }
                if ((i == 63 || i8 == i) && peek(0) == i && peek(1) == 62) {
                    if (i == 45 && i7 == 45) {
                        error("illegal comment delimiter: --->");
                    }
                    read();
                    read();
                    if (z && i != 63) {
                        this.txtPos--;
                    }
                } else {
                    i7 = i8;
                }
            }
            error(string);
            return 9;
        }
        parseDoctype(z);
        return i2;
    }

    private final void parseStartTag(boolean z) throws XmlPullParserException, IOException {
        if (!z) {
            read();
        }
        this.name = readName();
        this.attributeCount = 0;
        while (true) {
            skip();
            int iPeek = peek(0);
            if (!z) {
                if (iPeek != 47) {
                    if (iPeek == 62 && !z) {
                        read();
                        break;
                    }
                } else {
                    this.degenerated = true;
                    read();
                    skip();
                    read(Typography.greater);
                    break;
                }
            } else if (iPeek == 63) {
                read();
                read(Typography.greater);
                return;
            }
            if (iPeek == -1) {
                error(UNEXPECTED_EOF);
                return;
            }
            String name = readName();
            if (name.length() == 0) {
                error("attr name expected");
                break;
            }
            int i = this.attributeCount;
            this.attributeCount = i + 1;
            int i2 = i << 2;
            String[] strArrEnsureCapacity = ensureCapacity(this.attributes, i2 + 4);
            this.attributes = strArrEnsureCapacity;
            int i3 = i2 + 1;
            strArrEnsureCapacity[i2] = "";
            int i4 = i3 + 1;
            strArrEnsureCapacity[i3] = null;
            int i5 = i4 + 1;
            strArrEnsureCapacity[i4] = name;
            skip();
            if (peek(0) != 61) {
                error(new StringBuffer("Attr.value missing f. ").append(name).toString());
                this.attributes[i5] = "1";
            } else {
                read('=');
                skip();
                int iPeek2 = peek(0);
                if (iPeek2 == 39 || iPeek2 == 34) {
                    read();
                } else {
                    error("attr value delimiter missing!");
                    iPeek2 = 32;
                }
                int i6 = this.txtPos;
                pushText(iPeek2, true);
                this.attributes[i5] = get(i6);
                this.txtPos = i6;
                if (iPeek2 != 32) {
                    read();
                }
            }
        }
        int i7 = this.depth;
        this.depth = i7 + 1;
        int i8 = i7 << 2;
        String[] strArrEnsureCapacity2 = ensureCapacity(this.elementStack, i8 + 4);
        this.elementStack = strArrEnsureCapacity2;
        strArrEnsureCapacity2[i8 + 3] = this.name;
        int i9 = this.depth;
        int[] iArr = this.nspCounts;
        if (i9 >= iArr.length) {
            int[] iArr2 = new int[i9 + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.nspCounts = iArr2;
        }
        int[] iArr3 = this.nspCounts;
        int i10 = this.depth;
        iArr3[i10] = iArr3[i10 - 1];
        if (this.processNsp) {
            adjustNsp();
        } else {
            this.namespace = "";
        }
        String[] strArr = this.elementStack;
        strArr[i8] = this.namespace;
        strArr[i8 + 1] = this.prefix;
        strArr[i8 + 2] = this.name;
    }

    private final int peek(int i) throws IOException {
        int i2;
        while (i >= this.peekCount) {
            char[] cArr = this.srcBuf;
            if (cArr.length <= 1) {
                i2 = this.reader.read();
            } else {
                int i3 = this.srcPos;
                if (i3 < this.srcCount) {
                    this.srcPos = i3 + 1;
                    i2 = cArr[i3];
                } else {
                    int i4 = this.reader.read(cArr, 0, cArr.length);
                    this.srcCount = i4;
                    int i5 = i4 <= 0 ? -1 : this.srcBuf[0];
                    this.srcPos = 1;
                    i2 = i5;
                }
            }
            if (i2 == 13) {
                this.wasCR = true;
                int[] iArr = this.peek;
                int i6 = this.peekCount;
                this.peekCount = i6 + 1;
                iArr[i6] = 10;
            } else {
                if (i2 != 10) {
                    int[] iArr2 = this.peek;
                    int i7 = this.peekCount;
                    this.peekCount = i7 + 1;
                    iArr2[i7] = i2;
                } else if (!this.wasCR) {
                    int[] iArr3 = this.peek;
                    int i8 = this.peekCount;
                    this.peekCount = i8 + 1;
                    iArr3[i8] = 10;
                }
                this.wasCR = false;
            }
        }
        return this.peek[i];
    }

    private final int peekType() throws IOException {
        int iPeek = peek(0);
        if (iPeek == -1) {
            return 1;
        }
        if (iPeek == 38) {
            return 6;
        }
        if (iPeek != 60) {
            return 4;
        }
        int iPeek2 = peek(1);
        if (iPeek2 == 33) {
            return 999;
        }
        if (iPeek2 != 47) {
            return iPeek2 != 63 ? 2 : 999;
        }
        return 3;
    }

    private final void push(int i) {
        this.isWhitespace &= i <= 32;
        int i2 = this.txtPos;
        char[] cArr = this.txtBuf;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[((i2 * 4) / 3) + 4];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.txtBuf = cArr2;
        }
        char[] cArr3 = this.txtBuf;
        int i3 = this.txtPos;
        this.txtPos = i3 + 1;
        cArr3[i3] = (char) i;
    }

    private final void pushEntity() throws XmlPullParserException, IOException {
        push(read());
        int i = this.txtPos;
        while (true) {
            int i2 = read();
            if (i2 == 59) {
                String str = get(i);
                this.txtPos = i - 1;
                if (this.token && this.type == 6) {
                    this.name = str;
                }
                if (str.charAt(0) == '#') {
                    push(str.charAt(1) == 'x' ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str.substring(1)));
                    return;
                }
                String str2 = (String) this.entityMap.get(str);
                boolean z = str2 == null;
                this.unresolved = z;
                if (!z) {
                    for (int i3 = 0; i3 < str2.length(); i3++) {
                        push(str2.charAt(i3));
                    }
                    return;
                } else {
                    if (this.token) {
                        return;
                    }
                    error(new StringBuffer("unresolved: &").append(str).append(";").toString());
                    return;
                }
            }
            if (i2 < 128 && ((i2 < 48 || i2 > 57) && ((i2 < 97 || i2 > 122) && ((i2 < 65 || i2 > 90) && i2 != 95 && i2 != 45 && i2 != 35)))) {
                if (!this.relaxed) {
                    error("unterminated entity ref");
                }
                if (i2 != -1) {
                    push(i2);
                    return;
                }
                return;
            }
            push(i2);
        }
    }

    private final void pushText(int i, boolean z) throws XmlPullParserException, IOException {
        int iPeek = peek(0);
        int i2 = 0;
        while (iPeek != -1 && iPeek != i) {
            int i3 = 32;
            if (i == 32 && (iPeek <= 32 || iPeek == 62)) {
                return;
            }
            if (iPeek != 38) {
                if (iPeek == 10 && this.type == 2) {
                    read();
                } else {
                    i3 = read();
                }
                push(i3);
            } else if (!z) {
                return;
            } else {
                pushEntity();
            }
            if (iPeek == 62 && i2 >= 2 && i != 93) {
                error("Illegal: ]]>");
            }
            i2 = iPeek == 93 ? i2 + 1 : 0;
            iPeek = peek(0);
        }
    }

    private final int read() throws IOException {
        int iPeek;
        if (this.peekCount == 0) {
            iPeek = peek(0);
        } else {
            int[] iArr = this.peek;
            int i = iArr[0];
            iArr[0] = iArr[1];
            iPeek = i;
        }
        this.peekCount--;
        this.column++;
        if (iPeek == 10) {
            this.line++;
            this.column = 1;
        }
        return iPeek;
    }

    private final void read(char c) throws XmlPullParserException, IOException {
        int i = read();
        if (i != c) {
            error(new StringBuffer("expected: '").append(c).append("' actual: '").append((char) i).append("'").toString());
        }
    }

    private final String readName() throws XmlPullParserException, IOException {
        int i = this.txtPos;
        int iPeek = peek(0);
        if ((iPeek < 97 || iPeek > 122) && ((iPeek < 65 || iPeek > 90) && iPeek != 95 && iPeek != 58 && iPeek < 192 && !this.relaxed)) {
            error("name expected");
        }
        while (true) {
            push(read());
            int iPeek2 = peek(0);
            if (iPeek2 < 97 || iPeek2 > 122) {
                if (iPeek2 < 65 || iPeek2 > 90) {
                    if (iPeek2 < 48 || iPeek2 > 57) {
                        if (iPeek2 != 95 && iPeek2 != 45 && iPeek2 != 58 && iPeek2 != 46 && iPeek2 < 183) {
                            String str = get(i);
                            this.txtPos = i;
                            return str;
                        }
                    }
                }
            }
        }
    }

    private final void skip() throws IOException {
        while (true) {
            int iPeek = peek(0);
            if (iPeek > 32 || iPeek == -1) {
                return;
            } else {
                read();
            }
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        Hashtable hashtable = this.entityMap;
        if (hashtable == null) {
            throw new RuntimeException("entity replacement text must be defined after setInput!");
        }
        hashtable.put(str, str2);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getAttributeCount() {
        return this.attributeCount;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeName(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int i) {
        if (i < this.attributeCount) {
            return this.attributes[i << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        for (int i = (this.attributeCount << 2) - 4; i >= 0; i -= 4) {
            if (this.attributes[i + 2].equals(str2) && (str == null || this.attributes[i].equals(str))) {
                return this.attributes[i + 3];
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return this.column;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.depth;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() throws XmlPullParserException {
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.processNsp;
        }
        if (isProp(str, false, "relaxed")) {
            return this.relaxed;
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return this.encoding;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return this.line;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        return this.name;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.namespace;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        if ("xml".equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int namespaceCount = (getNamespaceCount(this.depth) << 1) - 2; namespaceCount >= 0; namespaceCount -= 2) {
            String[] strArr = this.nspStack;
            if (str == null) {
                if (strArr[namespaceCount] == null) {
                    return strArr[namespaceCount + 1];
                }
            } else if (str.equals(strArr[namespaceCount])) {
                return this.nspStack[namespaceCount + 1];
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i) {
        if (i <= this.depth) {
            return this.nspCounts[i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.nspStack[i << 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.nspStack[(i << 1) + 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPositionDescription() {
        String text;
        StringBuffer stringBuffer = new StringBuffer(this.type < XmlPullParser.TYPES.length ? XmlPullParser.TYPES[this.type] : EnvironmentCompat.MEDIA_UNKNOWN);
        stringBuffer.append(' ');
        int i = this.type;
        if (i == 2 || i == 3) {
            if (this.degenerated) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append(Typography.less);
            if (this.type == 3) {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
            }
            if (this.prefix != null) {
                stringBuffer.append(new StringBuffer("{").append(this.namespace).append("}").append(this.prefix).append(":").toString());
            }
            stringBuffer.append(this.name);
            int i2 = this.attributeCount << 2;
            for (int i3 = 0; i3 < i2; i3 += 4) {
                stringBuffer.append(' ');
                int i4 = i3 + 1;
                if (this.attributes[i4] != null) {
                    stringBuffer.append(new StringBuffer("{").append(this.attributes[i3]).append("}").append(this.attributes[i4]).append(":").toString());
                }
                stringBuffer.append(new StringBuffer().append(this.attributes[i3 + 2]).append("='").append(this.attributes[i3 + 3]).append("'").toString());
            }
            stringBuffer.append(Typography.greater);
        } else if (i != 7) {
            if (i != 4) {
                text = getText();
            } else if (this.isWhitespace) {
                text = "(whitespace)";
            } else {
                text = getText();
                if (text.length() > 16) {
                    text = new StringBuffer().append(text.substring(0, 16)).append("...").toString();
                }
            }
            stringBuffer.append(text);
        }
        stringBuffer.append(new StringBuffer("@").append(this.line).append(":").append(this.column).toString());
        if (this.location != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.location);
        } else if (this.reader != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.reader.toString());
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        if (isProp(str, true, "xmldecl-version")) {
            return this.version;
        }
        if (isProp(str, true, "xmldecl-standalone")) {
            return this.standalone;
        }
        if (!isProp(str, true, "location")) {
            return null;
        }
        Object obj = this.location;
        return obj != null ? obj : this.reader.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        int i = this.type;
        if (i < 4 || (i == 6 && this.unresolved)) {
            return null;
        }
        return get(0);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        int i = this.type;
        if (i < 4) {
            iArr[0] = -1;
            iArr[1] = -1;
            return null;
        }
        if (i == 6) {
            iArr[0] = 0;
            iArr[1] = this.name.length();
            return this.name.toCharArray();
        }
        iArr[0] = 0;
        iArr[1] = this.txtPos;
        return this.txtBuf;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() throws XmlPullParserException {
        if (this.type != 2) {
            exception(ILLEGAL_TYPE);
        }
        return this.degenerated;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() throws XmlPullParserException {
        int i = this.type;
        if (i != 4 && i != 7 && i != 5) {
            exception(ILLEGAL_TYPE);
        }
        return this.isWhitespace;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int next() throws XmlPullParserException, IOException {
        this.txtPos = 0;
        this.isWhitespace = true;
        this.token = false;
        int i = 9999;
        while (true) {
            nextImpl();
            int i2 = this.type;
            if (i2 < i) {
                i = i2;
            }
            if (i <= 6 && (i < 4 || peekType() < 4)) {
                break;
            }
        }
        this.type = i;
        if (i > 4) {
            this.type = 4;
        }
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() throws XmlPullParserException, IOException {
        next();
        if (this.type == 4 && this.isWhitespace) {
            next();
        }
        int i = this.type;
        if (i != 3 && i != 2) {
            exception("unexpected type");
        }
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() throws XmlPullParserException, IOException {
        String text;
        if (this.type != 2) {
            exception("precondition: START_TAG");
        }
        next();
        if (this.type == 4) {
            text = getText();
            next();
        } else {
            text = "";
        }
        if (this.type != 3) {
            exception("END_TAG expected");
        }
        return text;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() throws XmlPullParserException, IOException {
        this.isWhitespace = true;
        this.txtPos = 0;
        this.token = true;
        nextImpl();
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i, String str, String str2) throws XmlPullParserException, IOException {
        if (i == this.type && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        exception(new StringBuffer("expected: ").append(XmlPullParser.TYPES[i]).append(" {").append(str).append("}").append(str2).toString());
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.processNsp = z;
        } else if (isProp(str, false, "relaxed")) {
            this.relaxed = z;
        } else {
            exception(new StringBuffer("unsupported feature: ").append(str).toString());
        }
    }

    /* JADX WARN: Found duplicated region for block: B:43:0x00b8 A[Catch: Exception -> 0x0101, TryCatch #0 {Exception -> 0x0101, blocks: (B:7:0x000c, B:9:0x0012, B:12:0x0019, B:13:0x0028, B:18:0x003f, B:21:0x0047, B:23:0x0056, B:25:0x0063, B:27:0x006b, B:29:0x0073, B:30:0x0076, B:41:0x00b0, B:43:0x00b8, B:55:0x00f2, B:46:0x00cb, B:47:0x00da, B:49:0x00e1, B:31:0x0085, B:32:0x008f, B:33:0x0096, B:35:0x00a0, B:37:0x00a4, B:38:0x00ab), top: B:62:0x000c }] */
    /* JADX WARN: Found duplicated region for block: B:44:0x00c7  */
    /* JADX WARN: Found duplicated region for block: B:46:0x00cb A[Catch: Exception -> 0x0101, TryCatch #0 {Exception -> 0x0101, blocks: (B:7:0x000c, B:9:0x0012, B:12:0x0019, B:13:0x0028, B:18:0x003f, B:21:0x0047, B:23:0x0056, B:25:0x0063, B:27:0x006b, B:29:0x0073, B:30:0x0076, B:41:0x00b0, B:43:0x00b8, B:55:0x00f2, B:46:0x00cb, B:47:0x00da, B:49:0x00e1, B:31:0x0085, B:32:0x008f, B:33:0x0096, B:35:0x00a0, B:37:0x00a4, B:38:0x00ab), top: B:62:0x000c }] */
    /* JADX WARN: Found duplicated region for block: B:47:0x00da A[Catch: Exception -> 0x0101, TryCatch #0 {Exception -> 0x0101, blocks: (B:7:0x000c, B:9:0x0012, B:12:0x0019, B:13:0x0028, B:18:0x003f, B:21:0x0047, B:23:0x0056, B:25:0x0063, B:27:0x006b, B:29:0x0073, B:30:0x0076, B:41:0x00b0, B:43:0x00b8, B:55:0x00f2, B:46:0x00cb, B:47:0x00da, B:49:0x00e1, B:31:0x0085, B:32:0x008f, B:33:0x0096, B:35:0x00a0, B:37:0x00a4, B:38:0x00ab), top: B:62:0x000c }] */
    /* JADX WARN: Found duplicated region for block: B:49:0x00e1 A[Catch: Exception -> 0x0101, TryCatch #0 {Exception -> 0x0101, blocks: (B:7:0x000c, B:9:0x0012, B:12:0x0019, B:13:0x0028, B:18:0x003f, B:21:0x0047, B:23:0x0056, B:25:0x0063, B:27:0x006b, B:29:0x0073, B:30:0x0076, B:41:0x00b0, B:43:0x00b8, B:55:0x00f2, B:46:0x00cb, B:47:0x00da, B:49:0x00e1, B:31:0x0085, B:32:0x008f, B:33:0x0096, B:35:0x00a0, B:37:0x00a4, B:38:0x00ab), top: B:62:0x000c }] */
    /* JADX WARN: Found duplicated region for block: B:50:0x00eb  */
    /* JADX WARN: Found duplicated region for block: B:51:0x00ed  */
    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        String str2;
        String strSubstring;
        int i;
        int i2;
        this.srcPos = 0;
        this.srcCount = 0;
        if (inputStream == null) {
            throw new IllegalArgumentException();
        }
        String str3 = "UTF-8";
        if (str == null) {
            int i3 = 0;
            while (this.srcCount < 4 && (i2 = inputStream.read()) != -1) {
                try {
                    i3 = (i3 << 8) | i2;
                    char[] cArr = this.srcBuf;
                    int i4 = this.srcCount;
                    this.srcCount = i4 + 1;
                    cArr[i4] = (char) i2;
                } catch (Exception e) {
                    throw new XmlPullParserException(new StringBuffer("Invalid stream or encoding: ").append(e.toString()).toString(), this, e);
                }
            }
            if (this.srcCount == 4) {
                str2 = "UTF-16LE";
                switch (i3) {
                    case -131072:
                        this.srcCount = 0;
                        str2 = "UTF-32LE";
                        break;
                    case 60:
                        this.srcBuf[0] = Typography.less;
                        this.srcCount = 1;
                        str2 = "UTF-32BE";
                        break;
                    case 65279:
                        this.srcCount = 0;
                        str2 = "UTF-32BE";
                        break;
                    case 3932223:
                        char[] cArr2 = this.srcBuf;
                        cArr2[0] = Typography.less;
                        cArr2[1] = '?';
                        this.srcCount = 2;
                        str2 = "UTF-16BE";
                        break;
                    case 1006632960:
                        this.srcBuf[0] = Typography.less;
                        this.srcCount = 1;
                        str2 = "UTF-32LE";
                        break;
                    case 1006649088:
                        char[] cArr3 = this.srcBuf;
                        cArr3[0] = Typography.less;
                        cArr3[1] = '?';
                        this.srcCount = 2;
                        break;
                    case 1010792557:
                        while (true) {
                            int i5 = inputStream.read();
                            if (i5 != -1) {
                                char[] cArr4 = this.srcBuf;
                                int i6 = this.srcCount;
                                int i7 = i6 + 1;
                                this.srcCount = i7;
                                cArr4[i6] = (char) i5;
                                if (i5 == 62) {
                                    String str4 = new String(cArr4, 0, i7);
                                    int iIndexOf = str4.indexOf("encoding");
                                    if (iIndexOf != -1) {
                                        while (str4.charAt(iIndexOf) != '\"' && str4.charAt(iIndexOf) != '\'') {
                                            iIndexOf++;
                                        }
                                        int i8 = iIndexOf + 1;
                                        strSubstring = str4.substring(i8, str4.indexOf(str4.charAt(iIndexOf), i8));
                                    }
                                }
                            }
                            strSubstring = str;
                        }
                        i = (-65536) & i3;
                        if (i == -16842752) {
                            char[] cArr5 = this.srcBuf;
                            cArr5[0] = (char) ((cArr5[2] << '\b') | cArr5[3]);
                            this.srcCount = 1;
                            str2 = "UTF-16BE";
                        } else if (i == -131072) {
                            char[] cArr6 = this.srcBuf;
                            cArr6[0] = (char) ((cArr6[3] << '\b') | cArr6[2]);
                            this.srcCount = 1;
                        } else if ((i3 & (-256)) == -272908544) {
                            str2 = strSubstring;
                        } else {
                            char[] cArr7 = this.srcBuf;
                            cArr7[0] = cArr7[3];
                            this.srcCount = 1;
                            str2 = "UTF-8";
                        }
                        break;
                    default:
                        strSubstring = str;
                        i = (-65536) & i3;
                        if (i == -16842752) {
                            char[] cArr52 = this.srcBuf;
                            cArr52[0] = (char) ((cArr52[2] << '\b') | cArr52[3]);
                            this.srcCount = 1;
                            str2 = "UTF-16BE";
                        } else if (i == -131072) {
                            char[] cArr62 = this.srcBuf;
                            cArr62[0] = (char) ((cArr62[3] << '\b') | cArr62[2]);
                            this.srcCount = 1;
                        } else if ((i3 & (-256)) == -272908544) {
                            str2 = strSubstring;
                        } else {
                            char[] cArr72 = this.srcBuf;
                            cArr72[0] = cArr72[3];
                            this.srcCount = 1;
                            str2 = "UTF-8";
                        }
                        break;
                }
            } else {
                str2 = str;
            }
        } else {
            str2 = str;
        }
        if (str2 != null) {
            str3 = str2;
        }
        int i9 = this.srcCount;
        setInput(new InputStreamReader(inputStream, str3));
        this.encoding = str;
        this.srcCount = i9;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) throws XmlPullParserException {
        this.reader = reader;
        this.line = 1;
        this.column = 0;
        this.type = 0;
        this.name = null;
        this.namespace = null;
        this.degenerated = false;
        this.attributeCount = -1;
        this.encoding = null;
        this.version = null;
        this.standalone = null;
        if (reader == null) {
            return;
        }
        this.srcPos = 0;
        this.srcCount = 0;
        this.peekCount = 0;
        this.depth = 0;
        Hashtable hashtable = new Hashtable();
        this.entityMap = hashtable;
        hashtable.put("amp", "&");
        this.entityMap.put("apos", "'");
        this.entityMap.put("gt", ">");
        this.entityMap.put("lt", "<");
        this.entityMap.put("quot", "\"");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) throws XmlPullParserException {
        if (!isProp(str, true, "location")) {
            throw new XmlPullParserException(new StringBuffer("unsupported property: ").append(str).toString());
        }
        this.location = obj;
    }

    public void skipSubTree() throws XmlPullParserException, IOException {
        require(2, null, null);
        int i = 1;
        while (i > 0) {
            int next = next();
            if (next == 3) {
                i--;
            } else if (next == 2) {
                i++;
            }
        }
    }
}
