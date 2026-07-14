package O;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f632a;

    public e(String name) {
        kotlin.jvm.internal.h.e(name, "name");
        this.f632a = name;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return kotlin.jvm.internal.h.a(this.f632a, ((e) obj).f632a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f632a.hashCode();
    }

    public final String toString() {
        return this.f632a;
    }
}
