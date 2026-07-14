package K2;

import S2.p;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class c implements i, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final i f939f;

    /* renamed from: g, reason: collision with root package name */
    public final g f940g;

    public c(i iVar, g gVar) {
        T2.h.e(iVar, "left");
        T2.h.e(gVar, "element");
        this.f939f = iVar;
        this.f940g = gVar;
    }

    @Override // K2.i
    public final i c(h hVar) {
        T2.h.e(hVar, "key");
        g gVar = this.f940g;
        g e4 = gVar.e(hVar);
        i iVar = this.f939f;
        if (e4 != null) {
            return iVar;
        }
        i c4 = iVar.c(hVar);
        if (c4 == iVar) {
            return this;
        }
        if (c4 == j.f942f) {
            return gVar;
        }
        return new c(c4, gVar);
    }

    @Override // K2.i
    public final g e(h hVar) {
        T2.h.e(hVar, "key");
        c cVar = this;
        while (true) {
            g e4 = cVar.f940g.e(hVar);
            if (e4 != null) {
                return e4;
            }
            i iVar = cVar.f939f;
            if (iVar instanceof c) {
                cVar = (c) iVar;
            } else {
                return iVar.e(hVar);
            }
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                cVar.getClass();
                int i4 = 2;
                c cVar2 = cVar;
                int i5 = 2;
                while (true) {
                    i iVar = cVar2.f939f;
                    if (iVar instanceof c) {
                        cVar2 = (c) iVar;
                    } else {
                        cVar2 = null;
                    }
                    if (cVar2 == null) {
                        break;
                    }
                    i5++;
                }
                c cVar3 = this;
                while (true) {
                    i iVar2 = cVar3.f939f;
                    if (iVar2 instanceof c) {
                        cVar3 = (c) iVar2;
                    } else {
                        cVar3 = null;
                    }
                    if (cVar3 == null) {
                        break;
                    }
                    i4++;
                }
                if (i5 == i4) {
                    c cVar4 = this;
                    while (true) {
                        g gVar = cVar4.f940g;
                        if (!T2.h.a(cVar.e(gVar.getKey()), gVar)) {
                            z = false;
                            break;
                        }
                        i iVar3 = cVar4.f939f;
                        if (iVar3 instanceof c) {
                            cVar4 = (c) iVar3;
                        } else {
                            T2.h.c(iVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                            g gVar2 = (g) iVar3;
                            z = T2.h.a(cVar.e(gVar2.getKey()), gVar2);
                            break;
                        }
                    }
                    if (z) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f940g.hashCode() + this.f939f.hashCode();
    }

    @Override // K2.i
    public final i j(i iVar) {
        T2.h.e(iVar, "context");
        if (iVar == j.f942f) {
            return this;
        }
        return (i) iVar.k(this, new b(1));
    }

    @Override // K2.i
    public final Object k(Object obj, p pVar) {
        return pVar.e(this.f939f.k(obj, pVar), this.f940g);
    }

    public final String toString() {
        return "[" + ((String) k("", new b(0))) + ']';
    }
}
