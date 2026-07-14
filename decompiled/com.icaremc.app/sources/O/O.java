package O;

import java.io.FileInputStream;

/* loaded from: classes.dex */
public final class O extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public Object f1131i;

    /* renamed from: j, reason: collision with root package name */
    public FileInputStream f1132j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ P f1133l;

    /* renamed from: m, reason: collision with root package name */
    public int f1134m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(P p3, M2.c cVar) {
        super(cVar);
        this.f1133l = p3;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.k = obj;
        this.f1134m |= Integer.MIN_VALUE;
        return P.a(this.f1133l, this);
    }
}
