package org.xbill.DNS;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import org.xbill.DNS.utils.base64;

/* JADX INFO: loaded from: classes2.dex */
public class IPSECKEYRecord extends Record {
    private int algorithmType;
    private Object gateway;
    private int gatewayType;
    private byte[] key;
    private int precedence;

    public static class Algorithm {
        public static final int DSA = 1;
        public static final int ECDSA = 3;
        public static final int RSA = 2;

        private Algorithm() {
        }
    }

    public static class Gateway {
        public static final int IPv4 = 1;
        public static final int IPv6 = 2;
        public static final int Name = 3;
        public static final int None = 0;

        private Gateway() {
        }
    }

    IPSECKEYRecord() {
    }

    public IPSECKEYRecord(Name name, int i, long j, int i2, int i3, int i4, Object obj, byte[] bArr) {
        super(name, 45, i, j);
        this.precedence = checkU8("precedence", i2);
        this.gatewayType = checkU8("gatewayType", i3);
        this.algorithmType = checkU8("algorithmType", i4);
        if (i3 == 0) {
            this.gateway = null;
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (!(obj instanceof Name)) {
                        throw new IllegalArgumentException("\"gateway\" must be a DNS name");
                    }
                    this.gateway = checkName("gateway", (Name) obj);
                } else {
                    throw new IllegalArgumentException("\"gatewayType\" must be between 0 and 3");
                }
            } else {
                if (!(obj instanceof Inet6Address)) {
                    throw new IllegalArgumentException("\"gateway\" must be an IPv6 address");
                }
                this.gateway = obj;
            }
        } else {
            if (!(obj instanceof InetAddress)) {
                throw new IllegalArgumentException("\"gateway\" must be an IPv4 address");
            }
            this.gateway = obj;
        }
        this.key = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.precedence = dNSInput.readU8();
        this.gatewayType = dNSInput.readU8();
        this.algorithmType = dNSInput.readU8();
        int i = this.gatewayType;
        if (i == 0) {
            this.gateway = null;
        } else if (i == 1) {
            this.gateway = InetAddress.getByAddress(dNSInput.readByteArray(4));
        } else if (i == 2) {
            this.gateway = InetAddress.getByAddress(dNSInput.readByteArray(16));
        } else if (i == 3) {
            this.gateway = new Name(dNSInput);
        } else {
            throw new WireParseException("invalid gateway type");
        }
        if (dNSInput.remaining() > 0) {
            this.key = dNSInput.readByteArray();
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.precedence = tokenizer.getUInt8();
        this.gatewayType = tokenizer.getUInt8();
        this.algorithmType = tokenizer.getUInt8();
        int i = this.gatewayType;
        if (i != 0) {
            if (i == 1) {
                this.gateway = tokenizer.getAddress(1);
            } else if (i == 2) {
                this.gateway = tokenizer.getAddress(2);
            } else if (i == 3) {
                this.gateway = tokenizer.getName(name);
            } else {
                throw new WireParseException("invalid gateway type");
            }
        } else {
            if (!tokenizer.getString().equals(".")) {
                throw new TextParseException("invalid gateway format");
            }
            this.gateway = null;
        }
        this.key = tokenizer.getBase64(false);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.precedence);
        sb.append(" ");
        sb.append(this.gatewayType);
        sb.append(" ");
        sb.append(this.algorithmType);
        sb.append(" ");
        int i = this.gatewayType;
        if (i == 0) {
            sb.append(".");
        } else if (i == 1 || i == 2) {
            sb.append(((InetAddress) this.gateway).getHostAddress());
        } else if (i == 3) {
            sb.append(this.gateway);
        }
        if (this.key != null) {
            sb.append(" ");
            sb.append(base64.toString(this.key));
        }
        return sb.toString();
    }

    public int getPrecedence() {
        return this.precedence;
    }

    public int getGatewayType() {
        return this.gatewayType;
    }

    public int getAlgorithmType() {
        return this.algorithmType;
    }

    public Object getGateway() {
        return this.gateway;
    }

    public byte[] getKey() {
        return this.key;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.precedence);
        dNSOutput.writeU8(this.gatewayType);
        dNSOutput.writeU8(this.algorithmType);
        int i = this.gatewayType;
        if (i == 1 || i == 2) {
            dNSOutput.writeByteArray(((InetAddress) this.gateway).getAddress());
        } else if (i == 3) {
            ((Name) this.gateway).toWire(dNSOutput, null, z);
        }
        byte[] bArr = this.key;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }
}
