package O;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class D extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public Object f1085i;

    /* renamed from: j, reason: collision with root package name */
    public Object f1086j;
    public Serializable k;

    /* renamed from: l, reason: collision with root package name */
    public T2.p f1087l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1088m;

    /* renamed from: n, reason: collision with root package name */
    public int f1089n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f1090o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ N f1091p;

    /* renamed from: q, reason: collision with root package name */
    public int f1092q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(N n3, M2.c cVar) {
        super(cVar);
        this.f1091p = n3;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f1090o = obj;
        this.f1092q |= Integer.MIN_VALUE;
        return N.f(this.f1091p, false, this);
    }
}
