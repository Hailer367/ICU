package l;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f2806c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f2807d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f2808e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ F.h f2809f;

    public e(F.h hVar, f fVar, k kVar, j jVar) {
        this.f2809f = hVar;
        this.f2806c = fVar;
        this.f2807d = kVar;
        this.f2808e = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = (g) this.f2809f.f274d;
        f fVar = this.f2806c;
        if (fVar != null) {
            gVar.f2814B = true;
            fVar.f2811b.c(false);
            gVar.f2814B = false;
        }
        k kVar = this.f2807d;
        if (kVar.isEnabled() && kVar.hasSubMenu()) {
            this.f2808e.p(kVar, null, 4);
        }
    }
}
