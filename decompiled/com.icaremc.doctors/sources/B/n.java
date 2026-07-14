package B;

import android.os.Process;

/* loaded from: classes.dex */
public final class n extends Thread {

    /* renamed from: c, reason: collision with root package name */
    public final int f74c;

    public n(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f74c = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f74c);
        super.run();
    }
}
