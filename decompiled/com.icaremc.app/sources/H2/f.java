package H2;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class f implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Object f676f;

    public /* synthetic */ f(Object obj) {
        this.f676f = obj;
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof e) {
            return ((e) obj).f675f;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!T2.h.a(this.f676f, ((f) obj).f676f)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f676f;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f676f;
        if (obj instanceof e) {
            return ((e) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
