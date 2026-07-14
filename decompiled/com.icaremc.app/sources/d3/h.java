package d3;

/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f3530a;

    public h(Throwable th) {
        this.f3530a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            if (T2.h.a(this.f3530a, ((h) obj).f3530a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f3530a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // d3.i
    public final String toString() {
        return "Closed(" + this.f3530a + ')';
    }
}
