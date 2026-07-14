package e2;

import A2.q;
import A2.t;
import android.content.Context;
import android.net.ConnectivityManager;
import s2.C0644p;
import s2.InterfaceC0634f;

/* renamed from: e2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0278c implements o2.c {

    /* renamed from: f, reason: collision with root package name */
    public C0644p f3603f;

    /* renamed from: g, reason: collision with root package name */
    public t f3604g;

    /* renamed from: h, reason: collision with root package name */
    public C0277b f3605h;

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        Context context = bVar.f5785a;
        this.f3603f = new C0644p(interfaceC0634f, "dev.fluttercommunity.plus/connectivity");
        this.f3604g = new t(interfaceC0634f, "dev.fluttercommunity.plus/connectivity_status");
        R1.c cVar = new R1.c(18, (ConnectivityManager) context.getSystemService("connectivity"));
        q qVar = new q(20, cVar);
        this.f3605h = new C0277b(context, cVar);
        this.f3603f.b(qVar);
        this.f3604g.X(this.f3605h);
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        this.f3603f.b(null);
        this.f3604g.X(null);
        this.f3605h.onCancel();
        this.f3603f = null;
        this.f3604g = null;
        this.f3605h = null;
    }
}
