package W1;

import b2.C0223a;
import b2.C0224b;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: W1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0112c extends T1.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1905a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1906b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1907c;

    public C0112c(T1.e eVar, Type type, T1.s sVar, V1.p pVar) {
        this.f1906b = new r(eVar, sVar, type);
        this.f1907c = pVar;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        switch (this.f1905a) {
            case 0:
                if (c0223a.x() == 9) {
                    c0223a.t();
                    return null;
                }
                Collection collection = (Collection) ((V1.p) this.f1907c).g();
                c0223a.a();
                while (c0223a.k()) {
                    collection.add(((T1.s) ((r) this.f1906b).f1961c).b(c0223a));
                }
                c0223a.e();
                return collection;
            default:
                Class cls = (Class) this.f1906b;
                Object b4 = ((Y) this.f1907c).f1898h.b(c0223a);
                if (b4 != null && !cls.isInstance(b4)) {
                    throw new RuntimeException("Expected a " + cls.getName() + " but was " + b4.getClass().getName() + "; at path " + c0223a.j());
                }
                return b4;
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        switch (this.f1905a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection == null) {
                    c0224b.i();
                    return;
                }
                c0224b.b();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    ((r) this.f1906b).c(c0224b, it.next());
                }
                c0224b.e();
                return;
            default:
                ((Y) this.f1907c).f1898h.c(c0224b, obj);
                return;
        }
    }

    public C0112c(Y y3, Class cls) {
        this.f1907c = y3;
        this.f1906b = cls;
    }
}
