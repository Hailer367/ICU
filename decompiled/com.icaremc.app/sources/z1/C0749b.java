package z1;

import H2.i;
import S2.l;
import S2.p;

/* renamed from: z1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0749b extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6636j;
    public final /* synthetic */ l k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0749b(l lVar, K2.d dVar) {
        super(2, dVar);
        this.k = lVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        C0749b c0749b = (C0749b) i((K2.d) obj2, (S.b) obj);
        i iVar = i.f681a;
        c0749b.k(iVar);
        return iVar;
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C0749b c0749b = new C0749b(this.k, dVar);
        c0749b.f6636j = obj;
        return c0749b;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        k3.b.A(obj);
        this.k.f((S.b) this.f6636j);
        return i.f681a;
    }
}
