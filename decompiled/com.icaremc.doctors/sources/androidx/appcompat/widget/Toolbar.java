package androidx.appcompat.widget;

import A0.g;
import E.J;
import F.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.icaremc.doctors.R;
import h.AbstractC0201a;
import i.AbstractC0203a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import k.C0220d;
import l.j;
import l.k;
import m.C0258e;
import m.C0261h;
import m.C0269p;
import m.C0270q;
import m.C0273u;
import m.InterfaceC0276x;
import m.P;
import m.j0;
import m.k0;
import m.l0;
import m.m0;
import m.n0;
import m.o0;
import m.u0;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f1219A;

    /* renamed from: B, reason: collision with root package name */
    public ColorStateList f1220B;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f1221C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f1222D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f1223E;

    /* renamed from: F, reason: collision with root package name */
    public final ArrayList f1224F;

    /* renamed from: G, reason: collision with root package name */
    public final ArrayList f1225G;

    /* renamed from: H, reason: collision with root package name */
    public final int[] f1226H;

    /* renamed from: I, reason: collision with root package name */
    public final h f1227I;

    /* renamed from: J, reason: collision with root package name */
    public o0 f1228J;

    /* renamed from: K, reason: collision with root package name */
    public k0 f1229K;
    public boolean L;

    /* renamed from: M, reason: collision with root package name */
    public final B.b f1230M;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f1231c;

    /* renamed from: d, reason: collision with root package name */
    public C0273u f1232d;

    /* renamed from: e, reason: collision with root package name */
    public C0273u f1233e;

    /* renamed from: f, reason: collision with root package name */
    public C0269p f1234f;

    /* renamed from: g, reason: collision with root package name */
    public C0270q f1235g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f1236h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f1237i;

    /* renamed from: j, reason: collision with root package name */
    public C0269p f1238j;

    /* renamed from: k, reason: collision with root package name */
    public View f1239k;

    /* renamed from: l, reason: collision with root package name */
    public Context f1240l;

    /* renamed from: m, reason: collision with root package name */
    public int f1241m;

    /* renamed from: n, reason: collision with root package name */
    public int f1242n;

    /* renamed from: o, reason: collision with root package name */
    public int f1243o;
    public final int p;
    public final int q;

    /* renamed from: r, reason: collision with root package name */
    public int f1244r;

    /* renamed from: s, reason: collision with root package name */
    public int f1245s;

    /* renamed from: t, reason: collision with root package name */
    public int f1246t;

    /* renamed from: u, reason: collision with root package name */
    public int f1247u;

    /* renamed from: v, reason: collision with root package name */
    public P f1248v;

    /* renamed from: w, reason: collision with root package name */
    public int f1249w;

    /* renamed from: x, reason: collision with root package name */
    public int f1250x;
    public final int y;
    public CharSequence z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.y = 8388627;
        this.f1224F = new ArrayList();
        this.f1225G = new ArrayList();
        this.f1226H = new int[2];
        this.f1227I = new h(15, this);
        this.f1230M = new B.b(6, this);
        g i2 = g.i(getContext(), attributeSet, AbstractC0201a.f2315t, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) i2.f31e;
        this.f1242n = typedArray.getResourceId(28, 0);
        this.f1243o = typedArray.getResourceId(19, 0);
        this.y = typedArray.getInteger(0, 8388627);
        this.p = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f1247u = dimensionPixelOffset;
        this.f1246t = dimensionPixelOffset;
        this.f1245s = dimensionPixelOffset;
        this.f1244r = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f1244r = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f1245s = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f1246t = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f1247u = dimensionPixelOffset5;
        }
        this.q = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        P p = this.f1248v;
        p.f3103h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            p.f3100e = dimensionPixelSize;
            p.f3096a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            p.f3101f = dimensionPixelSize2;
            p.f3097b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            p.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f1249w = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f1250x = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f1236h = i2.e(4);
        this.f1237i = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f1240l = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable e2 = i2.e(16);
        if (e2 != null) {
            setNavigationIcon(e2);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable e3 = i2.e(11);
        if (e3 != null) {
            setLogo(e3);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(i2.d(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(i2.d(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        i2.k();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$MarginLayoutParams, m.l0] */
    public static l0 g() {
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.f3190b = 0;
        marginLayoutParams.f3189a = 8388627;
        return marginLayoutParams;
    }

    private MenuInflater getMenuInflater() {
        return new C0220d(getContext());
    }

    public static l0 h(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof l0;
        if (z) {
            l0 l0Var = (l0) layoutParams;
            l0 l0Var2 = new l0(l0Var);
            l0Var2.f3190b = 0;
            l0Var2.f3190b = l0Var.f3190b;
            return l0Var2;
        }
        if (z) {
            l0 l0Var3 = new l0((l0) layoutParams);
            l0Var3.f3190b = 0;
            return l0Var3;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            l0 l0Var4 = new l0(marginLayoutParams);
            l0Var4.f3190b = 0;
            ((ViewGroup.MarginLayoutParams) l0Var4).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) l0Var4).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) l0Var4).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) l0Var4).bottomMargin = marginLayoutParams.bottomMargin;
            return l0Var4;
        }
        l0 l0Var5 = new l0(layoutParams);
        l0Var5.f3190b = 0;
        return l0Var5;
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i2, ArrayList arrayList) {
        boolean z;
        Field field = J.f180a;
        if (getLayoutDirection() == 1) {
            z = true;
        } else {
            z = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        arrayList.clear();
        if (z) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                l0 l0Var = (l0) childAt.getLayoutParams();
                if (l0Var.f3190b == 0 && q(childAt)) {
                    int i4 = l0Var.f3189a;
                    Field field2 = J.f180a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i4, layoutDirection) & 7;
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
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            l0 l0Var2 = (l0) childAt2.getLayoutParams();
            if (l0Var2.f3190b == 0 && q(childAt2)) {
                int i6 = l0Var2.f3189a;
                Field field3 = J.f180a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i6, layoutDirection2) & 7;
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
        l0 l0Var;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            l0Var = g();
        } else if (!checkLayoutParams(layoutParams)) {
            l0Var = h(layoutParams);
        } else {
            l0Var = (l0) layoutParams;
        }
        l0Var.f3190b = 1;
        if (z && this.f1239k != null) {
            view.setLayoutParams(l0Var);
            this.f1225G.add(view);
        } else {
            addView(view, l0Var);
        }
    }

    public final void c() {
        if (this.f1238j == null) {
            C0269p c0269p = new C0269p(getContext());
            this.f1238j = c0269p;
            c0269p.setImageDrawable(this.f1236h);
            this.f1238j.setContentDescription(this.f1237i);
            l0 g2 = g();
            g2.f3189a = (this.p & 112) | 8388611;
            g2.f3190b = 2;
            this.f1238j.setLayoutParams(g2);
            this.f1238j.setOnClickListener(new j0(this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof l0)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, m.P] */
    public final void d() {
        if (this.f1248v == null) {
            ?? obj = new Object();
            obj.f3096a = 0;
            obj.f3097b = 0;
            obj.f3098c = Integer.MIN_VALUE;
            obj.f3099d = Integer.MIN_VALUE;
            obj.f3100e = 0;
            obj.f3101f = 0;
            obj.f3102g = false;
            obj.f3103h = false;
            this.f1248v = obj;
        }
    }

    public final void e() {
        if (this.f1231c == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f1231c = actionMenuView;
            actionMenuView.setPopupTheme(this.f1241m);
            this.f1231c.setOnMenuItemClickListener(this.f1227I);
            this.f1231c.getClass();
            l0 g2 = g();
            g2.f3189a = (this.p & 112) | 8388613;
            this.f1231c.setLayoutParams(g2);
            b(this.f1231c, false);
        }
        ActionMenuView actionMenuView2 = this.f1231c;
        if (actionMenuView2.f1125r == null) {
            j jVar = (j) actionMenuView2.getMenu();
            if (this.f1229K == null) {
                this.f1229K = new k0(this);
            }
            this.f1231c.setExpandedActionViewsExclusive(true);
            jVar.b(this.f1229K, this.f1240l);
        }
    }

    public final void f() {
        if (this.f1234f == null) {
            this.f1234f = new C0269p(getContext());
            l0 g2 = g();
            g2.f3189a = (this.p & 112) | 8388611;
            this.f1234f.setLayoutParams(g2);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return h(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        C0269p c0269p = this.f1238j;
        if (c0269p != null) {
            return c0269p.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        C0269p c0269p = this.f1238j;
        if (c0269p != null) {
            return c0269p.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        P p = this.f1248v;
        if (p != null) {
            if (p.f3102g) {
                return p.f3096a;
            }
            return p.f3097b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.f1250x;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        P p = this.f1248v;
        if (p != null) {
            return p.f3096a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        P p = this.f1248v;
        if (p != null) {
            return p.f3097b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        P p = this.f1248v;
        if (p != null) {
            if (p.f3102g) {
                return p.f3097b;
            }
            return p.f3096a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.f1249w;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        j jVar;
        ActionMenuView actionMenuView = this.f1231c;
        if (actionMenuView != null && (jVar = actionMenuView.f1125r) != null && jVar.hasVisibleItems()) {
            return Math.max(getContentInsetEnd(), Math.max(this.f1250x, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        Field field = J.f180a;
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        Field field = J.f180a;
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f1249w, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        C0270q c0270q = this.f1235g;
        if (c0270q != null) {
            return c0270q.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        C0270q c0270q = this.f1235g;
        if (c0270q != null) {
            return c0270q.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f1231c.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        C0269p c0269p = this.f1234f;
        if (c0269p != null) {
            return c0269p.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        C0269p c0269p = this.f1234f;
        if (c0269p != null) {
            return c0269p.getDrawable();
        }
        return null;
    }

    public C0261h getOuterActionMenuPresenter() {
        return null;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f1231c.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f1240l;
    }

    public int getPopupTheme() {
        return this.f1241m;
    }

    public CharSequence getSubtitle() {
        return this.f1219A;
    }

    public final TextView getSubtitleTextView() {
        return this.f1233e;
    }

    public CharSequence getTitle() {
        return this.z;
    }

    public int getTitleMarginBottom() {
        return this.f1247u;
    }

    public int getTitleMarginEnd() {
        return this.f1245s;
    }

    public int getTitleMarginStart() {
        return this.f1244r;
    }

    public int getTitleMarginTop() {
        return this.f1246t;
    }

    public final TextView getTitleTextView() {
        return this.f1232d;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [m.o0, java.lang.Object] */
    public InterfaceC0276x getWrapper() {
        boolean z;
        Drawable drawable;
        if (this.f1228J == null) {
            ?? obj = new Object();
            obj.f3219l = 0;
            obj.f3208a = this;
            obj.f3215h = getTitle();
            obj.f3216i = getSubtitle();
            if (obj.f3215h != null) {
                z = true;
            } else {
                z = false;
            }
            obj.f3214g = z;
            obj.f3213f = getNavigationIcon();
            String str = null;
            g i2 = g.i(getContext(), null, AbstractC0201a.f2298a, R.attr.actionBarStyle);
            TypedArray typedArray = (TypedArray) i2.f31e;
            obj.f3220m = i2.e(15);
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                obj.f3214g = true;
                obj.f3215h = text;
                if ((obj.f3209b & 8) != 0) {
                    obj.f3208a.setTitle(text);
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                obj.f3216i = text2;
                if ((obj.f3209b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable e2 = i2.e(20);
            if (e2 != null) {
                obj.f3212e = e2;
                obj.c();
            }
            Drawable e3 = i2.e(17);
            if (e3 != null) {
                obj.f3211d = e3;
                obj.c();
            }
            if (obj.f3213f == null && (drawable = obj.f3220m) != null) {
                obj.f3213f = drawable;
                Toolbar toolbar = obj.f3208a;
                if ((obj.f3209b & 4) != 0) {
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            obj.a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = obj.f3210c;
                if (view != null && (obj.f3209b & 16) != 0) {
                    removeView(view);
                }
                obj.f3210c = inflate;
                if (inflate != null && (obj.f3209b & 16) != 0) {
                    addView(inflate);
                }
                obj.a(obj.f3209b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                d();
                this.f1248v.a(max, max2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f1242n = resourceId2;
                C0273u c0273u = this.f1232d;
                if (c0273u != null) {
                    c0273u.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.f1243o = resourceId3;
                C0273u c0273u2 = this.f1233e;
                if (c0273u2 != null) {
                    c0273u2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            i2.k();
            if (R.string.abc_action_bar_up_description != obj.f3219l) {
                obj.f3219l = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i3 = obj.f3219l;
                    if (i3 != 0) {
                        str = getContext().getString(i3);
                    }
                    obj.f3217j = str;
                    obj.b();
                }
            }
            obj.f3217j = getNavigationContentDescription();
            setNavigationOnClickListener(new j0((o0) obj));
            this.f1228J = obj;
        }
        return this.f1228J;
    }

    public final int i(View view, int i2) {
        int i3;
        l0 l0Var = (l0) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 > 0) {
            i3 = (measuredHeight - i2) / 2;
        } else {
            i3 = 0;
        }
        int i4 = l0Var.f3189a & 112;
        if (i4 != 16 && i4 != 48 && i4 != 80) {
            i4 = this.y & 112;
        }
        if (i4 != 48) {
            if (i4 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i5 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i6 = ((ViewGroup.MarginLayoutParams) l0Var).topMargin;
                if (i5 < i6) {
                    i5 = i6;
                } else {
                    int i7 = (((height - paddingBottom) - measuredHeight) - i5) - paddingTop;
                    int i8 = ((ViewGroup.MarginLayoutParams) l0Var).bottomMargin;
                    if (i7 < i8) {
                        i5 = Math.max(0, i5 - (i8 - i7));
                    }
                }
                return paddingTop + i5;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) l0Var).bottomMargin) - i3;
        }
        return getPaddingTop() - i3;
    }

    public final boolean l(View view) {
        if (view.getParent() != this && !this.f1225G.contains(view)) {
            return false;
        }
        return true;
    }

    public final int m(View view, int i2, int i3, int[] iArr) {
        l0 l0Var = (l0) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) l0Var).leftMargin - iArr[0];
        int max = Math.max(0, i4) + i2;
        iArr[0] = Math.max(0, -i4);
        int i5 = i(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i5, max + measuredWidth, view.getMeasuredHeight() + i5);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) l0Var).rightMargin + max;
    }

    public final int n(View view, int i2, int i3, int[] iArr) {
        l0 l0Var = (l0) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) l0Var).rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int i5 = i(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i5, max, view.getMeasuredHeight() + i5);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) l0Var).leftMargin);
    }

    public final int o(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i7) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1230M);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1223E = false;
        }
        if (!this.f1223E) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1223E = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f1223E = false;
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
    public final void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean a2 = u0.a(this);
        int i11 = !a2 ? 1 : 0;
        int i12 = 0;
        if (q(this.f1234f)) {
            p(this.f1234f, i2, 0, i3, this.q);
            i4 = j(this.f1234f) + this.f1234f.getMeasuredWidth();
            i5 = Math.max(0, k(this.f1234f) + this.f1234f.getMeasuredHeight());
            i6 = View.combineMeasuredStates(0, this.f1234f.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (q(this.f1238j)) {
            p(this.f1238j, i2, 0, i3, this.q);
            i4 = j(this.f1238j) + this.f1238j.getMeasuredWidth();
            i5 = Math.max(i5, k(this.f1238j) + this.f1238j.getMeasuredHeight());
            i6 = View.combineMeasuredStates(i6, this.f1238j.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i4);
        int max2 = Math.max(0, currentContentInsetStart - i4);
        int[] iArr = this.f1226H;
        iArr[a2 ? 1 : 0] = max2;
        if (q(this.f1231c)) {
            p(this.f1231c, i2, max, i3, this.q);
            i7 = j(this.f1231c) + this.f1231c.getMeasuredWidth();
            i5 = Math.max(i5, k(this.f1231c) + this.f1231c.getMeasuredHeight());
            i6 = View.combineMeasuredStates(i6, this.f1231c.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i7);
        iArr[i11] = Math.max(0, currentContentInsetEnd - i7);
        if (q(this.f1239k)) {
            max3 += o(this.f1239k, i2, max3, i3, 0, iArr);
            i5 = Math.max(i5, k(this.f1239k) + this.f1239k.getMeasuredHeight());
            i6 = View.combineMeasuredStates(i6, this.f1239k.getMeasuredState());
        }
        if (q(this.f1235g)) {
            max3 += o(this.f1235g, i2, max3, i3, 0, iArr);
            i5 = Math.max(i5, k(this.f1235g) + this.f1235g.getMeasuredHeight());
            i6 = View.combineMeasuredStates(i6, this.f1235g.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((l0) childAt.getLayoutParams()).f3190b == 0 && q(childAt)) {
                max3 += o(childAt, i2, max3, i3, 0, iArr);
                int max4 = Math.max(i5, k(childAt) + childAt.getMeasuredHeight());
                i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
                i5 = max4;
            } else {
                max3 = max3;
            }
        }
        int i14 = max3;
        int i15 = this.f1246t + this.f1247u;
        int i16 = this.f1244r + this.f1245s;
        if (q(this.f1232d)) {
            o(this.f1232d, i2, i14 + i16, i3, i15, iArr);
            int j2 = j(this.f1232d) + this.f1232d.getMeasuredWidth();
            i8 = k(this.f1232d) + this.f1232d.getMeasuredHeight();
            i9 = View.combineMeasuredStates(i6, this.f1232d.getMeasuredState());
            i10 = j2;
        } else {
            i8 = 0;
            i9 = i6;
            i10 = 0;
        }
        if (q(this.f1233e)) {
            i10 = Math.max(i10, o(this.f1233e, i2, i14 + i16, i3, i15 + i8, iArr));
            i8 += k(this.f1233e) + this.f1233e.getMeasuredHeight();
            i9 = View.combineMeasuredStates(i9, this.f1233e.getMeasuredState());
        }
        int max5 = Math.max(i5, i8);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i14 + i10;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, (-16777216) & i9);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, i9 << 16);
        if (this.L) {
            int childCount2 = getChildCount();
            for (int i17 = 0; i17 < childCount2; i17++) {
                View childAt2 = getChildAt(i17);
                if (!q(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i12);
        }
        i12 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i12);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        j jVar;
        MenuItem findItem;
        if (!(parcelable instanceof n0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n0 n0Var = (n0) parcelable;
        super.onRestoreInstanceState(n0Var.f329c);
        ActionMenuView actionMenuView = this.f1231c;
        if (actionMenuView != null) {
            jVar = actionMenuView.f1125r;
        } else {
            jVar = null;
        }
        int i2 = n0Var.f3203e;
        if (i2 != 0 && this.f1229K != null && jVar != null && (findItem = jVar.findItem(i2)) != null) {
            findItem.expandActionView();
        }
        if (n0Var.f3204f) {
            B.b bVar = this.f1230M;
            removeCallbacks(bVar);
            post(bVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        d();
        P p = this.f1248v;
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        if (z == p.f3102g) {
            return;
        }
        p.f3102g = z;
        if (p.f3103h) {
            if (z) {
                int i3 = p.f3099d;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = p.f3100e;
                }
                p.f3096a = i3;
                int i4 = p.f3098c;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = p.f3101f;
                }
                p.f3097b = i4;
                return;
            }
            int i5 = p.f3098c;
            if (i5 == Integer.MIN_VALUE) {
                i5 = p.f3100e;
            }
            p.f3096a = i5;
            int i6 = p.f3099d;
            if (i6 == Integer.MIN_VALUE) {
                i6 = p.f3101f;
            }
            p.f3097b = i6;
            return;
        }
        p.f3096a = p.f3100e;
        p.f3097b = p.f3101f;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m.n0, android.os.Parcelable, J.c] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z;
        C0261h c0261h;
        C0258e c0258e;
        k kVar;
        ?? cVar = new J.c(super.onSaveInstanceState());
        k0 k0Var = this.f1229K;
        if (k0Var != null && (kVar = k0Var.f3184d) != null) {
            cVar.f3203e = kVar.f2861a;
        }
        ActionMenuView actionMenuView = this.f1231c;
        if (actionMenuView != null && (c0261h = actionMenuView.f1128u) != null && (c0258e = c0261h.f3166t) != null && c0258e.b()) {
            z = true;
        } else {
            z = false;
        }
        cVar.f3204f = z;
        return cVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1222D = false;
        }
        if (!this.f1222D) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1222D = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f1222D = false;
        return true;
    }

    public final void p(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean q(View view) {
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(AbstractC0203a.a(getContext(), i2));
    }

    public void setCollapsible(boolean z) {
        this.L = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1250x) {
            this.f1250x = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1249w) {
            this.f1249w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(AbstractC0203a.a(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(AbstractC0203a.a(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        f();
        this.f1234f.setOnClickListener(onClickListener);
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f1231c.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.f1241m != i2) {
            this.f1241m = i2;
            if (i2 == 0) {
                this.f1240l = getContext();
            } else {
                this.f1240l = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.f1247u = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.f1245s = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.f1244r = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.f1246t = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams, m.l0] */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(context, attributeSet);
        marginLayoutParams.f3189a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0201a.f2299b);
        marginLayoutParams.f3189a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        marginLayoutParams.f3190b = 0;
        return marginLayoutParams;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        C0269p c0269p = this.f1238j;
        if (c0269p != null) {
            c0269p.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f1238j.setImageDrawable(drawable);
        } else {
            C0269p c0269p = this.f1238j;
            if (c0269p != null) {
                c0269p.setImageDrawable(this.f1236h);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f1235g == null) {
                this.f1235g = new C0270q(getContext(), 0);
            }
            if (!l(this.f1235g)) {
                b(this.f1235g, true);
            }
        } else {
            C0270q c0270q = this.f1235g;
            if (c0270q != null && l(c0270q)) {
                removeView(this.f1235g);
                this.f1225G.remove(this.f1235g);
            }
        }
        C0270q c0270q2 = this.f1235g;
        if (c0270q2 != null) {
            c0270q2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f1235g == null) {
            this.f1235g = new C0270q(getContext(), 0);
        }
        C0270q c0270q = this.f1235g;
        if (c0270q != null) {
            c0270q.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        C0269p c0269p = this.f1234f;
        if (c0269p != null) {
            c0269p.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!l(this.f1234f)) {
                b(this.f1234f, true);
            }
        } else {
            C0269p c0269p = this.f1234f;
            if (c0269p != null && l(c0269p)) {
                removeView(this.f1234f);
                this.f1225G.remove(this.f1234f);
            }
        }
        C0269p c0269p2 = this.f1234f;
        if (c0269p2 != null) {
            c0269p2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1233e == null) {
                Context context = getContext();
                C0273u c0273u = new C0273u(context, null);
                this.f1233e = c0273u;
                c0273u.setSingleLine();
                this.f1233e.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1243o;
                if (i2 != 0) {
                    this.f1233e.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f1221C;
                if (colorStateList != null) {
                    this.f1233e.setTextColor(colorStateList);
                }
            }
            if (!l(this.f1233e)) {
                b(this.f1233e, true);
            }
        } else {
            C0273u c0273u2 = this.f1233e;
            if (c0273u2 != null && l(c0273u2)) {
                removeView(this.f1233e);
                this.f1225G.remove(this.f1233e);
            }
        }
        C0273u c0273u3 = this.f1233e;
        if (c0273u3 != null) {
            c0273u3.setText(charSequence);
        }
        this.f1219A = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f1221C = colorStateList;
        C0273u c0273u = this.f1233e;
        if (c0273u != null) {
            c0273u.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1232d == null) {
                Context context = getContext();
                C0273u c0273u = new C0273u(context, null);
                this.f1232d = c0273u;
                c0273u.setSingleLine();
                this.f1232d.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1242n;
                if (i2 != 0) {
                    this.f1232d.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f1220B;
                if (colorStateList != null) {
                    this.f1232d.setTextColor(colorStateList);
                }
            }
            if (!l(this.f1232d)) {
                b(this.f1232d, true);
            }
        } else {
            C0273u c0273u2 = this.f1232d;
            if (c0273u2 != null && l(c0273u2)) {
                removeView(this.f1232d);
                this.f1225G.remove(this.f1232d);
            }
        }
        C0273u c0273u3 = this.f1232d;
        if (c0273u3 != null) {
            c0273u3.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f1220B = colorStateList;
        C0273u c0273u = this.f1232d;
        if (c0273u != null) {
            c0273u.setTextColor(colorStateList);
        }
    }

    public void setOnMenuItemClickListener(m0 m0Var) {
    }
}
