package androidx.recyclerview.widget;

import A0.f;
import O.a;
import a0.C0056E;
import a0.C0071m;
import a0.C0072n;
import a0.C0073o;
import a0.v;
import a0.w;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class LinearLayoutManager extends v {

    /* renamed from: h, reason: collision with root package name */
    public final int f1887h;

    /* renamed from: i, reason: collision with root package name */
    public f f1888i;

    /* renamed from: j, reason: collision with root package name */
    public final C0073o f1889j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f1890k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f1891l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1892m = false;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f1893n = true;

    /* renamed from: o, reason: collision with root package name */
    public C0072n f1894o = null;

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1887h = 1;
        this.f1890k = false;
        C0071m c0071m = new C0071m(0);
        c0071m.f991b = -1;
        c0071m.f992c = Integer.MIN_VALUE;
        c0071m.f993d = false;
        c0071m.f994e = false;
        C0071m w2 = v.w(context, attributeSet, i2, i3);
        int i4 = w2.f991b;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException(a.c(i4, "invalid orientation:"));
        }
        a(null);
        if (i4 != this.f1887h || this.f1889j == null) {
            this.f1889j = C0073o.a(this, i4);
            this.f1887h = i4;
            H();
        }
        boolean z = w2.f993d;
        a(null);
        if (z != this.f1890k) {
            this.f1890k = z;
            H();
        }
        Q(w2.f994e);
    }

    @Override // a0.v
    public final void A(AccessibilityEvent accessibilityEvent) {
        super.A(accessibilityEvent);
        if (p() > 0) {
            View P2 = P(0, false, p());
            if (P2 == null) {
                accessibilityEvent.setFromIndex(-1);
                View P3 = P(p() - 1, false, -1);
                if (P3 == null) {
                    accessibilityEvent.setToIndex(-1);
                    return;
                } else {
                    ((w) P3.getLayoutParams()).getClass();
                    throw null;
                }
            }
            ((w) P2.getLayoutParams()).getClass();
            throw null;
        }
    }

    @Override // a0.v
    public final void B(Parcelable parcelable) {
        if (parcelable instanceof C0072n) {
            this.f1894o = (C0072n) parcelable;
            H();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [a0.n, android.os.Parcelable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [a0.n, android.os.Parcelable, java.lang.Object] */
    @Override // a0.v
    public final Parcelable C() {
        C0072n c0072n = this.f1894o;
        if (c0072n != null) {
            ?? obj = new Object();
            obj.f995c = c0072n.f995c;
            obj.f996d = c0072n.f996d;
            obj.f997e = c0072n.f997e;
            return obj;
        }
        ?? obj2 = new Object();
        if (p() > 0) {
            M();
            boolean z = this.f1891l;
            obj2.f997e = z;
            int i2 = 0;
            if (z) {
                if (!z) {
                    i2 = p() - 1;
                }
                View o2 = o(i2);
                obj2.f996d = this.f1889j.d() - this.f1889j.b(o2);
                v.v(o2);
                throw null;
            }
            if (z) {
                i2 = p() - 1;
            }
            v.v(o(i2));
            throw null;
        }
        obj2.f995c = -1;
        return obj2;
    }

    public final int J(C0056E c0056e) {
        if (p() == 0) {
            return 0;
        }
        M();
        boolean z = !this.f1893n;
        return android.support.v4.media.session.a.f(c0056e, this.f1889j, O(z), N(z), this, this.f1893n);
    }

    public final void K(C0056E c0056e) {
        if (p() != 0) {
            M();
            boolean z = !this.f1893n;
            View O2 = O(z);
            View N2 = N(z);
            if (p() != 0 && c0056e.a() != 0 && O2 != null && N2 != null) {
                ((w) O2.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    public final int L(C0056E c0056e) {
        if (p() == 0) {
            return 0;
        }
        M();
        boolean z = !this.f1893n;
        return android.support.v4.media.session.a.g(c0056e, this.f1889j, O(z), N(z), this, this.f1893n);
    }

    public final void M() {
        if (this.f1888i == null) {
            this.f1888i = new f(11);
        }
    }

    public final View N(boolean z) {
        if (this.f1891l) {
            return P(0, z, p());
        }
        return P(p() - 1, z, -1);
    }

    public final View O(boolean z) {
        if (this.f1891l) {
            return P(p() - 1, z, -1);
        }
        return P(0, z, p());
    }

    public final View P(int i2, boolean z, int i3) {
        int i4;
        M();
        if (z) {
            i4 = 24579;
        } else {
            i4 = 320;
        }
        if (this.f1887h == 0) {
            return this.f1008c.b(i2, i3, i4, 320);
        }
        return this.f1009d.b(i2, i3, i4, 320);
    }

    public void Q(boolean z) {
        a(null);
        if (this.f1892m == z) {
            return;
        }
        this.f1892m = z;
        H();
    }

    @Override // a0.v
    public final void a(String str) {
        RecyclerView recyclerView;
        if (this.f1894o == null && (recyclerView = this.f1007b) != null) {
            recyclerView.b(str);
        }
    }

    @Override // a0.v
    public final boolean b() {
        if (this.f1887h == 0) {
            return true;
        }
        return false;
    }

    @Override // a0.v
    public final boolean c() {
        if (this.f1887h == 1) {
            return true;
        }
        return false;
    }

    @Override // a0.v
    public final int f(C0056E c0056e) {
        return J(c0056e);
    }

    @Override // a0.v
    public final void g(C0056E c0056e) {
        K(c0056e);
    }

    @Override // a0.v
    public final int h(C0056E c0056e) {
        return L(c0056e);
    }

    @Override // a0.v
    public final int i(C0056E c0056e) {
        return J(c0056e);
    }

    @Override // a0.v
    public final void j(C0056E c0056e) {
        K(c0056e);
    }

    @Override // a0.v
    public final int k(C0056E c0056e) {
        return L(c0056e);
    }

    @Override // a0.v
    public w l() {
        return new w(-2, -2);
    }

    @Override // a0.v
    public final boolean y() {
        return true;
    }

    @Override // a0.v
    public final void z(RecyclerView recyclerView) {
    }
}
