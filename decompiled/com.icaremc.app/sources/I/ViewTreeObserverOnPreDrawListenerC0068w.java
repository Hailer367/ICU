package I;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: I.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0068w implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public final View f789f;

    /* renamed from: g, reason: collision with root package name */
    public ViewTreeObserver f790g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f791h;

    public ViewTreeObserverOnPreDrawListenerC0068w(View view, Runnable runnable) {
        this.f789f = view;
        this.f790g = view.getViewTreeObserver();
        this.f791h = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view != null) {
            ViewTreeObserverOnPreDrawListenerC0068w viewTreeObserverOnPreDrawListenerC0068w = new ViewTreeObserverOnPreDrawListenerC0068w(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0068w);
            view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0068w);
            return;
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean isAlive = this.f790g.isAlive();
        View view = this.f789f;
        if (isAlive) {
            this.f790g.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f791h.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f790g = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f790g.isAlive();
        View view2 = this.f789f;
        if (isAlive) {
            this.f790g.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
