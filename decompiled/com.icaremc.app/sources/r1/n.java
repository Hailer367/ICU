package r1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class n implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f6030a;

    public /* synthetic */ n(o oVar) {
        this.f6030a = oVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        o oVar = this.f6030a;
        oVar.f6033b.o("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        oVar.a().post(new m(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        o oVar = this.f6030a;
        oVar.f6033b.o("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        oVar.a().post(new l(1, this));
    }
}
