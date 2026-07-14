package n1;

/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f3344a;

    public h(Throwable th) {
        this.f3344a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            if (kotlin.jvm.internal.h.a(this.f3344a, ((h) obj).f3344a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f3344a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // n1.i
    public final String toString() {
        return "Closed(" + this.f3344a + ')';
    }
}
