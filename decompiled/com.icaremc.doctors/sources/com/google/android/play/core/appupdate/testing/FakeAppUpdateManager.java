package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.zzc;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import f.AbstractC0187c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class FakeAppUpdateManager implements AppUpdateManager {
    private final zzc zza;
    private final Context zzb;
    private final List zzc = new ArrayList();

    @InstallStatus
    private int zzd = 0;

    @InstallErrorCode
    private int zze = 0;
    private boolean zzf = false;
    private int zzg = 0;
    private Integer zzh = null;
    private int zzi = 0;
    private long zzj = 0;
    private long zzk = 0;
    private boolean zzl = false;
    private boolean zzm = false;
    private boolean zzn = false;

    @AppUpdateType
    private Integer zzo;

    public FakeAppUpdateManager(Context context) {
        this.zza = new zzc(context);
        this.zzb = context;
    }

    private static int zza() {
        return 67108864;
    }

    @UpdateAvailability
    private final int zzb() {
        if (!this.zzf) {
            return 1;
        }
        int i2 = this.zzd;
        return (i2 == 0 || i2 == 4 || i2 == 5 || i2 == 6) ? 2 : 3;
    }

    private final void zzc() {
        this.zza.zzd(InstallState.zza(this.zzd, this.zzj, this.zzk, this.zze, this.zzb.getPackageName()));
    }

    private final boolean zzd(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.zzm = true;
            this.zzo = 1;
        } else {
            this.zzl = true;
            this.zzo = 0;
        }
        return true;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public Task<Void> completeUpdate() {
        if (this.zze != 0) {
            return Tasks.forException(new InstallException(this.zze));
        }
        int i2 = this.zzd;
        if (i2 == 11) {
            this.zzd = 3;
            this.zzn = true;
            Integer num = 0;
            if (num.equals(this.zzo)) {
                zzc();
            }
            return Tasks.forResult(null);
        }
        if (i2 == 3) {
            return Tasks.forException(new InstallException(-8));
        }
        return Tasks.forException(new InstallException(-7));
    }

    public void downloadCompletes() {
        int i2 = this.zzd;
        if (i2 == 2 || i2 == 1) {
            this.zzd = 11;
            this.zzj = 0L;
            this.zzk = 0L;
            Integer num = 0;
            if (num.equals(this.zzo)) {
                zzc();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.zzo)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i2 = this.zzd;
        if (i2 != 1 && i2 != 2) {
            return;
        }
        this.zzd = 5;
        Integer num = 0;
        if (num.equals(this.zzo)) {
            zzc();
        }
        this.zzo = null;
        this.zzm = false;
        this.zzd = 0;
    }

    public void downloadStarts() {
        if (this.zzd == 1) {
            this.zzd = 2;
            Integer num = 0;
            if (num.equals(this.zzo)) {
                zzc();
            }
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        PendingIntent pendingIntent4;
        PendingIntent pendingIntent5;
        PendingIntent pendingIntent6;
        if (this.zze != 0) {
            return Tasks.forException(new InstallException(this.zze));
        }
        if (zzb() == 2) {
            if (this.zzc.contains(0)) {
                pendingIntent5 = PendingIntent.getBroadcast(this.zzb, 0, new Intent(), zza());
                pendingIntent6 = PendingIntent.getBroadcast(this.zzb, 0, new Intent(), zza());
            } else {
                pendingIntent5 = null;
                pendingIntent6 = null;
            }
            if (this.zzc.contains(1)) {
                PendingIntent broadcast = PendingIntent.getBroadcast(this.zzb, 0, new Intent(), zza());
                pendingIntent2 = pendingIntent5;
                pendingIntent3 = PendingIntent.getBroadcast(this.zzb, 0, new Intent(), zza());
                pendingIntent = broadcast;
            } else {
                pendingIntent2 = pendingIntent5;
                pendingIntent = null;
                pendingIntent3 = null;
            }
            pendingIntent4 = pendingIntent6;
        } else {
            pendingIntent = null;
            pendingIntent2 = null;
            pendingIntent3 = null;
            pendingIntent4 = null;
        }
        return Tasks.forResult(AppUpdateInfo.zzb(this.zzb.getPackageName(), this.zzg, zzb(), this.zzd, this.zzh, this.zzi, this.zzj, this.zzk, 0L, 0L, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, new HashMap()));
    }

    @AppUpdateType
    public Integer getTypeForUpdateInProgress() {
        return this.zzo;
    }

    public void installCompletes() {
        if (this.zzd == 3) {
            this.zzd = 4;
            this.zzf = false;
            this.zzg = 0;
            this.zzh = null;
            this.zzi = 0;
            this.zzj = 0L;
            this.zzk = 0L;
            this.zzm = false;
            this.zzn = false;
            Integer num = 0;
            if (num.equals(this.zzo)) {
                zzc();
            }
            this.zzo = null;
            this.zzd = 0;
        }
    }

    public void installFails() {
        if (this.zzd == 3) {
            this.zzd = 5;
            Integer num = 0;
            if (num.equals(this.zzo)) {
                zzc();
            }
            this.zzo = null;
            this.zzn = false;
            this.zzm = false;
            this.zzd = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.zzl;
    }

    public boolean isImmediateFlowVisible() {
        return this.zzm;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.zzn;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.zza.zzb(installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j2) {
        if (this.zzd == 2 && j2 <= this.zzk) {
            this.zzj = j2;
            Integer num = 0;
            if (num.equals(this.zzo)) {
                zzc();
            }
        }
    }

    public void setClientVersionStalenessDays(Integer num) {
        if (this.zzf) {
            this.zzh = num;
        }
    }

    public void setInstallErrorCode(@InstallErrorCode int i2) {
        this.zze = i2;
    }

    public void setTotalBytesToDownload(long j2) {
        if (this.zzd == 2) {
            this.zzk = j2;
            Integer num = 0;
            if (num.equals(this.zzo)) {
                zzc();
            }
        }
    }

    public void setUpdateAvailable(int i2) {
        this.zzf = true;
        this.zzc.clear();
        this.zzc.add(0);
        this.zzc.add(1);
        this.zzg = i2;
    }

    public void setUpdateNotAvailable() {
        this.zzf = false;
        this.zzh = null;
    }

    public void setUpdatePriority(int i2) {
        if (this.zzf) {
            this.zzi = i2;
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        if (zzd(appUpdateInfo, appUpdateOptions)) {
            return Tasks.forResult(-1);
        }
        return Tasks.forException(new InstallException(-6));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i2, Activity activity, int i3) {
        return zzd(appUpdateInfo, AppUpdateOptions.newBuilder(i2).build());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.zza.zzc(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.zzl || this.zzm) {
            this.zzl = false;
            this.zzd = 1;
            Integer num = 0;
            if (num.equals(this.zzo)) {
                zzc();
            }
        }
    }

    public void userCancelsDownload() {
        int i2 = this.zzd;
        if (i2 != 1 && i2 != 2) {
            return;
        }
        this.zzd = 6;
        Integer num = 0;
        if (num.equals(this.zzo)) {
            zzc();
        }
        this.zzo = null;
        this.zzm = false;
        this.zzd = 0;
    }

    public void userRejectsUpdate() {
        if (this.zzl || this.zzm) {
            this.zzl = false;
            this.zzm = false;
            this.zzo = null;
            this.zzd = 0;
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i2, IntentSenderForResultStarter intentSenderForResultStarter, int i3) {
        return zzd(appUpdateInfo, AppUpdateOptions.newBuilder(i2).build());
    }

    public void setUpdateAvailable(int i2, @AppUpdateType int i3) {
        this.zzf = true;
        this.zzc.clear();
        this.zzc.add(Integer.valueOf(i3));
        this.zzg = i2;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i2) {
        return zzd(appUpdateInfo, appUpdateOptions);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, AbstractC0187c abstractC0187c, AppUpdateOptions appUpdateOptions) {
        return zzd(appUpdateInfo, appUpdateOptions);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i2) {
        return zzd(appUpdateInfo, appUpdateOptions);
    }
}
