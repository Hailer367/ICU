package O0;

import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f1266a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1267b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f1268c;

    public c(long j4, long j5, Set set) {
        this.f1266a = j4;
        this.f1267b = j5;
        this.f1268c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f1266a == cVar.f1266a && this.f1267b == cVar.f1267b && this.f1268c.equals(cVar.f1268c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f1266a;
        int i4 = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        long j5 = this.f1267b;
        return ((i4 ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003) ^ this.f1268c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f1266a + ", maxAllowedDelay=" + this.f1267b + ", flags=" + this.f1268c + "}";
    }
}
