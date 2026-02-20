package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> listDetect = detect(z, blackMatrix);
        for (int i = 0; listDetect.isEmpty() && i < 3; i++) {
            blackMatrix = blackMatrix.m341clone();
            if (i != 1) {
                blackMatrix.rotate180();
            } else {
                blackMatrix.rotate90();
            }
            listDetect = detect(z, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, listDetect);
    }

    private static List<ResultPoint[]> detect(boolean z, BitMatrix bitMatrix) {
        int x;
        float y;
        ArrayList<ResultPoint[]> arrayList = new ArrayList();
        int iMax = 0;
        loop0: while (true) {
            int i = 0;
            boolean z2 = false;
            while (iMax < bitMatrix.getHeight()) {
                ResultPoint[] resultPointArrFindVertices = findVertices(bitMatrix, iMax, i);
                if (resultPointArrFindVertices[0] == null && resultPointArrFindVertices[3] == null) {
                    if (!z2) {
                        break;
                    }
                    for (ResultPoint[] resultPointArr : arrayList) {
                        ResultPoint resultPoint = resultPointArr[1];
                        if (resultPoint != null) {
                            iMax = (int) Math.max(iMax, resultPoint.getY());
                        }
                        ResultPoint resultPoint2 = resultPointArr[3];
                        if (resultPoint2 != null) {
                            iMax = Math.max(iMax, (int) resultPoint2.getY());
                        }
                    }
                    iMax += 5;
                } else {
                    arrayList.add(resultPointArrFindVertices);
                    if (!z) {
                        break loop0;
                    }
                    ResultPoint resultPoint3 = resultPointArrFindVertices[2];
                    if (resultPoint3 != null) {
                        x = (int) resultPoint3.getX();
                        y = resultPointArrFindVertices[2].getY();
                    } else {
                        x = (int) resultPointArrFindVertices[4].getX();
                        y = resultPointArrFindVertices[4].getY();
                    }
                    iMax = (int) y;
                    i = x;
                    z2 = true;
                }
            }
            break loop0;
        }
        return arrayList;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, START_PATTERN), INDEXES_START_PATTERN);
        ResultPoint resultPoint = resultPointArr[4];
        if (resultPoint != null) {
            i2 = (int) resultPoint.getX();
            i = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            resultPointArr[iArr[i]] = resultPointArr2[i];
        }
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i6 = i3;
        while (true) {
            if (i6 >= i) {
                z = false;
                break;
            }
            int[] iArrFindGuardPattern = findGuardPattern(bitMatrix, i4, i6, i2, iArr, iArr2);
            if (iArrFindGuardPattern != null) {
                int i7 = i6;
                int[] iArr3 = iArrFindGuardPattern;
                int i8 = i7;
                while (true) {
                    if (i8 <= 0) {
                        i5 = i8;
                        break;
                    }
                    int i9 = i8 - 1;
                    int[] iArrFindGuardPattern2 = findGuardPattern(bitMatrix, i4, i9, i2, iArr, iArr2);
                    if (iArrFindGuardPattern2 == null) {
                        i5 = i9 + 1;
                        break;
                    }
                    iArr3 = iArrFindGuardPattern2;
                    i8 = i9;
                }
                float f = i5;
                resultPointArr[0] = new ResultPoint(iArr3[0], f);
                resultPointArr[1] = new ResultPoint(iArr3[1], f);
                i6 = i5;
                z = true;
                break;
            }
            i6 += 5;
        }
        int i10 = i6 + 1;
        if (z) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i11 = i10;
            int i12 = 0;
            while (i11 < i) {
                int[] iArrFindGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i11, i2, iArr, iArr2);
                if (iArrFindGuardPattern3 != null && Math.abs(iArr4[0] - iArrFindGuardPattern3[0]) < 5 && Math.abs(iArr4[1] - iArrFindGuardPattern3[1]) < 5) {
                    iArr4 = iArrFindGuardPattern3;
                    i12 = 0;
                } else {
                    if (i12 > 25) {
                        break;
                    }
                    i12++;
                }
                i11++;
            }
            i10 = i11 - (i12 + 1);
            float f2 = i10;
            resultPointArr[2] = new ResultPoint(iArr4[0], f2);
            resultPointArr[3] = new ResultPoint(iArr4[1], f2);
        }
        if (i10 - i6 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z = false;
        while (i < i3) {
            if (bitMatrix.get(i, i2) != z) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (patternMatchVariance(iArr2, iArr) < MAX_AVG_VARIANCE) {
                        return new int[]{i6, i};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z = !z;
            }
            i++;
        }
        if (i7 != length - 1 || patternMatchVariance(iArr2, iArr) >= MAX_AVG_VARIANCE) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f = i;
        float f2 = f / i2;
        float f3 = MAX_INDIVIDUAL_VARIANCE * f2;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f5 = iArr2[i4] * f2;
            float f6 = iArr[i4];
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
        }
        return f4 / f;
    }
}
