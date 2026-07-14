package h0;

import I.C0048b;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: h0.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0304G extends C0048b {

    /* renamed from: d, reason: collision with root package name */
    public final C0305H f3835d;

    public C0304G(C0305H c0305h) {
        this.f3835d = c0305h;
    }

    @Override // I.C0048b
    public final void b(View view, J.f fVar) {
        this.f721a.onInitializeAccessibilityNodeInfo(view, fVar.f875a);
        C0305H c0305h = this.f3835d;
        RecyclerView recyclerView = c0305h.f3836d;
        RecyclerView recyclerView2 = c0305h.f3836d;
        if (!recyclerView.l() && recyclerView2.getLayoutManager() != null) {
            recyclerView2.getLayoutManager().getClass();
            RecyclerView.j(view);
        }
    }

    @Override // I.C0048b
    public final boolean c(View view, int i4, Bundle bundle) {
        if (super.c(view, i4, bundle)) {
            return true;
        }
        C0305H c0305h = this.f3835d;
        RecyclerView recyclerView = c0305h.f3836d;
        RecyclerView recyclerView2 = c0305h.f3836d;
        if (!recyclerView.l() && recyclerView2.getLayoutManager() != null) {
            C0298A c0298a = recyclerView2.getLayoutManager().f3931b.f3107f;
        }
        return false;
    }
}
