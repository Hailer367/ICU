package H2;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Throwable f675f;

    public e(Throwable th) {
        T2.h.e(th, "exception");
        this.f675f = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            if (T2.h.a(this.f675f, ((e) obj).f675f)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f675f.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f675f + ')';
    }
}
