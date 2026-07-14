package W1;

import b2.C0223a;
import b2.C0224b;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: W1.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0122m extends T1.s {

    /* renamed from: a, reason: collision with root package name */
    public static final C0122m f1948a = new C0122m();

    private C0122m() {
    }

    public static T1.h d(C0223a c0223a, int i4) {
        int b4 = R.i.b(i4);
        if (b4 != 5) {
            if (b4 != 6) {
                if (b4 != 7) {
                    if (b4 == 8) {
                        c0223a.t();
                        return T1.j.f1620f;
                    }
                    throw new IllegalStateException("Unexpected token: ".concat(A2.i.s(i4)));
                }
                return new T1.l(Boolean.valueOf(c0223a.n()));
            }
            return new T1.l(new V1.j(c0223a.v()));
        }
        return new T1.l(c0223a.v());
    }

    public static void e(C0224b c0224b, T1.h hVar) {
        if (hVar != null && !(hVar instanceof T1.j)) {
            boolean z = hVar instanceof T1.l;
            if (z) {
                if (z) {
                    T1.l lVar = (T1.l) hVar;
                    Serializable serializable = lVar.f1622f;
                    if (serializable instanceof Number) {
                        c0224b.q(lVar.f());
                        return;
                    } else if (serializable instanceof Boolean) {
                        c0224b.s(lVar.a());
                        return;
                    } else {
                        c0224b.r(lVar.c());
                        return;
                    }
                }
                throw new IllegalStateException("Not a JSON Primitive: " + hVar);
            }
            boolean z3 = hVar instanceof T1.f;
            if (z3) {
                c0224b.b();
                if (z3) {
                    ArrayList arrayList = ((T1.f) hVar).f1619f;
                    int size = arrayList.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList.get(i4);
                        i4++;
                        e(c0224b, (T1.h) obj);
                    }
                    c0224b.e();
                    return;
                }
                throw new IllegalStateException("Not a JSON Array: " + hVar);
            }
            if (hVar instanceof T1.k) {
                c0224b.c();
                Iterator it = ((V1.m) hVar.b().f1621f.entrySet()).iterator();
                while (((V1.l) it).hasNext()) {
                    V1.n b4 = ((V1.l) it).b();
                    c0224b.g((String) b4.getKey());
                    e(c0224b, (T1.h) b4.getValue());
                }
                c0224b.f();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
        }
        c0224b.i();
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        T1.h fVar;
        String str;
        T1.h fVar2;
        boolean z;
        if (c0223a instanceof C0124o) {
            C0124o c0124o = (C0124o) c0223a;
            int x3 = c0124o.x();
            if (x3 != 5 && x3 != 2 && x3 != 4 && x3 != 10) {
                T1.h hVar = (T1.h) c0124o.K();
                c0124o.D();
                return hVar;
            }
            throw new IllegalStateException("Unexpected " + A2.i.s(x3) + " when reading a JsonElement.");
        }
        int x4 = c0223a.x();
        int b4 = R.i.b(x4);
        if (b4 != 0) {
            if (b4 != 2) {
                fVar = null;
            } else {
                c0223a.b();
                fVar = new T1.k();
            }
        } else {
            c0223a.a();
            fVar = new T1.f();
        }
        if (fVar == null) {
            return d(c0223a, x4);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (c0223a.k()) {
                if (fVar instanceof T1.k) {
                    str = c0223a.r();
                } else {
                    str = null;
                }
                int x5 = c0223a.x();
                int b5 = R.i.b(x5);
                if (b5 != 0) {
                    if (b5 != 2) {
                        fVar2 = null;
                    } else {
                        c0223a.b();
                        fVar2 = new T1.k();
                    }
                } else {
                    c0223a.a();
                    fVar2 = new T1.f();
                }
                if (fVar2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (fVar2 == null) {
                    fVar2 = d(c0223a, x5);
                }
                if (fVar instanceof T1.f) {
                    ((T1.f) fVar).f1619f.add(fVar2);
                } else {
                    ((T1.k) fVar).f1621f.put(str, fVar2);
                }
                if (z) {
                    arrayDeque.addLast(fVar);
                    fVar = fVar2;
                }
            } else {
                if (fVar instanceof T1.f) {
                    c0223a.e();
                } else {
                    c0223a.f();
                }
                if (arrayDeque.isEmpty()) {
                    return fVar;
                }
                fVar = (T1.h) arrayDeque.removeLast();
            }
        }
    }

    @Override // T1.s
    public final /* bridge */ /* synthetic */ void c(C0224b c0224b, Object obj) {
        e(c0224b, (T1.h) obj);
    }
}
