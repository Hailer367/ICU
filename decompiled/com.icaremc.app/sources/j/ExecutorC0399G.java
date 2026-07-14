package j;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: j.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ExecutorC0399G implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public final Object f4888f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f4889g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorC0400H f4890h;

    /* renamed from: i, reason: collision with root package name */
    public Runnable f4891i;

    public ExecutorC0399G(ExecutorC0400H executorC0400H) {
        this.f4890h = executorC0400H;
    }

    public final void a() {
        synchronized (this.f4888f) {
            try {
                Runnable runnable = (Runnable) this.f4889g.poll();
                this.f4891i = runnable;
                if (runnable != null) {
                    this.f4890h.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f4888f) {
            try {
                this.f4889g.add(new A.j(8, this, runnable));
                if (this.f4891i == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
