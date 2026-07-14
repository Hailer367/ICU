package d3;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class k extends g3.r {

    /* renamed from: e, reason: collision with root package name */
    public final c f3532e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f3533f;

    public k(long j4, k kVar, c cVar, int i4) {
        super(j4, kVar, i4);
        this.f3532e = cVar;
        this.f3533f = new AtomicReferenceArray(e.f3510b * 2);
    }

    @Override // g3.r
    public final int f() {
        return e.f3510b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0059, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x005e, code lost:
    
        T2.h.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    @Override // g3.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, K2.i r6) {
        /*
            r4 = this;
            int r6 = d3.e.f3510b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f3533f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof b3.i0
            d3.c r2 = r4.f3532e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof d3.u
            if (r1 == 0) goto L21
            goto L62
        L21:
            R1.c r1 = d3.e.f3518j
            if (r6 == r1) goto L59
            R1.c r1 = d3.e.k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            R1.c r1 = d3.e.f3515g
            if (r6 == r1) goto L11
            R1.c r1 = d3.e.f3514f
            if (r6 != r1) goto L33
            goto L11
        L33:
            R1.c r5 = d3.e.f3517i
            if (r6 == r5) goto L7c
            R1.c r5 = d3.e.f3512d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            R1.c r5 = d3.e.f3519l
            if (r6 != r5) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L59:
            r4.m(r5, r3)
            if (r0 == 0) goto L7c
            T2.h.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            R1.c r1 = d3.e.f3518j
            goto L69
        L67:
            R1.c r1 = d3.e.k
        L69:
            boolean r6 = r4.j(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L7c
            T2.h.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.k.g(int, K2.i):void");
    }

    public final boolean j(int i4, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i5 = (i4 * 2) + 1;
        do {
            atomicReferenceArray = this.f3533f;
            if (atomicReferenceArray.compareAndSet(i5, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i5) == obj);
        return false;
    }

    public final Object k(int i4) {
        return this.f3533f.get((i4 * 2) + 1);
    }

    public final void l(int i4, boolean z) {
        if (z) {
            c cVar = this.f3532e;
            T2.h.b(cVar);
            cVar.C((this.f3807c * e.f3510b) + i4);
        }
        h();
    }

    public final void m(int i4, Object obj) {
        this.f3533f.set(i4 * 2, obj);
    }

    public final void n(int i4, Object obj) {
        this.f3533f.set((i4 * 2) + 1, obj);
    }
}
