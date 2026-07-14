package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.icaremc.app.R;

/* renamed from: androidx.fragment.app.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0185q extends AbstractComponentCallbacksC0187t implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: X, reason: collision with root package name */
    public final DialogInterfaceOnCancelListenerC0182n f2877X;

    /* renamed from: Y, reason: collision with root package name */
    public final DialogInterfaceOnDismissListenerC0183o f2878Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f2879Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f2880a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f2881b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2882c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f2883d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f2884e0;

    /* renamed from: f0, reason: collision with root package name */
    public final A2.q f2885f0;

    /* renamed from: g0, reason: collision with root package name */
    public Dialog f2886g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f2887h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f2888i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f2889j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f2890k0;

    public DialogInterfaceOnCancelListenerC0185q() {
        new F.b(7, this);
        this.f2877X = new DialogInterfaceOnCancelListenerC0182n(this);
        this.f2878Y = new DialogInterfaceOnDismissListenerC0183o(this);
        this.f2879Z = 0;
        this.f2880a0 = 0;
        this.f2881b0 = true;
        this.f2882c0 = true;
        this.f2883d0 = -1;
        this.f2885f0 = new A2.q(15, this);
        this.f2890k0 = false;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final A a() {
        return new C0184p(this, new C0184p(this));
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void j() {
        this.f2911I = true;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void l(Context context) {
        super.l(context);
        this.f2920S.c(this.f2885f0);
        if (!this.f2889j0) {
            this.f2888i0 = false;
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void m(Bundle bundle) {
        boolean z;
        Bundle bundle2;
        this.f2911I = true;
        Bundle bundle3 = this.f2925g;
        if (bundle3 != null && (bundle2 = bundle3.getBundle("childFragmentManager")) != null) {
            this.z.U(bundle2);
            Q q2 = this.z;
            q2.f2741G = false;
            q2.f2742H = false;
            q2.f2748N.f2788i = false;
            q2.u(1);
        }
        Q q3 = this.z;
        if (q3.f2769u < 1) {
            q3.f2741G = false;
            q3.f2742H = false;
            q3.f2748N.f2788i = false;
            q3.u(1);
        }
        new Handler();
        if (this.f2905C == 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2882c0 = z;
        if (bundle != null) {
            this.f2879Z = bundle.getInt("android:style", 0);
            this.f2880a0 = bundle.getInt("android:theme", 0);
            this.f2881b0 = bundle.getBoolean("android:cancelable", true);
            this.f2882c0 = bundle.getBoolean("android:showsDialog", this.f2882c0);
            this.f2883d0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void n() {
        this.f2911I = true;
        Dialog dialog = this.f2886g0;
        if (dialog != null) {
            this.f2887h0 = true;
            dialog.setOnDismissListener(null);
            this.f2886g0.dismiss();
            if (!this.f2888i0) {
                onDismiss(this.f2886g0);
            }
            this.f2886g0 = null;
            this.f2890k0 = false;
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void o() {
        this.f2911I = true;
        if (!this.f2889j0 && !this.f2888i0) {
            this.f2888i0 = true;
        }
        this.f2920S.e(this.f2885f0);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        if (!this.f2887h0) {
            if (P.J(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            if (!this.f2888i0) {
                this.f2888i0 = true;
                this.f2889j0 = false;
                Dialog dialog = this.f2886g0;
                if (dialog != null) {
                    dialog.setOnDismissListener(null);
                    this.f2886g0.dismiss();
                }
                this.f2887h0 = true;
                if (this.f2883d0 >= 0) {
                    P e4 = e();
                    int i4 = this.f2883d0;
                    if (i4 >= 0) {
                        e4.y(new N(e4, i4), true);
                        this.f2883d0 = -1;
                        return;
                    }
                    throw new IllegalArgumentException(A2.i.g(i4, "Bad id: "));
                }
                C0169a c0169a = new C0169a(e());
                c0169a.f2829o = true;
                P p3 = this.f2941x;
                if (p3 != null && p3 != c0169a.f2830p) {
                    throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
                }
                c0169a.b(new Y(3, this));
                c0169a.d(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:10:0x001a, B:12:0x0027, B:18:0x003f, B:22:0x0048, B:23:0x0050, B:25:0x0044, B:26:0x0031, B:28:0x0037, B:29:0x003c, B:30:0x0068), top: B:9:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:10:0x001a, B:12:0x0027, B:18:0x003f, B:22:0x0048, B:23:0x0050, B:25:0x0044, B:26:0x0031, B:28:0x0037, B:29:0x003c, B:30:0x0068), top: B:9:0x001a }] */
    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater p(android.os.Bundle r9) {
        /*
            r8 = this;
            android.view.LayoutInflater r9 = super.p(r9)
            boolean r0 = r8.f2882c0
            java.lang.String r1 = "FragmentManager"
            r2 = 2
            if (r0 == 0) goto L99
            boolean r3 = r8.f2884e0
            if (r3 == 0) goto L11
            goto L99
        L11:
            if (r0 != 0) goto L14
            goto L70
        L14:
            boolean r0 = r8.f2890k0
            if (r0 != 0) goto L70
            r0 = 0
            r3 = 1
            r8.f2884e0 = r3     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r8.w()     // Catch: java.lang.Throwable -> L4e
            r8.f2886g0 = r4     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r8.f2882c0     // Catch: java.lang.Throwable -> L4e
            r6 = 0
            if (r5 == 0) goto L68
            int r5 = r8.f2879Z     // Catch: java.lang.Throwable -> L4e
            if (r5 == r3) goto L3c
            if (r5 == r2) goto L3c
            r7 = 3
            if (r5 == r7) goto L31
            goto L3f
        L31:
            android.view.Window r5 = r4.getWindow()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L3c
            r7 = 24
            r5.addFlags(r7)     // Catch: java.lang.Throwable -> L4e
        L3c:
            r4.requestWindowFeature(r3)     // Catch: java.lang.Throwable -> L4e
        L3f:
            androidx.fragment.app.x r4 = r8.f2942y     // Catch: java.lang.Throwable -> L4e
            if (r4 != 0) goto L44
            goto L46
        L44:
            j.k r6 = r4.f2949g     // Catch: java.lang.Throwable -> L4e
        L46:
            if (r6 == 0) goto L50
            android.app.Dialog r4 = r8.f2886g0     // Catch: java.lang.Throwable -> L4e
            r4.setOwnerActivity(r6)     // Catch: java.lang.Throwable -> L4e
            goto L50
        L4e:
            r9 = move-exception
            goto L6d
        L50:
            android.app.Dialog r4 = r8.f2886g0     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r8.f2881b0     // Catch: java.lang.Throwable -> L4e
            r4.setCancelable(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r8.f2886g0     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.n r5 = r8.f2877X     // Catch: java.lang.Throwable -> L4e
            r4.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r8.f2886g0     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.o r5 = r8.f2878Y     // Catch: java.lang.Throwable -> L4e
            r4.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L4e
            r8.f2890k0 = r3     // Catch: java.lang.Throwable -> L4e
            goto L6a
        L68:
            r8.f2886g0 = r6     // Catch: java.lang.Throwable -> L4e
        L6a:
            r8.f2884e0 = r0
            goto L70
        L6d:
            r8.f2884e0 = r0
            throw r9
        L70:
            boolean r0 = androidx.fragment.app.P.J(r2)
            if (r0 == 0) goto L8c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "get layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r2 = " from dialog context"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L8c:
            android.app.Dialog r0 = r8.f2886g0
            if (r0 == 0) goto Ld4
            android.content.Context r0 = r0.getContext()
            android.view.LayoutInflater r9 = r9.cloneInContext(r0)
            return r9
        L99:
            boolean r0 = androidx.fragment.app.P.J(r2)
            if (r0 == 0) goto Ld4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "getting layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r2 = r8.f2882c0
            if (r2 != 0) goto Lc3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "mShowsDialog = false: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.d(r1, r0)
            return r9
        Lc3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "mCreatingDialog = true: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.d(r1, r0)
        Ld4:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DialogInterfaceOnCancelListenerC0185q.p(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void q(Bundle bundle) {
        Dialog dialog = this.f2886g0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i4 = this.f2879Z;
        if (i4 != 0) {
            bundle.putInt("android:style", i4);
        }
        int i5 = this.f2880a0;
        if (i5 != 0) {
            bundle.putInt("android:theme", i5);
        }
        boolean z = this.f2881b0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z3 = this.f2882c0;
        if (!z3) {
            bundle.putBoolean("android:showsDialog", z3);
        }
        int i6 = this.f2883d0;
        if (i6 != -1) {
            bundle.putInt("android:backStackId", i6);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void r() {
        this.f2911I = true;
        Dialog dialog = this.f2886g0;
        if (dialog != null) {
            this.f2887h0 = false;
            dialog.show();
            View decorView = this.f2886g0.getWindow().getDecorView();
            T2.h.e(decorView, "<this>");
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void s() {
        this.f2911I = true;
        Dialog dialog = this.f2886g0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0187t
    public final void t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.t(layoutInflater, viewGroup, bundle);
        if (this.f2886g0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f2886g0.onRestoreInstanceState(bundle2);
        }
    }

    public Dialog w() {
        if (P.J(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new e.n(u(), this.f2880a0);
    }
}
