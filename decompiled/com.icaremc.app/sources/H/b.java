package H;

import p0.s;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f571a;

    /* renamed from: b, reason: collision with root package name */
    public final s f572b;

    public b(String str, s sVar) {
        this.f571a = str;
        this.f572b = sVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.f571a.equals(this.f571a) && bVar.f572b.equals(this.f572b)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f571a.hashCode() ^ this.f572b.hashCode();
    }

    public final String toString() {
        return "Pair{" + ((Object) this.f571a) + " " + this.f572b + "}";
    }
}
