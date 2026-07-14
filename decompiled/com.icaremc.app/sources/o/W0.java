package o;

/* loaded from: classes.dex */
public final class W0 {

    /* renamed from: a, reason: collision with root package name */
    public int f5538a;

    /* renamed from: b, reason: collision with root package name */
    public int f5539b;

    /* renamed from: c, reason: collision with root package name */
    public int f5540c;

    /* renamed from: d, reason: collision with root package name */
    public int f5541d;

    /* renamed from: e, reason: collision with root package name */
    public int f5542e;

    /* renamed from: f, reason: collision with root package name */
    public int f5543f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5544g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5545h;

    public final void a(int i4, int i5) {
        this.f5540c = i4;
        this.f5541d = i5;
        this.f5545h = true;
        if (this.f5544g) {
            if (i5 != Integer.MIN_VALUE) {
                this.f5538a = i5;
            }
            if (i4 != Integer.MIN_VALUE) {
                this.f5539b = i4;
                return;
            }
            return;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f5538a = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f5539b = i5;
        }
    }
}
