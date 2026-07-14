package o;

/* renamed from: o.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0477I extends AbstractViewOnTouchListenerC0468D0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C0491Q f5465o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ C0494U f5466p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0477I(C0494U c0494u, C0494U c0494u2, C0491Q c0491q) {
        super(c0494u2);
        this.f5466p = c0494u;
        this.f5465o = c0491q;
    }

    @Override // o.AbstractViewOnTouchListenerC0468D0
    public final n.F b() {
        return this.f5465o;
    }

    @Override // o.AbstractViewOnTouchListenerC0468D0
    public final boolean c() {
        C0494U c0494u = this.f5466p;
        if (!c0494u.getInternalPopup().b()) {
            c0494u.k.l(AbstractC0481K.b(c0494u), AbstractC0481K.a(c0494u));
            return true;
        }
        return true;
    }
}
