package j;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import f1.AbstractC0286a;

/* loaded from: classes.dex */
public final class y extends ContentFrameLayout {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ LayoutInflaterFactory2C0393A f5018n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A, m.e eVar) {
        super(eVar, null);
        this.f5018n = layoutInflaterFactory2C0393A;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f5018n.v(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            if (x3 < -5 || y3 < -5 || x3 > getWidth() + 5 || y3 > getHeight() + 5) {
                LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.f5018n;
                layoutInflaterFactory2C0393A.t(layoutInflaterFactory2C0393A.A(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i4) {
        setBackgroundDrawable(AbstractC0286a.o(getContext(), i4));
    }
}
