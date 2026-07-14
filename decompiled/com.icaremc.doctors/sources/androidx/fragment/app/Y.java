package androidx.fragment.app;

import android.util.Log;
import d.C0172a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class Y extends d.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f1577a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(h0 h0Var) {
        super(false);
        this.f1577a = h0Var;
    }

    @Override // d.p
    public final void handleOnBackCancelled() {
        boolean K2 = h0.K(3);
        h0 h0Var = this.f1577a;
        if (K2) {
            Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager " + h0Var);
        }
        C0099a c0099a = h0Var.f1640h;
        if (c0099a != null) {
            c0099a.q = false;
            c0099a.e(false);
            h0Var.z(true);
            h0Var.E();
            Iterator it = h0Var.f1645m.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
        h0Var.f1640h = null;
    }

    @Override // d.p
    public final void handleOnBackPressed() {
        boolean K2 = h0.K(3);
        h0 h0Var = this.f1577a;
        if (K2) {
            Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager " + h0Var);
        }
        Y y = h0Var.f1641i;
        ArrayList arrayList = h0Var.f1645m;
        h0Var.z(true);
        if (h0Var.f1640h != null) {
            if (!arrayList.isEmpty()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(h0.F(h0Var.f1640h));
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    if (obj == null) {
                        Iterator it = linkedHashSet.iterator();
                        if (it.hasNext()) {
                            throw null;
                        }
                    } else {
                        throw new ClassCastException();
                    }
                }
            }
            ArrayList arrayList2 = h0Var.f1640h.f1735a;
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                H h2 = ((q0) obj2).f1726b;
                if (h2 != null) {
                    h2.mTransitioning = false;
                }
            }
            Iterator it2 = h0Var.f(new ArrayList(Collections.singletonList(h0Var.f1640h)), 0, 1).iterator();
            while (it2.hasNext()) {
                C0121p c0121p = (C0121p) it2.next();
                ArrayList arrayList3 = c0121p.f1716c;
                if (h0.K(3)) {
                    Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
                }
                c0121p.l(arrayList3);
                c0121p.c(arrayList3);
            }
            h0Var.f1640h = null;
            h0Var.e0();
            if (h0.K(3)) {
                Log.d("FragmentManager", "Op is being set to null");
                Log.d("FragmentManager", "OnBackPressedCallback enabled=" + y.isEnabled() + " for  FragmentManager " + h0Var);
                return;
            }
            return;
        }
        if (y.isEnabled()) {
            if (h0.K(3)) {
                Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
            }
            h0Var.Q();
        } else {
            if (h0.K(3)) {
                Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
            }
            h0Var.f1639g.b().a();
        }
    }

    @Override // d.p
    public final void handleOnBackProgressed(C0172a backEvent) {
        boolean K2 = h0.K(2);
        h0 h0Var = this.f1577a;
        if (K2) {
            Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = true fragment manager " + h0Var);
        }
        if (h0Var.f1640h != null) {
            Iterator it = h0Var.f(new ArrayList(Collections.singletonList(h0Var.f1640h)), 0, 1).iterator();
            while (it.hasNext()) {
                C0121p c0121p = (C0121p) it.next();
                c0121p.getClass();
                kotlin.jvm.internal.h.e(backEvent, "backEvent");
                if (h0.K(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.f2113c);
                }
                ArrayList arrayList = c0121p.f1716c;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    R0.p.P(arrayList2, ((E0) obj).f1544k);
                }
                List U2 = R0.j.U(R0.j.W(arrayList2));
                int size2 = U2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((D0) U2.get(i3)).d(backEvent, c0121p.f1714a);
                }
            }
            Iterator it2 = h0Var.f1645m.iterator();
            if (it2.hasNext()) {
                it2.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    @Override // d.p
    public final void handleOnBackStarted(C0172a c0172a) {
        boolean K2 = h0.K(3);
        h0 h0Var = this.f1577a;
        if (K2) {
            Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = true fragment manager " + h0Var);
        }
        h0Var.w();
        h0Var.x(new C0112g0(h0Var), false);
    }
}
