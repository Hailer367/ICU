package e;

import android.util.Log;
import androidx.fragment.app.C0169a;
import androidx.fragment.app.G;
import androidx.fragment.app.P;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final q f3573a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3574b;

    /* renamed from: c, reason: collision with root package name */
    public d0.c f3575c;

    /* renamed from: d, reason: collision with root package name */
    public final G f3576d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3577e;

    public p(G g4, q qVar) {
        T2.h.e(g4, "onBackPressedCallback");
        boolean z = g4.f2722b;
        this.f3573a = qVar;
        this.f3574b = z;
        this.f3576d = g4;
        this.f3577e = true;
    }

    public final void a() {
        P p3 = this.f3576d.f2724d;
        if (P.J(3)) {
            Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager " + p3);
        }
        C0169a c0169a = p3.f2757h;
        if (c0169a != null) {
            c0169a.f2831q = false;
            c0169a.d(false);
            p3.A(true);
            p3.D();
            Iterator it = p3.f2761m.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
        p3.f2757h = null;
    }

    public final void b() {
        d0.c cVar = this.f3575c;
        if (cVar != null && cVar.f3434c.remove(this)) {
            d0.f fVar = cVar.f3433b;
            fVar.getClass();
            if (equals(fVar.f3445f)) {
                if (fVar.f3446g == -1) {
                    a();
                }
                fVar.f3445f = null;
                fVar.f3446g = 0;
                fVar.f3447h = null;
            }
            fVar.f3443d.remove(this);
            fVar.f3444e.remove(this);
            this.f3575c = null;
            fVar.b();
        }
    }

    public final void c(boolean z) {
        boolean z3;
        d0.f fVar;
        this.f3577e = z;
        if (z && this.f3576d.f2722b) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f3574b != z3) {
            this.f3574b = z3;
            d0.c cVar = this.f3575c;
            if (cVar != null && (fVar = cVar.f3433b) != null) {
                fVar.b();
            }
        }
    }
}
