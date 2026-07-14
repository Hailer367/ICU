package o;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class h1 extends TouchDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final View f5587a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f5588b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f5589c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f5590d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5591e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5592f;

    public h1(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f5591e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f5588b = rect3;
        Rect rect4 = new Rect();
        this.f5590d = rect4;
        Rect rect5 = new Rect();
        this.f5589c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i4 = -scaledTouchSlop;
        rect4.inset(i4, i4);
        rect5.set(rect2);
        this.f5587a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z3;
        int x3 = (int) motionEvent.getX();
        int y3 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z4 = true;
        if (action != 0) {
            if (action != 1 && action != 2) {
                if (action == 3) {
                    z3 = this.f5592f;
                    this.f5592f = false;
                }
                z = true;
                z4 = false;
            } else {
                z3 = this.f5592f;
                if (z3 && !this.f5590d.contains(x3, y3)) {
                    z4 = z3;
                    z = false;
                }
            }
            z4 = z3;
            z = true;
        } else {
            if (this.f5588b.contains(x3, y3)) {
                this.f5592f = true;
                z = true;
            }
            z = true;
            z4 = false;
        }
        if (!z4) {
            return false;
        }
        Rect rect = this.f5589c;
        View view = this.f5587a;
        if (z && !rect.contains(x3, y3)) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            motionEvent.setLocation(x3 - rect.left, y3 - rect.top);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
