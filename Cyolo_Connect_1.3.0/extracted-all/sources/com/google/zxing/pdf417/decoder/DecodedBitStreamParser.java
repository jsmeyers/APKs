package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.ECIStringBuilder;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i;
        ECIStringBuilder eCIStringBuilder = new ECIStringBuilder(iArr.length * 2);
        int iTextCompaction = textCompaction(iArr, 1, eCIStringBuilder);
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        while (iTextCompaction < iArr[0]) {
            int i2 = iTextCompaction + 1;
            int i3 = iArr[iTextCompaction];
            if (i3 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i3) {
                    case TEXT_COMPACTION_MODE_LATCH /* 900 */:
                        iTextCompaction = textCompaction(iArr, i2, eCIStringBuilder);
                        continue;
                    case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                        iTextCompaction = numericCompaction(iArr, i2, eCIStringBuilder);
                        continue;
                    default:
                        switch (i3) {
                            case MACRO_PDF417_TERMINATOR /* 922 */:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                break;
                            case ECI_USER_DEFINED /* 925 */:
                                i = i2 + 1;
                                iTextCompaction = i;
                                break;
                            case ECI_GENERAL_PURPOSE /* 926 */:
                                i = i2 + 2;
                                iTextCompaction = i;
                                break;
                            case ECI_CHARSET /* 927 */:
                                iTextCompaction = i2 + 1;
                                eCIStringBuilder.appendECI(iArr[i2]);
                                break;
                            case 928:
                                iTextCompaction = decodeMacroBlock(iArr, i2, pDF417ResultMetadata);
                                break;
                            default:
                                iTextCompaction = textCompaction(iArr, i2 - 1, eCIStringBuilder);
                                break;
                        }
                        break;
                }
                iTextCompaction = byteCompaction(i3, iArr, i2, eCIStringBuilder);
            } else {
                iTextCompaction = i2 + 1;
                eCIStringBuilder.append((char) iArr[i2]);
            }
        }
        if (eCIStringBuilder.isEmpty() && pDF417ResultMetadata.getFileId() == null) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, eCIStringBuilder.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        int i2;
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i3 = 0;
        while (i3 < 2) {
            iArr2[i3] = iArr[i];
            i3++;
            i++;
        }
        String strDecodeBase900toBase10 = decodeBase900toBase10(iArr2, 2);
        if (strDecodeBase900toBase10.isEmpty()) {
            pDF417ResultMetadata.setSegmentIndex(0);
        } else {
            try {
                pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(strDecodeBase900toBase10));
            } catch (NumberFormatException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (i < iArr[0] && i < iArr.length && (i2 = iArr[i]) != MACRO_PDF417_TERMINATOR && i2 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            sb.append(String.format("%03d", Integer.valueOf(i2)));
            i++;
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        pDF417ResultMetadata.setFileId(sb.toString());
        int i4 = iArr[i] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD ? i + 1 : -1;
        while (i < iArr[0]) {
            int i5 = iArr[i];
            if (i5 == MACRO_PDF417_TERMINATOR) {
                i++;
                pDF417ResultMetadata.setLastSegment(true);
            } else if (i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                int i6 = i + 1;
                switch (iArr[i6]) {
                    case 0:
                        ECIStringBuilder eCIStringBuilder = new ECIStringBuilder();
                        i = textCompaction(iArr, i6 + 1, eCIStringBuilder);
                        pDF417ResultMetadata.setFileName(eCIStringBuilder.toString());
                        break;
                    case 1:
                        ECIStringBuilder eCIStringBuilder2 = new ECIStringBuilder();
                        i = numericCompaction(iArr, i6 + 1, eCIStringBuilder2);
                        pDF417ResultMetadata.setSegmentCount(Integer.parseInt(eCIStringBuilder2.toString()));
                        break;
                    case 2:
                        ECIStringBuilder eCIStringBuilder3 = new ECIStringBuilder();
                        i = numericCompaction(iArr, i6 + 1, eCIStringBuilder3);
                        pDF417ResultMetadata.setTimestamp(Long.parseLong(eCIStringBuilder3.toString()));
                        break;
                    case 3:
                        ECIStringBuilder eCIStringBuilder4 = new ECIStringBuilder();
                        i = textCompaction(iArr, i6 + 1, eCIStringBuilder4);
                        pDF417ResultMetadata.setSender(eCIStringBuilder4.toString());
                        break;
                    case 4:
                        ECIStringBuilder eCIStringBuilder5 = new ECIStringBuilder();
                        i = textCompaction(iArr, i6 + 1, eCIStringBuilder5);
                        pDF417ResultMetadata.setAddressee(eCIStringBuilder5.toString());
                        break;
                    case 5:
                        ECIStringBuilder eCIStringBuilder6 = new ECIStringBuilder();
                        i = numericCompaction(iArr, i6 + 1, eCIStringBuilder6);
                        pDF417ResultMetadata.setFileSize(Long.parseLong(eCIStringBuilder6.toString()));
                        break;
                    case 6:
                        ECIStringBuilder eCIStringBuilder7 = new ECIStringBuilder();
                        i = numericCompaction(iArr, i6 + 1, eCIStringBuilder7);
                        pDF417ResultMetadata.setChecksum(Integer.parseInt(eCIStringBuilder7.toString()));
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i4 != -1) {
            int i7 = i - i4;
            if (pDF417ResultMetadata.isLastSegment()) {
                i7--;
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i4, i7 + i4));
        }
        return i;
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x0047 A[FALL_THROUGH] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private static int textCompaction(int[] r10, int r11, com.google.zxing.common.ECIStringBuilder r12) throws com.google.zxing.FormatException {
        /*
            r0 = 0
            r1 = r10[r0]
            int r2 = r1 - r11
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            int r1 = r1 - r11
            int r1 = r1 * 2
            int[] r1 = new int[r1]
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r4 = 0
            r5 = 0
        L12:
            r6 = r10[r0]
            if (r11 >= r6) goto L75
            if (r4 != 0) goto L75
            int r6 = r11 + 1
            r11 = r10[r11]
            r7 = 900(0x384, float:1.261E-42)
            if (r11 >= r7) goto L2d
            int r7 = r11 / 30
            r2[r5] = r7
            int r7 = r5 + 1
            int r11 = r11 % 30
            r2[r7] = r11
            int r5 = r5 + 2
            goto L3f
        L2d:
            r8 = 913(0x391, float:1.28E-42)
            if (r11 == r8) goto L6a
            r8 = 927(0x39f, float:1.299E-42)
            if (r11 == r8) goto L4b
            r8 = 928(0x3a0, float:1.3E-42)
            if (r11 == r8) goto L47
            switch(r11) {
                case 900: goto L41;
                case 901: goto L47;
                case 902: goto L47;
                default: goto L3c;
            }
        L3c:
            switch(r11) {
                case 922: goto L47;
                case 923: goto L47;
                case 924: goto L47;
                default: goto L3f;
            }
        L3f:
            r11 = r6
            goto L12
        L41:
            int r11 = r5 + 1
            r2[r5] = r7
            r5 = r11
            goto L3f
        L47:
            int r6 = r6 + (-1)
            r4 = 1
            goto L3f
        L4b:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r11 = decodeTextCompaction(r2, r1, r5, r12, r3)
            int r1 = r6 + 1
            r2 = r10[r6]
            r12.appendECI(r2)
            r2 = r10[r0]
            int r3 = r2 - r1
            int r3 = r3 * 2
            int[] r3 = new int[r3]
            int r2 = r2 - r1
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            r5 = 0
            r9 = r3
            r3 = r11
            r11 = r1
            r1 = r2
            r2 = r9
            goto L12
        L6a:
            r2[r5] = r8
            int r11 = r6 + 1
            r6 = r10[r6]
            r1[r5] = r6
            int r5 = r5 + 1
            goto L12
        L75:
            decodeTextCompaction(r2, r1, r5, r12, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.textCompaction(int[], int, com.google.zxing.common.ECIStringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0020. Please report as an issue. */
    /* JADX WARN: Found duplicated region for block: B:45:0x0095  */
    private static Mode decodeTextCompaction(int[] iArr, int[] iArr2, int i, ECIStringBuilder eCIStringBuilder, Mode mode) {
        Mode mode2;
        int i2;
        char c;
        char c2;
        Mode mode3;
        Mode mode4 = mode;
        Mode mode5 = mode4;
        Mode mode6 = mode5;
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            char c3 = ' ';
            switch (AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode5.ordinal()]) {
                case 1:
                    if (i4 >= 26) {
                        if (i4 != TEXT_COMPACTION_MODE_LATCH) {
                            if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                switch (i4) {
                                    case 27:
                                        mode4 = Mode.LOWER;
                                        break;
                                    case 28:
                                        mode4 = Mode.MIXED;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c3 = 0;
                                        Mode mode7 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode7;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c2 = c3;
                            } else {
                                eCIStringBuilder.append((char) iArr2[i3]);
                            }
                            c3 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c2 = c3;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        mode5 = mode4;
                        c3 = 0;
                        mode3 = mode6;
                        mode6 = mode5;
                        c2 = c3;
                    } else {
                        i2 = i4 + 65;
                        c = (char) i2;
                        Mode mode8 = mode6;
                        mode6 = mode5;
                        c2 = c;
                        mode3 = mode8;
                    }
                    break;
                case 2:
                    if (i4 >= 26) {
                        if (i4 != TEXT_COMPACTION_MODE_LATCH) {
                            if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                switch (i4) {
                                    case 27:
                                        mode2 = Mode.ALPHA_SHIFT;
                                        c3 = 0;
                                        Mode mode72 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode72;
                                        break;
                                    case 28:
                                        mode4 = Mode.MIXED;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c3 = 0;
                                        Mode mode722 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode722;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c2 = c3;
                            } else {
                                eCIStringBuilder.append((char) iArr2[i3]);
                            }
                            c3 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c2 = c3;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        mode5 = mode4;
                        c3 = 0;
                        mode3 = mode6;
                        mode6 = mode5;
                        c2 = c3;
                    } else {
                        i2 = i4 + 97;
                        c = (char) i2;
                        Mode mode82 = mode6;
                        mode6 = mode5;
                        c2 = c;
                        mode3 = mode82;
                    }
                    break;
                case 3:
                    if (i4 >= 25) {
                        if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                            mode4 = Mode.ALPHA;
                            mode5 = mode4;
                            c3 = 0;
                        } else {
                            if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                switch (i4) {
                                    case 25:
                                        mode4 = Mode.PUNCT;
                                        mode5 = mode4;
                                        break;
                                    case 27:
                                        mode4 = Mode.LOWER;
                                        mode5 = mode4;
                                        break;
                                    case 28:
                                        mode4 = Mode.ALPHA;
                                        mode5 = mode4;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c3 = 0;
                                        Mode mode7222 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode7222;
                                        break;
                                }
                            } else {
                                eCIStringBuilder.append((char) iArr2[i3]);
                            }
                            c3 = 0;
                        }
                        mode3 = mode6;
                        mode6 = mode5;
                        c2 = c3;
                    } else {
                        c = MIXED_CHARS[i4];
                        Mode mode822 = mode6;
                        mode6 = mode5;
                        c2 = c;
                        mode3 = mode822;
                    }
                    break;
                case 4:
                    if (i4 >= 29) {
                        if (i4 == 29 || i4 == TEXT_COMPACTION_MODE_LATCH) {
                            mode4 = Mode.ALPHA;
                            mode5 = mode4;
                        } else if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            eCIStringBuilder.append((char) iArr2[i3]);
                        }
                        mode3 = mode6;
                        mode6 = mode5;
                        c2 = 0;
                    } else {
                        c = PUNCT_CHARS[i4];
                        Mode mode8222 = mode6;
                        mode6 = mode5;
                        c2 = c;
                        mode3 = mode8222;
                    }
                    break;
                case 5:
                    if (i4 >= 26) {
                        if (i4 != 26) {
                            mode5 = i4 != TEXT_COMPACTION_MODE_LATCH ? mode6 : Mode.ALPHA;
                            c3 = 0;
                        } else {
                            mode5 = mode6;
                        }
                        mode3 = mode6;
                        mode6 = mode5;
                        c2 = c3;
                    } else {
                        c2 = (char) (i4 + 65);
                        mode3 = mode6;
                    }
                    break;
                case 6:
                    if (i4 >= 29) {
                        if (i4 == 29 || i4 == TEXT_COMPACTION_MODE_LATCH) {
                            mode5 = Mode.ALPHA;
                            mode3 = mode6;
                            mode6 = mode5;
                        } else {
                            if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                eCIStringBuilder.append((char) iArr2[i3]);
                            }
                            mode3 = mode6;
                        }
                        c2 = 0;
                    } else {
                        c2 = PUNCT_CHARS[i4];
                        mode3 = mode6;
                    }
                    break;
                default:
                    mode3 = mode6;
                    mode6 = mode5;
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                eCIStringBuilder.append(c2);
            }
            i3++;
            mode5 = mode6;
            mode6 = mode3;
        }
        return mode4;
    }

    /* JADX INFO: renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static int byteCompaction(int i, int[] iArr, int i2, ECIStringBuilder eCIStringBuilder) throws FormatException {
        int i3;
        int i4;
        boolean z = false;
        while (i2 < iArr[0] && !z) {
            while (true) {
                i3 = iArr[0];
                if (i2 >= i3 || iArr[i2] != ECI_CHARSET) {
                    break;
                }
                int i5 = i2 + 1;
                eCIStringBuilder.appendECI(iArr[i5]);
                i2 = i5 + 1;
            }
            if (i2 >= i3 || iArr[i2] >= TEXT_COMPACTION_MODE_LATCH) {
                z = true;
            } else {
                long j = 0;
                int i6 = 0;
                while (true) {
                    i4 = i2 + 1;
                    j = (j * 900) + ((long) iArr[i2]);
                    i6++;
                    if (i6 >= 5 || i4 >= iArr[0] || iArr[i4] >= TEXT_COMPACTION_MODE_LATCH) {
                        break;
                    }
                    i2 = i4;
                }
                if (i6 != 5 || (i != BYTE_COMPACTION_MODE_LATCH_6 && (i4 >= iArr[0] || iArr[i4] >= TEXT_COMPACTION_MODE_LATCH))) {
                    i4 -= i6;
                    while (i4 < iArr[0] && !z) {
                        int i7 = i4 + 1;
                        int i8 = iArr[i4];
                        if (i8 < TEXT_COMPACTION_MODE_LATCH) {
                            eCIStringBuilder.append((byte) i8);
                            i4 = i7;
                        } else if (i8 == ECI_CHARSET) {
                            eCIStringBuilder.appendECI(iArr[i7]);
                            i4 = i7 + 1;
                        } else {
                            i4 = i7 - 1;
                            z = true;
                        }
                    }
                } else {
                    for (int i9 = 0; i9 < 6; i9++) {
                        eCIStringBuilder.append((byte) (j >> ((5 - i9) * 8)));
                    }
                }
                i2 = i4;
            }
        }
        return i2;
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0030  */
    private static int numericCompaction(int[] iArr, int i, ECIStringBuilder eCIStringBuilder) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = iArr[0];
            if (i < i3 && !z) {
                int i4 = i + 1;
                int i5 = iArr[i];
                if (i4 == i3) {
                    z = true;
                }
                if (i5 >= TEXT_COMPACTION_MODE_LATCH) {
                    if (i5 != TEXT_COMPACTION_MODE_LATCH && i5 != BYTE_COMPACTION_MODE_LATCH && i5 != ECI_CHARSET && i5 != 928) {
                        switch (i5) {
                            case MACRO_PDF417_TERMINATOR /* 922 */:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                            case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                i4--;
                                z = true;
                                break;
                        }
                    } else {
                        i4--;
                        z = true;
                    }
                } else {
                    iArr2[i2] = i5;
                    i2++;
                }
                if ((i2 % 15 == 0 || i5 == NUMERIC_COMPACTION_MODE_LATCH || z) && i2 > 0) {
                    eCIStringBuilder.append(decodeBase900toBase10(iArr2, i2));
                    i2 = 0;
                }
                i = i4;
            }
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) != '1') {
            throw FormatException.getFormatInstance();
        }
        return string.substring(1);
    }
}
