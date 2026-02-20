package org.xbill.DNS;

import io.flutter.embedding.android.KeyboardMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.Tokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class Master implements AutoCloseable {
    private int currentDClass;
    private long currentTTL;
    private int currentType;
    private long defaultTTL;
    private File file;
    private Generator generator;
    private List<Generator> generators;
    private boolean includeThrowsException;
    private Master included;
    private Record last;
    private boolean needSOATTL;
    private boolean noExpandGenerate;
    private boolean noExpandIncludes;
    private Name origin;
    private Tokenizer st;

    Master(File file, Name name, long j) throws IOException {
        this.last = null;
        this.included = null;
        if (name != null && !name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        this.file = file;
        this.st = new Tokenizer(file);
        this.origin = name;
        this.defaultTTL = j;
    }

    public Master(String str, Name name, long j) throws IOException {
        this(new File(str), name, j);
    }

    public Master(String str, Name name) throws IOException {
        this(new File(str), name, -1L);
    }

    public Master(String str) throws IOException {
        this(new File(str), (Name) null, -1L);
    }

    public Master(InputStream inputStream, Name name, long j) {
        this.last = null;
        this.included = null;
        if (name != null && !name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        this.st = new Tokenizer(inputStream);
        this.origin = name;
        this.defaultTTL = j;
    }

    public Master(InputStream inputStream, Name name) {
        this(inputStream, name, -1L);
    }

    public Master(InputStream inputStream) {
        this(inputStream, (Name) null, -1L);
    }

    private Name parseName(String str, Name name) throws TextParseException {
        try {
            return Name.fromString(str, name);
        } catch (TextParseException e) {
            throw this.st.exception(e.getMessage());
        }
    }

    private void parseTTLClassAndType() throws IOException {
        boolean z;
        String string = this.st.getString();
        int iValue = DClass.value(string);
        this.currentDClass = iValue;
        if (iValue >= 0) {
            string = this.st.getString();
            z = true;
        } else {
            z = false;
        }
        this.currentTTL = -1L;
        try {
            this.currentTTL = TTL.parseTTL(string);
            string = this.st.getString();
        } catch (NumberFormatException unused) {
            long j = this.defaultTTL;
            if (j >= 0) {
                this.currentTTL = j;
            } else {
                Record record = this.last;
                if (record != null) {
                    this.currentTTL = record.getTTL();
                }
            }
        }
        if (!z) {
            int iValue2 = DClass.value(string);
            this.currentDClass = iValue2;
            if (iValue2 >= 0) {
                string = this.st.getString();
            } else {
                this.currentDClass = 1;
            }
        }
        int iValue3 = Type.value(string);
        this.currentType = iValue3;
        if (iValue3 < 0) {
            throw this.st.exception("Invalid type '" + string + "'");
        }
        if (this.currentTTL < 0) {
            if (iValue3 != 6) {
                throw this.st.exception("missing TTL");
            }
            this.needSOATTL = true;
            this.currentTTL = 0L;
        }
    }

    private long parseUInt32(String str) {
        long j;
        if (!Character.isDigit(str.charAt(0))) {
            return -1L;
        }
        try {
            j = Long.parseLong(str);
        } catch (NumberFormatException unused) {
        }
        if (j < 0 || j > KeyboardMap.kValueMask) {
            return -1L;
        }
        return j;
    }

    private void startGenerate() throws IOException {
        String strSubstring;
        String identifier = this.st.getIdentifier();
        int iIndexOf = identifier.indexOf("-");
        if (iIndexOf < 0) {
            throw this.st.exception("Invalid $GENERATE range specifier: " + identifier);
        }
        String strSubstring2 = identifier.substring(0, iIndexOf);
        String strSubstring3 = identifier.substring(iIndexOf + 1);
        int iIndexOf2 = strSubstring3.indexOf("/");
        if (iIndexOf2 >= 0) {
            strSubstring = strSubstring3.substring(iIndexOf2 + 1);
            strSubstring3 = strSubstring3.substring(0, iIndexOf2);
        } else {
            strSubstring = null;
        }
        long uInt32 = parseUInt32(strSubstring2);
        long uInt322 = parseUInt32(strSubstring3);
        long uInt323 = strSubstring != null ? parseUInt32(strSubstring) : 1L;
        if (uInt32 < 0 || uInt322 < 0 || uInt32 > uInt322 || uInt323 <= 0) {
            throw this.st.exception("Invalid $GENERATE range specifier: " + identifier);
        }
        String identifier2 = this.st.getIdentifier();
        parseTTLClassAndType();
        if (!Generator.supportedType(this.currentType)) {
            throw this.st.exception("$GENERATE does not support " + Type.string(this.currentType) + " records");
        }
        String identifier3 = this.st.getIdentifier();
        this.st.getEOL();
        this.st.unget();
        this.generator = new Generator(uInt32, uInt322, uInt323, identifier2, this.currentType, this.currentDClass, this.currentTTL, identifier3, this.origin);
        if (this.generators == null) {
            this.generators = new ArrayList(1);
        }
        this.generators.add(this.generator);
    }

    private void endGenerate() throws IOException {
        this.st.getEOL();
        this.generator = null;
    }

    private Record nextGenerated() throws IOException {
        try {
            return this.generator.nextRecord();
        } catch (TextParseException e) {
            throw this.st.exception("Parsing $GENERATE: " + e.getMessage());
        }
    }

    private Record _nextRecord() throws IOException {
        Name name;
        Master master = this.included;
        if (master != null) {
            Record recordNextRecord = master.nextRecord();
            if (recordNextRecord != null) {
                return recordNextRecord;
            }
            this.included = null;
        }
        if (this.generator != null) {
            Record recordNextGenerated = nextGenerated();
            if (recordNextGenerated != null) {
                return recordNextGenerated;
            }
            endGenerate();
        }
        while (true) {
            Tokenizer.Token token = this.st.get(true, false);
            if (token.type == 2) {
                Tokenizer.Token token2 = this.st.get();
                if (token2.type != 1) {
                    if (token2.type == 0) {
                        return null;
                    }
                    this.st.unget();
                    Record record = this.last;
                    if (record == null) {
                        throw this.st.exception("no owner");
                    }
                    name = record.getName();
                    break;
                }
            } else if (token.type == 1) {
                continue;
            } else if (token.type != 0) {
                if (token.value.charAt(0) == '$') {
                    String str = token.value;
                    if (str.equalsIgnoreCase("$ORIGIN")) {
                        this.origin = this.st.getName(Name.root);
                        this.st.getEOL();
                    } else if (str.equalsIgnoreCase("$TTL")) {
                        this.defaultTTL = this.st.getTTL();
                        this.st.getEOL();
                    } else if (str.equalsIgnoreCase("$INCLUDE")) {
                        if (this.noExpandIncludes) {
                            if (this.includeThrowsException) {
                                throw this.st.exception("$INCLUDE encountered, but processing disabled in strict mode");
                            }
                            this.st.getString();
                            this.st.getEOL();
                        } else {
                            String string = this.st.getString();
                            File file = new File(string);
                            if (!file.isAbsolute()) {
                                if (this.file != null) {
                                    file = new File(this.file.getParent(), string);
                                } else {
                                    throw this.st.exception("Cannot $INCLUDE using relative path when parsing from stream");
                                }
                            }
                            Name name2 = this.origin;
                            Tokenizer.Token token3 = this.st.get();
                            if (token3.isString()) {
                                name2 = parseName(token3.value, Name.root);
                                this.st.getEOL();
                            }
                            this.included = new Master(file, name2, this.defaultTTL);
                            return nextRecord();
                        }
                    } else if (str.equalsIgnoreCase("$GENERATE")) {
                        if (this.generator != null) {
                            throw new IllegalStateException("cannot nest $GENERATE");
                        }
                        startGenerate();
                        if (this.noExpandGenerate) {
                            endGenerate();
                        } else {
                            return nextGenerated();
                        }
                    } else {
                        throw this.st.exception("Invalid directive: " + str);
                    }
                } else {
                    name = parseName(token.value, this.origin);
                    Record record2 = this.last;
                    if (record2 == null || !name.equals(record2.getName())) {
                        break;
                        break;
                    }
                    name = this.last.getName();
                    break;
                }
            } else {
                return null;
            }
        }
        parseTTLClassAndType();
        Record recordFromString = Record.fromString(name, this.currentType, this.currentDClass, this.currentTTL, this.st, this.origin);
        this.last = recordFromString;
        if (this.needSOATTL) {
            long minimum = ((SOARecord) recordFromString).getMinimum();
            this.last.setTTL(minimum);
            this.defaultTTL = minimum;
            this.needSOATTL = false;
        }
        return this.last;
    }

    public Record nextRecord() throws IOException {
        try {
            Record record_nextRecord = _nextRecord();
            if (record_nextRecord == null) {
                this.st.close();
            }
            return record_nextRecord;
        } catch (Throwable th) {
            this.st.close();
            throw th;
        }
    }

    public void disableIncludes() {
        disableIncludes(false);
    }

    public void disableIncludes(boolean z) {
        this.noExpandIncludes = true;
        this.includeThrowsException = z;
    }

    public void expandGenerate(boolean z) {
        this.noExpandGenerate = !z;
    }

    public Iterator<Generator> generators() {
        List<Generator> list = this.generators;
        if (list != null) {
            return Collections.unmodifiableList(list).iterator();
        }
        return Collections.emptyIterator();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Tokenizer tokenizer = this.st;
        if (tokenizer != null) {
            tokenizer.close();
        }
    }
}
