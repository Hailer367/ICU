package e0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l extends t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2200a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2201b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2202c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2203d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n f2204e;

    public l(n nVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f2204e = nVar;
        this.f2200a = obj;
        this.f2201b = arrayList;
        this.f2202c = obj2;
        this.f2203d = arrayList2;
    }

    @Override // e0.t, e0.r
    public final void a(s sVar) {
        n nVar = this.f2204e;
        Object obj = this.f2200a;
        if (obj != null) {
            nVar.t(obj, this.f2201b, null);
        }
        Object obj2 = this.f2202c;
        if (obj2 != null) {
            nVar.t(obj2, this.f2203d, null);
        }
    }

    @Override // e0.r
    public final void b(s sVar) {
        sVar.w(this);
    }
}
