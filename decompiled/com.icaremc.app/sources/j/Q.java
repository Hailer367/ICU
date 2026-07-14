package j;

import I.T;
import I.Y;
import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import i.AbstractC0357a;
import j2.C0427b;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.AbstractC0438b;
import m.InterfaceC0437a;
import o.InterfaceC0509d;
import o.InterfaceC0538q0;
import o.s1;
import o.x1;

/* loaded from: classes.dex */
public final class Q extends AbstractC0406a implements InterfaceC0509d {

    /* renamed from: a, reason: collision with root package name */
    public Context f4917a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4918b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f4919c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f4920d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0538q0 f4921e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f4922f;

    /* renamed from: g, reason: collision with root package name */
    public final View f4923g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4924h;

    /* renamed from: i, reason: collision with root package name */
    public P f4925i;

    /* renamed from: j, reason: collision with root package name */
    public P f4926j;
    public io.flutter.plugin.platform.s k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4927l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f4928m;

    /* renamed from: n, reason: collision with root package name */
    public int f4929n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4930o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4931p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4932q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4933r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4934s;

    /* renamed from: t, reason: collision with root package name */
    public C0427b f4935t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4936u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4937v;

    /* renamed from: w, reason: collision with root package name */
    public final N f4938w;

    /* renamed from: x, reason: collision with root package name */
    public final N f4939x;

    /* renamed from: y, reason: collision with root package name */
    public final O f4940y;
    public static final AccelerateInterpolator z = new AccelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    public static final DecelerateInterpolator f4916A = new DecelerateInterpolator();

    public Q(Activity activity, boolean z3) {
        new ArrayList();
        this.f4928m = new ArrayList();
        this.f4929n = 0;
        this.f4930o = true;
        this.f4934s = true;
        this.f4938w = new N(this, 0);
        this.f4939x = new N(this, 1);
        this.f4940y = new O(0, this);
        View decorView = activity.getWindow().getDecorView();
        w(decorView);
        if (z3) {
            return;
        }
        this.f4923g = decorView.findViewById(R.id.content);
    }

    @Override // j.AbstractC0406a
    public final boolean b() {
        s1 s1Var;
        n.q qVar;
        InterfaceC0538q0 interfaceC0538q0 = this.f4921e;
        if (interfaceC0538q0 != null && (s1Var = ((x1) interfaceC0538q0).f5734a.f2466R) != null && s1Var.f5705g != null) {
            s1 s1Var2 = ((x1) interfaceC0538q0).f5734a.f2466R;
            if (s1Var2 == null) {
                qVar = null;
            } else {
                qVar = s1Var2.f5705g;
            }
            if (qVar != null) {
                qVar.collapseActionView();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // j.AbstractC0406a
    public final void c(boolean z3) {
        if (z3 != this.f4927l) {
            this.f4927l = z3;
            ArrayList arrayList = this.f4928m;
            if (arrayList.size() <= 0) {
            } else {
                throw A2.i.f(arrayList, 0);
            }
        }
    }

    @Override // j.AbstractC0406a
    public final int d() {
        return ((x1) this.f4921e).f5735b;
    }

    @Override // j.AbstractC0406a
    public final Context e() {
        if (this.f4918b == null) {
            TypedValue typedValue = new TypedValue();
            this.f4917a.getTheme().resolveAttribute(com.icaremc.app.R.attr.actionBarWidgetTheme, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                this.f4918b = new ContextThemeWrapper(this.f4917a, i4);
            } else {
                this.f4918b = this.f4917a;
            }
        }
        return this.f4918b;
    }

    @Override // j.AbstractC0406a
    public final void f() {
        if (!this.f4931p) {
            this.f4931p = true;
            y(false);
        }
    }

    @Override // j.AbstractC0406a
    public final boolean h() {
        int height = this.f4920d.getHeight();
        if (this.f4934s) {
            if (height == 0 || this.f4919c.getActionBarHideOffset() < height) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // j.AbstractC0406a
    public final void i() {
        x(this.f4917a.getResources().getBoolean(com.icaremc.app.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // j.AbstractC0406a
    public final boolean k(int i4, KeyEvent keyEvent) {
        n.n nVar;
        P p3 = this.f4925i;
        if (p3 == null || (nVar = p3.f4913i) == null) {
            return false;
        }
        boolean z3 = true;
        if (KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() == 1) {
            z3 = false;
        }
        nVar.setQwertyMode(z3);
        return nVar.performShortcut(i4, keyEvent, 0);
    }

    @Override // j.AbstractC0406a
    public final void n(ColorDrawable colorDrawable) {
        this.f4920d.setPrimaryBackground(colorDrawable);
    }

    @Override // j.AbstractC0406a
    public final void o(boolean z3) {
        int i4;
        if (!this.f4924h) {
            if (z3) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            x1 x1Var = (x1) this.f4921e;
            int i5 = x1Var.f5735b;
            this.f4924h = true;
            x1Var.a((i4 & 4) | (i5 & (-5)));
        }
    }

    @Override // j.AbstractC0406a
    public final void p(boolean z3) {
        int i4;
        if (z3) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        x1 x1Var = (x1) this.f4921e;
        x1Var.a((i4 & 8) | (x1Var.f5735b & (-9)));
    }

    @Override // j.AbstractC0406a
    public final void q(boolean z3) {
        C0427b c0427b;
        this.f4936u = z3;
        if (!z3 && (c0427b = this.f4935t) != null) {
            c0427b.b();
        }
    }

    @Override // j.AbstractC0406a
    public final void r(CharSequence charSequence) {
        x1 x1Var = (x1) this.f4921e;
        x1Var.f5740g = true;
        Toolbar toolbar = x1Var.f5734a;
        x1Var.f5741h = charSequence;
        if ((x1Var.f5735b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (x1Var.f5740g) {
                T.j(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // j.AbstractC0406a
    public final void s(CharSequence charSequence) {
        x1 x1Var = (x1) this.f4921e;
        if (!x1Var.f5740g) {
            Toolbar toolbar = x1Var.f5734a;
            x1Var.f5741h = charSequence;
            if ((x1Var.f5735b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (x1Var.f5740g) {
                    T.j(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // j.AbstractC0406a
    public final void t() {
        if (this.f4931p) {
            this.f4931p = false;
            y(false);
        }
    }

    @Override // j.AbstractC0406a
    public final AbstractC0438b u(io.flutter.plugin.platform.s sVar) {
        P p3 = this.f4925i;
        if (p3 != null) {
            p3.a();
        }
        this.f4919c.setHideOnContentScrollEnabled(false);
        this.f4922f.e();
        P p4 = new P(this, this.f4922f.getContext(), sVar);
        n.n nVar = p4.f4913i;
        nVar.w();
        try {
            if (((InterfaceC0437a) p4.f4914j.f4390g).b(p4, nVar)) {
                this.f4925i = p4;
                p4.g();
                this.f4922f.c(p4);
                v(true);
                return p4;
            }
            return null;
        } finally {
            nVar.v();
        }
    }

    public final void v(boolean z3) {
        Y i4;
        Y y3;
        long j4;
        if (z3) {
            if (!this.f4933r) {
                this.f4933r = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4919c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                y(false);
            }
        } else if (this.f4933r) {
            this.f4933r = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4919c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            y(false);
        }
        ActionBarContainer actionBarContainer = this.f4920d;
        WeakHashMap weakHashMap = T.f702a;
        if (actionBarContainer.isLaidOut()) {
            if (z3) {
                x1 x1Var = (x1) this.f4921e;
                i4 = T.a(x1Var.f5734a);
                i4.a(0.0f);
                i4.c(100L);
                i4.d(new m.k(x1Var, 4));
                y3 = this.f4922f.i(200L, 0);
            } else {
                x1 x1Var2 = (x1) this.f4921e;
                Y a4 = T.a(x1Var2.f5734a);
                a4.a(1.0f);
                a4.c(200L);
                a4.d(new m.k(x1Var2, 0));
                i4 = this.f4922f.i(100L, 8);
                y3 = a4;
            }
            C0427b c0427b = new C0427b();
            ArrayList arrayList = (ArrayList) c0427b.f5058h;
            arrayList.add(i4);
            View view = (View) i4.f712a.get();
            if (view != null) {
                j4 = view.animate().getDuration();
            } else {
                j4 = 0;
            }
            View view2 = (View) y3.f712a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j4);
            }
            arrayList.add(y3);
            c0427b.f();
            return;
        }
        if (z3) {
            ((x1) this.f4921e).f5734a.setVisibility(4);
            this.f4922f.setVisibility(0);
        } else {
            ((x1) this.f4921e).f5734a.setVisibility(0);
            this.f4922f.setVisibility(8);
        }
    }

    public final void w(View view) {
        String str;
        InterfaceC0538q0 wrapper;
        boolean z3;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.icaremc.app.R.id.decor_content_parent);
        this.f4919c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(com.icaremc.app.R.id.action_bar);
        if (findViewById instanceof InterfaceC0538q0) {
            wrapper = (InterfaceC0538q0) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = "null";
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.f4921e = wrapper;
        this.f4922f = (ActionBarContextView) view.findViewById(com.icaremc.app.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.icaremc.app.R.id.action_bar_container);
        this.f4920d = actionBarContainer;
        InterfaceC0538q0 interfaceC0538q0 = this.f4921e;
        if (interfaceC0538q0 != null && this.f4922f != null && actionBarContainer != null) {
            Context context = ((x1) interfaceC0538q0).f5734a.getContext();
            this.f4917a = context;
            if ((((x1) this.f4921e).f5735b & 4) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                this.f4924h = true;
            }
            int i4 = context.getApplicationInfo().targetSdkVersion;
            this.f4921e.getClass();
            x(context.getResources().getBoolean(com.icaremc.app.R.bool.abc_action_bar_embed_tabs));
            TypedArray obtainStyledAttributes = this.f4917a.obtainStyledAttributes(null, AbstractC0357a.f4066a, com.icaremc.app.R.attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(14, false)) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4919c;
                if (actionBarOverlayLayout2.f2331m) {
                    this.f4937v = true;
                    actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
                } else {
                    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                }
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
            if (dimensionPixelSize != 0) {
                ActionBarContainer actionBarContainer2 = this.f4920d;
                WeakHashMap weakHashMap = T.f702a;
                actionBarContainer2.setElevation(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(Q.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
    }

    public final void x(boolean z3) {
        if (!z3) {
            ((x1) this.f4921e).getClass();
            this.f4920d.setTabContainer(null);
        } else {
            this.f4920d.setTabContainer(null);
            ((x1) this.f4921e).getClass();
        }
        this.f4921e.getClass();
        ((x1) this.f4921e).f5734a.setCollapsible(false);
        this.f4919c.setHasNonEmbeddedTabs(false);
    }

    public final void y(boolean z3) {
        boolean z4 = this.f4931p;
        boolean z5 = this.f4932q;
        boolean z6 = this.f4933r;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        final O o3 = this.f4940y;
        View view = this.f4923g;
        if (z6 || (!z4 && !z5)) {
            if (!this.f4934s) {
                this.f4934s = true;
                C0427b c0427b = this.f4935t;
                if (c0427b != null) {
                    c0427b.b();
                }
                this.f4920d.setVisibility(0);
                int i4 = this.f4929n;
                N n3 = this.f4939x;
                if (i4 == 0 && (this.f4936u || z3)) {
                    this.f4920d.setTranslationY(0.0f);
                    float f4 = -this.f4920d.getHeight();
                    if (z3) {
                        this.f4920d.getLocationInWindow(new int[]{0, 0});
                        f4 -= r12[1];
                    }
                    this.f4920d.setTranslationY(f4);
                    C0427b c0427b2 = new C0427b();
                    ArrayList arrayList = (ArrayList) c0427b2.f5058h;
                    Y a4 = T.a(this.f4920d);
                    a4.e(0.0f);
                    final View view2 = (View) a4.f712a.get();
                    if (view2 != null) {
                        if (o3 != null) {
                            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(view2) { // from class: I.W
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ((View) ((j.Q) j.O.this.f4911g).f4920d.getParent()).invalidate();
                                }
                            };
                        }
                        view2.animate().setUpdateListener(animatorUpdateListener);
                    }
                    if (!c0427b2.f5057g) {
                        arrayList.add(a4);
                    }
                    if (this.f4930o && view != null) {
                        view.setTranslationY(f4);
                        Y a5 = T.a(view);
                        a5.e(0.0f);
                        if (!c0427b2.f5057g) {
                            arrayList.add(a5);
                        }
                    }
                    boolean z7 = c0427b2.f5057g;
                    if (!z7) {
                        c0427b2.f5059i = f4916A;
                    }
                    if (!z7) {
                        c0427b2.f5056f = 250L;
                    }
                    if (!z7) {
                        c0427b2.f5060j = n3;
                    }
                    this.f4935t = c0427b2;
                    c0427b2.f();
                } else {
                    this.f4920d.setAlpha(1.0f);
                    this.f4920d.setTranslationY(0.0f);
                    if (this.f4930o && view != null) {
                        view.setTranslationY(0.0f);
                    }
                    n3.a();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4919c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = T.f702a;
                    actionBarOverlayLayout.requestApplyInsets();
                    return;
                }
                return;
            }
            return;
        }
        if (this.f4934s) {
            this.f4934s = false;
            C0427b c0427b3 = this.f4935t;
            if (c0427b3 != null) {
                c0427b3.b();
            }
            int i5 = this.f4929n;
            N n4 = this.f4938w;
            if (i5 == 0 && (this.f4936u || z3)) {
                this.f4920d.setAlpha(1.0f);
                this.f4920d.setTransitioning(true);
                C0427b c0427b4 = new C0427b();
                ArrayList arrayList2 = (ArrayList) c0427b4.f5058h;
                float f5 = -this.f4920d.getHeight();
                if (z3) {
                    this.f4920d.getLocationInWindow(new int[]{0, 0});
                    f5 -= r12[1];
                }
                Y a6 = T.a(this.f4920d);
                a6.e(f5);
                final View view3 = (View) a6.f712a.get();
                if (view3 != null) {
                    if (o3 != null) {
                        animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(view3) { // from class: I.W
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                ((View) ((j.Q) j.O.this.f4911g).f4920d.getParent()).invalidate();
                            }
                        };
                    }
                    view3.animate().setUpdateListener(animatorUpdateListener);
                }
                if (!c0427b4.f5057g) {
                    arrayList2.add(a6);
                }
                if (this.f4930o && view != null) {
                    Y a7 = T.a(view);
                    a7.e(f5);
                    if (!c0427b4.f5057g) {
                        arrayList2.add(a7);
                    }
                }
                boolean z8 = c0427b4.f5057g;
                if (!z8) {
                    c0427b4.f5059i = z;
                }
                if (!z8) {
                    c0427b4.f5056f = 250L;
                }
                if (!z8) {
                    c0427b4.f5060j = n4;
                }
                this.f4935t = c0427b4;
                c0427b4.f();
                return;
            }
            n4.a();
        }
    }

    public Q(Dialog dialog) {
        new ArrayList();
        this.f4928m = new ArrayList();
        this.f4929n = 0;
        this.f4930o = true;
        this.f4934s = true;
        this.f4938w = new N(this, 0);
        this.f4939x = new N(this, 1);
        this.f4940y = new O(0, this);
        w(dialog.getWindow().getDecorView());
    }
}
