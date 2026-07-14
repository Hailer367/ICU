package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zaj extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientNotificationTelemetryService");
    }

    public final void zae(com.google.android.gms.common.internal.zab zabVar) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zab(zaa, zabVar);
        zad(1, zaa);
    }
}
