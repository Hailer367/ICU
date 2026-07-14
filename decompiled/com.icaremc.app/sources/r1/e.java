package r1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class e implements g, IInterface {

    /* renamed from: f, reason: collision with root package name */
    public final IBinder f6021f;

    public e(IBinder iBinder) {
        this.f6021f = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f6021f;
    }

    @Override // r1.g
    public final void c(String str, Bundle bundle, q1.i iVar) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        obtain.writeString(str);
        int i4 = d.f6020a;
        obtain.writeInt(1);
        bundle.writeToParcel(obtain, 0);
        obtain.writeStrongBinder(iVar);
        try {
            this.f6021f.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // r1.g
    public final void g(String str, Bundle bundle, q1.h hVar) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        obtain.writeString(str);
        int i4 = d.f6020a;
        obtain.writeInt(1);
        bundle.writeToParcel(obtain, 0);
        obtain.writeStrongBinder(hVar);
        try {
            this.f6021f.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
