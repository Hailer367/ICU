package androidx.lifecycle;

/* loaded from: classes.dex */
public interface a0 {
    default X a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default X b(Class cls, T.c cVar) {
        return a(cls);
    }
}
