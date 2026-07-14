package l1;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* renamed from: l1.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0245x extends G implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: l, reason: collision with root package name */
    public static final RunnableC0245x f3025l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f3026m;

    /* JADX WARN: Type inference failed for: r0v0, types: [l1.x, l1.H, l1.G] */
    static {
        Long l2;
        ?? g2 = new G();
        f3025l = g2;
        g2.l(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f3026m = timeUnit.toNanos(l2.longValue());
    }

    @Override // l1.H
    public final Thread j() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setContextClassLoader(f3025l.getClass().getClassLoader());
                    thread.setDaemon(true);
                    thread.start();
                }
            }
            return thread;
        }
        return thread2;
    }

    @Override // l1.G
    public final void o(Runnable runnable) {
        if (debugStatus != 4) {
            super.o(runnable);
            return;
        }
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void q() {
        boolean z;
        int i2 = debugStatus;
        if (i2 != 2 && i2 != 3) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return;
        }
        debugStatus = 3;
        G.f2952i.set(this, null);
        G.f2953j.set(this, null);
        notifyAll();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        boolean p;
        f0.f2986a.set(this);
        try {
            synchronized (this) {
                int i2 = debugStatus;
                if (i2 != 2 && i2 != 3) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (!p) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j2 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long m2 = m();
                    if (m2 == Long.MAX_VALUE) {
                        long nanoTime = System.nanoTime();
                        if (j2 == Long.MAX_VALUE) {
                            j2 = f3026m + nanoTime;
                        }
                        long j3 = j2 - nanoTime;
                        if (j3 <= 0) {
                            _thread = null;
                            q();
                            if (!p()) {
                                j();
                                return;
                            }
                            return;
                        }
                        if (m2 > j3) {
                            m2 = j3;
                        }
                    } else {
                        j2 = Long.MAX_VALUE;
                    }
                    if (m2 > 0) {
                        int i3 = debugStatus;
                        if (i3 != 2 && i3 != 3) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            _thread = null;
                            q();
                            if (!p()) {
                                j();
                                return;
                            }
                            return;
                        }
                        LockSupport.parkNanos(this, m2);
                    }
                }
            }
        } finally {
            _thread = null;
            q();
            if (!p()) {
                j();
            }
        }
    }

    @Override // l1.G, l1.H
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // l1.AbstractC0240s
    public final String toString() {
        return "DefaultExecutor";
    }
}
