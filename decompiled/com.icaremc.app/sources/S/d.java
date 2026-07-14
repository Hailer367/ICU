package S;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1538a;

    public d(String str) {
        T2.h.e(str, "name");
        this.f1538a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return T2.h.a(this.f1538a, ((d) obj).f1538a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1538a.hashCode();
    }

    public final String toString() {
        return this.f1538a;
    }
}
