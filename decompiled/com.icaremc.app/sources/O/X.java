package O;

import java.io.FileOutputStream;

/* loaded from: classes.dex */
public final class X extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public FileOutputStream f1160i;

    /* renamed from: j, reason: collision with root package name */
    public FileOutputStream f1161j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Y f1162l;

    /* renamed from: m, reason: collision with root package name */
    public int f1163m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(Y y3, M2.c cVar) {
        super(cVar);
        this.f1162l = y3;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.k = obj;
        this.f1163m |= Integer.MIN_VALUE;
        return this.f1162l.b(null, this);
    }
}
