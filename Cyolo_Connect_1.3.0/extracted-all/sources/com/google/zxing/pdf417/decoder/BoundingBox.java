package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes3.dex */
final class BoundingBox {
    private final ResultPoint bottomLeft;
    private final ResultPoint bottomRight;
    private final BitMatrix image;
    private final int maxX;
    private final int maxY;
    private final int minX;
    private final int minY;
    private final ResultPoint topLeft;
    private final ResultPoint topRight;

    BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z = resultPoint == null || resultPoint2 == null;
        boolean z2 = resultPoint3 == null || resultPoint4 == null;
        if (z && z2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z) {
            resultPoint = new ResultPoint(0.0f, resultPoint3.getY());
            resultPoint2 = new ResultPoint(0.0f, resultPoint4.getY());
        } else if (z2) {
            resultPoint3 = new ResultPoint(bitMatrix.getWidth() - 1, resultPoint.getY());
            resultPoint4 = new ResultPoint(bitMatrix.getWidth() - 1, resultPoint2.getY());
        }
        this.image = bitMatrix;
        this.topLeft = resultPoint;
        this.bottomLeft = resultPoint2;
        this.topRight = resultPoint3;
        this.bottomRight = resultPoint4;
        this.minX = (int) Math.min(resultPoint.getX(), resultPoint2.getX());
        this.maxX = (int) Math.max(resultPoint3.getX(), resultPoint4.getX());
        this.minY = (int) Math.min(resultPoint.getY(), resultPoint3.getY());
        this.maxY = (int) Math.max(resultPoint2.getY(), resultPoint4.getY());
    }

    BoundingBox(BoundingBox boundingBox) {
        this.image = boundingBox.image;
        this.topLeft = boundingBox.topLeft;
        this.bottomLeft = boundingBox.bottomLeft;
        this.topRight = boundingBox.topRight;
        this.bottomRight = boundingBox.bottomRight;
        this.minX = boundingBox.minX;
        this.maxX = boundingBox.maxX;
        this.minY = boundingBox.minY;
        this.maxY = boundingBox.maxY;
    }

    static BoundingBox merge(BoundingBox boundingBox, BoundingBox boundingBox2) throws NotFoundException {
        return boundingBox == null ? boundingBox2 : boundingBox2 == null ? boundingBox : new BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight);
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x002d A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Found duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Found duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Found duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Found duplicated region for block: B:27:0x005b  */
    BoundingBox addMissingRows(int i, int i2, boolean z) throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        int y;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6 = this.topLeft;
        ResultPoint resultPoint7 = this.bottomLeft;
        ResultPoint resultPoint8 = this.topRight;
        ResultPoint resultPoint9 = this.bottomRight;
        if (i > 0) {
            ResultPoint resultPoint10 = z ? resultPoint6 : resultPoint8;
            int y2 = ((int) resultPoint10.getY()) - i;
            if (y2 < 0) {
                y2 = 0;
            }
            ResultPoint resultPoint11 = new ResultPoint(resultPoint10.getX(), y2);
            if (z) {
                resultPoint = resultPoint11;
            } else {
                resultPoint2 = resultPoint11;
                resultPoint = resultPoint6;
            }
            if (i2 > 0) {
                ResultPoint resultPoint12 = z ? this.bottomLeft : this.bottomRight;
                y = ((int) resultPoint12.getY()) + i2;
                if (y >= this.image.getHeight()) {
                    y = this.image.getHeight() - 1;
                }
                resultPoint5 = new ResultPoint(resultPoint12.getX(), y);
                if (z) {
                    resultPoint3 = resultPoint5;
                } else {
                    resultPoint4 = resultPoint5;
                    resultPoint3 = resultPoint7;
                }
                return new BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
            }
            resultPoint3 = resultPoint7;
            resultPoint4 = resultPoint9;
            return new BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
        }
        resultPoint = resultPoint6;
        resultPoint2 = resultPoint8;
        if (i2 > 0) {
            if (z) {
            }
            y = ((int) resultPoint12.getY()) + i2;
            if (y >= this.image.getHeight()) {
                y = this.image.getHeight() - 1;
            }
            resultPoint5 = new ResultPoint(resultPoint12.getX(), y);
            if (z) {
                resultPoint3 = resultPoint5;
            } else {
                resultPoint4 = resultPoint5;
                resultPoint3 = resultPoint7;
            }
            return new BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
        }
        resultPoint3 = resultPoint7;
        resultPoint4 = resultPoint9;
        return new BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
    }

    int getMinX() {
        return this.minX;
    }

    int getMaxX() {
        return this.maxX;
    }

    int getMinY() {
        return this.minY;
    }

    int getMaxY() {
        return this.maxY;
    }

    ResultPoint getTopLeft() {
        return this.topLeft;
    }

    ResultPoint getTopRight() {
        return this.topRight;
    }

    ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    ResultPoint getBottomRight() {
        return this.bottomRight;
    }
}
