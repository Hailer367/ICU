package z1;

import H2.i;
import I2.n;
import S2.p;
import b3.InterfaceC0243s;
import e3.s;

/* renamed from: z1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0751d extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public int f6639j;
    public final /* synthetic */ h k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0751d(h hVar, K2.d dVar) {
        super(2, dVar);
        this.k = hVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0751d) i((K2.d) obj2, (InterfaceC0243s) obj)).k(i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new C0751d(this.k, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f6639j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            e3.d data = this.k.f6650c.getData();
            this.f6639j = 1;
            obj = s.c(data, this);
            L2.a aVar = L2.a.f1019f;
            if (obj == aVar) {
                return aVar;
            }
        }
        S.b bVar = (S.b) obj;
        if (bVar != null) {
            return bVar.a();
        }
        return n.f863f;
    }
}
