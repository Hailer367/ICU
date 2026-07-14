package o;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: o.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0287f implements Iterable {

    /* renamed from: c, reason: collision with root package name */
    public C0284c f3366c;

    /* renamed from: d, reason: collision with root package name */
    public C0284c f3367d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakHashMap f3368e = new WeakHashMap();

    /* renamed from: f, reason: collision with root package name */
    public int f3369f = 0;

    public C0284c a(Object obj) {
        C0284c c0284c = this.f3366c;
        while (c0284c != null && !c0284c.f3359c.equals(obj)) {
            c0284c = c0284c.f3361e;
        }
        return c0284c;
    }

    public Object b(Object obj, Object obj2) {
        C0284c a2 = a(obj);
        if (a2 != null) {
            return a2.f3360d;
        }
        C0284c c0284c = new C0284c(obj, obj2);
        this.f3369f++;
        C0284c c0284c2 = this.f3367d;
        if (c0284c2 == null) {
            this.f3366c = c0284c;
            this.f3367d = c0284c;
            return null;
        }
        c0284c2.f3361e = c0284c;
        c0284c.f3362f = c0284c2;
        this.f3367d = c0284c;
        return null;
    }

    public Object c(Object obj) {
        C0284c a2 = a(obj);
        if (a2 == null) {
            return null;
        }
        this.f3369f--;
        WeakHashMap weakHashMap = this.f3368e;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((AbstractC0286e) it.next()).a(a2);
            }
        }
        C0284c c0284c = a2.f3362f;
        if (c0284c != null) {
            c0284c.f3361e = a2.f3361e;
        } else {
            this.f3366c = a2.f3361e;
        }
        C0284c c0284c2 = a2.f3361e;
        if (c0284c2 != null) {
            c0284c2.f3362f = c0284c;
        } else {
            this.f3367d = c0284c;
        }
        a2.f3361e = null;
        a2.f3362f = null;
        return a2.f3360d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (((o.C0283b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof o.C0287f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            o.f r7 = (o.C0287f) r7
            int r1 = r6.f3369f
            int r3 = r7.f3369f
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            o.b r3 = (o.C0283b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            o.b r4 = (o.C0283b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            o.b r7 = (o.C0283b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0287f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i2 = 0;
        while (true) {
            C0283b c0283b = (C0283b) it;
            if (c0283b.hasNext()) {
                i2 += ((Map.Entry) c0283b.next()).hashCode();
            } else {
                return i2;
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        C0283b c0283b = new C0283b(this.f3366c, this.f3367d, 0);
        this.f3368e.put(c0283b, Boolean.FALSE);
        return c0283b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            C0283b c0283b = (C0283b) it;
            if (c0283b.hasNext()) {
                sb.append(((Map.Entry) c0283b.next()).toString());
                if (c0283b.hasNext()) {
                    sb.append(", ");
                }
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
