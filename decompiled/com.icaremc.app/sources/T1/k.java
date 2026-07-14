package T1;

/* loaded from: classes.dex */
public final class k extends h {

    /* renamed from: f, reason: collision with root package name */
    public final V1.o f1621f = new V1.o(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof k) || !((k) obj).f1621f.equals(this.f1621f)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final int hashCode() {
        return this.f1621f.hashCode();
    }
}
