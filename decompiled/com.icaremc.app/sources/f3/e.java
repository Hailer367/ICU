package f3;

import a.AbstractC0141a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class e implements i {

    /* renamed from: f, reason: collision with root package name */
    public final K2.i f3718f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3719g;

    /* renamed from: h, reason: collision with root package name */
    public final d3.a f3720h;

    public e(K2.i iVar, int i4, d3.a aVar) {
        this.f3718f = iVar;
        this.f3719g = i4;
        this.f3720h = aVar;
    }

    public abstract Object a(d3.r rVar, K2.d dVar);

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        K2.j jVar = K2.j.f942f;
        K2.i iVar = this.f3718f;
        if (iVar != jVar) {
            arrayList.add("context=" + iVar);
        }
        int i4 = this.f3719g;
        if (i4 != -3) {
            arrayList.add("capacity=" + i4);
        }
        d3.a aVar = d3.a.f3492f;
        d3.a aVar2 = this.f3720h;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        return getClass().getSimpleName() + '[' + I2.e.G(arrayList, ", ", null, null, null, 62) + ']';
    }

    @Override // e3.d
    public Object u(e3.e eVar, K2.d dVar) {
        c cVar = new c(eVar, this, null);
        g3.q qVar = new g3.q(dVar, dVar.getContext());
        Object G3 = AbstractC0141a.G(qVar, qVar, cVar);
        if (G3 == L2.a.f1019f) {
            return G3;
        }
        return H2.i.f681a;
    }
}
