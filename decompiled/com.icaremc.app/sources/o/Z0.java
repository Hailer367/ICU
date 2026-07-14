package o;

import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class Z0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5551f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SearchView f5552g;

    public /* synthetic */ Z0(SearchView searchView, int i4) {
        this.f5551f = i4;
        this.f5552g = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5551f) {
            case 0:
                this.f5552g.r();
                return;
            default:
                M.c cVar = this.f5552g.f2385T;
                if (cVar instanceof j1) {
                    cVar.b(null);
                    return;
                }
                return;
        }
    }
}
