package m;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* renamed from: m.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0255b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3112c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f3113d;

    public /* synthetic */ RunnableC0255b(ActionBarOverlayLayout actionBarOverlayLayout, int i2) {
        this.f3112c = i2;
        this.f3113d = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3112c) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f3113d;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.f1122v = actionBarOverlayLayout.f1107e.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f1123w);
                return;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f3113d;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.f1122v = actionBarOverlayLayout2.f1107e.animate().translationY(-actionBarOverlayLayout2.f1107e.getHeight()).setListener(actionBarOverlayLayout2.f1123w);
                return;
        }
    }
}
