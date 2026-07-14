package l0;

/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: d, reason: collision with root package name */
    public static final b f2917d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f2918e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f2919f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f2920g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f2921h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f2922i;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2923b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2924c;

    static {
        int i2 = 0;
        f2917d = new b("NONE", i2);
        f2918e = new b("FULL", i2);
        int i3 = 1;
        f2919f = new b("FLAT", i3);
        f2920g = new b("HALF_OPENED", i3);
        int i4 = 2;
        f2921h = new b("FOLD", i4);
        f2922i = new b("HINGE", i4);
    }

    public /* synthetic */ b(String str, int i2) {
        this.f2923b = i2;
        this.f2924c = str;
    }

    public String toString() {
        switch (this.f2923b) {
            case 0:
                return (String) this.f2924c;
            case 1:
                return (String) this.f2924c;
            case 2:
                return (String) this.f2924c;
            default:
                return super.toString();
        }
    }

    public b(m0.a aVar) {
        this.f2923b = 3;
        int i2 = n.f2947b;
        this.f2924c = aVar;
    }
}
