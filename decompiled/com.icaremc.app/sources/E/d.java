package E;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class d implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f451f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f452g;

    public /* synthetic */ d(Handler handler, int i4) {
        this.f451f = i4;
        this.f452g = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f451f) {
            case 0:
                runnable.getClass();
                Handler handler = this.f452g;
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            default:
                runnable.getClass();
                Handler handler2 = this.f452g;
                if (handler2.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler2 + " is shutting down");
        }
    }
}
