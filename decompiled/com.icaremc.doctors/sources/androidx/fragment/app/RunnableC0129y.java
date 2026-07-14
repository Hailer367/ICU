package androidx.fragment.app;

/* renamed from: androidx.fragment.app.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0129y implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1769c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ H f1770d;

    public /* synthetic */ RunnableC0129y(H h2, int i2) {
        this.f1769c = i2;
        this.f1770d = h2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1769c) {
            case 0:
                this.f1770d.startPostponedEnterTransition();
                return;
            default:
                this.f1770d.callStartTransitionListener(false);
                return;
        }
    }
}
