package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class j implements G0.a {
    static final a ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    volatile e listeners;
    volatile Object value;
    volatile i waiters;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(j.class.getName());

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.concurrent.futures.a] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    static {
        ?? r3;
        try {
            th = null;
            r3 = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(j.class, i.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(j.class, e.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "value"));
        } catch (Throwable th) {
            th = th;
            r3 = new Object();
        }
        ATOMIC_HELPER = r3;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    public static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object c(Object obj) {
        if (!(obj instanceof b)) {
            if (!(obj instanceof d)) {
                if (obj == NULL) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((d) obj).f1265a);
        }
        Throwable th = ((b) obj).f1263b;
        CancellationException cancellationException = new CancellationException("Task was cancelled.");
        cancellationException.initCause(th);
        throw cancellationException;
    }

    public static <T> T checkNotNull(T t2) {
        t2.getClass();
        return t2;
    }

    public static void complete(j jVar) {
        e eVar;
        e eVar2;
        e eVar3 = null;
        while (true) {
            i iVar = jVar.waiters;
            if (ATOMIC_HELPER.c(jVar, iVar, i.f1277c)) {
                while (iVar != null) {
                    Thread thread = iVar.f1278a;
                    if (thread != null) {
                        iVar.f1278a = null;
                        LockSupport.unpark(thread);
                    }
                    iVar = iVar.f1279b;
                }
                jVar.afterDone();
                do {
                    eVar = jVar.listeners;
                } while (!ATOMIC_HELPER.a(jVar, eVar, e.f1266d));
                while (true) {
                    eVar2 = eVar3;
                    eVar3 = eVar;
                    if (eVar3 == null) {
                        break;
                    }
                    eVar = eVar3.f1269c;
                    eVar3.f1269c = eVar2;
                }
                while (eVar2 != null) {
                    eVar3 = eVar2.f1269c;
                    Runnable runnable = eVar2.f1267a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        jVar = gVar.f1275c;
                        if (jVar.value == gVar) {
                            if (ATOMIC_HELPER.b(jVar, gVar, getFutureValue(gVar.f1276d))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        b(runnable, eVar2.f1268b);
                    }
                    eVar2 = eVar3;
                }
                return;
            }
        }
    }

    public static Object getFutureValue(G0.a aVar) {
        if (aVar instanceof j) {
            Object obj = ((j) aVar).value;
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (bVar.f1262a) {
                    if (bVar.f1263b != null) {
                        return new b(bVar.f1263b, false);
                    }
                    return b.f1261d;
                }
                return obj;
            }
            return obj;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
            return b.f1261d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(aVar);
            if (uninterruptibly == null) {
                return NULL;
            }
            return uninterruptibly;
        } catch (CancellationException e2) {
            if (!isCancelled) {
                return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e2));
            }
            return new b(e2, false);
        } catch (ExecutionException e3) {
            return new d(e3.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    public static <V> V getUninterruptibly(Future<V> future) {
        V v2;
        boolean z = false;
        while (true) {
            try {
                v2 = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v2;
    }

    public final void a(StringBuilder sb) {
        String valueOf;
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            if (uninterruptibly == this) {
                valueOf = "this future";
            } else {
                valueOf = String.valueOf(uninterruptibly);
            }
            sb.append(valueOf);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    @Override // G0.a
    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        e eVar = this.listeners;
        e eVar2 = e.f1266d;
        if (eVar != eVar2) {
            e eVar3 = new e(runnable, executor);
            do {
                eVar3.f1269c = eVar;
                if (ATOMIC_HELPER.a(this, eVar, eVar3)) {
                    return;
                } else {
                    eVar = this.listeners;
                }
            } while (eVar != eVar2);
        }
        b(runnable, executor);
    }

    public void afterDone() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
            r3 = r1
            goto L9
        L8:
            r3 = r2
        L9:
            boolean r4 = r0 instanceof androidx.concurrent.futures.g
            r3 = r3 | r4
            if (r3 == 0) goto L60
            boolean r3 = androidx.concurrent.futures.j.GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L1f
            androidx.concurrent.futures.b r3 = new androidx.concurrent.futures.b
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r4, r8)
            goto L26
        L1f:
            if (r8 == 0) goto L24
            androidx.concurrent.futures.b r3 = androidx.concurrent.futures.b.f1260c
            goto L26
        L24:
            androidx.concurrent.futures.b r3 = androidx.concurrent.futures.b.f1261d
        L26:
            r4 = r7
            r5 = r2
        L28:
            androidx.concurrent.futures.a r6 = androidx.concurrent.futures.j.ATOMIC_HELPER
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L59
            if (r8 == 0) goto L35
            r4.interruptTask()
        L35:
            complete(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.g
            if (r4 == 0) goto L58
            androidx.concurrent.futures.g r0 = (androidx.concurrent.futures.g) r0
            G0.a r0 = r0.f1276d
            boolean r4 = r0 instanceof androidx.concurrent.futures.j
            if (r4 == 0) goto L55
            r4 = r0
            androidx.concurrent.futures.j r4 = (androidx.concurrent.futures.j) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L4d
            r5 = r1
            goto L4e
        L4d:
            r5 = r2
        L4e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.g
            r5 = r5 | r6
            if (r5 == 0) goto L58
            r5 = r1
            goto L28
        L55:
            r0.cancel(r8)
        L58:
            return r1
        L59:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof androidx.concurrent.futures.g
            if (r6 != 0) goto L28
            return r5
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.j.cancel(boolean):boolean");
    }

    public final void d(i iVar) {
        iVar.f1278a = null;
        while (true) {
            i iVar2 = this.waiters;
            if (iVar2 != i.f1277c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f1279b;
                    if (iVar2.f1278a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f1279b = iVar4;
                        if (iVar3.f1278a == null) {
                            break;
                        }
                    } else if (!ATOMIC_HELPER.c(this, iVar2, iVar4)) {
                        break;
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        boolean z;
        i iVar = i.f1277c;
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) & (!(obj instanceof g))) {
                return c(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= SPIN_THRESHOLD_NANOS) {
                i iVar2 = this.waiters;
                if (iVar2 != iVar) {
                    i iVar3 = new i();
                    z = true;
                    do {
                        a aVar = ATOMIC_HELPER;
                        aVar.d(iVar3, iVar2);
                        if (aVar.c(this, iVar2, iVar3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof g))) {
                                        return c(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    d(iVar3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= SPIN_THRESHOLD_NANOS);
                            d(iVar3);
                        } else {
                            iVar2 = this.waiters;
                        }
                    } while (iVar2 != iVar);
                }
                return c(this.value);
            }
            z = true;
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null ? z : false) & (!(obj3 instanceof g))) {
                    return c(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String jVar = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + SPIN_THRESHOLD_NANOS < 0) {
                String f2 = O.a.f(str, " (plus ");
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
                boolean z2 = (convert == 0 || nanos2 > SPIN_THRESHOLD_NANOS) ? z : false;
                if (convert > 0) {
                    String str2 = f2 + convert + " " + lowerCase;
                    if (z2) {
                        str2 = O.a.f(str2, ",");
                    }
                    f2 = O.a.f(str2, " ");
                }
                if (z2) {
                    f2 = f2 + nanos2 + " nanoseconds ";
                }
                str = O.a.f(f2, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(O.a.f(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(str + " for " + jVar);
        }
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z;
        if (this.value != null) {
            z = true;
        } else {
            z = false;
        }
        return (!(r0 instanceof g)) & z;
    }

    public final void maybePropagateCancellationTo(Future<?> future) {
        boolean z;
        if (future != null) {
            z = true;
        } else {
            z = false;
        }
        if (z & isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        String valueOf;
        Object obj = this.value;
        if (obj instanceof g) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            G0.a aVar = ((g) obj).f1276d;
            if (aVar == this) {
                valueOf = "this future";
            } else {
                valueOf = String.valueOf(aVar);
            }
            return O.a.i(sb, valueOf, "]");
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    public boolean set(Object obj) {
        if (obj == null) {
            obj = NULL;
        }
        if (ATOMIC_HELPER.b(this, null, obj)) {
            complete(this);
            return true;
        }
        return false;
    }

    public boolean setException(Throwable th) {
        if (ATOMIC_HELPER.b(this, null, new d((Throwable) checkNotNull(th)))) {
            complete(this);
            return true;
        }
        return false;
    }

    public boolean setFuture(G0.a aVar) {
        d dVar;
        checkNotNull(aVar);
        Object obj = this.value;
        if (obj == null) {
            if (aVar.isDone()) {
                if (ATOMIC_HELPER.b(this, null, getFutureValue(aVar))) {
                    complete(this);
                    return true;
                }
                return false;
            }
            g gVar = new g(this, aVar);
            if (ATOMIC_HELPER.b(this, null, gVar)) {
                try {
                    aVar.addListener(gVar, k.f1280c);
                    return true;
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.f1264b;
                    }
                    ATOMIC_HELPER.b(this, gVar, dVar);
                    return true;
                }
            }
            obj = this.value;
        }
        if (obj instanceof b) {
            aVar.cancel(((b) obj).f1262a);
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        if ((obj instanceof b) && ((b) obj).f1262a) {
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        i iVar = i.f1277c;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return c(obj2);
            }
            i iVar2 = this.waiters;
            if (iVar2 != iVar) {
                i iVar3 = new i();
                do {
                    a aVar = ATOMIC_HELPER;
                    aVar.d(iVar3, iVar2);
                    if (aVar.c(this, iVar2, iVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                d(iVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return c(obj);
                    }
                    iVar2 = this.waiters;
                } while (iVar2 != iVar);
            }
            return c(this.value);
        }
        throw new InterruptedException();
    }
}
