package s0;

/* renamed from: s0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0301c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3584a;

    public C0301c(String str) {
        if (str != null) {
            this.f3584a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0301c)) {
            return false;
        }
        return this.f3584a.equals(((C0301c) obj).f3584a);
    }

    public final int hashCode() {
        return this.f3584a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return O.a.i(new StringBuilder("Encoding{name=\""), this.f3584a, "\"}");
    }
}
