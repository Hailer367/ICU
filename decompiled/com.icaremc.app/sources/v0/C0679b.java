package v0;

import w0.InterfaceC0695a;

/* renamed from: v0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0679b implements InterfaceC0685h {

    /* renamed from: h, reason: collision with root package name */
    public static final C0679b f6261h;

    /* renamed from: i, reason: collision with root package name */
    public static final C0679b f6262i;

    /* renamed from: j, reason: collision with root package name */
    public static final C0679b f6263j;
    public static final C0679b k;

    /* renamed from: l, reason: collision with root package name */
    public static final C0679b f6264l;

    /* renamed from: m, reason: collision with root package name */
    public static final C0679b f6265m;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6266f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f6267g;

    static {
        int i4 = 0;
        f6261h = new C0679b("NONE", i4);
        f6262i = new C0679b("FULL", i4);
        int i5 = 1;
        f6263j = new C0679b("FLAT", i5);
        k = new C0679b("HALF_OPENED", i5);
        int i6 = 2;
        f6264l = new C0679b("FOLD", i6);
        f6265m = new C0679b("HINGE", i6);
    }

    public /* synthetic */ C0679b(String str, int i4) {
        this.f6266f = i4;
        this.f6267g = str;
    }

    public String toString() {
        switch (this.f6266f) {
            case 0:
                return (String) this.f6267g;
            case 1:
                return (String) this.f6267g;
            case 2:
                return (String) this.f6267g;
            default:
                return super.toString();
        }
    }

    public C0679b(InterfaceC0695a interfaceC0695a) {
        this.f6266f = 3;
        int i4 = C0690m.f6288b;
        this.f6267g = interfaceC0695a;
    }
}
