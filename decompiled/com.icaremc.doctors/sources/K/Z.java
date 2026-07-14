package K;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class Z implements InterfaceC0026a {

    /* renamed from: a, reason: collision with root package name */
    public final File f446a;

    /* renamed from: b, reason: collision with root package name */
    public final l0 f447b;

    /* renamed from: c, reason: collision with root package name */
    public final V f448c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f449d;

    /* renamed from: e, reason: collision with root package name */
    public final t1.c f450e;

    public Z(File file, l0 coordinator, V v2) {
        kotlin.jvm.internal.h.e(coordinator, "coordinator");
        this.f446a = file;
        this.f447b = coordinator;
        this.f448c = v2;
        this.f449d = new AtomicBoolean(false);
        this.f450e = new t1.c();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(3:10|11|12)(2:32|33))(2:34|(6:36|37|38|40|41|(1:43)(1:44))(2:53|54))|13|14|15|(2:(1:18)|19)(1:21)))|56|6|7|(0)(0)|13|14|15|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078 A[Catch: all -> 0x0079, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0079, blocks: (B:21:0x0078, B:31:0x0086, B:28:0x0089, B:27:0x0081), top: B:7:0x0020, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13, types: [K.Z] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [K.X, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [K.Z] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [K.r] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(K.r r7, V0.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof K.X
            if (r0 == 0) goto L13
            r0 = r8
            K.X r0 = (K.X) r0
            int r1 = r0.f438h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f438h = r1
            goto L18
        L13:
            K.X r0 = new K.X
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f436f
            U0.a r1 = U0.a.f780c
            int r2 = r0.f438h
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            boolean r7 = r0.f435e
            K.T r1 = r0.f434d
            K.Z r0 = r0.f433c
            a.AbstractC0051a.V(r8)     // Catch: java.lang.Throwable -> L2e
            goto L68
        L2e:
            r8 = move-exception
            goto L81
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            a.AbstractC0051a.V(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r6.f449d
            boolean r8 = r8.get()
            if (r8 != 0) goto L97
            t1.c r8 = r6.f450e
            boolean r8 = r8.d()
            K.T r2 = new K.T     // Catch: java.lang.Throwable -> L8a
            java.io.File r5 = r6.f446a     // Catch: java.lang.Throwable -> L8a
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L8a
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L7b
            r0.f433c = r6     // Catch: java.lang.Throwable -> L7b
            r0.f434d = r2     // Catch: java.lang.Throwable -> L7b
            r0.f435e = r8     // Catch: java.lang.Throwable -> L7b
            r0.f438h = r3     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r7 = r7.a(r2, r5, r0)     // Catch: java.lang.Throwable -> L7b
            if (r7 != r1) goto L63
            return r1
        L63:
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
            r1 = r2
        L68:
            r1.close()     // Catch: java.lang.Throwable -> L6d
            r1 = r4
            goto L6e
        L6d:
            r1 = move-exception
        L6e:
            if (r1 != 0) goto L78
            if (r7 == 0) goto L77
            t1.c r7 = r0.f450e
            r7.e(r4)
        L77:
            return r8
        L78:
            throw r1     // Catch: java.lang.Throwable -> L79
        L79:
            r8 = move-exception
            goto L8f
        L7b:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
            r1 = r2
        L81:
            r1.close()     // Catch: java.lang.Throwable -> L85
            goto L89
        L85:
            r1 = move-exception
            android.support.v4.media.session.a.c(r8, r1)     // Catch: java.lang.Throwable -> L79
        L89:
            throw r8     // Catch: java.lang.Throwable -> L79
        L8a:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L8f:
            if (r7 == 0) goto L96
            t1.c r7 = r0.f450e
            r7.e(r4)
        L96:
            throw r8
        L97:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "StorageConnection has already been disposed."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Z.a(K.r, V0.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(7:(2:3|(11:5|6|7|(1:(1:(7:11|12|13|14|15|16|(4:18|(3:20|(1:22)(1:28)|(1:24)(2:25|26))|29|30)(1:31))(2:42|43))(1:44))(2:62|(5:64|(2:66|(2:68|69))|70|(1:72)|51)(2:73|74))|45|46|47|48|49|(5:52|14|15|16|(0)(0))|51))|46|47|48|49|(0)|51)|7|(0)(0)|45) */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0118, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0119, code lost:
    
        r12 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00db A[Catch: all -> 0x0116, IOException -> 0x0118, TRY_ENTER, TryCatch #0 {IOException -> 0x0118, blocks: (B:18:0x00db, B:20:0x00e1, B:22:0x00e9, B:25:0x00f5, B:26:0x0115, B:28:0x00ee, B:31:0x0123, B:41:0x012d, B:38:0x0130), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0123 A[Catch: all -> 0x0116, IOException -> 0x0118, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x0118, blocks: (B:18:0x00db, B:20:0x00e1, B:22:0x00e9, B:25:0x00f5, B:26:0x0115, B:28:0x00ee, B:31:0x0123, B:41:0x012d, B:38:0x0130), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2, types: [K.T, K.b0, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(K.P r11, V0.c r12) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K.Z.b(K.P, V0.c):java.lang.Object");
    }

    @Override // K.InterfaceC0026a
    public final void close() {
        this.f449d.set(true);
        this.f448c.invoke();
    }
}
