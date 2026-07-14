package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnDismissListenerC0123s implements DialogInterface.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0126v f1750c;

    public DialogInterfaceOnDismissListenerC0123s(DialogInterfaceOnCancelListenerC0126v dialogInterfaceOnCancelListenerC0126v) {
        this.f1750c = dialogInterfaceOnCancelListenerC0126v;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Dialog dialog;
        Dialog dialog2;
        DialogInterfaceOnCancelListenerC0126v dialogInterfaceOnCancelListenerC0126v = this.f1750c;
        dialog = dialogInterfaceOnCancelListenerC0126v.mDialog;
        if (dialog != null) {
            dialog2 = dialogInterfaceOnCancelListenerC0126v.mDialog;
            dialogInterfaceOnCancelListenerC0126v.onDismiss(dialog2);
        }
    }
}
