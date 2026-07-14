package B2;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class v extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public Set f234i;

    /* renamed from: j, reason: collision with root package name */
    public Map f235j;
    public Iterator k;

    /* renamed from: l, reason: collision with root package name */
    public S.d f236l;

    /* renamed from: m, reason: collision with root package name */
    public int f237m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f238n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ K f239o;

    /* renamed from: p, reason: collision with root package name */
    public int f240p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(K k, M2.c cVar) {
        super(cVar);
        this.f239o = k;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f238n = obj;
        this.f240p |= Integer.MIN_VALUE;
        return K.h(this.f239o, null, this);
    }
}
