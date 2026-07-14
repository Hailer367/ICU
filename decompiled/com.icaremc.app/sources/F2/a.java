package F2;

import T2.h;
import android.content.Context;
import s2.C0644p;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final class a implements o2.c {

    /* renamed from: f, reason: collision with root package name */
    public C0644p f548f;

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        h.e(bVar, "binding");
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        h.d(interfaceC0634f, "getBinaryMessenger(...)");
        Context context = bVar.f5785a;
        h.d(context, "getApplicationContext(...)");
        this.f548f = new C0644p(interfaceC0634f, "PonnamKarthik/fluttertoast");
        E0.a aVar = new E0.a(2, false);
        aVar.f459g = context;
        C0644p c0644p = this.f548f;
        if (c0644p != null) {
            c0644p.b(aVar);
        }
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        h.e(bVar, "p0");
        C0644p c0644p = this.f548f;
        if (c0644p != null) {
            c0644p.b(null);
        }
        this.f548f = null;
    }
}
