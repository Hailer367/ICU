package K;

import com.google.android.gms.common.api.Api;
import java.util.List;
import l1.AbstractC0244w;
import l1.C0232j;
import l1.C0241t;
import l1.InterfaceC0242u;

/* loaded from: classes.dex */
public final class Q implements InterfaceC0034i {

    /* renamed from: c, reason: collision with root package name */
    public final W f407c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0028c f408d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0242u f409e;

    /* renamed from: h, reason: collision with root package name */
    public int f412h;

    /* renamed from: i, reason: collision with root package name */
    public l1.c0 f413i;

    /* renamed from: k, reason: collision with root package name */
    public final B0.q f415k;

    /* renamed from: l, reason: collision with root package name */
    public final Q0.h f416l;

    /* renamed from: m, reason: collision with root package name */
    public final Q0.h f417m;

    /* renamed from: n, reason: collision with root package name */
    public final B0.q f418n;

    /* renamed from: f, reason: collision with root package name */
    public final C0045u f410f = new C0045u(new C0046v(this, null));

    /* renamed from: g, reason: collision with root package name */
    public final t1.c f411g = new t1.c();

    /* renamed from: j, reason: collision with root package name */
    public final F.h f414j = new F.h(3);

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, B0.q] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object, B0.q] */
    public Q(W w2, List list, InterfaceC0028c interfaceC0028c, InterfaceC0242u interfaceC0242u) {
        this.f407c = w2;
        this.f408d = interfaceC0028c;
        this.f409e = interfaceC0242u;
        ?? obj = new Object();
        obj.f133f = this;
        obj.f130c = new t1.c();
        l1.X x2 = new l1.X(true);
        x2.B(null);
        obj.f131d = x2;
        obj.f132e = R0.j.U(list);
        this.f415k = obj;
        this.f416l = new Q0.h(new C0039n(this, 1));
        this.f417m = new Q0.h(new C0039n(this, 0));
        M m2 = new M(0, this);
        N n2 = new N(this, null);
        ?? obj2 = new Object();
        obj2.f130c = interfaceC0242u;
        obj2.f131d = n2;
        obj2.f132e = n1.j.a(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, 6);
        obj2.f133f = new F.h(2);
        l1.O o2 = (l1.O) interfaceC0242u.e().k(C0241t.f3012d);
        if (o2 != null) {
            ((l1.X) o2).C(true, new C0232j(1, new g0(m2, obj2)));
        }
        this.f418n = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x0058, TryCatch #0 {all -> 0x0058, blocks: (B:12:0x0048, B:14:0x0050, B:16:0x0054, B:17:0x005a), top: B:11:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(K.Q r4, V0.c r5) {
        /*
            boolean r0 = r5 instanceof K.C0047w
            if (r0 == 0) goto L13
            r0 = r5
            K.w r0 = (K.C0047w) r0
            int r1 = r0.f559g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f559g = r1
            goto L18
        L13:
            K.w r0 = new K.w
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f557e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f559g
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            t1.c r4 = r0.f556d
            K.Q r0 = r0.f555c
            a.AbstractC0051a.V(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            a.AbstractC0051a.V(r5)
            t1.c r5 = r4.f411g
            r0.f555c = r4
            r0.f556d = r5
            r0.f559g = r3
            java.lang.Object r0 = r5.c(r0)
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.f412h     // Catch: java.lang.Throwable -> L58
            int r1 = r1 + (-1)
            r4.f412h = r1     // Catch: java.lang.Throwable -> L58
            if (r1 != 0) goto L5c
            l1.c0 r1 = r4.f413i     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L5a
            r1.b(r0)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r4 = move-exception
            goto L62
        L5a:
            r4.f413i = r0     // Catch: java.lang.Throwable -> L58
        L5c:
            r5.e(r0)
            Q0.j r4 = Q0.j.f722a
            return r4
        L62:
            r5.e(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Q.a(K.Q, V0.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|(7:55|(1:(1:(1:59)(2:61|62))(3:63|64|65))(1:66)|60|17|(1:19)(1:23)|20|21)(5:8|9|10|(3:12|13|14)(3:30|(1:32)(1:53)|(2:34|(2:36|(1:38))(2:45|46))(2:47|(2:49|50)(2:51|52)))|24)|39|40|41))|68|6|(0)(0)|39|40|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0076, code lost:
    
        if (r9 == r1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0079, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ba, code lost:
    
        if (r9 != r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0052  */
    /* JADX WARN: Type inference failed for: r2v3, types: [V0.h, c1.p] */
    /* JADX WARN: Type inference failed for: r2v9, types: [V0.h, c1.p] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(K.Q r9, K.d0 r10, V0.c r11) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Q.b(K.Q, K.d0, V0.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #0 {all -> 0x005d, blocks: (B:12:0x0048, B:14:0x004f), top: B:11:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(K.Q r4, V0.c r5) {
        /*
            boolean r0 = r5 instanceof K.C0050z
            if (r0 == 0) goto L13
            r0 = r5
            K.z r0 = (K.C0050z) r0
            int r1 = r0.f572g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f572g = r1
            goto L18
        L13:
            K.z r0 = new K.z
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f570e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f572g
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            t1.c r4 = r0.f569d
            K.Q r0 = r0.f568c
            a.AbstractC0051a.V(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            a.AbstractC0051a.V(r5)
            t1.c r5 = r4.f411g
            r0.f568c = r4
            r0.f569d = r5
            r0.f572g = r3
            java.lang.Object r0 = r5.c(r0)
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.f412h     // Catch: java.lang.Throwable -> L5d
            int r1 = r1 + r3
            r4.f412h = r1     // Catch: java.lang.Throwable -> L5d
            if (r1 != r3) goto L5f
            l1.u r1 = r4.f409e     // Catch: java.lang.Throwable -> L5d
            K.A r2 = new K.A     // Catch: java.lang.Throwable -> L5d
            r2.<init>(r4, r0)     // Catch: java.lang.Throwable -> L5d
            l1.c0 r1 = l1.AbstractC0244w.f(r1, r2)     // Catch: java.lang.Throwable -> L5d
            r4.f413i = r1     // Catch: java.lang.Throwable -> L5d
            goto L5f
        L5d:
            r4 = move-exception
            goto L65
        L5f:
            r5.e(r0)
            Q0.j r4 = Q0.j.f722a
            return r4
        L65:
            r5.e(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Q.c(K.Q, V0.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(K.Q r8, boolean r9, T0.d r10) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Q.d(K.Q, boolean, T0.d):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|72|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x005f, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013b A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:27:0x0129, B:29:0x013b, B:32:0x0143), top: B:26:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143 A[Catch: all -> 0x0167, TRY_LEAVE, TryCatch #1 {all -> 0x0167, blocks: (B:27:0x0129, B:29:0x013b, B:32:0x0143), top: B:26:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f A[Catch: b -> 0x005f, TryCatch #0 {b -> 0x005f, blocks: (B:36:0x005a, B:37:0x00fe, B:40:0x0068, B:41:0x00e0, B:56:0x0085, B:58:0x009f, B:59:0x00a5, B:65:0x008e, B:68:0x00cd), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlin.jvm.internal.p, java.lang.Object, java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.q, java.lang.Object, java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(K.Q r9, boolean r10, V0.c r11) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Q.e(K.Q, boolean, V0.c):java.lang.Object");
    }

    public final l0 f() {
        return (l0) this.f417m.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        if (r4.d(r0) != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(V0.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof K.B
            if (r0 == 0) goto L13
            r0 = r6
            K.B r0 = (K.B) r0
            int r1 = r0.f343g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f343g = r1
            goto L18
        L13:
            K.B r0 = new K.B
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f341e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f343g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            int r1 = r0.f340d
            K.Q r0 = r0.f339c
            a.AbstractC0051a.V(r6)     // Catch: java.lang.Throwable -> L2e
            goto L66
        L2e:
            r6 = move-exception
            goto L6d
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            K.Q r2 = r0.f339c
            a.AbstractC0051a.V(r6)
            goto L51
        L3e:
            a.AbstractC0051a.V(r6)
            K.l0 r6 = r5.f()
            r0.f339c = r5
            r0.f343g = r4
            java.lang.Integer r6 = r6.a()
            if (r6 != r1) goto L50
            goto L65
        L50:
            r2 = r5
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            B0.q r4 = r2.f415k     // Catch: java.lang.Throwable -> L69
            r0.f339c = r2     // Catch: java.lang.Throwable -> L69
            r0.f340d = r6     // Catch: java.lang.Throwable -> L69
            r0.f343g = r3     // Catch: java.lang.Throwable -> L69
            java.lang.Object r6 = r4.d(r0)     // Catch: java.lang.Throwable -> L69
            if (r6 != r1) goto L66
        L65:
            return r1
        L66:
            Q0.j r6 = Q0.j.f722a
            return r6
        L69:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L6d:
            F.h r0 = r0.f414j
            K.e0 r2 = new K.e0
            r2.<init>(r6, r1)
            r0.m(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Q.g(V0.c):java.lang.Object");
    }

    @Override // K.InterfaceC0034i
    public final Object h(c1.p pVar, T0.d dVar) {
        q0 q0Var = (q0) dVar.getContext().k(p0.f536c);
        if (q0Var != null) {
            q0Var.e(this);
        }
        return AbstractC0244w.m(new q0(q0Var, this), new L(this, pVar, null), dVar);
    }

    @Override // K.InterfaceC0034i
    public final o1.d i() {
        return this.f410f;
    }

    public final Object j(V0.c cVar) {
        return ((Z) this.f416l.a()).a(new r(3, (T0.d) null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.jvm.internal.p, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r11, boolean r12, V0.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof K.O
            if (r0 == 0) goto L13
            r0 = r13
            K.O r0 = (K.O) r0
            int r1 = r0.f399f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f399f = r1
            goto L18
        L13:
            K.O r0 = new K.O
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f397d
            U0.a r1 = U0.a.f780c
            int r2 = r0.f399f
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.jvm.internal.p r11 = r0.f396c
            a.AbstractC0051a.V(r13)
            goto L56
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            a.AbstractC0051a.V(r13)
            kotlin.jvm.internal.p r5 = new kotlin.jvm.internal.p
            r5.<init>()
            Q0.h r13 = r10.f416l
            java.lang.Object r13 = r13.a()
            K.Z r13 = (K.Z) r13
            K.P r4 = new K.P
            r9 = 0
            r6 = r10
            r7 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f396c = r5
            r0.f399f = r3
            java.lang.Object r11 = r13.b(r4, r0)
            if (r11 != r1) goto L55
            return r1
        L55:
            r11 = r5
        L56:
            int r11 = r11.f2788c
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Q.k(java.lang.Object, boolean, V0.c):java.lang.Object");
    }
}
