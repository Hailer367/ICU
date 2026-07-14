package d;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.M;

/* loaded from: classes.dex */
public final class i implements h, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final long f2125c = SystemClock.uptimeMillis() + 10000;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f2126d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2127e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ M f2128f;

    public i(M m2) {
        this.f2128f = m2;
    }

    public final void a(View view) {
        if (!this.f2127e) {
            this.f2127e = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        kotlin.jvm.internal.h.e(runnable, "runnable");
        this.f2126d = runnable;
        View decorView = this.f2128f.getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView, "getDecorView(...)");
        if (this.f2127e) {
            if (kotlin.jvm.internal.h.a(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
                return;
            } else {
                decorView.postInvalidate();
                return;
            }
        }
        decorView.postOnAnimation(new B0.o(3, this));
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z;
        Runnable runnable = this.f2126d;
        if (runnable != null) {
            runnable.run();
            this.f2126d = null;
            n fullyDrawnReporter = this.f2128f.getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.f2137b) {
                z = fullyDrawnReporter.f2138c;
            }
            if (z) {
                this.f2127e = false;
                this.f2128f.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        if (SystemClock.uptimeMillis() > this.f2125c) {
            this.f2127e = false;
            this.f2128f.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2128f.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
