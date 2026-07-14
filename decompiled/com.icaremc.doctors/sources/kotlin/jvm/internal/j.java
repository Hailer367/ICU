package kotlin.jvm.internal;

/* loaded from: classes.dex */
public final class j implements c {

    /* renamed from: c, reason: collision with root package name */
    public final Class f2786c;

    public j(Class jClass) {
        h.e(jClass, "jClass");
        this.f2786c = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public final Class a() {
        return this.f2786c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            if (h.a(this.f2786c, ((j) obj).f2786c)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f2786c.hashCode();
    }

    public final String toString() {
        return this.f2786c.toString() + " (Kotlin reflection is not available)";
    }
}
