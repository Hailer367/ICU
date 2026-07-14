package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.IntentSender;
import f.AbstractC0187c;
import f.C0195k;
import java.util.Objects;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
final class zaa implements DialogInterface.OnClickListener {
    final /* synthetic */ Activity zaa;
    final /* synthetic */ int zab;
    final /* synthetic */ AbstractC0187c zac;
    final /* synthetic */ GoogleApiAvailability zad;

    public zaa(GoogleApiAvailability googleApiAvailability, Activity activity, int i2, AbstractC0187c abstractC0187c) {
        this.zaa = activity;
        this.zab = i2;
        this.zac = abstractC0187c;
        Objects.requireNonNull(googleApiAvailability);
        this.zad = googleApiAvailability;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        PendingIntent errorResolutionPendingIntent = this.zad.getErrorResolutionPendingIntent(this.zaa, this.zab, 0);
        if (errorResolutionPendingIntent == null) {
            return;
        }
        IntentSender intentSender = errorResolutionPendingIntent.getIntentSender();
        h.e(intentSender, "intentSender");
        this.zac.a(new C0195k(intentSender, null, 0, 0));
    }
}
