package Z0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public final class x extends p {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f2185g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f2186h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(com.google.android.gms.common.internal.a aVar, int i4, IBinder iBinder, Bundle bundle) {
        super(aVar, i4, bundle);
        this.f2186h = aVar;
        this.f2185g = iBinder;
    }

    @Override // Z0.p
    public final boolean a() {
        IBinder iBinder = this.f2185g;
        try {
            r.e(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            com.google.android.gms.common.internal.a aVar = this.f2186h;
            if (!aVar.j().equals(interfaceDescriptor)) {
                String j4 = aVar.j();
                StringBuilder sb = new StringBuilder(j4.length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(j4);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.w("GmsClient", sb.toString());
                return false;
            }
            IInterface c4 = aVar.c(iBinder);
            if (c4 == null || (!aVar.o(2, 4, c4) && !aVar.o(3, 4, c4))) {
                return false;
            }
            aVar.f3389t = null;
            A2.q qVar = aVar.f3383n;
            if (qVar != null) {
                ((X0.f) qVar.f93g).f();
                return true;
            }
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // Z0.p
    public final void b(W0.a aVar) {
        R1.c cVar = this.f2186h.f3384o;
        if (cVar != null) {
            ((X0.g) cVar.f1532g).a(aVar);
        }
        System.currentTimeMillis();
    }
}
