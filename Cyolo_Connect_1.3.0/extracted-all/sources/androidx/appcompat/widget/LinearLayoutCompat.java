package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.common.primitives.Ints;
import j$.util.function.IntFunction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    int measureNullChild(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<LinearLayoutCompat> {
        private int mBaselineAlignedChildIndexId;
        private int mBaselineAlignedId;
        private int mDividerId;
        private int mDividerPaddingId;
        private int mGravityId;
        private int mMeasureWithLargestChildId;
        private int mOrientationId;
        private boolean mPropertiesMapped = false;
        private int mShowDividersId;
        private int mWeightSumId;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            this.mBaselineAlignedId = propertyMapper.mapBoolean("baselineAligned", R.attr.baselineAligned);
            this.mBaselineAlignedChildIndexId = propertyMapper.mapInt("baselineAlignedChildIndex", R.attr.baselineAlignedChildIndex);
            this.mGravityId = propertyMapper.mapGravity("gravity", R.attr.gravity);
            this.mOrientationId = propertyMapper.mapIntEnum("orientation", R.attr.orientation, IntFunction.Wrapper.convert(new IntFunction<String>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.1
                @Override // j$.util.function.IntFunction
                public String apply(int i) {
                    return i != 0 ? i != 1 ? String.valueOf(i) : "vertical" : "horizontal";
                }
            }));
            this.mWeightSumId = propertyMapper.mapFloat("weightSum", R.attr.weightSum);
            this.mDividerId = propertyMapper.mapObject("divider", androidx.appcompat.R.attr.divider);
            this.mDividerPaddingId = propertyMapper.mapInt("dividerPadding", androidx.appcompat.R.attr.dividerPadding);
            this.mMeasureWithLargestChildId = propertyMapper.mapBoolean("measureWithLargestChild", androidx.appcompat.R.attr.measureWithLargestChild);
            this.mShowDividersId = propertyMapper.mapIntFlag("showDividers", androidx.appcompat.R.attr.showDividers, IntFunction.Wrapper.convert(new IntFunction<Set<String>>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.2
                @Override // j$.util.function.IntFunction
                public Set<String> apply(int i) {
                    HashSet hashSet = new HashSet();
                    if (i == 0) {
                        hashSet.add("none");
                    }
                    if (i == 1) {
                        hashSet.add("beginning");
                    }
                    if (i == 2) {
                        hashSet.add("middle");
                    }
                    if (i == 4) {
                        hashSet.add("end");
                    }
                    return hashSet;
                }
            }));
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(LinearLayoutCompat linearLayoutCompat, PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw ComponentDialog$$ExternalSyntheticApiModelOutline0.m9m();
            }
            propertyReader.readBoolean(this.mBaselineAlignedId, linearLayoutCompat.isBaselineAligned());
            propertyReader.readInt(this.mBaselineAlignedChildIndexId, linearLayoutCompat.getBaselineAlignedChildIndex());
            propertyReader.readGravity(this.mGravityId, linearLayoutCompat.getGravity());
            propertyReader.readIntEnum(this.mOrientationId, linearLayoutCompat.getOrientation());
            propertyReader.readFloat(this.mWeightSumId, linearLayoutCompat.getWeightSum());
            propertyReader.readObject(this.mDividerId, linearLayoutCompat.getDividerDrawable());
            propertyReader.readInt(this.mDividerPaddingId, linearLayoutCompat.getDividerPadding());
            propertyReader.readBoolean(this.mMeasureWithLargestChildId, linearLayoutCompat.isMeasureWithLargestChildEnabled());
            propertyReader.readIntFlag(this.mShowDividersId, linearLayoutCompat.getShowDividers());
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.appcompat.R.styleable.LinearLayoutCompat, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = tintTypedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (zIsLayoutRtl) {
                    left2 = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    left2 = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, left2);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (zIsLayoutRtl) {
                    left = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i = this.mDividerWidth;
                    right = left - i;
                } else {
                    right = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                }
            } else if (zIsLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.mDividerWidth;
                right = left - i;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return bottom + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Found duplicated region for block: B:150:0x0327  */
    /* JADX WARN: Found duplicated region for block: B:156:0x0334  */
    void measureVertical(int i, int i2) {
        int i3;
        int iCombineMeasuredStates;
        int i4;
        int iMax;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View view;
        int iMax2;
        boolean z2;
        int iMax3;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i17 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f = 0.0f;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int iMax4 = 0;
        int i21 = 0;
        int childrenSkipCount = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i22 = 8;
            int i23 = iMax4;
            if (childrenSkipCount < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(childrenSkipCount);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(childrenSkipCount);
                    i12 = virtualChildCount;
                    i13 = mode2;
                    iMax4 = i23;
                } else {
                    int i24 = i18;
                    if (virtualChildAt.getVisibility() == 8) {
                        childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                        i12 = virtualChildCount;
                        iMax4 = i23;
                        i18 = i24;
                        i13 = mode2;
                    } else {
                        if (hasDividerBeforeChildAt(childrenSkipCount)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                        float f2 = f + layoutParams.weight;
                        if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                            int i25 = this.mTotalLength;
                            this.mTotalLength = Math.max(i25, layoutParams.topMargin + i25 + layoutParams.bottomMargin);
                            iMax2 = i20;
                            view = virtualChildAt;
                            i15 = i21;
                            i12 = virtualChildCount;
                            i10 = i24;
                            i11 = i19;
                            z4 = true;
                            i16 = childrenSkipCount;
                            i13 = mode2;
                            i14 = i23;
                        } else {
                            int i26 = i19;
                            if (layoutParams.height != 0 || layoutParams.weight <= 0.0f) {
                                i9 = Integer.MIN_VALUE;
                            } else {
                                layoutParams.height = -2;
                                i9 = 0;
                            }
                            i10 = i24;
                            int i27 = i9;
                            i11 = i26;
                            int i28 = i20;
                            i12 = virtualChildCount;
                            i13 = mode2;
                            i14 = i23;
                            i15 = i21;
                            i16 = childrenSkipCount;
                            measureChildBeforeLayout(virtualChildAt, childrenSkipCount, i, 0, i2, f2 == 0.0f ? this.mTotalLength : 0);
                            if (i27 != Integer.MIN_VALUE) {
                                layoutParams.height = i27;
                            }
                            int measuredHeight = virtualChildAt.getMeasuredHeight();
                            int i29 = this.mTotalLength;
                            view = virtualChildAt;
                            this.mTotalLength = Math.max(i29, i29 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                            iMax2 = z3 ? Math.max(measuredHeight, i28) : i28;
                        }
                        if (i17 >= 0 && i17 == i16 + 1) {
                            this.mBaselineChildTop = this.mTotalLength;
                        }
                        if (i16 < i17 && layoutParams.weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (mode == 1073741824 || layoutParams.width != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                            z6 = true;
                        }
                        int i30 = layoutParams.leftMargin + layoutParams.rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i30;
                        int iMax5 = Math.max(i11, measuredWidth);
                        int iCombineMeasuredStates2 = View.combineMeasuredStates(i10, view.getMeasuredState());
                        z5 = z5 && layoutParams.width == -1;
                        if (layoutParams.weight > 0.0f) {
                            if (!z2) {
                                i30 = measuredWidth;
                            }
                            iMax4 = Math.max(i14, i30);
                            iMax3 = i15;
                        } else {
                            if (!z2) {
                                i30 = measuredWidth;
                            }
                            iMax3 = Math.max(i15, i30);
                            iMax4 = i14;
                        }
                        int childrenSkipCount2 = getChildrenSkipCount(view, i16) + i16;
                        i20 = iMax2;
                        f = f2;
                        i21 = iMax3;
                        i18 = iCombineMeasuredStates2;
                        childrenSkipCount = childrenSkipCount2;
                        i19 = iMax5;
                    }
                }
                childrenSkipCount++;
                virtualChildCount = i12;
                mode2 = i13;
            } else {
                int i31 = i18;
                int i32 = i20;
                int i33 = i21;
                int i34 = virtualChildCount;
                int i35 = mode2;
                int iMax6 = i19;
                if (this.mTotalLength > 0) {
                    i3 = i34;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i34;
                }
                if (z3 && (i35 == Integer.MIN_VALUE || i35 == 0)) {
                    this.mTotalLength = 0;
                    int childrenSkipCount3 = 0;
                    while (childrenSkipCount3 < i3) {
                        View virtualChildAt2 = getVirtualChildAt(childrenSkipCount3);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(childrenSkipCount3);
                        } else if (virtualChildAt2.getVisibility() == i22) {
                            childrenSkipCount3 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount3);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            int i36 = this.mTotalLength;
                            this.mTotalLength = Math.max(i36, i36 + i32 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        childrenSkipCount3++;
                        i22 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i37 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
                if (z4 || (i37 != 0 && f > 0.0f)) {
                    float f3 = this.mWeightSum;
                    if (f3 > 0.0f) {
                        f = f3;
                    }
                    this.mTotalLength = 0;
                    int i38 = i37;
                    int i39 = i33;
                    iCombineMeasuredStates = i31;
                    int i40 = 0;
                    while (i40 < i3) {
                        View virtualChildAt3 = getVirtualChildAt(i40);
                        if (virtualChildAt3.getVisibility() == 8) {
                            i5 = i38;
                        } else {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                            float f4 = layoutParams3.weight;
                            if (f4 > 0.0f) {
                                int i41 = (int) ((i38 * f4) / f);
                                float f5 = f - f4;
                                i5 = i38 - i41;
                                int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                                if (layoutParams3.height == 0) {
                                    i8 = Ints.MAX_POWER_OF_TWO;
                                    if (i35 == 1073741824) {
                                        if (i41 <= 0) {
                                            i41 = 0;
                                        }
                                        virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i41, Ints.MAX_POWER_OF_TWO));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt3.getMeasuredState() & (-256));
                                    f = f5;
                                } else {
                                    i8 = Ints.MAX_POWER_OF_TWO;
                                }
                                int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i41;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i8));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt3.getMeasuredState() & (-256));
                                f = f5;
                            } else {
                                i5 = i38;
                            }
                            int i42 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                            int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i42;
                            iMax6 = Math.max(iMax6, measuredWidth2);
                            float f6 = f;
                            if (mode != 1073741824) {
                                i6 = iCombineMeasuredStates;
                                i7 = -1;
                                z = layoutParams3.width == -1;
                                if (!z) {
                                    i42 = measuredWidth2;
                                }
                                int iMax7 = Math.max(i39, i42);
                                boolean z7 = !z5 && layoutParams3.width == i7;
                                int i43 = this.mTotalLength;
                                this.mTotalLength = Math.max(i43, virtualChildAt3.getMeasuredHeight() + i43 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                                z5 = z7;
                                iCombineMeasuredStates = i6;
                                i39 = iMax7;
                                f = f6;
                            } else {
                                i6 = iCombineMeasuredStates;
                                i7 = -1;
                            }
                            if (!z) {
                                i42 = measuredWidth2;
                            }
                            int iMax72 = Math.max(i39, i42);
                            if (z5) {
                            }
                            int i432 = this.mTotalLength;
                            this.mTotalLength = Math.max(i432, virtualChildAt3.getMeasuredHeight() + i432 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                            z5 = z7;
                            iCombineMeasuredStates = i6;
                            i39 = iMax72;
                            f = f6;
                        }
                        i40++;
                        i38 = i5;
                    }
                    i4 = i;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    iMax = i39;
                } else {
                    iMax = Math.max(i33, i23);
                    if (z3 && i35 != 1073741824) {
                        for (int i44 = 0; i44 < i3; i44++) {
                            View virtualChildAt4 = getVirtualChildAt(i44);
                            if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(i32, Ints.MAX_POWER_OF_TWO));
                            }
                        }
                    }
                    i4 = i;
                    iCombineMeasuredStates = i31;
                }
                if (z5 || mode == 1073741824) {
                    iMax = iMax6;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i4, iCombineMeasuredStates), iResolveSizeAndState);
                if (z6) {
                    forceUniformWidth(i3, i2);
                    return;
                }
                return;
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:198:0x0453  */
    /* JADX WARN: Found duplicated region for block: B:199:0x0456  */
    /* JADX WARN: Found duplicated region for block: B:60:0x0177  */
    /* JADX WARN: Found duplicated region for block: B:67:0x0199  */
    /* JADX WARN: Found duplicated region for block: B:68:0x019c  */
    /* JADX WARN: Found duplicated region for block: B:75:0x01c8  */
    /* JADX WARN: Found duplicated region for block: B:78:0x01d0 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:80:0x01d3  */
    /* JADX WARN: Found duplicated region for block: B:82:0x01db  */
    /* JADX WARN: Found duplicated region for block: B:85:0x01e0  */
    void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int iMax;
        int i4;
        int i5;
        int iMax2;
        int iMax3;
        int i6;
        int i7;
        float f;
        int i8;
        int baseline;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        boolean z2;
        View view;
        int i13;
        boolean z3;
        int i14;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z4 = this.mBaselineAligned;
        boolean z5 = this.mUseLargestChild;
        int i15 = Ints.MAX_POWER_OF_TWO;
        boolean z6 = mode == 1073741824;
        float f2 = 0.0f;
        int childrenSkipCount2 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        int iMax6 = 0;
        int iMax7 = 0;
        boolean z7 = false;
        int iCombineMeasuredStates = 0;
        boolean z8 = true;
        boolean z9 = false;
        while (true) {
            iArr = iArr3;
            if (childrenSkipCount2 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(childrenSkipCount2);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(childrenSkipCount2);
            } else {
                if (virtualChildAt.getVisibility() == 8) {
                    childrenSkipCount2 += getChildrenSkipCount(virtualChildAt, childrenSkipCount2);
                } else {
                    if (hasDividerBeforeChildAt(childrenSkipCount2)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f3 = f2 + layoutParams.weight;
                    if (mode != i15 || layoutParams.width != 0 || layoutParams.weight <= 0.0f) {
                        if (layoutParams.width != 0 || layoutParams.weight <= 0.0f) {
                            i11 = Integer.MIN_VALUE;
                        } else {
                            layoutParams.width = -2;
                            i11 = 0;
                        }
                        i12 = childrenSkipCount2;
                        int i16 = i11;
                        z = z5;
                        z2 = z4;
                        measureChildBeforeLayout(virtualChildAt, i12, i, f3 == 0.0f ? this.mTotalLength : 0, i2, 0);
                        if (i16 != Integer.MIN_VALUE) {
                            layoutParams.width = i16;
                        }
                        int measuredWidth = virtualChildAt.getMeasuredWidth();
                        if (z6) {
                            view = virtualChildAt;
                            this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                        } else {
                            view = virtualChildAt;
                            int i17 = this.mTotalLength;
                            this.mTotalLength = Math.max(i17, i17 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                        }
                        if (z) {
                            iMax4 = Math.max(measuredWidth, iMax4);
                        }
                    } else {
                        if (z6) {
                            this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                        } else {
                            int i18 = this.mTotalLength;
                            this.mTotalLength = Math.max(i18, layoutParams.leftMargin + i18 + layoutParams.rightMargin);
                        }
                        if (z4) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i12 = childrenSkipCount2;
                            z = z5;
                            z2 = z4;
                            view = virtualChildAt;
                        } else {
                            i12 = childrenSkipCount2;
                            z = z5;
                            z2 = z4;
                            view = virtualChildAt;
                            i13 = Ints.MAX_POWER_OF_TWO;
                            z7 = true;
                        }
                        if (mode2 == i13 && layoutParams.height == -1) {
                            z3 = true;
                            z9 = true;
                        }
                        i14 = layoutParams.topMargin + layoutParams.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i14;
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            int i19 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & (-2)) >> 1;
                            iArr2[i19] = Math.max(iArr2[i19], baseline2);
                            iArr[i19] = Math.max(iArr[i19], measuredHeight - baseline2);
                        }
                        iMax5 = Math.max(iMax5, measuredHeight);
                        z8 = !z8 && layoutParams.height == -1;
                        if (layoutParams.weight > 0.0f) {
                            if (!z3) {
                                i14 = measuredHeight;
                            }
                            iMax7 = Math.max(iMax7, i14);
                        } else {
                            int i20 = iMax7;
                            if (!z3) {
                                i14 = measuredHeight;
                            }
                            iMax6 = Math.max(iMax6, i14);
                            iMax7 = i20;
                        }
                        int i21 = i12;
                        childrenSkipCount = getChildrenSkipCount(view, i21) + i21;
                        f2 = f3;
                    }
                    i13 = Ints.MAX_POWER_OF_TWO;
                    z3 = mode2 == i13 ? false : false;
                    i14 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i14;
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    if (z2) {
                        int i192 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & (-2)) >> 1;
                        iArr2[i192] = Math.max(iArr2[i192], baseline2);
                        iArr[i192] = Math.max(iArr[i192], measuredHeight - baseline2);
                    }
                    iMax5 = Math.max(iMax5, measuredHeight);
                    if (z8) {
                    }
                    if (layoutParams.weight > 0.0f) {
                        if (!z3) {
                            i14 = measuredHeight;
                        }
                        iMax7 = Math.max(iMax7, i14);
                    } else {
                        int i202 = iMax7;
                        if (!z3) {
                            i14 = measuredHeight;
                        }
                        iMax6 = Math.max(iMax6, i14);
                        iMax7 = i202;
                    }
                    int i212 = i12;
                    childrenSkipCount = getChildrenSkipCount(view, i212) + i212;
                    f2 = f3;
                }
                childrenSkipCount2 = childrenSkipCount + 1;
                iArr3 = iArr;
                z5 = z;
                z4 = z2;
                i15 = Ints.MAX_POWER_OF_TWO;
            }
            childrenSkipCount = childrenSkipCount2;
            z = z5;
            z2 = z4;
            childrenSkipCount2 = childrenSkipCount + 1;
            iArr3 = iArr;
            z5 = z;
            z4 = z2;
            i15 = Ints.MAX_POWER_OF_TWO;
        }
        boolean z10 = z5;
        boolean z11 = z4;
        int i22 = iMax5;
        int i23 = iMax6;
        int i24 = iMax7;
        int i25 = iCombineMeasuredStates;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int i26 = iArr2[1];
        if (i26 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            iMax = i22;
            i3 = i25;
        } else {
            i3 = i25;
            iMax = Math.max(i22, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i26, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z10 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int childrenSkipCount3 = 0;
            while (childrenSkipCount3 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(childrenSkipCount3);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(childrenSkipCount3);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    childrenSkipCount3 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount3);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z6) {
                        this.mTotalLength += layoutParams2.leftMargin + iMax4 + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i27 = this.mTotalLength;
                        i10 = iMax;
                        this.mTotalLength = Math.max(i27, i27 + iMax4 + layoutParams2.leftMargin + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2));
                    }
                    childrenSkipCount3++;
                    iMax = i10;
                }
                i10 = iMax;
                childrenSkipCount3++;
                iMax = i10;
            }
        }
        int i28 = iMax;
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i29 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z7 || (i29 != 0 && f2 > 0.0f)) {
            float f4 = this.mWeightSum;
            if (f4 > 0.0f) {
                f2 = f4;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i30 = i23;
            int iCombineMeasuredStates2 = i3;
            int iMax8 = -1;
            int i31 = 0;
            while (i31 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i31);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i6 = i29;
                    i7 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f5 = layoutParams3.weight;
                    if (f5 > 0.0f) {
                        int i32 = (int) ((i29 * f5) / f2);
                        float f6 = f2 - f5;
                        int i33 = i29 - i32;
                        i7 = virtualChildCount;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width == 0) {
                            i9 = Ints.MAX_POWER_OF_TWO;
                            if (mode == 1073741824) {
                                if (i32 <= 0) {
                                    i32 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i32, Ints.MAX_POWER_OF_TWO), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                            f2 = f6;
                            i6 = i33;
                        } else {
                            i9 = Ints.MAX_POWER_OF_TWO;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i32;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i9), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                        f2 = f6;
                        i6 = i33;
                    } else {
                        i6 = i29;
                        i7 = virtualChildCount;
                    }
                    if (z6) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3);
                        f = f2;
                    } else {
                        int i34 = this.mTotalLength;
                        f = f2;
                        this.mTotalLength = Math.max(i34, virtualChildAt3.getMeasuredWidth() + i34 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z12 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i35 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i35;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z12) {
                        i35 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i30, i35);
                    if (z8) {
                        i8 = -1;
                        boolean z13 = layoutParams3.height == -1;
                        if (z11 && (baseline = virtualChildAt3.getBaseline()) != i8) {
                            int i36 = ((((layoutParams3.gravity < 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & (-2)) >> 1;
                            iArr2[i36] = Math.max(iArr2[i36], baseline);
                            iArr[i36] = Math.max(iArr[i36], measuredHeight2 - baseline);
                        }
                        z8 = z13;
                        i30 = iMax9;
                        f2 = f;
                    } else {
                        i8 = -1;
                    }
                    if (z11) {
                        int i362 = ((((layoutParams3.gravity < 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & (-2)) >> 1;
                        iArr2[i362] = Math.max(iArr2[i362], baseline);
                        iArr[i362] = Math.max(iArr[i362], measuredHeight2 - baseline);
                    }
                    z8 = z13;
                    i30 = iMax9;
                    f2 = f;
                }
                i31++;
                i29 = i6;
                virtualChildCount = i7;
            }
            i4 = i2;
            i5 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            int i37 = iArr2[1];
            iMax2 = (i37 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i37, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax3 = i30;
            i3 = iCombineMeasuredStates2;
        } else {
            iMax3 = Math.max(i23, i24);
            if (z10 && mode != 1073741824) {
                for (int i38 = 0; i38 < virtualChildCount; i38++) {
                    View virtualChildAt4 = getVirtualChildAt(i38);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(iMax4, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), Ints.MAX_POWER_OF_TWO));
                    }
                }
            }
            i4 = i2;
            i5 = virtualChildCount;
            iMax2 = i28;
        }
        if (z8 || mode2 == 1073741824) {
            iMax3 = iMax2;
        }
        setMeasuredDimension(iResolveSizeAndState | (i3 & ViewCompat.MEASURED_STATE_MASK), View.resolveSizeAndState(Math.max(iMax3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, i3 << 16));
        if (z9) {
            forceUniformHeight(i5, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Ints.MAX_POWER_OF_TWO);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, iMakeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:29:0x009f  */
    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.mGravity;
        int i10 = i9 & 112;
        int i11 = i9 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i10 == 16) {
            paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        } else if (i10 == 80) {
            paddingTop = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
        } else {
            paddingTop = getPaddingTop();
        }
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(childrenSkipCount);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i12 = layoutParams.gravity;
                if (i12 < 0) {
                    i12 = i11;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i6 = layoutParams.rightMargin;
                } else {
                    if (absoluteGravity == 5) {
                        i5 = paddingRight - measuredWidth;
                        i6 = layoutParams.rightMargin;
                    } else {
                        i7 = layoutParams.leftMargin + paddingLeft;
                    }
                    int i13 = i7;
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i14 = paddingTop + layoutParams.topMargin;
                    setChildFrame(virtualChildAt, i13, i14 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    int nextLocationOffset = i14 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                    paddingTop = nextLocationOffset;
                }
                i7 = i5 - i6;
                int i132 = i7;
                if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    paddingTop += this.mDividerHeight;
                }
                int i142 = paddingTop + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i132, i142 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                int nextLocationOffset2 = i142 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                paddingTop = nextLocationOffset2;
            }
            childrenSkipCount++;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Found duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Found duplicated region for block: B:34:0x00b4  */
    /* JADX WARN: Found duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Found duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Found duplicated region for block: B:39:0x00c3  */
    /* JADX WARN: Found duplicated region for block: B:40:0x00d1  */
    /* JADX WARN: Found duplicated region for block: B:42:0x00d7  */
    /* JADX WARN: Found duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Found duplicated region for block: B:47:0x00f7  */
    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int baseline;
        int i8;
        int i9;
        int i10;
        int measuredHeight;
        int i11;
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i12 = i4 - i2;
        int paddingBottom = i12 - getPaddingBottom();
        int paddingBottom2 = (i12 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.mGravity;
        int i14 = i13 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i13, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 1) {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity == 5) {
            paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (zIsLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            int i15 = i5 + (i6 * childrenSkipCount);
            View virtualChildAt = getVirtualChildAt(i15);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i15);
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight2 = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i16 = childrenSkipCount;
                    if (z) {
                        i7 = virtualChildCount;
                        baseline = layoutParams.height != -1 ? virtualChildAt.getBaseline() : -1;
                        i8 = layoutParams.gravity;
                        if (i8 < 0) {
                            i8 = i14;
                        }
                        i9 = i8 & 112;
                        i10 = i14;
                        if (i9 != 16) {
                            measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        } else if (i9 != 48) {
                            measuredHeight = layoutParams.topMargin + paddingTop;
                            if (baseline != -1) {
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i9 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - layoutParams.bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - baseline);
                            }
                        }
                        if (hasDividerBeforeChildAt(i15)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i17 = layoutParams.leftMargin + paddingLeft;
                        i11 = paddingTop;
                        setChildFrame(virtualChildAt, i17 + getLocationOffset(virtualChildAt), measuredHeight, measuredWidth, measuredHeight2);
                        int nextLocationOffset = i17 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                        childrenSkipCount = i16 + getChildrenSkipCount(virtualChildAt, i15);
                        paddingLeft = nextLocationOffset;
                    } else {
                        i7 = virtualChildCount;
                    }
                    i8 = layoutParams.gravity;
                    if (i8 < 0) {
                        i8 = i14;
                    }
                    i9 = i8 & 112;
                    i10 = i14;
                    if (i9 != 16) {
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                    } else if (i9 != 48) {
                        measuredHeight = layoutParams.topMargin + paddingTop;
                        if (baseline != -1) {
                            measuredHeight += iArr[1] - baseline;
                        }
                    } else if (i9 != 80) {
                        measuredHeight = paddingTop;
                    } else {
                        measuredHeight = (paddingBottom - measuredHeight2) - layoutParams.bottomMargin;
                        if (baseline != -1) {
                            measuredHeight -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - baseline);
                        }
                    }
                    if (hasDividerBeforeChildAt(i15)) {
                        paddingLeft += this.mDividerWidth;
                    }
                    int i172 = layoutParams.leftMargin + paddingLeft;
                    i11 = paddingTop;
                    setChildFrame(virtualChildAt, i172 + getLocationOffset(virtualChildAt), measuredHeight, measuredWidth, measuredHeight2);
                    int nextLocationOffset2 = i172 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                    childrenSkipCount = i16 + getChildrenSkipCount(virtualChildAt, i15);
                    paddingLeft = nextLocationOffset2;
                }
                childrenSkipCount++;
                virtualChildCount = i7;
                i14 = i10;
                paddingTop = i11;
            }
            i11 = paddingTop;
            i7 = virtualChildCount;
            i10 = i14;
            childrenSkipCount++;
            virtualChildCount = i7;
            i14 = i10;
            paddingTop = i11;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }
}
