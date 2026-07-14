package d0;

import D2.J;
import android.util.Log;
import androidx.fragment.app.AbstractComponentCallbacksC0187t;
import androidx.fragment.app.C0181m;
import androidx.fragment.app.G;
import androidx.fragment.app.P;
import androidx.fragment.app.Y;
import androidx.fragment.app.b0;
import androidx.fragment.app.c0;
import e.p;
import e.t;
import e3.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public c f3438a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3439b;

    public final void a() {
        c cVar = this.f3438a;
        if (cVar != null) {
            if (!this.f3439b) {
                cVar.c(this, null);
            }
            f fVar = cVar.f3433b;
            J j4 = cVar.f3432a;
            fVar.getClass();
            if (equals(fVar.f3447h) && -1 == fVar.f3446g) {
                p pVar = fVar.f3445f;
                if (pVar == null) {
                    pVar = fVar.c(-1);
                }
                fVar.f3445f = null;
                fVar.f3446g = 0;
                fVar.f3447h = null;
                if (pVar == null) {
                    ((t) j4.f294g).f3584a.run();
                } else {
                    P p3 = pVar.f3576d.f2724d;
                    int i4 = 3;
                    if (P.J(3)) {
                        Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager " + p3);
                    }
                    G g4 = p3.f2758i;
                    ArrayList arrayList = p3.f2761m;
                    p3.A(true);
                    if (p3.f2757h != null) {
                        if (!arrayList.isEmpty()) {
                            LinkedHashSet linkedHashSet = new LinkedHashSet(P.E(p3.f2757h));
                            int size = arrayList.size();
                            int i5 = 0;
                            while (i5 < size) {
                                Object obj = arrayList.get(i5);
                                i5++;
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
                        ArrayList arrayList2 = p3.f2757h.f2816a;
                        int size2 = arrayList2.size();
                        int i6 = 0;
                        while (i6 < size2) {
                            Object obj2 = arrayList2.get(i6);
                            i6++;
                            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = ((Y) obj2).f2808b;
                            if (abstractComponentCallbacksC0187t != null) {
                                abstractComponentCallbacksC0187t.f2935r = false;
                            }
                        }
                        Iterator it2 = p3.f(new ArrayList(Collections.singletonList(p3.f2757h)), 0, 1).iterator();
                        while (it2.hasNext()) {
                            C0181m c0181m = (C0181m) it2.next();
                            ArrayList arrayList3 = c0181m.f2870c;
                            if (P.J(i4)) {
                                Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
                            }
                            c0181m.f(arrayList3);
                            c0181m.getClass();
                            T2.h.e(arrayList3, "operations");
                            ArrayList arrayList4 = new ArrayList();
                            Iterator it3 = arrayList3.iterator();
                            while (it3.hasNext()) {
                                ((c0) it3.next()).getClass();
                                I2.k.E(arrayList4, null);
                            }
                            List I3 = I2.e.I(I2.e.K(arrayList4));
                            int size3 = I3.size();
                            int i7 = 0;
                            while (i7 < size3) {
                                ((b0) I3.get(i7)).a(c0181m.f2868a);
                                i7++;
                                i4 = i4;
                            }
                            int i8 = i4;
                            int size4 = arrayList3.size();
                            for (int i9 = 0; i9 < size4; i9++) {
                                c0181m.a((c0) arrayList3.get(i9));
                            }
                            List I4 = I2.e.I(arrayList3);
                            if (I4.size() <= 0) {
                                i4 = i8;
                            } else {
                                ((c0) I4.get(0)).getClass();
                                throw null;
                            }
                        }
                        p3.f2757h = null;
                        p3.e0();
                        if (P.J(i4)) {
                            Log.d("FragmentManager", "Op is being set to null");
                            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + g4.f2722b + " for  FragmentManager " + p3);
                        }
                    } else if (g4.f2722b) {
                        if (P.J(3)) {
                            Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                        }
                        p3.Q();
                    } else {
                        if (P.J(3)) {
                            Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                        }
                        p3.f2756g.a().a();
                    }
                }
                r rVar = fVar.f3440a;
                rVar.getClass();
                rVar.c(null, g.f3453e);
            }
            this.f3439b = false;
            return;
        }
        throw new IllegalStateException("This input is not added to any dispatcher.");
    }

    public void b(boolean z) {
    }
}
