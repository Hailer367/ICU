package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0092t implements L {

    /* renamed from: b, reason: collision with root package name */
    public static final C0092t f1490b = new C0092t(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1491a;

    public /* synthetic */ C0092t(int i2) {
        this.f1491a = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final V a(Class cls) {
        switch (this.f1491a) {
            case 0:
                if (AbstractC0095w.class.isAssignableFrom(cls)) {
                    try {
                        return (V) AbstractC0095w.d(cls.asSubclass(AbstractC0095w.class)).c(3);
                    } catch (Exception e2) {
                        throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
                    }
                }
                throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final boolean b(Class cls) {
        switch (this.f1491a) {
            case 0:
                return AbstractC0095w.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
