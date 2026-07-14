package p1;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class e implements i {

    /* renamed from: c, reason: collision with root package name */
    public final T0.i f3478c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3479d;

    /* renamed from: e, reason: collision with root package name */
    public final n1.a f3480e;

    public e(T0.i iVar, int i2, n1.a aVar) {
        this.f3478c = iVar;
        this.f3479d = i2;
        this.f3480e = aVar;
    }

    @Override // p1.i
    public final o1.d a(T0.i iVar, int i2, n1.a aVar) {
        T0.i iVar2 = this.f3478c;
        T0.i d2 = iVar.d(iVar2);
        n1.a aVar2 = n1.a.f3306c;
        n1.a aVar3 = this.f3480e;
        int i3 = this.f3479d;
        if (aVar == aVar2) {
            if (i3 != -3) {
                if (i2 != -3) {
                    if (i3 != -2) {
                        if (i2 != -2) {
                            i2 += i3;
                            if (i2 < 0) {
                                i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            aVar = aVar3;
        }
        if (kotlin.jvm.internal.h.a(d2, iVar2) && i2 == i3 && aVar == aVar3) {
            return this;
        }
        return c(d2, i2, aVar);
    }

    public abstract Object b(n1.r rVar, T0.d dVar);

    public abstract e c(T0.i iVar, int i2, n1.a aVar);

    @Override // o1.d
    public Object collect(o1.e eVar, T0.d dVar) {
        c cVar = new c(eVar, this, null);
        q1.q qVar = new q1.q(dVar, dVar.getContext());
        Object G2 = android.support.v4.media.session.a.G(qVar, qVar, cVar);
        if (G2 == U0.a.f780c) {
            return G2;
        }
        return Q0.j.f722a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        T0.j jVar = T0.j.f774c;
        T0.i iVar = this.f3478c;
        if (iVar != jVar) {
            arrayList.add("context=" + iVar);
        }
        int i2 = this.f3479d;
        if (i2 != -3) {
            arrayList.add("capacity=" + i2);
        }
        n1.a aVar = n1.a.f3306c;
        n1.a aVar2 = this.f3480e;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        return getClass().getSimpleName() + '[' + R0.j.S(arrayList, ", ", null, null, null, 62) + ']';
    }
}
