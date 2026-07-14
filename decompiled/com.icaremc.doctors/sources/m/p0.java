package m;

/* loaded from: classes.dex */
public final class p0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3223c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q0 f3224d;

    public /* synthetic */ p0(q0 q0Var, int i2) {
        this.f3223c = i2;
        this.f3224d = q0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3223c) {
            case 0:
                this.f3224d.c(false);
                return;
            default:
                this.f3224d.a();
                return;
        }
    }
}
