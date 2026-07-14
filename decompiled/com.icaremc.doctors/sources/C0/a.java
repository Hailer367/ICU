package C0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f138f = new a(10485760, 200, 10000, 604800000, 81920);

    /* renamed from: a, reason: collision with root package name */
    public final long f139a;

    /* renamed from: b, reason: collision with root package name */
    public final int f140b;

    /* renamed from: c, reason: collision with root package name */
    public final int f141c;

    /* renamed from: d, reason: collision with root package name */
    public final long f142d;

    /* renamed from: e, reason: collision with root package name */
    public final int f143e;

    public a(long j2, int i2, int i3, long j3, int i4) {
        this.f139a = j2;
        this.f140b = i2;
        this.f141c = i3;
        this.f142d = j3;
        this.f143e = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f139a == aVar.f139a && this.f140b == aVar.f140b && this.f141c == aVar.f141c && this.f142d == aVar.f142d && this.f143e == aVar.f143e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f139a;
        int i2 = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f140b) * 1000003) ^ this.f141c) * 1000003;
        long j3 = this.f142d;
        return ((i2 ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f143e;
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f139a + ", loadBatchSize=" + this.f140b + ", criticalSectionEnterTimeoutMs=" + this.f141c + ", eventCleanUpAge=" + this.f142d + ", maxBlobByteSizePerRow=" + this.f143e + "}";
    }
}
