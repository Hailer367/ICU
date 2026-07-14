package androidx.recyclerview.widget;

import A0.f;
import B.b;
import F.h;
import a0.C0053B;
import a0.C0056E;
import a0.C0071m;
import a0.C0073o;
import a0.J;
import a0.L;
import a0.M;
import a0.v;
import a0.w;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.media.session.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.BitSet;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends v {

    /* renamed from: h, reason: collision with root package name */
    public final int f1950h;

    /* renamed from: i, reason: collision with root package name */
    public final M[] f1951i;

    /* renamed from: j, reason: collision with root package name */
    public final C0073o f1952j;

    /* renamed from: k, reason: collision with root package name */
    public final C0073o f1953k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1954l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f1955m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f1956n = false;

    /* renamed from: o, reason: collision with root package name */
    public final h f1957o;
    public final int p;
    public L q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f1958r;

    /* renamed from: s, reason: collision with root package name */
    public final b f1959s;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1950h = -1;
        this.f1955m = false;
        h hVar = new h(10, false);
        this.f1957o = hVar;
        this.p = 2;
        new Rect();
        new f(15, this);
        this.f1958r = true;
        this.f1959s = new b(4, this);
        C0071m w2 = v.w(context, attributeSet, i2, i3);
        int i4 = w2.f991b;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a(null);
        if (i4 != this.f1954l) {
            this.f1954l = i4;
            C0073o c0073o = this.f1952j;
            this.f1952j = this.f1953k;
            this.f1953k = c0073o;
            H();
        }
        int i5 = w2.f992c;
        a(null);
        if (i5 != this.f1950h) {
            hVar.f274d = null;
            H();
            this.f1950h = i5;
            new BitSet(this.f1950h);
            this.f1951i = new M[this.f1950h];
            for (int i6 = 0; i6 < this.f1950h; i6++) {
                this.f1951i[i6] = new M(this, i6);
            }
            H();
        }
        boolean z = w2.f993d;
        a(null);
        L l2 = this.q;
        if (l2 != null && l2.f923j != z) {
            l2.f923j = z;
        }
        this.f1955m = z;
        H();
        this.f1952j = C0073o.a(this, this.f1954l);
        this.f1953k = C0073o.a(this, 1 - this.f1954l);
    }

    @Override // a0.v
    public final void A(AccessibilityEvent accessibilityEvent) {
        super.A(accessibilityEvent);
        if (p() > 0) {
            View M2 = M(false);
            View L = L(false);
            if (M2 != null && L != null) {
                ((w) M2.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    @Override // a0.v
    public final void B(Parcelable parcelable) {
        if (parcelable instanceof L) {
            this.q = (L) parcelable;
            H();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [a0.L, android.os.Parcelable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [a0.L, android.os.Parcelable, java.lang.Object] */
    @Override // a0.v
    public final Parcelable C() {
        View M2;
        L l2 = this.q;
        if (l2 != null) {
            ?? obj = new Object();
            obj.f918e = l2.f918e;
            obj.f916c = l2.f916c;
            obj.f917d = l2.f917d;
            obj.f919f = l2.f919f;
            obj.f920g = l2.f920g;
            obj.f921h = l2.f921h;
            obj.f923j = l2.f923j;
            obj.f924k = l2.f924k;
            obj.f925l = l2.f925l;
            obj.f922i = l2.f922i;
            return obj;
        }
        ?? obj2 = new Object();
        obj2.f923j = this.f1955m;
        obj2.f924k = false;
        obj2.f925l = false;
        obj2.f920g = 0;
        if (p() > 0) {
            N();
            obj2.f916c = 0;
            if (this.f1956n) {
                M2 = L(true);
            } else {
                M2 = M(true);
            }
            if (M2 == null) {
                obj2.f917d = -1;
                int i2 = this.f1950h;
                obj2.f918e = i2;
                obj2.f919f = new int[i2];
                for (int i3 = 0; i3 < this.f1950h; i3++) {
                    M m2 = this.f1951i[i3];
                    int i4 = m2.f927b;
                    if (i4 == Integer.MIN_VALUE) {
                        if (m2.f926a.size() == 0) {
                            i4 = Integer.MIN_VALUE;
                        } else {
                            View view = (View) m2.f926a.get(0);
                            J j2 = (J) view.getLayoutParams();
                            m2.f927b = m2.f930e.f1952j.c(view);
                            j2.getClass();
                            i4 = m2.f927b;
                        }
                    }
                    if (i4 != Integer.MIN_VALUE) {
                        i4 -= this.f1952j.e();
                    }
                    obj2.f919f[i3] = i4;
                }
                return obj2;
            }
            ((w) M2.getLayoutParams()).getClass();
            throw null;
        }
        obj2.f916c = -1;
        obj2.f917d = -1;
        obj2.f918e = 0;
        return obj2;
    }

    @Override // a0.v
    public final void D(int i2) {
        if (i2 == 0) {
            J();
        }
    }

    public final boolean J() {
        if (p() == 0 || this.p == 0 || !this.f1010e) {
            return false;
        }
        boolean z = this.f1956n;
        if (z) {
            O();
            N();
        } else {
            N();
            O();
        }
        int p = p();
        int i2 = p - 1;
        int i3 = this.f1950h;
        new BitSet(i3).set(0, i3, true);
        if (this.f1954l == 1) {
            RecyclerView recyclerView = this.f1007b;
            Field field = E.J.f180a;
            if (recyclerView.getLayoutDirection() != 1) {
            }
        }
        if (z) {
            p = -1;
        } else {
            i2 = 0;
        }
        if (i2 == p) {
            return false;
        }
        ((J) o(i2).getLayoutParams()).getClass();
        throw null;
    }

    public final void K(C0056E c0056e) {
        if (p() != 0) {
            boolean z = !this.f1958r;
            View M2 = M(z);
            View L = L(z);
            if (p() != 0 && c0056e.a() != 0 && M2 != null && L != null) {
                ((w) M2.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    public final View L(boolean z) {
        int e2 = this.f1952j.e();
        int d2 = this.f1952j.d();
        View view = null;
        for (int p = p() - 1; p >= 0; p--) {
            View o2 = o(p);
            int c2 = this.f1952j.c(o2);
            int b2 = this.f1952j.b(o2);
            if (b2 > e2 && c2 < d2) {
                if (b2 > d2 && z) {
                    if (view == null) {
                        view = o2;
                    }
                } else {
                    return o2;
                }
            }
        }
        return view;
    }

    public final View M(boolean z) {
        int e2 = this.f1952j.e();
        int d2 = this.f1952j.d();
        int p = p();
        View view = null;
        for (int i2 = 0; i2 < p; i2++) {
            View o2 = o(i2);
            int c2 = this.f1952j.c(o2);
            if (this.f1952j.b(o2) > e2 && c2 < d2) {
                if (c2 < e2 && z) {
                    if (view == null) {
                        view = o2;
                    }
                } else {
                    return o2;
                }
            }
        }
        return view;
    }

    public final void N() {
        if (p() == 0) {
            return;
        }
        v.v(o(0));
        throw null;
    }

    public final void O() {
        int p = p();
        if (p == 0) {
            return;
        }
        v.v(o(p - 1));
        throw null;
    }

    @Override // a0.v
    public final void a(String str) {
        RecyclerView recyclerView;
        if (this.q == null && (recyclerView = this.f1007b) != null) {
            recyclerView.b(str);
        }
    }

    @Override // a0.v
    public final boolean b() {
        if (this.f1954l == 0) {
            return true;
        }
        return false;
    }

    @Override // a0.v
    public final boolean c() {
        if (this.f1954l == 1) {
            return true;
        }
        return false;
    }

    @Override // a0.v
    public final boolean d(w wVar) {
        return wVar instanceof J;
    }

    @Override // a0.v
    public final int f(C0056E c0056e) {
        if (p() == 0) {
            return 0;
        }
        boolean z = !this.f1958r;
        return a.f(c0056e, this.f1952j, M(z), L(z), this, this.f1958r);
    }

    @Override // a0.v
    public final void g(C0056E c0056e) {
        K(c0056e);
    }

    @Override // a0.v
    public final int h(C0056E c0056e) {
        if (p() == 0) {
            return 0;
        }
        boolean z = !this.f1958r;
        return a.g(c0056e, this.f1952j, M(z), L(z), this, this.f1958r);
    }

    @Override // a0.v
    public final int i(C0056E c0056e) {
        if (p() == 0) {
            return 0;
        }
        boolean z = !this.f1958r;
        return a.f(c0056e, this.f1952j, M(z), L(z), this, this.f1958r);
    }

    @Override // a0.v
    public final void j(C0056E c0056e) {
        K(c0056e);
    }

    @Override // a0.v
    public final int k(C0056E c0056e) {
        if (p() == 0) {
            return 0;
        }
        boolean z = !this.f1958r;
        return a.g(c0056e, this.f1952j, M(z), L(z), this, this.f1958r);
    }

    @Override // a0.v
    public final w l() {
        if (this.f1954l == 0) {
            return new w(-2, -1);
        }
        return new w(-1, -2);
    }

    @Override // a0.v
    public final w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    @Override // a0.v
    public final w n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new w((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new w(layoutParams);
    }

    @Override // a0.v
    public final int q(C0053B c0053b, C0056E c0056e) {
        if (this.f1954l == 1) {
            return this.f1950h;
        }
        super.q(c0053b, c0056e);
        return 1;
    }

    @Override // a0.v
    public final int x(C0053B c0053b, C0056E c0056e) {
        if (this.f1954l == 0) {
            return this.f1950h;
        }
        super.x(c0053b, c0056e);
        return 1;
    }

    @Override // a0.v
    public final boolean y() {
        if (this.p != 0) {
            return true;
        }
        return false;
    }

    @Override // a0.v
    public final void z(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1007b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.f1959s);
        }
        for (int i2 = 0; i2 < this.f1950h; i2++) {
            M m2 = this.f1951i[i2];
            m2.f926a.clear();
            m2.f927b = Integer.MIN_VALUE;
            m2.f928c = Integer.MIN_VALUE;
        }
        recyclerView.requestLayout();
    }
}
