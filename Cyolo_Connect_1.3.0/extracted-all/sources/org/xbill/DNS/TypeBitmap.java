package org.xbill.DNS;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;
import org.xbill.DNS.Tokenizer;

/* JADX INFO: loaded from: classes2.dex */
final class TypeBitmap implements Serializable {
    private static final long serialVersionUID = -125354057735389003L;
    private TreeSet<Integer> types;

    private TypeBitmap() {
        this.types = new TreeSet<>();
    }

    public TypeBitmap(int[] iArr) {
        this();
        for (int i : iArr) {
            Type.check(i);
            this.types.add(Integer.valueOf(i));
        }
    }

    public TypeBitmap(DNSInput dNSInput) throws WireParseException {
        this();
        while (dNSInput.remaining() > 0) {
            if (dNSInput.remaining() < 2) {
                throw new WireParseException("invalid bitmap descriptor");
            }
            int u8 = dNSInput.readU8();
            if (u8 < -1) {
                throw new WireParseException("invalid ordering");
            }
            int u82 = dNSInput.readU8();
            if (u82 > dNSInput.remaining()) {
                throw new WireParseException("invalid bitmap");
            }
            for (int i = 0; i < u82; i++) {
                int u83 = dNSInput.readU8();
                if (u83 != 0) {
                    for (int i2 = 0; i2 < 8; i2++) {
                        if (((1 << (7 - i2)) & u83) != 0) {
                            this.types.add(Integer.valueOf((u8 * 256) + (i * 8) + i2));
                        }
                    }
                }
            }
        }
    }

    public TypeBitmap(Tokenizer tokenizer) throws IOException {
        this();
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (token.isString()) {
                int iValue = Type.value(token.value);
                if (iValue < 0) {
                    throw tokenizer.exception("Invalid type: " + token.value);
                }
                this.types.add(Integer.valueOf(iValue));
            } else {
                tokenizer.unget();
                return;
            }
        }
    }

    public int[] toArray() {
        int[] iArr = new int[this.types.size()];
        Iterator<Integer> it = this.types.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.types.iterator();
        while (it.hasNext()) {
            sb.append(Type.string(it.next().intValue()));
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    private static void mapToWire(DNSOutput dNSOutput, TreeSet<Integer> treeSet, int i) {
        int iIntValue = ((treeSet.last().intValue() & 255) / 8) + 1;
        int[] iArr = new int[iIntValue];
        dNSOutput.writeU8(i);
        dNSOutput.writeU8(iIntValue);
        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            int i2 = (iIntValue2 & 255) / 8;
            iArr[i2] = (1 << (7 - (iIntValue2 % 8))) | iArr[i2];
        }
        for (int i3 = 0; i3 < iIntValue; i3++) {
            dNSOutput.writeU8(iArr[i3]);
        }
    }

    public void toWire(DNSOutput dNSOutput) {
        if (this.types.size() == 0) {
            return;
        }
        TreeSet treeSet = new TreeSet();
        Iterator<Integer> it = this.types.iterator();
        int i = -1;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            int i2 = iIntValue >> 8;
            if (i2 != i) {
                if (treeSet.size() > 0) {
                    mapToWire(dNSOutput, treeSet, i);
                    treeSet.clear();
                }
                i = i2;
            }
            treeSet.add(Integer.valueOf(iIntValue));
        }
        mapToWire(dNSOutput, treeSet, i);
    }

    public boolean empty() {
        return this.types.isEmpty();
    }

    public boolean contains(int i) {
        return this.types.contains(Integer.valueOf(i));
    }
}
