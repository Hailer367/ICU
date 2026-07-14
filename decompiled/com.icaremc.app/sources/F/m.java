package F;

import android.os.Process;

/* loaded from: classes.dex */
public final class m extends Thread {

    /* renamed from: f, reason: collision with root package name */
    public final int f517f;

    public m(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f517f = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f517f);
        super.run();
    }
}
