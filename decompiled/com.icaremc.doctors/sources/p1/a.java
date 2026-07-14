package p1;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a extends CancellationException {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object f3467c;

    public a(o1.e eVar) {
        super("Flow was aborted, no more elements needed");
        this.f3467c = eVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
