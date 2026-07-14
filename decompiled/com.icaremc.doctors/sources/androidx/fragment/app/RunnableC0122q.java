package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0122q implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1723c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1724d;

    public /* synthetic */ RunnableC0122q(int i2, Object obj) {
        this.f1723c = i2;
        this.f1724d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DialogInterface.OnDismissListener onDismissListener;
        Dialog dialog;
        switch (this.f1723c) {
            case 0:
                DialogInterfaceOnCancelListenerC0126v dialogInterfaceOnCancelListenerC0126v = (DialogInterfaceOnCancelListenerC0126v) this.f1724d;
                onDismissListener = dialogInterfaceOnCancelListenerC0126v.mOnDismissListener;
                dialog = dialogInterfaceOnCancelListenerC0126v.mDialog;
                onDismissListener.onDismiss(dialog);
                return;
            case 1:
                C0121p c0121p = (C0121p) this.f1724d;
                if (!c0121p.f1715b.isEmpty()) {
                    c0121p.e();
                    return;
                }
                return;
            default:
                ((h0) this.f1724d).z(true);
                return;
        }
    }
}
