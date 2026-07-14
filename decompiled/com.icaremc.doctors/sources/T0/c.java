package T0;

import c1.p;
import com.google.firebase.encoders.json.BuildConfig;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class c implements i, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final i f771c;

    /* renamed from: d, reason: collision with root package name */
    public final g f772d;

    public c(i left, g element) {
        kotlin.jvm.internal.h.e(left, "left");
        kotlin.jvm.internal.h.e(element, "element");
        this.f771c = left;
        this.f772d = element;
    }

    @Override // T0.i
    public final Object c(Object obj, p pVar) {
        return pVar.invoke(this.f771c.c(obj, pVar), this.f772d);
    }

    @Override // T0.i
    public final i d(i context) {
        kotlin.jvm.internal.h.e(context, "context");
        if (context == j.f774c) {
            return this;
        }
        return (i) context.c(this, new b(1));
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                cVar.getClass();
                int i2 = 2;
                c cVar2 = cVar;
                int i3 = 2;
                while (true) {
                    i iVar = cVar2.f771c;
                    if (iVar instanceof c) {
                        cVar2 = (c) iVar;
                    } else {
                        cVar2 = null;
                    }
                    if (cVar2 == null) {
                        break;
                    }
                    i3++;
                }
                c cVar3 = this;
                while (true) {
                    i iVar2 = cVar3.f771c;
                    if (iVar2 instanceof c) {
                        cVar3 = (c) iVar2;
                    } else {
                        cVar3 = null;
                    }
                    if (cVar3 == null) {
                        break;
                    }
                    i2++;
                }
                if (i3 == i2) {
                    c cVar4 = this;
                    while (true) {
                        g gVar = cVar4.f772d;
                        if (!kotlin.jvm.internal.h.a(cVar.k(gVar.getKey()), gVar)) {
                            z = false;
                            break;
                        }
                        i iVar3 = cVar4.f771c;
                        if (iVar3 instanceof c) {
                            cVar4 = (c) iVar3;
                        } else {
                            kotlin.jvm.internal.h.c(iVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                            g gVar2 = (g) iVar3;
                            z = kotlin.jvm.internal.h.a(cVar.k(gVar2.getKey()), gVar2);
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

    @Override // T0.i
    public final i g(h key) {
        kotlin.jvm.internal.h.e(key, "key");
        g gVar = this.f772d;
        g k2 = gVar.k(key);
        i iVar = this.f771c;
        if (k2 != null) {
            return iVar;
        }
        i g2 = iVar.g(key);
        if (g2 == iVar) {
            return this;
        }
        if (g2 == j.f774c) {
            return gVar;
        }
        return new c(g2, gVar);
    }

    public final int hashCode() {
        return this.f772d.hashCode() + this.f771c.hashCode();
    }

    @Override // T0.i
    public final g k(h key) {
        kotlin.jvm.internal.h.e(key, "key");
        c cVar = this;
        while (true) {
            g k2 = cVar.f772d.k(key);
            if (k2 != null) {
                return k2;
            }
            i iVar = cVar.f771c;
            if (iVar instanceof c) {
                cVar = (c) iVar;
            } else {
                return iVar.k(key);
            }
        }
    }

    public final String toString() {
        return "[" + ((String) c(BuildConfig.FLAVOR, new b(0))) + ']';
    }
}
