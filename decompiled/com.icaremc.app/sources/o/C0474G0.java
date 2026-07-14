package o;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* renamed from: o.G0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0474G0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5457f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5458g;

    public /* synthetic */ C0474G0(int i4, Object obj) {
        this.f5457f = i4;
        this.f5458g = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i4, long j4) {
        C0462A0 c0462a0;
        switch (this.f5457f) {
            case 0:
                if (i4 != -1 && (c0462a0 = ((AbstractC0486M0) this.f5458g).f5483h) != null) {
                    c0462a0.setListSelectionHidden(false);
                    return;
                }
                return;
            default:
                ((SearchView) this.f5458g).n(i4);
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i4 = this.f5457f;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }
}
