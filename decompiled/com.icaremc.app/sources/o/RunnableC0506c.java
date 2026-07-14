package o;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* renamed from: o.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0506c implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5559f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f5560g;

    public /* synthetic */ RunnableC0506c(ActionBarOverlayLayout actionBarOverlayLayout, int i4) {
        this.f5559f = i4;
        this.f5560g = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5559f) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f5560g;
                actionBarOverlayLayout.b();
                actionBarOverlayLayout.f2320B = actionBarOverlayLayout.f2328i.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f2321C);
                return;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f5560g;
                actionBarOverlayLayout2.b();
                actionBarOverlayLayout2.f2320B = actionBarOverlayLayout2.f2328i.animate().translationY(-actionBarOverlayLayout2.f2328i.getHeight()).setListener(actionBarOverlayLayout2.f2321C);
                return;
        }
    }
}
