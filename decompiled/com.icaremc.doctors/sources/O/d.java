package O;

import a.AbstractC0051a;
import c1.p;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class d extends V0.h implements p {

    /* renamed from: c, reason: collision with root package name */
    public int f629c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f630d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ V0.h f631e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(p pVar, T0.d dVar) {
        super(2, dVar);
        this.f631e = (V0.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [V0.h, c1.p] */
    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        d dVar2 = new d(this.f631e, dVar);
        dVar2.f630d = obj;
        return dVar2;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((g) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [V0.h, c1.p] */
    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f629c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            g gVar = (g) this.f630d;
            this.f629c = 1;
            obj = this.f631e.invoke(gVar, this);
            if (obj == aVar) {
                return aVar;
            }
        }
        g gVar2 = (g) obj;
        kotlin.jvm.internal.h.c(gVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
        ((AtomicBoolean) ((c) gVar2).f628b.f274d).set(true);
        return gVar2;
    }
}
