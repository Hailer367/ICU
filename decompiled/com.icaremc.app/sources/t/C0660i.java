package t;

import j.O;
import java.util.LinkedHashMap;

/* renamed from: t.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0660i {

    /* renamed from: a, reason: collision with root package name */
    public final int f6188a;

    /* renamed from: b, reason: collision with root package name */
    public final O f6189b;

    /* renamed from: c, reason: collision with root package name */
    public final W0.g f6190c;

    /* renamed from: d, reason: collision with root package name */
    public int f6191d;

    /* renamed from: e, reason: collision with root package name */
    public int f6192e;

    /* renamed from: f, reason: collision with root package name */
    public int f6193f;

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, W0.g] */
    public C0660i(int i4) {
        this.f6188a = i4;
        if (i4 > 0) {
            this.f6189b = new O(18);
            this.f6190c = new Object();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final Object a(Object obj) {
        T2.h.e(obj, "key");
        synchronized (this.f6190c) {
            O o3 = this.f6189b;
            o3.getClass();
            Object obj2 = ((LinkedHashMap) o3.f4911g).get(obj);
            if (obj2 != null) {
                this.f6192e++;
                return obj2;
            }
            this.f6193f++;
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b6, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            T2.h.e(r6, r0)
            W0.g r0 = r5.f6190c
            monitor-enter(r0)
            int r1 = r5.f6191d     // Catch: java.lang.Throwable -> L24
            int r1 = r1 + 1
            r5.f6191d = r1     // Catch: java.lang.Throwable -> L24
            j.O r1 = r5.f6189b     // Catch: java.lang.Throwable -> L24
            r1.getClass()     // Catch: java.lang.Throwable -> L24
            java.lang.Object r1 = r1.f4911g     // Catch: java.lang.Throwable -> L24
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L24
            java.lang.Object r6 = r1.put(r6, r7)     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L27
            int r7 = r5.f6191d     // Catch: java.lang.Throwable -> L24
            int r7 = r7 + (-1)
            r5.f6191d = r7     // Catch: java.lang.Throwable -> L24
            goto L27
        L24:
            r6 = move-exception
            goto Lc1
        L27:
            monitor-exit(r0)
            int r7 = r5.f6188a
        L2a:
            W0.g r0 = r5.f6190c
            monitor-enter(r0)
            int r1 = r5.f6191d     // Catch: java.lang.Throwable -> L42
            if (r1 < 0) goto Lb7
            j.O r1 = r5.f6189b     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.f4911g     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L45
            int r1 = r5.f6191d     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto Lb7
            goto L45
        L42:
            r6 = move-exception
            goto Lbf
        L45:
            int r1 = r5.f6191d     // Catch: java.lang.Throwable -> L42
            if (r1 <= r7) goto Lb5
            j.O r1 = r5.f6189b     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.f4911g     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L56
            goto Lb5
        L56:
            j.O r1 = r5.f6189b     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.f4911g     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = "map.entries"
            T2.h.d(r1, r2)     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L42
            r3 = 0
            if (r2 == 0) goto L79
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L73
            goto L88
        L73:
            r2 = 0
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L42
            goto L88
        L79:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L42
            if (r2 != 0) goto L84
            goto L88
        L84:
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L42
        L88:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L42
            if (r3 != 0) goto L8e
            monitor-exit(r0)
            return r6
        L8e:
            java.lang.Object r1 = r3.getKey()     // Catch: java.lang.Throwable -> L42
            java.lang.Object r2 = r3.getValue()     // Catch: java.lang.Throwable -> L42
            j.O r3 = r5.f6189b     // Catch: java.lang.Throwable -> L42
            r3.getClass()     // Catch: java.lang.Throwable -> L42
            java.lang.String r4 = "key"
            T2.h.e(r1, r4)     // Catch: java.lang.Throwable -> L42
            java.lang.Object r3 = r3.f4911g     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r3 = (java.util.LinkedHashMap) r3     // Catch: java.lang.Throwable -> L42
            r3.remove(r1)     // Catch: java.lang.Throwable -> L42
            int r1 = r5.f6191d     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "value"
            T2.h.e(r2, r3)     // Catch: java.lang.Throwable -> L42
            int r1 = r1 + (-1)
            r5.f6191d = r1     // Catch: java.lang.Throwable -> L42
            monitor-exit(r0)
            goto L2a
        Lb5:
            monitor-exit(r0)
            return r6
        Lb7:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L42
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L42
            throw r7     // Catch: java.lang.Throwable -> L42
        Lbf:
            monitor-exit(r0)
            throw r6
        Lc1:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t.C0660i.b(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final String toString() {
        int i4;
        String str;
        synchronized (this.f6190c) {
            try {
                int i5 = this.f6192e;
                int i6 = this.f6193f + i5;
                if (i6 != 0) {
                    i4 = (i5 * 100) / i6;
                } else {
                    i4 = 0;
                }
                str = "LruCache[maxSize=" + this.f6188a + ",hits=" + this.f6192e + ",misses=" + this.f6193f + ",hitRate=" + i4 + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
