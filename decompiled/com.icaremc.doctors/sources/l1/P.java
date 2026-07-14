package l1;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class P extends CancellationException {

    /* renamed from: c, reason: collision with root package name */
    public final transient X f2964c;

    public P(String str, Throwable th, X x2) {
        super(str);
        this.f2964c = x2;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof P) {
                P p = (P) obj;
                if (!kotlin.jvm.internal.h.a(p.getMessage(), getMessage()) || !kotlin.jvm.internal.h.a(p.f2964c, this.f2964c) || !kotlin.jvm.internal.h.a(p.getCause(), getCause())) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        int i2;
        String message = getMessage();
        kotlin.jvm.internal.h.b(message);
        int hashCode = (this.f2964c.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i2 = cause.hashCode();
        } else {
            i2 = 0;
        }
        return hashCode + i2;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f2964c;
    }
}
