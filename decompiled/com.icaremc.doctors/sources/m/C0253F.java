package m;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* renamed from: m.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0253F implements AdapterView.OnItemSelectedListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3058c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3059d;

    public /* synthetic */ C0253F(int i2, Object obj) {
        this.f3058c = i2;
        this.f3059d = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i2, long j2) {
        L l2;
        switch (this.f3058c) {
            case 0:
                if (i2 != -1 && (l2 = ((J) this.f3059d).f3066e) != null) {
                    l2.setListSelectionHidden(false);
                    return;
                }
                return;
            default:
                ((SearchView) this.f3059d).m(i2);
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i2 = this.f3058c;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }
}
