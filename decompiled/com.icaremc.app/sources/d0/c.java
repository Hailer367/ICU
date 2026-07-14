package d0;

import D2.J;
import android.util.Log;
import androidx.fragment.app.O;
import androidx.fragment.app.P;
import e.p;
import e3.r;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final J f3432a;

    /* renamed from: b, reason: collision with root package name */
    public final f f3433b = new f();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f3434c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f3435d;

    public c(J j4) {
        this.f3432a = j4;
        new LinkedHashSet();
        this.f3434c = new LinkedHashSet();
        this.f3435d = new LinkedHashSet();
    }

    public final void a(e eVar) {
        if (this.f3435d.add(eVar)) {
            this.f3433b.a(this, eVar, -1);
        }
    }

    public final void b(i iVar, int i4) {
        if (i4 != 1 && i4 != 0) {
            throw new IllegalArgumentException(A2.i.g(i4, "Unsupported priority value: ").toString());
        }
        if (this.f3435d.add(iVar)) {
            this.f3433b.a(this, iVar, i4);
        }
    }

    public final void c(e eVar, b bVar) {
        f fVar = this.f3433b;
        fVar.getClass();
        if (fVar.f3446g == 0) {
            p c4 = fVar.c(-1);
            fVar.f3445f = c4;
            fVar.f3446g = -1;
            fVar.f3447h = eVar;
            if (bVar != null) {
                if (c4 != null) {
                    P p3 = c4.f3576d.f2724d;
                    if (P.J(3)) {
                        Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = true fragment manager " + p3);
                    }
                    p3.x();
                    p3.y(new O(p3), false);
                }
                r rVar = fVar.f3440a;
                h hVar = new h(bVar);
                rVar.getClass();
                rVar.c(null, hVar);
            }
        }
    }
}
