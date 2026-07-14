package q;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: q.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0592f implements Iterable {

    /* renamed from: f, reason: collision with root package name */
    public C0589c f5849f;

    /* renamed from: g, reason: collision with root package name */
    public C0589c f5850g;

    /* renamed from: h, reason: collision with root package name */
    public final WeakHashMap f5851h = new WeakHashMap();

    /* renamed from: i, reason: collision with root package name */
    public int f5852i = 0;

    public C0589c a(Object obj) {
        C0589c c0589c = this.f5849f;
        while (c0589c != null && !c0589c.f5842f.equals(obj)) {
            c0589c = c0589c.f5844h;
        }
        return c0589c;
    }

    public Object b(Object obj) {
        C0589c a4 = a(obj);
        if (a4 == null) {
            return null;
        }
        this.f5852i--;
        WeakHashMap weakHashMap = this.f5851h;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((AbstractC0591e) it.next()).a(a4);
            }
        }
        C0589c c0589c = a4.f5845i;
        if (c0589c != null) {
            c0589c.f5844h = a4.f5844h;
        } else {
            this.f5849f = a4.f5844h;
        }
        C0589c c0589c2 = a4.f5844h;
        if (c0589c2 != null) {
            c0589c2.f5845i = c0589c;
        } else {
            this.f5850g = c0589c;
        }
        a4.f5844h = null;
        a4.f5845i = null;
        return a4.f5843g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (((q.C0588b) r7).hasNext() != false) goto L28;
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
            boolean r1 = r7 instanceof q.C0592f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            q.f r7 = (q.C0592f) r7
            int r1 = r6.f5852i
            int r3 = r7.f5852i
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            q.b r3 = (q.C0588b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            q.b r4 = (q.C0588b) r4
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
            q.b r7 = (q.C0588b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q.C0592f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i4 = 0;
        while (true) {
            C0588b c0588b = (C0588b) it;
            if (c0588b.hasNext()) {
                i4 += ((Map.Entry) c0588b.next()).hashCode();
            } else {
                return i4;
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        C0588b c0588b = new C0588b(this.f5849f, this.f5850g, 0);
        this.f5851h.put(c0588b, Boolean.FALSE);
        return c0588b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            C0588b c0588b = (C0588b) it;
            if (c0588b.hasNext()) {
                sb.append(((Map.Entry) c0588b.next()).toString());
                if (c0588b.hasNext()) {
                    sb.append(", ");
                }
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
