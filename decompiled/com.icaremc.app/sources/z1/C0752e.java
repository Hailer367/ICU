package z1;

import H2.i;
import S2.p;
import b3.InterfaceC0243s;
import e3.s;

/* renamed from: z1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0752e extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public int f6640j;
    public final /* synthetic */ h k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ S.d f6641l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0752e(h hVar, S.d dVar, K2.d dVar2) {
        super(2, dVar2);
        this.k = hVar;
        this.f6641l = dVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0752e) i((K2.d) obj2, (InterfaceC0243s) obj)).k(i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new C0752e(this.k, this.f6641l, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        Object c4;
        int i4 = this.f6640j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            e3.d data = this.k.f6650c.getData();
            this.f6640j = 1;
            obj = s.c(data, this);
            L2.a aVar = L2.a.f1019f;
            if (obj == aVar) {
                return aVar;
            }
        }
        S.b bVar = (S.b) obj;
        if (bVar != null && (c4 = bVar.c(this.f6641l)) != null) {
            return c4;
        }
        return -1L;
    }
}
