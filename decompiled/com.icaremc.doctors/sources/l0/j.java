package l0;

import a.AbstractC0051a;
import android.app.Activity;
import c1.p;
import n1.r;

/* loaded from: classes.dex */
public final class j extends V0.h implements p {

    /* renamed from: c, reason: collision with root package name */
    public int f2939c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f2940d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b f2941e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Activity f2942f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(b bVar, Activity activity, T0.d dVar) {
        super(2, dVar);
        this.f2941e = bVar;
        this.f2942f = activity;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        j jVar = new j(this.f2941e, this.f2942f, dVar);
        jVar.f2940d = obj;
        return jVar;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((r) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, Y.d] */
    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f2939c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            r rVar = (r) this.f2940d;
            i iVar = new i(rVar);
            b bVar = this.f2941e;
            ((m0.a) bVar.f2924c).a(this.f2942f, new Object(), iVar);
            M.a aVar2 = new M.a(2, bVar, iVar);
            this.f2939c = 1;
            if (n1.j.b(rVar, aVar2, this) == aVar) {
                return aVar;
            }
        }
        return Q0.j.f722a;
    }
}
