package androidx.appcompat.widget;

import A2.t;
import I.C0061o;
import I.InterfaceC0062p;
import I.T;
import Z0.D;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.H;
import com.icaremc.app.R;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import j.O;
import j.ViewOnClickListenerC0408c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import m.j;
import n.n;
import n.p;
import n.q;
import o.C0516f0;
import o.C0523j;
import o.C0551x;
import o.C0555z;
import o.E1;
import o.InterfaceC0538q0;
import o.W0;
import o.q1;
import o.r1;
import o.s1;
import o.t1;
import o.u1;
import o.v1;
import o.x1;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    public int f2450A;

    /* renamed from: B, reason: collision with root package name */
    public final int f2451B;

    /* renamed from: C, reason: collision with root package name */
    public CharSequence f2452C;

    /* renamed from: D, reason: collision with root package name */
    public CharSequence f2453D;

    /* renamed from: E, reason: collision with root package name */
    public ColorStateList f2454E;

    /* renamed from: F, reason: collision with root package name */
    public ColorStateList f2455F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f2456G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f2457H;

    /* renamed from: I, reason: collision with root package name */
    public final ArrayList f2458I;

    /* renamed from: J, reason: collision with root package name */
    public final ArrayList f2459J;

    /* renamed from: K, reason: collision with root package name */
    public final int[] f2460K;

    /* renamed from: L, reason: collision with root package name */
    public final C0061o f2461L;

    /* renamed from: M, reason: collision with root package name */
    public ArrayList f2462M;

    /* renamed from: N, reason: collision with root package name */
    public u1 f2463N;

    /* renamed from: O, reason: collision with root package name */
    public final p f2464O;
    public x1 P;

    /* renamed from: Q, reason: collision with root package name */
    public C0523j f2465Q;

    /* renamed from: R, reason: collision with root package name */
    public s1 f2466R;

    /* renamed from: S, reason: collision with root package name */
    public D f2467S;

    /* renamed from: T, reason: collision with root package name */
    public R1.c f2468T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f2469U;

    /* renamed from: V, reason: collision with root package name */
    public OnBackInvokedCallback f2470V;

    /* renamed from: W, reason: collision with root package name */
    public OnBackInvokedDispatcher f2471W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f2472a0;

    /* renamed from: b0, reason: collision with root package name */
    public final F.b f2473b0;

    /* renamed from: f, reason: collision with root package name */
    public ActionMenuView f2474f;

    /* renamed from: g, reason: collision with root package name */
    public C0516f0 f2475g;

    /* renamed from: h, reason: collision with root package name */
    public C0516f0 f2476h;

    /* renamed from: i, reason: collision with root package name */
    public C0551x f2477i;

    /* renamed from: j, reason: collision with root package name */
    public C0555z f2478j;
    public final Drawable k;

    /* renamed from: l, reason: collision with root package name */
    public final CharSequence f2479l;

    /* renamed from: m, reason: collision with root package name */
    public C0551x f2480m;

    /* renamed from: n, reason: collision with root package name */
    public View f2481n;

    /* renamed from: o, reason: collision with root package name */
    public Context f2482o;

    /* renamed from: p, reason: collision with root package name */
    public int f2483p;

    /* renamed from: q, reason: collision with root package name */
    public int f2484q;

    /* renamed from: r, reason: collision with root package name */
    public int f2485r;

    /* renamed from: s, reason: collision with root package name */
    public final int f2486s;

    /* renamed from: t, reason: collision with root package name */
    public final int f2487t;

    /* renamed from: u, reason: collision with root package name */
    public int f2488u;

    /* renamed from: v, reason: collision with root package name */
    public int f2489v;

    /* renamed from: w, reason: collision with root package name */
    public int f2490w;

    /* renamed from: x, reason: collision with root package name */
    public int f2491x;

    /* renamed from: y, reason: collision with root package name */
    public W0 f2492y;
    public int z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f2451B = 8388627;
        this.f2458I = new ArrayList();
        this.f2459J = new ArrayList();
        this.f2460K = new int[2];
        this.f2461L = new C0061o(new q1(this, 1));
        this.f2462M = new ArrayList();
        this.f2464O = new p(2, this);
        this.f2473b0 = new F.b(16, this);
        Context context2 = getContext();
        int[] iArr = AbstractC0357a.f4089y;
        t P = t.P(context2, attributeSet, iArr, R.attr.toolbarStyle);
        T.h(this, context, iArr, attributeSet, (TypedArray) P.f100h, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) P.f100h;
        this.f2484q = typedArray.getResourceId(28, 0);
        this.f2485r = typedArray.getResourceId(19, 0);
        this.f2451B = typedArray.getInteger(0, 8388627);
        this.f2486s = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f2491x = dimensionPixelOffset;
        this.f2490w = dimensionPixelOffset;
        this.f2489v = dimensionPixelOffset;
        this.f2488u = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f2488u = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f2489v = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f2490w = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f2491x = dimensionPixelOffset5;
        }
        this.f2487t = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        W0 w02 = this.f2492y;
        w02.f5545h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            w02.f5542e = dimensionPixelSize;
            w02.f5538a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            w02.f5543f = dimensionPixelSize2;
            w02.f5539b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            w02.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.z = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f2450A = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.k = P.H(4);
        this.f2479l = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f2482o = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable H3 = P.H(16);
        if (H3 != null) {
            setNavigationIcon(H3);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable H4 = P.H(11);
        if (H4 != null) {
            setLogo(H4);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(P.G(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(P.G(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        P.T();
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i4 = 0; i4 < menu.size(); i4++) {
            arrayList.add(menu.getItem(i4));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new j(getContext());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$MarginLayoutParams, o.t1] */
    public static t1 h() {
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.f5711b = 0;
        marginLayoutParams.f5710a = 8388627;
        return marginLayoutParams;
    }

    public static t1 i(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof t1;
        if (z) {
            t1 t1Var = (t1) layoutParams;
            t1 t1Var2 = new t1(t1Var);
            t1Var2.f5711b = 0;
            t1Var2.f5711b = t1Var.f5711b;
            return t1Var2;
        }
        if (z) {
            t1 t1Var3 = new t1((t1) layoutParams);
            t1Var3.f5711b = 0;
            return t1Var3;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            t1 t1Var4 = new t1(marginLayoutParams);
            t1Var4.f5711b = 0;
            ((ViewGroup.MarginLayoutParams) t1Var4).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) t1Var4).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) t1Var4).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) t1Var4).bottomMargin = marginLayoutParams.bottomMargin;
            return t1Var4;
        }
        t1 t1Var5 = new t1(layoutParams);
        t1Var5.f5711b = 0;
        return t1Var5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i4) {
        boolean z;
        WeakHashMap weakHashMap = T.f702a;
        if (getLayoutDirection() == 1) {
            z = true;
        } else {
            z = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, getLayoutDirection());
        arrayList.clear();
        if (z) {
            for (int i5 = childCount - 1; i5 >= 0; i5--) {
                View childAt = getChildAt(i5);
                t1 t1Var = (t1) childAt.getLayoutParams();
                if (t1Var.f5711b == 0 && t(childAt)) {
                    int i6 = t1Var.f5710a;
                    WeakHashMap weakHashMap2 = T.f702a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i6, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            t1 t1Var2 = (t1) childAt2.getLayoutParams();
            if (t1Var2.f5711b == 0 && t(childAt2)) {
                int i8 = t1Var2.f5710a;
                WeakHashMap weakHashMap3 = T.f702a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i8, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z) {
        t1 t1Var;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            t1Var = h();
        } else if (!checkLayoutParams(layoutParams)) {
            t1Var = i(layoutParams);
        } else {
            t1Var = (t1) layoutParams;
        }
        t1Var.f5711b = 1;
        if (z && this.f2481n != null) {
            view.setLayoutParams(t1Var);
            this.f2459J.add(view);
        } else {
            addView(view, t1Var);
        }
    }

    public final void c() {
        if (this.f2480m == null) {
            C0551x c0551x = new C0551x(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f2480m = c0551x;
            c0551x.setImageDrawable(this.k);
            this.f2480m.setContentDescription(this.f2479l);
            t1 h3 = h();
            h3.f5710a = (this.f2486s & 112) | 8388611;
            h3.f5711b = 2;
            this.f2480m.setLayoutParams(h3);
            this.f2480m.setOnClickListener(new ViewOnClickListenerC0408c(2, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof t1)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, o.W0] */
    public final void d() {
        if (this.f2492y == null) {
            ?? obj = new Object();
            obj.f5538a = 0;
            obj.f5539b = 0;
            obj.f5540c = Integer.MIN_VALUE;
            obj.f5541d = Integer.MIN_VALUE;
            obj.f5542e = 0;
            obj.f5543f = 0;
            obj.f5544g = false;
            obj.f5545h = false;
            this.f2492y = obj;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f2474f;
        if (actionMenuView.f2350u == null) {
            n nVar = (n) actionMenuView.getMenu();
            if (this.f2466R == null) {
                this.f2466R = new s1(this);
            }
            this.f2474f.setExpandedActionViewsExclusive(true);
            nVar.b(this.f2466R, this.f2482o);
            v();
        }
    }

    public final void f() {
        if (this.f2474f == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f2474f = actionMenuView;
            actionMenuView.setPopupTheme(this.f2483p);
            this.f2474f.setOnMenuItemClickListener(this.f2464O);
            ActionMenuView actionMenuView2 = this.f2474f;
            D d4 = this.f2467S;
            O o3 = new O(5, this);
            actionMenuView2.z = d4;
            actionMenuView2.f2344A = o3;
            t1 h3 = h();
            h3.f5710a = (this.f2486s & 112) | 8388613;
            this.f2474f.setLayoutParams(h3);
            b(this.f2474f, false);
        }
    }

    public final void g() {
        if (this.f2477i == null) {
            this.f2477i = new C0551x(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            t1 h3 = h();
            h3.f5710a = (this.f2486s & 112) | 8388611;
            this.f2477i.setLayoutParams(h3);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        C0551x c0551x = this.f2480m;
        if (c0551x != null) {
            return c0551x.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        C0551x c0551x = this.f2480m;
        if (c0551x != null) {
            return c0551x.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        W0 w02 = this.f2492y;
        if (w02 != null) {
            if (w02.f5544g) {
                return w02.f5538a;
            }
            return w02.f5539b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i4 = this.f2450A;
        if (i4 != Integer.MIN_VALUE) {
            return i4;
        }
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        W0 w02 = this.f2492y;
        if (w02 != null) {
            return w02.f5538a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        W0 w02 = this.f2492y;
        if (w02 != null) {
            return w02.f5539b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        W0 w02 = this.f2492y;
        if (w02 != null) {
            if (w02.f5544g) {
                return w02.f5539b;
            }
            return w02.f5538a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i4 = this.z;
        if (i4 != Integer.MIN_VALUE) {
            return i4;
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        n nVar;
        ActionMenuView actionMenuView = this.f2474f;
        if (actionMenuView != null && (nVar = actionMenuView.f2350u) != null && nVar.hasVisibleItems()) {
            return Math.max(getContentInsetEnd(), Math.max(this.f2450A, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = T.f702a;
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = T.f702a;
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.z, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        C0555z c0555z = this.f2478j;
        if (c0555z != null) {
            return c0555z.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        C0555z c0555z = this.f2478j;
        if (c0555z != null) {
            return c0555z.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f2474f.getMenu();
    }

    public View getNavButtonView() {
        return this.f2477i;
    }

    public CharSequence getNavigationContentDescription() {
        C0551x c0551x = this.f2477i;
        if (c0551x != null) {
            return c0551x.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        C0551x c0551x = this.f2477i;
        if (c0551x != null) {
            return c0551x.getDrawable();
        }
        return null;
    }

    public C0523j getOuterActionMenuPresenter() {
        return this.f2465Q;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f2474f.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f2482o;
    }

    public int getPopupTheme() {
        return this.f2483p;
    }

    public CharSequence getSubtitle() {
        return this.f2453D;
    }

    public final TextView getSubtitleTextView() {
        return this.f2476h;
    }

    public CharSequence getTitle() {
        return this.f2452C;
    }

    public int getTitleMarginBottom() {
        return this.f2491x;
    }

    public int getTitleMarginEnd() {
        return this.f2489v;
    }

    public int getTitleMarginStart() {
        return this.f2488u;
    }

    public int getTitleMarginTop() {
        return this.f2490w;
    }

    public final TextView getTitleTextView() {
        return this.f2475g;
    }

    public InterfaceC0538q0 getWrapper() {
        if (this.P == null) {
            this.P = new x1(this, true);
        }
        return this.P;
    }

    public final int j(View view, int i4) {
        int i5;
        t1 t1Var = (t1) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i4 > 0) {
            i5 = (measuredHeight - i4) / 2;
        } else {
            i5 = 0;
        }
        int i6 = t1Var.f5710a & 112;
        if (i6 != 16 && i6 != 48 && i6 != 80) {
            i6 = this.f2451B & 112;
        }
        if (i6 != 48) {
            if (i6 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i7 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i8 = ((ViewGroup.MarginLayoutParams) t1Var).topMargin;
                if (i7 < i8) {
                    i7 = i8;
                } else {
                    int i9 = (((height - paddingBottom) - measuredHeight) - i7) - paddingTop;
                    int i10 = ((ViewGroup.MarginLayoutParams) t1Var).bottomMargin;
                    if (i9 < i10) {
                        i7 = Math.max(0, i7 - (i10 - i9));
                    }
                }
                return paddingTop + i7;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) t1Var).bottomMargin) - i5;
        }
        return getPaddingTop() - i5;
    }

    public final void m() {
        ArrayList arrayList = this.f2462M;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it = this.f2461L.f775b.iterator();
        while (it.hasNext()) {
            ((H) ((InterfaceC0062p) it.next())).f2725a.k();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f2462M = currentMenuItems2;
    }

    public final boolean n(View view) {
        if (view.getParent() != this && !this.f2459J.contains(view)) {
            return false;
        }
        return true;
    }

    public final boolean o() {
        C0523j c0523j;
        ActionMenuView actionMenuView = this.f2474f;
        if (actionMenuView != null && (c0523j = actionMenuView.f2354y) != null && c0523j.f()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2473b0);
        v();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2457H = false;
        }
        if (!this.f2457H) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f2457H = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f2457H = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x028f A[LOOP:0: B:39:0x028d->B:40:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02a7 A[LOOP:1: B:43:0x02a5->B:44:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02c7 A[LOOP:2: B:47:0x02c5->B:48:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x031a A[LOOP:3: B:56:0x0318->B:57:0x031a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean a4 = E1.a(this);
        int i13 = !a4 ? 1 : 0;
        int i14 = 0;
        if (t(this.f2477i)) {
            s(this.f2477i, i4, 0, i5, this.f2487t);
            i6 = k(this.f2477i) + this.f2477i.getMeasuredWidth();
            i7 = Math.max(0, l(this.f2477i) + this.f2477i.getMeasuredHeight());
            i8 = View.combineMeasuredStates(0, this.f2477i.getMeasuredState());
        } else {
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (t(this.f2480m)) {
            s(this.f2480m, i4, 0, i5, this.f2487t);
            i6 = k(this.f2480m) + this.f2480m.getMeasuredWidth();
            i7 = Math.max(i7, l(this.f2480m) + this.f2480m.getMeasuredHeight());
            i8 = View.combineMeasuredStates(i8, this.f2480m.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i6);
        int max2 = Math.max(0, currentContentInsetStart - i6);
        int[] iArr = this.f2460K;
        iArr[a4 ? 1 : 0] = max2;
        if (t(this.f2474f)) {
            s(this.f2474f, i4, max, i5, this.f2487t);
            i9 = k(this.f2474f) + this.f2474f.getMeasuredWidth();
            i7 = Math.max(i7, l(this.f2474f) + this.f2474f.getMeasuredHeight());
            i8 = View.combineMeasuredStates(i8, this.f2474f.getMeasuredState());
        } else {
            i9 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i9);
        iArr[i13] = Math.max(0, currentContentInsetEnd - i9);
        if (t(this.f2481n)) {
            max3 += r(this.f2481n, i4, max3, i5, 0, iArr);
            i7 = Math.max(i7, l(this.f2481n) + this.f2481n.getMeasuredHeight());
            i8 = View.combineMeasuredStates(i8, this.f2481n.getMeasuredState());
        }
        if (t(this.f2478j)) {
            max3 += r(this.f2478j, i4, max3, i5, 0, iArr);
            i7 = Math.max(i7, l(this.f2478j) + this.f2478j.getMeasuredHeight());
            i8 = View.combineMeasuredStates(i8, this.f2478j.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (((t1) childAt.getLayoutParams()).f5711b == 0 && t(childAt)) {
                max3 += r(childAt, i4, max3, i5, 0, iArr);
                int max4 = Math.max(i7, l(childAt) + childAt.getMeasuredHeight());
                i8 = View.combineMeasuredStates(i8, childAt.getMeasuredState());
                i7 = max4;
            } else {
                max3 = max3;
            }
        }
        int i16 = max3;
        int i17 = this.f2490w + this.f2491x;
        int i18 = this.f2488u + this.f2489v;
        if (t(this.f2475g)) {
            r(this.f2475g, i4, i16 + i18, i5, i17, iArr);
            int k = k(this.f2475g) + this.f2475g.getMeasuredWidth();
            i10 = l(this.f2475g) + this.f2475g.getMeasuredHeight();
            i11 = View.combineMeasuredStates(i8, this.f2475g.getMeasuredState());
            i12 = k;
        } else {
            i10 = 0;
            i11 = i8;
            i12 = 0;
        }
        if (t(this.f2476h)) {
            i12 = Math.max(i12, r(this.f2476h, i4, i16 + i18, i5, i17 + i10, iArr));
            i10 += l(this.f2476h) + this.f2476h.getMeasuredHeight();
            i11 = View.combineMeasuredStates(i11, this.f2476h.getMeasuredState());
        }
        int max5 = Math.max(i7, i10);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i16 + i12;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i4, (-16777216) & i11);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i5, i11 << 16);
        if (this.f2469U) {
            int childCount2 = getChildCount();
            for (int i19 = 0; i19 < childCount2; i19++) {
                View childAt2 = getChildAt(i19);
                if (!t(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i14);
        }
        i14 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i14);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        n nVar;
        MenuItem findItem;
        if (!(parcelable instanceof v1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        v1 v1Var = (v1) parcelable;
        super.onRestoreInstanceState(v1Var.f1062f);
        ActionMenuView actionMenuView = this.f2474f;
        if (actionMenuView != null) {
            nVar = actionMenuView.f2350u;
        } else {
            nVar = null;
        }
        int i4 = v1Var.f5721h;
        if (i4 != 0 && this.f2466R != null && nVar != null && (findItem = nVar.findItem(i4)) != null) {
            findItem.expandActionView();
        }
        if (v1Var.f5722i) {
            F.b bVar = this.f2473b0;
            removeCallbacks(bVar);
            post(bVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        d();
        W0 w02 = this.f2492y;
        boolean z = true;
        if (i4 != 1) {
            z = false;
        }
        if (z == w02.f5544g) {
            return;
        }
        w02.f5544g = z;
        if (w02.f5545h) {
            if (z) {
                int i5 = w02.f5541d;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = w02.f5542e;
                }
                w02.f5538a = i5;
                int i6 = w02.f5540c;
                if (i6 == Integer.MIN_VALUE) {
                    i6 = w02.f5543f;
                }
                w02.f5539b = i6;
                return;
            }
            int i7 = w02.f5540c;
            if (i7 == Integer.MIN_VALUE) {
                i7 = w02.f5542e;
            }
            w02.f5538a = i7;
            int i8 = w02.f5541d;
            if (i8 == Integer.MIN_VALUE) {
                i8 = w02.f5543f;
            }
            w02.f5539b = i8;
            return;
        }
        w02.f5538a = w02.f5542e;
        w02.f5539b = w02.f5543f;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [N.c, android.os.Parcelable, o.v1] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        q qVar;
        ?? cVar = new N.c(super.onSaveInstanceState());
        s1 s1Var = this.f2466R;
        if (s1Var != null && (qVar = s1Var.f5705g) != null) {
            cVar.f5721h = qVar.f5326a;
        }
        cVar.f5722i = o();
        return cVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2456G = false;
        }
        if (!this.f2456G) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f2456G = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f2456G = false;
        return true;
    }

    public final int p(View view, int i4, int i5, int[] iArr) {
        t1 t1Var = (t1) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) t1Var).leftMargin - iArr[0];
        int max = Math.max(0, i6) + i4;
        iArr[0] = Math.max(0, -i6);
        int j4 = j(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, j4, max + measuredWidth, view.getMeasuredHeight() + j4);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) t1Var).rightMargin + max;
    }

    public final int q(View view, int i4, int i5, int[] iArr) {
        t1 t1Var = (t1) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) t1Var).rightMargin - iArr[1];
        int max = i4 - Math.max(0, i6);
        iArr[1] = Math.max(0, -i6);
        int j4 = j(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, j4, max, view.getMeasuredHeight() + j4);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) t1Var).leftMargin);
    }

    public final int r(View view, int i4, int i5, int i6, int i7, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i8 = marginLayoutParams.leftMargin - iArr[0];
        int i9 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i9) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i8);
        iArr[1] = Math.max(0, -i9);
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + max + i5, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void s(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.f2472a0 != z) {
            this.f2472a0 = z;
            v();
        }
    }

    public void setCollapseContentDescription(int i4) {
        setCollapseContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setCollapseIcon(int i4) {
        setCollapseIcon(AbstractC0286a.o(getContext(), i4));
    }

    public void setCollapsible(boolean z) {
        this.f2469U = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i4) {
        if (i4 < 0) {
            i4 = Integer.MIN_VALUE;
        }
        if (i4 != this.f2450A) {
            this.f2450A = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i4) {
        if (i4 < 0) {
            i4 = Integer.MIN_VALUE;
        }
        if (i4 != this.z) {
            this.z = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i4) {
        setLogo(AbstractC0286a.o(getContext(), i4));
    }

    public void setLogoDescription(int i4) {
        setLogoDescription(getContext().getText(i4));
    }

    public void setNavigationContentDescription(int i4) {
        setNavigationContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setNavigationIcon(int i4) {
        setNavigationIcon(AbstractC0286a.o(getContext(), i4));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f2477i.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(u1 u1Var) {
        this.f2463N = u1Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f2474f.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i4) {
        if (this.f2483p != i4) {
            this.f2483p = i4;
            if (i4 == 0) {
                this.f2482o = getContext();
            } else {
                this.f2482o = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setSubtitle(int i4) {
        setSubtitle(getContext().getText(i4));
    }

    public void setSubtitleTextColor(int i4) {
        setSubtitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setTitle(int i4) {
        setTitle(getContext().getText(i4));
    }

    public void setTitleMarginBottom(int i4) {
        this.f2491x = i4;
        requestLayout();
    }

    public void setTitleMarginEnd(int i4) {
        this.f2489v = i4;
        requestLayout();
    }

    public void setTitleMarginStart(int i4) {
        this.f2488u = i4;
        requestLayout();
    }

    public void setTitleMarginTop(int i4) {
        this.f2490w = i4;
        requestLayout();
    }

    public void setTitleTextColor(int i4) {
        setTitleTextColor(ColorStateList.valueOf(i4));
    }

    public final boolean t(View view) {
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    public final boolean u() {
        C0523j c0523j;
        ActionMenuView actionMenuView = this.f2474f;
        if (actionMenuView != null && (c0523j = actionMenuView.f2354y) != null && c0523j.l()) {
            return true;
        }
        return false;
    }

    public final void v() {
        boolean z;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a4 = r1.a(this);
            s1 s1Var = this.f2466R;
            int i4 = 0;
            if (s1Var != null && s1Var.f5705g != null && a4 != null) {
                WeakHashMap weakHashMap = T.f702a;
                if (isAttachedToWindow() && this.f2472a0) {
                    z = true;
                    if (!z && this.f2471W == null) {
                        if (this.f2470V == null) {
                            this.f2470V = r1.b(new q1(this, i4));
                        }
                        r1.c(a4, this.f2470V);
                        this.f2471W = a4;
                        return;
                    }
                    if (z && (onBackInvokedDispatcher = this.f2471W) != null) {
                        r1.d(onBackInvokedDispatcher, this.f2470V);
                        this.f2471W = null;
                        return;
                    }
                }
            }
            z = false;
            if (!z) {
            }
            if (z) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams, o.t1] */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(context, attributeSet);
        marginLayoutParams.f5710a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0357a.f4067b);
        marginLayoutParams.f5710a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        marginLayoutParams.f5711b = 0;
        return marginLayoutParams;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        C0551x c0551x = this.f2480m;
        if (c0551x != null) {
            c0551x.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f2480m.setImageDrawable(drawable);
        } else {
            C0551x c0551x = this.f2480m;
            if (c0551x != null) {
                c0551x.setImageDrawable(this.k);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f2478j == null) {
                this.f2478j = new C0555z(getContext(), null, 0);
            }
            if (!n(this.f2478j)) {
                b(this.f2478j, true);
            }
        } else {
            C0555z c0555z = this.f2478j;
            if (c0555z != null && n(c0555z)) {
                removeView(this.f2478j);
                this.f2459J.remove(this.f2478j);
            }
        }
        C0555z c0555z2 = this.f2478j;
        if (c0555z2 != null) {
            c0555z2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f2478j == null) {
            this.f2478j = new C0555z(getContext(), null, 0);
        }
        C0555z c0555z = this.f2478j;
        if (c0555z != null) {
            c0555z.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        C0551x c0551x = this.f2477i;
        if (c0551x != null) {
            c0551x.setContentDescription(charSequence);
            AbstractC0286a.H(this.f2477i, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!n(this.f2477i)) {
                b(this.f2477i, true);
            }
        } else {
            C0551x c0551x = this.f2477i;
            if (c0551x != null && n(c0551x)) {
                removeView(this.f2477i);
                this.f2459J.remove(this.f2477i);
            }
        }
        C0551x c0551x2 = this.f2477i;
        if (c0551x2 != null) {
            c0551x2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2476h == null) {
                Context context = getContext();
                C0516f0 c0516f0 = new C0516f0(context, null);
                this.f2476h = c0516f0;
                c0516f0.setSingleLine();
                this.f2476h.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f2485r;
                if (i4 != 0) {
                    this.f2476h.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.f2455F;
                if (colorStateList != null) {
                    this.f2476h.setTextColor(colorStateList);
                }
            }
            if (!n(this.f2476h)) {
                b(this.f2476h, true);
            }
        } else {
            C0516f0 c0516f02 = this.f2476h;
            if (c0516f02 != null && n(c0516f02)) {
                removeView(this.f2476h);
                this.f2459J.remove(this.f2476h);
            }
        }
        C0516f0 c0516f03 = this.f2476h;
        if (c0516f03 != null) {
            c0516f03.setText(charSequence);
        }
        this.f2453D = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f2455F = colorStateList;
        C0516f0 c0516f0 = this.f2476h;
        if (c0516f0 != null) {
            c0516f0.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2475g == null) {
                Context context = getContext();
                C0516f0 c0516f0 = new C0516f0(context, null);
                this.f2475g = c0516f0;
                c0516f0.setSingleLine();
                this.f2475g.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f2484q;
                if (i4 != 0) {
                    this.f2475g.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.f2454E;
                if (colorStateList != null) {
                    this.f2475g.setTextColor(colorStateList);
                }
            }
            if (!n(this.f2475g)) {
                b(this.f2475g, true);
            }
        } else {
            C0516f0 c0516f02 = this.f2475g;
            if (c0516f02 != null && n(c0516f02)) {
                removeView(this.f2475g);
                this.f2459J.remove(this.f2475g);
            }
        }
        C0516f0 c0516f03 = this.f2475g;
        if (c0516f03 != null) {
            c0516f03.setText(charSequence);
        }
        this.f2452C = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f2454E = colorStateList;
        C0516f0 c0516f0 = this.f2475g;
        if (c0516f0 != null) {
            c0516f0.setTextColor(colorStateList);
        }
    }
}
