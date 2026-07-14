package j$.time.temporal;

/* loaded from: classes2.dex */
public final /* synthetic */ class o implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4763a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4764b;

    public /* synthetic */ o(int i4, int i5) {
        this.f4763a = i5;
        this.f4764b = i4;
    }

    @Override // j$.time.temporal.n
    public final m e(m mVar) {
        switch (this.f4763a) {
            case 0:
                int g4 = mVar.g(a.DAY_OF_WEEK);
                int i4 = this.f4764b;
                if (g4 == i4) {
                    return mVar;
                }
                return mVar.d(g4 - i4 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int g5 = mVar.g(a.DAY_OF_WEEK);
                int i5 = this.f4764b;
                if (g5 == i5) {
                    return mVar;
                }
                return mVar.a(i5 - g5 >= 0 ? 7 - r1 : -r1, b.DAYS);
        }
    }
}
