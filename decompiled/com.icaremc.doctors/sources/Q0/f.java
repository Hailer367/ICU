package Q0;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class f implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f716c;

    public f(Throwable exception) {
        kotlin.jvm.internal.h.e(exception, "exception");
        this.f716c = exception;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            if (kotlin.jvm.internal.h.a(this.f716c, ((f) obj).f716c)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f716c.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f716c + ')';
    }
}
