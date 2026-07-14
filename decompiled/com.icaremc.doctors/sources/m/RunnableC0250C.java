package m;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* renamed from: m.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0250C implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3041c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l.a f3042d;

    public /* synthetic */ RunnableC0250C(l.a aVar, int i2) {
        this.f3041c = i2;
        this.f3042d = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3041c) {
            case 0:
                ViewParent parent = this.f3042d.f2794f.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                return;
            default:
                l.a aVar = this.f3042d;
                aVar.a();
                View view = aVar.f2794f;
                if (view.isEnabled() && !view.isLongClickable() && aVar.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    aVar.f2797i = true;
                    return;
                }
                return;
        }
    }
}
