package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* loaded from: classes.dex */
final class zzf implements IntentSenderForResultStarter {
    final /* synthetic */ Activity zza;

    public zzf(zzg zzgVar, Activity activity) {
        this.zza = activity;
    }

    @Override // com.google.android.play.core.common.IntentSenderForResultStarter
    public final void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        this.zza.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
