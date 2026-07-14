package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class r implements DialogInterface.OnCancelListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0126v f1734c;

    public r(DialogInterfaceOnCancelListenerC0126v dialogInterfaceOnCancelListenerC0126v) {
        this.f1734c = dialogInterfaceOnCancelListenerC0126v;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Dialog dialog;
        Dialog dialog2;
        DialogInterfaceOnCancelListenerC0126v dialogInterfaceOnCancelListenerC0126v = this.f1734c;
        dialog = dialogInterfaceOnCancelListenerC0126v.mDialog;
        if (dialog != null) {
            dialog2 = dialogInterfaceOnCancelListenerC0126v.mDialog;
            dialogInterfaceOnCancelListenerC0126v.onCancel(dialog2);
        }
    }
}
