package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* loaded from: classes.dex */
final class zzq extends zzo {
    final /* synthetic */ zzr zzd;
    private final String zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(zzr zzrVar, TaskCompletionSource taskCompletionSource, String str) {
        super(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnRequestInstallCallback"), taskCompletionSource);
        this.zzd = zzrVar;
        this.zze = str;
    }

    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void zzc(Bundle bundle) {
        int i2;
        int i3;
        super.zzc(bundle);
        i2 = bundle.getInt("error.code", -2);
        if (i2 != 0) {
            TaskCompletionSource taskCompletionSource = this.zzb;
            i3 = bundle.getInt("error.code", -2);
            taskCompletionSource.trySetException(new InstallException(i3));
            return;
        }
        this.zzb.trySetResult(zzr.zzf(this.zzd, bundle, this.zze));
    }
}
