package j$.time.temporal;

/* loaded from: classes2.dex */
public final /* synthetic */ class o implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2666a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2667b;

    public /* synthetic */ o(int i2, int i3) {
        this.f2666a = i3;
        this.f2667b = i2;
    }

    @Override // j$.time.temporal.n
    public final m e(m mVar) {
        switch (this.f2666a) {
            case 0:
                int g2 = mVar.g(a.DAY_OF_WEEK);
                int i2 = this.f2667b;
                if (g2 == i2) {
                    return mVar;
                }
                return mVar.d(g2 - i2 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int g3 = mVar.g(a.DAY_OF_WEEK);
                int i3 = this.f2667b;
                if (g3 == i3) {
                    return mVar;
                }
                return mVar.a(i3 - g3 >= 0 ? 7 - r1 : -r1, b.DAYS);
        }
    }
}
