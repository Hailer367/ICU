package o;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import n.ViewTreeObserverOnGlobalLayoutListenerC0454d;

/* renamed from: o.P, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0490P implements PopupWindow.OnDismissListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0454d f5504f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0491Q f5505g;

    public C0490P(C0491Q c0491q, ViewTreeObserverOnGlobalLayoutListenerC0454d viewTreeObserverOnGlobalLayoutListenerC0454d) {
        this.f5505g = c0491q;
        this.f5504f = viewTreeObserverOnGlobalLayoutListenerC0454d;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f5505g.f5510K.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f5504f);
        }
    }
}
