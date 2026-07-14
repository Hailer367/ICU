package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public interface IStatusCallback extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends com.google.android.gms.internal.base.zab implements IStatusCallback {
        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static IStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            if (queryLocalInterface instanceof IStatusCallback) {
                return (IStatusCallback) queryLocalInterface;
            }
            return new zabt(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        public final boolean zaa(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                Status status = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
                com.google.android.gms.internal.base.zac.zad(parcel);
                onResult(status);
                return true;
            }
            return false;
        }
    }

    void onResult(Status status);
}
