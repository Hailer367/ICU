package R0;

import f.C0189e;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f734c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f735d;

    public /* synthetic */ a(int i2, Object obj) {
        this.f734c = i2;
        this.f735d = obj;
    }

    @Override // c1.l
    public final Object invoke(Object it) {
        switch (this.f734c) {
            case 0:
                if (it == ((e) this.f735d)) {
                    return "(this Collection)";
                }
                return String.valueOf(it);
            case 1:
                C0189e c0189e = (C0189e) this.f735d;
                kotlin.jvm.internal.h.e(it, "it");
                return c0189e.invoke();
            default:
                ((t1.c) this.f735d).e(null);
                return Q0.j.f722a;
        }
    }

    public /* synthetic */ a(t1.c cVar, t1.b bVar) {
        this.f734c = 2;
        this.f735d = cVar;
    }
}
