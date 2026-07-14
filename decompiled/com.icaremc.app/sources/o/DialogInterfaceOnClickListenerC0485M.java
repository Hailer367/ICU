package o;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import j.C0410e;
import j.DialogInterfaceC0414i;

/* renamed from: o.M, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0485M implements InterfaceC0493T, DialogInterface.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    public DialogInterfaceC0414i f5471f;

    /* renamed from: g, reason: collision with root package name */
    public C0487N f5472g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f5473h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ C0494U f5474i;

    public DialogInterfaceOnClickListenerC0485M(C0494U c0494u) {
        this.f5474i = c0494u;
    }

    @Override // o.InterfaceC0493T
    public final int a() {
        return 0;
    }

    @Override // o.InterfaceC0493T
    public final boolean b() {
        DialogInterfaceC0414i dialogInterfaceC0414i = this.f5471f;
        if (dialogInterfaceC0414i != null) {
            return dialogInterfaceC0414i.isShowing();
        }
        return false;
    }

    @Override // o.InterfaceC0493T
    public final Drawable d() {
        return null;
    }

    @Override // o.InterfaceC0493T
    public final void dismiss() {
        DialogInterfaceC0414i dialogInterfaceC0414i = this.f5471f;
        if (dialogInterfaceC0414i != null) {
            dialogInterfaceC0414i.dismiss();
            this.f5471f = null;
        }
    }

    @Override // o.InterfaceC0493T
    public final void g(CharSequence charSequence) {
        this.f5473h = charSequence;
    }

    @Override // o.InterfaceC0493T
    public final void h(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // o.InterfaceC0493T
    public final void i(int i4) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // o.InterfaceC0493T
    public final void j(int i4) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // o.InterfaceC0493T
    public final void k(int i4) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // o.InterfaceC0493T
    public final void l(int i4, int i5) {
        if (this.f5472g == null) {
            return;
        }
        C0494U c0494u = this.f5474i;
        F.k kVar = new F.k(c0494u.getPopupContext());
        C0410e c0410e = (C0410e) kVar.f510b;
        CharSequence charSequence = this.f5473h;
        if (charSequence != null) {
            c0410e.f4948d = charSequence;
        }
        C0487N c0487n = this.f5472g;
        int selectedItemPosition = c0494u.getSelectedItemPosition();
        c0410e.f4956m = c0487n;
        c0410e.f4957n = this;
        c0410e.f4959p = selectedItemPosition;
        c0410e.f4958o = true;
        DialogInterfaceC0414i a4 = kVar.a();
        this.f5471f = a4;
        AlertController$RecycleListView alertController$RecycleListView = a4.f4992l.f4972f;
        AbstractC0481K.d(alertController$RecycleListView, i4);
        AbstractC0481K.c(alertController$RecycleListView, i5);
        this.f5471f.show();
    }

    @Override // o.InterfaceC0493T
    public final int m() {
        return 0;
    }

    @Override // o.InterfaceC0493T
    public final CharSequence n() {
        return this.f5473h;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        C0494U c0494u = this.f5474i;
        c0494u.setSelection(i4);
        if (c0494u.getOnItemClickListener() != null) {
            c0494u.performItemClick(null, i4, this.f5472g.getItemId(i4));
        }
        dismiss();
    }

    @Override // o.InterfaceC0493T
    public final void p(ListAdapter listAdapter) {
        this.f5472g = (C0487N) listAdapter;
    }
}
