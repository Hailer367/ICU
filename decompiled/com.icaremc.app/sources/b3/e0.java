package b3;

/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f3270a = new ThreadLocal();

    public static G a() {
        ThreadLocal threadLocal = f3270a;
        G g4 = (G) threadLocal.get();
        if (g4 == null) {
            C0229d c0229d = new C0229d(Thread.currentThread());
            threadLocal.set(c0229d);
            return c0229d;
        }
        return g4;
    }
}
