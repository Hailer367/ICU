package androidx.appcompat.widget;

import I.C0065t;
import I.InterfaceC0064s;
import I.K;
import I.T;
import I.X;
import I.a0;
import I.b0;
import I.c0;
import I.d0;
import I.e0;
import I.f0;
import I.g0;
import I.h0;
import I.r;
import I.r0;
import I.v0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.icaremc.app.R;
import f1.AbstractC0286a;
import j.Q;
import j2.C0427b;
import java.util.WeakHashMap;
import n.InterfaceC0448A;
import n.n;
import o.C0512e;
import o.C0523j;
import o.InterfaceC0509d;
import o.InterfaceC0536p0;
import o.InterfaceC0538q0;
import o.RunnableC0506c;
import o.s1;
import o.x1;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0536p0, r, InterfaceC0064s {

    /* renamed from: G, reason: collision with root package name */
    public static final int[] f2318G = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* renamed from: A, reason: collision with root package name */
    public OverScroller f2319A;

    /* renamed from: B, reason: collision with root package name */
    public ViewPropertyAnimator f2320B;

    /* renamed from: C, reason: collision with root package name */
    public final X f2321C;

    /* renamed from: D, reason: collision with root package name */
    public final RunnableC0506c f2322D;

    /* renamed from: E, reason: collision with root package name */
    public final RunnableC0506c f2323E;

    /* renamed from: F, reason: collision with root package name */
    public final C0065t f2324F;

    /* renamed from: f, reason: collision with root package name */
    public int f2325f;

    /* renamed from: g, reason: collision with root package name */
    public int f2326g;

    /* renamed from: h, reason: collision with root package name */
    public ContentFrameLayout f2327h;

    /* renamed from: i, reason: collision with root package name */
    public ActionBarContainer f2328i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0538q0 f2329j;
    public Drawable k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2330l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2331m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2332n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2333o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2334p;

    /* renamed from: q, reason: collision with root package name */
    public int f2335q;

    /* renamed from: r, reason: collision with root package name */
    public int f2336r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f2337s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f2338t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f2339u;

    /* renamed from: v, reason: collision with root package name */
    public v0 f2340v;

    /* renamed from: w, reason: collision with root package name */
    public v0 f2341w;

    /* renamed from: x, reason: collision with root package name */
    public v0 f2342x;

    /* renamed from: y, reason: collision with root package name */
    public v0 f2343y;
    public InterfaceC0509d z;

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, I.t] */
    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2326g = 0;
        this.f2337s = new Rect();
        this.f2338t = new Rect();
        this.f2339u = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        v0 v0Var = v0.f787b;
        this.f2340v = v0Var;
        this.f2341w = v0Var;
        this.f2342x = v0Var;
        this.f2343y = v0Var;
        this.f2321C = new X(this);
        this.f2322D = new RunnableC0506c(this, 0);
        this.f2323E = new RunnableC0506c(this, 1);
        c(context);
        this.f2324F = new Object();
    }

    public static boolean a(View view, Rect rect, boolean z) {
        boolean z3;
        C0512e c0512e = (C0512e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) c0512e).leftMargin;
        int i5 = rect.left;
        if (i4 != i5) {
            ((ViewGroup.MarginLayoutParams) c0512e).leftMargin = i5;
            z3 = true;
        } else {
            z3 = false;
        }
        int i6 = ((ViewGroup.MarginLayoutParams) c0512e).topMargin;
        int i7 = rect.top;
        if (i6 != i7) {
            ((ViewGroup.MarginLayoutParams) c0512e).topMargin = i7;
            z3 = true;
        }
        int i8 = ((ViewGroup.MarginLayoutParams) c0512e).rightMargin;
        int i9 = rect.right;
        if (i8 != i9) {
            ((ViewGroup.MarginLayoutParams) c0512e).rightMargin = i9;
            z3 = true;
        }
        if (z) {
            int i10 = ((ViewGroup.MarginLayoutParams) c0512e).bottomMargin;
            int i11 = rect.bottom;
            if (i10 != i11) {
                ((ViewGroup.MarginLayoutParams) c0512e).bottomMargin = i11;
                return true;
            }
        }
        return z3;
    }

    public final void b() {
        removeCallbacks(this.f2322D);
        removeCallbacks(this.f2323E);
        ViewPropertyAnimator viewPropertyAnimator = this.f2320B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void c(Context context) {
        boolean z;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2318G);
        boolean z3 = false;
        this.f2325f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.k = drawable;
        if (drawable == null) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z3 = true;
        }
        this.f2330l = z3;
        this.f2319A = new OverScroller(context);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0512e;
    }

    public final void d(int i4) {
        e();
        if (i4 != 2) {
            if (i4 != 5) {
                if (i4 != 109) {
                    return;
                }
                setOverlayMode(true);
                return;
            } else {
                ((x1) this.f2329j).getClass();
                Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
                return;
            }
        }
        ((x1) this.f2329j).getClass();
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i4;
        super.draw(canvas);
        if (this.k != null && !this.f2330l) {
            if (this.f2328i.getVisibility() == 0) {
                i4 = (int) (this.f2328i.getTranslationY() + this.f2328i.getBottom() + 0.5f);
            } else {
                i4 = 0;
            }
            this.k.setBounds(0, i4, getWidth(), this.k.getIntrinsicHeight() + i4);
            this.k.draw(canvas);
        }
    }

    public final void e() {
        InterfaceC0538q0 wrapper;
        if (this.f2327h == null) {
            this.f2327h = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f2328i = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof InterfaceC0538q0) {
                wrapper = (InterfaceC0538q0) findViewById;
            } else if (findViewById instanceof Toolbar) {
                wrapper = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            }
            this.f2329j = wrapper;
        }
    }

    public final void f(Menu menu, InterfaceC0448A interfaceC0448A) {
        e();
        x1 x1Var = (x1) this.f2329j;
        Toolbar toolbar = x1Var.f5734a;
        if (x1Var.f5745m == null) {
            x1Var.f5745m = new C0523j(toolbar.getContext());
        }
        C0523j c0523j = x1Var.f5745m;
        c0523j.f5605j = interfaceC0448A;
        n nVar = (n) menu;
        if (nVar != null || toolbar.f2474f != null) {
            toolbar.f();
            n nVar2 = toolbar.f2474f.f2350u;
            if (nVar2 == nVar) {
                return;
            }
            if (nVar2 != null) {
                nVar2.r(toolbar.f2465Q);
                nVar2.r(toolbar.f2466R);
            }
            if (toolbar.f2466R == null) {
                toolbar.f2466R = new s1(toolbar);
            }
            c0523j.f5616v = true;
            if (nVar != null) {
                nVar.b(c0523j, toolbar.f2482o);
                nVar.b(toolbar.f2466R, toolbar.f2482o);
            } else {
                c0523j.g(toolbar.f2482o, null);
                toolbar.f2466R.g(toolbar.f2482o, null);
                c0523j.d();
                toolbar.f2466R.d();
            }
            toolbar.f2474f.setPopupTheme(toolbar.f2483p);
            toolbar.f2474f.setPresenter(c0523j);
            toolbar.f2465Q = c0523j;
            toolbar.v();
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2328i;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0065t c0065t = this.f2324F;
        return c0065t.f786b | c0065t.f785a;
    }

    public CharSequence getTitle() {
        e();
        return ((x1) this.f2329j).f5734a.getTitle();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        e();
        v0 c4 = v0.c(windowInsets, this);
        r0 r0Var = c4.f788a;
        boolean a4 = a(this.f2328i, new Rect(r0Var.l().f124a, r0Var.l().f125b, r0Var.l().f126c, r0Var.l().f127d), false);
        WeakHashMap weakHashMap = T.f702a;
        Rect rect = this.f2337s;
        K.b(this, c4, rect);
        v0 p3 = r0Var.p(rect.left, rect.top, rect.right, rect.bottom);
        this.f2340v = p3;
        boolean z = true;
        if (!this.f2341w.equals(p3)) {
            this.f2341w = this.f2340v;
            a4 = true;
        }
        Rect rect2 = this.f2338t;
        if (!rect2.equals(rect)) {
            rect2.set(rect);
        } else {
            z = a4;
        }
        if (z) {
            requestLayout();
        }
        return r0Var.a().f788a.c().f788a.b().b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c(getContext());
        WeakHashMap weakHashMap = T.f702a;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0512e c0512e = (C0512e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = ((ViewGroup.MarginLayoutParams) c0512e).leftMargin + paddingLeft;
                int i10 = ((ViewGroup.MarginLayoutParams) c0512e).topMargin + paddingTop;
                childAt.layout(i9, i10, measuredWidth + i9, measuredHeight + i10);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        boolean z;
        int measuredHeight;
        h0 a0Var;
        e();
        measureChildWithMargins(this.f2328i, i4, 0, i5, 0);
        C0512e c0512e = (C0512e) this.f2328i.getLayoutParams();
        int max = Math.max(0, this.f2328i.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0512e).leftMargin + ((ViewGroup.MarginLayoutParams) c0512e).rightMargin);
        int max2 = Math.max(0, this.f2328i.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0512e).topMargin + ((ViewGroup.MarginLayoutParams) c0512e).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f2328i.getMeasuredState());
        WeakHashMap weakHashMap = T.f702a;
        if ((getWindowSystemUiVisibility() & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            measuredHeight = this.f2325f;
            if (this.f2332n && this.f2328i.getTabContainer() != null) {
                measuredHeight += this.f2325f;
            }
        } else {
            measuredHeight = this.f2328i.getVisibility() != 8 ? this.f2328i.getMeasuredHeight() : 0;
        }
        Rect rect = this.f2337s;
        Rect rect2 = this.f2339u;
        rect2.set(rect);
        v0 v0Var = this.f2340v;
        this.f2342x = v0Var;
        if (!this.f2331m && !z) {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            this.f2342x = v0Var.f788a.p(0, measuredHeight, 0, 0);
        } else {
            B.c b4 = B.c.b(v0Var.f788a.l().f124a, this.f2342x.f788a.l().f125b + measuredHeight, this.f2342x.f788a.l().f126c, this.f2342x.f788a.l().f127d);
            v0 v0Var2 = this.f2342x;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 36) {
                a0Var = new g0(v0Var2);
            } else if (i6 >= 35) {
                a0Var = new f0(v0Var2);
            } else if (i6 >= 34) {
                a0Var = new e0(v0Var2);
            } else if (i6 >= 31) {
                a0Var = new d0(v0Var2);
            } else if (i6 >= 30) {
                a0Var = new c0(v0Var2);
            } else if (i6 >= 29) {
                a0Var = new b0(v0Var2);
            } else {
                a0Var = new a0(v0Var2);
            }
            a0Var.h(b4);
            this.f2342x = a0Var.b();
        }
        a(this.f2327h, rect2, true);
        if (!this.f2343y.equals(this.f2342x)) {
            v0 v0Var3 = this.f2342x;
            this.f2343y = v0Var3;
            T.b(this.f2327h, v0Var3);
        }
        measureChildWithMargins(this.f2327h, i4, 0, i5, 0);
        C0512e c0512e2 = (C0512e) this.f2327h.getLayoutParams();
        int max3 = Math.max(max, this.f2327h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0512e2).leftMargin + ((ViewGroup.MarginLayoutParams) c0512e2).rightMargin);
        int max4 = Math.max(max2, this.f2327h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0512e2).topMargin + ((ViewGroup.MarginLayoutParams) c0512e2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f2327h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i4, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i5, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z) {
        if (this.f2333o && z) {
            this.f2319A.fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (this.f2319A.getFinalY() > this.f2328i.getHeight()) {
                b();
                this.f2323E.run();
            } else {
                b();
                this.f2322D.run();
            }
            this.f2334p = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
    }

    @Override // I.InterfaceC0064s
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        onNestedScroll(view, i4, i5, i6, i7, i8);
    }

    @Override // I.r
    public final void onNestedScrollAccepted(View view, View view2, int i4, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(view, view2, i4);
        }
    }

    @Override // I.r
    public final boolean onStartNestedScroll(View view, View view2, int i4, int i5) {
        return i5 == 0 && onStartNestedScroll(view, view2, i4);
    }

    @Override // I.r
    public final void onStopNestedScroll(View view, int i4) {
        if (i4 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i4) {
        boolean z;
        boolean z3;
        super.onWindowSystemUiVisibilityChanged(i4);
        e();
        int i5 = this.f2336r ^ i4;
        this.f2336r = i4;
        if ((i4 & 4) == 0) {
            z = true;
        } else {
            z = false;
        }
        if ((i4 & 256) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        InterfaceC0509d interfaceC0509d = this.z;
        if (interfaceC0509d != null) {
            Q q2 = (Q) interfaceC0509d;
            q2.f4930o = !z3;
            if (!z && z3) {
                if (!q2.f4932q) {
                    q2.f4932q = true;
                    q2.y(true);
                }
            } else if (q2.f4932q) {
                q2.f4932q = false;
                q2.y(true);
            }
        }
        if ((i5 & 256) != 0 && this.z != null) {
            WeakHashMap weakHashMap = T.f702a;
            requestApplyInsets();
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.f2326g = i4;
        InterfaceC0509d interfaceC0509d = this.z;
        if (interfaceC0509d != null) {
            ((Q) interfaceC0509d).f4929n = i4;
        }
    }

    public void setActionBarHideOffset(int i4) {
        b();
        this.f2328i.setTranslationY(-Math.max(0, Math.min(i4, this.f2328i.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0509d interfaceC0509d) {
        this.z = interfaceC0509d;
        if (getWindowToken() != null) {
            ((Q) this.z).f4929n = this.f2326g;
            int i4 = this.f2336r;
            if (i4 != 0) {
                onWindowSystemUiVisibilityChanged(i4);
                WeakHashMap weakHashMap = T.f702a;
                requestApplyInsets();
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f2332n = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f2333o) {
            this.f2333o = z;
            if (!z) {
                b();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i4) {
        e();
        x1 x1Var = (x1) this.f2329j;
        x1Var.f5737d = i4 != 0 ? AbstractC0286a.o(x1Var.f5734a.getContext(), i4) : null;
        x1Var.c();
    }

    public void setLogo(int i4) {
        Drawable drawable;
        e();
        x1 x1Var = (x1) this.f2329j;
        if (i4 != 0) {
            drawable = AbstractC0286a.o(x1Var.f5734a.getContext(), i4);
        } else {
            drawable = null;
        }
        x1Var.f5738e = drawable;
        x1Var.c();
    }

    public void setOverlayMode(boolean z) {
        boolean z3;
        this.f2331m = z;
        if (z && getContext().getApplicationInfo().targetSdkVersion < 19) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f2330l = z3;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i4) {
    }

    @Override // o.InterfaceC0536p0
    public void setWindowCallback(Window.Callback callback) {
        e();
        ((x1) this.f2329j).k = callback;
    }

    @Override // o.InterfaceC0536p0
    public void setWindowTitle(CharSequence charSequence) {
        e();
        x1 x1Var = (x1) this.f2329j;
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

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // I.r
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr, int i6) {
    }

    @Override // I.r
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            onNestedScroll(view, i4, i5, i6, i7);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        Q q2;
        C0427b c0427b;
        this.f2324F.f785a = i4;
        this.f2335q = getActionBarHideOffset();
        b();
        InterfaceC0509d interfaceC0509d = this.z;
        if (interfaceC0509d == null || (c0427b = (q2 = (Q) interfaceC0509d).f4935t) == null) {
            return;
        }
        c0427b.b();
        q2.f4935t = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        if ((i4 & 2) == 0 || this.f2328i.getVisibility() != 0) {
            return false;
        }
        return this.f2333o;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f2333o || this.f2334p) {
            return;
        }
        if (this.f2335q <= this.f2328i.getHeight()) {
            b();
            postDelayed(this.f2322D, 600L);
        } else {
            b();
            postDelayed(this.f2323E, 600L);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        int i8 = this.f2335q + i5;
        this.f2335q = i8;
        setActionBarHideOffset(i8);
    }

    public void setIcon(Drawable drawable) {
        e();
        x1 x1Var = (x1) this.f2329j;
        x1Var.f5737d = drawable;
        x1Var.c();
    }
}
