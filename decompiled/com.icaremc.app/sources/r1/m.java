package r1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.ArrayList;
import n.p;

/* loaded from: classes.dex */
public final class m extends j {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ IBinder f6028g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f6029h;

    public m(n nVar, IBinder iBinder) {
        this.f6029h = nVar;
        this.f6028g = iBinder;
    }

    @Override // r1.j
    public final void a() {
        g eVar;
        o oVar = this.f6029h.f6030a;
        int i4 = f.f6022g;
        IBinder iBinder = this.f6028g;
        if (iBinder == null) {
            eVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
            if (queryLocalInterface instanceof g) {
                eVar = (g) queryLocalInterface;
            } else {
                eVar = new e(iBinder);
            }
        }
        oVar.f6043m = eVar;
        p pVar = oVar.f6033b;
        int i5 = 0;
        pVar.o("linkToDeath", new Object[0]);
        try {
            oVar.f6043m.asBinder().linkToDeath(oVar.f6041j, 0);
        } catch (RemoteException e4) {
            pVar.m(e4, "linkToDeath failed", new Object[0]);
        }
        oVar.f6038g = false;
        ArrayList arrayList = oVar.f6035d;
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((Runnable) obj).run();
        }
        oVar.f6035d.clear();
    }
}
