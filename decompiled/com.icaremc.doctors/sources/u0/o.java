package u0;

/* loaded from: classes.dex */
public final class o extends w {

    /* renamed from: a, reason: collision with root package name */
    public final v f3874a;

    /* renamed from: b, reason: collision with root package name */
    public final u f3875b;

    public o(v vVar, u uVar) {
        this.f3874a = vVar;
        this.f3875b = uVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            v vVar = this.f3874a;
            if (vVar != null ? vVar.equals(((o) wVar).f3874a) : ((o) wVar).f3874a == null) {
                u uVar = this.f3875b;
                if (uVar != null ? uVar.equals(((o) wVar).f3875b) : ((o) wVar).f3875b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i2 = 0;
        v vVar = this.f3874a;
        if (vVar == null) {
            hashCode = 0;
        } else {
            hashCode = vVar.hashCode();
        }
        int i3 = (hashCode ^ 1000003) * 1000003;
        u uVar = this.f3875b;
        if (uVar != null) {
            i2 = uVar.hashCode();
        }
        return i2 ^ i3;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f3874a + ", mobileSubtype=" + this.f3875b + "}";
    }
}
