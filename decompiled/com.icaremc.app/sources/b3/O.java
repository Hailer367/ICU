package b3;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class O extends CancellationException {

    /* renamed from: f, reason: collision with root package name */
    public final transient W f3250f;

    public O(String str, Throwable th, W w2) {
        super(str);
        this.f3250f = w2;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof O) {
                O o3 = (O) obj;
                if (!T2.h.a(o3.getMessage(), getMessage()) || !T2.h.a(o3.f3250f, this.f3250f) || !T2.h.a(o3.getCause(), getCause())) {
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
        int i4;
        String message = getMessage();
        T2.h.b(message);
        int hashCode = (this.f3250f.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i4 = cause.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f3250f;
    }
}
