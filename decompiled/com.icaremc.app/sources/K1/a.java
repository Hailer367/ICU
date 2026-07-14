package K1;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f909a;

    /* renamed from: b, reason: collision with root package name */
    public final long f910b;

    /* renamed from: c, reason: collision with root package name */
    public final long f911c;

    public a(String str, long j4, long j5) {
        this.f909a = str;
        this.f910b = j4;
        this.f911c = j5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f909a.equals(aVar.f909a) && this.f910b == aVar.f910b && this.f911c == aVar.f911c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f909a.hashCode() ^ 1000003) * 1000003;
        long j4 = this.f910b;
        long j5 = this.f911c;
        return ((hashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        return "InstallationTokenResult{token=" + this.f909a + ", tokenExpirationTimestamp=" + this.f910b + ", tokenCreationTimestamp=" + this.f911c + "}";
    }
}
