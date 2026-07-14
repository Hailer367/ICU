package Z0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* loaded from: classes.dex */
public final class v extends j1.g {

    /* renamed from: g, reason: collision with root package name */
    public com.google.android.gms.common.internal.a f2181g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2182h;

    public v(com.google.android.gms.common.internal.a aVar, int i4) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.f2181g = aVar;
        this.f2182h = i4;
    }

    @Override // j1.g
    public final boolean h(int i4, Parcel parcel, Parcel parcel2) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return false;
                }
                int readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                z zVar = (z) j1.h.a(parcel, z.CREATOR);
                j1.h.b(parcel);
                com.google.android.gms.common.internal.a aVar = this.f2181g;
                r.f(aVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
                r.e(zVar);
                aVar.f3391v = zVar;
                Bundle bundle = zVar.f2188f;
                r.f(this.f2181g, "onPostInitComplete can be called only once per call to getRemoteService");
                com.google.android.gms.common.internal.a aVar2 = this.f2181g;
                int i5 = this.f2182h;
                aVar2.getClass();
                x xVar = new x(aVar2, readInt, readStrongBinder, bundle);
                u uVar = aVar2.f3375e;
                uVar.sendMessage(uVar.obtainMessage(1, i5, -1, xVar));
                this.f2181g = null;
            } else {
                parcel.readInt();
                j1.h.b(parcel);
                Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            }
        } else {
            int readInt2 = parcel.readInt();
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            Bundle bundle2 = (Bundle) j1.h.a(parcel, Bundle.CREATOR);
            j1.h.b(parcel);
            r.f(this.f2181g, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar3 = this.f2181g;
            int i6 = this.f2182h;
            aVar3.getClass();
            x xVar2 = new x(aVar3, readInt2, readStrongBinder2, bundle2);
            u uVar2 = aVar3.f3375e;
            uVar2.sendMessage(uVar2.obtainMessage(1, i6, -1, xVar2));
            this.f2181g = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
