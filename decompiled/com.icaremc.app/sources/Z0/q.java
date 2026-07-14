package Z0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class q implements IInterface {

    /* renamed from: f, reason: collision with root package name */
    public final IBinder f2174f;

    public q(IBinder iBinder) {
        this.f2174f = iBinder;
    }

    public final void a(v vVar, C0138d c0138d) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(vVar);
            obtain.writeInt(1);
            L.g.a(c0138d, obtain, 0);
            this.f2174f.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2174f;
    }
}
