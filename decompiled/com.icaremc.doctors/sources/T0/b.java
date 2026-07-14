package T0;

import c1.p;
import l1.e0;
import q1.v;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f770c;

    public /* synthetic */ b(int i2) {
        this.f770c = i2;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        c cVar;
        Integer num;
        int i2;
        switch (this.f770c) {
            case 0:
                String acc = (String) obj;
                g element = (g) obj2;
                kotlin.jvm.internal.h.e(acc, "acc");
                kotlin.jvm.internal.h.e(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            case 1:
                i acc2 = (i) obj;
                g element2 = (g) obj2;
                kotlin.jvm.internal.h.e(acc2, "acc");
                kotlin.jvm.internal.h.e(element2, "element");
                i g2 = acc2.g(element2.getKey());
                j jVar = j.f774c;
                if (g2 != jVar) {
                    e eVar = e.f773c;
                    f fVar = (f) g2.k(eVar);
                    if (fVar == null) {
                        cVar = new c(g2, element2);
                    } else {
                        i g3 = g2.g(eVar);
                        if (g3 == jVar) {
                            return new c(element2, fVar);
                        }
                        cVar = new c(new c(g3, element2), fVar);
                    }
                    return cVar;
                }
                return element2;
            case 2:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 3:
                return ((i) obj).d((g) obj2);
            case 4:
                return ((i) obj).d((g) obj2);
            case 5:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 6:
                g gVar = (g) obj2;
                if (gVar instanceof e0) {
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i2 = num.intValue();
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        return gVar;
                    }
                    return Integer.valueOf(i2 + 1);
                }
                return obj;
            case 7:
                e0 e0Var = (e0) obj;
                g gVar2 = (g) obj2;
                if (e0Var == null) {
                    if (gVar2 instanceof e0) {
                        return (e0) gVar2;
                    }
                    return null;
                }
                return e0Var;
            default:
                return (v) obj;
        }
    }
}
