package u1;

/* renamed from: u1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0666a {

    /* renamed from: a, reason: collision with root package name */
    public final long f6208a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6209b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6210c;

    public C0666a(long j4, long j5, long j6) {
        this.f6208a = j4;
        this.f6209b = j5;
        this.f6210c = j6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0666a) {
            C0666a c0666a = (C0666a) obj;
            if (this.f6208a == c0666a.f6208a && this.f6209b == c0666a.f6209b && this.f6210c == c0666a.f6210c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f6208a;
        long j5 = this.f6209b;
        int i4 = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j6 = this.f6210c;
        return i4 ^ ((int) ((j6 >>> 32) ^ j6));
    }

    public final String toString() {
        return "StartupTime{epochMillis=" + this.f6208a + ", elapsedRealtime=" + this.f6209b + ", uptimeMillis=" + this.f6210c + "}";
    }
}
