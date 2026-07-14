package androidx.recyclerview.widget;

import A0.f;
import A0.g;
import B.b;
import B.l;
import E.AbstractC0015o;
import E.C0017q;
import E.E;
import E.J;
import E.K;
import F.h;
import J.c;
import Z.a;
import a0.AbstractC0057F;
import a0.C0052A;
import a0.C0053B;
import a0.C0055D;
import a0.C0056E;
import a0.C0060b;
import a0.C0065g;
import a0.C0067i;
import a0.I;
import a0.InterfaceC0054C;
import a0.O;
import a0.RunnableC0058G;
import a0.RunnableC0069k;
import a0.p;
import a0.q;
import a0.r;
import a0.s;
import a0.t;
import a0.v;
import a0.w;
import a0.x;
import a0.y;
import a0.z;
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
import com.google.firebase.encoders.json.BuildConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* renamed from: j0, reason: collision with root package name */
    public static final int[] f1895j0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: k0, reason: collision with root package name */
    public static final int[] f1896k0 = {R.attr.clipToPadding};

    /* renamed from: l0, reason: collision with root package name */
    public static final Class[] f1897l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final p f1898m0;

    /* renamed from: A, reason: collision with root package name */
    public s f1899A;

    /* renamed from: B, reason: collision with root package name */
    public EdgeEffect f1900B;

    /* renamed from: C, reason: collision with root package name */
    public EdgeEffect f1901C;

    /* renamed from: D, reason: collision with root package name */
    public EdgeEffect f1902D;

    /* renamed from: E, reason: collision with root package name */
    public EdgeEffect f1903E;

    /* renamed from: F, reason: collision with root package name */
    public t f1904F;

    /* renamed from: G, reason: collision with root package name */
    public int f1905G;

    /* renamed from: H, reason: collision with root package name */
    public int f1906H;

    /* renamed from: I, reason: collision with root package name */
    public VelocityTracker f1907I;

    /* renamed from: J, reason: collision with root package name */
    public int f1908J;

    /* renamed from: K, reason: collision with root package name */
    public int f1909K;
    public int L;

    /* renamed from: M, reason: collision with root package name */
    public int f1910M;

    /* renamed from: N, reason: collision with root package name */
    public int f1911N;

    /* renamed from: O, reason: collision with root package name */
    public final int f1912O;

    /* renamed from: P, reason: collision with root package name */
    public final int f1913P;

    /* renamed from: Q, reason: collision with root package name */
    public final float f1914Q;

    /* renamed from: R, reason: collision with root package name */
    public final float f1915R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f1916S;

    /* renamed from: T, reason: collision with root package name */
    public final RunnableC0058G f1917T;

    /* renamed from: U, reason: collision with root package name */
    public RunnableC0069k f1918U;

    /* renamed from: V, reason: collision with root package name */
    public final C0067i f1919V;

    /* renamed from: W, reason: collision with root package name */
    public final C0056E f1920W;

    /* renamed from: a0, reason: collision with root package name */
    public ArrayList f1921a0;

    /* renamed from: b0, reason: collision with root package name */
    public final f f1922b0;

    /* renamed from: c, reason: collision with root package name */
    public final C0053B f1923c;

    /* renamed from: c0, reason: collision with root package name */
    public I f1924c0;

    /* renamed from: d, reason: collision with root package name */
    public C0055D f1925d;

    /* renamed from: d0, reason: collision with root package name */
    public C0017q f1926d0;

    /* renamed from: e, reason: collision with root package name */
    public final g f1927e;

    /* renamed from: e0, reason: collision with root package name */
    public final int[] f1928e0;

    /* renamed from: f, reason: collision with root package name */
    public final g f1929f;

    /* renamed from: f0, reason: collision with root package name */
    public final int[] f1930f0;

    /* renamed from: g, reason: collision with root package name */
    public final f f1931g;

    /* renamed from: g0, reason: collision with root package name */
    public final int[] f1932g0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1933h;

    /* renamed from: h0, reason: collision with root package name */
    public final ArrayList f1934h0;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f1935i;

    /* renamed from: i0, reason: collision with root package name */
    public final b f1936i0;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f1937j;

    /* renamed from: k, reason: collision with root package name */
    public v f1938k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f1939l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f1940m;

    /* renamed from: n, reason: collision with root package name */
    public C0065g f1941n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1942o;
    public boolean p;
    public boolean q;

    /* renamed from: r, reason: collision with root package name */
    public int f1943r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1944s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1945t;

    /* renamed from: u, reason: collision with root package name */
    public int f1946u;

    /* renamed from: v, reason: collision with root package name */
    public final AccessibilityManager f1947v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1948w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1949x;
    public int y;
    public final int z;

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, a0.p] */
    static {
        Class cls = Integer.TYPE;
        f1897l0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f1898m0 = new Object();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [a0.s, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [a0.c, a0.t, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15, types: [a0.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object, a0.E] */
    public RecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        float a2;
        float a3;
        boolean z;
        int i2;
        ClassLoader classLoader;
        Constructor constructor;
        this.f1923c = new C0053B(this);
        this.f1931g = new f();
        this.f1935i = new Rect();
        this.f1937j = new Rect();
        new RectF();
        this.f1939l = new ArrayList();
        this.f1940m = new ArrayList();
        this.f1943r = 0;
        this.f1948w = false;
        this.f1949x = false;
        this.y = 0;
        this.z = 0;
        this.f1899A = new Object();
        ?? obj = new Object();
        Object[] objArr = null;
        obj.f1000a = null;
        obj.f1001b = new ArrayList();
        obj.f1002c = 250L;
        obj.f1003d = 250L;
        obj.f939e = new ArrayList();
        obj.f940f = new ArrayList();
        obj.f941g = new ArrayList();
        obj.f942h = new ArrayList();
        obj.f943i = new ArrayList();
        obj.f944j = new ArrayList();
        obj.f945k = new ArrayList();
        obj.f946l = new ArrayList();
        obj.f947m = new ArrayList();
        obj.f948n = new ArrayList();
        obj.f949o = new ArrayList();
        this.f1904F = obj;
        this.f1905G = 0;
        this.f1906H = -1;
        this.f1914Q = Float.MIN_VALUE;
        this.f1915R = Float.MIN_VALUE;
        boolean z2 = true;
        this.f1916S = true;
        this.f1917T = new RunnableC0058G(this);
        this.f1919V = new Object();
        ?? obj2 = new Object();
        obj2.f898a = 0;
        obj2.f899b = false;
        obj2.f900c = false;
        obj2.f901d = false;
        obj2.f902e = false;
        this.f1920W = obj2;
        f fVar = new f(14);
        this.f1922b0 = fVar;
        this.f1928e0 = new int[2];
        this.f1930f0 = new int[2];
        this.f1932g0 = new int[2];
        this.f1934h0 = new ArrayList();
        this.f1936i0 = new b(3, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1896k0, 0, 0);
            this.f1933h = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.f1933h = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1911N = viewConfiguration.getScaledTouchSlop();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            Method method = K.f182a;
            a2 = AbstractC0015o.d(viewConfiguration);
        } else {
            a2 = K.a(viewConfiguration, context);
        }
        this.f1914Q = a2;
        if (i3 >= 26) {
            a3 = AbstractC0015o.e(viewConfiguration);
        } else {
            a3 = K.a(viewConfiguration, context);
        }
        this.f1915R = a3;
        this.f1912O = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1913P = viewConfiguration.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.f1904F.f1000a = fVar;
        this.f1927e = new g(new f(13, this));
        this.f1929f = new g(new h(9, this));
        Field field = J.f180a;
        if (i3 >= 26) {
            i2 = E.a(this);
        } else {
            i2 = 0;
        }
        if (i2 == 0 && i3 >= 26) {
            E.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f1947v = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new I(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.f882a, 0, 0);
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
                    new C0065g(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.icaremc.doctors.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.icaremc.doctors.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.icaremc.doctors.R.dimen.fastscroll_margin));
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
                        Class<? extends U> asSubclass = classLoader.loadClass(str).asSubclass(v.class);
                        try {
                            constructor = asSubclass.getConstructor(f1897l0);
                            objArr = new Object[]{context, attributeSet, 0, 0};
                        } catch (NoSuchMethodException e2) {
                            try {
                                constructor = asSubclass.getConstructor(null);
                            } catch (NoSuchMethodException e3) {
                                e3.initCause(e2);
                                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e3);
                            }
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((v) constructor.newInstance(objArr));
                    } catch (ClassCastException e4) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e4);
                    } catch (ClassNotFoundException e5) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e5);
                    } catch (IllegalAccessException e6) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e6);
                    } catch (InstantiationException e7) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                    } catch (InvocationTargetException e8) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e8);
                    }
                }
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1895j0, 0, 0);
            z2 = obtainStyledAttributes3.getBoolean(0, true);
            obtainStyledAttributes3.recycle();
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    private C0017q getScrollingChildHelper() {
        if (this.f1926d0 == null) {
            this.f1926d0 = new C0017q(this);
        }
        return this.f1926d0;
    }

    public static void j(View view) {
        if (view == null) {
            return;
        }
        ((w) view.getLayoutParams()).getClass();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i2, int i3) {
        v vVar = this.f1938k;
        if (vVar != null) {
            vVar.getClass();
        }
        super.addFocusables(arrayList, i2, i3);
    }

    public final void b(String str) {
        if (this.y > 0) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + h());
            }
            throw new IllegalStateException(str);
        }
        if (this.z > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(BuildConfig.FLAVOR + h()));
        }
    }

    public final void c(int i2, int i3) {
        boolean z;
        EdgeEffect edgeEffect = this.f1900B;
        if (edgeEffect != null && !edgeEffect.isFinished() && i2 > 0) {
            this.f1900B.onRelease();
            z = this.f1900B.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.f1902D;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.f1902D.onRelease();
            z |= this.f1902D.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1901C;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.f1901C.onRelease();
            z |= this.f1901C.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1903E;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.f1903E.onRelease();
            z |= this.f1903E.isFinished();
        }
        if (z) {
            Field field = J.f180a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof w) && this.f1938k.d((w) layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        v vVar = this.f1938k;
        if (vVar != null && vVar.b()) {
            return this.f1938k.f(this.f1920W);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        v vVar = this.f1938k;
        if (vVar != null && vVar.b()) {
            this.f1938k.g(this.f1920W);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        v vVar = this.f1938k;
        if (vVar != null && vVar.b()) {
            return this.f1938k.h(this.f1920W);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        v vVar = this.f1938k;
        if (vVar != null && vVar.c()) {
            return this.f1938k.i(this.f1920W);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        v vVar = this.f1938k;
        if (vVar != null && vVar.c()) {
            this.f1938k.j(this.f1920W);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        v vVar = this.f1938k;
        if (vVar != null && vVar.c()) {
            return this.f1938k.k(this.f1920W);
        }
        return 0;
    }

    public final void d() {
        if (this.q && !this.f1948w) {
            g gVar = this.f1927e;
            if (((ArrayList) gVar.f31e).size() > 0) {
                gVar.getClass();
                if (((ArrayList) gVar.f31e).size() > 0) {
                    int i2 = A.h.f6a;
                    Trace.beginSection("RV FullInvalidate");
                    Log.e("RecyclerView", "No adapter attached; skipping layout");
                    Trace.endSection();
                    return;
                }
                return;
            }
            return;
        }
        int i3 = A.h.f6a;
        Trace.beginSection("RV FullInvalidate");
        Log.e("RecyclerView", "No adapter attached; skipping layout");
        Trace.endSection();
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().d(i2, i3, i4, i5, iArr, 0, null);
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
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        int i3;
        super.draw(canvas);
        ArrayList arrayList = this.f1939l;
        int size = arrayList.size();
        boolean z5 = false;
        int i4 = 0;
        while (true) {
            z = true;
            if (i4 >= size) {
                break;
            }
            C0065g c0065g = (C0065g) arrayList.get(i4);
            if (c0065g.f966l == c0065g.f968n.getWidth() && c0065g.f967m == c0065g.f968n.getHeight()) {
                if (c0065g.f974v != 0) {
                    if (c0065g.f969o) {
                        int i5 = c0065g.f966l;
                        int i6 = c0065g.f958d;
                        int i7 = i5 - i6;
                        int i8 = 0 - (0 / 2);
                        StateListDrawable stateListDrawable = c0065g.f956b;
                        stateListDrawable.setBounds(0, 0, i6, 0);
                        Drawable drawable = c0065g.f957c;
                        drawable.setBounds(0, 0, c0065g.f959e, c0065g.f967m);
                        RecyclerView recyclerView = c0065g.f968n;
                        Field field = J.f180a;
                        if (recyclerView.getLayoutDirection() == 1) {
                            drawable.draw(canvas);
                            canvas.translate(i6, i8);
                            canvas.scale(-1.0f, 1.0f);
                            stateListDrawable.draw(canvas);
                            canvas.scale(1.0f, 1.0f);
                            canvas.translate(-i6, -i8);
                        } else {
                            canvas.translate(i7, 0.0f);
                            drawable.draw(canvas);
                            canvas.translate(0.0f, i8);
                            stateListDrawable.draw(canvas);
                            canvas.translate(-i7, -i8);
                        }
                    }
                    if (c0065g.p) {
                        int i9 = c0065g.f967m;
                        int i10 = c0065g.f962h;
                        int i11 = i9 - i10;
                        StateListDrawable stateListDrawable2 = c0065g.f960f;
                        stateListDrawable2.setBounds(0, 0, 0, i10);
                        Drawable drawable2 = c0065g.f961g;
                        drawable2.setBounds(0, 0, c0065g.f966l, c0065g.f963i);
                        canvas.translate(0.0f, i11);
                        drawable2.draw(canvas);
                        canvas.translate(0 - (0 / 2), 0.0f);
                        stateListDrawable2.draw(canvas);
                        canvas.translate(-r8, -i11);
                    }
                }
            } else {
                c0065g.f966l = c0065g.f968n.getWidth();
                c0065g.f967m = c0065g.f968n.getHeight();
                c0065g.e(0);
            }
            i4++;
        }
        EdgeEffect edgeEffect = this.f1900B;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.f1933h) {
                i3 = getPaddingBottom();
            } else {
                i3 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i3, 0.0f);
            EdgeEffect edgeEffect2 = this.f1900B;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z2 = true;
            } else {
                z2 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect3 = this.f1901C;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f1933h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f1901C;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z4 = true;
            } else {
                z4 = false;
            }
            z2 |= z4;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f1902D;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.f1933h) {
                i2 = getPaddingTop();
            } else {
                i2 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(-i2, -width);
            EdgeEffect edgeEffect6 = this.f1902D;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z3 = true;
            } else {
                z3 = false;
            }
            z2 |= z3;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f1903E;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1933h) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f1903E;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z5 = true;
            }
            z2 |= z5;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.f1904F == null || arrayList.size() <= 0 || !this.f1904F.b()) {
            z = z2;
        }
        if (z) {
            Field field2 = J.f180a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void e(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        Field field = J.f180a;
        setMeasuredDimension(v.e(i2, paddingRight, getMinimumWidth()), v.e(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public final boolean f(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, i4, iArr, iArr2);
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

    public final boolean g(int[] iArr, int i2) {
        return getScrollingChildHelper().d(0, 0, 0, 0, iArr, i2, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        v vVar = this.f1938k;
        if (vVar != null) {
            return vVar.l();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        v vVar = this.f1938k;
        if (vVar != null) {
            return vVar.m(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    public q getAdapter() {
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        v vVar = this.f1938k;
        if (vVar != null) {
            vVar.getClass();
            return -1;
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        return super.getChildDrawingOrder(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1933h;
    }

    public I getCompatAccessibilityDelegate() {
        return this.f1924c0;
    }

    public s getEdgeEffectFactory() {
        return this.f1899A;
    }

    public t getItemAnimator() {
        return this.f1904F;
    }

    public int getItemDecorationCount() {
        return this.f1939l.size();
    }

    public v getLayoutManager() {
        return this.f1938k;
    }

    public int getMaxFlingVelocity() {
        return this.f1913P;
    }

    public int getMinFlingVelocity() {
        return this.f1912O;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public x getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1916S;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, a0.A] */
    public C0052A getRecycledViewPool() {
        C0053B c0053b = this.f1923c;
        if (c0053b.f895e == null) {
            ?? obj = new Object();
            obj.f889a = new SparseArray();
            obj.f890b = 0;
            c0053b.f895e = obj;
        }
        return c0053b.f895e;
    }

    public int getScrollState() {
        return this.f1905G;
    }

    public final String h() {
        return " " + super.toString() + ", adapter:null, layout:" + this.f1938k + ", context:" + getContext();
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
        return this.f1942o;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f249d;
    }

    public final boolean k() {
        return getScrollingChildHelper().f(1);
    }

    public final boolean l() {
        if (this.q && !this.f1948w && ((ArrayList) this.f1927e.f31e).size() <= 0) {
            return false;
        }
        return true;
    }

    public final void m() {
        int h2 = this.f1929f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ((w) this.f1929f.g(i2).getLayoutParams()).f1014b = true;
        }
        ArrayList arrayList = this.f1923c.f892b;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    public final void n(MotionEvent motionEvent) {
        int i2;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1906H) {
            if (actionIndex == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.f1906H = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.L = x2;
            this.f1908J = x2;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.f1910M = y;
            this.f1909K = y;
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
        Rect rect = this.f1935i;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof w) {
            w wVar = (w) layoutParams;
            if (!wVar.f1014b) {
                Rect rect2 = wVar.f1013a;
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
        v vVar = this.f1938k;
        boolean z2 = !this.q;
        if (view2 == null) {
            z = true;
        } else {
            z = false;
        }
        vVar.G(this, view, this.f1935i, z2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r1 >= 30.0f) goto L19;
     */
    /* JADX WARN: Type inference failed for: r1v3, types: [a0.k, java.lang.Object] */
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
            r5.y = r0
            r1 = 1
            r5.f1942o = r1
            boolean r2 = r5.q
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            r0 = r1
        L14:
            r5.q = r0
            a0.v r0 = r5.f1938k
            if (r0 == 0) goto L1c
            r0.f1010e = r1
        L1c:
            java.lang.ThreadLocal r0 = a0.RunnableC0069k.f984g
            java.lang.Object r1 = r0.get()
            a0.k r1 = (a0.RunnableC0069k) r1
            r5.f1918U = r1
            if (r1 != 0) goto L64
            a0.k r1 = new a0.k
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f986c = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f989f = r2
            r5.f1918U = r1
            java.lang.reflect.Field r1 = E.J.f180a
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
            a0.k r2 = r5.f1918U
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f988e = r3
            r0.set(r2)
        L64:
            a0.k r0 = r5.f1918U
            java.util.ArrayList r0 = r0.f986c
            r0.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Object obj;
        super.onDetachedFromWindow();
        t tVar = this.f1904F;
        if (tVar != null) {
            tVar.a();
        }
        setScrollState(0);
        RunnableC0058G runnableC0058G = this.f1917T;
        runnableC0058G.f909i.removeCallbacks(runnableC0058G);
        runnableC0058G.f905e.abortAnimation();
        this.f1942o = false;
        v vVar = this.f1938k;
        if (vVar != null) {
            vVar.f1010e = false;
            vVar.z(this);
        }
        this.f1934h0.clear();
        removeCallbacks(this.f1936i0);
        this.f1931g.getClass();
        do {
            l lVar = O.f936a;
            Object[] objArr = (Object[]) lVar.f67b;
            int i2 = lVar.f66a;
            obj = null;
            if (i2 > 0) {
                int i3 = i2 - 1;
                Object obj2 = objArr[i3];
                kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                objArr[i3] = null;
                lVar.f66a--;
                obj = obj2;
            }
        } while (obj != null);
        RunnableC0069k runnableC0069k = this.f1918U;
        if (runnableC0069k != null) {
            runnableC0069k.f986c.remove(this);
            this.f1918U = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f1939l;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((C0065g) arrayList.get(i2)).getClass();
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
            a0.v r0 = r5.f1938k
            r1 = 0
            if (r0 != 0) goto L7
            goto L79
        L7:
            boolean r0 = r5.f1944s
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
            a0.v r0 = r5.f1938k
            boolean r0 = r0.c()
            if (r0 == 0) goto L2e
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2f
        L2e:
            r0 = r2
        L2f:
            a0.v r3 = r5.f1938k
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
            a0.v r3 = r5.f1938k
            boolean r3 = r3.c()
            if (r3 == 0) goto L59
            float r0 = -r0
            goto L3e
        L59:
            a0.v r3 = r5.f1938k
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
            float r2 = r5.f1914Q
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f1915R
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
        if (!this.f1944s) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 0) {
                this.f1941n = null;
            }
            ArrayList arrayList = this.f1940m;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0065g c0065g = (C0065g) arrayList.get(i2);
                if (c0065g.c(motionEvent) && action != 3) {
                    this.f1941n = c0065g;
                    p();
                    setScrollState(0);
                    return true;
                }
            }
            v vVar = this.f1938k;
            if (vVar != null) {
                boolean b2 = vVar.b();
                boolean c2 = this.f1938k.c();
                if (this.f1907I == null) {
                    this.f1907I = VelocityTracker.obtain();
                }
                this.f1907I.addMovement(motionEvent);
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
                                    this.f1906H = motionEvent.getPointerId(actionIndex);
                                    int x2 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                                    this.L = x2;
                                    this.f1908J = x2;
                                    int y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                                    this.f1910M = y;
                                    this.f1909K = y;
                                }
                            } else {
                                p();
                                setScrollState(0);
                            }
                        } else {
                            int findPointerIndex = motionEvent.findPointerIndex(this.f1906H);
                            if (findPointerIndex < 0) {
                                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1906H + " not found. Did any MotionEvents get skipped?");
                                return false;
                            }
                            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                            if (this.f1905G != 1) {
                                int i3 = x3 - this.f1908J;
                                int i4 = y2 - this.f1909K;
                                if (b2 != 0 && Math.abs(i3) > this.f1911N) {
                                    this.L = x3;
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (c2 && Math.abs(i4) > this.f1911N) {
                                    this.f1910M = y2;
                                    z = true;
                                }
                                if (z) {
                                    setScrollState(1);
                                }
                            }
                        }
                    } else {
                        this.f1907I.clear();
                        s(0);
                    }
                } else {
                    if (this.f1945t) {
                        this.f1945t = false;
                    }
                    this.f1906H = motionEvent.getPointerId(0);
                    int x4 = (int) (motionEvent.getX() + 0.5f);
                    this.L = x4;
                    this.f1908J = x4;
                    int y3 = (int) (motionEvent.getY() + 0.5f);
                    this.f1910M = y3;
                    this.f1909K = y3;
                    if (this.f1905G == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.f1932g0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i5 = b2;
                    if (c2) {
                        i5 = (b2 ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i5, 0);
                }
                if (this.f1905G == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = A.h.f6a;
        Trace.beginSection("RV OnLayout");
        Log.e("RecyclerView", "No adapter attached; skipping layout");
        Trace.endSection();
        this.q = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        v vVar = this.f1938k;
        if (vVar == null) {
            e(i2, i3);
            return;
        }
        if (vVar.y()) {
            View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getMode(i3);
            this.f1938k.f1007b.e(i2, i3);
        } else {
            if (this.p) {
                this.f1938k.f1007b.e(i2, i3);
                return;
            }
            C0056E c0056e = this.f1920W;
            if (c0056e.f902e) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            c0056e.getClass();
            this.f1943r++;
            this.f1938k.f1007b.e(i2, i3);
            if (this.f1943r < 1) {
                this.f1943r = 1;
            }
            this.f1943r--;
            c0056e.f900c = false;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (this.y > 0) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0055D)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0055D c0055d = (C0055D) parcelable;
        this.f1925d = c0055d;
        super.onRestoreInstanceState(c0055d.f329c);
        v vVar = this.f1938k;
        if (vVar != null && (parcelable2 = this.f1925d.f897e) != null) {
            vVar.B(parcelable2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, a0.D, J.c] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? cVar = new c(super.onSaveInstanceState());
        C0055D c0055d = this.f1925d;
        if (c0055d != null) {
            cVar.f897e = c0055d.f897e;
            return cVar;
        }
        v vVar = this.f1938k;
        if (vVar != null) {
            cVar.f897e = vVar.C();
            return cVar;
        }
        cVar.f897e = null;
        return cVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        this.f1903E = null;
        this.f1901C = null;
        this.f1902D = null;
        this.f1900B = null;
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
        VelocityTracker velocityTracker = this.f1907I;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z = false;
        s(0);
        EdgeEffect edgeEffect = this.f1900B;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.f1900B.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f1901C;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.f1901C.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1902D;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.f1902D.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1903E;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.f1903E.isFinished();
        }
        if (z) {
            Field field = J.f180a;
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

    public final void r(int i2, int i3) {
        int i4;
        int i5;
        boolean z;
        int height;
        int i6;
        v vVar = this.f1938k;
        if (vVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.f1944s) {
            if (!vVar.b()) {
                i4 = 0;
            } else {
                i4 = i2;
            }
            if (!this.f1938k.c()) {
                i5 = 0;
            } else {
                i5 = i3;
            }
            if (i4 == 0 && i5 == 0) {
                return;
            }
            RunnableC0058G runnableC0058G = this.f1917T;
            RecyclerView recyclerView = runnableC0058G.f909i;
            int abs = Math.abs(i4);
            int abs2 = Math.abs(i5);
            if (abs > abs2) {
                z = true;
            } else {
                z = false;
            }
            int sqrt = (int) Math.sqrt(0);
            int sqrt2 = (int) Math.sqrt((i5 * i5) + (i4 * i4));
            if (z) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            int i7 = height / 2;
            float f2 = height;
            float f3 = i7;
            float sin = (((float) Math.sin((Math.min(1.0f, (sqrt2 * 1.0f) / f2) - 0.5f) * 0.47123894f)) * f3) + f3;
            if (sqrt > 0) {
                i6 = Math.round(Math.abs(sin / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i6 = (int) (((abs / f2) + 1.0f) * 300.0f);
            }
            int min = Math.min(i6, 2000);
            Interpolator interpolator = runnableC0058G.f906f;
            p pVar = f1898m0;
            if (interpolator != pVar) {
                runnableC0058G.f906f = pVar;
                runnableC0058G.f905e = new OverScroller(recyclerView.getContext(), pVar);
            }
            recyclerView.setScrollState(2);
            runnableC0058G.f904d = 0;
            runnableC0058G.f903c = 0;
            runnableC0058G.f905e.startScroll(0, 0, i4, i5, min);
            runnableC0058G.a();
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
        this.f1938k.getClass();
        if (this.y <= 0 && view2 != null) {
            o(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f1938k.G(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.f1940m;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((C0065g) arrayList.get(i2)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f1943r == 0 && !this.f1944s) {
            super.requestLayout();
        }
    }

    public final void s(int i2) {
        getScrollingChildHelper().h(i2);
    }

    @Override // android.view.View
    public final void scrollBy(int i2, int i3) {
        v vVar = this.f1938k;
        if (vVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.f1944s) {
            boolean b2 = vVar.b();
            boolean c2 = this.f1938k.c();
            if (!b2 && !c2) {
                return;
            }
            if (!b2) {
                i2 = 0;
            }
            if (!c2) {
                i3 = 0;
            }
            q(i2, i3, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i2;
        if (this.y > 0) {
            int i3 = 0;
            if (accessibilityEvent != null) {
                i2 = accessibilityEvent.getContentChangeTypes();
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                i3 = i2;
            }
            this.f1946u |= i3;
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(I i2) {
        this.f1924c0 = i2;
        J.a(this, i2);
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Object, a0.A] */
    public void setAdapter(q qVar) {
        setLayoutFrozen(false);
        t tVar = this.f1904F;
        if (tVar != null) {
            tVar.a();
        }
        v vVar = this.f1938k;
        C0053B c0053b = this.f1923c;
        if (vVar != null) {
            vVar.E();
            this.f1938k.F(c0053b);
        }
        c0053b.f891a.clear();
        ArrayList arrayList = c0053b.f892b;
        int size = arrayList.size() - 1;
        if (size < 0) {
            arrayList.clear();
            C0067i c0067i = c0053b.f896f.f1919V;
            c0067i.getClass();
            c0067i.f978c = 0;
            g gVar = this.f1927e;
            gVar.l((ArrayList) gVar.f31e);
            gVar.l((ArrayList) gVar.f32f);
            ArrayList arrayList2 = c0053b.f891a;
            RecyclerView recyclerView = c0053b.f896f;
            ArrayList arrayList3 = c0053b.f892b;
            arrayList2.clear();
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                arrayList3.clear();
                C0067i c0067i2 = recyclerView.f1919V;
                c0067i2.getClass();
                c0067i2.f978c = 0;
                if (c0053b.f895e == null) {
                    ?? obj = new Object();
                    obj.f889a = new SparseArray();
                    obj.f890b = 0;
                    c0053b.f895e = obj;
                }
                C0052A c0052a = c0053b.f895e;
                if (c0052a.f890b == 0) {
                    SparseArray sparseArray = c0052a.f889a;
                    if (sparseArray.size() > 0) {
                        ((z) sparseArray.valueAt(0)).getClass();
                        throw null;
                    }
                }
                this.f1920W.f899b = true;
                this.f1949x = this.f1949x;
                this.f1948w = true;
                int h2 = this.f1929f.h();
                for (int i2 = 0; i2 < h2; i2++) {
                    j(this.f1929f.g(i2));
                }
                m();
                int size3 = arrayList3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    if (arrayList3.get(i3) != null) {
                        throw new ClassCastException();
                    }
                }
                int size4 = arrayList3.size() - 1;
                if (size4 < 0) {
                    arrayList3.clear();
                    C0067i c0067i3 = recyclerView.f1919V;
                    c0067i3.getClass();
                    c0067i3.f978c = 0;
                    requestLayout();
                    return;
                }
                arrayList3.get(size4).getClass();
                throw new ClassCastException();
            }
            arrayList3.get(size2).getClass();
            throw new ClassCastException();
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    public void setChildDrawingOrderCallback(r rVar) {
        if (rVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.f1933h) {
            this.f1903E = null;
            this.f1901C = null;
            this.f1902D = null;
            this.f1900B = null;
        }
        this.f1933h = z;
        super.setClipToPadding(z);
        if (this.q) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(s sVar) {
        sVar.getClass();
        this.f1899A = sVar;
        this.f1903E = null;
        this.f1901C = null;
        this.f1902D = null;
        this.f1900B = null;
    }

    public void setHasFixedSize(boolean z) {
        this.p = z;
    }

    public void setItemAnimator(t tVar) {
        t tVar2 = this.f1904F;
        if (tVar2 != null) {
            tVar2.a();
            this.f1904F.f1000a = null;
        }
        this.f1904F = tVar;
        if (tVar != null) {
            tVar.f1000a = this.f1922b0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        C0053B c0053b = this.f1923c;
        c0053b.f893c = i2;
        c0053b.b();
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f1944s) {
            b("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.f1944s = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f1944s = true;
            this.f1945t = true;
            setScrollState(0);
            RunnableC0058G runnableC0058G = this.f1917T;
            runnableC0058G.f909i.removeCallbacks(runnableC0058G);
            runnableC0058G.f905e.abortAnimation();
        }
    }

    public void setLayoutManager(v vVar) {
        if (vVar == this.f1938k) {
            return;
        }
        setScrollState(0);
        RunnableC0058G runnableC0058G = this.f1917T;
        runnableC0058G.f909i.removeCallbacks(runnableC0058G);
        runnableC0058G.f905e.abortAnimation();
        v vVar2 = this.f1938k;
        C0053B c0053b = this.f1923c;
        if (vVar2 != null) {
            t tVar = this.f1904F;
            if (tVar != null) {
                tVar.a();
            }
            this.f1938k.E();
            this.f1938k.F(c0053b);
            c0053b.f891a.clear();
            ArrayList arrayList = c0053b.f892b;
            int size = arrayList.size() - 1;
            if (size < 0) {
                arrayList.clear();
                C0067i c0067i = c0053b.f896f.f1919V;
                c0067i.getClass();
                c0067i.f978c = 0;
                if (this.f1942o) {
                    v vVar3 = this.f1938k;
                    vVar3.f1010e = false;
                    vVar3.z(this);
                }
                this.f1938k.I(null);
                this.f1938k = null;
            } else {
                arrayList.get(size).getClass();
                throw new ClassCastException();
            }
        } else {
            c0053b.f891a.clear();
            ArrayList arrayList2 = c0053b.f892b;
            int size2 = arrayList2.size() - 1;
            if (size2 < 0) {
                arrayList2.clear();
                C0067i c0067i2 = c0053b.f896f.f1919V;
                c0067i2.getClass();
                c0067i2.f978c = 0;
            } else {
                arrayList2.get(size2).getClass();
                throw new ClassCastException();
            }
        }
        g gVar = this.f1929f;
        h hVar = (h) gVar.f30d;
        ((C0060b) gVar.f31e).c();
        ArrayList arrayList3 = (ArrayList) gVar.f32f;
        for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
            j((View) arrayList3.get(size3));
            arrayList3.remove(size3);
        }
        RecyclerView recyclerView = (RecyclerView) hVar.f274d;
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            j(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f1938k = vVar;
        if (vVar != null) {
            if (vVar.f1007b == null) {
                vVar.I(this);
                if (this.f1942o) {
                    this.f1938k.f1010e = true;
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + vVar + " is already attached to a RecyclerView:" + vVar.f1007b.h());
            }
        }
        c0053b.b();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        C0017q scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f249d) {
            ViewGroup viewGroup = scrollingChildHelper.f248c;
            Field field = J.f180a;
            viewGroup.stopNestedScroll();
        }
        scrollingChildHelper.f249d = z;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.f1916S = z;
    }

    public void setRecycledViewPool(C0052A c0052a) {
        C0053B c0053b = this.f1923c;
        if (c0053b.f895e != null) {
            r1.f890b--;
        }
        c0053b.f895e = c0052a;
        if (c0052a != null) {
            c0053b.f896f.getAdapter();
        }
    }

    public void setScrollState(int i2) {
        if (i2 != this.f1905G) {
            this.f1905G = i2;
            if (i2 != 2) {
                RunnableC0058G runnableC0058G = this.f1917T;
                runnableC0058G.f909i.removeCallbacks(runnableC0058G);
                runnableC0058G.f905e.abortAnimation();
            }
            v vVar = this.f1938k;
            if (vVar != null) {
                vVar.D(i2);
            }
            ArrayList arrayList = this.f1921a0;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((y) this.f1921a0.get(size)).getClass();
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.f1911N = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f1911N = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC0057F abstractC0057F) {
        this.f1923c.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().g(i2, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        v vVar = this.f1938k;
        if (vVar != null) {
            return vVar.n(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + h());
    }

    public void setOnFlingListener(x xVar) {
    }

    @Deprecated
    public void setOnScrollListener(y yVar) {
    }

    public void setRecyclerListener(InterfaceC0054C interfaceC0054C) {
    }
}
