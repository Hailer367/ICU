package B0;

import android.content.Context;
import android.util.SparseArray;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Executor;
import r.C0295g;

/* loaded from: classes.dex */
public final class q implements x0.b {

    /* renamed from: c, reason: collision with root package name */
    public Object f130c;

    /* renamed from: d, reason: collision with root package name */
    public Object f131d;

    /* renamed from: e, reason: collision with root package name */
    public Object f132e;

    /* renamed from: f, reason: collision with root package name */
    public Object f133f;

    public q(int i2) {
        switch (i2) {
            case 4:
                A0.f fVar = new A0.f(21);
                A0.f fVar2 = new A0.f(20);
                this.f130c = new HashSet();
                this.f131d = fVar;
                this.f132e = fVar2;
                return;
            default:
                this.f130c = new r.j(0);
                this.f131d = new SparseArray();
                this.f132e = new C0295g();
                this.f133f = new r.j(0);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(V0.c r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f133f
            K.Q r0 = (K.Q) r0
            boolean r1 = r7 instanceof K.C0035j
            if (r1 == 0) goto L17
            r1 = r7
            K.j r1 = (K.C0035j) r1
            int r2 = r1.f498f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.f498f = r2
            goto L1c
        L17:
            K.j r1 = new K.j
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f496d
            U0.a r2 = U0.a.f780c
            int r3 = r1.f498f
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L3e
            if (r3 == r5) goto L38
            if (r3 != r4) goto L30
            B0.q r0 = r1.f495c
            a.AbstractC0051a.V(r7)
            goto L64
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            B0.q r0 = r1.f495c
            a.AbstractC0051a.V(r7)
            goto L74
        L3e:
            a.AbstractC0051a.V(r7)
            java.lang.Object r7 = r6.f132e
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L67
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4e
            goto L67
        L4e:
            K.l0 r7 = r0.f()
            K.m r3 = new K.m
            r5 = 0
            r3.<init>(r0, r6, r5)
            r1.f495c = r6
            r1.f498f = r4
            java.lang.Object r7 = r7.b(r3, r1)
            if (r7 != r2) goto L63
            goto L72
        L63:
            r0 = r6
        L64:
            K.d r7 = (K.C0029d) r7
            goto L76
        L67:
            r1.f495c = r6
            r1.f498f = r5
            r7 = 0
            java.lang.Object r7 = K.Q.e(r0, r7, r1)
            if (r7 != r2) goto L73
        L72:
            return r2
        L73:
            r0 = r6
        L74:
            K.d r7 = (K.C0029d) r7
        L76:
            java.lang.Object r0 = r0.f133f
            K.Q r0 = (K.Q) r0
            F.h r0 = r0.f414j
            r0.m(r7)
            Q0.j r7 = Q0.j.f722a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.q.a(V0.c):java.lang.Object");
    }

    public File b(Context context) {
        ((A0.f) this.f131d).getClass();
        return new File(context.getDir("lib", 0), System.mapLibraryName("flutter"));
    }

    public void c(String str, Object... objArr) {
        String format = String.format(Locale.US, str, objArr);
        if (((C0.f) this.f133f) != null) {
            Log.d(FlutterJNI.TAG, format);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[Catch: all -> 0x009f, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x009f, blocks: (B:25:0x006c, B:29:0x0083), top: B:24:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r2v7, types: [t1.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(V0.c r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof K.f0
            if (r0 == 0) goto L13
            r0 = r9
            K.f0 r0 = (K.f0) r0
            int r1 = r0.f475g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f475g = r1
            goto L18
        L13:
            K.f0 r0 = new K.f0
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f473e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f475g
            r3 = 2
            r4 = 1
            Q0.j r5 = Q0.j.f722a
            r6 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            t1.a r1 = r0.f472d
            B0.q r0 = r0.f471c
            a.AbstractC0051a.V(r9)     // Catch: java.lang.Throwable -> L31
            goto L92
        L31:
            r9 = move-exception
            goto La2
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3c:
            t1.a r2 = r0.f472d
            B0.q r4 = r0.f471c
            a.AbstractC0051a.V(r9)
            r9 = r2
            goto L6c
        L45:
            a.AbstractC0051a.V(r9)
            java.lang.Object r9 = r8.f131d
            l1.n r9 = (l1.C0236n) r9
            r9.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = l1.X.f2976c
            java.lang.Object r9 = r2.get(r9)
            boolean r9 = r9 instanceof l1.L
            if (r9 != 0) goto L5a
            return r5
        L5a:
            java.lang.Object r9 = r8.f130c
            t1.c r9 = (t1.c) r9
            r0.f471c = r8
            r0.f472d = r9
            r0.f475g = r4
            java.lang.Object r2 = r9.c(r0)
            if (r2 != r1) goto L6b
            goto L8f
        L6b:
            r4 = r8
        L6c:
            java.lang.Object r2 = r4.f131d     // Catch: java.lang.Throwable -> L9f
            l1.n r2 = (l1.C0236n) r2     // Catch: java.lang.Throwable -> L9f
            r2.getClass()     // Catch: java.lang.Throwable -> L9f
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = l1.X.f2976c     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r2 = r7.get(r2)     // Catch: java.lang.Throwable -> L9f
            boolean r2 = r2 instanceof l1.L     // Catch: java.lang.Throwable -> L9f
            if (r2 != 0) goto L83
            t1.c r9 = (t1.c) r9
            r9.e(r6)
            return r5
        L83:
            r0.f471c = r4     // Catch: java.lang.Throwable -> L9f
            r0.f472d = r9     // Catch: java.lang.Throwable -> L9f
            r0.f475g = r3     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r0 = r4.a(r0)     // Catch: java.lang.Throwable -> L9f
            if (r0 != r1) goto L90
        L8f:
            return r1
        L90:
            r1 = r9
            r0 = r4
        L92:
            java.lang.Object r9 = r0.f131d     // Catch: java.lang.Throwable -> L31
            l1.n r9 = (l1.C0236n) r9     // Catch: java.lang.Throwable -> L31
            r9.E(r5)     // Catch: java.lang.Throwable -> L31
            t1.c r1 = (t1.c) r1
            r1.e(r6)
            return r5
        L9f:
            r0 = move-exception
            r1 = r9
            r9 = r0
        La2:
            t1.c r1 = (t1.c) r1
            r1.e(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.q.d(V0.c):java.lang.Object");
    }

    @Override // P0.a
    public Object get() {
        return new p((Executor) ((P0.a) this.f130c).get(), (C0.d) ((P0.a) this.f131d).get(), (d) ((A0.g) this.f133f).get(), (D0.c) ((P0.a) this.f132e).get());
    }
}
