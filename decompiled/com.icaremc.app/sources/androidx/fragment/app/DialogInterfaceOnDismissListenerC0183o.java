package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnDismissListenerC0183o implements DialogInterface.OnDismissListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0185q f2874f;

    public DialogInterfaceOnDismissListenerC0183o(DialogInterfaceOnCancelListenerC0185q dialogInterfaceOnCancelListenerC0185q) {
        this.f2874f = dialogInterfaceOnCancelListenerC0185q;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0185q dialogInterfaceOnCancelListenerC0185q = this.f2874f;
        Dialog dialog = dialogInterfaceOnCancelListenerC0185q.f2886g0;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0185q.onDismiss(dialog);
        }
    }
}
