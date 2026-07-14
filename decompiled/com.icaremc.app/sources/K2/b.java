package K2;

import S2.p;
import b3.d0;
import g3.v;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f938f;

    public /* synthetic */ b(int i4) {
        this.f938f = i4;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        c cVar;
        Integer num;
        int i4;
        switch (this.f938f) {
            case 0:
                String str = (String) obj;
                g gVar = (g) obj2;
                T2.h.e(str, "acc");
                T2.h.e(gVar, "element");
                if (str.length() == 0) {
                    return gVar.toString();
                }
                return str + ", " + gVar;
            case 1:
                i iVar = (i) obj;
                g gVar2 = (g) obj2;
                T2.h.e(iVar, "acc");
                T2.h.e(gVar2, "element");
                i c4 = iVar.c(gVar2.getKey());
                j jVar = j.f942f;
                if (c4 != jVar) {
                    e eVar = e.f941f;
                    f fVar = (f) c4.e(eVar);
                    if (fVar == null) {
                        cVar = new c(c4, gVar2);
                    } else {
                        i c5 = c4.c(eVar);
                        if (c5 == jVar) {
                            return new c(gVar2, fVar);
                        }
                        cVar = new c(new c(c5, gVar2), fVar);
                    }
                    return cVar;
                }
                return gVar2;
            case 2:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 3:
                return ((i) obj).j((g) obj2);
            case 4:
                return ((i) obj).j((g) obj2);
            case 5:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 6:
                g gVar3 = (g) obj2;
                if (gVar3 instanceof d0) {
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i4 = num.intValue();
                    } else {
                        i4 = 1;
                    }
                    if (i4 == 0) {
                        return gVar3;
                    }
                    return Integer.valueOf(i4 + 1);
                }
                return obj;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                d0 d0Var = (d0) obj;
                g gVar4 = (g) obj2;
                if (d0Var == null) {
                    if (gVar4 instanceof d0) {
                        return (d0) gVar4;
                    }
                    return null;
                }
                return d0Var;
            default:
                return (v) obj;
        }
    }
}
