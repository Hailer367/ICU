package X2;

/* loaded from: classes.dex */
public final class c extends a {
    static {
        new a(1, 0, 1);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f2003f == cVar.f2003f && this.f2004g == cVar.f2004g) {
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
        return (this.f2003f * 31) + this.f2004g;
    }

    public final boolean isEmpty() {
        if (this.f2003f > this.f2004g) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.f2003f + ".." + this.f2004g;
    }
}
