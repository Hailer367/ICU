package q1;

import a.AbstractC0051a;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.AbstractC0240s;
import l1.AbstractC0244w;
import l1.C0238p;
import l1.C0241t;
import l1.H;
import l1.O;
import l1.X;
import l1.e0;
import l1.f0;
import l1.h0;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final F.h f3503a;

    /* renamed from: b, reason: collision with root package name */
    public static final F.h f3504b;

    /* renamed from: c, reason: collision with root package name */
    public static final F.h f3505c;

    /* renamed from: d, reason: collision with root package name */
    public static final F.h f3506d;

    /* renamed from: e, reason: collision with root package name */
    public static final T0.b f3507e = new T0.b(6);

    /* renamed from: f, reason: collision with root package name */
    public static final T0.b f3508f = new T0.b(7);

    /* renamed from: g, reason: collision with root package name */
    public static final T0.b f3509g = new T0.b(8);

    static {
        int i2 = 17;
        f3503a = new F.h(i2, "CLOSED");
        f3504b = new F.h(i2, "UNDEFINED");
        f3505c = new F.h(i2, "REUSABLE_CLAIMED");
        f3506d = new F.h(i2, "NO_THREAD_ELEMENTS");
    }

    public static final void a(int i2) {
        if (i2 >= 1) {
        } else {
            throw new IllegalArgumentException(O.a.c(i2, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(r rVar, long j2, c1.p pVar) {
        while (true) {
            if (rVar.f3542c >= j2 && !rVar.c()) {
                return rVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f3510a;
            Object obj = atomicReferenceFieldUpdater.get(rVar);
            F.h hVar = f3503a;
            if (obj == hVar) {
                return hVar;
            }
            r rVar2 = (r) ((b) obj);
            if (rVar2 == null) {
                rVar2 = (r) pVar.invoke(Long.valueOf(rVar.f3542c + 1), rVar);
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
        if (obj != f3503a) {
            return (r) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(T0.i iVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = d.f3513a.iterator();
        while (it.hasNext()) {
            try {
                ((m1.b) it.next()).e(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    android.support.v4.media.session.a.c(runtimeException, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, runtimeException);
            }
        }
        try {
            android.support.v4.media.session.a.c(th, new e(iVar));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final boolean e(Object obj) {
        if (obj == f3503a) {
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

    public static final void g(T0.i iVar, Object obj) {
        if (obj != f3506d) {
            if (obj instanceof v) {
                v vVar = (v) obj;
                e0[] e0VarArr = vVar.f3547b;
                int length = e0VarArr.length - 1;
                if (length < 0) {
                    return;
                }
                e0 e0Var = e0VarArr[length];
                kotlin.jvm.internal.h.b(null);
                Object obj2 = vVar.f3546a[length];
                throw null;
            }
            Object c2 = iVar.c(null, f3508f);
            kotlin.jvm.internal.h.c(c2, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            O.a.l(c2);
            throw null;
        }
    }

    public static final void h(T0.d dVar, Object obj) {
        Object c0238p;
        h0 h0Var;
        if (dVar instanceof f) {
            f fVar = (f) dVar;
            AbstractC0240s abstractC0240s = fVar.f3516f;
            Throwable a2 = Q0.g.a(obj);
            if (a2 == null) {
                c0238p = obj;
            } else {
                c0238p = new C0238p(a2, false);
            }
            V0.c cVar = fVar.f3517g;
            if (abstractC0240s.f(cVar.getContext())) {
                fVar.f3518h = c0238p;
                fVar.f2949e = 1;
                abstractC0240s.e(cVar.getContext(), fVar);
                return;
            }
            H a3 = f0.a();
            if (a3.f2956e >= 4294967296L) {
                fVar.f3518h = c0238p;
                fVar.f2949e = 1;
                R0.h hVar = a3.f2958g;
                if (hVar == null) {
                    hVar = new R0.h();
                    a3.f2958g = hVar;
                }
                hVar.addLast(fVar);
                return;
            }
            a3.l(true);
            try {
                O o2 = (O) cVar.getContext().k(C0241t.f3012d);
                if (o2 != null && !o2.a()) {
                    fVar.resumeWith(AbstractC0051a.j(((X) o2).v()));
                } else {
                    Object obj2 = fVar.f3519i;
                    T0.i context = cVar.getContext();
                    Object l2 = l(context, obj2);
                    if (l2 != f3506d) {
                        h0Var = AbstractC0244w.l(cVar, context, l2);
                    } else {
                        h0Var = null;
                    }
                    try {
                        cVar.resumeWith(obj);
                    } finally {
                        if (h0Var == null || h0Var.T()) {
                            g(context, l2);
                        }
                    }
                }
                do {
                } while (a3.n());
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
    public static final long i(long r22, long r24, long r26, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.a.i(long, long, long, java.lang.String):long");
    }

    public static int j(String str, int i2, int i3) {
        int i4;
        if ((i3 & 8) != 0) {
            i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            i4 = 2097150;
        }
        return (int) i(i2, 1, i4, str);
    }

    public static final Object k(T0.i iVar) {
        Object c2 = iVar.c(0, f3507e);
        kotlin.jvm.internal.h.b(c2);
        return c2;
    }

    public static final Object l(T0.i iVar, Object obj) {
        if (obj == null) {
            obj = k(iVar);
        }
        if (obj == 0) {
            return f3506d;
        }
        if (obj instanceof Integer) {
            return iVar.c(new v(((Number) obj).intValue(), iVar), f3509g);
        }
        O.a.l(obj);
        throw null;
    }
}
