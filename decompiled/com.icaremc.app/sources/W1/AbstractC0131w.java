package W1;

import b2.C0223a;
import b2.C0224b;
import f1.AbstractC0286a;
import java.util.Iterator;
import java.util.Map;

/* renamed from: W1.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0131w extends T1.s {

    /* renamed from: a, reason: collision with root package name */
    public final C0133y f1978a;

    public AbstractC0131w(C0133y c0133y) {
        this.f1978a = c0133y;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        Object d4 = d();
        Map map = this.f1978a.f1981a;
        try {
            c0223a.b();
            while (c0223a.k()) {
                C0130v c0130v = (C0130v) map.get(c0223a.r());
                if (c0130v == null) {
                    c0223a.D();
                } else {
                    f(d4, c0223a, c0130v);
                }
            }
            c0223a.f();
            return e(d4);
        } catch (IllegalAccessException e4) {
            AbstractC0286a abstractC0286a = Y1.c.f2084a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.12.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e4);
        } catch (IllegalStateException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        if (obj == null) {
            c0224b.i();
            return;
        }
        c0224b.c();
        try {
            Iterator it = this.f1978a.f1982b.iterator();
            while (it.hasNext()) {
                ((C0130v) it.next()).a(c0224b, obj);
            }
            c0224b.f();
        } catch (IllegalAccessException e4) {
            AbstractC0286a abstractC0286a = Y1.c.f2084a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.12.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e4);
        }
    }

    public abstract Object d();

    public abstract Object e(Object obj);

    public abstract void f(Object obj, C0223a c0223a, C0130v c0130v);
}
