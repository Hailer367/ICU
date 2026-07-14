package K0;

/* loaded from: classes.dex */
public final class a implements G2.a {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f906h = new Object();

    /* renamed from: f, reason: collision with root package name */
    public volatile b f907f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Object f908g;

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K0.a, G2.a] */
    public static G2.a a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        ?? obj = new Object();
        obj.f908g = f906h;
        obj.f907f = bVar;
        return obj;
    }

    @Override // G2.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f908g;
        Object obj3 = f906h;
        if (obj2 == obj3) {
            synchronized (this) {
                try {
                    obj = this.f908g;
                    if (obj == obj3) {
                        obj = this.f907f.get();
                        Object obj4 = this.f908g;
                        if (obj4 != obj3 && obj4 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f908g = obj;
                        this.f907f = null;
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
