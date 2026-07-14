package n;

/* renamed from: n.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0279a extends android.support.v4.media.session.a {

    /* renamed from: g, reason: collision with root package name */
    public static volatile C0279a f3286g;

    /* renamed from: f, reason: collision with root package name */
    public final C0281c f3287f = new C0281c();

    public static C0279a N() {
        if (f3286g != null) {
            return f3286g;
        }
        synchronized (C0279a.class) {
            try {
                if (f3286g == null) {
                    f3286g = new C0279a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f3286g;
    }
}
