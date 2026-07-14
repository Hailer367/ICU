package g3;

import b3.AbstractC0242q;
import b3.AbstractC0245u;
import b3.C0240o;
import b3.G;
import b3.N;
import b3.W;
import b3.d0;
import b3.e0;
import b3.g0;
import f1.AbstractC0286a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final R1.c f3770a;

    /* renamed from: b, reason: collision with root package name */
    public static final R1.c f3771b;

    /* renamed from: c, reason: collision with root package name */
    public static final R1.c f3772c;

    /* renamed from: d, reason: collision with root package name */
    public static final R1.c f3773d;

    /* renamed from: e, reason: collision with root package name */
    public static final K2.b f3774e = new K2.b(6);

    /* renamed from: f, reason: collision with root package name */
    public static final K2.b f3775f = new K2.b(7);

    /* renamed from: g, reason: collision with root package name */
    public static final K2.b f3776g = new K2.b(8);

    static {
        int i4 = 21;
        f3770a = new R1.c(i4, "CLOSED");
        f3771b = new R1.c(i4, "UNDEFINED");
        f3772c = new R1.c(i4, "REUSABLE_CLAIMED");
        f3773d = new R1.c(i4, "NO_THREAD_ELEMENTS");
    }

    public static final void a(int i4) {
        if (i4 >= 1) {
        } else {
            throw new IllegalArgumentException(A2.i.g(i4, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(r rVar, long j4, S2.p pVar) {
        while (true) {
            if (rVar.f3807c >= j4 && !rVar.c()) {
                return rVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f3777a;
            Object obj = atomicReferenceFieldUpdater.get(rVar);
            R1.c cVar = f3770a;
            if (obj == cVar) {
                return cVar;
            }
            r rVar2 = (r) ((b) obj);
            if (rVar2 == null) {
                rVar2 = (r) pVar.e(Long.valueOf(rVar.f3807c + 1), rVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(rVar, null, rVar2)) {
                    if (atomicReferenceFieldUpdater.get(rVar) != null) {
                        break;
                    }
                }
                if (rVar.c()) {
                    rVar.d();
                }
            }
            rVar = rVar2;
        }
    }

    public static final r c(Object obj) {
        if (obj != f3770a) {
            return (r) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(K2.i iVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = d.f3780a.iterator();
        while (it.hasNext()) {
            try {
                ((c3.b) it.next()).d(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    AbstractC0286a.a(runtimeException, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, runtimeException);
            }
        }
        try {
            AbstractC0286a.a(th, new e(iVar));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final boolean e(Object obj) {
        if (obj == f3770a) {
            return true;
        }
        return false;
    }

    public static final Object f(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void g(K2.i iVar, Object obj) {
        if (obj != f3773d) {
            if (obj instanceof v) {
                v vVar = (v) obj;
                d0[] d0VarArr = vVar.f3812b;
                int length = d0VarArr.length - 1;
                if (length < 0) {
                    return;
                }
                d0 d0Var = d0VarArr[length];
                T2.h.b(null);
                Object obj2 = vVar.f3811a[length];
                throw null;
            }
            Object k = iVar.k(null, f3775f);
            T2.h.c(k, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            A2.i.o(k);
            throw null;
        }
    }

    public static final void h(K2.d dVar, Object obj) {
        Object c0240o;
        g0 g0Var;
        if (dVar instanceof f) {
            f fVar = (f) dVar;
            AbstractC0242q abstractC0242q = fVar.f3783i;
            Throwable a4 = H2.f.a(obj);
            if (a4 == null) {
                c0240o = obj;
            } else {
                c0240o = new C0240o(a4, false);
            }
            M2.c cVar = fVar.f3784j;
            if (abstractC0242q.f(cVar.getContext())) {
                fVar.k = c0240o;
                fVar.f3312h = 1;
                abstractC0242q.d(cVar.getContext(), fVar);
                return;
            }
            G a5 = e0.a();
            if (a5.f3242h >= 4294967296L) {
                fVar.k = c0240o;
                fVar.f3312h = 1;
                I2.c cVar2 = a5.f3244j;
                if (cVar2 == null) {
                    cVar2 = new I2.c();
                    a5.f3244j = cVar2;
                }
                cVar2.addLast(fVar);
                return;
            }
            a5.l(true);
            try {
                N n3 = (N) cVar.getContext().e(b3.r.f3295g);
                if (n3 != null && !n3.a()) {
                    fVar.resumeWith(k3.b.f(((W) n3).w()));
                } else {
                    Object obj2 = fVar.f3785l;
                    K2.i context = cVar.getContext();
                    Object l3 = l(context, obj2);
                    if (l3 != f3773d) {
                        g0Var = AbstractC0245u.l(cVar, context, l3);
                    } else {
                        g0Var = null;
                    }
                    try {
                        cVar.resumeWith(obj);
                    } finally {
                        if (g0Var == null || g0Var.U()) {
                            g(context, l3);
                        }
                    }
                }
                do {
                } while (a5.n());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        dVar.resumeWith(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long i(java.lang.String r22, long r23, long r25, long r27) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.a.i(java.lang.String, long, long, long):long");
    }

    public static int j(int i4, String str, int i5) {
        int i6;
        if ((i5 & 8) != 0) {
            i6 = Integer.MAX_VALUE;
        } else {
            i6 = 2097150;
        }
        return (int) i(str, i4, 1, i6);
    }

    public static final Object k(K2.i iVar) {
        Object k = iVar.k(0, f3774e);
        T2.h.b(k);
        return k;
    }

    public static final Object l(K2.i iVar, Object obj) {
        if (obj == null) {
            obj = k(iVar);
        }
        if (obj == 0) {
            return f3773d;
        }
        if (obj instanceof Integer) {
            return iVar.k(new v(((Number) obj).intValue(), iVar), f3776g);
        }
        A2.i.o(obj);
        throw null;
    }
}
