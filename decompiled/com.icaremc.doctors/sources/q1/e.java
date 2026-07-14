package q1;

/* loaded from: classes.dex */
public final class e extends RuntimeException {

    /* renamed from: c, reason: collision with root package name */
    public final transient T0.i f3514c;

    public e(T0.i iVar) {
        this.f3514c = iVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f3514c.toString();
    }
}
