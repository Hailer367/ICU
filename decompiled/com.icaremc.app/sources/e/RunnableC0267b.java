package e;

import androidx.fragment.app.AbstractActivityC0192y;

/* renamed from: e.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0267b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3546f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0192y f3547g;

    public /* synthetic */ RunnableC0267b(AbstractActivityC0192y abstractActivityC0192y, int i4) {
        this.f3546f = i4;
        this.f3547g = abstractActivityC0192y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3546f) {
            case 0:
                l.d(this.f3547g);
                return;
            default:
                this.f3547g.invalidateMenu();
                return;
        }
    }
}
