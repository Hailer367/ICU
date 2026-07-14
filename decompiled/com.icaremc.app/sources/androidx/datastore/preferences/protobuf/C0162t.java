package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0162t implements L {

    /* renamed from: b, reason: collision with root package name */
    public static final C0162t f2705b = new C0162t(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2706a;

    public /* synthetic */ C0162t(int i4) {
        this.f2706a = i4;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final V a(Class cls) {
        switch (this.f2706a) {
            case 0:
                if (AbstractC0165w.class.isAssignableFrom(cls)) {
                    try {
                        return (V) AbstractC0165w.d(cls.asSubclass(AbstractC0165w.class)).c(3);
                    } catch (Exception e4) {
                        throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e4);
                    }
                }
                throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final boolean b(Class cls) {
        switch (this.f2706a) {
            case 0:
                return AbstractC0165w.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
