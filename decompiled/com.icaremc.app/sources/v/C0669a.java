package v;

/* renamed from: v.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0669a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0669a f6238c;

    /* renamed from: d, reason: collision with root package name */
    public static final C0669a f6239d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6240a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f6241b;

    static {
        if (AbstractFutureC0676h.f6253i) {
            f6239d = null;
            f6238c = null;
        } else {
            f6239d = new C0669a(null, false);
            f6238c = new C0669a(null, true);
        }
    }

    public C0669a(Throwable th, boolean z) {
        this.f6240a = z;
        this.f6241b = th;
    }
}
