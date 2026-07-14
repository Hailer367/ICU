package n;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: n.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0455e implements View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5250f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w f5251g;

    public /* synthetic */ ViewOnAttachStateChangeListenerC0455e(w wVar, int i4) {
        this.f5250f = i4;
        this.f5251g = wVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i4 = this.f5250f;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f5250f) {
            case 0:
                ViewOnKeyListenerC0458h viewOnKeyListenerC0458h = (ViewOnKeyListenerC0458h) this.f5251g;
                ViewTreeObserver viewTreeObserver = viewOnKeyListenerC0458h.f5261C;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        viewOnKeyListenerC0458h.f5261C = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC0458h.f5261C.removeGlobalOnLayoutListener(viewOnKeyListenerC0458h.f5270n);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            default:
                G g4 = (G) this.f5251g;
                ViewTreeObserver viewTreeObserver2 = g4.f5223t;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        g4.f5223t = view.getViewTreeObserver();
                    }
                    g4.f5223t.removeGlobalOnLayoutListener(g4.f5217n);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}
