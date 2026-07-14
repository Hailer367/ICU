package m;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class I implements View.OnTouchListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ J f3063c;

    public I(J j2) {
        this.f3063c = j2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        r rVar;
        J j2 = this.f3063c;
        G g2 = j2.p;
        Handler handler = j2.f3079t;
        int action = motionEvent.getAction();
        int x2 = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && (rVar = j2.f3083x) != null && rVar.isShowing() && x2 >= 0 && x2 < j2.f3083x.getWidth() && y >= 0 && y < j2.f3083x.getHeight()) {
            handler.postDelayed(g2, 250L);
            return false;
        }
        if (action == 1) {
            handler.removeCallbacks(g2);
            return false;
        }
        return false;
    }
}
