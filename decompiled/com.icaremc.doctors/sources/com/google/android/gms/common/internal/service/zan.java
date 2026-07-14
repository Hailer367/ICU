package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zan extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zan(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zae(zam zamVar) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zac(zaa, zamVar);
        zad(1, zaa);
    }
}
