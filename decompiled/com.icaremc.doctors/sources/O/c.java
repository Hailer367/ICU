package O;

import R0.l;
import R0.u;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class c extends g {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f627a;

    /* renamed from: b, reason: collision with root package name */
    public final F.h f628b;

    public c(LinkedHashMap linkedHashMap, boolean z) {
        this.f627a = linkedHashMap;
        this.f628b = new F.h(z);
    }

    @Override // O.g
    public final Map a() {
        Q0.e eVar;
        Set<Map.Entry> entrySet = this.f627a.entrySet();
        int X2 = u.X(l.O(entrySet));
        if (X2 < 16) {
            X2 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(X2);
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.h.d(copyOf, "copyOf(this, size)");
                eVar = new Q0.e(key, copyOf);
            } else {
                eVar = new Q0.e(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(eVar.f714c, eVar.f715d);
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.h.d(unmodifiableMap, "unmodifiableMap(map)");
        return unmodifiableMap;
    }

    @Override // O.g
    public final Object b(e key) {
        kotlin.jvm.internal.h.e(key, "key");
        Object obj = this.f627a.get(key);
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            kotlin.jvm.internal.h.d(copyOf, "copyOf(this, size)");
            return copyOf;
        }
        return obj;
    }

    public final void c() {
        if (!((AtomicBoolean) this.f628b.f274d).get()) {
        } else {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void d(e key) {
        kotlin.jvm.internal.h.e(key, "key");
        c();
        this.f627a.remove(key);
    }

    public final void e(e key, Object obj) {
        kotlin.jvm.internal.h.e(key, "key");
        f(key, obj);
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
            boolean r0 = r7 instanceof O.c
            r1 = 0
            if (r0 != 0) goto L6
            goto L62
        L6:
            O.c r7 = (O.c) r7
            java.util.LinkedHashMap r0 = r7.f627a
            java.util.LinkedHashMap r2 = r6.f627a
            r3 = 1
            if (r0 != r2) goto L10
            goto L63
        L10:
            int r0 = r0.size()
            int r4 = r2.size()
            if (r0 == r4) goto L1b
            goto L62
        L1b:
            java.util.LinkedHashMap r7 = r7.f627a
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
            boolean r0 = kotlin.jvm.internal.h.a(r0, r4)
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
        throw new UnsupportedOperationException("Method not decompiled: O.c.equals(java.lang.Object):boolean");
    }

    public final void f(e key, Object obj) {
        kotlin.jvm.internal.h.e(key, "key");
        c();
        if (obj == null) {
            d(key);
            return;
        }
        boolean z = obj instanceof Set;
        LinkedHashMap linkedHashMap = this.f627a;
        if (z) {
            Set unmodifiableSet = Collections.unmodifiableSet(R0.j.W((Set) obj));
            kotlin.jvm.internal.h.d(unmodifiableSet, "unmodifiableSet(set.toSet())");
            linkedHashMap.put(key, unmodifiableSet);
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.h.d(copyOf, "copyOf(this, size)");
                linkedHashMap.put(key, copyOf);
                return;
            }
            linkedHashMap.put(key, obj);
        }
    }

    public final int hashCode() {
        int hashCode;
        Iterator it = this.f627a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof byte[]) {
                hashCode = Arrays.hashCode((byte[]) value);
            } else {
                hashCode = value.hashCode();
            }
            i2 += hashCode;
        }
        return i2;
    }

    public final String toString() {
        return R0.j.S(this.f627a.entrySet(), ",\n", "{\n", "\n}", b.f626c, 24);
    }

    public /* synthetic */ c(boolean z) {
        this(new LinkedHashMap(), z);
    }
}
