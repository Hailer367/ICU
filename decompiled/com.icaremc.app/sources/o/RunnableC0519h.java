package o;

import android.view.View;

/* renamed from: o.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0519h implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final C0515f f5585f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0523j f5586g;

    public RunnableC0519h(C0523j c0523j, C0515f c0515f) {
        this.f5586g = c0523j;
        this.f5585f = c0515f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.l lVar;
        C0523j c0523j = this.f5586g;
        n.n nVar = c0523j.f5603h;
        if (nVar != null && (lVar = nVar.f5298e) != null) {
            lVar.i(nVar);
        }
        View view = (View) c0523j.f5607m;
        if (view != null && view.getWindowToken() != null) {
            C0515f c0515f = this.f5585f;
            if (!c0515f.b()) {
                if (c0515f.f5365e != null) {
                    c0515f.d(0, 0, false, false);
                }
            }
            c0523j.f5618x = c0515f;
        }
        c0523j.z = null;
    }
}
