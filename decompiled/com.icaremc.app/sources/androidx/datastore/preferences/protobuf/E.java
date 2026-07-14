package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class E implements L {

    /* renamed from: a, reason: collision with root package name */
    public L[] f2561a;

    @Override // androidx.datastore.preferences.protobuf.L
    public final V a(Class cls) {
        for (L l3 : this.f2561a) {
            if (l3.b(cls)) {
                return l3.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final boolean b(Class cls) {
        for (L l3 : this.f2561a) {
            if (l3.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
