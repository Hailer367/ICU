package f3;

import T2.s;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final R1.c f3727a = new R1.c(21, "NULL");

    public static e3.d a(e3.c cVar, c3.c cVar2, int i4, d3.a aVar, int i5) {
        K2.i iVar = cVar2;
        if ((i5 & 1) != 0) {
            iVar = K2.j.f942f;
        }
        if ((i5 & 2) != 0) {
            i4 = -3;
        }
        int i6 = i5 & 4;
        d3.a aVar2 = d3.a.f3492f;
        if (i6 != 0) {
            aVar = aVar2;
        }
        d3.a aVar3 = cVar.f3720h;
        int i7 = cVar.f3719g;
        K2.i iVar2 = cVar.f3718f;
        K2.i j4 = iVar.j(iVar2);
        if (aVar == aVar2) {
            if (i7 != -3) {
                if (i4 != -3) {
                    if (i7 != -2) {
                        if (i4 != -2) {
                            i4 += i7;
                            if (i4 < 0) {
                                i4 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i4 = i7;
            }
            aVar = aVar3;
        }
        if (T2.h.a(j4, iVar2) && i4 == i7 && aVar == aVar3) {
            return cVar;
        }
        return new e3.c(cVar.f3613j, j4, i4, aVar);
    }

    public static final Object b(K2.i iVar, Object obj, Object obj2, S2.p pVar, K2.d dVar) {
        Object e4;
        Object l3 = g3.a.l(iVar, obj2);
        try {
            q qVar = new q(dVar, iVar);
            if (pVar == null) {
                e4 = k3.b.C(pVar, obj, qVar);
            } else {
                s.a(2, pVar);
                e4 = pVar.e(obj, qVar);
            }
            g3.a.g(iVar, l3);
            if (e4 == L2.a.f1019f) {
                T2.h.e(dVar, "frame");
            }
            return e4;
        } catch (Throwable th) {
            g3.a.g(iVar, l3);
            throw th;
        }
    }
}
