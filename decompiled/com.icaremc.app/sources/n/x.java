package n;

import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class x implements PopupWindow.OnDismissListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ z f5360f;

    public x(z zVar) {
        this.f5360f = zVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f5360f.c();
    }
}
