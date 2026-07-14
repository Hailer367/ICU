package n;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import j.DialogInterfaceC0414i;

/* loaded from: classes.dex */
public final class o implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, InterfaceC0448A {

    /* renamed from: f, reason: collision with root package name */
    public H f5318f;

    /* renamed from: g, reason: collision with root package name */
    public DialogInterfaceC0414i f5319g;

    /* renamed from: h, reason: collision with root package name */
    public j f5320h;

    @Override // n.InterfaceC0448A
    public final void a(n nVar, boolean z) {
        DialogInterfaceC0414i dialogInterfaceC0414i;
        if ((z || nVar == this.f5318f) && (dialogInterfaceC0414i = this.f5319g) != null) {
            dialogInterfaceC0414i.dismiss();
        }
    }

    @Override // n.InterfaceC0448A
    public final boolean c(n nVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        H h3 = this.f5318f;
        j jVar = this.f5320h;
        if (jVar.k == null) {
            jVar.k = new i(jVar);
        }
        h3.q(jVar.k.getItem(i4), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f5320h.a(this.f5318f, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        H h3 = this.f5318f;
        if (i4 == 82 || i4 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f5319g.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f5319g.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                h3.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return h3.performShortcut(i4, keyEvent, 0);
    }
}
