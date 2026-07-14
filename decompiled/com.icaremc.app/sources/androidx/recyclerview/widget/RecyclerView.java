package androidx.recyclerview.widget;

import A2.i;
import A2.q;
import A2.t;
import C.a;
import F.b;
import F.k;
import H1.f;
import I.C0063q;
import I.M;
import I.T;
import I.U;
import N.c;
import T2.h;
import W0.g;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import g0.AbstractC0293a;
import h0.AbstractC0302E;
import h0.AbstractC0312O;
import h0.AbstractC0329q;
import h0.AbstractC0332t;
import h0.AbstractC0333u;
import h0.AbstractC0335w;
import h0.C0298A;
import h0.C0300C;
import h0.C0301D;
import h0.C0305H;
import h0.C0314b;
import h0.C0319g;
import h0.C0320h;
import h0.C0331s;
import h0.C0334v;
import h0.InterfaceC0299B;
import h0.InterfaceC0330r;
import h0.InterpolatorC0328p;
import h0.RunnableC0303F;
import h0.RunnableC0322j;
import h0.x;
import h0.y;
import h0.z;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import t.C0658g;
import t.C0661j;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {
    public static final int[] m0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: n0, reason: collision with root package name */
    public static final int[] f3077n0 = {R.attr.clipToPadding};

    /* renamed from: o0, reason: collision with root package name */
    public static final Class[] f3078o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final InterpolatorC0328p f3079p0;

    /* renamed from: A, reason: collision with root package name */
    public boolean f3080A;

    /* renamed from: B, reason: collision with root package name */
    public int f3081B;

    /* renamed from: C, reason: collision with root package name */
    public final int f3082C;

    /* renamed from: D, reason: collision with root package name */
    public C0331s f3083D;

    /* renamed from: E, reason: collision with root package name */
    public EdgeEffect f3084E;

    /* renamed from: F, reason: collision with root package name */
    public EdgeEffect f3085F;

    /* renamed from: G, reason: collision with root package name */
    public EdgeEffect f3086G;

    /* renamed from: H, reason: collision with root package name */
    public EdgeEffect f3087H;

    /* renamed from: I, reason: collision with root package name */
    public AbstractC0332t f3088I;

    /* renamed from: J, reason: collision with root package name */
    public int f3089J;

    /* renamed from: K, reason: collision with root package name */
    public int f3090K;

    /* renamed from: L, reason: collision with root package name */
    public VelocityTracker f3091L;

    /* renamed from: M, reason: collision with root package name */
    public int f3092M;

    /* renamed from: N, reason: collision with root package name */
    public int f3093N;

    /* renamed from: O, reason: collision with root package name */
    public int f3094O;
    public int P;

    /* renamed from: Q, reason: collision with root package name */
    public int f3095Q;

    /* renamed from: R, reason: collision with root package name */
    public final int f3096R;

    /* renamed from: S, reason: collision with root package name */
    public final int f3097S;

    /* renamed from: T, reason: collision with root package name */
    public final float f3098T;

    /* renamed from: U, reason: collision with root package name */
    public final float f3099U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f3100V;

    /* renamed from: W, reason: collision with root package name */
    public final RunnableC0303F f3101W;

    /* renamed from: a0, reason: collision with root package name */
    public RunnableC0322j f3102a0;

    /* renamed from: b0, reason: collision with root package name */
    public final C0320h f3103b0;

    /* renamed from: c0, reason: collision with root package name */
    public final C0301D f3104c0;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList f3105d0;

    /* renamed from: e0, reason: collision with root package name */
    public final g f3106e0;

    /* renamed from: f, reason: collision with root package name */
    public final C0298A f3107f;

    /* renamed from: f0, reason: collision with root package name */
    public C0305H f3108f0;

    /* renamed from: g, reason: collision with root package name */
    public C0300C f3109g;

    /* renamed from: g0, reason: collision with root package name */
    public C0063q f3110g0;

    /* renamed from: h, reason: collision with root package name */
    public final t f3111h;

    /* renamed from: h0, reason: collision with root package name */
    public final int[] f3112h0;

    /* renamed from: i, reason: collision with root package name */
    public final t f3113i;

    /* renamed from: i0, reason: collision with root package name */
    public final int[] f3114i0;

    /* renamed from: j, reason: collision with root package name */
    public final f f3115j;

    /* renamed from: j0, reason: collision with root package name */
    public final int[] f3116j0;
    public boolean k;

    /* renamed from: k0, reason: collision with root package name */
    public final ArrayList f3117k0;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f3118l;

    /* renamed from: l0, reason: collision with root package name */
    public final b f3119l0;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f3120m;

    /* renamed from: n, reason: collision with root package name */
    public AbstractC0333u f3121n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f3122o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f3123p;

    /* renamed from: q, reason: collision with root package name */
    public C0319g f3124q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3125r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3126s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3127t;

    /* renamed from: u, reason: collision with root package name */
    public int f3128u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3129v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3130w;

    /* renamed from: x, reason: collision with root package name */
    public int f3131x;

    /* renamed from: y, reason: collision with root package name */
    public final AccessibilityManager f3132y;
    public boolean z;

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, h0.p] */
    static {
        Class cls = Integer.TYPE;
        f3078o0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f3079p0 = new Object();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [H1.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, h0.s] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, h0.c, h0.t] */
    /* JADX WARN: Type inference failed for: r2v17, types: [h0.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.Object, h0.D] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object, W0.g] */
    public RecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        float a4;
        float a5;
        boolean z;
        int i4;
        ClassLoader classLoader;
        Constructor constructor;
        this.f3107f = new C0298A(this);
        ?? obj = new Object();
        new C0661j(0);
        new C0658g();
        this.f3115j = obj;
        this.f3118l = new Rect();
        this.f3120m = new Rect();
        new RectF();
        this.f3122o = new ArrayList();
        this.f3123p = new ArrayList();
        this.f3128u = 0;
        this.z = false;
        this.f3080A = false;
        this.f3081B = 0;
        this.f3082C = 0;
        this.f3083D = new Object();
        ?? obj2 = new Object();
        Object[] objArr = null;
        obj2.f3926a = null;
        obj2.f3927b = new ArrayList();
        obj2.f3928c = 250L;
        obj2.f3929d = 250L;
        obj2.f3863e = new ArrayList();
        obj2.f3864f = new ArrayList();
        obj2.f3865g = new ArrayList();
        obj2.f3866h = new ArrayList();
        obj2.f3867i = new ArrayList();
        obj2.f3868j = new ArrayList();
        obj2.k = new ArrayList();
        obj2.f3869l = new ArrayList();
        obj2.f3870m = new ArrayList();
        obj2.f3871n = new ArrayList();
        obj2.f3872o = new ArrayList();
        this.f3088I = obj2;
        this.f3089J = 0;
        this.f3090K = -1;
        this.f3098T = Float.MIN_VALUE;
        this.f3099U = Float.MIN_VALUE;
        boolean z3 = true;
        this.f3100V = true;
        this.f3101W = new RunnableC0303F(this);
        this.f3103b0 = new Object();
        ?? obj3 = new Object();
        obj3.f3824a = 0;
        obj3.f3825b = false;
        obj3.f3826c = false;
        obj3.f3827d = false;
        obj3.f3828e = false;
        this.f3104c0 = obj3;
        ?? obj4 = new Object();
        this.f3106e0 = obj4;
        this.f3112h0 = new int[2];
        this.f3114i0 = new int[2];
        this.f3116j0 = new int[2];
        this.f3117k0 = new ArrayList();
        this.f3119l0 = new b(12, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3077n0, 0, 0);
            this.k = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.k = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3095Q = viewConfiguration.getScaledTouchSlop();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            Method method = U.f707a;
            a4 = a.d(viewConfiguration);
        } else {
            a4 = U.a(viewConfiguration, context);
        }
        this.f3098T = a4;
        if (i5 >= 26) {
            a5 = a.e(viewConfiguration);
        } else {
            a5 = U.a(viewConfiguration, context);
        }
        this.f3099U = a5;
        this.f3096R = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3097S = viewConfiguration.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.f3088I.f3926a = obj4;
        this.f3111h = new t(new f(this));
        this.f3113i = new t(new q(23, this));
        WeakHashMap weakHashMap = T.f702a;
        if (i5 >= 26) {
            i4 = M.a(this);
        } else {
            i4 = 0;
        }
        if (i4 == 0 && i5 >= 26) {
            M.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f3132y = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C0305H(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0293a.f3767a, 0, 0);
            String string = obtainStyledAttributes2.getString(7);
            if (obtainStyledAttributes2.getInt(1, -1) == -1) {
                setDescendantFocusability(262144);
            }
            if (obtainStyledAttributes2.getBoolean(2, false)) {
                StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes2.getDrawable(5);
                Drawable drawable = obtainStyledAttributes2.getDrawable(6);
                StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes2.getDrawable(3);
                Drawable drawable2 = obtainStyledAttributes2.getDrawable(4);
                if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
                    Resources resources = getContext().getResources();
                    new C0319g(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.icaremc.app.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.icaremc.app.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.icaremc.app.R.dimen.fastscroll_margin));
                } else {
                    throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + h());
                }
            }
            obtainStyledAttributes2.recycle();
            if (string != null) {
                String trim = string.trim();
                if (!trim.isEmpty()) {
                    if (trim.charAt(0) == '.') {
                        trim = context.getPackageName() + trim;
                    } else if (!trim.contains(".")) {
                        trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                    }
                    String str = trim;
                    try {
                        if (isInEditMode()) {
                            classLoader = getClass().getClassLoader();
                        } else {
                            classLoader = context.getClassLoader();
                        }
                        Class<? extends U> asSubclass = classLoader.loadClass(str).asSubclass(AbstractC0333u.class);
                        try {
                            constructor = asSubclass.getConstructor(f3078o0);
                            objArr = new Object[]{context, attributeSet, 0, 0};
                        } catch (NoSuchMethodException e4) {
                            try {
                                constructor = asSubclass.getConstructor(null);
                            } catch (NoSuchMethodException e5) {
                                e5.initCause(e4);
                                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e5);
                            }
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((AbstractC0333u) constructor.newInstance(objArr));
                    } catch (ClassCastException e6) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e6);
                    } catch (ClassNotFoundException e7) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e7);
                    } catch (IllegalAccessException e8) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e8);
                    } catch (InstantiationException e9) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e9);
                    } catch (InvocationTargetException e10) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e10);
                    }
                }
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, m0, 0, 0);
            z3 = obtainStyledAttributes3.getBoolean(0, true);
            obtainStyledAttributes3.recycle();
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z3);
    }

    private C0063q getScrollingChildHelper() {
        if (this.f3110g0 == null) {
            this.f3110g0 = new C0063q(this);
        }
        return this.f3110g0;
    }

    public static void j(View view) {
        if (view == null) {
            return;
        }
        ((C0334v) view.getLayoutParams()).getClass();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i4, int i5) {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null) {
            abstractC0333u.getClass();
        }
        super.addFocusables(arrayList, i4, i5);
    }

    public final void b(String str) {
        if (this.f3081B > 0) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + h());
            }
            throw new IllegalStateException(str);
        }
        if (this.f3082C > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + h()));
        }
    }

    public final void c(int i4, int i5) {
        boolean z;
        EdgeEffect edgeEffect = this.f3084E;
        if (edgeEffect != null && !edgeEffect.isFinished() && i4 > 0) {
            this.f3084E.onRelease();
            z = this.f3084E.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.f3086G;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i4 < 0) {
            this.f3086G.onRelease();
            z |= this.f3086G.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3085F;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i5 > 0) {
            this.f3085F.onRelease();
            z |= this.f3085F.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3087H;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i5 < 0) {
            this.f3087H.onRelease();
            z |= this.f3087H.isFinished();
        }
        if (z) {
            WeakHashMap weakHashMap = T.f702a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof C0334v) && this.f3121n.d((C0334v) layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null && abstractC0333u.b()) {
            return this.f3121n.f(this.f3104c0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null && abstractC0333u.b()) {
            this.f3121n.g(this.f3104c0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null && abstractC0333u.b()) {
            return this.f3121n.h(this.f3104c0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null && abstractC0333u.c()) {
            return this.f3121n.i(this.f3104c0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null && abstractC0333u.c()) {
            this.f3121n.j(this.f3104c0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null && abstractC0333u.c()) {
            return this.f3121n.k(this.f3104c0);
        }
        return 0;
    }

    public final void d() {
        if (this.f3127t && !this.z) {
            t tVar = this.f3111h;
            if (((ArrayList) tVar.f100h).size() > 0) {
                tVar.getClass();
                if (((ArrayList) tVar.f100h).size() > 0) {
                    int i4 = E.g.f456a;
                    Trace.beginSection("RV FullInvalidate");
                    Log.e("RecyclerView", "No adapter attached; skipping layout");
                    Trace.endSection();
                    return;
                }
                return;
            }
            return;
        }
        int i5 = E.g.f456a;
        Trace.beginSection("RV FullInvalidate");
        Log.e("RecyclerView", "No adapter attached; skipping layout");
        Trace.endSection();
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z) {
        return getScrollingChildHelper().a(f4, f5, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return getScrollingChildHelper().b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return getScrollingChildHelper().d(i4, i5, i6, i7, iArr, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        boolean z3;
        int i4;
        boolean z4;
        boolean z5;
        int i5;
        super.draw(canvas);
        ArrayList arrayList = this.f3122o;
        int size = arrayList.size();
        boolean z6 = false;
        int i6 = 0;
        while (true) {
            z = true;
            if (i6 >= size) {
                break;
            }
            C0319g c0319g = (C0319g) arrayList.get(i6);
            if (c0319g.f3888l == c0319g.f3890n.getWidth() && c0319g.f3889m == c0319g.f3890n.getHeight()) {
                if (c0319g.f3898v != 0) {
                    if (c0319g.f3891o) {
                        int i7 = c0319g.f3888l;
                        int i8 = c0319g.f3881d;
                        int i9 = i7 - i8;
                        int i10 = 0 - (0 / 2);
                        StateListDrawable stateListDrawable = c0319g.f3879b;
                        stateListDrawable.setBounds(0, 0, i8, 0);
                        Drawable drawable = c0319g.f3880c;
                        drawable.setBounds(0, 0, c0319g.f3882e, c0319g.f3889m);
                        RecyclerView recyclerView = c0319g.f3890n;
                        WeakHashMap weakHashMap = T.f702a;
                        if (recyclerView.getLayoutDirection() == 1) {
                            drawable.draw(canvas);
                            canvas.translate(i8, i10);
                            canvas.scale(-1.0f, 1.0f);
                            stateListDrawable.draw(canvas);
                            canvas.scale(1.0f, 1.0f);
                            canvas.translate(-i8, -i10);
                        } else {
                            canvas.translate(i9, 0.0f);
                            drawable.draw(canvas);
                            canvas.translate(0.0f, i10);
                            stateListDrawable.draw(canvas);
                            canvas.translate(-i9, -i10);
                        }
                    }
                    if (c0319g.f3892p) {
                        int i11 = c0319g.f3889m;
                        int i12 = c0319g.f3885h;
                        int i13 = i11 - i12;
                        StateListDrawable stateListDrawable2 = c0319g.f3883f;
                        stateListDrawable2.setBounds(0, 0, 0, i12);
                        Drawable drawable2 = c0319g.f3884g;
                        drawable2.setBounds(0, 0, c0319g.f3888l, c0319g.f3886i);
                        canvas.translate(0.0f, i13);
                        drawable2.draw(canvas);
                        canvas.translate(0 - (0 / 2), 0.0f);
                        stateListDrawable2.draw(canvas);
                        canvas.translate(-r8, -i13);
                    }
                }
            } else {
                c0319g.f3888l = c0319g.f3890n.getWidth();
                c0319g.f3889m = c0319g.f3890n.getHeight();
                c0319g.e(0);
            }
            i6++;
        }
        EdgeEffect edgeEffect = this.f3084E;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.k) {
                i5 = getPaddingBottom();
            } else {
                i5 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i5, 0.0f);
            EdgeEffect edgeEffect2 = this.f3084E;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z3 = true;
            } else {
                z3 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z3 = false;
        }
        EdgeEffect edgeEffect3 = this.f3085F;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.k) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f3085F;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z5 = true;
            } else {
                z5 = false;
            }
            z3 |= z5;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f3086G;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.k) {
                i4 = getPaddingTop();
            } else {
                i4 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(-i4, -width);
            EdgeEffect edgeEffect6 = this.f3086G;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z4 = true;
            } else {
                z4 = false;
            }
            z3 |= z4;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f3087H;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.k) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f3087H;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z6 = true;
            }
            z3 |= z6;
            canvas.restoreToCount(save4);
        }
        if (z3 || this.f3088I == null || arrayList.size() <= 0 || !this.f3088I.b()) {
            z = z3;
        }
        if (z) {
            WeakHashMap weakHashMap2 = T.f702a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    public final void e(int i4, int i5) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = T.f702a;
        setMeasuredDimension(AbstractC0333u.e(i4, paddingRight, getMinimumWidth()), AbstractC0333u.e(i5, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public final boolean f(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
    
        if (r4 > 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e0, code lost:
    
        if (r7 > 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e3, code lost:
    
        if (r4 < 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e6, code lost:
    
        if (r7 < 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ee, code lost:
    
        if ((r7 * r1) < 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f6, code lost:
    
        if ((r7 * r1) > 0) goto L83;
     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r13, int r14) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final boolean g(int[] iArr, int i4) {
        return getScrollingChildHelper().d(0, 0, 0, 0, iArr, i4, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null) {
            return abstractC0333u.l();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null) {
            return abstractC0333u.m(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    public AbstractC0329q getAdapter() {
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null) {
            abstractC0333u.getClass();
            return -1;
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i4, int i5) {
        return super.getChildDrawingOrder(i4, i5);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.k;
    }

    public C0305H getCompatAccessibilityDelegate() {
        return this.f3108f0;
    }

    public C0331s getEdgeEffectFactory() {
        return this.f3083D;
    }

    public AbstractC0332t getItemAnimator() {
        return this.f3088I;
    }

    public int getItemDecorationCount() {
        return this.f3122o.size();
    }

    public AbstractC0333u getLayoutManager() {
        return this.f3121n;
    }

    public int getMaxFlingVelocity() {
        return this.f3097S;
    }

    public int getMinFlingVelocity() {
        return this.f3096R;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public AbstractC0335w getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3100V;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [h0.z, java.lang.Object] */
    public z getRecycledViewPool() {
        C0298A c0298a = this.f3107f;
        if (((z) c0298a.f3822j) == null) {
            ?? obj = new Object();
            obj.f3939a = new SparseArray();
            obj.f3940b = 0;
            c0298a.f3822j = obj;
        }
        return (z) c0298a.f3822j;
    }

    public int getScrollState() {
        return this.f3089J;
    }

    public final String h() {
        return " " + super.toString() + ", adapter:null, layout:" + this.f3121n + ", context:" + getContext();
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View i(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            return r3
        L17:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i(android.view.View):android.view.View");
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f3125r;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f781d;
    }

    public final boolean k() {
        return getScrollingChildHelper().f(1);
    }

    public final boolean l() {
        if (this.f3127t && !this.z && ((ArrayList) this.f3111h.f100h).size() <= 0) {
            return false;
        }
        return true;
    }

    public final void m() {
        int L3 = this.f3113i.L();
        for (int i4 = 0; i4 < L3; i4++) {
            ((C0334v) this.f3113i.K(i4).getLayoutParams()).f3938b = true;
        }
        ArrayList arrayList = (ArrayList) this.f3107f.f3821i;
        if (arrayList.size() > 0) {
            throw i.f(arrayList, 0);
        }
    }

    public final void n(MotionEvent motionEvent) {
        int i4;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3090K) {
            if (actionIndex == 0) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            this.f3090K = motionEvent.getPointerId(i4);
            int x3 = (int) (motionEvent.getX(i4) + 0.5f);
            this.f3094O = x3;
            this.f3092M = x3;
            int y3 = (int) (motionEvent.getY(i4) + 0.5f);
            this.P = y3;
            this.f3093N = y3;
        }
    }

    public final void o(View view, View view2) {
        View view3;
        boolean z;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f3118l;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C0334v) {
            C0334v c0334v = (C0334v) layoutParams;
            if (!c0334v.f3938b) {
                Rect rect2 = c0334v.f3937a;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        AbstractC0333u abstractC0333u = this.f3121n;
        boolean z3 = !this.f3127t;
        if (view2 == null) {
            z = true;
        } else {
            z = false;
        }
        abstractC0333u.G(this, view, this.f3118l, z3, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r1 >= 30.0f) goto L19;
     */
    /* JADX WARN: Type inference failed for: r1v3, types: [h0.j, java.lang.Object] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f3081B = r0
            r1 = 1
            r5.f3125r = r1
            boolean r2 = r5.f3127t
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            r0 = r1
        L14:
            r5.f3127t = r0
            h0.u r0 = r5.f3121n
            if (r0 == 0) goto L1c
            r0.f3934e = r1
        L1c:
            java.lang.ThreadLocal r0 = h0.RunnableC0322j.f3908j
            java.lang.Object r1 = r0.get()
            h0.j r1 = (h0.RunnableC0322j) r1
            r5.f3102a0 = r1
            if (r1 != 0) goto L64
            h0.j r1 = new h0.j
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f3909f = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f3912i = r2
            r5.f3102a0 = r1
            java.util.WeakHashMap r1 = I.T.f702a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L56
            if (r1 == 0) goto L56
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L56
            goto L58
        L56:
            r1 = 1114636288(0x42700000, float:60.0)
        L58:
            h0.j r2 = r5.f3102a0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f3911h = r3
            r0.set(r2)
        L64:
            h0.j r0 = r5.f3102a0
            java.util.ArrayList r0 = r0.f3909f
            r0.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Object obj;
        super.onDetachedFromWindow();
        AbstractC0332t abstractC0332t = this.f3088I;
        if (abstractC0332t != null) {
            abstractC0332t.a();
        }
        setScrollState(0);
        RunnableC0303F runnableC0303F = this.f3101W;
        runnableC0303F.f3834l.removeCallbacks(runnableC0303F);
        runnableC0303F.f3831h.abortAnimation();
        this.f3125r = false;
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null) {
            abstractC0333u.f3934e = false;
            abstractC0333u.z(this);
        }
        this.f3117k0.clear();
        removeCallbacks(this.f3119l0);
        this.f3115j.getClass();
        do {
            k kVar = AbstractC0312O.f3860a;
            Object[] objArr = (Object[]) kVar.f510b;
            int i4 = kVar.f509a;
            obj = null;
            if (i4 > 0) {
                int i5 = i4 - 1;
                Object obj2 = objArr[i5];
                h.c(obj2, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                objArr[i5] = null;
                kVar.f509a--;
                obj = obj2;
            }
        } while (obj != null);
        RunnableC0322j runnableC0322j = this.f3102a0;
        if (runnableC0322j != null) {
            runnableC0322j.f3909f.remove(this);
            this.f3102a0 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f3122o;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((C0319g) arrayList.get(i4)).getClass();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            h0.u r0 = r5.f3121n
            r1 = 0
            if (r0 != 0) goto L7
            goto L79
        L7:
            boolean r0 = r5.f3129v
            if (r0 == 0) goto Ld
            goto L79
        Ld:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L79
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L40
            h0.u r0 = r5.f3121n
            boolean r0 = r0.c()
            if (r0 == 0) goto L2e
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2f
        L2e:
            r0 = r2
        L2f:
            h0.u r3 = r5.f3121n
            boolean r3 = r3.b()
            if (r3 == 0) goto L3e
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L66
        L3e:
            r3 = r2
            goto L66
        L40:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L64
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            h0.u r3 = r5.f3121n
            boolean r3 = r3.c()
            if (r3 == 0) goto L59
            float r0 = -r0
            goto L3e
        L59:
            h0.u r3 = r5.f3121n
            boolean r3 = r3.b()
            if (r3 == 0) goto L64
            r3 = r0
            r0 = r2
            goto L66
        L64:
            r0 = r2
            r3 = r0
        L66:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6e
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L79
        L6e:
            float r2 = r5.f3098T
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f3099U
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.q(r2, r0, r6)
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.f3129v) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 0) {
                this.f3124q = null;
            }
            ArrayList arrayList = this.f3123p;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                C0319g c0319g = (C0319g) arrayList.get(i4);
                if (c0319g.c(motionEvent) && action != 3) {
                    this.f3124q = c0319g;
                    p();
                    setScrollState(0);
                    return true;
                }
            }
            AbstractC0333u abstractC0333u = this.f3121n;
            if (abstractC0333u != null) {
                boolean b4 = abstractC0333u.b();
                boolean c4 = this.f3121n.c();
                if (this.f3091L == null) {
                    this.f3091L = VelocityTracker.obtain();
                }
                this.f3091L.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked != 5) {
                                    if (actionMasked == 6) {
                                        n(motionEvent);
                                    }
                                } else {
                                    this.f3090K = motionEvent.getPointerId(actionIndex);
                                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                                    this.f3094O = x3;
                                    this.f3092M = x3;
                                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                                    this.P = y3;
                                    this.f3093N = y3;
                                }
                            } else {
                                p();
                                setScrollState(0);
                            }
                        } else {
                            int findPointerIndex = motionEvent.findPointerIndex(this.f3090K);
                            if (findPointerIndex < 0) {
                                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f3090K + " not found. Did any MotionEvents get skipped?");
                                return false;
                            }
                            int x4 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                            int y4 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                            if (this.f3089J != 1) {
                                int i5 = x4 - this.f3092M;
                                int i6 = y4 - this.f3093N;
                                if (b4 != 0 && Math.abs(i5) > this.f3095Q) {
                                    this.f3094O = x4;
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (c4 && Math.abs(i6) > this.f3095Q) {
                                    this.P = y4;
                                    z = true;
                                }
                                if (z) {
                                    setScrollState(1);
                                }
                            }
                        }
                    } else {
                        this.f3091L.clear();
                        s(0);
                    }
                } else {
                    if (this.f3130w) {
                        this.f3130w = false;
                    }
                    this.f3090K = motionEvent.getPointerId(0);
                    int x5 = (int) (motionEvent.getX() + 0.5f);
                    this.f3094O = x5;
                    this.f3092M = x5;
                    int y5 = (int) (motionEvent.getY() + 0.5f);
                    this.P = y5;
                    this.f3093N = y5;
                    if (this.f3089J == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.f3116j0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i7 = b4;
                    if (c4) {
                        i7 = (b4 ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i7, 0);
                }
                if (this.f3089J == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        int i8 = E.g.f456a;
        Trace.beginSection("RV OnLayout");
        Log.e("RecyclerView", "No adapter attached; skipping layout");
        Trace.endSection();
        this.f3127t = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u == null) {
            e(i4, i5);
            return;
        }
        if (abstractC0333u.y()) {
            View.MeasureSpec.getMode(i4);
            View.MeasureSpec.getMode(i5);
            this.f3121n.f3931b.e(i4, i5);
        } else {
            if (this.f3126s) {
                this.f3121n.f3931b.e(i4, i5);
                return;
            }
            C0301D c0301d = this.f3104c0;
            if (c0301d.f3828e) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            c0301d.getClass();
            this.f3128u++;
            this.f3121n.f3931b.e(i4, i5);
            if (this.f3128u < 1) {
                this.f3128u = 1;
            }
            this.f3128u--;
            c0301d.f3826c = false;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (this.f3081B > 0) {
            return false;
        }
        return super.onRequestFocusInDescendants(i4, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0300C)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0300C c0300c = (C0300C) parcelable;
        this.f3109g = c0300c;
        super.onRestoreInstanceState(c0300c.f1062f);
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null && (parcelable2 = this.f3109g.f3823h) != null) {
            abstractC0333u.B(parcelable2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [N.c, android.os.Parcelable, h0.C] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? cVar = new c(super.onSaveInstanceState());
        C0300C c0300c = this.f3109g;
        if (c0300c != null) {
            cVar.f3823h = c0300c.f3823h;
            return cVar;
        }
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null) {
            cVar.f3823h = abstractC0333u.C();
            return cVar;
        }
        cVar.f3823h = null;
        return cVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 == i6 && i5 == i7) {
            return;
        }
        this.f3087H = null;
        this.f3085F = null;
        this.f3086G = null;
        this.f3084E = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0241  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        VelocityTracker velocityTracker = this.f3091L;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z = false;
        s(0);
        EdgeEffect edgeEffect = this.f3084E;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.f3084E.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3085F;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.f3085F.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3086G;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.f3086G.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3087H;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.f3087H.isFinished();
        }
        if (z) {
            WeakHashMap weakHashMap = T.f702a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(int r11, int r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.q(int, int, android.view.MotionEvent):void");
    }

    public final void r(int i4, int i5) {
        int i6;
        int i7;
        boolean z;
        int height;
        int i8;
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.f3129v) {
            if (!abstractC0333u.b()) {
                i6 = 0;
            } else {
                i6 = i4;
            }
            if (!this.f3121n.c()) {
                i7 = 0;
            } else {
                i7 = i5;
            }
            if (i6 == 0 && i7 == 0) {
                return;
            }
            RunnableC0303F runnableC0303F = this.f3101W;
            RecyclerView recyclerView = runnableC0303F.f3834l;
            int abs = Math.abs(i6);
            int abs2 = Math.abs(i7);
            if (abs > abs2) {
                z = true;
            } else {
                z = false;
            }
            int sqrt = (int) Math.sqrt(0);
            int sqrt2 = (int) Math.sqrt((i7 * i7) + (i6 * i6));
            if (z) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            int i9 = height / 2;
            float f4 = height;
            float f5 = i9;
            float sin = (((float) Math.sin((Math.min(1.0f, (sqrt2 * 1.0f) / f4) - 0.5f) * 0.47123894f)) * f5) + f5;
            if (sqrt > 0) {
                i8 = Math.round(Math.abs(sin / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i8 = (int) (((abs / f4) + 1.0f) * 300.0f);
            }
            int min = Math.min(i8, 2000);
            Interpolator interpolator = runnableC0303F.f3832i;
            InterpolatorC0328p interpolatorC0328p = f3079p0;
            if (interpolator != interpolatorC0328p) {
                runnableC0303F.f3832i = interpolatorC0328p;
                runnableC0303F.f3831h = new OverScroller(recyclerView.getContext(), interpolatorC0328p);
            }
            recyclerView.setScrollState(2);
            runnableC0303F.f3830g = 0;
            runnableC0303F.f3829f = 0;
            runnableC0303F.f3831h.startScroll(0, 0, i6, i7, min);
            runnableC0303F.a();
        }
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        j(view);
        view.clearAnimation();
        j(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        this.f3121n.getClass();
        if (this.f3081B <= 0 && view2 != null) {
            o(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f3121n.G(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.f3123p;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((C0319g) arrayList.get(i4)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f3128u == 0 && !this.f3129v) {
            super.requestLayout();
        }
    }

    public final void s(int i4) {
        getScrollingChildHelper().h(i4);
    }

    @Override // android.view.View
    public final void scrollBy(int i4, int i5) {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.f3129v) {
            boolean b4 = abstractC0333u.b();
            boolean c4 = this.f3121n.c();
            if (!b4 && !c4) {
                return;
            }
            if (!b4) {
                i4 = 0;
            }
            if (!c4) {
                i5 = 0;
            }
            q(i4, i5, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i4, int i5) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i4;
        if (this.f3081B > 0) {
            int i5 = 0;
            if (accessibilityEvent != null) {
                i4 = accessibilityEvent.getContentChangeTypes();
            } else {
                i4 = 0;
            }
            if (i4 != 0) {
                i5 = i4;
            }
            this.f3131x |= i5;
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C0305H c0305h) {
        this.f3108f0 = c0305h;
        T.i(this, c0305h);
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [h0.z, java.lang.Object] */
    public void setAdapter(AbstractC0329q abstractC0329q) {
        setLayoutFrozen(false);
        AbstractC0332t abstractC0332t = this.f3088I;
        if (abstractC0332t != null) {
            abstractC0332t.a();
        }
        AbstractC0333u abstractC0333u = this.f3121n;
        C0298A c0298a = this.f3107f;
        if (abstractC0333u != null) {
            abstractC0333u.E();
            this.f3121n.F(c0298a);
        }
        ((ArrayList) c0298a.f3820h).clear();
        ArrayList arrayList = (ArrayList) c0298a.f3821i;
        int size = arrayList.size() - 1;
        if (size < 0) {
            arrayList.clear();
            C0320h c0320h = ((RecyclerView) c0298a.k).f3103b0;
            c0320h.getClass();
            c0320h.f3902c = 0;
            t tVar = this.f3111h;
            tVar.U((ArrayList) tVar.f100h);
            tVar.U((ArrayList) tVar.f101i);
            ArrayList arrayList2 = (ArrayList) c0298a.f3820h;
            RecyclerView recyclerView = (RecyclerView) c0298a.k;
            ArrayList arrayList3 = (ArrayList) c0298a.f3821i;
            arrayList2.clear();
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                arrayList3.clear();
                C0320h c0320h2 = recyclerView.f3103b0;
                c0320h2.getClass();
                c0320h2.f3902c = 0;
                if (((z) c0298a.f3822j) == null) {
                    ?? obj = new Object();
                    obj.f3939a = new SparseArray();
                    obj.f3940b = 0;
                    c0298a.f3822j = obj;
                }
                z zVar = (z) c0298a.f3822j;
                if (zVar.f3940b == 0) {
                    SparseArray sparseArray = zVar.f3939a;
                    if (sparseArray.size() > 0) {
                        ((y) sparseArray.valueAt(0)).getClass();
                        throw null;
                    }
                }
                this.f3104c0.f3825b = true;
                this.f3080A = this.f3080A;
                this.z = true;
                int L3 = this.f3113i.L();
                for (int i4 = 0; i4 < L3; i4++) {
                    j(this.f3113i.K(i4));
                }
                m();
                int size3 = arrayList3.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    if (arrayList3.get(i5) != null) {
                        throw new ClassCastException();
                    }
                }
                int size4 = arrayList3.size() - 1;
                if (size4 < 0) {
                    arrayList3.clear();
                    C0320h c0320h3 = recyclerView.f3103b0;
                    c0320h3.getClass();
                    c0320h3.f3902c = 0;
                    requestLayout();
                    return;
                }
                throw i.f(arrayList3, size4);
            }
            throw i.f(arrayList3, size2);
        }
        throw i.f(arrayList, size);
    }

    public void setChildDrawingOrderCallback(InterfaceC0330r interfaceC0330r) {
        if (interfaceC0330r == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.k) {
            this.f3087H = null;
            this.f3085F = null;
            this.f3086G = null;
            this.f3084E = null;
        }
        this.k = z;
        super.setClipToPadding(z);
        if (this.f3127t) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(C0331s c0331s) {
        c0331s.getClass();
        this.f3083D = c0331s;
        this.f3087H = null;
        this.f3085F = null;
        this.f3086G = null;
        this.f3084E = null;
    }

    public void setHasFixedSize(boolean z) {
        this.f3126s = z;
    }

    public void setItemAnimator(AbstractC0332t abstractC0332t) {
        AbstractC0332t abstractC0332t2 = this.f3088I;
        if (abstractC0332t2 != null) {
            abstractC0332t2.a();
            this.f3088I.f3926a = null;
        }
        this.f3088I = abstractC0332t;
        if (abstractC0332t != null) {
            abstractC0332t.f3926a = this.f3106e0;
        }
    }

    public void setItemViewCacheSize(int i4) {
        C0298A c0298a = this.f3107f;
        c0298a.f3818f = i4;
        c0298a.c();
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f3129v) {
            b("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.f3129v = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f3129v = true;
            this.f3130w = true;
            setScrollState(0);
            RunnableC0303F runnableC0303F = this.f3101W;
            runnableC0303F.f3834l.removeCallbacks(runnableC0303F);
            runnableC0303F.f3831h.abortAnimation();
        }
    }

    public void setLayoutManager(AbstractC0333u abstractC0333u) {
        if (abstractC0333u == this.f3121n) {
            return;
        }
        setScrollState(0);
        RunnableC0303F runnableC0303F = this.f3101W;
        runnableC0303F.f3834l.removeCallbacks(runnableC0303F);
        runnableC0303F.f3831h.abortAnimation();
        AbstractC0333u abstractC0333u2 = this.f3121n;
        C0298A c0298a = this.f3107f;
        if (abstractC0333u2 != null) {
            AbstractC0332t abstractC0332t = this.f3088I;
            if (abstractC0332t != null) {
                abstractC0332t.a();
            }
            this.f3121n.E();
            this.f3121n.F(c0298a);
            ((ArrayList) c0298a.f3820h).clear();
            ArrayList arrayList = (ArrayList) c0298a.f3821i;
            int size = arrayList.size() - 1;
            if (size < 0) {
                arrayList.clear();
                C0320h c0320h = ((RecyclerView) c0298a.k).f3103b0;
                c0320h.getClass();
                c0320h.f3902c = 0;
                if (this.f3125r) {
                    AbstractC0333u abstractC0333u3 = this.f3121n;
                    abstractC0333u3.f3934e = false;
                    abstractC0333u3.z(this);
                }
                this.f3121n.I(null);
                this.f3121n = null;
            } else {
                throw i.f(arrayList, size);
            }
        } else {
            ((ArrayList) c0298a.f3820h).clear();
            ArrayList arrayList2 = (ArrayList) c0298a.f3821i;
            int size2 = arrayList2.size() - 1;
            if (size2 < 0) {
                arrayList2.clear();
                C0320h c0320h2 = ((RecyclerView) c0298a.k).f3103b0;
                c0320h2.getClass();
                c0320h2.f3902c = 0;
            } else {
                throw i.f(arrayList2, size2);
            }
        }
        t tVar = this.f3113i;
        q qVar = (q) tVar.f99g;
        ((C0314b) tVar.f100h).c();
        ArrayList arrayList3 = (ArrayList) tVar.f101i;
        for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
            j((View) arrayList3.get(size3));
            arrayList3.remove(size3);
        }
        RecyclerView recyclerView = (RecyclerView) qVar.f93g;
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            j(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f3121n = abstractC0333u;
        if (abstractC0333u != null) {
            if (abstractC0333u.f3931b == null) {
                abstractC0333u.I(this);
                if (this.f3125r) {
                    this.f3121n.f3934e = true;
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + abstractC0333u + " is already attached to a RecyclerView:" + abstractC0333u.f3931b.h());
            }
        }
        c0298a.c();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        C0063q scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f781d) {
            ViewGroup viewGroup = scrollingChildHelper.f780c;
            WeakHashMap weakHashMap = T.f702a;
            viewGroup.stopNestedScroll();
        }
        scrollingChildHelper.f781d = z;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.f3100V = z;
    }

    public void setRecycledViewPool(z zVar) {
        C0298A c0298a = this.f3107f;
        if (((z) c0298a.f3822j) != null) {
            r1.f3940b--;
        }
        c0298a.f3822j = zVar;
        if (zVar != null) {
            ((RecyclerView) c0298a.k).getAdapter();
        }
    }

    public void setScrollState(int i4) {
        if (i4 != this.f3089J) {
            this.f3089J = i4;
            if (i4 != 2) {
                RunnableC0303F runnableC0303F = this.f3101W;
                runnableC0303F.f3834l.removeCallbacks(runnableC0303F);
                runnableC0303F.f3831h.abortAnimation();
            }
            AbstractC0333u abstractC0333u = this.f3121n;
            if (abstractC0333u != null) {
                abstractC0333u.D(i4);
            }
            ArrayList arrayList = this.f3105d0;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((x) this.f3105d0.get(size)).getClass();
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i4) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i4 != 0) {
            if (i4 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i4 + "; using default value");
            } else {
                this.f3095Q = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f3095Q = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC0302E abstractC0302E) {
        this.f3107f.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i4) {
        return getScrollingChildHelper().g(i4, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC0333u abstractC0333u = this.f3121n;
        if (abstractC0333u != null) {
            return abstractC0333u.n(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    public void setOnFlingListener(AbstractC0335w abstractC0335w) {
    }

    @Deprecated
    public void setOnScrollListener(x xVar) {
    }

    public void setRecyclerListener(InterfaceC0299B interfaceC0299B) {
    }
}
