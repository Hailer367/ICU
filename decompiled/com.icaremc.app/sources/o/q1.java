package o;

import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public final /* synthetic */ class q1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5686f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Toolbar f5687g;

    public /* synthetic */ q1(Toolbar toolbar, int i4) {
        this.f5686f = i4;
        this.f5687g = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.q qVar;
        switch (this.f5686f) {
            case 0:
                s1 s1Var = this.f5687g.f2466R;
                if (s1Var == null) {
                    qVar = null;
                } else {
                    qVar = s1Var.f5705g;
                }
                if (qVar != null) {
                    qVar.collapseActionView();
                    return;
                }
                return;
            default:
                this.f5687g.m();
                return;
        }
    }
}
