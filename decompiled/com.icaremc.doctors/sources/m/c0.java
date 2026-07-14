package m;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class c0 extends TouchDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final View f3115a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f3116b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f3117c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f3118d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3119e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3120f;

    public c0(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f3119e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f3116b = rect3;
        Rect rect4 = new Rect();
        this.f3118d = rect4;
        Rect rect5 = new Rect();
        this.f3117c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i2 = -scaledTouchSlop;
        rect4.inset(i2, i2);
        rect5.set(rect2);
        this.f3115a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int x2 = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z3 = true;
        if (action != 0) {
            if (action != 1 && action != 2) {
                if (action == 3) {
                    z2 = this.f3120f;
                    this.f3120f = false;
                }
                z = true;
                z3 = false;
            } else {
                z2 = this.f3120f;
                if (z2 && !this.f3118d.contains(x2, y)) {
                    z3 = z2;
                    z = false;
                }
            }
            z3 = z2;
            z = true;
        } else {
            if (this.f3116b.contains(x2, y)) {
                this.f3120f = true;
                z = true;
            }
            z = true;
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        Rect rect = this.f3117c;
        View view = this.f3115a;
        if (z && !rect.contains(x2, y)) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            motionEvent.setLocation(x2 - rect.left, y - rect.top);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
