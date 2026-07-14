package B0;

import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f80a;

    /* renamed from: b, reason: collision with root package name */
    public final long f81b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f82c;

    public c(long j2, long j3, Set set) {
        this.f80a = j2;
        this.f81b = j3;
        this.f82c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f80a == cVar.f80a && this.f81b == cVar.f81b && this.f82c.equals(cVar.f82c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f80a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        long j3 = this.f81b;
        return ((i2 ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f82c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f80a + ", maxAllowedDelay=" + this.f81b + ", flags=" + this.f82c + "}";
    }
}
