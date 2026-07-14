package b1;

import android.os.IBinder;
import android.os.IInterface;
import h1.AbstractC0336a;
import h1.AbstractC0338c;

/* loaded from: classes.dex */
public final class a extends com.google.android.gms.common.internal.a {
    @Override // X0.c
    public final int a() {
        return 253600000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientNotificationTelemetryService");
        if (queryLocalInterface instanceof b) {
            return (b) queryLocalInterface;
        }
        return new AbstractC0336a(iBinder, "com.google.android.gms.common.internal.service.IClientNotificationTelemetryService");
    }

    @Override // com.google.android.gms.common.internal.a
    public final W0.c[] f() {
        return AbstractC0338c.f3946c;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String j() {
        return "com.google.android.gms.common.internal.service.IClientNotificationTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String k() {
        return "com.google.android.gms.common.telemetry.notification.service.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean l() {
        return true;
    }
}
