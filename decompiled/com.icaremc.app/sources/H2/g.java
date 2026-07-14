package H2;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class g implements c, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public S2.a f677f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Object f678g = h.f680a;

    /* renamed from: h, reason: collision with root package name */
    public final Object f679h = this;

    public g(S2.a aVar) {
        this.f677f = aVar;
    }

    public final Object a() {
        Object obj;
        Object obj2 = this.f678g;
        h hVar = h.f680a;
        if (obj2 != hVar) {
            return obj2;
        }
        synchronized (this.f679h) {
            obj = this.f678g;
            if (obj == hVar) {
                S2.a aVar = this.f677f;
                T2.h.b(aVar);
                obj = aVar.a();
                this.f678g = obj;
                this.f677f = null;
            }
        }
        return obj;
    }

    public final String toString() {
        if (this.f678g != h.f680a) {
            return String.valueOf(a());
        }
        return "Lazy value not initialized yet.";
    }
}
