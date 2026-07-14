package x0;

/* renamed from: x0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0344a implements P0.a {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f3981e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public volatile b f3982c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Object f3983d;

    /* JADX WARN: Type inference failed for: r0v1, types: [P0.a, java.lang.Object, x0.a] */
    public static P0.a a(b bVar) {
        if (bVar instanceof C0344a) {
            return bVar;
        }
        ?? obj = new Object();
        obj.f3983d = f3981e;
        obj.f3982c = bVar;
        return obj;
    }

    @Override // P0.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f3983d;
        Object obj3 = f3981e;
        if (obj2 == obj3) {
            synchronized (this) {
                try {
                    obj = this.f3983d;
                    if (obj == obj3) {
                        obj = this.f3982c.get();
                        Object obj4 = this.f3983d;
                        if (obj4 != obj3 && obj4 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f3983d = obj;
                        this.f3982c = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return obj;
        }
        return obj2;
    }
}
