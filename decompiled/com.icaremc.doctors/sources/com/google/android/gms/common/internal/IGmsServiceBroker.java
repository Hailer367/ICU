package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes.dex */
public interface IGmsServiceBroker extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @KeepForSdk
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            IGmsCallbacks zzyVar;
            if (i2 > 0 && i2 <= 16777215) {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                IBinder readStrongBinder = parcel.readStrongBinder();
                GetServiceRequest getServiceRequest = null;
                if (readStrongBinder == null) {
                    zzyVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                    if (queryLocalInterface instanceof IGmsCallbacks) {
                        zzyVar = (IGmsCallbacks) queryLocalInterface;
                    } else {
                        zzyVar = new zzy(readStrongBinder);
                    }
                }
                if (i2 == 46) {
                    if (parcel.readInt() != 0) {
                        getServiceRequest = GetServiceRequest.CREATOR.createFromParcel(parcel);
                    }
                    getService(zzyVar, getServiceRequest);
                    Preconditions.checkNotNull(parcel2);
                    parcel2.writeNoException();
                    return true;
                }
                if (i2 == 47) {
                    if (parcel.readInt() != 0) {
                        zzai.CREATOR.createFromParcel(parcel);
                    }
                    throw new UnsupportedOperationException();
                }
                parcel.readInt();
                if (i2 != 4) {
                    parcel.readString();
                    if (i2 != 1) {
                        if (i2 != 2 && i2 != 23 && i2 != 25 && i2 != 27) {
                            if (i2 != 30) {
                                if (i2 != 34) {
                                    if (i2 != 41 && i2 != 43 && i2 != 37 && i2 != 38) {
                                        switch (i2) {
                                            case 9:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                parcel.readString();
                                                parcel.readStrongBinder();
                                                parcel.readString();
                                                if (parcel.readInt() != 0) {
                                                    break;
                                                }
                                                break;
                                            case 10:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                break;
                                            case 19:
                                                parcel.readStrongBinder();
                                                if (parcel.readInt() != 0) {
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    parcel.readString();
                                }
                            }
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                            }
                        }
                        if (parcel.readInt() != 0) {
                        }
                    } else {
                        parcel.readString();
                        parcel.createStringArray();
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                        }
                    }
                }
                throw new UnsupportedOperationException();
            }
            return super.onTransact(i2, parcel, parcel2, i3);
        }
    }

    @KeepForSdk
    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest);
}
