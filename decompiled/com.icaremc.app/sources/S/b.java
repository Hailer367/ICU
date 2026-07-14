package S;

import A2.q;
import I2.p;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1534a;

    /* renamed from: b, reason: collision with root package name */
    public final q f1535b;

    public b(LinkedHashMap linkedHashMap, boolean z) {
        this.f1534a = linkedHashMap;
        this.f1535b = new q(z);
    }

    public final Map a() {
        H2.d dVar;
        Set<Map.Entry> entrySet = this.f1534a.entrySet();
        int Q2 = p.Q(I2.g.D(entrySet));
        if (Q2 < 16) {
            Q2 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q2);
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                T2.h.d(copyOf, "copyOf(this, size)");
                dVar = new H2.d(key, copyOf);
            } else {
                dVar = new H2.d(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(dVar.f673f, dVar.f674g);
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        T2.h.d(unmodifiableMap, "unmodifiableMap(map)");
        return unmodifiableMap;
    }

    public final void b() {
        if (!((AtomicBoolean) this.f1535b.f93g).get()) {
        } else {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final Object c(d dVar) {
        T2.h.e(dVar, "key");
        Object obj = this.f1534a.get(dVar);
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            T2.h.d(copyOf, "copyOf(this, size)");
            return copyOf;
        }
        return obj;
    }

    public final void d(d dVar) {
        T2.h.e(dVar, "key");
        b();
        this.f1534a.remove(dVar);
    }

    public final void e(d dVar, Object obj) {
        T2.h.e(dVar, "key");
        f(dVar, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:0: B:10:0x002c->B:24:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof S.b
            r1 = 0
            if (r0 != 0) goto L6
            goto L62
        L6:
            S.b r7 = (S.b) r7
            java.util.LinkedHashMap r0 = r7.f1534a
            java.util.LinkedHashMap r2 = r6.f1534a
            r3 = 1
            if (r0 != r2) goto L10
            goto L63
        L10:
            int r0 = r0.size()
            int r4 = r2.size()
            if (r0 == r4) goto L1b
            goto L62
        L1b:
            java.util.LinkedHashMap r7 = r7.f1534a
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L24
            goto L63
        L24:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L2c:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L63
            java.lang.Object r0 = r7.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r4 = r2.get(r4)
            if (r4 == 0) goto L5f
            java.lang.Object r0 = r0.getValue()
            boolean r5 = r0 instanceof byte[]
            if (r5 == 0) goto L5a
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L5f
            byte[] r0 = (byte[]) r0
            byte[] r4 = (byte[]) r4
            boolean r0 = java.util.Arrays.equals(r0, r4)
            if (r0 == 0) goto L5f
            r0 = r3
            goto L60
        L5a:
            boolean r0 = T2.h.a(r0, r4)
            goto L60
        L5f:
            r0 = r1
        L60:
            if (r0 != 0) goto L2c
        L62:
            return r1
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: S.b.equals(java.lang.Object):boolean");
    }

    public final void f(d dVar, Object obj) {
        T2.h.e(dVar, "key");
        b();
        if (obj == null) {
            d(dVar);
            return;
        }
        boolean z = obj instanceof Set;
        LinkedHashMap linkedHashMap = this.f1534a;
        if (z) {
            Set unmodifiableSet = Collections.unmodifiableSet(I2.e.K((Set) obj));
            T2.h.d(unmodifiableSet, "unmodifiableSet(set.toSet())");
            linkedHashMap.put(dVar, unmodifiableSet);
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                T2.h.d(copyOf, "copyOf(this, size)");
                linkedHashMap.put(dVar, copyOf);
                return;
            }
            linkedHashMap.put(dVar, obj);
        }
    }

    public final int hashCode() {
        int hashCode;
        Iterator it = this.f1534a.entrySet().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof byte[]) {
                hashCode = Arrays.hashCode((byte[]) value);
            } else {
                hashCode = value.hashCode();
            }
            i4 += hashCode;
        }
        return i4;
    }

    public final String toString() {
        return I2.e.G(this.f1534a.entrySet(), ",\n", "{\n", "\n}", a.f1533g, 24);
    }

    public /* synthetic */ b(boolean z) {
        this(new LinkedHashMap(), z);
    }
}
