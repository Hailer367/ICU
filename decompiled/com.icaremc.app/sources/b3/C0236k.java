package b3;

/* renamed from: b3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0236k extends S implements InterfaceC0235j {

    /* renamed from: e, reason: collision with root package name */
    public final W f3283e;

    public C0236k(W w2) {
        this.f3283e = w2;
    }

    @Override // b3.InterfaceC0235j
    public final boolean b(Throwable th) {
        return i().s(th);
    }

    @Override // b3.S
    public final boolean j() {
        return true;
    }

    @Override // b3.S
    public final void k(Throwable th) {
        this.f3283e.o(i());
    }
}
