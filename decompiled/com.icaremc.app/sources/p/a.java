package p;

/* loaded from: classes.dex */
public final class a extends k3.b {

    /* renamed from: n, reason: collision with root package name */
    public static volatile a f5793n;

    /* renamed from: m, reason: collision with root package name */
    public final c f5794m = new c();

    public static a D() {
        if (f5793n != null) {
            return f5793n;
        }
        synchronized (a.class) {
            try {
                if (f5793n == null) {
                    f5793n = new a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f5793n;
    }
}
