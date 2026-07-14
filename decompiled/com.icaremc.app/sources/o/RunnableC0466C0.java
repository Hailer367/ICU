package o;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* renamed from: o.C0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0466C0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5424f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractViewOnTouchListenerC0468D0 f5425g;

    public /* synthetic */ RunnableC0466C0(AbstractViewOnTouchListenerC0468D0 abstractViewOnTouchListenerC0468D0, int i4) {
        this.f5424f = i4;
        this.f5425g = abstractViewOnTouchListenerC0468D0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5424f) {
            case 0:
                ViewParent parent = this.f5425g.f5434i.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                return;
            default:
                AbstractViewOnTouchListenerC0468D0 abstractViewOnTouchListenerC0468D0 = this.f5425g;
                abstractViewOnTouchListenerC0468D0.a();
                View view = abstractViewOnTouchListenerC0468D0.f5434i;
                if (view.isEnabled() && !view.isLongClickable() && abstractViewOnTouchListenerC0468D0.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    abstractViewOnTouchListenerC0468D0.f5436l = true;
                    return;
                }
                return;
        }
    }
}
