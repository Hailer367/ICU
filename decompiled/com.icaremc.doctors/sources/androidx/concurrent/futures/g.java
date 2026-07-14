package androidx.concurrent.futures;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final j f1275c;

    /* renamed from: d, reason: collision with root package name */
    public final G0.a f1276d;

    public g(j jVar, G0.a aVar) {
        this.f1275c = jVar;
        this.f1276d = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1275c.value == this) {
            if (j.ATOMIC_HELPER.b(this.f1275c, this, j.getFutureValue(this.f1276d))) {
                j.complete(this.f1275c);
            }
        }
    }
}
