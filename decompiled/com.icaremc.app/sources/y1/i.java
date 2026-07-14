package y1;

import I0.p;
import Z0.r;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class i implements Executor {
    public static final Logger k = Logger.getLogger(i.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public final Executor f6579f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f6580g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    public int f6581h = 1;

    /* renamed from: i, reason: collision with root package name */
    public long f6582i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final F.a f6583j = new F.a(this);

    public i(Executor executor) {
        r.e(executor);
        this.f6579f = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        r.e(runnable);
        synchronized (this.f6580g) {
            int i4 = this.f6581h;
            if (i4 != 4 && i4 != 3) {
                long j4 = this.f6582i;
                p pVar = new p(runnable, 2);
                this.f6580g.add(pVar);
                this.f6581h = 2;
                try {
                    this.f6579f.execute(this.f6583j);
                    if (this.f6581h == 2) {
                        synchronized (this.f6580g) {
                            try {
                                if (this.f6582i == j4 && this.f6581h == 2) {
                                    this.f6581h = 3;
                                }
                            } finally {
                            }
                        }
                        return;
                    }
                    return;
                } catch (Error | RuntimeException e4) {
                    synchronized (this.f6580g) {
                        try {
                            int i5 = this.f6581h;
                            boolean z = true;
                            if ((i5 != 1 && i5 != 2) || !this.f6580g.removeLastOccurrence(pVar)) {
                                z = false;
                            }
                            if (!(e4 instanceof RejectedExecutionException) || z) {
                                throw e4;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.f6580g.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f6579f + "}";
    }
}
