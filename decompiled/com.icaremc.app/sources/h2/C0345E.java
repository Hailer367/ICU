package h2;

/* renamed from: h2.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0345E implements io.flutter.embedding.engine.renderer.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f3956a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SurfaceHolderCallback2C0347G f3957b;

    public C0345E(SurfaceHolderCallback2C0347G surfaceHolderCallback2C0347G, Runnable runnable) {
        this.f3957b = surfaceHolderCallback2C0347G;
        this.f3956a = runnable;
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void b() {
        this.f3956a.run();
        io.flutter.embedding.engine.renderer.j jVar = this.f3957b.f3961b;
        if (jVar != null) {
            jVar.g(this);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void a() {
    }
}
