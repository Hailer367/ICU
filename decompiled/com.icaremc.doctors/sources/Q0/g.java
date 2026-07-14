package Q0;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class g implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Object f717c;

    public static final Throwable a(Object obj) {
        if (obj instanceof f) {
            return ((f) obj).f716c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            if (!kotlin.jvm.internal.h.a(this.f717c, ((g) obj).f717c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f717c;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f717c;
        if (obj instanceof f) {
            return ((f) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
