package A2;

import B2.C0008b;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements S2.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f74f;

    public /* synthetic */ f(int i4) {
        this.f74f = i4;
    }

    @Override // S2.a
    public final Object a() {
        int i4 = 1;
        switch (this.f74f) {
            case 0:
                return new A(0);
            case 1:
                return new C0008b(i4);
            case 2:
                return new A(i4);
            case 3:
                return new A(2);
            default:
                V2.a aVar = V2.e.f1772f;
                return Integer.valueOf(V2.e.f1772f.a().nextInt(2147418112) + 65536);
        }
    }
}
