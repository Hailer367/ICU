package B0;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final A0.f f78a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f79b;

    public b(A0.f fVar, HashMap hashMap) {
        this.f78a = fVar;
        this.f79b = hashMap;
    }

    public final long a(s0.d dVar, long j2, int i2) {
        long j3;
        long j4 = j2 - this.f78a.j();
        c cVar = (c) this.f79b.get(dVar);
        long j5 = cVar.f80a;
        int i3 = i2 - 1;
        if (j5 > 1) {
            j3 = j5;
        } else {
            j3 = 2;
        }
        return Math.min(Math.max((long) (Math.pow(3.0d, i3) * j5 * Math.max(1.0d, Math.log(10000.0d) / Math.log(j3 * i3))), j4), cVar.f81b);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f78a.equals(bVar.f78a) && this.f79b.equals(bVar.f79b)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f78a.hashCode() ^ 1000003) * 1000003) ^ this.f79b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f78a + ", values=" + this.f79b + "}";
    }
}
