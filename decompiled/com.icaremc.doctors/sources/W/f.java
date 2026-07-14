package W;

import d.o;
import d.t;
import o1.v;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public c f800a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f801b;

    public final void a() {
        c cVar = this.f800a;
        if (cVar != null) {
            if (!this.f801b) {
                cVar.c(this, null);
            }
            g gVar = cVar.f795b;
            B0.h hVar = cVar.f794a;
            gVar.getClass();
            if (equals(gVar.f809h) && -1 == gVar.f808g) {
                o oVar = gVar.f807f;
                if (oVar == null) {
                    oVar = gVar.c(-1);
                }
                gVar.f807f = null;
                gVar.f808g = 0;
                gVar.f809h = null;
                if (oVar == null) {
                    ((t) hVar.f98b).f2153a.run();
                } else {
                    oVar.f2145f.handleOnBackPressed();
                }
                v vVar = gVar.f802a;
                vVar.getClass();
                vVar.c(null, h.f816f);
            }
            this.f801b = false;
            return;
        }
        throw new IllegalStateException("This input is not added to any dispatcher.");
    }

    public void b(boolean z) {
    }
}
