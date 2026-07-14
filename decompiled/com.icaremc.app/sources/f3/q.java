package f3;

/* loaded from: classes.dex */
public final class q implements K2.d, M2.d {

    /* renamed from: f, reason: collision with root package name */
    public final K2.d f3736f;

    /* renamed from: g, reason: collision with root package name */
    public final K2.i f3737g;

    public q(K2.d dVar, K2.i iVar) {
        this.f3736f = dVar;
        this.f3737g = iVar;
    }

    @Override // M2.d
    public final M2.d d() {
        K2.d dVar = this.f3736f;
        if (dVar instanceof M2.d) {
            return (M2.d) dVar;
        }
        return null;
    }

    @Override // K2.d
    public final K2.i getContext() {
        return this.f3737g;
    }

    @Override // K2.d
    public final void resumeWith(Object obj) {
        this.f3736f.resumeWith(obj);
    }
}
