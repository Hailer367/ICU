package Q0;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class h implements c, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public c1.a f718c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Object f719d = i.f721a;

    /* renamed from: e, reason: collision with root package name */
    public final Object f720e = this;

    public h(c1.a aVar) {
        this.f718c = aVar;
    }

    public final Object a() {
        Object obj;
        Object obj2 = this.f719d;
        i iVar = i.f721a;
        if (obj2 != iVar) {
            return obj2;
        }
        synchronized (this.f720e) {
            obj = this.f719d;
            if (obj == iVar) {
                c1.a aVar = this.f718c;
                kotlin.jvm.internal.h.b(aVar);
                obj = aVar.invoke();
                this.f719d = obj;
                this.f718c = null;
            }
        }
        return obj;
    }

    public final String toString() {
        if (this.f719d != i.f721a) {
            return String.valueOf(a());
        }
        return "Lazy value not initialized yet.";
    }
}
