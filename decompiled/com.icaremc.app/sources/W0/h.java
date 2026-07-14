package W0;

import Z0.r;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.C0191x;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0185q;
import j.AbstractActivityC0416k;

/* loaded from: classes.dex */
public class h extends DialogInterfaceOnCancelListenerC0185q {

    /* renamed from: l0, reason: collision with root package name */
    public Dialog f1868l0;
    public DialogInterface.OnCancelListener m0;

    /* renamed from: n0, reason: collision with root package name */
    public AlertDialog f1869n0;

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0185q, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.m0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0185q
    public final Dialog w() {
        AbstractActivityC0416k abstractActivityC0416k;
        Dialog dialog = this.f1868l0;
        if (dialog == null) {
            this.f2882c0 = false;
            if (this.f1869n0 == null) {
                C0191x c0191x = this.f2942y;
                if (c0191x == null) {
                    abstractActivityC0416k = null;
                } else {
                    abstractActivityC0416k = c0191x.f2949g;
                }
                r.e(abstractActivityC0416k);
                this.f1869n0 = new AlertDialog.Builder(abstractActivityC0416k).create();
            }
            return this.f1869n0;
        }
        return dialog;
    }
}
