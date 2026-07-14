package b3;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
public final class I extends H implements InterfaceC0248x {

    /* renamed from: h, reason: collision with root package name */
    public final Executor f3245h;

    public I(Executor executor) {
        this.f3245h = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ExecutorService executorService;
        Executor executor = this.f3245h;
        if (executor instanceof ExecutorService) {
            executorService = (ExecutorService) executor;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // b3.AbstractC0242q
    public final void d(K2.i iVar, Runnable runnable) {
        try {
            this.f3245h.execute(runnable);
        } catch (RejectedExecutionException e4) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e4);
            N n3 = (N) iVar.e(r.f3295g);
            if (n3 != null) {
                n3.b(cancellationException);
            }
            i3.e eVar = A.f3236a;
            i3.d.f4172h.d(iVar, runnable);
        }
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof I) && ((I) obj).f3245h == this.f3245h) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f3245h);
    }

    @Override // b3.AbstractC0242q
    public final String toString() {
        return this.f3245h.toString();
    }
}
