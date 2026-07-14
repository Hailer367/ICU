package n1;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class k extends q1.r {

    /* renamed from: e, reason: collision with root package name */
    public final c f3346e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f3347f;

    public k(long j2, k kVar, c cVar, int i2) {
        super(j2, kVar, i2);
        this.f3346e = cVar;
        this.f3347f = new AtomicReferenceArray(e.f3325b * 2);
    }

    @Override // q1.r
    public final int f() {
        return e.f3325b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0059, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x005e, code lost:
    
        kotlin.jvm.internal.h.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    @Override // q1.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, T0.i r6) {
        /*
            r4 = this;
            int r6 = n1.e.f3325b
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
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f3347f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof l1.j0
            n1.c r2 = r4.f3346e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof n1.u
            if (r1 == 0) goto L21
            goto L62
        L21:
            F.h r1 = n1.e.f3333j
            if (r6 == r1) goto L59
            F.h r1 = n1.e.f3334k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            F.h r1 = n1.e.f3330g
            if (r6 == r1) goto L11
            F.h r1 = n1.e.f3329f
            if (r6 != r1) goto L33
            goto L11
        L33:
            F.h r5 = n1.e.f3332i
            if (r6 == r5) goto L7c
            F.h r5 = n1.e.f3327d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            F.h r5 = n1.e.f3335l
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
            kotlin.jvm.internal.h.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            F.h r1 = n1.e.f3333j
            goto L69
        L67:
            F.h r1 = n1.e.f3334k
        L69:
            boolean r6 = r4.j(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.h.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.k.g(int, T0.i):void");
    }

    public final boolean j(int i2, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i3 = (i2 * 2) + 1;
        do {
            atomicReferenceArray = this.f3347f;
            if (atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i3) == obj);
        return false;
    }

    public final Object k(int i2) {
        return this.f3347f.get((i2 * 2) + 1);
    }

    public final void l(int i2, boolean z) {
        if (z) {
            c cVar = this.f3346e;
            kotlin.jvm.internal.h.b(cVar);
            cVar.C((this.f3542c * e.f3325b) + i2);
        }
        h();
    }

    public final void m(int i2, Object obj) {
        this.f3347f.set(i2 * 2, obj);
    }

    public final void n(int i2, Object obj) {
        this.f3347f.set((i2 * 2) + 1, obj);
    }
}
