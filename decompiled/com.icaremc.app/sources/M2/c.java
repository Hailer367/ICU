package M2;

import K2.i;
import b3.C0232g;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: g, reason: collision with root package name */
    public final i f1052g;

    /* renamed from: h, reason: collision with root package name */
    public transient K2.d f1053h;

    public c(K2.d dVar, i iVar) {
        super(dVar);
        this.f1052g = iVar;
    }

    @Override // K2.d
    public i getContext() {
        i iVar = this.f1052g;
        T2.h.b(iVar);
        return iVar;
    }

    @Override // M2.a
    public void m() {
        C0232g c0232g;
        K2.d dVar = this.f1053h;
        if (dVar != null && dVar != this) {
            K2.g e4 = getContext().e(K2.e.f941f);
            T2.h.b(e4);
            g3.f fVar = (g3.f) dVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g3.f.f3782m;
            do {
            } while (atomicReferenceFieldUpdater.get(fVar) == g3.a.f3772c);
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            if (obj instanceof C0232g) {
                c0232g = (C0232g) obj;
            } else {
                c0232g = null;
            }
            if (c0232g != null) {
                c0232g.o();
            }
        }
        this.f1053h = b.f1051f;
    }

    public c(K2.d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
