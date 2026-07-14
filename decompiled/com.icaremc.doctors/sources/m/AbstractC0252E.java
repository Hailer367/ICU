package m;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import h.AbstractC0201a;

/* renamed from: m.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0252E extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public boolean f3045c;

    /* renamed from: d, reason: collision with root package name */
    public int f3046d;

    /* renamed from: e, reason: collision with root package name */
    public int f3047e;

    /* renamed from: f, reason: collision with root package name */
    public int f3048f;

    /* renamed from: g, reason: collision with root package name */
    public int f3049g;

    /* renamed from: h, reason: collision with root package name */
    public int f3050h;

    /* renamed from: i, reason: collision with root package name */
    public float f3051i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3052j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f3053k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f3054l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f3055m;

    /* renamed from: n, reason: collision with root package name */
    public int f3056n;

    /* renamed from: o, reason: collision with root package name */
    public int f3057o;
    public int p;
    public int q;

    public AbstractC0252E(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3045c = true;
        this.f3046d = -1;
        this.f3047e = 0;
        this.f3049g = 8388659;
        A0.g i3 = A0.g.i(context, attributeSet, AbstractC0201a.f2306i, i2);
        TypedArray typedArray = (TypedArray) i3.f31e;
        int i4 = typedArray.getInt(1, -1);
        if (i4 >= 0) {
            setOrientation(i4);
        }
        int i5 = typedArray.getInt(0, -1);
        if (i5 >= 0) {
            setGravity(i5);
        }
        boolean z = typedArray.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f3051i = typedArray.getFloat(4, -1.0f);
        this.f3046d = typedArray.getInt(3, -1);
        this.f3052j = typedArray.getBoolean(7, false);
        setDividerDrawable(i3.e(5));
        this.p = typedArray.getInt(8, 0);
        this.q = typedArray.getDimensionPixelSize(6, 0);
        i3.k();
    }

    public final void b(Canvas canvas, int i2) {
        this.f3055m.setBounds(getPaddingLeft() + this.q, i2, (getWidth() - getPaddingRight()) - this.q, this.f3057o + i2);
        this.f3055m.draw(canvas);
    }

    public final void c(Canvas canvas, int i2) {
        this.f3055m.setBounds(i2, getPaddingTop() + this.q, this.f3056n + i2, (getHeight() - getPaddingBottom()) - this.q);
        this.f3055m.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0251D;
    }

    @Override // android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0251D generateDefaultLayoutParams() {
        int i2 = this.f3048f;
        if (i2 == 0) {
            return new C0251D(-2);
        }
        if (i2 == 1) {
            return new C0251D(-1);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0251D generateLayoutParams(AttributeSet attributeSet) {
        return new C0251D(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0251D generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0251D(layoutParams);
    }

    public final boolean g(int i2) {
        if (i2 == 0) {
            if ((this.p & 1) == 0) {
                return false;
            }
            return true;
        }
        if (i2 == getChildCount()) {
            if ((this.p & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.p & 2) != 0) {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.f3046d < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f3046d;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f3046d == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i4 = this.f3047e;
            if (this.f3048f == 1 && (i2 = this.f3049g & 112) != 48) {
                if (i2 != 16) {
                    if (i2 == 80) {
                        i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f3050h;
                    }
                } else {
                    i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f3050h) / 2;
                }
            }
            return i4 + ((ViewGroup.MarginLayoutParams) ((C0251D) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f3046d;
    }

    public Drawable getDividerDrawable() {
        return this.f3055m;
    }

    public int getDividerPadding() {
        return this.q;
    }

    public int getDividerWidth() {
        return this.f3056n;
    }

    public int getGravity() {
        return this.f3049g;
    }

    public int getOrientation() {
        return this.f3048f;
    }

    public int getShowDividers() {
        return this.p;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f3051i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i2;
        int left2;
        int bottom;
        if (this.f3055m != null) {
            int i3 = 0;
            if (this.f3048f == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i3 < virtualChildCount) {
                    View childAt = getChildAt(i3);
                    if (childAt != null && childAt.getVisibility() != 8 && g(i3)) {
                        b(canvas, (childAt.getTop() - ((ViewGroup.MarginLayoutParams) ((C0251D) childAt.getLayoutParams())).topMargin) - this.f3057o);
                    }
                    i3++;
                }
                if (g(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        bottom = (getHeight() - getPaddingBottom()) - this.f3057o;
                    } else {
                        bottom = childAt2.getBottom() + ((ViewGroup.MarginLayoutParams) ((C0251D) childAt2.getLayoutParams())).bottomMargin;
                    }
                    b(canvas, bottom);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean a2 = u0.a(this);
            while (i3 < virtualChildCount2) {
                View childAt3 = getChildAt(i3);
                if (childAt3 != null && childAt3.getVisibility() != 8 && g(i3)) {
                    C0251D c0251d = (C0251D) childAt3.getLayoutParams();
                    if (a2) {
                        left2 = childAt3.getRight() + ((ViewGroup.MarginLayoutParams) c0251d).rightMargin;
                    } else {
                        left2 = (childAt3.getLeft() - ((ViewGroup.MarginLayoutParams) c0251d).leftMargin) - this.f3056n;
                    }
                    c(canvas, left2);
                }
                i3++;
            }
            if (g(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 == null) {
                    if (a2) {
                        right = getPaddingLeft();
                    } else {
                        left = getWidth() - getPaddingRight();
                        i2 = this.f3056n;
                        right = left - i2;
                    }
                } else {
                    C0251D c0251d2 = (C0251D) childAt4.getLayoutParams();
                    if (a2) {
                        left = childAt4.getLeft() - ((ViewGroup.MarginLayoutParams) c0251d2).leftMargin;
                        i2 = this.f3056n;
                        right = left - i2;
                    } else {
                        right = childAt4.getRight() + ((ViewGroup.MarginLayoutParams) c0251d2).rightMargin;
                    }
                }
                c(canvas, right);
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
        throw new UnsupportedOperationException("Method not decompiled: m.AbstractC0252E.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:221:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0527  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.AbstractC0252E.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.f3045c = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.f3046d = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f3055m) {
            return;
        }
        this.f3055m = drawable;
        boolean z = false;
        if (drawable != null) {
            this.f3056n = drawable.getIntrinsicWidth();
            this.f3057o = drawable.getIntrinsicHeight();
        } else {
            this.f3056n = 0;
            this.f3057o = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.q = i2;
    }

    public void setGravity(int i2) {
        if (this.f3049g != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f3049g = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f3049g;
        if ((8388615 & i4) != i3) {
            this.f3049g = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f3052j = z;
    }

    public void setOrientation(int i2) {
        if (this.f3048f != i2) {
            this.f3048f = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.p) {
            requestLayout();
        }
        this.p = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f3049g;
        if ((i4 & 112) != i3) {
            this.f3049g = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f3051i = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
