package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import d.C0172a;
import java.util.ArrayList;
import r.C0293e;

/* renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0119n extends D0 {

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1692c;

    /* renamed from: d, reason: collision with root package name */
    public final E0 f1693d;

    /* renamed from: e, reason: collision with root package name */
    public final E0 f1694e;

    /* renamed from: f, reason: collision with root package name */
    public final z0 f1695f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f1696g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1697h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1698i;

    /* renamed from: j, reason: collision with root package name */
    public final C0293e f1699j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1700k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f1701l;

    /* renamed from: m, reason: collision with root package name */
    public final C0293e f1702m;

    /* renamed from: n, reason: collision with root package name */
    public final C0293e f1703n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f1704o;
    public final A.e p = new Object();

    /* JADX WARN: Type inference failed for: r1v1, types: [A.e, java.lang.Object] */
    public C0119n(ArrayList arrayList, E0 e02, E0 e03, z0 z0Var, Object obj, ArrayList arrayList2, ArrayList arrayList3, C0293e c0293e, ArrayList arrayList4, ArrayList arrayList5, C0293e c0293e2, C0293e c0293e3, boolean z) {
        this.f1692c = arrayList;
        this.f1693d = e02;
        this.f1694e = e03;
        this.f1695f = z0Var;
        this.f1696g = obj;
        this.f1697h = arrayList2;
        this.f1698i = arrayList3;
        this.f1699j = c0293e;
        this.f1700k = arrayList4;
        this.f1701l = arrayList5;
        this.f1702m = c0293e2;
        this.f1703n = c0293e3;
        this.f1704o = z;
    }

    public static void f(View view, ArrayList arrayList) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = E.L.f183a;
            if (viewGroup.isTransitionGroup()) {
                if (!arrayList.contains(view)) {
                    arrayList.add(view);
                    return;
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    f(childAt, arrayList);
                }
            }
            return;
        }
        if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    @Override // androidx.fragment.app.D0
    public final boolean a() {
        this.f1695f.i();
        return false;
    }

    @Override // androidx.fragment.app.D0
    public final void b(ViewGroup container) {
        kotlin.jvm.internal.h.e(container, "container");
        A.e eVar = this.p;
        synchronized (eVar) {
            try {
                if (eVar.f1a) {
                    return;
                }
                eVar.f1a = true;
                eVar.f3c = true;
                F.h hVar = eVar.f2b;
                if (hVar != null) {
                    try {
                        ((e0.s) hVar.f274d).d();
                    } catch (Throwable th) {
                        synchronized (eVar) {
                            eVar.f3c = false;
                            eVar.notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (eVar) {
                    eVar.f3c = false;
                    eVar.notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0286 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0272 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0229  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v9, types: [r.j] */
    @Override // androidx.fragment.app.D0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.view.ViewGroup r37) {
        /*
            Method dump skipped, instructions count: 1127
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0119n.c(android.view.ViewGroup):void");
    }

    @Override // androidx.fragment.app.D0
    public final void d(C0172a c0172a, ViewGroup container) {
        kotlin.jvm.internal.h.e(container, "container");
    }

    @Override // androidx.fragment.app.D0
    public final void e(ViewGroup container) {
        boolean z;
        Object obj;
        kotlin.jvm.internal.h.e(container, "container");
        if (!container.isLaidOut()) {
            ArrayList arrayList = this.f1692c;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                E0 e02 = ((C0120o) obj2).f1665a;
                if (h0.K(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + e02);
                }
            }
            return;
        }
        ArrayList arrayList2 = this.f1692c;
        if (!arrayList2.isEmpty()) {
            int size2 = arrayList2.size();
            z = false;
            int i3 = 0;
            while (i3 < size2) {
                Object obj3 = arrayList2.get(i3);
                i3++;
                if (!((C0120o) obj3).f1665a.f1536c.mTransitioning) {
                    break;
                }
            }
        }
        z = true;
        if (z && (obj = this.f1696g) != null) {
            a();
            Log.i("FragmentManager", "Ignoring shared elements transition " + obj + " between " + this.f1693d + " and " + this.f1694e + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
        }
        a();
    }
}
