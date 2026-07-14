package m;

/* loaded from: classes.dex */
public final class P {

    /* renamed from: a, reason: collision with root package name */
    public int f3096a;

    /* renamed from: b, reason: collision with root package name */
    public int f3097b;

    /* renamed from: c, reason: collision with root package name */
    public int f3098c;

    /* renamed from: d, reason: collision with root package name */
    public int f3099d;

    /* renamed from: e, reason: collision with root package name */
    public int f3100e;

    /* renamed from: f, reason: collision with root package name */
    public int f3101f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3102g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3103h;

    public final void a(int i2, int i3) {
        this.f3098c = i2;
        this.f3099d = i3;
        this.f3103h = true;
        if (this.f3102g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f3096a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f3097b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f3096a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f3097b = i3;
        }
    }
}
