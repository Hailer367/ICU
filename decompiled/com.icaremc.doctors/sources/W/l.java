package W;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import d.C0172a;
import d.o;
import o1.v;

/* loaded from: classes.dex */
public final class l implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f823a;

    public l(j jVar) {
        this.f823a = jVar;
    }

    public final void onBackCancelled() {
        j jVar = this.f823a;
        c cVar = jVar.f800a;
        if (cVar != null) {
            if (!jVar.f801b) {
                cVar.c(jVar, null);
            }
            g gVar = cVar.f795b;
            gVar.getClass();
            if (jVar.equals(gVar.f809h) && -1 == gVar.f808g) {
                o oVar = gVar.f807f;
                if (oVar == null) {
                    oVar = gVar.c(-1);
                }
                gVar.f807f = null;
                gVar.f808g = 0;
                gVar.f809h = null;
                if (oVar != null) {
                    oVar.f2145f.handleOnBackCancelled();
                }
                v vVar = gVar.f802a;
                vVar.getClass();
                vVar.c(null, h.f816f);
            }
            jVar.f801b = false;
            return;
        }
        throw new IllegalStateException("This input is not added to any dispatcher.");
    }

    public final void onBackInvoked() {
        this.f823a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        kotlin.jvm.internal.h.e(backEvent, "backEvent");
        b a2 = android.support.v4.media.session.a.a(backEvent);
        j jVar = this.f823a;
        c cVar = jVar.f800a;
        if (cVar != null) {
            if (jVar.f801b) {
                g gVar = cVar.f795b;
                gVar.getClass();
                if (jVar.equals(gVar.f809h) && -1 == gVar.f808g) {
                    o oVar = gVar.f807f;
                    if (oVar == null) {
                        oVar = gVar.c(-1);
                    }
                    if (oVar != null) {
                        oVar.f2145f.handleOnBackProgressed(new C0172a(a2));
                    }
                    v vVar = gVar.f802a;
                    i iVar = new i(a2);
                    vVar.getClass();
                    vVar.c(null, iVar);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("This input is not added to any dispatcher.");
    }

    public final void onBackStarted(BackEvent backEvent) {
        kotlin.jvm.internal.h.e(backEvent, "backEvent");
        b a2 = android.support.v4.media.session.a.a(backEvent);
        j jVar = this.f823a;
        c cVar = jVar.f800a;
        if (cVar != null) {
            if (!jVar.f801b) {
                cVar.c(jVar, a2);
                jVar.f801b = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("This input is not added to any dispatcher.");
    }
}
