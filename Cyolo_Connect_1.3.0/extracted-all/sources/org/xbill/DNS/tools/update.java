package org.xbill.DNS.tools;

import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import j$.time.Instant;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.SocketException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xbill.DNS.DClass;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Rcode;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SOARecord;
import org.xbill.DNS.Section;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.TTL;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.Type;

/* JADX INFO: loaded from: classes2.dex */
public class update {
    int defaultClass;
    long defaultTTL;
    PrintStream log = null;
    Message query;
    Resolver res;
    Message response;
    String server;
    Name zone;

    void print(Object obj) {
        System.out.println(obj);
        PrintStream printStream = this.log;
        if (printStream != null) {
            printStream.println(obj);
        }
    }

    public Message newMessage() {
        Message message = new Message();
        message.getHeader().setOpcode(5);
        return message;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Found duplicated region for block: B:115:0x01ea  */
    public update(InputStream inputStream) {
        byte b;
        this.server = null;
        this.zone = Name.root;
        this.defaultClass = 1;
        List<BufferedReader> linkedList = new LinkedList<>();
        List<InputStream> linkedList2 = new LinkedList<>();
        this.query = newMessage();
        linkedList.add(new BufferedReader(new InputStreamReader(inputStream)));
        linkedList2.add(inputStream);
        while (true) {
            try {
                InputStream inputStream2 = linkedList2.get(0);
                BufferedReader bufferedReader = linkedList.get(0);
                if (inputStream2 == System.in) {
                    System.out.print("> ");
                }
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    linkedList.remove(0);
                    linkedList2.remove(0);
                    if (linkedList.isEmpty()) {
                        return;
                    }
                }
                if (line != null) {
                    PrintStream printStream = this.log;
                    if (printStream != null) {
                        printStream.println("> " + line);
                    }
                    if (line.length() != 0 && line.charAt(0) != '#') {
                        line = line.charAt(0) == '>' ? line.substring(1) : line;
                        Tokenizer tokenizer = new Tokenizer(line);
                        Tokenizer.Token token = tokenizer.get();
                        if (!token.isEOL()) {
                            String str = token.value;
                            switch (str.hashCode()) {
                                case -1408208058:
                                    b = !str.equals("assert") ? (byte) -1 : Ascii.EM;
                                    break;
                                case -1335458389:
                                    if (str.equals("delete")) {
                                        b = Ascii.FF;
                                    }
                                    break;
                                case -1008619738:
                                    if (str.equals(HttpHeaders.ReferrerPolicyValues.ORIGIN)) {
                                        b = 7;
                                    }
                                    break;
                                case -1000426017:
                                    if (str.equals("prohibit")) {
                                        b = 10;
                                    }
                                    break;
                                case -905826493:
                                    if (str.equals("server")) {
                                        b = 0;
                                    }
                                    break;
                                case 63:
                                    if (str.equals("?")) {
                                        b = Ascii.SI;
                                    }
                                    break;
                                case 113:
                                    if (str.equals("q")) {
                                        b = Ascii.SYN;
                                    }
                                    break;
                                case 96417:
                                    if (str.equals("add")) {
                                        b = 11;
                                    }
                                    break;
                                case 106079:
                                    if (str.equals("key")) {
                                        b = 1;
                                    }
                                    break;
                                case 107332:
                                    if (str.equals("log")) {
                                        b = Ascii.CAN;
                                    }
                                    break;
                                case 114657:
                                    if (str.equals("tcp")) {
                                        b = 4;
                                    }
                                    break;
                                case 115180:
                                    if (str.equals("ttl")) {
                                        b = 6;
                                    }
                                    break;
                                case 3076014:
                                    if (str.equals("date")) {
                                        b = Ascii.ESC;
                                    }
                                    break;
                                case 3107365:
                                    if (str.equals("echo")) {
                                        b = Ascii.DLE;
                                    }
                                    break;
                                case 3108516:
                                    if (str.equals("edns")) {
                                        b = 2;
                                    }
                                    break;
                                case 3143036:
                                    if (str.equals("file")) {
                                        b = Ascii.ETB;
                                    }
                                    break;
                                case 3175989:
                                    if (str.equals("glue")) {
                                        b = Ascii.CR;
                                    }
                                    break;
                                case 3198785:
                                    if (str.equals("help")) {
                                        b = Ascii.SO;
                                    }
                                    break;
                                case 3446913:
                                    if (str.equals("port")) {
                                        b = 3;
                                    }
                                    break;
                                case 3482191:
                                    if (str.equals("quit")) {
                                        b = Ascii.NAK;
                                    }
                                    break;
                                case 3526536:
                                    if (str.equals("send")) {
                                        b = 17;
                                    }
                                    break;
                                case 3529469:
                                    if (str.equals("show")) {
                                        b = Ascii.DC2;
                                    }
                                    break;
                                case 3744684:
                                    if (str.equals("zone")) {
                                        b = 8;
                                    }
                                    break;
                                case 94742904:
                                    if (str.equals(InstrumentationResultPrinter.REPORT_KEY_NAME_CLASS)) {
                                        b = 5;
                                    }
                                    break;
                                case 94746189:
                                    if (str.equals("clear")) {
                                        b = 19;
                                    }
                                    break;
                                case 107944136:
                                    if (str.equals("query")) {
                                        b = Ascii.DC4;
                                    }
                                    break;
                                case 109522647:
                                    if (str.equals("sleep")) {
                                        b = Ascii.SUB;
                                    }
                                    break;
                                case 1095696741:
                                    if (str.equals("require")) {
                                        b = 9;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            switch (b) {
                                case 0:
                                    this.server = tokenizer.getString();
                                    this.res = new SimpleResolver(this.server);
                                    Tokenizer.Token token2 = tokenizer.get();
                                    if (token2.isString()) {
                                        this.res.setPort(Short.parseShort(token2.value));
                                    }
                                    break;
                                case 1:
                                    String string = tokenizer.getString();
                                    String string2 = tokenizer.getString();
                                    if (this.res == null) {
                                        this.res = new SimpleResolver(this.server);
                                    }
                                    this.res.setTSIGKey(new TSIG(TSIG.HMAC_MD5, string, string2));
                                    break;
                                case 2:
                                    if (this.res == null) {
                                        this.res = new SimpleResolver(this.server);
                                    }
                                    this.res.setEDNS(tokenizer.getUInt16());
                                    break;
                                case 3:
                                    if (this.res == null) {
                                        this.res = new SimpleResolver(this.server);
                                    }
                                    this.res.setPort(tokenizer.getUInt16());
                                    break;
                                case 4:
                                    if (this.res == null) {
                                        this.res = new SimpleResolver(this.server);
                                    }
                                    this.res.setTCP(true);
                                    break;
                                case 5:
                                    String string3 = tokenizer.getString();
                                    int iValue = DClass.value(string3);
                                    if (iValue > 0) {
                                        this.defaultClass = iValue;
                                    } else {
                                        print("Invalid class " + string3);
                                    }
                                    break;
                                case 6:
                                    this.defaultTTL = tokenizer.getTTL();
                                    break;
                                case 7:
                                case 8:
                                    this.zone = tokenizer.getName(Name.root);
                                    break;
                                case 9:
                                    doRequire(tokenizer);
                                    break;
                                case 10:
                                    doProhibit(tokenizer);
                                    break;
                                case 11:
                                    doAdd(tokenizer);
                                    break;
                                case 12:
                                    doDelete(tokenizer);
                                    break;
                                case 13:
                                    doGlue(tokenizer);
                                    break;
                                case 14:
                                case 15:
                                    Tokenizer.Token token3 = tokenizer.get();
                                    if (token3.isString()) {
                                        help(token3.value);
                                    } else {
                                        help(null);
                                    }
                                    break;
                                case 16:
                                    print(line.substring(4).trim());
                                    break;
                                case 17:
                                    sendUpdate();
                                    this.query = newMessage();
                                    break;
                                case 18:
                                    print(this.query);
                                    break;
                                case 19:
                                    this.query = newMessage();
                                    break;
                                case 20:
                                    doQuery(tokenizer);
                                    break;
                                case 21:
                                case 22:
                                    PrintStream printStream2 = this.log;
                                    if (printStream2 != null) {
                                        printStream2.close();
                                    }
                                    Iterator<BufferedReader> it = linkedList.iterator();
                                    while (it.hasNext()) {
                                        it.next().close();
                                    }
                                    System.exit(0);
                                    doFile(tokenizer, linkedList, linkedList2);
                                    break;
                                case 23:
                                    doFile(tokenizer, linkedList, linkedList2);
                                    break;
                                case 24:
                                    doLog(tokenizer);
                                    break;
                                case 25:
                                    if (!doAssert(tokenizer)) {
                                        return;
                                    }
                                    break;
                                case 26:
                                    try {
                                        Thread.sleep(tokenizer.getUInt32());
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                        throw new IOException(e);
                                    }
                                    break;
                                case 27:
                                    Instant instantNow = Instant.now();
                                    Tokenizer.Token token4 = tokenizer.get();
                                    if (token4.isString() && token4.value.equals("-ms")) {
                                        print(Long.toString(instantNow.toEpochMilli()));
                                    } else {
                                        print(instantNow);
                                    }
                                    break;
                                default:
                                    print("invalid keyword: " + str);
                                    break;
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (InterruptedIOException unused) {
                System.out.println("Operation timed out");
            } catch (SocketException unused2) {
                System.out.println("Socket error");
            } catch (TextParseException e2) {
                System.out.println(e2.getMessage());
            } catch (IOException e3) {
                System.out.println(e3);
            }
        }
    }

    void sendUpdate() throws IOException {
        if (this.query.getHeader().getCount(2) == 0) {
            print("Empty update message.  Ignoring.");
            return;
        }
        if (this.query.getHeader().getCount(0) == 0) {
            Name name = this.zone;
            int dClass = this.defaultClass;
            if (name == null) {
                for (Record record : this.query.getSection(2)) {
                    if (name == null) {
                        name = new Name(record.getName(), 1);
                    }
                    if (record.getDClass() != 254 && record.getDClass() != 255) {
                        dClass = record.getDClass();
                        break;
                    }
                }
            }
            this.query.addRecord(Record.newRecord(name, 6, dClass), 0);
        }
        if (this.res == null) {
            this.res = new SimpleResolver(this.server);
        }
        Message messageSend = this.res.send(this.query);
        this.response = messageSend;
        print(messageSend);
    }

    Record parseRR(Tokenizer tokenizer, int i, long j) throws IOException {
        long j2;
        Name name = tokenizer.getName(this.zone);
        String string = tokenizer.getString();
        try {
            long ttl = TTL.parseTTL(string);
            string = tokenizer.getString();
            j2 = ttl;
        } catch (NumberFormatException unused) {
            j2 = j;
        }
        if (DClass.value(string) >= 0) {
            i = DClass.value(string);
            string = tokenizer.getString();
        }
        int i2 = i;
        int iValue = Type.value(string);
        if (iValue < 0) {
            throw new IOException("Invalid type: " + string);
        }
        return Record.fromString(name, iValue, i2, j2, tokenizer, this.zone);
    }

    void doRequire(Tokenizer tokenizer) throws IOException {
        Record recordNewRecord;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            int iValue = Type.value(token.value);
            if (iValue < 0) {
                throw new IOException("Invalid type: " + token.value);
            }
            boolean zIsEOL = tokenizer.get().isEOL();
            tokenizer.unget();
            if (!zIsEOL) {
                recordNewRecord = Record.fromString(name, iValue, this.defaultClass, 0L, tokenizer, this.zone);
            } else {
                recordNewRecord = Record.newRecord(name, iValue, 255, 0L);
            }
        } else {
            recordNewRecord = Record.newRecord(name, 255, 255, 0L);
        }
        this.query.addRecord(recordNewRecord, 1);
        print(recordNewRecord);
    }

    void doProhibit(Tokenizer tokenizer) throws IOException {
        int iValue;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            iValue = Type.value(token.value);
            if (iValue < 0) {
                throw new IOException("Invalid type: " + token.value);
            }
        } else {
            iValue = 255;
        }
        Record recordNewRecord = Record.newRecord(name, iValue, 254, 0L);
        this.query.addRecord(recordNewRecord, 1);
        print(recordNewRecord);
    }

    void doAdd(Tokenizer tokenizer) throws IOException {
        Record rr = parseRR(tokenizer, this.defaultClass, this.defaultTTL);
        this.query.addRecord(rr, 2);
        print(rr);
    }

    void doDelete(Tokenizer tokenizer) throws IOException {
        Record recordNewRecord;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            String string = token.value;
            if (DClass.value(string) >= 0) {
                string = tokenizer.getString();
            }
            int iValue = Type.value(string);
            if (iValue < 0) {
                throw new IOException("Invalid type: " + string);
            }
            boolean zIsEOL = tokenizer.get().isEOL();
            tokenizer.unget();
            if (!zIsEOL) {
                recordNewRecord = Record.fromString(name, iValue, 254, 0L, tokenizer, this.zone);
            } else {
                recordNewRecord = Record.newRecord(name, iValue, 255, 0L);
            }
        } else {
            recordNewRecord = Record.newRecord(name, 255, 255, 0L);
        }
        this.query.addRecord(recordNewRecord, 2);
        print(recordNewRecord);
    }

    void doGlue(Tokenizer tokenizer) throws IOException {
        Record rr = parseRR(tokenizer, this.defaultClass, this.defaultTTL);
        this.query.addRecord(rr, 3);
        print(rr);
    }

    void doQuery(Tokenizer tokenizer) throws IOException {
        int iValue;
        int iValue2 = this.defaultClass;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            iValue = Type.value(token.value);
            if (iValue < 0) {
                throw new IOException("Invalid type");
            }
            Tokenizer.Token token2 = tokenizer.get();
            if (token2.isString() && (iValue2 = DClass.value(token2.value)) < 0) {
                throw new IOException("Invalid class");
            }
        } else {
            iValue = 1;
        }
        Message messageNewQuery = Message.newQuery(Record.newRecord(name, iValue, iValue2));
        if (this.res == null) {
            this.res = new SimpleResolver(this.server);
        }
        Message messageSend = this.res.send(messageNewQuery);
        this.response = messageSend;
        print(messageSend);
    }

    void doFile(Tokenizer tokenizer, List<BufferedReader> list, List<InputStream> list2) throws IOException {
        InputStream fileInputStream;
        String string = tokenizer.getString();
        try {
            if (string.equals("-")) {
                fileInputStream = System.in;
            } else {
                fileInputStream = new FileInputStream(string);
            }
            list2.add(0, fileInputStream);
            list.add(0, new BufferedReader(new InputStreamReader(fileInputStream)));
        } catch (FileNotFoundException unused) {
            print(string + " not found");
        }
    }

    void doLog(Tokenizer tokenizer) throws IOException {
        String string = tokenizer.getString();
        try {
            this.log = new PrintStream(new FileOutputStream(string));
        } catch (Exception unused) {
            print("Error opening " + string);
        }
    }

    boolean doAssert(Tokenizer tokenizer) throws IOException {
        String str;
        String string = tokenizer.getString();
        String string2 = tokenizer.getString();
        boolean z = true;
        if (this.response == null) {
            print("No response has been received");
            return true;
        }
        String string3 = null;
        if (string.equalsIgnoreCase("rcode")) {
            int rcode = this.response.getHeader().getRcode();
            if (rcode != Rcode.value(string2)) {
                string3 = Rcode.string(rcode);
                z = false;
            }
        } else if (string.equalsIgnoreCase("serial")) {
            List<Record> section = this.response.getSection(1);
            if (section.isEmpty() || !(section.get(0) instanceof SOARecord)) {
                print("Invalid response (no SOA)");
            } else {
                long serial = ((SOARecord) section.get(0)).getSerial();
                if (serial != Long.parseLong(string2)) {
                    string3 = Long.toString(serial);
                    z = false;
                }
            }
        } else if (string.equalsIgnoreCase("tsig")) {
            if (this.response.isSigned()) {
                str = this.response.isVerified() ? "ok" : "failed";
            } else {
                str = "unsigned";
            }
            string3 = str;
            if (!string3.equalsIgnoreCase(string2)) {
                z = false;
            }
        } else {
            int iValue = Section.value(string);
            if (iValue >= 0) {
                int count = this.response.getHeader().getCount(iValue);
                if (count != Integer.parseInt(string2)) {
                    string3 = Integer.toString(count);
                    z = false;
                }
            } else {
                print("Invalid assertion keyword: " + string);
            }
        }
        if (!z) {
            print("Expected " + string + " " + string2 + ", received " + string3);
            while (true) {
                Tokenizer.Token token = tokenizer.get();
                if (!token.isString()) {
                    break;
                }
                print(token.value);
            }
            tokenizer.unget();
        }
        return z;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static void help(String str) {
        System.out.println();
        if (str == null) {
            System.out.println("The following are supported commands:\nadd      assert   class    clear    date     delete\necho     edns     file     glue     help     key\nlog      port     prohibit query    quit     require\nsend     server   show     sleep    tcp      ttl\nzone     #\n");
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        byte b = -1;
        switch (lowerCase.hashCode()) {
            case -1408208058:
                if (lowerCase.equals("assert")) {
                    b = 0;
                }
                break;
            case -1335458389:
                if (lowerCase.equals("delete")) {
                    b = 1;
                }
                break;
            case -1008619738:
                if (lowerCase.equals(HttpHeaders.ReferrerPolicyValues.ORIGIN)) {
                    b = 2;
                }
                break;
            case -1000426017:
                if (lowerCase.equals("prohibit")) {
                    b = 3;
                }
                break;
            case -905826493:
                if (lowerCase.equals("server")) {
                    b = 4;
                }
                break;
            case 35:
                if (lowerCase.equals("#")) {
                    b = 5;
                }
                break;
            case 113:
                if (lowerCase.equals("q")) {
                    b = 6;
                }
                break;
            case 96417:
                if (lowerCase.equals("add")) {
                    b = 7;
                }
                break;
            case 106079:
                if (lowerCase.equals("key")) {
                    b = 8;
                }
                break;
            case 107332:
                if (lowerCase.equals("log")) {
                    b = 9;
                }
                break;
            case 114657:
                if (lowerCase.equals("tcp")) {
                    b = 10;
                }
                break;
            case 115180:
                if (lowerCase.equals("ttl")) {
                    b = 11;
                }
                break;
            case 3076014:
                if (lowerCase.equals("date")) {
                    b = Ascii.FF;
                }
                break;
            case 3107365:
                if (lowerCase.equals("echo")) {
                    b = Ascii.CR;
                }
                break;
            case 3108516:
                if (lowerCase.equals("edns")) {
                    b = Ascii.SO;
                }
                break;
            case 3143036:
                if (lowerCase.equals("file")) {
                    b = Ascii.SI;
                }
                break;
            case 3175989:
                if (lowerCase.equals("glue")) {
                    b = Ascii.DLE;
                }
                break;
            case 3198785:
                if (lowerCase.equals("help")) {
                    b = 17;
                }
                break;
            case 3446913:
                if (lowerCase.equals("port")) {
                    b = Ascii.DC2;
                }
                break;
            case 3482191:
                if (lowerCase.equals("quit")) {
                    b = 19;
                }
                break;
            case 3526536:
                if (lowerCase.equals("send")) {
                    b = Ascii.DC4;
                }
                break;
            case 3529469:
                if (lowerCase.equals("show")) {
                    b = Ascii.NAK;
                }
                break;
            case 3744684:
                if (lowerCase.equals("zone")) {
                    b = Ascii.SYN;
                }
                break;
            case 94742904:
                if (lowerCase.equals(InstrumentationResultPrinter.REPORT_KEY_NAME_CLASS)) {
                    b = Ascii.ETB;
                }
                break;
            case 94746189:
                if (lowerCase.equals("clear")) {
                    b = Ascii.CAN;
                }
                break;
            case 107944136:
                if (lowerCase.equals("query")) {
                    b = Ascii.EM;
                }
                break;
            case 109522647:
                if (lowerCase.equals("sleep")) {
                    b = Ascii.SUB;
                }
                break;
            case 1095696741:
                if (lowerCase.equals("require")) {
                    b = Ascii.ESC;
                }
                break;
        }
        switch (b) {
            case 0:
                System.out.println("assert <field> <value> [msg]\n\nasserts that the value of the field in the last\nresponse matches the value specified.  If not,\nthe message is printed (if present) and the\nprogram exits.  The field may be any of <rcode>,\n<serial>, <tsig>, <qu>, <an>, <au>, or <ad>.\n");
                break;
            case 1:
                System.out.println("delete <name> [ttl] [class] <type> <data> \ndelete <name> <type> \ndelete <name>\n\nspecify a record or set to be deleted, or that\nall records at a name should be deleted\n");
                break;
            case 2:
            case 22:
                System.out.println("zone <zone>\n\nzone to update (default: .\n");
                break;
            case 3:
                System.out.println("prohibit <name> <type> \nprohibit <name>\n\nrequire that a set or name is not present\n");
                break;
            case 4:
                System.out.println("server <name> [port]\n\nserver that receives send updates/queries\n");
                break;
            case 5:
                System.out.println("# <text>\n\na comment\n");
                break;
            case 6:
            case 19:
                System.out.println("quit\n\nquits the program\n");
                break;
            case 7:
                System.out.println("add <name> [ttl] [class] <type> <data>\n\nspecify a record to be added\n");
                break;
            case 8:
                System.out.println("key <name> <data>\n\nTSIG key used to sign messages\n");
                break;
            case 9:
                System.out.println("log <file>\n\nopens the specified file and uses it to log output\n");
                break;
            case 10:
                System.out.println("tcp\n\nTCP should be used to send all messages\n");
                break;
            case 11:
                System.out.println("ttl <ttl>\n\ndefault ttl of added records (default: 0)\n");
                break;
            case 12:
                System.out.println("date [-ms]\n\nprints the current date and time in human readable\nformat or as the number of milliseconds since the\nepoch");
                break;
            case 13:
                System.out.println("echo <text>\n\nprints the text\n");
                break;
            case 14:
                System.out.println("edns <level>\n\nEDNS level specified when sending messages\n");
                break;
            case 15:
                System.out.println("file <file>\n\nopens the specified file as the new input source\n(- represents stdin)\n");
                break;
            case 16:
                System.out.println("glue <name> [ttl] [class] <type> <data>\n\nspecify an additional record\n");
                break;
            case 17:
                System.out.println("help\nhelp [topic]\n\nprints a list of commands or help about a specific\ncommand\n");
                break;
            case 18:
                System.out.println("port <port>\n\nUDP/TCP port messages are sent to (default: 53)\n");
                break;
            case 20:
                System.out.println("send\n\nsends and resets the current update packet\n");
                break;
            case 21:
                System.out.println("show\n\nshows the current update packet\n");
                break;
            case 23:
                System.out.println("class <class>\n\nclass of the zone to be updated (default: IN)\n");
                break;
            case 24:
                System.out.println("clear\n\nclears the current update packet\n");
                break;
            case 25:
                System.out.println("query <name> [type [class]] \n\nissues a query\n");
                break;
            case 26:
                System.out.println("sleep <milliseconds>\n\npause for interval before next command\n");
                break;
            case 27:
                System.out.println("require <name> [ttl] [class] <type> <data> \nrequire <name> <type> \nrequire <name>\n\nrequire that a record, set, or name is present\n");
                break;
            default:
                System.out.println("Topic '" + lowerCase + "' unrecognized\n");
                break;
        }
    }

    public static void main(String[] strArr) {
        InputStream fileInputStream;
        if (strArr.length >= 1) {
            try {
                fileInputStream = new FileInputStream(strArr[0]);
            } catch (FileNotFoundException unused) {
                System.out.println(strArr[0] + " not found.");
                System.exit(1);
                fileInputStream = null;
            }
        } else {
            fileInputStream = System.in;
        }
        new update(fileInputStream);
    }
}
