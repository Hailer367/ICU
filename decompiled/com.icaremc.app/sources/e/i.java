package e;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.AbstractActivityC0192y;

/* loaded from: classes.dex */
public final class i implements h, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final long f3555f = SystemClock.uptimeMillis() + 10000;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f3556g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3557h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0192y f3558i;

    public i(AbstractActivityC0192y abstractActivityC0192y) {
        this.f3558i = abstractActivityC0192y;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        T2.h.e(runnable, "runnable");
        this.f3556g = runnable;
        View decorView = this.f3558i.getWindow().getDecorView();
        T2.h.d(decorView, "getDecorView(...)");
        if (this.f3557h) {
            if (T2.h.a(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
                return;
            } else {
                decorView.postInvalidate();
                return;
            }
        }
        decorView.postOnAnimation(new A.k(8, this));
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z;
        Runnable runnable = this.f3556g;
        if (runnable != null) {
            runnable.run();
            this.f3556g = null;
            o fullyDrawnReporter = this.f3558i.getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.f3570a) {
                z = fullyDrawnReporter.f3571b;
            }
            if (z) {
                this.f3557h = false;
                this.f3558i.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        if (SystemClock.uptimeMillis() > this.f3555f) {
            this.f3557h = false;
            this.f3558i.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3558i.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
