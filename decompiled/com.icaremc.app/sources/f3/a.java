package f3;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a extends CancellationException {

    /* renamed from: f, reason: collision with root package name */
    public final transient Object f3709f;

    public a(e3.e eVar) {
        super("Flow was aborted, no more elements needed");
        this.f3709f = eVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
