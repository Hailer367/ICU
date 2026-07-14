package I0;

import android.os.Handler;
import android.os.Looper;
import h1.HandlerC0340e;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class q implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f845f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final Object f846g;

    public q() {
        Handler handler = new Handler(Looper.getMainLooper());
        Looper.getMainLooper();
        this.f846g = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f845f) {
            case 0:
                ((Executor) this.f846g).execute(new p(runnable, 0));
                return;
            default:
                ((HandlerC0340e) this.f846g).post(runnable);
                return;
        }
    }

    public q(ExecutorService executorService) {
        this.f846g = executorService;
    }
}
