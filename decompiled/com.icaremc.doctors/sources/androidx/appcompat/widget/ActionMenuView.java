package androidx.appcompat.widget;

import A0.f;
import F.h;
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
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.google.android.gms.common.api.Api;
import l.i;
import l.j;
import l.k;
import m.AbstractC0252E;
import m.C0251D;
import m.C0258e;
import m.C0260g;
import m.C0261h;
import m.C0263j;
import m.InterfaceC0262i;
import m.InterfaceC0264k;
import m.u0;

/* loaded from: classes.dex */
public class ActionMenuView extends AbstractC0252E implements i {

    /* renamed from: r, reason: collision with root package name */
    public j f1125r;

    /* renamed from: s, reason: collision with root package name */
    public Context f1126s;

    /* renamed from: t, reason: collision with root package name */
    public int f1127t;

    /* renamed from: u, reason: collision with root package name */
    public C0261h f1128u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1129v;

    /* renamed from: w, reason: collision with root package name */
    public int f1130w;

    /* renamed from: x, reason: collision with root package name */
    public final int f1131x;
    public final int y;
    public InterfaceC0264k z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f1131x = (int) (56.0f * f2);
        this.y = (int) (f2 * 4.0f);
        this.f1126s = context;
        this.f1127t = 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m.D, m.j] */
    public static C0263j h() {
        ?? c0251d = new C0251D(-2);
        c0251d.f3175c = false;
        c0251d.f3044b = 16;
        return c0251d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [m.D, m.j] */
    public static C0263j i(ViewGroup.LayoutParams layoutParams) {
        C0263j c0263j;
        if (layoutParams != null) {
            if (layoutParams instanceof C0263j) {
                C0263j c0263j2 = (C0263j) layoutParams;
                ?? c0251d = new C0251D(c0263j2);
                c0251d.f3175c = c0263j2.f3175c;
                c0263j = c0251d;
            } else {
                c0263j = new C0251D(layoutParams);
            }
            if (c0263j.f3044b <= 0) {
                c0263j.f3044b = 16;
            }
            return c0263j;
        }
        return h();
    }

    @Override // l.i
    public final boolean a(k kVar) {
        return this.f1125r.p(kVar, null, 0);
    }

    @Override // m.AbstractC0252E, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0263j;
    }

    @Override // m.AbstractC0252E
    /* renamed from: d */
    public final /* bridge */ /* synthetic */ C0251D generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // m.AbstractC0252E
    /* renamed from: e */
    public final C0251D generateLayoutParams(AttributeSet attributeSet) {
        return new C0251D(getContext(), attributeSet);
    }

    @Override // m.AbstractC0252E
    /* renamed from: f */
    public final /* bridge */ /* synthetic */ C0251D generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    @Override // m.AbstractC0252E, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // m.AbstractC0252E, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public Menu getMenu() {
        if (this.f1125r == null) {
            Context context = getContext();
            j jVar = new j(context);
            this.f1125r = jVar;
            jVar.f2845e = new h(14, this);
            C0261h c0261h = new C0261h(context);
            this.f1128u = c0261h;
            c0261h.f3161m = true;
            c0261h.f3162n = true;
            c0261h.f3155g = new f(19);
            this.f1125r.b(c0261h, this.f1126s);
            C0261h c0261h2 = this.f1128u;
            c0261h2.f3157i = this;
            this.f1125r = c0261h2.f3153e;
        }
        return this.f1125r;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        C0261h c0261h = this.f1128u;
        C0260g c0260g = c0261h.f3158j;
        if (c0260g != null) {
            return c0260g.getDrawable();
        }
        if (c0261h.f3160l) {
            return c0261h.f3159k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f1127t;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final boolean j(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i2 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof InterfaceC0262i)) {
            z = ((InterfaceC0262i) childAt).a();
        }
        if (i2 > 0 && (childAt2 instanceof InterfaceC0262i)) {
            return ((InterfaceC0262i) childAt2).c() | z;
        }
        return z;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0261h c0261h = this.f1128u;
        if (c0261h != null) {
            c0261h.b();
            C0258e c0258e = this.f1128u.f3166t;
            if (c0258e != null && c0258e.b()) {
                this.f1128u.i();
                this.f1128u.k();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0261h c0261h = this.f1128u;
        if (c0261h != null) {
            c0261h.i();
            C0258e c0258e = c0261h.f3167u;
            if (c0258e != null && c0258e.b()) {
                c0258e.f2893i.dismiss();
            }
        }
    }

    @Override // m.AbstractC0252E, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        if (!this.f1129v) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i4 - i2;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = u0.a(this);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                C0263j c0263j = (C0263j) childAt.getLayoutParams();
                if (c0263j.f3175c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (j(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i7 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0263j).leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0263j).rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i13, width, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0263j).leftMargin) + ((ViewGroup.MarginLayoutParams) c0263j).rightMargin;
                    j(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        if (i16 > 0) {
            i6 = paddingRight / i16;
        } else {
            i6 = 0;
        }
        int max = Math.max(0, i6);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                C0263j c0263j2 = (C0263j) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0263j2.f3175c) {
                    int i18 = width2 - ((ViewGroup.MarginLayoutParams) c0263j2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) c0263j2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt4 = getChildAt(i20);
            C0263j c0263j3 = (C0263j) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0263j3.f3175c) {
                int i21 = paddingLeft + ((ViewGroup.MarginLayoutParams) c0263j3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = measuredWidth4 + ((ViewGroup.MarginLayoutParams) c0263j3).rightMargin + max + i21;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // m.AbstractC0252E, android.view.View
    public final void onMeasure(int i2, int i3) {
        boolean z;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        ?? r11;
        boolean z4;
        int i8;
        int i9;
        ActionMenuItemView actionMenuItemView;
        boolean z5;
        int i10;
        boolean z6;
        j jVar;
        boolean z7 = this.f1129v;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        this.f1129v = z;
        if (z7 != z) {
            this.f1130w = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.f1129v && (jVar = this.f1125r) != null && size != this.f1130w) {
            this.f1130w = size;
            jVar.o(true);
        }
        int childCount = getChildCount();
        if (this.f1129v && childCount > 0) {
            int mode = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i2);
            int size3 = View.MeasureSpec.getSize(i3);
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
            int i11 = size2 - paddingRight;
            int i12 = this.f1131x;
            int i13 = i11 / i12;
            int i14 = i11 % i12;
            if (i13 == 0) {
                setMeasuredDimension(i11, 0);
                return;
            }
            int i15 = (i14 / i13) + i12;
            int childCount2 = getChildCount();
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            boolean z8 = false;
            int i20 = 0;
            long j2 = 0;
            while (true) {
                i4 = this.y;
                if (i19 >= childCount2) {
                    break;
                }
                View childAt = getChildAt(i19);
                int i21 = size3;
                int i22 = paddingBottom;
                if (childAt.getVisibility() == 8) {
                    i9 = i15;
                } else {
                    boolean z9 = childAt instanceof ActionMenuItemView;
                    i17++;
                    if (z9) {
                        childAt.setPadding(i4, 0, i4, 0);
                    }
                    C0263j c0263j = (C0263j) childAt.getLayoutParams();
                    c0263j.f3180h = false;
                    c0263j.f3177e = 0;
                    c0263j.f3176d = 0;
                    c0263j.f3178f = false;
                    ((ViewGroup.MarginLayoutParams) c0263j).leftMargin = 0;
                    ((ViewGroup.MarginLayoutParams) c0263j).rightMargin = 0;
                    if (z9 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText())) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    c0263j.f3179g = z4;
                    if (c0263j.f3175c) {
                        i8 = 1;
                    } else {
                        i8 = i13;
                    }
                    C0263j c0263j2 = (C0263j) childAt.getLayoutParams();
                    int i23 = i13;
                    i9 = i15;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i22, View.MeasureSpec.getMode(childMeasureSpec));
                    if (z9) {
                        actionMenuItemView = (ActionMenuItemView) childAt;
                    } else {
                        actionMenuItemView = null;
                    }
                    if (actionMenuItemView != null && !TextUtils.isEmpty(actionMenuItemView.getText())) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean z10 = z5;
                    if (i8 > 0 && (!z5 || i8 >= 2)) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i9 * i8, Integer.MIN_VALUE), makeMeasureSpec);
                        int measuredWidth = childAt.getMeasuredWidth();
                        i10 = measuredWidth / i9;
                        if (measuredWidth % i9 != 0) {
                            i10++;
                        }
                        if (z10 && i10 < 2) {
                            i10 = 2;
                        }
                    } else {
                        i10 = 0;
                    }
                    if (!c0263j2.f3175c && z10) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    c0263j2.f3178f = z6;
                    c0263j2.f3176d = i10;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i10 * i9, 1073741824), makeMeasureSpec);
                    i18 = Math.max(i18, i10);
                    if (c0263j.f3178f) {
                        i20++;
                    }
                    if (c0263j.f3175c) {
                        z8 = true;
                    }
                    i13 = i23 - i10;
                    i16 = Math.max(i16, childAt.getMeasuredHeight());
                    if (i10 == 1) {
                        j2 |= 1 << i19;
                    }
                }
                i19++;
                size3 = i21;
                paddingBottom = i22;
                i15 = i9;
            }
            int i24 = size3;
            int i25 = i13;
            int i26 = i15;
            if (z8 && i17 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i27 = i25;
            boolean z11 = false;
            while (i20 > 0 && i27 > 0) {
                int i28 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                long j3 = 0;
                int i29 = 0;
                int i30 = 0;
                while (i30 < childCount2) {
                    int i31 = i16;
                    C0263j c0263j3 = (C0263j) getChildAt(i30).getLayoutParams();
                    boolean z12 = z2;
                    if (c0263j3.f3178f) {
                        int i32 = c0263j3.f3176d;
                        if (i32 < i28) {
                            j3 = 1 << i30;
                            i28 = i32;
                            i29 = 1;
                        } else if (i32 == i28) {
                            j3 |= 1 << i30;
                            i29++;
                        }
                    }
                    i30++;
                    z2 = z12;
                    i16 = i31;
                }
                i5 = i16;
                boolean z13 = z2;
                j2 |= j3;
                if (i29 > i27) {
                    break;
                }
                int i33 = i28 + 1;
                int i34 = 0;
                while (i34 < childCount2) {
                    View childAt2 = getChildAt(i34);
                    C0263j c0263j4 = (C0263j) childAt2.getLayoutParams();
                    boolean z14 = z8;
                    long j4 = 1 << i34;
                    if ((j3 & j4) == 0) {
                        if (c0263j4.f3176d == i33) {
                            j2 |= j4;
                        }
                    } else {
                        if (z13 && c0263j4.f3179g) {
                            r11 = 1;
                            r11 = 1;
                            if (i27 == 1) {
                                childAt2.setPadding(i4 + i26, 0, i4, 0);
                            }
                        } else {
                            r11 = 1;
                        }
                        c0263j4.f3176d += r11;
                        c0263j4.f3180h = r11;
                        i27--;
                    }
                    i34++;
                    z8 = z14;
                }
                z2 = z13;
                i16 = i5;
                z11 = true;
            }
            i5 = i16;
            if (!z8 && i17 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (i27 > 0 && j2 != 0 && (i27 < i17 - 1 || z3 || i18 > 1)) {
                float bitCount = Long.bitCount(j2);
                if (!z3) {
                    if ((j2 & 1) != 0 && !((C0263j) getChildAt(0).getLayoutParams()).f3179g) {
                        bitCount -= 0.5f;
                    }
                    int i35 = childCount2 - 1;
                    if ((j2 & (1 << i35)) != 0 && !((C0263j) getChildAt(i35).getLayoutParams()).f3179g) {
                        bitCount -= 0.5f;
                    }
                }
                if (bitCount > 0.0f) {
                    i7 = (int) ((i27 * i26) / bitCount);
                } else {
                    i7 = 0;
                }
                boolean z15 = z11;
                for (int i36 = 0; i36 < childCount2; i36++) {
                    if ((j2 & (1 << i36)) != 0) {
                        View childAt3 = getChildAt(i36);
                        C0263j c0263j5 = (C0263j) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            c0263j5.f3177e = i7;
                            c0263j5.f3180h = true;
                            if (i36 == 0 && !c0263j5.f3179g) {
                                ((ViewGroup.MarginLayoutParams) c0263j5).leftMargin = (-i7) / 2;
                            }
                            z15 = true;
                        } else if (c0263j5.f3175c) {
                            c0263j5.f3177e = i7;
                            c0263j5.f3180h = true;
                            ((ViewGroup.MarginLayoutParams) c0263j5).rightMargin = (-i7) / 2;
                            z15 = true;
                        } else {
                            if (i36 != 0) {
                                ((ViewGroup.MarginLayoutParams) c0263j5).leftMargin = i7 / 2;
                            }
                            if (i36 != childCount2 - 1) {
                                ((ViewGroup.MarginLayoutParams) c0263j5).rightMargin = i7 / 2;
                            }
                        }
                    }
                }
                z11 = z15;
            }
            if (z11) {
                for (int i37 = 0; i37 < childCount2; i37++) {
                    View childAt4 = getChildAt(i37);
                    C0263j c0263j6 = (C0263j) childAt4.getLayoutParams();
                    if (c0263j6.f3180h) {
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((c0263j6.f3176d * i26) + c0263j6.f3177e, 1073741824), childMeasureSpec);
                    }
                }
            }
            if (mode != 1073741824) {
                i6 = i5;
            } else {
                i6 = i24;
            }
            setMeasuredDimension(i11, i6);
            return;
        }
        for (int i38 = 0; i38 < childCount; i38++) {
            C0263j c0263j7 = (C0263j) getChildAt(i38).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) c0263j7).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) c0263j7).leftMargin = 0;
        }
        super.onMeasure(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1128u.f3164r = z;
    }

    public void setOnMenuItemClickListener(InterfaceC0264k interfaceC0264k) {
        this.z = interfaceC0264k;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        C0261h c0261h = this.f1128u;
        C0260g c0260g = c0261h.f3158j;
        if (c0260g != null) {
            c0260g.setImageDrawable(drawable);
        } else {
            c0261h.f3160l = true;
            c0261h.f3159k = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
    }

    public void setPopupTheme(int i2) {
        if (this.f1127t != i2) {
            this.f1127t = i2;
            if (i2 == 0) {
                this.f1126s = getContext();
            } else {
                this.f1126s = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(C0261h c0261h) {
        this.f1128u = c0261h;
        c0261h.f3157i = this;
        this.f1125r = c0261h.f3153e;
    }

    @Override // m.AbstractC0252E, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0251D(getContext(), attributeSet);
    }
}
