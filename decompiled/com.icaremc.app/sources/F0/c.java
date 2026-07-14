package F0;

import r2.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f525a;

    public c(String str) {
        if (str != null) {
            this.f525a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f525a.equals(((c) obj).f525a);
    }

    public final int hashCode() {
        return this.f525a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return k.c(new StringBuilder("Encoding{name=\""), this.f525a, "\"}");
    }
}
