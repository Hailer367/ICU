package A;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class f implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5d;

    public /* synthetic */ f(int i2, Object obj) {
        this.f4c = i2;
        this.f5d = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f4c) {
            case 0:
                Handler handler = (Handler) this.f5d;
                runnable.getClass();
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            case 1:
                Handler handler2 = (Handler) this.f5d;
                runnable.getClass();
                if (handler2.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler2 + " is shutting down");
            default:
                ((Executor) this.f5d).execute(new B.b(7, runnable));
                return;
        }
    }
}
