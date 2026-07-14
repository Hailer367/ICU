package O0;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final R0.a f1264a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1265b;

    public b(R0.a aVar, HashMap hashMap) {
        this.f1264a = aVar;
        this.f1265b = hashMap;
    }

    public final long a(F0.d dVar, long j4, int i4) {
        long j5;
        long a4 = j4 - this.f1264a.a();
        c cVar = (c) this.f1265b.get(dVar);
        long j6 = cVar.f1266a;
        int i5 = i4 - 1;
        if (j6 > 1) {
            j5 = j6;
        } else {
            j5 = 2;
        }
        return Math.min(Math.max((long) (Math.pow(3.0d, i5) * j6 * Math.max(1.0d, Math.log(10000.0d) / Math.log(j5 * i5))), a4), cVar.f1267b);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f1264a.equals(bVar.f1264a) && this.f1265b.equals(bVar.f1265b)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f1264a.hashCode() ^ 1000003) * 1000003) ^ this.f1265b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f1264a + ", values=" + this.f1265b + "}";
    }
}
