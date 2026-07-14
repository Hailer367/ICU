package j;

import java.util.concurrent.Executor;

/* renamed from: j.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ExecutorC0400H implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4892f;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f4892f) {
            case 0:
                new Thread(runnable).start();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
