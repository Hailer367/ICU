package androidx.recyclerview.widget;

import A2.i;
import W0.g;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import h0.AbstractC0333u;
import h0.C0301D;
import h0.C0325m;
import h0.C0326n;
import h0.C0327o;
import h0.C0334v;
import k3.b;

/* loaded from: classes.dex */
public class LinearLayoutManager extends AbstractC0333u {

    /* renamed from: h, reason: collision with root package name */
    public final int f3070h;

    /* renamed from: i, reason: collision with root package name */
    public g f3071i;

    /* renamed from: j, reason: collision with root package name */
    public final C0327o f3072j;
    public final boolean k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3073l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3074m = false;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3075n = true;

    /* renamed from: o, reason: collision with root package name */
    public C0326n f3076o = null;

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f3070h = 1;
        this.k = false;
        C0325m c0325m = new C0325m(0);
        c0325m.f3917b = -1;
        c0325m.f3918c = Integer.MIN_VALUE;
        c0325m.f3919d = false;
        c0325m.f3920e = false;
        C0325m w2 = AbstractC0333u.w(context, attributeSet, i4, i5);
        int i6 = w2.f3917b;
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException(i.g(i6, "invalid orientation:"));
        }
        a(null);
        if (i6 != this.f3070h || this.f3072j == null) {
            this.f3072j = C0327o.a(this, i6);
            this.f3070h = i6;
            H();
        }
        boolean z = w2.f3919d;
        a(null);
        if (z != this.k) {
            this.k = z;
            H();
        }
        Q(w2.f3920e);
    }

    @Override // h0.AbstractC0333u
    public final void A(AccessibilityEvent accessibilityEvent) {
        super.A(accessibilityEvent);
        if (p() > 0) {
            View P = P(0, p(), false);
            if (P == null) {
                accessibilityEvent.setFromIndex(-1);
                View P3 = P(p() - 1, -1, false);
                if (P3 == null) {
                    accessibilityEvent.setToIndex(-1);
                    return;
                } else {
                    ((C0334v) P3.getLayoutParams()).getClass();
                    throw null;
                }
            }
            ((C0334v) P.getLayoutParams()).getClass();
            throw null;
        }
    }

    @Override // h0.AbstractC0333u
    public final void B(Parcelable parcelable) {
        if (parcelable instanceof C0326n) {
            this.f3076o = (C0326n) parcelable;
            H();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.Parcelable, h0.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.os.Parcelable, h0.n, java.lang.Object] */
    @Override // h0.AbstractC0333u
    public final Parcelable C() {
        C0326n c0326n = this.f3076o;
        if (c0326n != null) {
            ?? obj = new Object();
            obj.f3921f = c0326n.f3921f;
            obj.f3922g = c0326n.f3922g;
            obj.f3923h = c0326n.f3923h;
            return obj;
        }
        ?? obj2 = new Object();
        if (p() > 0) {
            M();
            boolean z = this.f3073l;
            obj2.f3923h = z;
            int i4 = 0;
            if (z) {
                if (!z) {
                    i4 = p() - 1;
                }
                View o3 = o(i4);
                obj2.f3922g = this.f3072j.d() - this.f3072j.b(o3);
                AbstractC0333u.v(o3);
                throw null;
            }
            if (z) {
                i4 = p() - 1;
            }
            AbstractC0333u.v(o(i4));
            throw null;
        }
        obj2.f3921f = -1;
        return obj2;
    }

    public final int J(C0301D c0301d) {
        if (p() == 0) {
            return 0;
        }
        M();
        boolean z = !this.f3075n;
        return b.d(c0301d, this.f3072j, O(z), N(z), this, this.f3075n);
    }

    public final void K(C0301D c0301d) {
        if (p() != 0) {
            M();
            boolean z = !this.f3075n;
            View O3 = O(z);
            View N3 = N(z);
            if (p() != 0 && c0301d.a() != 0 && O3 != null && N3 != null) {
                ((C0334v) O3.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    public final int L(C0301D c0301d) {
        if (p() == 0) {
            return 0;
        }
        M();
        boolean z = !this.f3075n;
        return b.e(c0301d, this.f3072j, O(z), N(z), this, this.f3075n);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, W0.g] */
    public final void M() {
        if (this.f3071i == null) {
            this.f3071i = new Object();
        }
    }

    public final View N(boolean z) {
        if (this.f3073l) {
            return P(0, p(), z);
        }
        return P(p() - 1, -1, z);
    }

    public final View O(boolean z) {
        if (this.f3073l) {
            return P(p() - 1, -1, z);
        }
        return P(0, p(), z);
    }

    public final View P(int i4, int i5, boolean z) {
        int i6;
        M();
        if (z) {
            i6 = 24579;
        } else {
            i6 = 320;
        }
        if (this.f3070h == 0) {
            return this.f3932c.w(i4, i5, i6, 320);
        }
        return this.f3933d.w(i4, i5, i6, 320);
    }

    public void Q(boolean z) {
        a(null);
        if (this.f3074m == z) {
            return;
        }
        this.f3074m = z;
        H();
    }

    @Override // h0.AbstractC0333u
    public final void a(String str) {
        RecyclerView recyclerView;
        if (this.f3076o == null && (recyclerView = this.f3931b) != null) {
            recyclerView.b(str);
        }
    }

    @Override // h0.AbstractC0333u
    public final boolean b() {
        if (this.f3070h == 0) {
            return true;
        }
        return false;
    }

    @Override // h0.AbstractC0333u
    public final boolean c() {
        if (this.f3070h == 1) {
            return true;
        }
        return false;
    }

    @Override // h0.AbstractC0333u
    public final int f(C0301D c0301d) {
        return J(c0301d);
    }

    @Override // h0.AbstractC0333u
    public final void g(C0301D c0301d) {
        K(c0301d);
    }

    @Override // h0.AbstractC0333u
    public final int h(C0301D c0301d) {
        return L(c0301d);
    }

    @Override // h0.AbstractC0333u
    public final int i(C0301D c0301d) {
        return J(c0301d);
    }

    @Override // h0.AbstractC0333u
    public final void j(C0301D c0301d) {
        K(c0301d);
    }

    @Override // h0.AbstractC0333u
    public final int k(C0301D c0301d) {
        return L(c0301d);
    }

    @Override // h0.AbstractC0333u
    public C0334v l() {
        return new C0334v(-2, -2);
    }

    @Override // h0.AbstractC0333u
    public final boolean y() {
        return true;
    }

    @Override // h0.AbstractC0333u
    public final void z(RecyclerView recyclerView) {
    }
}
