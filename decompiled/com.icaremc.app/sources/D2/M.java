package D2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final /* synthetic */ class M implements S2.l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f301f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f302g;

    public /* synthetic */ M(int i4, Object obj) {
        this.f301f = i4;
        this.f302g = obj;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        switch (this.f301f) {
            case 0:
                ((S2.l) this.f302g).f(new N(((H2.f) obj).f676f));
                return H2.i.f681a;
            case 1:
                H1.j jVar = (H1.j) this.f302g;
                S.b bVar = (S.b) obj;
                S.d dVar = H1.j.f668c;
                long j4 = 0;
                for (Map.Entry entry : bVar.a().entrySet()) {
                    if (entry.getValue() instanceof Set) {
                        S.d dVar2 = (S.d) entry.getKey();
                        Set set = (Set) entry.getValue();
                        String b4 = jVar.b(System.currentTimeMillis());
                        if (set.contains(b4)) {
                            Object[] objArr = {b4};
                            HashSet hashSet = new HashSet(1);
                            Object obj2 = objArr[0];
                            Objects.requireNonNull(obj2);
                            if (hashSet.add(obj2)) {
                                bVar.e(dVar2, Collections.unmodifiableSet(hashSet));
                                j4++;
                            } else {
                                throw new IllegalArgumentException("duplicate element: " + obj2);
                            }
                        } else {
                            bVar.d(dVar2);
                        }
                    }
                }
                if (j4 == 0) {
                    bVar.d(dVar);
                    return null;
                }
                bVar.e(dVar, Long.valueOf(j4));
                return null;
            case 2:
                A2.f fVar = (A2.f) this.f302g;
                T2.h.e(obj, "it");
                return fVar.a();
            default:
                ((j3.c) this.f302g).e(null);
                return H2.i.f681a;
        }
    }

    public /* synthetic */ M(j3.c cVar, j3.b bVar) {
        this.f301f = 3;
        this.f302g = cVar;
    }
}
