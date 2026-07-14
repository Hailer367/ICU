package v;

import a.AbstractC0141a;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import r2.k;

/* renamed from: v.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractFutureC0676h implements Future {

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f6253i = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: j, reason: collision with root package name */
    public static final Logger f6254j = Logger.getLogger(AbstractFutureC0676h.class.getName());
    public static final AbstractC0141a k;

    /* renamed from: l, reason: collision with root package name */
    public static final Object f6255l;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f6256f;

    /* renamed from: g, reason: collision with root package name */
    public volatile C0672d f6257g;

    /* renamed from: h, reason: collision with root package name */
    public volatile C0675g f6258h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [a.a] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    static {
        ?? r3;
        try {
            th = null;
            r3 = new C0673e(AtomicReferenceFieldUpdater.newUpdater(C0675g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(C0675g.class, C0675g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFutureC0676h.class, C0675g.class, "h"), AtomicReferenceFieldUpdater.newUpdater(AbstractFutureC0676h.class, C0672d.class, "g"), AtomicReferenceFieldUpdater.newUpdater(AbstractFutureC0676h.class, Object.class, "f"));
        } catch (Throwable th) {
            th = th;
            r3 = new Object();
        }
        k = r3;
        if (th != null) {
            f6254j.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f6255l = new Object();
    }

    public static void c(AbstractFutureC0676h abstractFutureC0676h) {
        C0675g c0675g;
        C0672d c0672d;
        do {
            c0675g = abstractFutureC0676h.f6258h;
        } while (!k.d(abstractFutureC0676h, c0675g, C0675g.f6250c));
        while (c0675g != null) {
            Thread thread = c0675g.f6251a;
            if (thread != null) {
                c0675g.f6251a = null;
                LockSupport.unpark(thread);
            }
            c0675g = c0675g.f6252b;
        }
        abstractFutureC0676h.b();
        do {
            c0672d = abstractFutureC0676h.f6257g;
        } while (!k.b(abstractFutureC0676h, c0672d));
        C0672d c0672d2 = null;
        while (c0672d != null) {
            C0672d c0672d3 = c0672d.f6244a;
            c0672d.f6244a = c0672d2;
            c0672d2 = c0672d;
            c0672d = c0672d3;
        }
        while (c0672d2 != null) {
            c0672d2 = c0672d2.f6244a;
            try {
                throw null;
                break;
            } catch (RuntimeException e4) {
                f6254j.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e4);
            }
        }
    }

    public static Object d(Object obj) {
        if (!(obj instanceof C0669a)) {
            if (!(obj instanceof C0671c)) {
                if (obj == f6255l) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((C0671c) obj).f6242a);
        }
        Throwable th = ((C0669a) obj).f6241b;
        CancellationException cancellationException = new CancellationException("Task was cancelled.");
        cancellationException.initCause(th);
        throw cancellationException;
    }

    public static Object e(AbstractFutureC0676h abstractFutureC0676h) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = abstractFutureC0676h.get();
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
        return obj;
    }

    public final void a(StringBuilder sb) {
        String valueOf;
        try {
            Object e4 = e(this);
            sb.append("SUCCESS, result=[");
            if (e4 == this) {
                valueOf = "this future";
            } else {
                valueOf = String.valueOf(e4);
            }
            sb.append(valueOf);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e5) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e5.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e6) {
            sb.append("FAILURE, cause=[");
            sb.append(e6.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean z3;
        C0669a c0669a;
        Object obj = this.f6256f;
        if (obj == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (f6253i) {
                c0669a = new C0669a(new CancellationException("Future.cancel() was called."), z);
            } else if (z) {
                c0669a = C0669a.f6238c;
            } else {
                c0669a = C0669a.f6239d;
            }
            if (k.c(this, obj, c0669a)) {
                c(this);
                return true;
            }
        }
        return false;
    }

    public final void f(C0675g c0675g) {
        c0675g.f6251a = null;
        while (true) {
            C0675g c0675g2 = this.f6258h;
            if (c0675g2 != C0675g.f6250c) {
                C0675g c0675g3 = null;
                while (c0675g2 != null) {
                    C0675g c0675g4 = c0675g2.f6252b;
                    if (c0675g2.f6251a != null) {
                        c0675g3 = c0675g2;
                    } else if (c0675g3 != null) {
                        c0675g3.f6252b = c0675g4;
                        if (c0675g3.f6251a == null) {
                            break;
                        }
                    } else if (!k.d(this, c0675g2, c0675g4)) {
                        break;
                    }
                    c0675g2 = c0675g4;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        C0675g c0675g = C0675g.f6250c;
        long nanos = timeUnit.toNanos(j4);
        if (!Thread.interrupted()) {
            Object obj = this.f6256f;
            if (obj != null) {
                return d(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                C0675g c0675g2 = this.f6258h;
                if (c0675g2 != c0675g) {
                    C0675g c0675g3 = new C0675g();
                    do {
                        AbstractC0141a abstractC0141a = k;
                        abstractC0141a.B(c0675g3, c0675g2);
                        if (abstractC0141a.d(this, c0675g2, c0675g3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f6256f;
                                    if (obj2 != null) {
                                        return d(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    f(c0675g3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            f(c0675g3);
                        } else {
                            c0675g2 = this.f6258h;
                        }
                    } while (c0675g2 != c0675g);
                }
                return d(this.f6256f);
            }
            while (nanos > 0) {
                Object obj3 = this.f6256f;
                if (obj3 != null) {
                    return d(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFutureC0676h = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j4 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String a4 = k.a(str, " (plus ");
                long j5 = -nanos;
                long convert = timeUnit.convert(j5, TimeUnit.NANOSECONDS);
                long nanos2 = j5 - timeUnit.toNanos(convert);
                boolean z = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String str2 = a4 + convert + " " + lowerCase;
                    if (z) {
                        str2 = k.a(str2, ",");
                    }
                    a4 = k.a(str2, " ");
                }
                if (z) {
                    a4 = a4 + nanos2 + " nanoseconds ";
                }
                str = k.a(a4, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(k.a(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(str + " for " + abstractFutureC0676h);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f6256f instanceof C0669a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        if (this.f6256f != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f6256f instanceof C0669a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e4) {
                str = "Exception thrown from implementation: " + e4.getClass();
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

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        C0675g c0675g = C0675g.f6250c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f6256f;
            if (obj2 != null) {
                return d(obj2);
            }
            C0675g c0675g2 = this.f6258h;
            if (c0675g2 != c0675g) {
                C0675g c0675g3 = new C0675g();
                do {
                    AbstractC0141a abstractC0141a = k;
                    abstractC0141a.B(c0675g3, c0675g2);
                    if (abstractC0141a.d(this, c0675g2, c0675g3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f6256f;
                            } else {
                                f(c0675g3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return d(obj);
                    }
                    c0675g2 = this.f6258h;
                } while (c0675g2 != c0675g);
            }
            return d(this.f6256f);
        }
        throw new InterruptedException();
    }
}
