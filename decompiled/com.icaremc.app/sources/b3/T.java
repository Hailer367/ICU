package b3;

/* loaded from: classes.dex */
public final class T extends C0232g {

    /* renamed from: n, reason: collision with root package name */
    public final C0238m f3253n;

    public T(K2.d dVar, C0238m c0238m) {
        super(1, dVar);
        this.f3253n = c0238m;
    }

    @Override // b3.C0232g
    public final Throwable q(W w2) {
        Throwable d4;
        C0238m c0238m = this.f3253n;
        c0238m.getClass();
        Object obj = W.f3262f.get(c0238m);
        if ((obj instanceof V) && (d4 = ((V) obj).d()) != null) {
            return d4;
        }
        if (obj instanceof C0240o) {
            return ((C0240o) obj).f3290a;
        }
        return w2.w();
    }

    @Override // b3.C0232g
    public final String x() {
        return "AwaitContinuation";
    }
}
