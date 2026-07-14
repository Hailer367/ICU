package d2;

import X0.i;
import android.util.Log;
import e.r;
import e.t;
import n.p;
import p1.C0580i;
import q1.AbstractC0602b;
import q1.C0605e;
import q1.j;
import r1.o;

/* renamed from: d2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0262c implements S2.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3478f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3479g;

    public /* synthetic */ C0262c(int i4, Object obj) {
        this.f3478f = i4;
        this.f3479g = obj;
    }

    @Override // S2.a
    public final Object a() {
        switch (this.f3478f) {
            case 0:
                C0605e c0605e = ((C0265f) this.f3479g).f3491n;
                if (c0605e != null) {
                    j jVar = c0605e.f5951a;
                    String packageName = c0605e.f5953c.getPackageName();
                    o oVar = jVar.f5964a;
                    if (oVar == null) {
                        p pVar = j.f5962e;
                        Object[] objArr = {-9};
                        pVar.getClass();
                        if (Log.isLoggable("PlayCore", 6)) {
                            Log.e("PlayCore", p.p((String) pVar.f5322g, "onError(%d)", objArr));
                        }
                        AbstractC0602b.z(new i(-9));
                    } else {
                        j.f5962e.o("completeUpdate(%s)", packageName);
                        C0580i c0580i = new C0580i();
                        oVar.a().post(new q1.f(oVar, c0580i, c0580i, new q1.f(jVar, c0580i, c0580i, packageName, 1), 2));
                    }
                }
                return H2.i.f681a;
            default:
                return new r((t) this.f3479g);
        }
    }
}
