package d0;

import I2.m;
import e.q;
import e3.p;
import e3.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final r f3440a = new r(g.f3453e);

    /* renamed from: b, reason: collision with root package name */
    public final r f3441b;

    /* renamed from: c, reason: collision with root package name */
    public final p f3442c;

    /* renamed from: d, reason: collision with root package name */
    public final I2.c f3443d;

    /* renamed from: e, reason: collision with root package name */
    public final I2.c f3444e;

    /* renamed from: f, reason: collision with root package name */
    public e.p f3445f;

    /* renamed from: g, reason: collision with root package name */
    public int f3446g;

    /* renamed from: h, reason: collision with root package name */
    public e f3447h;

    /* renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f3448i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f3449j;
    public final LinkedHashSet k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3450l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3451m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3452n;

    public f() {
        r rVar = new r(new d());
        this.f3441b = rVar;
        this.f3442c = new p(rVar);
        this.f3443d = new I2.c();
        this.f3444e = new I2.c();
        this.f3448i = new LinkedHashSet();
        this.f3449j = new LinkedHashSet();
        this.k = new LinkedHashSet();
    }

    public final void a(c cVar, e eVar, int i4) {
        LinkedHashSet linkedHashSet;
        boolean z;
        T2.h.e(cVar, "dispatcher");
        if (eVar.f3438a == null) {
            if (i4 != 0) {
                if (i4 != 1) {
                    linkedHashSet = this.f3448i;
                } else {
                    linkedHashSet = this.f3449j;
                }
            } else {
                linkedHashSet = this.k;
            }
            linkedHashSet.add(eVar);
            eVar.f3438a = cVar;
            T2.h.e((d) this.f3442c.f3646f.a(), "history");
            if (i4 != 0) {
                if (i4 != 1) {
                    z = this.f3452n;
                } else {
                    z = this.f3450l;
                }
            } else {
                z = this.f3451m;
            }
            eVar.b(z);
            return;
        }
        throw new IllegalArgumentException(("Input '" + eVar + "' is already added to dispatcher " + eVar.f3438a + '.').toString());
    }

    public final void b() {
        boolean z;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        d dVar;
        I2.c cVar = this.f3443d;
        if (cVar == null || !cVar.isEmpty()) {
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                if (((e.p) it.next()).f3574b) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        I2.c cVar2 = this.f3444e;
        if (cVar2 == null || !cVar2.isEmpty()) {
            Iterator it2 = cVar2.iterator();
            while (it2.hasNext()) {
                if (((e.p) it2.next()).f3574b) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (!z && !z3) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (this.f3451m != z) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.f3450l != z3) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.f3452n != z4) {
            z7 = true;
        } else {
            z7 = false;
        }
        LinkedHashSet linkedHashSet = this.k;
        if (z5) {
            Iterator it3 = linkedHashSet.iterator();
            while (it3.hasNext()) {
                ((e) it3.next()).b(z);
            }
        }
        LinkedHashSet linkedHashSet2 = this.f3449j;
        if (z6) {
            Iterator it4 = linkedHashSet2.iterator();
            while (it4.hasNext()) {
                ((e) it4.next()).b(z3);
            }
        }
        LinkedHashSet linkedHashSet3 = this.f3448i;
        if (z7) {
            Iterator it5 = linkedHashSet3.iterator();
            while (it5.hasNext()) {
                ((e) it5.next()).b(z4);
            }
        }
        this.f3451m = z;
        this.f3450l = z3;
        this.f3452n = z4;
        e.p pVar = this.f3445f;
        if (pVar == null) {
            pVar = c(0);
        }
        e.p pVar2 = this.f3445f;
        if (pVar2 == null) {
            pVar2 = c(0);
        }
        if (T2.h.a(pVar2, pVar)) {
            if (pVar2 == null) {
                dVar = new d();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<E> it6 = cVar.iterator();
                while (it6.hasNext()) {
                    ((e.p) it6.next()).getClass();
                }
                Iterator<E> it7 = cVar2.iterator();
                while (it7.hasNext()) {
                    ((e.p) it7.next()).getClass();
                }
                q qVar = pVar2.f3573a;
                J2.c cVar3 = new J2.c(10);
                cVar3.addAll(arrayList);
                cVar3.add(qVar);
                cVar3.addAll(m.f862f);
                cVar3.f();
                cVar3.f901h = true;
                if (cVar3.f900g <= 0) {
                    cVar3 = J2.c.f898i;
                }
                dVar = new d(arrayList.size(), cVar3);
            }
            r rVar = this.f3441b;
            if (!T2.h.a((d) rVar.a(), dVar)) {
                rVar.c(null, dVar);
                Iterator it8 = linkedHashSet.iterator();
                while (it8.hasNext()) {
                    ((e) it8.next()).getClass();
                }
                Iterator it9 = linkedHashSet2.iterator();
                while (it9.hasNext()) {
                    ((e) it9.next()).getClass();
                }
                Iterator it10 = linkedHashSet3.iterator();
                while (it10.hasNext()) {
                    ((e) it10.next()).getClass();
                }
            }
        }
    }

    public final e.p c(int i4) {
        Object obj;
        Object obj2;
        I2.c cVar = this.f3444e;
        I2.c cVar2 = this.f3443d;
        Object obj3 = null;
        if (i4 != -1) {
            if (i4 != 0) {
                if (i4 == 1) {
                    Iterator it = cVar2.iterator();
                    while (it.hasNext()) {
                        ((e.p) it.next()).getClass();
                    }
                    Iterator it2 = cVar.iterator();
                    while (it2.hasNext()) {
                        ((e.p) it2.next()).getClass();
                    }
                    return null;
                }
                throw new IllegalStateException(("Unsupported direction: '" + i4 + "'.").toString());
            }
            Iterator it3 = cVar2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    obj2 = it3.next();
                    if (((e.p) obj2).f3574b) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            e.p pVar = (e.p) obj2;
            if (pVar == null) {
                Iterator it4 = cVar.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (((e.p) next).f3574b) {
                        obj3 = next;
                        break;
                    }
                }
                return (e.p) obj3;
            }
            return pVar;
        }
        Iterator it5 = cVar2.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                if (((e.p) obj).f3574b) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        e.p pVar2 = (e.p) obj;
        if (pVar2 == null) {
            Iterator it6 = cVar.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                Object next2 = it6.next();
                if (((e.p) next2).f3574b) {
                    obj3 = next2;
                    break;
                }
            }
            return (e.p) obj3;
        }
        return pVar2;
    }
}
