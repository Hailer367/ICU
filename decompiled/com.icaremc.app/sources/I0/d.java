package I0;

/* loaded from: classes.dex */
public final class d implements C1.d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f809a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final C1.c f810b = new C1.c("logSource", A2.i.l(A2.i.k(F1.e.class, new F1.a(1))));

    /* renamed from: c, reason: collision with root package name */
    public static final C1.c f811c = new C1.c("logEventDropped", A2.i.l(A2.i.k(F1.e.class, new F1.a(2))));

    @Override // C1.a
    public final void a(Object obj, Object obj2) {
        L0.e eVar = (L0.e) obj;
        C1.e eVar2 = (C1.e) obj2;
        eVar2.c(f810b, eVar.f994a);
        eVar2.c(f811c, eVar.f995b);
    }
}
