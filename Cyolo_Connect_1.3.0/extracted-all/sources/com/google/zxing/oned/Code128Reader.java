package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes3.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int i = nextSet;
        boolean z = false;
        int i2 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == 5) {
                    int i3 = -1;
                    float f = MAX_AVG_VARIANCE;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float fPatternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], MAX_INDIVIDUAL_VARIANCE);
                        if (fPatternMatchVariance < f) {
                            i3 = i4;
                            f = fPatternMatchVariance;
                        }
                    }
                    if (i3 >= 0 && bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                        return new int[]{i, nextSet, i3};
                    }
                    i += iArr[0] + iArr[1];
                    int i5 = i2 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i2] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i3 >= iArr2.length) {
                break;
            }
            float fPatternMatchVariance = patternMatchVariance(iArr, iArr2[i3], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f) {
                i2 = i3;
                f = fPatternMatchVariance;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Found duplicated region for block: B:100:0x016d  */
    /* JADX WARN: Found duplicated region for block: B:102:0x0171  */
    /* JADX WARN: Found duplicated region for block: B:104:0x0175  */
    /* JADX WARN: Found duplicated region for block: B:106:0x017e A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:107:0x0180  */
    /* JADX WARN: Found duplicated region for block: B:109:0x0184  */
    /* JADX WARN: Found duplicated region for block: B:111:0x0188  */
    /* JADX WARN: Found duplicated region for block: B:113:0x018e  */
    /* JADX WARN: Found duplicated region for block: B:114:0x0191  */
    /* JADX WARN: Found duplicated region for block: B:116:0x0198  */
    /* JADX WARN: Found duplicated region for block: B:118:0x019c  */
    /* JADX WARN: Found duplicated region for block: B:120:0x01a2  */
    /* JADX WARN: Found duplicated region for block: B:121:0x01a6  */
    /* JADX WARN: Found duplicated region for block: B:122:0x01ac  */
    /* JADX WARN: Found duplicated region for block: B:123:0x01b0  */
    /* JADX WARN: Found duplicated region for block: B:124:0x01b4  */
    /* JADX WARN: Found duplicated region for block: B:125:0x01b8 A[FALL_THROUGH, PHI: r3 r21 r22
      0x01b8: PHI (r3v17 boolean) = (r3v1 boolean), (r3v1 boolean), (r3v1 boolean), (r3v1 boolean), (r3v1 boolean), (r3v15 boolean), (r3v1 boolean) binds: [B:109:0x0184, B:117:0x019a, B:121:0x01a6, B:120:0x01a2, B:105:0x017a, B:69:0x0111, B:28:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x01b8: PHI (r21v18 boolean) = (r21v3 boolean), (r21v3 boolean), (r21v3 boolean), (r21v3 boolean), (r21v2 boolean), (r21v2 boolean), (r21v2 boolean) binds: [B:109:0x0184, B:117:0x019a, B:121:0x01a6, B:120:0x01a2, B:105:0x017a, B:69:0x0111, B:28:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x01b8: PHI (r22v15 int) = (r22v1 int), (r22v3 int), (r22v3 int), (r22v3 int), (r22v1 int), (r22v1 int), (r22v1 int) binds: [B:109:0x0184, B:117:0x019a, B:121:0x01a6, B:120:0x01a2, B:105:0x017a, B:69:0x0111, B:28:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:128:0x01bd A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:129:0x01bf  */
    /* JADX WARN: Found duplicated region for block: B:130:0x01c2  */
    /* JADX WARN: Found duplicated region for block: B:156:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:158:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Found duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Found duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Found duplicated region for block: B:24:0x007b A[LOOP:1: B:23:0x0079->B:24:0x007b, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:26:0x0085  */
    /* JADX WARN: Found duplicated region for block: B:28:0x008c  */
    /* JADX WARN: Found duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Found duplicated region for block: B:33:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Found duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Found duplicated region for block: B:36:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:37:0x00af A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Found duplicated region for block: B:39:0x00b8  */
    /* JADX WARN: Found duplicated region for block: B:40:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Found duplicated region for block: B:43:0x00c5  */
    /* JADX WARN: Found duplicated region for block: B:45:0x00c9  */
    /* JADX WARN: Found duplicated region for block: B:47:0x00cf  */
    /* JADX WARN: Found duplicated region for block: B:48:0x00d2  */
    /* JADX WARN: Found duplicated region for block: B:50:0x00d9  */
    /* JADX WARN: Found duplicated region for block: B:52:0x00dd  */
    /* JADX WARN: Found duplicated region for block: B:54:0x00e3  */
    /* JADX WARN: Found duplicated region for block: B:55:0x00e7  */
    /* JADX WARN: Found duplicated region for block: B:56:0x00ed  */
    /* JADX WARN: Found duplicated region for block: B:56:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:57:0x00ef A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:60:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:62:0x00f7  */
    /* JADX WARN: Found duplicated region for block: B:63:0x00f9  */
    /* JADX WARN: Found duplicated region for block: B:65:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:66:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:67:0x0102  */
    /* JADX WARN: Found duplicated region for block: B:68:0x0109  */
    /* JADX WARN: Found duplicated region for block: B:70:0x0116 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:71:0x0118  */
    /* JADX WARN: Found duplicated region for block: B:73:0x011c  */
    /* JADX WARN: Found duplicated region for block: B:74:0x011f A[FALL_THROUGH, PHI: r21 r22
      0x011f: PHI (r21v8 boolean) = 
      (r21v5 boolean)
      (r21v5 boolean)
      (r21v5 boolean)
      (r21v5 boolean)
      (r21v15 boolean)
      (r21v15 boolean)
      (r21v15 boolean)
      (r21v15 boolean)
     binds: [B:73:0x011c, B:81:0x0133, B:85:0x013f, B:84:0x013b, B:43:0x00c5, B:51:0x00db, B:55:0x00e7, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]
      0x011f: PHI (r22v8 int) = (r22v1 int), (r22v6 int), (r22v6 int), (r22v6 int), (r22v1 int), (r22v12 int), (r22v12 int), (r22v12 int) binds: [B:73:0x011c, B:81:0x0133, B:85:0x013f, B:84:0x013b, B:43:0x00c5, B:51:0x00db, B:55:0x00e7, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:75:0x0121  */
    /* JADX WARN: Found duplicated region for block: B:77:0x0127  */
    /* JADX WARN: Found duplicated region for block: B:78:0x012a  */
    /* JADX WARN: Found duplicated region for block: B:80:0x0131  */
    /* JADX WARN: Found duplicated region for block: B:82:0x0135  */
    /* JADX WARN: Found duplicated region for block: B:84:0x013b  */
    /* JADX WARN: Found duplicated region for block: B:85:0x013f  */
    /* JADX WARN: Found duplicated region for block: B:86:0x0145  */
    /* JADX WARN: Found duplicated region for block: B:87:0x0147  */
    /* JADX WARN: Found duplicated region for block: B:87:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:88:0x0149 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:89:0x014b A[PHI: r21
      0x014b: PHI (r21v14 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:88:0x0149, B:57:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:91:0x0151 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:92:0x0153 A[PHI: r21
      0x0153: PHI (r21v12 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:91:0x0151, B:60:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:93:0x0157 A[PHI: r21
      0x0157: PHI (r21v11 boolean) = (r21v5 boolean), (r21v5 boolean), (r21v15 boolean), (r21v15 boolean) binds: [B:90:0x014f, B:91:0x0151, B:59:0x00f2, B:60:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:94:0x015a A[PHI: r21
      0x015a: PHI (r21v10 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:73:0x011c, B:43:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:95:0x015e  */
    /* JADX WARN: Found duplicated region for block: B:97:0x0162 A[PHI: r21
      0x0162: PHI (r21v9 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:73:0x011c, B:43:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:98:0x0166 A[PHI: r21
      0x0166: PHI (r21v7 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:72:0x011a, B:42:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:41:0x00c1
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int r26, com.google.zxing.common.BitArray r27, java.util.Map<com.google.zxing.DecodeHintType, ?> r28) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
