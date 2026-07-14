package H0;

/* loaded from: classes.dex */
public final class n extends v {

    /* renamed from: a, reason: collision with root package name */
    public final u f636a;

    /* renamed from: b, reason: collision with root package name */
    public final t f637b;

    public n(u uVar, t tVar) {
        this.f636a = uVar;
        this.f637b = tVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            u uVar = this.f636a;
            if (uVar != null ? uVar.equals(((n) vVar).f636a) : ((n) vVar).f636a == null) {
                t tVar = this.f637b;
                if (tVar != null ? tVar.equals(((n) vVar).f637b) : ((n) vVar).f637b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i4 = 0;
        u uVar = this.f636a;
        if (uVar == null) {
            hashCode = 0;
        } else {
            hashCode = uVar.hashCode();
        }
        int i5 = (hashCode ^ 1000003) * 1000003;
        t tVar = this.f637b;
        if (tVar != null) {
            i4 = tVar.hashCode();
        }
        return i4 ^ i5;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f636a + ", mobileSubtype=" + this.f637b + "}";
    }
}
