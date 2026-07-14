package T2;

/* loaded from: classes.dex */
public final class j implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1641a;

    public j(Class cls) {
        this.f1641a = cls;
    }

    @Override // T2.d
    public final Class a() {
        return this.f1641a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            if (h.a(this.f1641a, ((j) obj).f1641a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f1641a.hashCode();
    }

    public final String toString() {
        return this.f1641a.toString() + " (Kotlin reflection is not available)";
    }
}
