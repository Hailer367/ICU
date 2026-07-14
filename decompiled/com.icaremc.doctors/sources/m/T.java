package m;

import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class T implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3105c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SearchView f3106d;

    public /* synthetic */ T(SearchView searchView, int i2) {
        this.f3105c = i2;
        this.f3106d = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3105c) {
            case 0:
                this.f3106d.q();
                return;
            default:
                I.c cVar = this.f3106d.f1158Q;
                if (cVar instanceof e0) {
                    cVar.b(null);
                    return;
                }
                return;
        }
    }
}
