package l1;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
public final class J extends I implements InterfaceC0247z {

    /* renamed from: e, reason: collision with root package name */
    public final Executor f2959e;

    public J(Executor executor) {
        this.f2959e = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ExecutorService executorService;
        Executor executor = this.f2959e;
        if (executor instanceof ExecutorService) {
            executorService = (ExecutorService) executor;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // l1.AbstractC0240s
    public final void e(T0.i iVar, Runnable runnable) {
        try {
            this.f2959e.execute(runnable);
        } catch (RejectedExecutionException e2) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e2);
            O o2 = (O) iVar.k(C0241t.f3012d);
            if (o2 != null) {
                o2.b(cancellationException);
            }
            s1.e eVar = C.f2950a;
            s1.d.f3615e.e(iVar, runnable);
        }
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof J) && ((J) obj).f2959e == this.f2959e) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f2959e);
    }

    @Override // l1.AbstractC0240s
    public final String toString() {
        return this.f2959e.toString();
    }
}
