package z1;

import H2.i;
import S2.p;

/* renamed from: z1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0753f extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6642j;
    public final /* synthetic */ S.d k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Long f6643l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0753f(S.d dVar, Long l3, K2.d dVar2) {
        super(2, dVar2);
        this.k = dVar;
        this.f6643l = l3;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        C0753f c0753f = (C0753f) i((K2.d) obj2, (S.b) obj);
        i iVar = i.f681a;
        c0753f.k(iVar);
        return iVar;
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C0753f c0753f = new C0753f(this.k, this.f6643l, dVar);
        c0753f.f6642j = obj;
        return c0753f;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        k3.b.A(obj);
        ((S.b) this.f6642j).e(this.k, this.f6643l);
        return i.f681a;
    }
}
