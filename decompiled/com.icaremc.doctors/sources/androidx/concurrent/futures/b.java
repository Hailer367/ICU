package androidx.concurrent.futures;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f1260c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f1261d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1262a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f1263b;

    static {
        if (j.GENERATE_CANCELLATION_CAUSES) {
            f1261d = null;
            f1260c = null;
        } else {
            f1261d = new b(null, false);
            f1260c = new b(null, true);
        }
    }

    public b(Throwable th, boolean z) {
        this.f1262a = z;
        this.f1263b = th;
    }
}
