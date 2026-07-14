package x1;

import P1.C0108l;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: h, reason: collision with root package name */
    public static final C0108l f6462h = new C0108l(1);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6463a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6464b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6465c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f6466d;

    /* renamed from: e, reason: collision with root package name */
    public final i f6467e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f6468f;

    /* renamed from: g, reason: collision with root package name */
    public final W0.g f6469g;

    public d(ArrayList arrayList, ArrayList arrayList2, W0.g gVar) {
        y1.j jVar = y1.j.f6584f;
        this.f6463a = new HashMap();
        this.f6464b = new HashMap();
        this.f6465c = new HashMap();
        this.f6466d = new HashSet();
        this.f6468f = new AtomicReference();
        i iVar = new i();
        this.f6467e = iVar;
        this.f6469g = gVar;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(C0721a.b(iVar, i.class, G1.c.class, G1.b.class));
        int i4 = 0;
        arrayList3.add(C0721a.b(this, d.class, new Class[0]));
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList2.get(i5);
            i5++;
            C0721a c0721a = (C0721a) obj;
            if (c0721a != null) {
                arrayList3.add(c0721a);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i6 = 0;
        while (i6 < size2) {
            Object obj2 = arrayList.get(i6);
            i6++;
            arrayList4.add(obj2);
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((J1.a) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.f6469g.i(componentRegistrar));
                        it.remove();
                    }
                } catch (j e4) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e4);
                }
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                Object[] array = ((C0721a) it2.next()).f6456b.toArray();
                int length = array.length;
                int i7 = 0;
                while (true) {
                    if (i7 < length) {
                        Object obj3 = array[i7];
                        if (obj3.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f6466d.contains(obj3.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f6466d.add(obj3.toString());
                        }
                        i7++;
                    }
                }
            }
            if (this.f6463a.isEmpty()) {
                k3.b.g(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f6463a.keySet());
                arrayList6.addAll(arrayList3);
                k3.b.g(arrayList6);
            }
            int size3 = arrayList3.size();
            int i8 = 0;
            while (i8 < size3) {
                Object obj4 = arrayList3.get(i8);
                i8++;
                C0721a c0721a2 = (C0721a) obj4;
                this.f6463a.put(c0721a2, new k(new H1.c(2, this, c0721a2)));
            }
            arrayList5.addAll(i(arrayList3));
            arrayList5.addAll(j());
            h();
        }
        int size4 = arrayList5.size();
        while (i4 < size4) {
            Object obj5 = arrayList5.get(i4);
            i4++;
            ((Runnable) obj5).run();
        }
        Boolean bool = (Boolean) this.f6468f.get();
        if (bool != null) {
            g(this.f6463a, bool.booleanValue());
        }
    }

    @Override // x1.b
    public final synchronized J1.a b(o oVar) {
        l lVar = (l) this.f6465c.get(oVar);
        if (lVar != null) {
            return lVar;
        }
        return f6462h;
    }

    @Override // x1.b
    public final synchronized J1.a f(o oVar) {
        AbstractC0602b.h(oVar, "Null interface requested.");
        return (J1.a) this.f6464b.get(oVar);
    }

    public final void g(HashMap hashMap, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : hashMap.entrySet()) {
            C0721a c0721a = (C0721a) entry.getKey();
            J1.a aVar = (J1.a) entry.getValue();
            int i4 = c0721a.f6458d;
            if (i4 == 1 || (i4 == 2 && z)) {
                aVar.get();
            }
        }
        i iVar = this.f6467e;
        synchronized (iVar) {
            try {
                arrayDeque = iVar.f6479b;
                if (arrayDeque != null) {
                    iVar.f6479b = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                iVar.a((G1.a) it.next());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, x1.m] */
    /* JADX WARN: Type inference failed for: r6v4, types: [x1.l, java.lang.Object] */
    public final void h() {
        for (C0721a c0721a : this.f6463a.keySet()) {
            for (g gVar : c0721a.f6457c) {
                if (gVar.f6476b == 2 && !this.f6465c.containsKey(gVar.f6475a)) {
                    HashMap hashMap = this.f6465c;
                    o oVar = gVar.f6475a;
                    Set set = Collections.EMPTY_SET;
                    ?? obj = new Object();
                    obj.f6485b = null;
                    obj.f6484a = Collections.newSetFromMap(new ConcurrentHashMap());
                    obj.f6484a.addAll(set);
                    hashMap.put(oVar, obj);
                } else if (this.f6464b.containsKey(gVar.f6475a)) {
                    continue;
                } else {
                    int i4 = gVar.f6476b;
                    if (i4 != 1) {
                        if (i4 != 2) {
                            HashMap hashMap2 = this.f6464b;
                            o oVar2 = gVar.f6475a;
                            V1.f fVar = m.f6486c;
                            C0108l c0108l = m.f6487d;
                            ?? obj2 = new Object();
                            obj2.f6488a = fVar;
                            obj2.f6489b = c0108l;
                            hashMap2.put(oVar2, obj2);
                        }
                    } else {
                        throw new RuntimeException("Unsatisfied dependency for component " + c0721a + ": " + gVar.f6475a);
                    }
                }
            }
        }
    }

    public final ArrayList i(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            C0721a c0721a = (C0721a) obj;
            if (c0721a.f6459e == 0) {
                J1.a aVar = (J1.a) this.f6463a.get(c0721a);
                for (o oVar : c0721a.f6456b) {
                    HashMap hashMap = this.f6464b;
                    if (!hashMap.containsKey(oVar)) {
                        hashMap.put(oVar, aVar);
                    } else {
                        arrayList2.add(new A.j(9, (m) ((J1.a) hashMap.get(oVar)), aVar));
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [x1.l, java.lang.Object] */
    public final ArrayList j() {
        HashMap hashMap = this.f6465c;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : this.f6463a.entrySet()) {
            C0721a c0721a = (C0721a) entry.getKey();
            if (c0721a.f6459e != 0) {
                J1.a aVar = (J1.a) entry.getValue();
                for (o oVar : c0721a.f6456b) {
                    if (!hashMap2.containsKey(oVar)) {
                        hashMap2.put(oVar, new HashSet());
                    }
                    ((Set) hashMap2.get(oVar)).add(aVar);
                }
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (!hashMap.containsKey(entry2.getKey())) {
                o oVar2 = (o) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                ?? obj = new Object();
                obj.f6485b = null;
                obj.f6484a = Collections.newSetFromMap(new ConcurrentHashMap());
                obj.f6484a.addAll(set);
                hashMap.put(oVar2, obj);
            } else {
                l lVar = (l) hashMap.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new A.j(10, lVar, (J1.a) it.next()));
                }
            }
        }
        return arrayList;
    }
}
