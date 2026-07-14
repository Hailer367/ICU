package g3;

/* loaded from: classes.dex */
public final class e extends RuntimeException {

    /* renamed from: f, reason: collision with root package name */
    public final transient K2.i f3781f;

    public e(K2.i iVar) {
        this.f3781f = iVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f3781f.toString();
    }
}
