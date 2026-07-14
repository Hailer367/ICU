package V0;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1697f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l f1698g;

    public /* synthetic */ j(l lVar, int i4) {
        this.f1697f = i4;
        this.f1698g = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1697f) {
            case 0:
                break;
            case 1:
                l lVar = this.f1698g;
                synchronized (lVar) {
                    if (lVar.f1701a == 1) {
                        lVar.a("Timed out while binding");
                    }
                }
                return;
            default:
                this.f1698g.a("Service disconnected");
                return;
        }
        while (true) {
            l lVar2 = this.f1698g;
            synchronized (lVar2) {
                try {
                    if (lVar2.f1701a == 2) {
                        if (lVar2.f1704d.isEmpty()) {
                            lVar2.c();
                            return;
                        }
                        m mVar = (m) lVar2.f1704d.poll();
                        lVar2.f1705e.put(mVar.f1707a, mVar);
                        lVar2.f1706f.f1714b.schedule(new F.a(3, lVar2, mVar), 30L, TimeUnit.SECONDS);
                        if (Log.isLoggable("MessengerIpcClient", 3)) {
                            Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(mVar)));
                        }
                        n nVar = lVar2.f1706f;
                        Messenger messenger = lVar2.f1702b;
                        int i4 = mVar.f1709c;
                        Context context = nVar.f1713a;
                        Message obtain = Message.obtain();
                        obtain.what = i4;
                        obtain.arg1 = mVar.f1707a;
                        obtain.replyTo = messenger;
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("oneWay", mVar.a());
                        bundle.putString("pkg", context.getPackageName());
                        bundle.putBundle("data", mVar.f1710d);
                        obtain.setData(bundle);
                        try {
                            E0.a aVar = lVar2.f1703c;
                            Messenger messenger2 = (Messenger) aVar.f459g;
                            if (messenger2 != null) {
                                messenger2.send(obtain);
                            } else {
                                g gVar = (g) aVar.f460h;
                                if (gVar != null) {
                                    Messenger messenger3 = gVar.f1689f;
                                    messenger3.getClass();
                                    messenger3.send(obtain);
                                } else {
                                    throw new IllegalStateException("Both messengers are null");
                                }
                            }
                        } catch (RemoteException e4) {
                            lVar2.a(e4.getMessage());
                        }
                    } else {
                        return;
                    }
                } finally {
                }
            }
        }
    }
}
