package h2;

import android.view.ViewTreeObserver;

/* renamed from: h2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0351d implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f3978f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0353f f3979g;

    public ViewTreeObserverOnPreDrawListenerC0351d(C0353f c0353f, p pVar) {
        this.f3979g = c0353f;
        this.f3978f = pVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        C0353f c0353f = this.f3979g;
        if (c0353f.f3987h && c0353f.f3985f != null) {
            this.f3978f.getViewTreeObserver().removeOnPreDrawListener(this);
            c0353f.f3985f = null;
        }
        return c0353f.f3987h;
    }
}
