package m;

import android.view.View;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public final class j0 implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3181c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3182d;

    public j0(o0 o0Var) {
        this.f3182d = o0Var;
        o0Var.f3208a.getContext();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        l.k kVar;
        switch (this.f3181c) {
            case 0:
                k0 k0Var = ((Toolbar) this.f3182d).f1229K;
                if (k0Var == null) {
                    kVar = null;
                } else {
                    kVar = k0Var.f3184d;
                }
                if (kVar != null) {
                    kVar.collapseActionView();
                    return;
                }
                return;
            default:
                o0 o0Var = (o0) this.f3182d;
                if (o0Var.f3218k != null) {
                    o0Var.getClass();
                    return;
                }
                return;
        }
    }

    public j0(Toolbar toolbar) {
        this.f3182d = toolbar;
    }
}
