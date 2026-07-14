package l;

import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class m implements PopupWindow.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f2884c;

    public m(n nVar) {
        this.f2884c = nVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f2884c.c();
    }
}
