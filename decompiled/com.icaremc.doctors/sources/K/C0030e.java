package K;

import a.AbstractC0051a;
import java.util.List;

/* renamed from: K.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0030e extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f463c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f464d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f465e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0030e(List list, T0.d dVar) {
        super(2, dVar);
        this.f465e = list;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        C0030e c0030e = new C0030e(this.f465e, dVar);
        c0030e.f464d = obj;
        return c0030e;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0030e) create((C0037l) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f463c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            C0037l c0037l = (C0037l) this.f464d;
            this.f463c = 1;
            if (AbstractC0051a.a(this.f465e, c0037l, this) == aVar) {
                return aVar;
            }
        }
        return Q0.j.f722a;
    }
}
