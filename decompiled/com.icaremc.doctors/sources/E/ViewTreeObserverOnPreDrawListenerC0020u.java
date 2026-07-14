package E;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: E.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0020u implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final View f254c;

    /* renamed from: d, reason: collision with root package name */
    public ViewTreeObserver f255d;

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f256e;

    public ViewTreeObserverOnPreDrawListenerC0020u(View view, Runnable runnable) {
        this.f254c = view;
        this.f255d = view.getViewTreeObserver();
        this.f256e = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view != null) {
            ViewTreeObserverOnPreDrawListenerC0020u viewTreeObserverOnPreDrawListenerC0020u = new ViewTreeObserverOnPreDrawListenerC0020u(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0020u);
            view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0020u);
            return;
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean isAlive = this.f255d.isAlive();
        View view = this.f254c;
        if (isAlive) {
            this.f255d.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f256e.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f255d = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f255d.isAlive();
        View view2 = this.f254c;
        if (isAlive) {
            this.f255d.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
