package androidx.recyclerview.widget;

import F.b;
import I.T;
import R1.c;
import Z0.g;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import h0.AbstractC0333u;
import h0.C0298A;
import h0.C0301D;
import h0.C0306I;
import h0.C0308K;
import h0.C0309L;
import h0.C0325m;
import h0.C0327o;
import h0.C0334v;
import java.util.BitSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends AbstractC0333u {

    /* renamed from: h, reason: collision with root package name */
    public final int f3133h;

    /* renamed from: i, reason: collision with root package name */
    public final C0309L[] f3134i;

    /* renamed from: j, reason: collision with root package name */
    public final C0327o f3135j;
    public final C0327o k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3136l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f3137m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3138n = false;

    /* renamed from: o, reason: collision with root package name */
    public final c f3139o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3140p;

    /* renamed from: q, reason: collision with root package name */
    public C0308K f3141q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f3142r;

    /* renamed from: s, reason: collision with root package name */
    public final b f3143s;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f3133h = -1;
        this.f3137m = false;
        c cVar = new c(24, false);
        this.f3139o = cVar;
        this.f3140p = 2;
        new Rect();
        new g(this);
        this.f3142r = true;
        this.f3143s = new b(13, this);
        C0325m w2 = AbstractC0333u.w(context, attributeSet, i4, i5);
        int i6 = w2.f3917b;
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a(null);
        if (i6 != this.f3136l) {
            this.f3136l = i6;
            C0327o c0327o = this.f3135j;
            this.f3135j = this.k;
            this.k = c0327o;
            H();
        }
        int i7 = w2.f3918c;
        a(null);
        if (i7 != this.f3133h) {
            cVar.f1532g = null;
            H();
            this.f3133h = i7;
            new BitSet(this.f3133h);
            this.f3134i = new C0309L[this.f3133h];
            for (int i8 = 0; i8 < this.f3133h; i8++) {
                this.f3134i[i8] = new C0309L(this, i8);
            }
            H();
        }
        boolean z = w2.f3919d;
        a(null);
        C0308K c0308k = this.f3141q;
        if (c0308k != null && c0308k.f3847m != z) {
            c0308k.f3847m = z;
        }
        this.f3137m = z;
        H();
        this.f3135j = C0327o.a(this, this.f3136l);
        this.k = C0327o.a(this, 1 - this.f3136l);
    }

    @Override // h0.AbstractC0333u
    public final void A(AccessibilityEvent accessibilityEvent) {
        super.A(accessibilityEvent);
        if (p() > 0) {
            View M3 = M(false);
            View L3 = L(false);
            if (M3 != null && L3 != null) {
                ((C0334v) M3.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    @Override // h0.AbstractC0333u
    public final void B(Parcelable parcelable) {
        if (parcelable instanceof C0308K) {
            this.f3141q = (C0308K) parcelable;
            H();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.Parcelable, h0.K, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable, h0.K, java.lang.Object] */
    @Override // h0.AbstractC0333u
    public final Parcelable C() {
        View M3;
        C0308K c0308k = this.f3141q;
        if (c0308k != null) {
            ?? obj = new Object();
            obj.f3843h = c0308k.f3843h;
            obj.f3841f = c0308k.f3841f;
            obj.f3842g = c0308k.f3842g;
            obj.f3844i = c0308k.f3844i;
            obj.f3845j = c0308k.f3845j;
            obj.k = c0308k.k;
            obj.f3847m = c0308k.f3847m;
            obj.f3848n = c0308k.f3848n;
            obj.f3849o = c0308k.f3849o;
            obj.f3846l = c0308k.f3846l;
            return obj;
        }
        ?? obj2 = new Object();
        obj2.f3847m = this.f3137m;
        obj2.f3848n = false;
        obj2.f3849o = false;
        obj2.f3845j = 0;
        if (p() > 0) {
            N();
            obj2.f3841f = 0;
            if (this.f3138n) {
                M3 = L(true);
            } else {
                M3 = M(true);
            }
            if (M3 == null) {
                obj2.f3842g = -1;
                int i4 = this.f3133h;
                obj2.f3843h = i4;
                obj2.f3844i = new int[i4];
                for (int i5 = 0; i5 < this.f3133h; i5++) {
                    C0309L c0309l = this.f3134i[i5];
                    int i6 = c0309l.f3851b;
                    if (i6 == Integer.MIN_VALUE) {
                        if (c0309l.f3850a.size() == 0) {
                            i6 = Integer.MIN_VALUE;
                        } else {
                            View view = (View) c0309l.f3850a.get(0);
                            C0306I c0306i = (C0306I) view.getLayoutParams();
                            c0309l.f3851b = c0309l.f3854e.f3135j.c(view);
                            c0306i.getClass();
                            i6 = c0309l.f3851b;
                        }
                    }
                    if (i6 != Integer.MIN_VALUE) {
                        i6 -= this.f3135j.e();
                    }
                    obj2.f3844i[i5] = i6;
                }
                return obj2;
            }
            ((C0334v) M3.getLayoutParams()).getClass();
            throw null;
        }
        obj2.f3841f = -1;
        obj2.f3842g = -1;
        obj2.f3843h = 0;
        return obj2;
    }

    @Override // h0.AbstractC0333u
    public final void D(int i4) {
        if (i4 == 0) {
            J();
        }
    }

    public final boolean J() {
        if (p() == 0 || this.f3140p == 0 || !this.f3934e) {
            return false;
        }
        boolean z = this.f3138n;
        if (z) {
            O();
            N();
        } else {
            N();
            O();
        }
        int p3 = p();
        int i4 = p3 - 1;
        int i5 = this.f3133h;
        new BitSet(i5).set(0, i5, true);
        if (this.f3136l == 1) {
            RecyclerView recyclerView = this.f3931b;
            WeakHashMap weakHashMap = T.f702a;
            if (recyclerView.getLayoutDirection() != 1) {
            }
        }
        if (z) {
            p3 = -1;
        } else {
            i4 = 0;
        }
        if (i4 == p3) {
            return false;
        }
        ((C0306I) o(i4).getLayoutParams()).getClass();
        throw null;
    }

    public final void K(C0301D c0301d) {
        if (p() != 0) {
            boolean z = !this.f3142r;
            View M3 = M(z);
            View L3 = L(z);
            if (p() != 0 && c0301d.a() != 0 && M3 != null && L3 != null) {
                ((C0334v) M3.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    public final View L(boolean z) {
        int e4 = this.f3135j.e();
        int d4 = this.f3135j.d();
        View view = null;
        for (int p3 = p() - 1; p3 >= 0; p3--) {
            View o3 = o(p3);
            int c4 = this.f3135j.c(o3);
            int b4 = this.f3135j.b(o3);
            if (b4 > e4 && c4 < d4) {
                if (b4 > d4 && z) {
                    if (view == null) {
                        view = o3;
                    }
                } else {
                    return o3;
                }
            }
        }
        return view;
    }

    public final View M(boolean z) {
        int e4 = this.f3135j.e();
        int d4 = this.f3135j.d();
        int p3 = p();
        View view = null;
        for (int i4 = 0; i4 < p3; i4++) {
            View o3 = o(i4);
            int c4 = this.f3135j.c(o3);
            if (this.f3135j.b(o3) > e4 && c4 < d4) {
                if (c4 < e4 && z) {
                    if (view == null) {
                        view = o3;
                    }
                } else {
                    return o3;
                }
            }
        }
        return view;
    }

    public final void N() {
        if (p() == 0) {
            return;
        }
        AbstractC0333u.v(o(0));
        throw null;
    }

    public final void O() {
        int p3 = p();
        if (p3 == 0) {
            return;
        }
        AbstractC0333u.v(o(p3 - 1));
        throw null;
    }

    @Override // h0.AbstractC0333u
    public final void a(String str) {
        RecyclerView recyclerView;
        if (this.f3141q == null && (recyclerView = this.f3931b) != null) {
            recyclerView.b(str);
        }
    }

    @Override // h0.AbstractC0333u
    public final boolean b() {
        if (this.f3136l == 0) {
            return true;
        }
        return false;
    }

    @Override // h0.AbstractC0333u
    public final boolean c() {
        if (this.f3136l == 1) {
            return true;
        }
        return false;
    }

    @Override // h0.AbstractC0333u
    public final boolean d(C0334v c0334v) {
        return c0334v instanceof C0306I;
    }

    @Override // h0.AbstractC0333u
    public final int f(C0301D c0301d) {
        if (p() == 0) {
            return 0;
        }
        boolean z = !this.f3142r;
        return k3.b.d(c0301d, this.f3135j, M(z), L(z), this, this.f3142r);
    }

    @Override // h0.AbstractC0333u
    public final void g(C0301D c0301d) {
        K(c0301d);
    }

    @Override // h0.AbstractC0333u
    public final int h(C0301D c0301d) {
        if (p() == 0) {
            return 0;
        }
        boolean z = !this.f3142r;
        return k3.b.e(c0301d, this.f3135j, M(z), L(z), this, this.f3142r);
    }

    @Override // h0.AbstractC0333u
    public final int i(C0301D c0301d) {
        if (p() == 0) {
            return 0;
        }
        boolean z = !this.f3142r;
        return k3.b.d(c0301d, this.f3135j, M(z), L(z), this, this.f3142r);
    }

    @Override // h0.AbstractC0333u
    public final void j(C0301D c0301d) {
        K(c0301d);
    }

    @Override // h0.AbstractC0333u
    public final int k(C0301D c0301d) {
        if (p() == 0) {
            return 0;
        }
        boolean z = !this.f3142r;
        return k3.b.e(c0301d, this.f3135j, M(z), L(z), this, this.f3142r);
    }

    @Override // h0.AbstractC0333u
    public final C0334v l() {
        if (this.f3136l == 0) {
            return new C0334v(-2, -1);
        }
        return new C0334v(-1, -2);
    }

    @Override // h0.AbstractC0333u
    public final C0334v m(Context context, AttributeSet attributeSet) {
        return new C0334v(context, attributeSet);
    }

    @Override // h0.AbstractC0333u
    public final C0334v n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0334v((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0334v(layoutParams);
    }

    @Override // h0.AbstractC0333u
    public final int q(C0298A c0298a, C0301D c0301d) {
        if (this.f3136l == 1) {
            return this.f3133h;
        }
        super.q(c0298a, c0301d);
        return 1;
    }

    @Override // h0.AbstractC0333u
    public final int x(C0298A c0298a, C0301D c0301d) {
        if (this.f3136l == 0) {
            return this.f3133h;
        }
        super.x(c0298a, c0301d);
        return 1;
    }

    @Override // h0.AbstractC0333u
    public final boolean y() {
        if (this.f3140p != 0) {
            return true;
        }
        return false;
    }

    @Override // h0.AbstractC0333u
    public final void z(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3931b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.f3143s);
        }
        for (int i4 = 0; i4 < this.f3133h; i4++) {
            C0309L c0309l = this.f3134i[i4];
            c0309l.f3850a.clear();
            c0309l.f3851b = Integer.MIN_VALUE;
            c0309l.f3852c = Integer.MIN_VALUE;
        }
        recyclerView.requestLayout();
    }
}
