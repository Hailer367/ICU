package V0;

import T0.i;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.AbstractC0240s;
import l1.C0230h;

/* loaded from: classes.dex */
public abstract class c extends a {
    private final i _context;
    private transient T0.d intercepted;

    public c(T0.d dVar, i iVar) {
        super(dVar);
        this._context = iVar;
    }

    @Override // T0.d
    public i getContext() {
        i iVar = this._context;
        kotlin.jvm.internal.h.b(iVar);
        return iVar;
    }

    public final T0.d intercepted() {
        T0.d dVar;
        T0.d dVar2 = this.intercepted;
        if (dVar2 == null) {
            T0.f fVar = (T0.f) getContext().k(T0.e.f773c);
            if (fVar != null) {
                dVar = new q1.f((AbstractC0240s) fVar, this);
            } else {
                dVar = this;
            }
            this.intercepted = dVar;
            return dVar;
        }
        return dVar2;
    }

    @Override // V0.a
    public void releaseIntercepted() {
        C0230h c0230h;
        T0.d dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            T0.g k2 = getContext().k(T0.e.f773c);
            kotlin.jvm.internal.h.b(k2);
            q1.f fVar = (q1.f) dVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q1.f.f3515j;
            do {
            } while (atomicReferenceFieldUpdater.get(fVar) == q1.a.f3505c);
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            if (obj instanceof C0230h) {
                c0230h = (C0230h) obj;
            } else {
                c0230h = null;
            }
            if (c0230h != null) {
                c0230h.n();
            }
        }
        this.intercepted = b.f783c;
    }

    public c(T0.d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
