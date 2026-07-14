package j;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* renamed from: j.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0409d implements AdapterView.OnItemClickListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0413h f4943f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0410e f4944g;

    public C0409d(C0410e c0410e, C0413h c0413h) {
        this.f4944g = c0410e;
        this.f4943f = c0413h;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        C0410e c0410e = this.f4944g;
        DialogInterface.OnClickListener onClickListener = c0410e.f4957n;
        C0413h c0413h = this.f4943f;
        onClickListener.onClick(c0413h.f4968b, i4);
        if (!c0410e.f4958o) {
            c0413h.f4968b.dismiss();
        }
    }
}
