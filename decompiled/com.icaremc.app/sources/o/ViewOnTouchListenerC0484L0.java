package o;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: o.L0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnTouchListenerC0484L0 implements View.OnTouchListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0486M0 f5470f;

    public ViewOnTouchListenerC0484L0(AbstractC0486M0 abstractC0486M0) {
        this.f5470f = abstractC0486M0;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C0463B c0463b;
        AbstractC0486M0 abstractC0486M0 = this.f5470f;
        RunnableC0480J0 runnableC0480J0 = abstractC0486M0.f5496v;
        Handler handler = abstractC0486M0.z;
        int action = motionEvent.getAction();
        int x3 = (int) motionEvent.getX();
        int y3 = (int) motionEvent.getY();
        if (action == 0 && (c0463b = abstractC0486M0.f5480D) != null && c0463b.isShowing() && x3 >= 0 && x3 < abstractC0486M0.f5480D.getWidth() && y3 >= 0 && y3 < abstractC0486M0.f5480D.getHeight()) {
            handler.postDelayed(runnableC0480J0, 250L);
            return false;
        }
        if (action == 1) {
            handler.removeCallbacks(runnableC0480J0);
            return false;
        }
        return false;
    }
}
