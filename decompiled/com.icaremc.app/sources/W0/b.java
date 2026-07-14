package W0;

import Z0.r;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes.dex */
public class b extends DialogFragment {

    /* renamed from: f, reason: collision with root package name */
    public Dialog f1852f;

    /* renamed from: g, reason: collision with root package name */
    public DialogInterface.OnCancelListener f1853g;

    /* renamed from: h, reason: collision with root package name */
    public AlertDialog f1854h;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f1853g;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f1852f;
        if (dialog == null) {
            setShowsDialog(false);
            if (this.f1854h == null) {
                Activity activity = getActivity();
                r.e(activity);
                this.f1854h = new AlertDialog.Builder(activity).create();
            }
            return this.f1854h;
        }
        return dialog;
    }
}
