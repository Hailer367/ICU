package X0;

/* loaded from: classes.dex */
public final class j extends UnsupportedOperationException {

    /* renamed from: f, reason: collision with root package name */
    public final W0.c f2001f;

    public j(W0.c cVar) {
        this.f2001f = cVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f2001f));
    }
}
