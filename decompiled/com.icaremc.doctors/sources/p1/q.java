package p1;

/* loaded from: classes.dex */
public final class q implements T0.d, V0.d {

    /* renamed from: c, reason: collision with root package name */
    public final T0.d f3498c;

    /* renamed from: d, reason: collision with root package name */
    public final T0.i f3499d;

    public q(T0.d dVar, T0.i iVar) {
        this.f3498c = dVar;
        this.f3499d = iVar;
    }

    @Override // V0.d
    public final V0.d getCallerFrame() {
        T0.d dVar = this.f3498c;
        if (dVar instanceof V0.d) {
            return (V0.d) dVar;
        }
        return null;
    }

    @Override // T0.d
    public final T0.i getContext() {
        return this.f3499d;
    }

    @Override // T0.d
    public final void resumeWith(Object obj) {
        this.f3498c.resumeWith(obj);
    }
}
