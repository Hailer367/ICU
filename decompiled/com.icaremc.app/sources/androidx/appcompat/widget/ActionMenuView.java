package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import n.D;
import n.l;
import n.m;
import n.n;
import n.p;
import n.q;
import o.AbstractC0472F0;
import o.C0470E0;
import o.C0515f;
import o.C0521i;
import o.C0523j;
import o.C0527l;
import o.E1;
import o.InterfaceC0525k;
import o.InterfaceC0529m;

/* loaded from: classes.dex */
public class ActionMenuView extends AbstractC0472F0 implements m, D {

    /* renamed from: A, reason: collision with root package name */
    public l f2344A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f2345B;

    /* renamed from: C, reason: collision with root package name */
    public int f2346C;

    /* renamed from: D, reason: collision with root package name */
    public final int f2347D;

    /* renamed from: E, reason: collision with root package name */
    public final int f2348E;

    /* renamed from: F, reason: collision with root package name */
    public InterfaceC0529m f2349F;

    /* renamed from: u, reason: collision with root package name */
    public n f2350u;

    /* renamed from: v, reason: collision with root package name */
    public Context f2351v;

    /* renamed from: w, reason: collision with root package name */
    public int f2352w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2353x;

    /* renamed from: y, reason: collision with root package name */
    public C0523j f2354y;
    public Z0.D z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f2347D = (int) (56.0f * f4);
        this.f2348E = (int) (f4 * 4.0f);
        this.f2351v = context;
        this.f2352w = 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout$LayoutParams, o.l] */
    public static C0527l i() {
        ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.f5636a = false;
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.LinearLayout$LayoutParams, o.l] */
    public static C0527l j(ViewGroup.LayoutParams layoutParams) {
        C0527l c0527l;
        if (layoutParams != null) {
            if (layoutParams instanceof C0527l) {
                C0527l c0527l2 = (C0527l) layoutParams;
                ?? layoutParams2 = new LinearLayout.LayoutParams((ViewGroup.LayoutParams) c0527l2);
                layoutParams2.f5636a = c0527l2.f5636a;
                c0527l = layoutParams2;
            } else {
                c0527l = new LinearLayout.LayoutParams(layoutParams);
            }
            if (((LinearLayout.LayoutParams) c0527l).gravity <= 0) {
                ((LinearLayout.LayoutParams) c0527l).gravity = 16;
            }
            return c0527l;
        }
        return i();
    }

    @Override // n.D
    public final void a(n nVar) {
        this.f2350u = nVar;
    }

    @Override // n.m
    public final boolean b(q qVar) {
        return this.f2350u.q(qVar, null, 0);
    }

    @Override // o.AbstractC0472F0, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0527l;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // o.AbstractC0472F0
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ C0470E0 generateDefaultLayoutParams() {
        return i();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [o.E0, android.widget.LinearLayout$LayoutParams] */
    @Override // o.AbstractC0472F0
    /* renamed from: f */
    public final C0470E0 generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    @Override // o.AbstractC0472F0
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ C0470E0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    @Override // o.AbstractC0472F0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return i();
    }

    @Override // o.AbstractC0472F0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Menu getMenu() {
        if (this.f2350u == null) {
            Context context = getContext();
            n nVar = new n(context);
            this.f2350u = nVar;
            nVar.f5298e = new p(1, this);
            C0523j c0523j = new C0523j(context);
            this.f2354y = c0523j;
            c0523j.f5611q = true;
            c0523j.f5612r = true;
            Z0.D d4 = this.z;
            Z0.D d5 = d4;
            if (d4 == null) {
                d5 = new Object();
            }
            c0523j.f5605j = d5;
            this.f2350u.b(c0523j, this.f2351v);
            C0523j c0523j2 = this.f2354y;
            c0523j2.f5607m = this;
            this.f2350u = c0523j2.f5603h;
        }
        return this.f2350u;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        C0523j c0523j = this.f2354y;
        C0521i c0521i = c0523j.f5608n;
        if (c0521i != null) {
            return c0521i.getDrawable();
        }
        if (c0523j.f5610p) {
            return c0523j.f5609o;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f2352w;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final boolean k(int i4) {
        boolean z = false;
        if (i4 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i4 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i4);
        if (i4 < getChildCount() && (childAt instanceof InterfaceC0525k)) {
            z = ((InterfaceC0525k) childAt).b();
        }
        if (i4 > 0 && (childAt2 instanceof InterfaceC0525k)) {
            return ((InterfaceC0525k) childAt2).c() | z;
        }
        return z;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0523j c0523j = this.f2354y;
        if (c0523j != null) {
            c0523j.d();
            if (this.f2354y.f()) {
                this.f2354y.c();
                this.f2354y.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0523j c0523j = this.f2354y;
        if (c0523j != null) {
            c0523j.c();
            C0515f c0515f = c0523j.f5619y;
            if (c0515f != null && c0515f.b()) {
                c0515f.f5369i.dismiss();
            }
        }
    }

    @Override // o.AbstractC0472F0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int width;
        int i9;
        if (!this.f2345B) {
            super.onLayout(z, i4, i5, i6, i7);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i7 - i5) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = i6 - i4;
        int paddingRight = (i11 - getPaddingRight()) - getPaddingLeft();
        boolean a4 = E1.a(this);
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                C0527l c0527l = (C0527l) childAt.getLayoutParams();
                if (c0527l.f5636a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (k(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a4) {
                        i9 = getPaddingLeft() + ((LinearLayout.LayoutParams) c0527l).leftMargin;
                        width = i9 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c0527l).rightMargin;
                        i9 = width - measuredWidth;
                    }
                    int i15 = i10 - (measuredHeight / 2);
                    childAt.layout(i9, i15, width, measuredHeight + i15);
                    paddingRight -= measuredWidth;
                    i12 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c0527l).leftMargin) + ((LinearLayout.LayoutParams) c0527l).rightMargin;
                    k(i14);
                    i13++;
                }
            }
        }
        if (childCount == 1 && i12 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i16 = (i11 / 2) - (measuredWidth2 / 2);
            int i17 = i10 - (measuredHeight2 / 2);
            childAt2.layout(i16, i17, measuredWidth2 + i16, measuredHeight2 + i17);
            return;
        }
        int i18 = i13 - (i12 ^ 1);
        if (i18 > 0) {
            i8 = paddingRight / i18;
        } else {
            i8 = 0;
        }
        int max = Math.max(0, i8);
        if (a4) {
            int width2 = getWidth() - getPaddingRight();
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt3 = getChildAt(i19);
                C0527l c0527l2 = (C0527l) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0527l2.f5636a) {
                    int i20 = width2 - ((LinearLayout.LayoutParams) c0527l2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i21 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i20 - measuredWidth3, i21, i20, measuredHeight3 + i21);
                    width2 = i20 - ((measuredWidth3 + ((LinearLayout.LayoutParams) c0527l2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt4 = getChildAt(i22);
            C0527l c0527l3 = (C0527l) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0527l3.f5636a) {
                int i23 = paddingLeft + ((LinearLayout.LayoutParams) c0527l3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i24 = i10 - (measuredHeight4 / 2);
                childAt4.layout(i23, i24, i23 + measuredWidth4, measuredHeight4 + i24);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) c0527l3).rightMargin + max + i23;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // o.AbstractC0472F0, android.view.View
    public final void onMeasure(int i4, int i5) {
        boolean z;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        int i8;
        int i9;
        ?? r11;
        boolean z5;
        int i10;
        int i11;
        ActionMenuItemView actionMenuItemView;
        boolean z6;
        int i12;
        boolean z7;
        n nVar;
        boolean z8 = this.f2345B;
        if (View.MeasureSpec.getMode(i4) == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        this.f2345B = z;
        if (z8 != z) {
            this.f2346C = 0;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (this.f2345B && (nVar = this.f2350u) != null && size != this.f2346C) {
            this.f2346C = size;
            nVar.p(true);
        }
        int childCount = getChildCount();
        if (this.f2345B && childCount > 0) {
            int mode = View.MeasureSpec.getMode(i5);
            int size2 = View.MeasureSpec.getSize(i4);
            int size3 = View.MeasureSpec.getSize(i5);
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, paddingBottom, -2);
            int i13 = size2 - paddingRight;
            int i14 = this.f2347D;
            int i15 = i13 / i14;
            int i16 = i13 % i14;
            if (i15 == 0) {
                setMeasuredDimension(i13, 0);
                return;
            }
            int i17 = (i16 / i15) + i14;
            int childCount2 = getChildCount();
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            boolean z9 = false;
            int i22 = 0;
            long j4 = 0;
            while (true) {
                i6 = this.f2348E;
                if (i21 >= childCount2) {
                    break;
                }
                View childAt = getChildAt(i21);
                int i23 = size3;
                int i24 = paddingBottom;
                if (childAt.getVisibility() == 8) {
                    i11 = i17;
                } else {
                    boolean z10 = childAt instanceof ActionMenuItemView;
                    i19++;
                    if (z10) {
                        childAt.setPadding(i6, 0, i6, 0);
                    }
                    C0527l c0527l = (C0527l) childAt.getLayoutParams();
                    c0527l.f5641f = false;
                    c0527l.f5638c = 0;
                    c0527l.f5637b = 0;
                    c0527l.f5639d = false;
                    ((LinearLayout.LayoutParams) c0527l).leftMargin = 0;
                    ((LinearLayout.LayoutParams) c0527l).rightMargin = 0;
                    if (z10 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText())) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    c0527l.f5640e = z5;
                    if (c0527l.f5636a) {
                        i10 = 1;
                    } else {
                        i10 = i15;
                    }
                    C0527l c0527l2 = (C0527l) childAt.getLayoutParams();
                    int i25 = i15;
                    i11 = i17;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i24, View.MeasureSpec.getMode(childMeasureSpec));
                    if (z10) {
                        actionMenuItemView = (ActionMenuItemView) childAt;
                    } else {
                        actionMenuItemView = null;
                    }
                    if (actionMenuItemView != null && !TextUtils.isEmpty(actionMenuItemView.getText())) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean z11 = z6;
                    if (i10 > 0 && (!z6 || i10 >= 2)) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), makeMeasureSpec);
                        int measuredWidth = childAt.getMeasuredWidth();
                        i12 = measuredWidth / i11;
                        if (measuredWidth % i11 != 0) {
                            i12++;
                        }
                        if (z11 && i12 < 2) {
                            i12 = 2;
                        }
                    } else {
                        i12 = 0;
                    }
                    if (!c0527l2.f5636a && z11) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    c0527l2.f5639d = z7;
                    c0527l2.f5637b = i12;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i12 * i11, 1073741824), makeMeasureSpec);
                    i20 = Math.max(i20, i12);
                    if (c0527l.f5639d) {
                        i22++;
                    }
                    if (c0527l.f5636a) {
                        z9 = true;
                    }
                    i15 = i25 - i12;
                    i18 = Math.max(i18, childAt.getMeasuredHeight());
                    if (i12 == 1) {
                        j4 |= 1 << i21;
                    }
                }
                i21++;
                size3 = i23;
                paddingBottom = i24;
                i17 = i11;
            }
            int i26 = size3;
            int i27 = i15;
            int i28 = i17;
            if (z9 && i19 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i29 = i27;
            boolean z12 = false;
            while (i22 > 0 && i29 > 0) {
                int i30 = Integer.MAX_VALUE;
                long j5 = 0;
                int i31 = 0;
                int i32 = 0;
                while (i32 < childCount2) {
                    int i33 = i18;
                    C0527l c0527l3 = (C0527l) getChildAt(i32).getLayoutParams();
                    boolean z13 = z3;
                    if (c0527l3.f5639d) {
                        int i34 = c0527l3.f5637b;
                        if (i34 < i30) {
                            j5 = 1 << i32;
                            i30 = i34;
                            i31 = 1;
                        } else if (i34 == i30) {
                            j5 |= 1 << i32;
                            i31++;
                        }
                    }
                    i32++;
                    z3 = z13;
                    i18 = i33;
                }
                i7 = i18;
                boolean z14 = z3;
                j4 |= j5;
                if (i31 > i29) {
                    break;
                }
                int i35 = i30 + 1;
                int i36 = 0;
                while (i36 < childCount2) {
                    View childAt2 = getChildAt(i36);
                    C0527l c0527l4 = (C0527l) childAt2.getLayoutParams();
                    boolean z15 = z9;
                    long j6 = 1 << i36;
                    if ((j5 & j6) == 0) {
                        if (c0527l4.f5637b == i35) {
                            j4 |= j6;
                        }
                    } else {
                        if (z14 && c0527l4.f5640e) {
                            r11 = 1;
                            r11 = 1;
                            if (i29 == 1) {
                                childAt2.setPadding(i6 + i28, 0, i6, 0);
                            }
                        } else {
                            r11 = 1;
                        }
                        c0527l4.f5637b += r11;
                        c0527l4.f5641f = r11;
                        i29--;
                    }
                    i36++;
                    z9 = z15;
                }
                z3 = z14;
                i18 = i7;
                z12 = true;
            }
            i7 = i18;
            if (!z9 && i19 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (i29 > 0 && j4 != 0 && (i29 < i19 - 1 || z4 || i20 > 1)) {
                float bitCount = Long.bitCount(j4);
                if (!z4) {
                    if ((j4 & 1) != 0 && !((C0527l) getChildAt(0).getLayoutParams()).f5640e) {
                        bitCount -= 0.5f;
                    }
                    int i37 = childCount2 - 1;
                    if ((j4 & (1 << i37)) != 0 && !((C0527l) getChildAt(i37).getLayoutParams()).f5640e) {
                        bitCount -= 0.5f;
                    }
                }
                if (bitCount > 0.0f) {
                    i9 = (int) ((i29 * i28) / bitCount);
                } else {
                    i9 = 0;
                }
                boolean z16 = z12;
                for (int i38 = 0; i38 < childCount2; i38++) {
                    if ((j4 & (1 << i38)) != 0) {
                        View childAt3 = getChildAt(i38);
                        C0527l c0527l5 = (C0527l) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            c0527l5.f5638c = i9;
                            c0527l5.f5641f = true;
                            if (i38 == 0 && !c0527l5.f5640e) {
                                ((LinearLayout.LayoutParams) c0527l5).leftMargin = (-i9) / 2;
                            }
                            z16 = true;
                        } else if (c0527l5.f5636a) {
                            c0527l5.f5638c = i9;
                            c0527l5.f5641f = true;
                            ((LinearLayout.LayoutParams) c0527l5).rightMargin = (-i9) / 2;
                            z16 = true;
                        } else {
                            if (i38 != 0) {
                                ((LinearLayout.LayoutParams) c0527l5).leftMargin = i9 / 2;
                            }
                            if (i38 != childCount2 - 1) {
                                ((LinearLayout.LayoutParams) c0527l5).rightMargin = i9 / 2;
                            }
                        }
                    }
                }
                z12 = z16;
            }
            if (z12) {
                for (int i39 = 0; i39 < childCount2; i39++) {
                    View childAt4 = getChildAt(i39);
                    C0527l c0527l6 = (C0527l) childAt4.getLayoutParams();
                    if (c0527l6.f5641f) {
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((c0527l6.f5637b * i28) + c0527l6.f5638c, 1073741824), childMeasureSpec);
                    }
                }
            }
            if (mode != 1073741824) {
                i8 = i7;
            } else {
                i8 = i26;
            }
            setMeasuredDimension(i13, i8);
            return;
        }
        for (int i40 = 0; i40 < childCount; i40++) {
            C0527l c0527l7 = (C0527l) getChildAt(i40).getLayoutParams();
            ((LinearLayout.LayoutParams) c0527l7).rightMargin = 0;
            ((LinearLayout.LayoutParams) c0527l7).leftMargin = 0;
        }
        super.onMeasure(i4, i5);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f2354y.f5616v = z;
    }

    public void setOnMenuItemClickListener(InterfaceC0529m interfaceC0529m) {
        this.f2349F = interfaceC0529m;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        C0523j c0523j = this.f2354y;
        C0521i c0521i = c0523j.f5608n;
        if (c0521i != null) {
            c0521i.setImageDrawable(drawable);
        } else {
            c0523j.f5610p = true;
            c0523j.f5609o = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.f2353x = z;
    }

    public void setPopupTheme(int i4) {
        if (this.f2352w != i4) {
            this.f2352w = i4;
            if (i4 == 0) {
                this.f2351v = getContext();
            } else {
                this.f2351v = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setPresenter(C0523j c0523j) {
        this.f2354y = c0523j;
        c0523j.f5607m = this;
        this.f2350u = c0523j.f5603h;
    }

    @Override // o.AbstractC0472F0, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }
}
