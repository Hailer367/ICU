package l1;

/* loaded from: classes.dex */
public final class U extends C0230h {

    /* renamed from: k, reason: collision with root package name */
    public final C0236n f2967k;

    public U(T0.d dVar, C0236n c0236n) {
        super(1, dVar);
        this.f2967k = c0236n;
    }

    @Override // l1.C0230h
    public final Throwable p(X x2) {
        Throwable d2;
        C0236n c0236n = this.f2967k;
        c0236n.getClass();
        Object obj = X.f2976c.get(c0236n);
        if ((obj instanceof W) && (d2 = ((W) obj).d()) != null) {
            return d2;
        }
        if (obj instanceof C0238p) {
            return ((C0238p) obj).f3007a;
        }
        return x2.v();
    }

    @Override // l1.C0230h
    public final String w() {
        return "AwaitContinuation";
    }
}
