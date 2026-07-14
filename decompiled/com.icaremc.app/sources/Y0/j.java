package Y0;

/* loaded from: classes.dex */
public final class j implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f2046a;

    public j(d dVar) {
        this.f2046a = dVar;
    }

    @Override // Y0.b
    public final void a(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        d dVar = this.f2046a;
        dVar.f2041m.sendMessage(dVar.f2041m.obtainMessage(1, valueOf));
    }
}
