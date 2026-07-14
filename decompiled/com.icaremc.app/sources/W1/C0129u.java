package W1;

import a2.C0143a;
import b2.C0223a;
import b2.C0224b;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: W1.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0129u extends T1.s {

    /* renamed from: c, reason: collision with root package name */
    public static final C0127s f1967c = new C0127s(1, T1.q.f1623f);

    /* renamed from: a, reason: collision with root package name */
    public final T1.e f1968a;

    /* renamed from: b, reason: collision with root package name */
    public final T1.q f1969b;

    public C0129u(T1.e eVar, T1.q qVar) {
        this.f1968a = eVar;
        this.f1969b = qVar;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        Object arrayList;
        String str;
        Serializable arrayList2;
        boolean z;
        int x3 = c0223a.x();
        int b4 = R.i.b(x3);
        if (b4 != 0) {
            if (b4 != 2) {
                arrayList = null;
            } else {
                c0223a.b();
                arrayList = new V1.o(true);
            }
        } else {
            c0223a.a();
            arrayList = new ArrayList();
        }
        if (arrayList == null) {
            return d(c0223a, x3);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (c0223a.k()) {
                if (arrayList instanceof Map) {
                    str = c0223a.r();
                } else {
                    str = null;
                }
                int x4 = c0223a.x();
                int b5 = R.i.b(x4);
                if (b5 != 0) {
                    if (b5 != 2) {
                        arrayList2 = null;
                    } else {
                        c0223a.b();
                        arrayList2 = new V1.o(true);
                    }
                } else {
                    c0223a.a();
                    arrayList2 = new ArrayList();
                }
                if (arrayList2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (arrayList2 == null) {
                    arrayList2 = d(c0223a, x4);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(str, arrayList2);
                }
                if (z) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    c0223a.e();
                } else {
                    c0223a.f();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        if (obj == null) {
            c0224b.i();
            return;
        }
        Class<?> cls = obj.getClass();
        T1.e eVar = this.f1968a;
        eVar.getClass();
        T1.s c4 = eVar.c(new C0143a(cls));
        if (c4 instanceof C0129u) {
            c0224b.c();
            c0224b.f();
        } else {
            c4.c(c0224b, obj);
        }
    }

    public final Serializable d(C0223a c0223a, int i4) {
        int b4 = R.i.b(i4);
        if (b4 != 5) {
            if (b4 != 6) {
                if (b4 != 7) {
                    if (b4 == 8) {
                        c0223a.t();
                        return null;
                    }
                    throw new IllegalStateException("Unexpected token: ".concat(A2.i.s(i4)));
                }
                return Boolean.valueOf(c0223a.n());
            }
            return this.f1969b.a(c0223a);
        }
        return c0223a.v();
    }
}
