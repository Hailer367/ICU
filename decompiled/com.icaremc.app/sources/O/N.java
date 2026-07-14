package O;

import b3.AbstractC0245u;
import b3.C0234i;
import b3.InterfaceC0243s;
import java.util.List;

/* loaded from: classes.dex */
public final class N implements InterfaceC0080i {

    /* renamed from: f, reason: collision with root package name */
    public final T f1120f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC0074c f1121g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC0243s f1122h;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public b3.b0 f1125l;

    /* renamed from: n, reason: collision with root package name */
    public final P1.y f1127n;

    /* renamed from: o, reason: collision with root package name */
    public final H2.g f1128o;

    /* renamed from: p, reason: collision with root package name */
    public final H2.g f1129p;

    /* renamed from: q, reason: collision with root package name */
    public final P1.y f1130q;

    /* renamed from: i, reason: collision with root package name */
    public final R1.c f1123i = new R1.c(new C0090t(this, null));

    /* renamed from: j, reason: collision with root package name */
    public final j3.c f1124j = new j3.c();

    /* renamed from: m, reason: collision with root package name */
    public final R1.c f1126m = new R1.c(8);

    /* JADX WARN: Type inference failed for: r3v4, types: [P1.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [P1.y, java.lang.Object] */
    public N(T t3, List list, InterfaceC0074c interfaceC0074c, InterfaceC0243s interfaceC0243s) {
        this.f1120f = t3;
        this.f1121g = interfaceC0074c;
        this.f1122h = interfaceC0243s;
        ?? obj = new Object();
        obj.f1472i = this;
        obj.f1469f = new j3.c();
        b3.W w2 = new b3.W(true);
        w2.C(null);
        obj.f1470g = w2;
        obj.f1471h = I2.e.I(list);
        this.f1127n = obj;
        this.f1128o = new H2.g(new C0085n(this, 1));
        this.f1129p = new H2.g(new C0085n(this, 0));
        J j4 = new J(this);
        K k = new K(this, null);
        ?? obj2 = new Object();
        obj2.f1469f = interfaceC0243s;
        obj2.f1470g = k;
        obj2.f1471h = d3.j.a(Integer.MAX_VALUE, null, 6);
        obj2.f1472i = new R1.c(7);
        b3.N n3 = (b3.N) interfaceC0243s.f().e(b3.r.f3295g);
        if (n3 != null) {
            ((b3.W) n3).D(true, new C0234i(1, new d0(j4, obj2)));
        }
        this.f1130q = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x0058, TryCatch #0 {all -> 0x0058, blocks: (B:12:0x0048, B:14:0x0050, B:16:0x0054, B:17:0x005a), top: B:11:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(O.N r4, M2.c r5) {
        /*
            boolean r0 = r5 instanceof O.C0091u
            if (r0 == 0) goto L13
            r0 = r5
            O.u r0 = (O.C0091u) r0
            int r1 = r0.f1247m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1247m = r1
            goto L18
        L13:
            O.u r0 = new O.u
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.k
            int r1 = r0.f1247m
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            j3.c r4 = r0.f1245j
            O.N r0 = r0.f1244i
            k3.b.A(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            k3.b.A(r5)
            j3.c r5 = r4.f1124j
            r0.f1244i = r4
            r0.f1245j = r5
            r0.f1247m = r2
            java.lang.Object r0 = r5.c(r0)
            L2.a r1 = L2.a.f1019f
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.k     // Catch: java.lang.Throwable -> L58
            int r1 = r1 + (-1)
            r4.k = r1     // Catch: java.lang.Throwable -> L58
            if (r1 != 0) goto L5c
            b3.b0 r1 = r4.f1125l     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L5a
            r1.b(r0)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r4 = move-exception
            goto L62
        L5a:
            r4.f1125l = r0     // Catch: java.lang.Throwable -> L58
        L5c:
            r5.e(r0)
            H2.i r4 = H2.i.f681a
            return r4
        L62:
            r5.e(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: O.N.b(O.N, M2.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|(7:55|(1:(1:(1:59)(2:61|62))(3:63|64|65))(1:66)|60|17|(1:19)(1:23)|20|21)(5:8|9|10|(3:12|13|14)(3:30|(1:32)(1:53)|(2:34|(2:36|(1:38))(2:45|46))(2:47|(2:49|50)(2:51|52)))|24)|39|40|41))|68|6|(0)(0)|39|40|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0076, code lost:
    
        if (r9 == r6) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0079, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ba, code lost:
    
        if (r9 != r6) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0052  */
    /* JADX WARN: Type inference failed for: r1v3, types: [S2.p, M2.h] */
    /* JADX WARN: Type inference failed for: r1v9, types: [S2.p, M2.h] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(O.N r9, O.a0 r10, M2.c r11) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O.N.c(O.N, O.a0, M2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #0 {all -> 0x005d, blocks: (B:12:0x0048, B:14:0x004f), top: B:11:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(O.N r4, M2.c r5) {
        /*
            boolean r0 = r5 instanceof O.C0093w
            if (r0 == 0) goto L13
            r0 = r5
            O.w r0 = (O.C0093w) r0
            int r1 = r0.f1256m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1256m = r1
            goto L18
        L13:
            O.w r0 = new O.w
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.k
            int r1 = r0.f1256m
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            j3.c r4 = r0.f1254j
            O.N r0 = r0.f1253i
            k3.b.A(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            k3.b.A(r5)
            j3.c r5 = r4.f1124j
            r0.f1253i = r4
            r0.f1254j = r5
            r0.f1256m = r2
            java.lang.Object r0 = r5.c(r0)
            L2.a r1 = L2.a.f1019f
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.k     // Catch: java.lang.Throwable -> L5d
            int r1 = r1 + r2
            r4.k = r1     // Catch: java.lang.Throwable -> L5d
            if (r1 != r2) goto L5f
            b3.s r1 = r4.f1122h     // Catch: java.lang.Throwable -> L5d
            O.y r2 = new O.y     // Catch: java.lang.Throwable -> L5d
            r2.<init>(r4, r0)     // Catch: java.lang.Throwable -> L5d
            b3.b0 r1 = b3.AbstractC0245u.f(r1, r2)     // Catch: java.lang.Throwable -> L5d
            r4.f1125l = r1     // Catch: java.lang.Throwable -> L5d
            goto L5f
        L5d:
            r4 = move-exception
            goto L65
        L5f:
            r5.e(r0)
            H2.i r4 = H2.i.f681a
            return r4
        L65:
            r5.e(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: O.N.d(O.N, M2.c):java.lang.Object");
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
    public static final java.lang.Object e(O.N r8, boolean r9, K2.d r10) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O.N.e(O.N, boolean, K2.d):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|72|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x005f, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013b A[Catch: all -> 0x0168, TryCatch #0 {all -> 0x0168, blocks: (B:27:0x0129, B:29:0x013b, B:32:0x0143), top: B:26:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143 A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #0 {all -> 0x0168, blocks: (B:27:0x0129, B:29:0x013b, B:32:0x0143), top: B:26:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f A[Catch: b -> 0x005f, TryCatch #1 {b -> 0x005f, blocks: (B:36:0x005a, B:37:0x00fe, B:40:0x0068, B:41:0x00e0, B:56:0x0085, B:58:0x009f, B:59:0x00a5, B:65:0x008e, B:68:0x00cd), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r10v4, types: [T2.o, java.lang.Object, java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v1, types: [T2.p, java.lang.Object, java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(O.N r9, boolean r10, M2.c r11) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O.N.f(O.N, boolean, M2.c):java.lang.Object");
    }

    @Override // O.InterfaceC0080i
    public final Object a(S2.p pVar, M2.h hVar) {
        K2.i iVar = hVar.f1052g;
        T2.h.b(iVar);
        n0 n0Var = (n0) iVar.e(m0.f1229f);
        if (n0Var != null) {
            n0Var.d(this);
        }
        return AbstractC0245u.m(new n0(n0Var, this), new I(this, pVar, null), hVar);
    }

    public final i0 g() {
        return (i0) this.f1129p.a();
    }

    @Override // O.InterfaceC0080i
    public final e3.d getData() {
        return this.f1123i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        if (r3.t(r0) != r4) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(M2.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof O.C0096z
            if (r0 == 0) goto L13
            r0 = r7
            O.z r0 = (O.C0096z) r0
            int r1 = r0.f1263m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1263m = r1
            goto L18
        L13:
            O.z r0 = new O.z
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.k
            int r1 = r0.f1263m
            r2 = 2
            r3 = 1
            L2.a r4 = L2.a.f1019f
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L38
            if (r1 != r2) goto L30
            int r1 = r0.f1261j
            O.N r0 = r0.f1260i
            k3.b.A(r7)     // Catch: java.lang.Throwable -> L2e
            goto L66
        L2e:
            r7 = move-exception
            goto L6e
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            O.N r1 = r0.f1260i
            k3.b.A(r7)
            goto L51
        L3e:
            k3.b.A(r7)
            O.i0 r7 = r6.g()
            r0.f1260i = r6
            r0.f1263m = r3
            java.lang.Integer r7 = r7.a()
            if (r7 != r4) goto L50
            goto L65
        L50:
            r1 = r6
        L51:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            P1.y r3 = r1.f1127n     // Catch: java.lang.Throwable -> L69
            r0.f1260i = r1     // Catch: java.lang.Throwable -> L69
            r0.f1261j = r7     // Catch: java.lang.Throwable -> L69
            r0.f1263m = r2     // Catch: java.lang.Throwable -> L69
            java.lang.Object r7 = r3.t(r0)     // Catch: java.lang.Throwable -> L69
            if (r7 != r4) goto L66
        L65:
            return r4
        L66:
            H2.i r7 = H2.i.f681a
            return r7
        L69:
            r0 = move-exception
            r5 = r1
            r1 = r7
            r7 = r0
            r0 = r5
        L6e:
            R1.c r0 = r0.f1126m
            O.b0 r2 = new O.b0
            r2.<init>(r7, r1)
            r0.w(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: O.N.h(M2.c):java.lang.Object");
    }

    public final Object i(M2.c cVar) {
        return ((W) this.f1128o.a()).a(new r(3, (K2.d) null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Type inference failed for: r4v0, types: [T2.o, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r10, boolean r11, M2.c r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof O.L
            if (r0 == 0) goto L13
            r0 = r12
            O.L r0 = (O.L) r0
            int r1 = r0.f1113l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1113l = r1
            goto L18
        L13:
            O.L r0 = new O.L
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.f1112j
            int r1 = r0.f1113l
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            T2.o r10 = r0.f1111i
            k3.b.A(r12)
            goto L56
        L27:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2f:
            k3.b.A(r12)
            T2.o r4 = new T2.o
            r4.<init>()
            H2.g r12 = r9.f1128o
            java.lang.Object r12 = r12.a()
            O.W r12 = (O.W) r12
            O.M r3 = new O.M
            r8 = 0
            r5 = r9
            r6 = r10
            r7 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r0.f1111i = r4
            r0.f1113l = r2
            java.lang.Object r10 = r12.b(r3, r0)
            L2.a r11 = L2.a.f1019f
            if (r10 != r11) goto L55
            return r11
        L55:
            r10 = r4
        L56:
            int r10 = r10.f1644f
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: O.N.j(java.lang.Object, boolean, M2.c):java.lang.Object");
    }
}
