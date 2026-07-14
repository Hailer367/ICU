package b1;

import I0.h;
import Y0.k;
import Z0.j;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import h1.AbstractC0336a;
import h1.AbstractC0338c;

/* loaded from: classes.dex */
public final class f extends com.google.android.gms.common.internal.a {
    public final j z;

    public f(Context context, Looper looper, h hVar, j jVar, k kVar, k kVar2) {
        super(context, looper, 270, hVar, kVar, kVar2);
        this.z = jVar;
    }

    @Override // X0.c
    public final int a() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        if (queryLocalInterface instanceof c) {
            return (c) queryLocalInterface;
        }
        return new AbstractC0336a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // com.google.android.gms.common.internal.a
    public final W0.c[] f() {
        return AbstractC0338c.f3946c;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle g() {
        this.z.getClass();
        return new Bundle();
    }

    @Override // com.google.android.gms.common.internal.a
    public final String j() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String k() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean l() {
        return true;
    }
}
