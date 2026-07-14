package x1;

import P1.q;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import u1.C0667b;

/* loaded from: classes.dex */
public final class i implements G1.c, G1.b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6478a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f6479b;

    /* renamed from: c, reason: collision with root package name */
    public final y1.j f6480c;

    public i() {
        y1.j jVar = y1.j.f6584f;
        this.f6478a = new HashMap();
        this.f6479b = new ArrayDeque();
        this.f6480c = jVar;
    }

    @Override // G1.b
    public final void a(G1.a aVar) {
        Set<Map.Entry> entrySet;
        aVar.getClass();
        synchronized (this) {
            try {
                ArrayDeque arrayDeque = this.f6479b;
                if (arrayDeque != null) {
                    arrayDeque.add(aVar);
                    return;
                }
                synchronized (this) {
                    try {
                        Map map = (Map) this.f6478a.get(C0667b.class);
                        if (map == null) {
                            entrySet = Collections.EMPTY_SET;
                        } else {
                            entrySet = map.entrySet();
                        }
                    } finally {
                    }
                }
                for (Map.Entry entry : entrySet) {
                    ((Executor) entry.getValue()).execute(new A.k(entry, aVar));
                }
            } finally {
            }
        }
    }

    public final void b(q qVar) {
        y1.j jVar = this.f6480c;
        synchronized (this) {
            try {
                jVar.getClass();
                if (!this.f6478a.containsKey(C0667b.class)) {
                    this.f6478a.put(C0667b.class, new ConcurrentHashMap());
                }
                ((ConcurrentHashMap) this.f6478a.get(C0667b.class)).put(qVar, jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void c(q qVar) {
        qVar.getClass();
        if (!this.f6478a.containsKey(C0667b.class)) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f6478a.get(C0667b.class);
        concurrentHashMap.remove(qVar);
        if (concurrentHashMap.isEmpty()) {
            this.f6478a.remove(C0667b.class);
        }
    }
}
