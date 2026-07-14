package E;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class W extends g0 {

    /* renamed from: m, reason: collision with root package name */
    public static boolean f192m = false;

    /* renamed from: n, reason: collision with root package name */
    public static Method f193n;

    /* renamed from: o, reason: collision with root package name */
    public static Class f194o;
    public static Field p;
    public static Field q;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f195c;

    /* renamed from: d, reason: collision with root package name */
    public x.b[] f196d;

    /* renamed from: e, reason: collision with root package name */
    public x.b f197e;

    /* renamed from: f, reason: collision with root package name */
    public k0 f198f;

    /* renamed from: g, reason: collision with root package name */
    public x.b f199g;

    /* renamed from: h, reason: collision with root package name */
    public int f200h;

    /* renamed from: i, reason: collision with root package name */
    public int f201i;

    /* renamed from: j, reason: collision with root package name */
    public int f202j;

    /* renamed from: k, reason: collision with root package name */
    public Rect[][] f203k;

    /* renamed from: l, reason: collision with root package name */
    public Rect[][] f204l;

    public W(k0 k0Var, WindowInsets windowInsets) {
        super(k0Var);
        this.f197e = null;
        this.f203k = new Rect[10];
        this.f204l = new Rect[10];
        this.f195c = windowInsets;
    }

    private Rect[] A(x.b bVar) {
        ArrayList arrayList = new ArrayList();
        int i2 = bVar.f3960a;
        int i3 = bVar.f3963d;
        int i4 = bVar.f3962c;
        int i5 = bVar.f3961b;
        if (i2 != 0) {
            arrayList.add(new Rect(0, 0, bVar.f3960a, this.f201i));
        }
        if (i5 != 0) {
            arrayList.add(new Rect(0, 0, this.f202j, i5));
        }
        if (i4 != 0) {
            int i6 = this.f202j;
            arrayList.add(new Rect(i6 - i4, 0, i6, this.f201i));
        }
        if (i3 != 0) {
            int i7 = this.f201i;
            arrayList.add(new Rect(0, i7 - i3, this.f202j, i7));
        }
        return (Rect[]) arrayList.toArray(new Rect[arrayList.size()]);
    }

    @SuppressLint({"WrongConstant"})
    private x.b C(int i2, boolean z) {
        x.b bVar = x.b.f3959e;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                x.b D2 = D(i3, z);
                bVar = x.b.a(Math.max(bVar.f3960a, D2.f3960a), Math.max(bVar.f3961b, D2.f3961b), Math.max(bVar.f3962c, D2.f3962c), Math.max(bVar.f3963d, D2.f3963d));
            }
        }
        return bVar;
    }

    private x.b F() {
        k0 k0Var = this.f198f;
        if (k0Var != null) {
            return k0Var.f234a.i();
        }
        return x.b.f3959e;
    }

    private x.b G(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            if (!f192m) {
                I();
            }
            Method method = f193n;
            if (method != null && f194o != null && p != null) {
                try {
                    Object invoke = method.invoke(view, null);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) p.get(q.get(invoke));
                    if (rect == null) {
                        return null;
                    }
                    return x.b.a(rect.left, rect.top, rect.right, rect.bottom);
                } catch (ReflectiveOperationException e2) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }

    @SuppressLint({"PrivateApi"})
    private static void I() {
        try {
            f193n = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f194o = cls;
            p = cls.getDeclaredField("mVisibleInsets");
            q = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            p.setAccessible(true);
            q.setAccessible(true);
        } catch (ReflectiveOperationException e2) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
        }
        f192m = true;
    }

    public static boolean K(int i2, int i3) {
        if ((i2 & 6) == (i3 & 6)) {
            return true;
        }
        return false;
    }

    private C0008h y(View view) {
        Display display;
        int i2;
        int i3;
        int i4;
        if (view == null || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        if (this.f228a.f234a.p()) {
            return C0008h.a(point.x, point.y, true, 0, 0, 0, 0);
        }
        int i5 = 0;
        C0021v n2 = android.support.v4.media.session.a.n(display, 0);
        C0021v n3 = android.support.v4.media.session.a.n(display, 1);
        C0021v n4 = android.support.v4.media.session.a.n(display, 2);
        C0021v n5 = android.support.v4.media.session.a.n(display, 3);
        int i6 = point.x;
        int i7 = point.y;
        if (n2 != null) {
            i2 = n2.f258b;
        } else {
            i2 = 0;
        }
        if (n3 != null) {
            i3 = n3.f258b;
        } else {
            i3 = 0;
        }
        if (n4 != null) {
            i4 = n4.f258b;
        } else {
            i4 = 0;
        }
        if (n5 != null) {
            i5 = n5.f258b;
        }
        return C0008h.a(i6, i7, false, i2, i3, i4, i5);
    }

    private static List<Rect> z(Rect[][] rectArr, int i2) {
        Rect[] rectArr2;
        Rect[] rectArr3 = null;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0 && (rectArr2 = rectArr[android.support.v4.media.session.a.u(i3)]) != null) {
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

    public x.b B(int i2) {
        return C(i2, false);
    }

    public x.b D(int i2, boolean z) {
        int i3;
        C0006f g2;
        int i4;
        int i5;
        int i6;
        x.b bVar = x.b.f3959e;
        int i7 = 0;
        if (i2 != 1) {
            x.b bVar2 = null;
            if (i2 != 2) {
                if (i2 != 8) {
                    if (i2 != 16) {
                        if (i2 != 32) {
                            if (i2 != 64) {
                                if (i2 == 128) {
                                    k0 k0Var = this.f198f;
                                    if (k0Var != null) {
                                        g2 = k0Var.f234a.g();
                                    } else {
                                        g2 = g();
                                    }
                                    if (g2 != null) {
                                        int i8 = Build.VERSION.SDK_INT;
                                        if (i8 >= 28) {
                                            i4 = AbstractC0005e.i(g2.f223a);
                                        } else {
                                            i4 = 0;
                                        }
                                        if (i8 >= 28) {
                                            i5 = AbstractC0005e.k(g2.f223a);
                                        } else {
                                            i5 = 0;
                                        }
                                        if (i8 >= 28) {
                                            i6 = AbstractC0005e.j(g2.f223a);
                                        } else {
                                            i6 = 0;
                                        }
                                        if (i8 >= 28) {
                                            i7 = AbstractC0005e.h(g2.f223a);
                                        }
                                        return x.b.a(i4, i5, i6, i7);
                                    }
                                }
                            } else {
                                return l();
                            }
                        } else {
                            return h();
                        }
                    } else {
                        return j();
                    }
                } else {
                    x.b[] bVarArr = this.f196d;
                    if (bVarArr != null) {
                        bVar2 = bVarArr[android.support.v4.media.session.a.u(8)];
                    }
                    if (bVar2 != null) {
                        return bVar2;
                    }
                    x.b k2 = k();
                    x.b F2 = F();
                    int i9 = k2.f3963d;
                    if (i9 > F2.f3963d) {
                        return x.b.a(0, 0, 0, i9);
                    }
                    x.b bVar3 = this.f199g;
                    if (bVar3 != null && !bVar3.equals(bVar) && (i3 = this.f199g.f3963d) > F2.f3963d) {
                        return x.b.a(0, 0, 0, i3);
                    }
                }
            } else {
                if (z) {
                    x.b F3 = F();
                    x.b i10 = i();
                    return x.b.a(Math.max(F3.f3960a, i10.f3960a), 0, Math.max(F3.f3962c, i10.f3962c), Math.max(F3.f3963d, i10.f3963d));
                }
                if ((this.f200h & 2) == 0) {
                    x.b k3 = k();
                    k0 k0Var2 = this.f198f;
                    if (k0Var2 != null) {
                        bVar2 = k0Var2.f234a.i();
                    }
                    int i11 = k3.f3963d;
                    if (bVar2 != null) {
                        i11 = Math.min(i11, bVar2.f3963d);
                    }
                    return x.b.a(k3.f3960a, 0, k3.f3962c, i11);
                }
            }
        } else {
            if (z) {
                return x.b.a(0, Math.max(F().f3961b, k().f3961b), 0, 0);
            }
            if ((this.f200h & 4) == 0) {
                return x.b.a(0, k().f3961b, 0, 0);
            }
        }
        return bVar;
    }

    public x.b E(int i2) {
        return C(i2, true);
    }

    public boolean H(int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 8 && i2 != 128) {
                return true;
            }
        }
        return !D(i2, false).equals(x.b.f3959e);
    }

    public void J(x.b bVar) {
        this.f199g = bVar;
    }

    @Override // E.g0
    public void d(View view) {
        this.f202j = view.getWidth();
        this.f201i = view.getHeight();
        x.b G2 = G(view);
        if (G2 == null) {
            G2 = x.b.f3959e;
        }
        J(G2);
    }

    @Override // E.g0
    public List<Rect> e(int i2) {
        return z(this.f203k, i2);
    }

    @Override // E.g0
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        W w2 = (W) obj;
        if (!Objects.equals(this.f199g, w2.f199g) || !K(this.f200h, w2.f200h)) {
            return false;
        }
        return true;
    }

    @Override // E.g0
    public List<Rect> f(int i2) {
        return z(this.f204l, i2);
    }

    @Override // E.g0
    public final x.b k() {
        if (this.f197e == null) {
            WindowInsets windowInsets = this.f195c;
            this.f197e = x.b.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f197e;
    }

    @Override // E.g0
    public void m(View view) {
        y(view);
    }

    @Override // E.g0
    @SuppressLint({"WrongConstant"})
    public void n() {
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            int u2 = android.support.v4.media.session.a.u(i2);
            this.f203k[u2] = A(B(i2));
            if (i2 != 8) {
                this.f204l[u2] = A(E(i2));
            }
        }
    }

    @Override // E.g0
    public boolean p() {
        return this.f195c.isRound();
    }

    @Override // E.g0
    @SuppressLint({"WrongConstant"})
    public boolean q(int i2) {
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0 && !H(i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // E.g0
    public void s(x.b[] bVarArr) {
        this.f196d = bVarArr;
    }

    @Override // E.g0
    public void t(k0 k0Var) {
        this.f198f = k0Var;
    }

    @Override // E.g0
    public void v(int i2) {
        this.f200h = i2;
    }

    @Override // E.g0
    public void w(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f203k = (Rect[][]) rectArr.clone();
    }

    @Override // E.g0
    public void x(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f204l = (Rect[][]) rectArr.clone();
    }

    @Override // E.g0
    public void r(C0008h c0008h) {
    }
}
