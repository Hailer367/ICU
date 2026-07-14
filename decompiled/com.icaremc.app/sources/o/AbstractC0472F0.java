package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import i.AbstractC0357a;

/* renamed from: o.F0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0472F0 extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    public boolean f5442f;

    /* renamed from: g, reason: collision with root package name */
    public int f5443g;

    /* renamed from: h, reason: collision with root package name */
    public int f5444h;

    /* renamed from: i, reason: collision with root package name */
    public int f5445i;

    /* renamed from: j, reason: collision with root package name */
    public int f5446j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public float f5447l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5448m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f5449n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f5450o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f5451p;

    /* renamed from: q, reason: collision with root package name */
    public int f5452q;

    /* renamed from: r, reason: collision with root package name */
    public int f5453r;

    /* renamed from: s, reason: collision with root package name */
    public int f5454s;

    /* renamed from: t, reason: collision with root package name */
    public int f5455t;

    public AbstractC0472F0(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5442f = true;
        this.f5443g = -1;
        this.f5444h = 0;
        this.f5446j = 8388659;
        int[] iArr = AbstractC0357a.f4078n;
        A2.t P = A2.t.P(context, attributeSet, iArr, i4);
        I.T.h(this, context, iArr, attributeSet, (TypedArray) P.f100h, i4);
        TypedArray typedArray = (TypedArray) P.f100h;
        int i5 = typedArray.getInt(1, -1);
        if (i5 >= 0) {
            setOrientation(i5);
        }
        int i6 = typedArray.getInt(0, -1);
        if (i6 >= 0) {
            setGravity(i6);
        }
        boolean z = typedArray.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f5447l = typedArray.getFloat(4, -1.0f);
        this.f5443g = typedArray.getInt(3, -1);
        this.f5448m = typedArray.getBoolean(7, false);
        setDividerDrawable(P.H(5));
        this.f5454s = typedArray.getInt(8, 0);
        this.f5455t = typedArray.getDimensionPixelSize(6, 0);
        P.T();
    }

    public final void c(Canvas canvas, int i4) {
        this.f5451p.setBounds(getPaddingLeft() + this.f5455t, i4, (getWidth() - getPaddingRight()) - this.f5455t, this.f5453r + i4);
        this.f5451p.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0470E0;
    }

    public final void d(Canvas canvas, int i4) {
        this.f5451p.setBounds(i4, getPaddingTop() + this.f5455t, this.f5452q + i4, (getHeight() - getPaddingBottom()) - this.f5455t);
        this.f5451p.draw(canvas);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [o.E0, android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [o.E0, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0470E0 generateDefaultLayoutParams() {
        int i4 = this.f5445i;
        if (i4 == 0) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        if (i4 == 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [o.E0, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0470E0 generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [o.E0, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0470E0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LinearLayout.LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i4;
        if (this.f5443g < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i5 = this.f5443g;
        if (childCount > i5) {
            View childAt = getChildAt(i5);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f5443g == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i6 = this.f5444h;
            if (this.f5445i == 1 && (i4 = this.f5446j & 112) != 48) {
                if (i4 != 16) {
                    if (i4 == 80) {
                        i6 = ((getBottom() - getTop()) - getPaddingBottom()) - this.k;
                    }
                } else {
                    i6 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.k) / 2;
                }
            }
            return i6 + ((LinearLayout.LayoutParams) ((C0470E0) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f5443g;
    }

    public Drawable getDividerDrawable() {
        return this.f5451p;
    }

    public int getDividerPadding() {
        return this.f5455t;
    }

    public int getDividerWidth() {
        return this.f5452q;
    }

    public int getGravity() {
        return this.f5446j;
    }

    public int getOrientation() {
        return this.f5445i;
    }

    public int getShowDividers() {
        return this.f5454s;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f5447l;
    }

    public final boolean h(int i4) {
        if (i4 == 0) {
            if ((this.f5454s & 1) == 0) {
                return false;
            }
            return true;
        }
        if (i4 == getChildCount()) {
            if ((this.f5454s & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.f5454s & 2) != 0) {
            for (int i5 = i4 - 1; i5 >= 0; i5--) {
                if (getChildAt(i5).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i4;
        int left2;
        int bottom;
        if (this.f5451p != null) {
            int i5 = 0;
            if (this.f5445i == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i5 < virtualChildCount) {
                    View childAt = getChildAt(i5);
                    if (childAt != null && childAt.getVisibility() != 8 && h(i5)) {
                        c(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((C0470E0) childAt.getLayoutParams())).topMargin) - this.f5453r);
                    }
                    i5++;
                }
                if (h(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        bottom = (getHeight() - getPaddingBottom()) - this.f5453r;
                    } else {
                        bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((C0470E0) childAt2.getLayoutParams())).bottomMargin;
                    }
                    c(canvas, bottom);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean a4 = E1.a(this);
            while (i5 < virtualChildCount2) {
                View childAt3 = getChildAt(i5);
                if (childAt3 != null && childAt3.getVisibility() != 8 && h(i5)) {
                    C0470E0 c0470e0 = (C0470E0) childAt3.getLayoutParams();
                    if (a4) {
                        left2 = childAt3.getRight() + ((LinearLayout.LayoutParams) c0470e0).rightMargin;
                    } else {
                        left2 = (childAt3.getLeft() - ((LinearLayout.LayoutParams) c0470e0).leftMargin) - this.f5452q;
                    }
                    d(canvas, left2);
                }
                i5++;
            }
            if (h(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 == null) {
                    if (a4) {
                        right = getPaddingLeft();
                    } else {
                        left = getWidth() - getPaddingRight();
                        i4 = this.f5452q;
                        right = left - i4;
                    }
                } else {
                    C0470E0 c0470e02 = (C0470E0) childAt4.getLayoutParams();
                    if (a4) {
                        left = childAt4.getLeft() - ((LinearLayout.LayoutParams) c0470e02).leftMargin;
                        i4 = this.f5452q;
                        right = left - i4;
                    } else {
                        right = childAt4.getRight() + ((LinearLayout.LayoutParams) c0470e02).rightMargin;
                    }
                }
                d(canvas, right);
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.AbstractC0472F0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.AbstractC0472F0.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.f5442f = z;
    }

    public void setBaselineAlignedChildIndex(int i4) {
        if (i4 >= 0 && i4 < getChildCount()) {
            this.f5443g = i4;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f5451p) {
            return;
        }
        this.f5451p = drawable;
        boolean z = false;
        if (drawable != null) {
            this.f5452q = drawable.getIntrinsicWidth();
            this.f5453r = drawable.getIntrinsicHeight();
        } else {
            this.f5452q = 0;
            this.f5453r = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    public void setDividerPadding(int i4) {
        this.f5455t = i4;
    }

    public void setGravity(int i4) {
        if (this.f5446j != i4) {
            if ((8388615 & i4) == 0) {
                i4 |= 8388611;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            this.f5446j = i4;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i4) {
        int i5 = i4 & 8388615;
        int i6 = this.f5446j;
        if ((8388615 & i6) != i5) {
            this.f5446j = i5 | ((-8388616) & i6);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f5448m = z;
    }

    public void setOrientation(int i4) {
        if (this.f5445i != i4) {
            this.f5445i = i4;
            requestLayout();
        }
    }

    public void setShowDividers(int i4) {
        if (i4 != this.f5454s) {
            requestLayout();
        }
        this.f5454s = i4;
    }

    public void setVerticalGravity(int i4) {
        int i5 = i4 & 112;
        int i6 = this.f5446j;
        if ((i6 & 112) != i5) {
            this.f5446j = i5 | (i6 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f4) {
        this.f5447l = Math.max(0.0f, f4);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
