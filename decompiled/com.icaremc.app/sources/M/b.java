package M;

import android.database.DataSetObserver;
import o.AbstractC0486M0;
import o.j1;

/* loaded from: classes.dex */
public final class b extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1023a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1024b;

    public /* synthetic */ b(int i4, Object obj) {
        this.f1023a = i4;
        this.f1024b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f1023a) {
            case 0:
                j1 j1Var = (j1) this.f1024b;
                j1Var.f1025f = true;
                j1Var.notifyDataSetChanged();
                return;
            default:
                AbstractC0486M0 abstractC0486M0 = (AbstractC0486M0) this.f1024b;
                if (abstractC0486M0.f5480D.isShowing()) {
                    abstractC0486M0.c();
                    return;
                }
                return;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f1023a) {
            case 0:
                j1 j1Var = (j1) this.f1024b;
                j1Var.f1025f = false;
                j1Var.notifyDataSetInvalidated();
                return;
            default:
                ((AbstractC0486M0) this.f1024b).dismiss();
                return;
        }
    }
}
