package com.google.android.play.core.appupdate.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb = "com.google.android.play.core.appupdate.protocol.IAppUpdateService";

    public zza(IBinder iBinder, String str) {
        this.zza = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    public final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        return obtain;
    }

    public final void zzb(int i2, Parcel parcel) {
        try {
            this.zza.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
