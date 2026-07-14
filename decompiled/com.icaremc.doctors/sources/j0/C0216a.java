package j0;

import K.C0044t;
import Q0.j;
import V0.h;
import a.AbstractC0051a;
import c1.p;
import l1.InterfaceC0242u;
import o1.d;

/* renamed from: j0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0216a extends h implements p {

    /* renamed from: c, reason: collision with root package name */
    public int f2728c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f2729d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ D.a f2730e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0216a(d dVar, D.a aVar, T0.d dVar2) {
        super(2, dVar2);
        this.f2729d = dVar;
        this.f2730e = aVar;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        return new C0216a(this.f2729d, this.f2730e, dVar);
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0216a) create((InterfaceC0242u) obj, (T0.d) obj2)).invokeSuspend(j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f2728c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            C0044t c0044t = new C0044t(2, this.f2730e);
            this.f2728c = 1;
            if (this.f2729d.collect(c0044t, this) == aVar) {
                return aVar;
            }
        }
        return j.f722a;
    }
}
