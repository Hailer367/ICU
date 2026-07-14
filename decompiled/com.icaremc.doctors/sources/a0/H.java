package a0;

import E.C0002b;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class H extends C0002b {

    /* renamed from: d, reason: collision with root package name */
    public final I f910d;

    public H(I i2) {
        this.f910d = i2;
    }

    @Override // E.C0002b
    public final void b(View view, F.g gVar) {
        this.f211a.onInitializeAccessibilityNodeInfo(view, gVar.f272a);
        I i2 = this.f910d;
        RecyclerView recyclerView = i2.f911d;
        RecyclerView recyclerView2 = i2.f911d;
        if (!recyclerView.l() && recyclerView2.getLayoutManager() != null) {
            recyclerView2.getLayoutManager().getClass();
            RecyclerView.j(view);
        }
    }

    @Override // E.C0002b
    public final boolean c(View view, int i2, Bundle bundle) {
        if (super.c(view, i2, bundle)) {
            return true;
        }
        I i3 = this.f910d;
        RecyclerView recyclerView = i3.f911d;
        RecyclerView recyclerView2 = i3.f911d;
        if (!recyclerView.l() && recyclerView2.getLayoutManager() != null) {
            C0053B c0053b = recyclerView2.getLayoutManager().f1007b.f1923c;
        }
        return false;
    }
}
