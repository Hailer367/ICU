package L;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f943a;

    /* renamed from: b, reason: collision with root package name */
    public int f944b;

    /* renamed from: c, reason: collision with root package name */
    public float f945c;

    /* renamed from: d, reason: collision with root package name */
    public float f946d;

    /* renamed from: e, reason: collision with root package name */
    public long f947e;

    /* renamed from: f, reason: collision with root package name */
    public long f948f;

    /* renamed from: g, reason: collision with root package name */
    public long f949g;

    /* renamed from: h, reason: collision with root package name */
    public float f950h;

    /* renamed from: i, reason: collision with root package name */
    public int f951i;

    public final float a(long j4) {
        long j5 = this.f947e;
        if (j4 < j5) {
            return 0.0f;
        }
        long j6 = this.f949g;
        if (j6 >= 0 && j4 >= j6) {
            float f4 = this.f950h;
            return (c.b(((float) (j4 - j6)) / this.f951i, 0.0f, 1.0f) * f4) + (1.0f - f4);
        }
        return c.b(((float) (j4 - j5)) / this.f943a, 0.0f, 1.0f) * 0.5f;
    }
}
