package org.xbill.DNS;

import j$.time.Duration;
import j$.util.Optional;
import j$.util.OptionalInt;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class TcpKeepaliveOption extends EDNSOption {
    private static final Duration UPPER_LIMIT = Duration.ofMillis(6553600);
    private OptionalInt timeout;

    public TcpKeepaliveOption() {
        super(11);
        this.timeout = OptionalInt.empty();
    }

    public TcpKeepaliveOption(int i) {
        super(11);
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("timeout must be betwee 0 and 65535");
        }
        this.timeout = OptionalInt.of(i);
    }

    public TcpKeepaliveOption(Duration duration) {
        super(11);
        if (duration.isNegative() || duration.compareTo(UPPER_LIMIT) >= 0) {
            throw new IllegalArgumentException("timeout must be between 0 and 6553.6 seconds (exclusively)");
        }
        this.timeout = OptionalInt.of(((int) duration.toMillis()) / 100);
    }

    public OptionalInt getTimeout() {
        return this.timeout;
    }

    public Optional<Duration> getTimeoutDuration() {
        if (this.timeout.isPresent()) {
            return Optional.of(Duration.ofMillis(this.timeout.getAsInt() * 100));
        }
        return Optional.empty();
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) throws IOException {
        int iRemaining = dNSInput.remaining();
        if (iRemaining == 0) {
            this.timeout = OptionalInt.empty();
        } else {
            if (iRemaining == 2) {
                this.timeout = OptionalInt.of(dNSInput.readU16());
                return;
            }
            throw new WireParseException("invalid length (" + iRemaining + ") of the data in the edns_tcp_keepalive option");
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(DNSOutput dNSOutput) {
        if (this.timeout.isPresent()) {
            dNSOutput.writeU16(this.timeout.getAsInt());
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        return this.timeout.isPresent() ? String.valueOf(this.timeout.getAsInt()) : "-";
    }
}
