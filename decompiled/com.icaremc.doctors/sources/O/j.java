package O;

import a.AbstractC0051a;
import c1.p;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class j extends V0.h implements p {

    /* renamed from: c, reason: collision with root package name */
    public int f635c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f636d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ V0.h f637e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j(p pVar, T0.d dVar) {
        super(2, dVar);
        this.f637e = (V0.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [V0.h, c1.p] */
    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        j jVar = new j(this.f637e, dVar);
        jVar.f636d = obj;
        return jVar;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((g) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [V0.h, c1.p] */
    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f635c;
        if (i2 != 0) {
            if (i2 == 1) {
                c cVar = (c) this.f636d;
                AbstractC0051a.V(obj);
                return cVar;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0051a.V(obj);
        c cVar2 = new c(new LinkedHashMap(((g) this.f636d).a()), false);
        this.f636d = cVar2;
        this.f635c = 1;
        if (this.f637e.invoke(cVar2, this) == aVar) {
            return aVar;
        }
        return cVar2;
    }
}
