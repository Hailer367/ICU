package Z0;

/* loaded from: classes.dex */
public final class s extends Exception {

    /* renamed from: f, reason: collision with root package name */
    public final W0.a f2178f;

    public s(W0.a aVar) {
        boolean z;
        if (aVar.f1848g != 0 && aVar.f1849h != null) {
            z = true;
        } else {
            z = false;
        }
        r.a("ResolvableConnectionException can only be created with a connection result containing a resolution.", z);
        this.f2178f = aVar;
    }
}
