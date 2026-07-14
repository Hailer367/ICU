package x1;

/* loaded from: classes.dex */
public final class k implements J1.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f6481c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f6482a = f6481c;

    /* renamed from: b, reason: collision with root package name */
    public volatile J1.a f6483b;

    public k(J1.a aVar) {
        this.f6483b = aVar;
    }

    @Override // J1.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f6482a;
        Object obj3 = f6481c;
        if (obj2 == obj3) {
            synchronized (this) {
                try {
                    obj = this.f6482a;
                    if (obj == obj3) {
                        obj = this.f6483b.get();
                        this.f6482a = obj;
                        this.f6483b = null;
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
