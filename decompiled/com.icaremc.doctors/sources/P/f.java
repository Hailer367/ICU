package P;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final long f655a;

    /* renamed from: b, reason: collision with root package name */
    public final long f656b;

    public f(long j2, long j3) {
        if (j3 == 0) {
            this.f655a = 0L;
            this.f656b = 1L;
        } else {
            this.f655a = j2;
            this.f656b = j3;
        }
    }

    public final String toString() {
        return this.f655a + "/" + this.f656b;
    }
}
