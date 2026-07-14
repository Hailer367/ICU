package o;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* renamed from: o.O, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0489O implements AdapterView.OnItemClickListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5502f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5503g;

    public /* synthetic */ C0489O(int i4, Object obj) {
        this.f5502f = i4;
        this.f5503g = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        switch (this.f5502f) {
            case 0:
                C0491Q c0491q = (C0491Q) this.f5503g;
                C0494U c0494u = c0491q.f5510K;
                c0494u.setSelection(i4);
                if (c0494u.getOnItemClickListener() != null) {
                    c0494u.performItemClick(view, i4, c0491q.f5507H.getItemId(i4));
                }
                c0491q.dismiss();
                return;
            default:
                ((SearchView) this.f5503g).m(i4);
                return;
        }
    }
}
