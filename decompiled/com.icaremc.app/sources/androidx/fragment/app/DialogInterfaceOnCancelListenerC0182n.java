package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnCancelListenerC0182n implements DialogInterface.OnCancelListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0185q f2873f;

    public DialogInterfaceOnCancelListenerC0182n(DialogInterfaceOnCancelListenerC0185q dialogInterfaceOnCancelListenerC0185q) {
        this.f2873f = dialogInterfaceOnCancelListenerC0185q;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0185q dialogInterfaceOnCancelListenerC0185q = this.f2873f;
        Dialog dialog = dialogInterfaceOnCancelListenerC0185q.f2886g0;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0185q.onCancel(dialog);
        }
    }
}
