package O;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class W implements InterfaceC0072a {

    /* renamed from: a, reason: collision with root package name */
    public final File f1155a;

    /* renamed from: b, reason: collision with root package name */
    public final i0 f1156b;

    /* renamed from: c, reason: collision with root package name */
    public final S f1157c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f1158d;

    /* renamed from: e, reason: collision with root package name */
    public final j3.c f1159e;

    public W(File file, i0 i0Var, S s3) {
        T2.h.e(i0Var, "coordinator");
        this.f1155a = file;
        this.f1156b = i0Var;
        this.f1157c = s3;
        this.f1158d = new AtomicBoolean(false);
        this.f1159e = new j3.c();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(3:10|11|12)(2:32|33))(2:34|(7:36|37|38|40|41|42|(1:44)(1:45))(2:54|55))|13|14|15|(2:(1:18)|19)(1:21)))|57|6|7|(0)(0)|13|14|15|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077 A[Catch: all -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0077, B:31:0x0084, B:28:0x0087, B:27:0x007f), top: B:7:0x001e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14, types: [O.W] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2, types: [O.U, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [O.W] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [O.r] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(O.r r6, M2.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof O.U
            if (r0 == 0) goto L13
            r0 = r7
            O.U r0 = (O.U) r0
            int r1 = r0.f1148n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1148n = r1
            goto L18
        L13:
            O.U r0 = new O.U
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f1146l
            int r1 = r0.f1148n
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            boolean r6 = r0.k
            O.P r1 = r0.f1145j
            O.W r0 = r0.f1144i
            k3.b.A(r7)     // Catch: java.lang.Throwable -> L2c
            goto L67
        L2c:
            r7 = move-exception
            goto L7f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            k3.b.A(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.f1158d
            boolean r7 = r7.get()
            if (r7 != 0) goto L95
            j3.c r7 = r5.f1159e
            boolean r7 = r7.d()
            O.P r1 = new O.P     // Catch: java.lang.Throwable -> L88
            java.io.File r4 = r5.f1155a     // Catch: java.lang.Throwable -> L88
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L88
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.Throwable -> L7a
            r0.f1144i = r5     // Catch: java.lang.Throwable -> L7a
            r0.f1145j = r1     // Catch: java.lang.Throwable -> L7a
            r0.k = r7     // Catch: java.lang.Throwable -> L7a
            r0.f1148n = r2     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r6 = r6.c(r1, r4, r0)     // Catch: java.lang.Throwable -> L7a
            L2.a r0 = L2.a.f1019f
            if (r6 != r0) goto L63
            return r0
        L63:
            r0 = r7
            r7 = r6
            r6 = r0
            r0 = r5
        L67:
            r1.close()     // Catch: java.lang.Throwable -> L6c
            r1 = r3
            goto L6d
        L6c:
            r1 = move-exception
        L6d:
            if (r1 != 0) goto L77
            if (r6 == 0) goto L76
            j3.c r6 = r0.f1159e
            r6.e(r3)
        L76:
            return r7
        L77:
            throw r1     // Catch: java.lang.Throwable -> L78
        L78:
            r7 = move-exception
            goto L8d
        L7a:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r0
            r0 = r5
        L7f:
            r1.close()     // Catch: java.lang.Throwable -> L83
            goto L87
        L83:
            r1 = move-exception
            f1.AbstractC0286a.a(r7, r1)     // Catch: java.lang.Throwable -> L78
        L87:
            throw r7     // Catch: java.lang.Throwable -> L78
        L88:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r0
            r0 = r5
        L8d:
            if (r6 == 0) goto L94
            j3.c r6 = r0.f1159e
            r6.e(r3)
        L94:
            throw r7
        L95:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "StorageConnection has already been disposed."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: O.W.a(O.r, M2.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d9 A[Catch: all -> 0x0114, IOException -> 0x0117, TRY_ENTER, TryCatch #8 {IOException -> 0x0117, all -> 0x0114, blocks: (B:18:0x00d9, B:20:0x00df, B:22:0x00e7, B:25:0x00f3, B:26:0x0113, B:28:0x00ec, B:31:0x0122, B:41:0x012c, B:38:0x012f), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0122 A[Catch: all -> 0x0114, IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x0117, all -> 0x0114, blocks: (B:18:0x00d9, B:20:0x00df, B:22:0x00e7, B:25:0x00f3, B:26:0x0113, B:28:0x00ec, B:31:0x0122, B:41:0x012c, B:38:0x012f), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r10v28, types: [j3.a] */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v8, types: [S2.p] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r7v2, types: [O.P, java.lang.Object, O.Y] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(O.M r10, M2.c r11) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O.W.b(O.M, M2.c):java.lang.Object");
    }

    @Override // O.InterfaceC0072a
    public final void close() {
        this.f1158d.set(true);
        this.f1157c.a();
    }
}
