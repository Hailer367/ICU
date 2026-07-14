package z1;

import H2.i;
import O.InterfaceC0080i;
import S2.l;
import S2.p;
import a.AbstractC0141a;
import b3.InterfaceC0243s;

/* renamed from: z1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0750c extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public int f6637j;
    public final /* synthetic */ h k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ l f6638l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0750c(h hVar, l lVar, K2.d dVar) {
        super(2, dVar);
        this.k = hVar;
        this.f6638l = lVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0750c) i((K2.d) obj2, (InterfaceC0243s) obj)).k(i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new C0750c(this.k, this.f6638l, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        h hVar = this.k;
        ThreadLocal threadLocal = hVar.f6649b;
        int i4 = this.f6637j;
        try {
            if (i4 != 0) {
                if (i4 == 1) {
                    k3.b.A(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                k3.b.A(obj);
                Object obj2 = threadLocal.get();
                Boolean bool = Boolean.TRUE;
                if (!T2.h.a(obj2, bool)) {
                    threadLocal.set(bool);
                    InterfaceC0080i interfaceC0080i = hVar.f6650c;
                    C0749b c0749b = new C0749b(this.f6638l, null);
                    this.f6637j = 1;
                    obj = AbstractC0141a.p(interfaceC0080i, c0749b, this);
                    L2.a aVar = L2.a.f1019f;
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    throw new IllegalStateException("Don't call JavaDataStorage.edit() from within an existing edit() callback.\nThis causes deadlocks, and is generally indicative of a code smell.\nInstead, either pass around the initial `MutablePreferences` instance, or don't do everything in a single callback. ");
                }
            }
            return (S.b) obj;
        } finally {
            threadLocal.set(Boolean.FALSE);
        }
    }
}
