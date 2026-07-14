package H0;

/* loaded from: classes.dex */
public final class j extends q {

    /* renamed from: a, reason: collision with root package name */
    public final h f621a;

    public j(h hVar) {
        this.f621a = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof q) {
                q qVar = (q) obj;
                ((j) qVar).getClass();
                Object obj2 = p.f638f;
                if (obj2.equals(obj2)) {
                    if (this.f621a.equals(((j) qVar).f621a)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((p.f638f.hashCode() ^ 1000003) * 1000003) ^ this.f621a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + p.f638f + ", androidClientInfo=" + this.f621a + "}";
    }
}
