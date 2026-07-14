package O;

/* loaded from: classes.dex */
public final class J extends T2.i implements S2.l {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ N f1108g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(N n3) {
        super(1);
        this.f1108g = n3;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        Throwable th = (Throwable) obj;
        N n3 = this.f1108g;
        if (th != null) {
            n3.f1126m.w(new Z(th));
        }
        if (n3.f1128o.f678g != H2.h.f680a) {
            ((W) n3.f1128o.a()).close();
        }
        return H2.i.f681a;
    }
}
