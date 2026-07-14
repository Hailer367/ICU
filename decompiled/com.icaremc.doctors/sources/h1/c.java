package h1;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: f, reason: collision with root package name */
    public static final c f2328f = new a(1, 0, 1);

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f2321c == cVar.f2321c && this.f2322d == cVar.f2322d) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f2321c * 31) + this.f2322d;
    }

    public final boolean isEmpty() {
        if (this.f2321c > this.f2322d) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.f2321c + ".." + this.f2322d;
    }
}
