package l1;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f2986a = new ThreadLocal();

    public static H a() {
        ThreadLocal threadLocal = f2986a;
        H h2 = (H) threadLocal.get();
        if (h2 == null) {
            C0226d c0226d = new C0226d(Thread.currentThread());
            threadLocal.set(c0226d);
            return c0226d;
        }
        return h2;
    }
}
