package F;

import Z0.AbstractBinderC0135a;
import Z0.E;
import Z0.InterfaceC0139e;
import Z0.r;
import android.app.Application;
import android.graphics.Typeface;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import b3.AbstractC0242q;
import b3.AbstractC0245u;
import j.ExecutorC0400H;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import o.C0496W;
import p1.AbstractC0579h;
import p1.AbstractC0581j;
import p1.C0577f;
import p1.C0582k;
import p1.C0583l;
import p1.C0585n;
import p1.InterfaceC0573b;
import p1.InterfaceC0574c;
import p1.InterfaceC0575d;
import p1.InterfaceC0576e;
import p1.InterfaceC0578g;
import x.AbstractC0703c;
import x.C0702b;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f479f;

    /* renamed from: g, reason: collision with root package name */
    public Object f480g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f481h;

    public /* synthetic */ a(int i4, Object obj, Object obj2) {
        this.f479f = i4;
        this.f480g = obj;
        this.f481h = obj2;
    }

    private final void a() {
        C0583l c0583l = (C0583l) this.f481h;
        synchronized (c0583l.f5830h) {
            try {
                InterfaceC0575d interfaceC0575d = (InterfaceC0575d) c0583l.f5831i;
                if (interfaceC0575d != null) {
                    Exception c4 = ((AbstractC0579h) this.f480g).c();
                    r.e(c4);
                    interfaceC0575d.c(c4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        C0583l c0583l = (C0583l) this.f481h;
        synchronized (c0583l.f5830h) {
            try {
                InterfaceC0576e interfaceC0576e = (InterfaceC0576e) c0583l.f5831i;
                if (interfaceC0576e != null) {
                    interfaceC0576e.e(((AbstractC0579h) this.f480g).d());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
    
        ((java.lang.Runnable) r10.f480g).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
    
        r10.f480g = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        y1.i.k.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f480g), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.f481h     // Catch: java.lang.Throwable -> L58
            y1.i r2 = (y1.i) r2     // Catch: java.lang.Throwable -> L58
            java.util.ArrayDeque r2 = r2.f6580g     // Catch: java.lang.Throwable -> L58
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L58
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.f481h     // Catch: java.lang.Throwable -> L20
            y1.i r0 = (y1.i) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.f6581h     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
        L18:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L46
        L20:
            r0 = move-exception
            goto L7d
        L22:
            long r6 = r0.f6582i     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.f6582i = r6     // Catch: java.lang.Throwable -> L20
            r0.f6581h = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.f481h     // Catch: java.lang.Throwable -> L20
            y1.i r4 = (y1.i) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.f6580g     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            r10.f480g = r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L47
            java.lang.Object r0 = r10.f481h     // Catch: java.lang.Throwable -> L20
            y1.i r0 = (y1.i) r0     // Catch: java.lang.Throwable -> L20
            r0.f6581h = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
            goto L18
        L46:
            return
        L47:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L58
            r1 = r1 | r2
            r2 = 0
            java.lang.Object r3 = r10.f480g     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
        L55:
            r10.f480g = r2     // Catch: java.lang.Throwable -> L58
            goto L2
        L58:
            r0 = move-exception
            goto L7f
        L5a:
            r0 = move-exception
            goto L7a
        L5c:
            r3 = move-exception
            java.util.logging.Logger r4 = y1.i.k     // Catch: java.lang.Throwable -> L5a
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r6.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = "Exception while executing runnable "
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r7 = r10.f480g     // Catch: java.lang.Throwable -> L5a
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L5a
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5a
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
            goto L55
        L7a:
            r10.f480g = r2     // Catch: java.lang.Throwable -> L58
            throw r0     // Catch: java.lang.Throwable -> L58
        L7d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r0     // Catch: java.lang.Throwable -> L58
        L7f:
            if (r1 == 0) goto L88
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L88:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: F.a.c():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Exception, P1.x] */
    @Override // java.lang.Runnable
    public final void run() {
        Set set;
        InterfaceC0139e interfaceC0139e;
        InterfaceC0139e e4;
        int i4 = 0;
        switch (this.f479f) {
            case 0:
                R1.c cVar = (R1.c) this.f480g;
                Typeface typeface = (Typeface) this.f481h;
                C0496W c0496w = (C0496W) cVar.f1532g;
                if (c0496w != null) {
                    c0496w.b(typeface);
                    return;
                }
                return;
            case 1:
                ((h) this.f480g).accept(this.f481h);
                return;
            case 2:
                V0.l lVar = (V0.l) this.f480g;
                IBinder iBinder = (IBinder) this.f481h;
                synchronized (lVar) {
                    if (iBinder == null) {
                        lVar.a("Null service connection");
                    } else {
                        try {
                            lVar.f1703c = new E0.a(iBinder);
                            lVar.f1701a = 2;
                            lVar.f1706f.f1714b.execute(new V0.j(lVar, i4));
                        } catch (RemoteException e5) {
                            lVar.a(e5.getMessage());
                        }
                    }
                }
                return;
            case 3:
                V0.l lVar2 = (V0.l) this.f480g;
                int i5 = ((V0.m) this.f481h).f1707a;
                synchronized (lVar2) {
                    V0.m mVar = (V0.m) lVar2.f1705e.get(i5);
                    if (mVar != 0) {
                        Log.w("MessengerIpcClient", "Timing out request: " + i5);
                        lVar2.f1705e.remove(i5);
                        mVar.b(new Exception("Timed out waiting for response", null));
                        lVar2.c();
                    }
                }
                return;
            case 4:
                W0.a aVar = (W0.a) this.f480g;
                Y0.m mVar2 = (Y0.m) this.f481h;
                Y0.d dVar = mVar2.k;
                X0.c cVar2 = mVar2.f2060f;
                Y0.k kVar = (Y0.k) dVar.f2039j.get(mVar2.f2061g);
                if (kVar != null) {
                    if (aVar.f1848g == 0) {
                        mVar2.f2064j = true;
                        if (!cVar2.b()) {
                            try {
                                com.google.android.gms.common.internal.a aVar2 = (com.google.android.gms.common.internal.a) cVar2;
                                if (aVar2.b()) {
                                    set = aVar2.f3393x;
                                } else {
                                    set = Collections.EMPTY_SET;
                                }
                                ((com.google.android.gms.common.internal.a) cVar2).h(null, set);
                                return;
                            } catch (SecurityException e6) {
                                Log.e("GoogleApiManager", "Failed to get service from broker. ", e6);
                                ((com.google.android.gms.common.internal.a) cVar2).e("Failed to get service from broker.");
                                kVar.n(new W0.a(10, null, null), null);
                                return;
                            }
                        }
                        if (mVar2.f2064j && (interfaceC0139e = mVar2.f2062h) != null) {
                            ((com.google.android.gms.common.internal.a) cVar2).h(interfaceC0139e, mVar2.f2063i);
                            return;
                        }
                        return;
                    }
                    kVar.n(aVar, null);
                    return;
                }
                return;
            case 5:
                Y0.r rVar = (Y0.r) this.f481h;
                n1.e eVar = (n1.e) this.f480g;
                rVar.getClass();
                W0.a aVar3 = eVar.f5380g;
                if (aVar3.f1848g == 0) {
                    Z0.o oVar = eVar.f5381h;
                    r.e(oVar);
                    W0.a aVar4 = oVar.f2165h;
                    if (aVar4.f1848g == 0) {
                        Y0.m mVar3 = rVar.f2075m;
                        IBinder iBinder2 = oVar.f2164g;
                        if (iBinder2 == null) {
                            e4 = null;
                        } else {
                            int i6 = AbstractBinderC0135a.f2110g;
                            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                            if (queryLocalInterface instanceof InterfaceC0139e) {
                                e4 = (InterfaceC0139e) queryLocalInterface;
                            } else {
                                e4 = new E(iBinder2);
                            }
                        }
                        Set set2 = rVar.f2073j;
                        mVar3.getClass();
                        if (e4 != null && set2 != null) {
                            mVar3.f2062h = e4;
                            mVar3.f2063i = set2;
                            if (mVar3.f2064j) {
                                ((com.google.android.gms.common.internal.a) mVar3.f2060f).h(e4, set2);
                            }
                        } else {
                            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                            mVar3.a(new W0.a(4, null, null));
                        }
                    } else {
                        Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(aVar4)), new Exception());
                        rVar.f2075m.a(aVar4);
                        rVar.f2074l.d();
                        return;
                    }
                } else {
                    rVar.f2075m.a(aVar3);
                }
                rVar.f2074l.d();
                return;
            case 6:
                g3.g gVar = (g3.g) this.f481h;
                AbstractC0242q abstractC0242q = gVar.f3787h;
                while (true) {
                    try {
                        ((Runnable) this.f480g).run();
                    } catch (Throwable th) {
                        AbstractC0245u.d(K2.j.f942f, th);
                    }
                    Runnable h3 = gVar.h();
                    if (h3 != null) {
                        this.f480g = h3;
                        i4++;
                        if (i4 >= 16 && abstractC0242q.f(gVar)) {
                            abstractC0242q.d(gVar, this);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                break;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                AbstractC0579h abstractC0579h = (AbstractC0579h) this.f480g;
                if (((C0585n) abstractC0579h).f5835d) {
                    ((C0582k) this.f481h).f5827i.n();
                    return;
                }
                try {
                    ((C0582k) this.f481h).f5827i.l(((C0582k) this.f481h).f5826h.b(abstractC0579h));
                    return;
                } catch (C0577f e7) {
                    if (e7.getCause() instanceof Exception) {
                        ((C0582k) this.f481h).f5827i.m((Exception) e7.getCause());
                        return;
                    } else {
                        ((C0582k) this.f481h).f5827i.m(e7);
                        return;
                    }
                } catch (Exception e8) {
                    ((C0582k) this.f481h).f5827i.m(e8);
                    return;
                }
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                C0582k c0582k = (C0582k) this.f481h;
                try {
                    AbstractC0579h abstractC0579h2 = (AbstractC0579h) c0582k.f5826h.b((AbstractC0579h) this.f480g);
                    if (abstractC0579h2 == null) {
                        c0582k.c(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    ExecutorC0400H executorC0400H = AbstractC0581j.f5823b;
                    abstractC0579h2.b(executorC0400H, c0582k);
                    abstractC0579h2.a(executorC0400H, c0582k);
                    C0585n c0585n = (C0585n) abstractC0579h2;
                    c0585n.f5833b.b(new C0583l((Executor) executorC0400H, (InterfaceC0573b) c0582k));
                    c0585n.p();
                    return;
                } catch (C0577f e9) {
                    if (e9.getCause() instanceof Exception) {
                        c0582k.f5827i.m((Exception) e9.getCause());
                        return;
                    } else {
                        c0582k.f5827i.m(e9);
                        return;
                    }
                } catch (Exception e10) {
                    c0582k.f5827i.m(e10);
                    return;
                }
            case 9:
                C0583l c0583l = (C0583l) this.f481h;
                synchronized (c0583l.f5830h) {
                    ((InterfaceC0574c) c0583l.f5831i).q((AbstractC0579h) this.f480g);
                }
                return;
            case 10:
                a();
                return;
            case 11:
                b();
                return;
            case 12:
                C0583l c0583l2 = (C0583l) this.f481h;
                try {
                    C0585n a4 = ((InterfaceC0578g) c0583l2.f5830h).a(((AbstractC0579h) this.f480g).d());
                    if (a4 == null) {
                        c0583l2.c(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    ExecutorC0400H executorC0400H2 = AbstractC0581j.f5823b;
                    a4.b(executorC0400H2, c0583l2);
                    a4.a(executorC0400H2, c0583l2);
                    a4.f5833b.b(new C0583l((Executor) executorC0400H2, (InterfaceC0573b) c0583l2));
                    a4.p();
                    return;
                } catch (CancellationException unused) {
                    c0583l2.b();
                    return;
                } catch (C0577f e11) {
                    if (e11.getCause() instanceof Exception) {
                        c0583l2.c((Exception) e11.getCause());
                        return;
                    } else {
                        c0583l2.c(e11);
                        return;
                    }
                } catch (Exception e12) {
                    c0583l2.c(e12);
                    return;
                }
            case 13:
                C0585n c0585n2 = (C0585n) this.f480g;
                try {
                    c0585n2.l(((Callable) this.f481h).call());
                    return;
                } catch (Exception e13) {
                    c0585n2.m(e13);
                    return;
                } catch (Throwable th2) {
                    c0585n2.m(new RuntimeException(th2));
                    return;
                }
            case 14:
                ((C0702b) this.f480g).f6344f = this.f481h;
                return;
            case 15:
                ((Application) this.f480g).unregisterActivityLifecycleCallbacks((C0702b) this.f481h);
                return;
            case 16:
                Object obj = this.f481h;
                Object obj2 = this.f480g;
                try {
                    Method method = AbstractC0703c.f6352d;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        AbstractC0703c.f6353e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e14) {
                    if (e14.getClass() == RuntimeException.class && e14.getMessage() != null && e14.getMessage().startsWith("Unable to stop")) {
                        throw e14;
                    }
                    return;
                } catch (Throwable th3) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th3);
                    return;
                }
            default:
                try {
                    c();
                    return;
                } catch (Error e15) {
                    synchronized (((y1.i) this.f481h).f6580g) {
                        ((y1.i) this.f481h).f6581h = 1;
                        throw e15;
                    }
                }
        }
    }

    public String toString() {
        String str;
        switch (this.f479f) {
            case 17:
                Runnable runnable = (Runnable) this.f480g;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i4 = ((y1.i) this.f481h).f6581h;
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                str = "null";
                            } else {
                                str = "RUNNING";
                            }
                        } else {
                            str = "QUEUED";
                        }
                    } else {
                        str = "QUEUING";
                    }
                } else {
                    str = "IDLE";
                }
                sb.append(str);
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(int i4, Object obj, Object obj2, boolean z) {
        this.f479f = i4;
        this.f480g = obj2;
        this.f481h = obj;
    }

    public a(y1.i iVar) {
        this.f479f = 17;
        this.f481h = iVar;
    }
}
