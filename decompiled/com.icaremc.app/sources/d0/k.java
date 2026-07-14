package d0;

import android.util.Log;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import androidx.fragment.app.C0181m;
import androidx.fragment.app.G;
import androidx.fragment.app.P;
import androidx.fragment.app.b0;
import androidx.fragment.app.c0;
import e.C0266a;
import e.p;
import e3.r;
import h2.AbstractActivityC0349b;
import h2.C0353f;
import i2.C0368c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s2.C0644p;

/* loaded from: classes.dex */
public final class k implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3461a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3462b;

    public /* synthetic */ k(int i4, Object obj) {
        this.f3461a = i4;
        this.f3462b = obj;
    }

    public final void onBackCancelled() {
        switch (this.f3461a) {
            case 0:
                i iVar = (i) this.f3462b;
                c cVar = iVar.f3438a;
                if (cVar != null) {
                    if (!iVar.f3439b) {
                        cVar.c(iVar, null);
                    }
                    f fVar = cVar.f3433b;
                    fVar.getClass();
                    if (iVar.equals(fVar.f3447h) && -1 == fVar.f3446g) {
                        p pVar = fVar.f3445f;
                        if (pVar == null) {
                            pVar = fVar.c(-1);
                        }
                        fVar.f3445f = null;
                        fVar.f3446g = 0;
                        fVar.f3447h = null;
                        if (pVar != null) {
                            pVar.a();
                        }
                        r rVar = fVar.f3440a;
                        rVar.getClass();
                        rVar.c(null, g.f3453e);
                    }
                    iVar.f3439b = false;
                    return;
                }
                throw new IllegalStateException("This input is not added to any dispatcher.");
            default:
                AbstractActivityC0349b abstractActivityC0349b = (AbstractActivityC0349b) this.f3462b;
                if (abstractActivityC0349b.j("cancelBackGesture")) {
                    C0353f c0353f = abstractActivityC0349b.f3973g;
                    c0353f.c();
                    C0368c c0368c = c0353f.f3981b;
                    if (c0368c != null) {
                        ((C0644p) c0368c.f4115j.f5322g).a("cancelBackGesture", null, null);
                        return;
                    } else {
                        Log.w("FlutterActivityAndFragmentDelegate", "Invoked cancelBackGesture() before FlutterFragment was attached to an Activity.");
                        return;
                    }
                }
                return;
        }
    }

    public final void onBackInvoked() {
        switch (this.f3461a) {
            case 0:
                ((i) this.f3462b).a();
                return;
            default:
                AbstractActivityC0349b abstractActivityC0349b = (AbstractActivityC0349b) this.f3462b;
                if (abstractActivityC0349b.j("commitBackGesture")) {
                    C0353f c0353f = abstractActivityC0349b.f3973g;
                    c0353f.c();
                    C0368c c0368c = c0353f.f3981b;
                    if (c0368c != null) {
                        ((C0644p) c0368c.f4115j.f5322g).a("commitBackGesture", null, null);
                        return;
                    } else {
                        Log.w("FlutterActivityAndFragmentDelegate", "Invoked commitBackGesture() before FlutterFragment was attached to an Activity.");
                        return;
                    }
                }
                return;
        }
    }

    public final void onBackProgressed(BackEvent backEvent) {
        switch (this.f3461a) {
            case 0:
                T2.h.e(backEvent, "backEvent");
                i iVar = (i) this.f3462b;
                b d4 = android.support.v4.media.session.a.d(backEvent);
                c cVar = iVar.f3438a;
                if (cVar != null) {
                    if (iVar.f3439b) {
                        f fVar = cVar.f3433b;
                        fVar.getClass();
                        if (iVar.equals(fVar.f3447h) && -1 == fVar.f3446g) {
                            p pVar = fVar.f3445f;
                            if (pVar == null) {
                                pVar = fVar.c(-1);
                            }
                            if (pVar != null) {
                                G g4 = pVar.f3576d;
                                C0266a c0266a = new C0266a(d4);
                                P p3 = g4.f2724d;
                                if (P.J(2)) {
                                    Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = true fragment manager " + p3);
                                }
                                if (p3.f2757h != null) {
                                    Iterator it = p3.f(new ArrayList(Collections.singletonList(p3.f2757h)), 0, 1).iterator();
                                    while (it.hasNext()) {
                                        C0181m c0181m = (C0181m) it.next();
                                        c0181m.getClass();
                                        if (P.J(2)) {
                                            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + c0266a.f3543c);
                                        }
                                        ArrayList arrayList = c0181m.f2870c;
                                        ArrayList arrayList2 = new ArrayList();
                                        int size = arrayList.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            Object obj = arrayList.get(i4);
                                            i4++;
                                            ((c0) obj).getClass();
                                            I2.k.E(arrayList2, null);
                                        }
                                        List I3 = I2.e.I(I2.e.K(arrayList2));
                                        int size2 = I3.size();
                                        for (int i5 = 0; i5 < size2; i5++) {
                                            ((b0) I3.get(i5)).b(c0266a, c0181m.f2868a);
                                        }
                                    }
                                    Iterator it2 = p3.f2761m.iterator();
                                    if (it2.hasNext()) {
                                        it2.next().getClass();
                                        throw new ClassCastException();
                                    }
                                }
                            }
                            r rVar = fVar.f3440a;
                            h hVar = new h(d4);
                            rVar.getClass();
                            rVar.c(null, hVar);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("This input is not added to any dispatcher.");
            default:
                AbstractActivityC0349b abstractActivityC0349b = (AbstractActivityC0349b) this.f3462b;
                if (abstractActivityC0349b.j("updateBackGestureProgress")) {
                    C0353f c0353f = abstractActivityC0349b.f3973g;
                    c0353f.c();
                    C0368c c0368c = c0353f.f3981b;
                    if (c0368c != null) {
                        ((C0644p) c0368c.f4115j.f5322g).a("updateBackGestureProgress", n.p.f(backEvent), null);
                        return;
                    } else {
                        Log.w("FlutterActivityAndFragmentDelegate", "Invoked updateBackGestureProgress() before FlutterFragment was attached to an Activity.");
                        return;
                    }
                }
                return;
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        switch (this.f3461a) {
            case 0:
                T2.h.e(backEvent, "backEvent");
                i iVar = (i) this.f3462b;
                b d4 = android.support.v4.media.session.a.d(backEvent);
                c cVar = iVar.f3438a;
                if (cVar != null) {
                    if (!iVar.f3439b) {
                        cVar.c(iVar, d4);
                        iVar.f3439b = true;
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("This input is not added to any dispatcher.");
            default:
                AbstractActivityC0349b abstractActivityC0349b = (AbstractActivityC0349b) this.f3462b;
                if (abstractActivityC0349b.j("startBackGesture")) {
                    C0353f c0353f = abstractActivityC0349b.f3973g;
                    c0353f.c();
                    C0368c c0368c = c0353f.f3981b;
                    if (c0368c != null) {
                        ((C0644p) c0368c.f4115j.f5322g).a("startBackGesture", n.p.f(backEvent), null);
                        return;
                    } else {
                        Log.w("FlutterActivityAndFragmentDelegate", "Invoked startBackGesture() before FlutterFragment was attached to an Activity.");
                        return;
                    }
                }
                return;
        }
    }
}
