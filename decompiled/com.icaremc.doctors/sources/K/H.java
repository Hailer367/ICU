package K;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class H extends V0.h implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public Serializable f372c;

    /* renamed from: d, reason: collision with root package name */
    public int f373d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.q f374e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Q f375f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.p f376g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(kotlin.jvm.internal.q qVar, Q q, kotlin.jvm.internal.p pVar, T0.d dVar) {
        super(1, dVar);
        this.f374e = qVar;
        this.f375f = q;
        this.f376g = pVar;
    }

    @Override // V0.a
    public final T0.d create(T0.d dVar) {
        return new H(this.f374e, this.f375f, this.f376g, dVar);
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        return ((H) create((T0.d) obj)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        if (r9 != r0) goto L30;
     */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            U0.a r0 = U0.a.f780c
            int r1 = r8.f373d
            kotlin.jvm.internal.p r2 = r8.f376g
            kotlin.jvm.internal.q r3 = r8.f374e
            r4 = 3
            r5 = 2
            K.Q r6 = r8.f375f
            r7 = 1
            if (r1 == 0) goto L36
            if (r1 == r7) goto L2e
            if (r1 == r5) goto L26
            if (r1 != r4) goto L1e
            java.io.Serializable r0 = r8.f372c
            r2 = r0
            kotlin.jvm.internal.p r2 = (kotlin.jvm.internal.p) r2
            a.AbstractC0051a.V(r9)
            goto L6d
        L1e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L26:
            java.io.Serializable r1 = r8.f372c
            kotlin.jvm.internal.p r1 = (kotlin.jvm.internal.p) r1
            a.AbstractC0051a.V(r9)     // Catch: K.C0027b -> L60
            goto L57
        L2e:
            java.io.Serializable r1 = r8.f372c
            kotlin.jvm.internal.q r1 = (kotlin.jvm.internal.q) r1
            a.AbstractC0051a.V(r9)     // Catch: K.C0027b -> L60
            goto L45
        L36:
            a.AbstractC0051a.V(r9)
            r8.f372c = r3     // Catch: K.C0027b -> L60
            r8.f373d = r7     // Catch: K.C0027b -> L60
            java.lang.Object r9 = r6.j(r8)     // Catch: K.C0027b -> L60
            if (r9 != r0) goto L44
            goto L6c
        L44:
            r1 = r3
        L45:
            r1.f2789c = r9     // Catch: K.C0027b -> L60
            K.l0 r9 = r6.f()     // Catch: K.C0027b -> L60
            r8.f372c = r2     // Catch: K.C0027b -> L60
            r8.f373d = r5     // Catch: K.C0027b -> L60
            java.lang.Integer r9 = r9.a()     // Catch: K.C0027b -> L60
            if (r9 != r0) goto L56
            goto L6c
        L56:
            r1 = r2
        L57:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch: K.C0027b -> L60
            int r9 = r9.intValue()     // Catch: K.C0027b -> L60
            r1.f2788c = r9     // Catch: K.C0027b -> L60
            goto L75
        L60:
            java.lang.Object r9 = r3.f2789c
            r8.f372c = r2
            r8.f373d = r4
            java.lang.Object r9 = r6.k(r9, r7, r8)
            if (r9 != r0) goto L6d
        L6c:
            return r0
        L6d:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r2.f2788c = r9
        L75:
            Q0.j r9 = Q0.j.f722a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: K.H.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
