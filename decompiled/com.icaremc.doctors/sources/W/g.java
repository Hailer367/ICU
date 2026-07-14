package W;

import R0.r;
import d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o1.s;
import o1.v;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final v f802a = new v(h.f816f);

    /* renamed from: b, reason: collision with root package name */
    public final v f803b;

    /* renamed from: c, reason: collision with root package name */
    public final s f804c;

    /* renamed from: d, reason: collision with root package name */
    public final R0.h f805d;

    /* renamed from: e, reason: collision with root package name */
    public final R0.h f806e;

    /* renamed from: f, reason: collision with root package name */
    public o f807f;

    /* renamed from: g, reason: collision with root package name */
    public int f808g;

    /* renamed from: h, reason: collision with root package name */
    public f f809h;

    /* renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f810i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f811j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f812k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f813l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f814m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f815n;

    public g() {
        v vVar = new v(new d());
        this.f803b = vVar;
        this.f804c = new s(vVar);
        this.f805d = new R0.h();
        this.f806e = new R0.h();
        this.f810i = new LinkedHashSet();
        this.f811j = new LinkedHashSet();
        this.f812k = new LinkedHashSet();
    }

    public final void a(c dispatcher, f fVar, int i2) {
        LinkedHashSet linkedHashSet;
        boolean z;
        kotlin.jvm.internal.h.e(dispatcher, "dispatcher");
        if (fVar.f800a == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    linkedHashSet = this.f810i;
                } else {
                    linkedHashSet = this.f811j;
                }
            } else {
                linkedHashSet = this.f812k;
            }
            linkedHashSet.add(fVar);
            fVar.f800a = dispatcher;
            d history = (d) this.f804c.f3451c.b();
            kotlin.jvm.internal.h.e(history, "history");
            if (i2 != 0) {
                if (i2 != 1) {
                    z = this.f815n;
                } else {
                    z = this.f813l;
                }
            } else {
                z = this.f814m;
            }
            fVar.b(z);
            return;
        }
        throw new IllegalArgumentException(("Input '" + fVar + "' is already added to dispatcher " + fVar.f800a + '.').toString());
    }

    public final void b() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        d dVar;
        R0.h hVar = this.f805d;
        if (hVar == null || !hVar.isEmpty()) {
            Iterator it = hVar.iterator();
            while (it.hasNext()) {
                if (((o) it.next()).f2143d) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        R0.h hVar2 = this.f806e;
        if (hVar2 == null || !hVar2.isEmpty()) {
            Iterator it2 = hVar2.iterator();
            while (it2.hasNext()) {
                if (((o) it2.next()).f2143d) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (!z && !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (this.f814m != z) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f813l != z2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.f815n != z3) {
            z6 = true;
        } else {
            z6 = false;
        }
        LinkedHashSet linkedHashSet = this.f812k;
        if (z4) {
            Iterator it3 = linkedHashSet.iterator();
            while (it3.hasNext()) {
                ((f) it3.next()).b(z);
            }
        }
        LinkedHashSet linkedHashSet2 = this.f811j;
        if (z5) {
            Iterator it4 = linkedHashSet2.iterator();
            while (it4.hasNext()) {
                ((f) it4.next()).b(z2);
            }
        }
        LinkedHashSet linkedHashSet3 = this.f810i;
        if (z6) {
            Iterator it5 = linkedHashSet3.iterator();
            while (it5.hasNext()) {
                ((f) it5.next()).b(z3);
            }
        }
        this.f814m = z;
        this.f813l = z2;
        this.f815n = z3;
        o oVar = this.f807f;
        if (oVar == null) {
            oVar = c(0);
        }
        o oVar2 = this.f807f;
        if (oVar2 == null) {
            oVar2 = c(0);
        }
        if (kotlin.jvm.internal.h.a(oVar2, oVar)) {
            if (oVar2 == null) {
                dVar = new d();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<E> it6 = hVar.iterator();
                while (it6.hasNext()) {
                    o oVar3 = (o) it6.next();
                    if (oVar3.f2143d) {
                        oVar3.f2141b.getClass();
                    }
                }
                Iterator<E> it7 = hVar2.iterator();
                while (it7.hasNext()) {
                    o oVar4 = (o) it7.next();
                    if (oVar4.f2143d) {
                        oVar4.f2141b.getClass();
                    }
                }
                e currentInfo = oVar2.f2140a;
                r forwardInfo = oVar2.f2142c;
                kotlin.jvm.internal.h.e(currentInfo, "currentInfo");
                kotlin.jvm.internal.h.e(forwardInfo, "forwardInfo");
                S0.c cVar = new S0.c(10);
                cVar.addAll(arrayList);
                cVar.add(currentInfo);
                cVar.addAll(forwardInfo);
                cVar.f();
                cVar.f766e = true;
                if (cVar.f765d <= 0) {
                    cVar = S0.c.f763f;
                }
                dVar = new d(arrayList.size(), cVar);
            }
            v vVar = this.f803b;
            if (!kotlin.jvm.internal.h.a((d) vVar.b(), dVar)) {
                vVar.c(null, dVar);
                Iterator it8 = linkedHashSet.iterator();
                while (it8.hasNext()) {
                    ((f) it8.next()).getClass();
                }
                Iterator it9 = linkedHashSet2.iterator();
                while (it9.hasNext()) {
                    ((f) it9.next()).getClass();
                }
                Iterator it10 = linkedHashSet3.iterator();
                while (it10.hasNext()) {
                    ((f) it10.next()).getClass();
                }
            }
        }
    }

    public final o c(int i2) {
        Object obj;
        Object obj2;
        R0.h hVar = this.f806e;
        R0.h hVar2 = this.f805d;
        Object obj3 = null;
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 == 1) {
                    Iterator it = hVar2.iterator();
                    while (it.hasNext()) {
                        ((o) it.next()).getClass();
                    }
                    Iterator it2 = hVar.iterator();
                    while (it2.hasNext()) {
                        ((o) it2.next()).getClass();
                    }
                    return null;
                }
                throw new IllegalStateException(("Unsupported direction: '" + i2 + "'.").toString());
            }
            Iterator it3 = hVar2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    obj2 = it3.next();
                    if (((o) obj2).f2143d) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            o oVar = (o) obj2;
            if (oVar == null) {
                Iterator it4 = hVar.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (((o) next).f2143d) {
                        obj3 = next;
                        break;
                    }
                }
                return (o) obj3;
            }
            return oVar;
        }
        Iterator it5 = hVar2.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                if (((o) obj).f2143d) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        o oVar2 = (o) obj;
        if (oVar2 == null) {
            Iterator it6 = hVar.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                Object next2 = it6.next();
                if (((o) next2).f2143d) {
                    obj3 = next2;
                    break;
                }
            }
            return (o) obj3;
        }
        return oVar2;
    }
}
