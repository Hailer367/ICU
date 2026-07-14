package H;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f277a;

    /* renamed from: b, reason: collision with root package name */
    public int f278b;

    /* renamed from: c, reason: collision with root package name */
    public float f279c;

    /* renamed from: d, reason: collision with root package name */
    public float f280d;

    /* renamed from: e, reason: collision with root package name */
    public long f281e;

    /* renamed from: f, reason: collision with root package name */
    public long f282f;

    /* renamed from: g, reason: collision with root package name */
    public long f283g;

    /* renamed from: h, reason: collision with root package name */
    public float f284h;

    /* renamed from: i, reason: collision with root package name */
    public int f285i;

    public final float a(long j2) {
        long j3 = this.f281e;
        if (j2 < j3) {
            return 0.0f;
        }
        long j4 = this.f283g;
        if (j4 >= 0 && j2 >= j4) {
            float f2 = this.f284h;
            return (d.b(((float) (j2 - j4)) / this.f285i, 0.0f, 1.0f) * f2) + (1.0f - f2);
        }
        return d.b(((float) (j2 - j3)) / this.f277a, 0.0f, 1.0f) * 0.5f;
    }
}
