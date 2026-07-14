package L1;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f1000a;

    /* renamed from: b, reason: collision with root package name */
    public int f1001b;

    /* renamed from: c, reason: collision with root package name */
    public String f1002c;

    /* renamed from: d, reason: collision with root package name */
    public String f1003d;

    /* renamed from: e, reason: collision with root package name */
    public long f1004e;

    /* renamed from: f, reason: collision with root package name */
    public long f1005f;

    /* renamed from: g, reason: collision with root package name */
    public String f1006g;

    /* renamed from: h, reason: collision with root package name */
    public byte f1007h;

    public final b a() {
        if (this.f1007h == 3 && this.f1001b != 0) {
            return new b(this.f1000a, this.f1001b, this.f1002c, this.f1003d, this.f1004e, this.f1005f, this.f1006g);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f1001b == 0) {
            sb.append(" registrationStatus");
        }
        if ((this.f1007h & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((this.f1007h & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb));
    }
}
