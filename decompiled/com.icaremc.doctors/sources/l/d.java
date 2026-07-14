package l;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class d implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2804c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l f2805d;

    public /* synthetic */ d(l lVar, int i2) {
        this.f2804c = i2;
        this.f2805d = lVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i2 = this.f2804c;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f2804c) {
            case 0:
                g gVar = (g) this.f2805d;
                ViewTreeObserver viewTreeObserver = gVar.z;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        gVar.z = view.getViewTreeObserver();
                    }
                    gVar.z.removeGlobalOnLayoutListener(gVar.f2822k);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            default:
                s sVar = (s) this.f2805d;
                ViewTreeObserver viewTreeObserver2 = sVar.q;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        sVar.q = view.getViewTreeObserver();
                    }
                    sVar.q.removeGlobalOnLayoutListener(sVar.f2903k);
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
