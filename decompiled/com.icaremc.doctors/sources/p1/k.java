package p1;

import kotlin.jvm.internal.t;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final F.h f3488a = new F.h(17, "NULL");

    public static /* synthetic */ o1.d a(i iVar, m1.c cVar, int i2, n1.a aVar, int i3) {
        T0.i iVar2 = cVar;
        if ((i3 & 1) != 0) {
            iVar2 = T0.j.f774c;
        }
        if ((i3 & 2) != 0) {
            i2 = -3;
        }
        if ((i3 & 4) != 0) {
            aVar = n1.a.f3306c;
        }
        return iVar.a(iVar2, i2, aVar);
    }

    public static final Object b(T0.i iVar, Object obj, Object obj2, c1.p pVar, T0.d frame) {
        Object invoke;
        Object l2 = q1.a.l(iVar, obj2);
        try {
            q qVar = new q(frame, iVar);
            if (pVar == null) {
                invoke = android.support.v4.media.session.a.L(pVar, obj, qVar);
            } else {
                t.a(2, pVar);
                invoke = pVar.invoke(obj, qVar);
            }
            q1.a.g(iVar, l2);
            if (invoke == U0.a.f780c) {
                kotlin.jvm.internal.h.e(frame, "frame");
            }
            return invoke;
        } catch (Throwable th) {
            q1.a.g(iVar, l2);
            throw th;
        }
    }
}
