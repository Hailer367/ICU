package io.flutter.embedding.android;

import T0.i;
import android.app.Activity;
import j0.C0216a;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import k0.C0221a;
import kotlin.jvm.internal.h;
import l0.j;
import l1.AbstractC0223a;
import l1.AbstractC0244w;
import l1.C;
import l1.C0241t;
import l1.EnumC0243v;
import l1.J;
import l1.O;
import l1.Q;
import p1.k;
import q1.n;

/* loaded from: classes.dex */
public class WindowInfoRepositoryCallbackAdapterWrapper {
    final C0221a adapter;

    public WindowInfoRepositoryCallbackAdapterWrapper(C0221a c0221a) {
        this.adapter = c0221a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v8, types: [o1.d] */
    public void addWindowLayoutInfoListener(Activity activity, Executor executor, D.a consumer) {
        C0221a c0221a = this.adapter;
        c0221a.getClass();
        h.e(activity, "activity");
        h.e(executor, "executor");
        h.e(consumer, "consumer");
        B.c cVar = c0221a.f2774c;
        l0.b bVar = c0221a.f2773b;
        bVar.getClass();
        j jVar = new j(bVar, activity, null);
        n1.a aVar = n1.a.f3306c;
        T0.j jVar2 = T0.j.f774c;
        o1.c cVar2 = new o1.c(jVar, jVar2, -2, aVar);
        s1.e eVar = C.f2950a;
        m1.c cVar3 = n.f3538a;
        if (cVar3.k(C0241t.f3012d) == null) {
            o1.c flow = cVar2;
            if (!cVar3.equals(jVar2)) {
                flow = k.a(cVar2, cVar3, 0, null, 6);
            }
            LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f40e;
            h.e(flow, "flow");
            ReentrantLock reentrantLock = (ReentrantLock) cVar.f39d;
            reentrantLock.lock();
            try {
                if (linkedHashMap.get(consumer) == null) {
                    i j2 = new J(executor);
                    if (j2.k(C0241t.f3012d) == null) {
                        j2 = j2.d(new Q());
                    }
                    C0216a c0216a = new C0216a(flow, consumer, null);
                    EnumC0243v enumC0243v = EnumC0243v.f3013c;
                    i a2 = AbstractC0244w.a(j2, jVar2, true);
                    s1.e eVar2 = C.f2950a;
                    if (a2 != eVar2 && a2.k(T0.e.f773c) == null) {
                        a2 = a2.d(eVar2);
                    }
                    EnumC0243v enumC0243v2 = EnumC0243v.f3013c;
                    AbstractC0223a abstractC0223a = new AbstractC0223a(a2, true);
                    abstractC0223a.S(enumC0243v, abstractC0223a, c0216a);
                    linkedHashMap.put(consumer, abstractC0223a);
                }
                return;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + cVar3).toString());
    }

    public void removeWindowLayoutInfoListener(D.a consumer) {
        C0221a c0221a = this.adapter;
        c0221a.getClass();
        h.e(consumer, "consumer");
        B.c cVar = c0221a.f2774c;
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f40e;
        ReentrantLock reentrantLock = (ReentrantLock) cVar.f39d;
        reentrantLock.lock();
        try {
            O o2 = (O) linkedHashMap.get(consumer);
            if (o2 != null) {
                o2.b(null);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
