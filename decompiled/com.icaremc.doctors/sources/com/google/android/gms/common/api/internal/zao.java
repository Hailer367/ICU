package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zao implements Runnable {
    final /* synthetic */ zap zaa;
    private final zam zab;

    public zao(zap zapVar, zam zamVar) {
        Objects.requireNonNull(zapVar);
        this.zaa = zapVar;
        this.zab = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zap zapVar = this.zaa;
        if (!zapVar.zaa) {
            return;
        }
        zam zamVar = this.zab;
        ConnectionResult zab = zamVar.zab();
        if (zab.hasResolution()) {
            zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(zab.getResolution()), zamVar.zaa(), false), 1);
            return;
        }
        Activity activity = zapVar.getActivity();
        int errorCode = zab.getErrorCode();
        GoogleApiAvailability googleApiAvailability = zapVar.zac;
        if (googleApiAvailability.getErrorResolutionIntent(activity, errorCode, null) != null) {
            googleApiAvailability.zab(zapVar.getActivity(), zapVar.mLifecycleFragment, zab.getErrorCode(), 2, zapVar);
        } else if (zab.getErrorCode() == 18) {
            googleApiAvailability.zag(zapVar.getActivity().getApplicationContext(), new zan(this, googleApiAvailability.zaf(zapVar.getActivity(), zapVar)));
        } else {
            zapVar.zah(zab, zamVar.zaa());
        }
    }
}
