package h2;

/* loaded from: classes.dex */
public final class o implements io.flutter.embedding.engine.renderer.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.flutter.embedding.engine.renderer.j f4012a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A.k f4013b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f4014c;

    public o(p pVar, io.flutter.embedding.engine.renderer.j jVar, A.k kVar) {
        this.f4014c = pVar;
        this.f4012a = jVar;
        this.f4013b = kVar;
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void b() {
        C0354g c0354g;
        this.f4012a.g(this);
        this.f4013b.run();
        p pVar = this.f4014c;
        if (!(pVar.k instanceof C0354g) && (c0354g = pVar.f4027j) != null) {
            c0354g.a();
            C0354g c0354g2 = pVar.f4027j;
            if (c0354g2 != null) {
                c0354g2.f3991f.close();
                pVar.removeView(pVar.f4027j);
                pVar.f4027j = null;
            }
        }
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void a() {
    }
}
