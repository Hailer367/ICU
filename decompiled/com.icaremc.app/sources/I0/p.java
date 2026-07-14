package I0;

import android.os.Process;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f843f;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f844g;

    public /* synthetic */ p(Runnable runnable, int i4) {
        this.f843f = i4;
        this.f844g = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f843f) {
            case 0:
                try {
                    this.f844g.run();
                    return;
                } catch (Exception e4) {
                    AbstractC0602b.v("Executor", "Background execution failure.", e4);
                    return;
                }
            case 1:
                Process.setThreadPriority(0);
                this.f844g.run();
                return;
            default:
                this.f844g.run();
                return;
        }
    }

    public String toString() {
        switch (this.f843f) {
            case 2:
                return this.f844g.toString();
            default:
                return super.toString();
        }
    }
}
