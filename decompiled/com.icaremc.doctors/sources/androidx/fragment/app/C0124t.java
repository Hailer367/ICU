package androidx.fragment.app;

import android.app.Dialog;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.InterfaceC0150u;

/* renamed from: androidx.fragment.app.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0124t implements androidx.lifecycle.E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0126v f1753a;

    public C0124t(DialogInterfaceOnCancelListenerC0126v dialogInterfaceOnCancelListenerC0126v) {
        this.f1753a = dialogInterfaceOnCancelListenerC0126v;
    }

    @Override // androidx.lifecycle.E
    public final void a(Object obj) {
        boolean z;
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        if (((InterfaceC0150u) obj) != null) {
            DialogInterfaceOnCancelListenerC0126v dialogInterfaceOnCancelListenerC0126v = this.f1753a;
            z = dialogInterfaceOnCancelListenerC0126v.mShowsDialog;
            if (z) {
                View requireView = dialogInterfaceOnCancelListenerC0126v.requireView();
                if (requireView.getParent() == null) {
                    dialog = dialogInterfaceOnCancelListenerC0126v.mDialog;
                    if (dialog != null) {
                        if (h0.K(3)) {
                            StringBuilder sb = new StringBuilder("DialogFragment ");
                            sb.append(this);
                            sb.append(" setting the content view on ");
                            dialog3 = dialogInterfaceOnCancelListenerC0126v.mDialog;
                            sb.append(dialog3);
                            Log.d("FragmentManager", sb.toString());
                        }
                        dialog2 = dialogInterfaceOnCancelListenerC0126v.mDialog;
                        dialog2.setContentView(requireView);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
        }
    }
}
