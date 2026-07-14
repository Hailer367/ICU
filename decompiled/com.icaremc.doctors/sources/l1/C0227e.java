package l1;

/* renamed from: l1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0227e implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2984a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2985b;

    public /* synthetic */ C0227e(int i2, Object obj) {
        this.f2984a = i2;
        this.f2985b = obj;
    }

    public final String toString() {
        switch (this.f2984a) {
            case 0:
                return "CancelHandler.UserSupplied[" + ((c1.l) this.f2985b).getClass().getSimpleName() + '@' + AbstractC0244w.b(this) + ']';
            default:
                return "DisposeOnCancel[" + ((D) this.f2985b) + ']';
        }
    }
}
