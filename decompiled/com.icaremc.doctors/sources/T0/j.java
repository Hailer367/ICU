package T0;

import c1.p;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class j implements i, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final j f774c = new Object();

    @Override // T0.i
    public final i d(i context) {
        kotlin.jvm.internal.h.e(context, "context");
        return context;
    }

    @Override // T0.i
    public final i g(h key) {
        kotlin.jvm.internal.h.e(key, "key");
        return this;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // T0.i
    public final g k(h key) {
        kotlin.jvm.internal.h.e(key, "key");
        return null;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // T0.i
    public final Object c(Object obj, p pVar) {
        return obj;
    }
}
