package androidx.lifecycle;

/* loaded from: classes.dex */
public interface V {
    default S a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default S b(Class cls, a0.c cVar) {
        return a(cls);
    }
}
