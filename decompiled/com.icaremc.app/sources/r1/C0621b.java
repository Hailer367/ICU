package r1;

/* renamed from: r1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0621b implements InterfaceC0622c {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f6017h = new Object();

    /* renamed from: f, reason: collision with root package name */
    public volatile InterfaceC0622c f6018f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Object f6019g;

    /* JADX WARN: Type inference failed for: r0v1, types: [r1.c, r1.b, java.lang.Object] */
    public static InterfaceC0622c a(InterfaceC0622c interfaceC0622c) {
        if (interfaceC0622c instanceof C0621b) {
            return interfaceC0622c;
        }
        ?? obj = new Object();
        obj.f6019g = f6017h;
        obj.f6018f = interfaceC0622c;
        return obj;
    }

    @Override // r1.InterfaceC0622c
    public final Object n() {
        Object obj;
        Object obj2 = this.f6019g;
        Object obj3 = f6017h;
        if (obj2 == obj3) {
            synchronized (this) {
                try {
                    obj = this.f6019g;
                    if (obj == obj3) {
                        obj = this.f6018f.n();
                        Object obj4 = this.f6019g;
                        if (obj4 != obj3 && obj4 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f6019g = obj;
                        this.f6018f = null;
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
