package org.xbill.DNS;

import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SetResponse {
    static final int CNAME = 4;
    static final int DELEGATION = 3;
    static final int DNAME = 5;
    static final int NXDOMAIN = 1;
    static final int NXRRSET = 2;
    static final int SUCCESSFUL = 6;
    static final int UNKNOWN = 0;
    private List<RRset> data;
    private int type;
    private static final SetResponse unknown = new SetResponse(0);
    private static final SetResponse nxdomain = new SetResponse(1);
    private static final SetResponse nxrrset = new SetResponse(2);

    private SetResponse() {
    }

    SetResponse(int i, RRset rRset) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.type = i;
        ArrayList arrayList = new ArrayList();
        this.data = arrayList;
        arrayList.add(rRset);
    }

    SetResponse(int i) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.type = i;
        this.data = null;
    }

    static SetResponse ofType(int i) {
        switch (i) {
            case 0:
                return unknown;
            case 1:
                return nxdomain;
            case 2:
                return nxrrset;
            case 3:
            case 4:
            case 5:
            case 6:
                SetResponse setResponse = new SetResponse();
                setResponse.type = i;
                setResponse.data = null;
                return setResponse;
            default:
                throw new IllegalArgumentException("invalid type");
        }
    }

    void addRRset(RRset rRset) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        this.data.add(rRset);
    }

    public boolean isUnknown() {
        return this.type == 0;
    }

    public boolean isNXDOMAIN() {
        return this.type == 1;
    }

    public boolean isNXRRSET() {
        return this.type == 2;
    }

    public boolean isDelegation() {
        return this.type == 3;
    }

    public boolean isCNAME() {
        return this.type == 4;
    }

    public boolean isDNAME() {
        return this.type == 5;
    }

    public boolean isSuccessful() {
        return this.type == 6;
    }

    public List<RRset> answers() {
        if (this.type != 6) {
            return null;
        }
        return this.data;
    }

    public CNAMERecord getCNAME() {
        return (CNAMERecord) this.data.get(0).first();
    }

    public DNAMERecord getDNAME() {
        return (DNAMERecord) this.data.get(0).first();
    }

    public RRset getNS() {
        List<RRset> list = this.data;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return EnvironmentCompat.MEDIA_UNKNOWN;
            case 1:
                return "NXDOMAIN";
            case 2:
                return "NXRRSET";
            case 3:
                return "delegation: " + this.data.get(0);
            case 4:
                return "CNAME: " + this.data.get(0);
            case 5:
                return "DNAME: " + this.data.get(0);
            case 6:
                return "successful";
            default:
                throw new IllegalStateException();
        }
    }
}
