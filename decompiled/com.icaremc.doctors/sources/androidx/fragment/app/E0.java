package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class E0 {

    /* renamed from: a, reason: collision with root package name */
    public int f1534a;

    /* renamed from: b, reason: collision with root package name */
    public int f1535b;

    /* renamed from: c, reason: collision with root package name */
    public final H f1536c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1537d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1538e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1539f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1540g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1541h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1542i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f1543j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1544k;

    /* renamed from: l, reason: collision with root package name */
    public final o0 f1545l;

    public E0(int i2, int i3, o0 o0Var) {
        O.a.k(i2, "finalState");
        O.a.k(i3, "lifecycleImpact");
        H fragment = o0Var.f1711c;
        kotlin.jvm.internal.h.d(fragment, "fragmentStateManager.fragment");
        O.a.k(i2, "finalState");
        O.a.k(i3, "lifecycleImpact");
        kotlin.jvm.internal.h.e(fragment, "fragment");
        this.f1534a = i2;
        this.f1535b = i3;
        this.f1536c = fragment;
        this.f1537d = new ArrayList();
        this.f1542i = true;
        ArrayList arrayList = new ArrayList();
        this.f1543j = arrayList;
        this.f1544k = arrayList;
        this.f1545l = o0Var;
    }

    public final void a(ViewGroup container) {
        kotlin.jvm.internal.h.e(container, "container");
        this.f1541h = false;
        if (!this.f1538e) {
            this.f1538e = true;
            if (this.f1543j.isEmpty()) {
                b();
                return;
            }
            for (D0 d02 : R0.j.U(this.f1544k)) {
                d02.getClass();
                if (!d02.f1516b) {
                    d02.b(container);
                }
                d02.f1516b = true;
            }
        }
    }

    public final void b() {
        this.f1541h = false;
        if (!this.f1539f) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1539f = true;
            ArrayList arrayList = this.f1537d;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((Runnable) obj).run();
            }
        }
        this.f1536c.mTransitioning = false;
        this.f1545l.k();
    }

    public final void c(D0 effect) {
        kotlin.jvm.internal.h.e(effect, "effect");
        ArrayList arrayList = this.f1543j;
        if (arrayList.remove(effect) && arrayList.isEmpty()) {
            b();
        }
    }

    public final void d(int i2, int i3) {
        O.a.k(i2, "finalState");
        O.a.k(i3, "lifecycleImpact");
        int b2 = N.i.b(i3);
        H h2 = this.f1536c;
        if (b2 != 0) {
            if (b2 != 1) {
                if (b2 == 2) {
                    if (h0.K(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + h2 + " mFinalState = " + O.a.o(this.f1534a) + " -> REMOVED. mLifecycleImpact  = " + O.a.n(this.f1535b) + " to REMOVING.");
                    }
                    this.f1534a = 1;
                    this.f1535b = 3;
                    this.f1542i = true;
                    return;
                }
                return;
            }
            if (this.f1534a == 1) {
                if (h0.K(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + h2 + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + O.a.n(this.f1535b) + " to ADDING.");
                }
                this.f1534a = 2;
                this.f1535b = 2;
                this.f1542i = true;
                return;
            }
            return;
        }
        if (this.f1534a != 1) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + h2 + " mFinalState = " + O.a.o(this.f1534a) + " -> " + O.a.o(i2) + '.');
            }
            this.f1534a = i2;
        }
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + O.a.o(this.f1534a) + " lifecycleImpact = " + O.a.n(this.f1535b) + " fragment = " + this.f1536c + '}';
    }
}
