package x1;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final o f6473a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6474b;

    public f(o oVar, boolean z) {
        this.f6473a = oVar;
        this.f6474b = z;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.f6473a.equals(this.f6473a) && fVar.f6474b == this.f6474b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f6473a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f6474b).hashCode();
    }
}
