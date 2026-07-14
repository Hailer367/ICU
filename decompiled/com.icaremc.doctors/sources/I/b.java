package I;

import android.database.DataSetObserver;
import m.J;
import m.e0;

/* loaded from: classes.dex */
public final class b extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f313a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f314b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f313a = i2;
        this.f314b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f313a) {
            case 0:
                e0 e0Var = (e0) this.f314b;
                e0Var.f315c = true;
                e0Var.notifyDataSetChanged();
                return;
            default:
                J j2 = (J) this.f314b;
                if (j2.f3083x.isShowing()) {
                    j2.show();
                    return;
                }
                return;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f313a) {
            case 0:
                e0 e0Var = (e0) this.f314b;
                e0Var.f315c = false;
                e0Var.notifyDataSetInvalidated();
                return;
            default:
                ((J) this.f314b).dismiss();
                return;
        }
    }
}
