package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.TelemetryData;

/* loaded from: classes.dex */
public final class zak extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void zae(TelemetryData telemetryData) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zab(zaa, telemetryData);
        zad(1, zaa);
    }
}
