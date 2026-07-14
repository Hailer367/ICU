package Z0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class w implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f2183a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f2184b;

    public w(com.google.android.gms.common.internal.a aVar, int i4) {
        this.f2184b = aVar;
        this.f2183a = i4;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        q qVar;
        int i4;
        int i5;
        com.google.android.gms.common.internal.a aVar = this.f2184b;
        if (iBinder == null) {
            synchronized (aVar.f3376f) {
                i4 = aVar.f3382m;
            }
            if (i4 == 3) {
                aVar.f3390u = true;
                i5 = 5;
            } else {
                i5 = 4;
            }
            u uVar = aVar.f3375e;
            uVar.sendMessage(uVar.obtainMessage(i5, aVar.f3392w.get(), 16));
            return;
        }
        synchronized (aVar.f3377g) {
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface != null && (queryLocalInterface instanceof q)) {
                    qVar = (q) queryLocalInterface;
                } else {
                    qVar = new q(iBinder);
                }
                aVar.f3378h = qVar;
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.common.internal.a aVar2 = this.f2184b;
        int i6 = this.f2183a;
        aVar2.getClass();
        y yVar = new y(aVar2, 0, null);
        u uVar2 = aVar2.f3375e;
        uVar2.sendMessage(uVar2.obtainMessage(7, i6, -1, yVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.a aVar = this.f2184b;
        synchronized (aVar.f3377g) {
            aVar.f3378h = null;
        }
        com.google.android.gms.common.internal.a aVar2 = this.f2184b;
        int i4 = this.f2183a;
        u uVar = aVar2.f3375e;
        uVar.sendMessage(uVar.obtainMessage(6, i4, 1));
    }
}
