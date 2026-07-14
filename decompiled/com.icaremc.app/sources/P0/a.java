package P0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f1315f = new a(10485760, 200, 10000, 604800000, 81920);

    /* renamed from: a, reason: collision with root package name */
    public final long f1316a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1317b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1318c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1319d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1320e;

    public a(long j4, int i4, int i5, long j5, int i6) {
        this.f1316a = j4;
        this.f1317b = i4;
        this.f1318c = i5;
        this.f1319d = j5;
        this.f1320e = i6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f1316a == aVar.f1316a && this.f1317b == aVar.f1317b && this.f1318c == aVar.f1318c && this.f1319d == aVar.f1319d && this.f1320e == aVar.f1320e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f1316a;
        int i4 = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f1317b) * 1000003) ^ this.f1318c) * 1000003;
        long j5 = this.f1319d;
        return ((i4 ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003) ^ this.f1320e;
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f1316a + ", loadBatchSize=" + this.f1317b + ", criticalSectionEnterTimeoutMs=" + this.f1318c + ", eventCleanUpAge=" + this.f1319d + ", maxBlobByteSizePerRow=" + this.f1320e + "}";
    }
}
