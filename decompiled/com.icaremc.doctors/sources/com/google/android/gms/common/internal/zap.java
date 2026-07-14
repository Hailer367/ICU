package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zap extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper zae(IObjectWrapper iObjectWrapper, zaaa zaaaVar) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zac(zaa, iObjectWrapper);
        com.google.android.gms.internal.base.zac.zab(zaa, zaaaVar);
        Parcel zab = zab(2, zaa);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zab.readStrongBinder());
        zab.recycle();
        return asInterface;
    }
}
