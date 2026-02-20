package org.xbill.DNS;

import io.flutter.embedding.android.KeyboardMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.io.IOUtils;
import org.xbill.DNS.utils.base16;
import org.xbill.DNS.utils.base32;
import org.xbill.DNS.utils.base64;

/* JADX INFO: loaded from: classes2.dex */
public class Tokenizer implements AutoCloseable {
    public static final int COMMENT = 5;
    public static final int EOF = 0;
    public static final int EOL = 1;
    public static final int IDENTIFIER = 3;
    public static final int QUOTED_STRING = 4;
    public static final int WHITESPACE = 2;
    private static String delim = " \t\n;()\"";
    private static String quotes = "\"";
    private Token current;
    private String delimiters;
    private String filename;
    private PushbackInputStream is;
    private int line;
    private int multiline;
    private boolean quoting;
    private StringBuffer sb;
    private boolean ungottenToken;
    private boolean wantClose;

    public static class Token {
        public int type;
        public String value;

        private Token() {
            this.type = -1;
            this.value = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Token set(int i, StringBuffer stringBuffer) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }
            this.type = i;
            this.value = stringBuffer == null ? null : stringBuffer.toString();
            return this;
        }

        public String toString() {
            int i = this.type;
            if (i == 0) {
                return "<eof>";
            }
            if (i == 1) {
                return "<eol>";
            }
            if (i == 2) {
                return "<whitespace>";
            }
            if (i == 3) {
                return "<identifier: " + this.value + ">";
            }
            if (i == 4) {
                return "<quoted_string: " + this.value + ">";
            }
            if (i != 5) {
                return "<unknown>";
            }
            return "<comment: " + this.value + ">";
        }

        public boolean isString() {
            int i = this.type;
            return i == 3 || i == 4;
        }

        public boolean isEOL() {
            int i = this.type;
            return i == 1 || i == 0;
        }
    }

    public Tokenizer(InputStream inputStream) {
        this.is = new PushbackInputStream(inputStream instanceof BufferedInputStream ? inputStream : new BufferedInputStream(inputStream), 2);
        this.ungottenToken = false;
        this.multiline = 0;
        this.quoting = false;
        this.delimiters = delim;
        this.current = new Token();
        this.sb = new StringBuffer();
        this.filename = "<none>";
        this.line = 1;
    }

    public Tokenizer(String str) {
        this(new ByteArrayInputStream(str.getBytes()));
    }

    public Tokenizer(File file) throws FileNotFoundException {
        this(new FileInputStream(file));
        this.wantClose = true;
        this.filename = file.getName();
    }

    private int getChar() throws IOException {
        int i = this.is.read();
        if (i == 13) {
            int i2 = this.is.read();
            if (i2 != 10) {
                this.is.unread(i2);
            }
            i = 10;
        }
        if (i == 10) {
            this.line++;
        }
        return i;
    }

    private void ungetChar(int i) throws IOException {
        if (i == -1) {
            return;
        }
        this.is.unread(i);
        if (i == 10) {
            this.line--;
        }
    }

    private int skipWhitespace() throws IOException {
        int i;
        int i2 = 0;
        while (true) {
            i = getChar();
            if (i != 32 && i != 9 && (i != 10 || this.multiline <= 0)) {
                break;
            }
            i2++;
        }
        ungetChar(i);
        return i2;
    }

    private void checkUnbalancedParens() throws TextParseException {
        if (this.multiline > 0) {
            throw exception("unbalanced parentheses");
        }
    }

    public Token get(boolean z, boolean z2) throws IOException {
        int i;
        if (this.ungottenToken) {
            this.ungottenToken = false;
            if (this.current.type == 2) {
                if (z) {
                    return this.current;
                }
            } else {
                if (this.current.type != 5) {
                    if (this.current.type == 1) {
                        this.line++;
                    }
                    return this.current;
                }
                if (z2) {
                    return this.current;
                }
            }
        }
        if (skipWhitespace() > 0 && z) {
            return this.current.set(2, null);
        }
        this.sb.setLength(0);
        int i2 = 3;
        while (true) {
            int i3 = getChar();
            if (i3 != -1 && this.delimiters.indexOf(i3) == -1) {
                if (i3 == 92) {
                    i3 = getChar();
                    if (i3 == -1) {
                        throw exception("unterminated escape sequence");
                    }
                    this.sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                } else if (this.quoting && i3 == 10) {
                    throw exception("newline in quoted string");
                }
                this.sb.append((char) i3);
            } else {
                if (i3 == -1) {
                    if (this.quoting) {
                        throw exception("EOF in quoted string");
                    }
                    return this.sb.length() == 0 ? this.current.set(0, null) : this.current.set(i2, this.sb);
                }
                if (this.sb.length() != 0 || i2 == 4) {
                    ungetChar(i3);
                    if (this.sb.length() != 0 || i2 == 4) {
                        return this.current.set(i2, this.sb);
                    }
                    checkUnbalancedParens();
                    return this.current.set(0, null);
                }
                if (i3 == 40) {
                    this.multiline++;
                    skipWhitespace();
                } else if (i3 == 41) {
                    int i4 = this.multiline;
                    if (i4 <= 0) {
                        throw exception("invalid close parenthesis");
                    }
                    this.multiline = i4 - 1;
                    skipWhitespace();
                } else if (i3 == 34) {
                    if (!this.quoting) {
                        this.quoting = true;
                        this.delimiters = quotes;
                        i2 = 4;
                    } else {
                        this.quoting = false;
                        this.delimiters = delim;
                        skipWhitespace();
                    }
                } else {
                    if (i3 == 10) {
                        return this.current.set(1, null);
                    }
                    if (i3 != 59) {
                        throw new IllegalStateException();
                    }
                    while (true) {
                        i = getChar();
                        if (i == 10 || i == -1) {
                            break;
                        }
                        this.sb.append((char) i);
                    }
                    if (z2) {
                        ungetChar(i);
                        return this.current.set(5, this.sb);
                    }
                    if (i == -1 && i2 != 4) {
                        checkUnbalancedParens();
                        return this.current.set(0, null);
                    }
                    if (this.multiline <= 0) {
                        return this.current.set(1, null);
                    }
                    skipWhitespace();
                    this.sb.setLength(0);
                }
            }
        }
    }

    public Token get() throws IOException {
        return get(false, false);
    }

    public void unget() {
        if (this.ungottenToken) {
            throw new IllegalStateException("Cannot unget multiple tokens");
        }
        if (this.current.type == 1) {
            this.line--;
        }
        this.ungottenToken = true;
    }

    public String getString() throws IOException {
        Token token = get();
        if (!token.isString()) {
            throw exception("expected a string");
        }
        return token.value;
    }

    private String _getIdentifier(String str) throws IOException {
        Token token = get();
        if (token.type != 3) {
            throw exception("expected " + str);
        }
        return token.value;
    }

    public String getIdentifier() throws IOException {
        return _getIdentifier("an identifier");
    }

    public long getLong() throws IOException {
        String str_getIdentifier = _getIdentifier("an integer");
        if (!Character.isDigit(str_getIdentifier.charAt(0))) {
            throw exception("expected an integer");
        }
        try {
            return Long.parseLong(str_getIdentifier);
        } catch (NumberFormatException unused) {
            throw exception("expected an integer");
        }
    }

    public long getUInt32() throws IOException {
        long j = getLong();
        if (j < 0 || j > KeyboardMap.kValueMask) {
            throw exception("expected an 32 bit unsigned integer");
        }
        return j;
    }

    public int getUInt16() throws IOException {
        long j = getLong();
        if (j < 0 || j > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            throw exception("expected an 16 bit unsigned integer");
        }
        return (int) j;
    }

    public int getUInt8() throws IOException {
        long j = getLong();
        if (j < 0 || j > 255) {
            throw exception("expected an 8 bit unsigned integer");
        }
        return (int) j;
    }

    public long getTTL() throws IOException {
        try {
            return TTL.parseTTL(_getIdentifier("a TTL value"));
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL value");
        }
    }

    public long getTTLLike() throws IOException {
        try {
            return TTL.parse(_getIdentifier("a TTL-like value"), false);
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL-like value");
        }
    }

    public Name getName(Name name) throws IOException {
        try {
            Name nameFromString = Name.fromString(_getIdentifier("a name"), name);
            if (nameFromString.isAbsolute()) {
                return nameFromString;
            }
            throw new RelativeNameException(nameFromString);
        } catch (TextParseException e) {
            throw exception(e.getMessage());
        }
    }

    public byte[] getAddressBytes(int i) throws IOException {
        String str_getIdentifier = _getIdentifier("an address");
        byte[] byteArray = Address.toByteArray(str_getIdentifier, i);
        if (byteArray != null) {
            return byteArray;
        }
        throw exception("Invalid address: " + str_getIdentifier);
    }

    public InetAddress getAddress(int i) throws IOException {
        try {
            return Address.getByAddress(_getIdentifier("an address"), i);
        } catch (UnknownHostException e) {
            throw exception(e.getMessage());
        }
    }

    public void getEOL() throws IOException {
        Token token = get();
        if (token.type != 1 && token.type != 0) {
            throw exception("expected EOL or EOF");
        }
    }

    private String remainingStrings() throws IOException {
        StringBuffer stringBuffer = null;
        while (true) {
            Token token = get();
            if (!token.isString()) {
                break;
            }
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            stringBuffer.append(token.value);
        }
        unget();
        if (stringBuffer == null) {
            return null;
        }
        return stringBuffer.toString();
    }

    public byte[] getBase64(boolean z) throws IOException {
        String strRemainingStrings = remainingStrings();
        if (strRemainingStrings == null) {
            if (z) {
                throw exception("expected base64 encoded string");
            }
            return null;
        }
        byte[] bArrFromString = base64.fromString(strRemainingStrings);
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid base64 encoding");
    }

    public byte[] getBase64() throws IOException {
        return getBase64(false);
    }

    public byte[] getHex(boolean z) throws IOException {
        String strRemainingStrings = remainingStrings();
        if (strRemainingStrings == null) {
            if (z) {
                throw exception("expected hex encoded string");
            }
            return null;
        }
        byte[] bArrFromString = base16.fromString(strRemainingStrings);
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid hex encoding");
    }

    public byte[] getHex() throws IOException {
        return getHex(false);
    }

    public byte[] getHexString() throws IOException {
        byte[] bArrFromString = base16.fromString(_getIdentifier("a hex string"));
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid hex encoding");
    }

    public byte[] getBase32String(base32 base32Var) throws IOException {
        byte[] bArrFromString = base32Var.fromString(_getIdentifier("a base32 string"));
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid base32 encoding");
    }

    public TextParseException exception(String str) {
        return new TextParseException(this.filename + ":" + this.line + ": " + str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.wantClose) {
            try {
                this.is.close();
            } catch (IOException unused) {
            }
        }
    }
}
