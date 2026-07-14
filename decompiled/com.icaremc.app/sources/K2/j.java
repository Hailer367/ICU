package K2;

import S2.p;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class j implements i, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final j f942f = new Object();

    @Override // K2.i
    public final i c(h hVar) {
        T2.h.e(hVar, "key");
        return this;
    }

    @Override // K2.i
    public final g e(h hVar) {
        T2.h.e(hVar, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // K2.i
    public final i j(i iVar) {
        T2.h.e(iVar, "context");
        return iVar;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // K2.i
    public final Object k(Object obj, p pVar) {
        return obj;
    }
}
