package b3;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* renamed from: b3.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0246v extends F implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: o, reason: collision with root package name */
    public static final RunnableC0246v f3308o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f3309p;

    /* JADX WARN: Type inference failed for: r0v0, types: [b3.F, b3.v, b3.G] */
    static {
        Long l3;
        ?? f4 = new F();
        f3308o = f4;
        f4.l(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l3 = 1000L;
        }
        f3309p = timeUnit.toNanos(l3.longValue());
    }

    @Override // b3.G
    public final Thread i() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setContextClassLoader(f3308o.getClass().getClassLoader());
                    thread.setDaemon(true);
                    thread.start();
                }
            }
            return thread;
        }
        return thread2;
    }

    @Override // b3.F
    public final void o(Runnable runnable) {
        if (debugStatus != 4) {
            super.o(runnable);
            return;
        }
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void q() {
        boolean z;
        int i4 = debugStatus;
        if (i4 != 2 && i4 != 3) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return;
        }
        debugStatus = 3;
        F.f3239l.set(this, null);
        F.f3240m.set(this, null);
        notifyAll();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z3;
        boolean p3;
        e0.f3270a.set(this);
        try {
            synchronized (this) {
                int i4 = debugStatus;
                if (i4 != 2 && i4 != 3) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (!p3) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j4 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long m3 = m();
                    if (m3 == Long.MAX_VALUE) {
                        long nanoTime = System.nanoTime();
                        if (j4 == Long.MAX_VALUE) {
                            j4 = f3309p + nanoTime;
                        }
                        long j5 = j4 - nanoTime;
                        if (j5 <= 0) {
                            _thread = null;
                            q();
                            if (!p()) {
                                i();
                                return;
                            }
                            return;
                        }
                        if (m3 > j5) {
                            m3 = j5;
                        }
                    } else {
                        j4 = Long.MAX_VALUE;
                    }
                    if (m3 > 0) {
                        int i5 = debugStatus;
                        if (i5 != 2 && i5 != 3) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            _thread = null;
                            q();
                            if (!p()) {
                                i();
                                return;
                            }
                            return;
                        }
                        LockSupport.parkNanos(this, m3);
                    }
                }
            }
        } finally {
            _thread = null;
            q();
            if (!p()) {
                i();
            }
        }
    }

    @Override // b3.F, b3.G
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // b3.AbstractC0242q
    public final String toString() {
        return "DefaultExecutor";
    }
}
