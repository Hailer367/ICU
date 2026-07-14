package e2;

import A.j;
import A.k;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* renamed from: e2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0276a extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0277b f3598a;

    public C0276a(C0277b c0277b) {
        this.f3598a = c0277b;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        C0277b c0277b = this.f3598a;
        c0277b.f3601h.post(new j(7, c0277b, R1.c.j(((ConnectivityManager) c0277b.f3599f.f1532g).getNetworkCapabilities(network))));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        C0277b c0277b = this.f3598a;
        c0277b.f3599f.getClass();
        c0277b.f3601h.post(new j(7, c0277b, R1.c.j(networkCapabilities)));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        C0277b c0277b = this.f3598a;
        c0277b.f3601h.postDelayed(new k(10, c0277b), 500L);
    }
}
