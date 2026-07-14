package I;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;
import f1.AbstractC0286a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public abstract class i0 extends r0 {

    /* renamed from: m, reason: collision with root package name */
    public static boolean f746m = false;

    /* renamed from: n, reason: collision with root package name */
    public static Method f747n;

    /* renamed from: o, reason: collision with root package name */
    public static Class f748o;

    /* renamed from: p, reason: collision with root package name */
    public static Field f749p;

    /* renamed from: q, reason: collision with root package name */
    public static Field f750q;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f751c;

    /* renamed from: d, reason: collision with root package name */
    public B.c[] f752d;

    /* renamed from: e, reason: collision with root package name */
    public B.c f753e;

    /* renamed from: f, reason: collision with root package name */
    public v0 f754f;

    /* renamed from: g, reason: collision with root package name */
    public B.c f755g;

    /* renamed from: h, reason: collision with root package name */
    public int f756h;

    /* renamed from: i, reason: collision with root package name */
    public int f757i;

    /* renamed from: j, reason: collision with root package name */
    public int f758j;
    public Rect[][] k;

    /* renamed from: l, reason: collision with root package name */
    public Rect[][] f759l;

    public i0(v0 v0Var, WindowInsets windowInsets) {
        super(v0Var);
        this.f753e = null;
        this.k = new Rect[10];
        this.f759l = new Rect[10];
        this.f751c = windowInsets;
    }

    private C0056j A(View view) {
        Display display;
        int i4;
        int i5;
        int i6;
        if (view == null || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        if (this.f784a.f788a.r()) {
            return C0056j.a(point.x, point.y, true, 0, 0, 0, 0);
        }
        int i7 = 0;
        C0069x F3 = AbstractC0602b.F(display, 0);
        C0069x F4 = AbstractC0602b.F(display, 1);
        C0069x F5 = AbstractC0602b.F(display, 2);
        C0069x F6 = AbstractC0602b.F(display, 3);
        int i8 = point.x;
        int i9 = point.y;
        if (F3 != null) {
            i4 = F3.f794b;
        } else {
            i4 = 0;
        }
        if (F4 != null) {
            i5 = F4.f794b;
        } else {
            i5 = 0;
        }
        if (F5 != null) {
            i6 = F5.f794b;
        } else {
            i6 = 0;
        }
        if (F6 != null) {
            i7 = F6.f794b;
        }
        return C0056j.a(i8, i9, false, i4, i5, i6, i7);
    }

    private static List<Rect> B(Rect[][] rectArr, int i4) {
        Rect[] rectArr2;
        Rect[] rectArr3 = null;
        for (int i5 = 1; i5 <= 512; i5 <<= 1) {
            if ((i4 & i5) != 0 && (rectArr2 = rectArr[AbstractC0286a.w(i5)]) != null) {
                if (rectArr3 == null) {
                    rectArr3 = rectArr2;
                } else {
                    Rect[] rectArr4 = new Rect[rectArr3.length + rectArr2.length];
                    System.arraycopy(rectArr3, 0, rectArr4, 0, rectArr3.length);
                    System.arraycopy(rectArr2, 0, rectArr4, rectArr3.length, rectArr2.length);
                    rectArr3 = rectArr4;
                }
            }
        }
        if (rectArr3 == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.asList(rectArr3);
    }

    private Rect[] C(B.c cVar) {
        ArrayList arrayList = new ArrayList();
        int i4 = cVar.f124a;
        int i5 = cVar.f127d;
        int i6 = cVar.f126c;
        int i7 = cVar.f125b;
        if (i4 != 0) {
            arrayList.add(new Rect(0, 0, cVar.f124a, this.f757i));
        }
        if (i7 != 0) {
            arrayList.add(new Rect(0, 0, this.f758j, i7));
        }
        if (i6 != 0) {
            int i8 = this.f758j;
            arrayList.add(new Rect(i8 - i6, 0, i8, this.f757i));
        }
        if (i5 != 0) {
            int i9 = this.f757i;
            arrayList.add(new Rect(0, i9 - i5, this.f758j, i9));
        }
        return (Rect[]) arrayList.toArray(new Rect[arrayList.size()]);
    }

    @SuppressLint({"WrongConstant"})
    private B.c D(int i4, boolean z) {
        B.c cVar = B.c.f123e;
        for (int i5 = 1; i5 <= 512; i5 <<= 1) {
            if ((i4 & i5) != 0) {
                cVar = B.c.a(cVar, E(i5, z));
            }
        }
        return cVar;
    }

    private B.c G() {
        v0 v0Var = this.f754f;
        if (v0Var != null) {
            return v0Var.f788a.j();
        }
        return B.c.f123e;
    }

    private B.c H(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            if (!f746m) {
                J();
            }
            Method method = f747n;
            if (method != null && f748o != null && f749p != null) {
                try {
                    Object invoke = method.invoke(view, null);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f749p.get(f750q.get(invoke));
                    if (rect == null) {
                        return null;
                    }
                    return B.c.b(rect.left, rect.top, rect.right, rect.bottom);
                } catch (ReflectiveOperationException e4) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e4.getMessage(), e4);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }

    @SuppressLint({"PrivateApi"})
    private static void J() {
        try {
            f747n = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f748o = cls;
            f749p = cls.getDeclaredField("mVisibleInsets");
            f750q = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f749p.setAccessible(true);
            f750q.setAccessible(true);
        } catch (ReflectiveOperationException e4) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e4.getMessage(), e4);
        }
        f746m = true;
    }

    public static boolean L(int i4, int i5) {
        if ((i4 & 6) == (i5 & 6)) {
            return true;
        }
        return false;
    }

    public B.c E(int i4, boolean z) {
        int i5;
        C0054h g4;
        int i6;
        int i7;
        int i8;
        B.c cVar = B.c.f123e;
        int i9 = 0;
        if (i4 != 1) {
            B.c cVar2 = null;
            if (i4 != 2) {
                if (i4 != 8) {
                    if (i4 != 16) {
                        if (i4 != 32) {
                            if (i4 != 64) {
                                if (i4 == 128) {
                                    v0 v0Var = this.f754f;
                                    if (v0Var != null) {
                                        g4 = v0Var.f788a.g();
                                    } else {
                                        g4 = g();
                                    }
                                    if (g4 != null) {
                                        int i10 = Build.VERSION.SDK_INT;
                                        if (i10 >= 28) {
                                            i6 = C.b.j(g4.f738a);
                                        } else {
                                            i6 = 0;
                                        }
                                        if (i10 >= 28) {
                                            i7 = C.b.l(g4.f738a);
                                        } else {
                                            i7 = 0;
                                        }
                                        if (i10 >= 28) {
                                            i8 = C.b.k(g4.f738a);
                                        } else {
                                            i8 = 0;
                                        }
                                        if (i10 >= 28) {
                                            i9 = C.b.i(g4.f738a);
                                        }
                                        return B.c.b(i6, i7, i8, i9);
                                    }
                                }
                            } else {
                                return m();
                            }
                        } else {
                            return i();
                        }
                    } else {
                        return k();
                    }
                } else {
                    B.c[] cVarArr = this.f752d;
                    if (cVarArr != null) {
                        cVar2 = cVarArr[AbstractC0286a.w(8)];
                    }
                    if (cVar2 != null) {
                        return cVar2;
                    }
                    B.c l3 = l();
                    B.c G3 = G();
                    int i11 = l3.f127d;
                    if (i11 > G3.f127d) {
                        return B.c.b(0, 0, 0, i11);
                    }
                    B.c cVar3 = this.f755g;
                    if (cVar3 != null && !cVar3.equals(cVar) && (i5 = this.f755g.f127d) > G3.f127d) {
                        return B.c.b(0, 0, 0, i5);
                    }
                }
            } else {
                if (z) {
                    B.c G4 = G();
                    B.c j4 = j();
                    return B.c.b(Math.max(G4.f124a, j4.f124a), 0, Math.max(G4.f126c, j4.f126c), Math.max(G4.f127d, j4.f127d));
                }
                if ((this.f756h & 2) == 0) {
                    B.c l4 = l();
                    v0 v0Var2 = this.f754f;
                    if (v0Var2 != null) {
                        cVar2 = v0Var2.f788a.j();
                    }
                    int i12 = l4.f127d;
                    if (cVar2 != null) {
                        i12 = Math.min(i12, cVar2.f127d);
                    }
                    return B.c.b(l4.f124a, 0, l4.f126c, i12);
                }
            }
        } else {
            if (z) {
                return B.c.b(0, Math.max(G().f125b, l().f125b), 0, 0);
            }
            if ((this.f756h & 4) == 0) {
                return B.c.b(0, l().f125b, 0, 0);
            }
        }
        return cVar;
    }

    public B.c F(int i4) {
        return D(i4, true);
    }

    public boolean I(int i4) {
        if (i4 != 1 && i4 != 2) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 8 && i4 != 128) {
                return true;
            }
        }
        return !E(i4, false).equals(B.c.f123e);
    }

    public void K(B.c cVar) {
        this.f755g = cVar;
    }

    @Override // I.r0
    public void d(View view) {
        this.f758j = view.getWidth();
        this.f757i = view.getHeight();
        B.c H3 = H(view);
        if (H3 == null) {
            H3 = B.c.f123e;
        }
        K(H3);
    }

    @Override // I.r0
    public List<Rect> e(int i4) {
        return B(this.k, i4);
    }

    @Override // I.r0
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        if (!Objects.equals(this.f755g, i0Var.f755g) || !L(this.f756h, i0Var.f756h)) {
            return false;
        }
        return true;
    }

    @Override // I.r0
    public List<Rect> f(int i4) {
        return B(this.f759l, i4);
    }

    @Override // I.r0
    public B.c h(int i4) {
        return D(i4, false);
    }

    @Override // I.r0
    public final B.c l() {
        if (this.f753e == null) {
            WindowInsets windowInsets = this.f751c;
            this.f753e = B.c.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f753e;
    }

    @Override // I.r0
    public void n(View view) {
        A(view);
    }

    @Override // I.r0
    @SuppressLint({"WrongConstant"})
    public void o() {
        for (int i4 = 1; i4 <= 512; i4 <<= 1) {
            int w2 = AbstractC0286a.w(i4);
            this.k[w2] = C(h(i4));
            if (i4 != 8) {
                this.f759l[w2] = C(F(i4));
            }
        }
    }

    @Override // I.r0
    public v0 p(int i4, int i5, int i6, int i7) {
        h0 a0Var;
        v0 c4 = v0.c(this.f751c, null);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 36) {
            a0Var = new g0(c4);
        } else if (i8 >= 35) {
            a0Var = new f0(c4);
        } else if (i8 >= 34) {
            a0Var = new e0(c4);
        } else if (i8 >= 31) {
            a0Var = new d0(c4);
        } else if (i8 >= 30) {
            a0Var = new c0(c4);
        } else if (i8 >= 29) {
            a0Var = new b0(c4);
        } else {
            a0Var = new a0(c4);
        }
        a0Var.h(v0.a(l(), i4, i5, i6, i7));
        a0Var.f(v0.a(j(), i4, i5, i6, i7));
        return a0Var.b();
    }

    @Override // I.r0
    public boolean r() {
        return this.f751c.isRound();
    }

    @Override // I.r0
    @SuppressLint({"WrongConstant"})
    public boolean s(int i4) {
        for (int i5 = 1; i5 <= 512; i5 <<= 1) {
            if ((i4 & i5) != 0 && !I(i5)) {
                return false;
            }
        }
        return true;
    }

    @Override // I.r0
    public void u(B.c[] cVarArr) {
        this.f752d = cVarArr;
    }

    @Override // I.r0
    public void v(v0 v0Var) {
        this.f754f = v0Var;
    }

    @Override // I.r0
    public void x(int i4) {
        this.f756h = i4;
    }

    @Override // I.r0
    public void y(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.k = (Rect[][]) rectArr.clone();
    }

    @Override // I.r0
    public void z(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f759l = (Rect[][]) rectArr.clone();
    }

    @Override // I.r0
    public void t(C0056j c0056j) {
    }
}
