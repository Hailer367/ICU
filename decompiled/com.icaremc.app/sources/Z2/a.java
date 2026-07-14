package Z2;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f2203a;

    public a(d dVar) {
        this.f2203a = new AtomicReference(dVar);
    }

    @Override // Z2.d
    public final Iterator iterator() {
        d dVar = (d) this.f2203a.getAndSet(null);
        if (dVar != null) {
            return dVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
