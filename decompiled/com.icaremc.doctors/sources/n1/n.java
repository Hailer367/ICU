package n1;

/* loaded from: classes.dex */
public final class n extends c {

    /* renamed from: m, reason: collision with root package name */
    public final a f3348m;

    public n(int i2, a aVar) {
        super(i2);
        this.f3348m = aVar;
        if (aVar != a.f3306c) {
            if (i2 >= 1) {
                return;
            }
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i2 + " was specified").toString());
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + kotlin.jvm.internal.r.a(c.class).b() + " instead").toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            n1.a r1 = r15.f3348m
            n1.a r2 = n1.a.f3308e
            Q0.j r8 = Q0.j.f722a
            if (r1 != r2) goto L17
            java.lang.Object r1 = super.i(r16)
            boolean r2 = r1 instanceof n1.i
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof n1.h
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            F.h r6 = n1.e.f3327d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = n1.c.f3317h
            java.lang.Object r1 = r1.get(r15)
            n1.k r1 = (n1.k) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = n1.c.f3313d
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.r(r2, r7)
            int r9 = n1.e.f3325b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f3542c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            n1.k r2 = n1.c.a(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.o()
            n1.h r2 = new n1.h
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = n1.c.d(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.a()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = n1.c.f3314e
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.a()
        L7e:
            java.lang.Throwable r1 = r15.o()
            n1.h r2 = new n1.h
            r2.<init>(r1)
            return r2
        L88:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L90:
            if (r7 == 0) goto L9f
            r1.h()
            java.lang.Throwable r1 = r15.o()
            n1.h r2 = new n1.h
            r2.<init>(r1)
            return r2
        L9f:
            boolean r3 = r6 instanceof l1.j0
            if (r3 == 0) goto La6
            l1.j0 r6 = (l1.j0) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.a(r1, r12)
        Lae:
            long r3 = r1.f3542c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.j(r3)
        Lb6:
            return r8
        Lb7:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.n.D(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // n1.c, n1.t
    public final Object h(T0.d dVar, Object obj) {
        if (!(D(obj, true) instanceof h)) {
            return Q0.j.f722a;
        }
        throw o();
    }

    @Override // n1.c, n1.t
    public final Object i(Object obj) {
        return D(obj, false);
    }

    @Override // n1.c
    public final boolean t() {
        if (this.f3348m == a.f3307d) {
            return true;
        }
        return false;
    }
}
