package u0;

/* loaded from: classes.dex */
public final class k extends r {

    /* renamed from: a, reason: collision with root package name */
    public final i f3859a;

    public k(i iVar) {
        this.f3859a = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof r) {
                r rVar = (r) obj;
                ((k) rVar).getClass();
                Object obj2 = q.f3876c;
                if (obj2.equals(obj2)) {
                    if (this.f3859a.equals(((k) rVar).f3859a)) {
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
        return ((q.f3876c.hashCode() ^ 1000003) * 1000003) ^ this.f3859a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + q.f3876c + ", androidClientInfo=" + this.f3859a + "}";
    }
}
