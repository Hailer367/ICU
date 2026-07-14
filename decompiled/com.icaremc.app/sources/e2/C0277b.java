package e2;

import A.j;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import s2.C0635g;
import s2.InterfaceC0636h;

/* renamed from: e2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0277b extends BroadcastReceiver implements InterfaceC0636h {

    /* renamed from: f, reason: collision with root package name */
    public final R1.c f3599f;

    /* renamed from: g, reason: collision with root package name */
    public C0635g f3600g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f3601h = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name */
    public C0276a f3602i;

    public C0277b(Context context, R1.c cVar) {
        this.f3599f = cVar;
    }

    @Override // s2.InterfaceC0636h
    public final void c(C0635g c0635g) {
        this.f3600g = c0635g;
        C0276a c0276a = new C0276a(this);
        this.f3602i = c0276a;
        R1.c cVar = this.f3599f;
        ((ConnectivityManager) cVar.f1532g).registerDefaultNetworkCallback(c0276a);
        ConnectivityManager connectivityManager = (ConnectivityManager) cVar.f1532g;
        this.f3601h.post(new j(7, this, R1.c.j(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()))));
    }

    @Override // s2.InterfaceC0636h
    public final void onCancel() {
        C0276a c0276a = this.f3602i;
        if (c0276a != null) {
            ((ConnectivityManager) this.f3599f.f1532g).unregisterNetworkCallback(c0276a);
            this.f3602i = null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        C0635g c0635g = this.f3600g;
        if (c0635g != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f3599f.f1532g;
            c0635g.a(R1.c.j(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())));
        }
    }
}
