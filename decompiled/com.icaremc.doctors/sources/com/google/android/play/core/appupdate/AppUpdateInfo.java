package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class AppUpdateInfo {
    private final String zza;
    private final int zzb;

    @UpdateAvailability
    private final int zzc;

    @InstallStatus
    private final int zzd;
    private final Integer zze;
    private final int zzf;
    private final long zzg;
    private final long zzh;
    private final long zzi;
    private final long zzj;
    private final PendingIntent zzk;
    private final PendingIntent zzl;
    private final PendingIntent zzm;
    private final PendingIntent zzn;
    private final Map zzo;
    private boolean zzp = false;

    private AppUpdateInfo(String str, int i2, @UpdateAvailability int i3, @InstallStatus int i4, Integer num, int i5, long j2, long j3, long j4, long j5, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = num;
        this.zzf = i5;
        this.zzg = j2;
        this.zzh = j3;
        this.zzi = j4;
        this.zzj = j5;
        this.zzk = pendingIntent;
        this.zzl = pendingIntent2;
        this.zzm = pendingIntent3;
        this.zzn = pendingIntent4;
        this.zzo = map;
    }

    public static AppUpdateInfo zzb(String str, int i2, @UpdateAvailability int i3, @InstallStatus int i4, Integer num, int i5, long j2, long j3, long j4, long j5, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        return new AppUpdateInfo(str, i2, i3, i4, num, i5, j2, j3, j4, j5, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    private static Set zze(Set set) {
        if (set == null) {
            return new HashSet();
        }
        return set;
    }

    private final boolean zzf(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.allowAssetPackDeletion() && this.zzi <= this.zzj) {
            return true;
        }
        return false;
    }

    public int availableVersionCode() {
        return this.zzb;
    }

    public long bytesDownloaded() {
        return this.zzg;
    }

    public Integer clientVersionStalenessDays() {
        return this.zze;
    }

    public Set<Integer> getFailedUpdatePreconditions(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.allowAssetPackDeletion()) {
            if (appUpdateOptions.appUpdateType() == 0) {
                return zze((Set) this.zzo.get("nonblocking.destructive.intent"));
            }
            return zze((Set) this.zzo.get("blocking.destructive.intent"));
        }
        if (appUpdateOptions.appUpdateType() == 0) {
            return zze((Set) this.zzo.get("nonblocking.intent"));
        }
        return zze((Set) this.zzo.get("blocking.intent"));
    }

    @InstallStatus
    public int installStatus() {
        return this.zzd;
    }

    public boolean isUpdateTypeAllowed(@AppUpdateType int i2) {
        return zza(AppUpdateOptions.defaultOptions(i2)) != null;
    }

    public String packageName() {
        return this.zza;
    }

    public long totalBytesToDownload() {
        return this.zzh;
    }

    @UpdateAvailability
    public int updateAvailability() {
        return this.zzc;
    }

    public int updatePriority() {
        return this.zzf;
    }

    public final PendingIntent zza(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() == 0) {
            PendingIntent pendingIntent = this.zzl;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (!zzf(appUpdateOptions)) {
                return null;
            }
            return this.zzn;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            PendingIntent pendingIntent2 = this.zzk;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (zzf(appUpdateOptions)) {
                return this.zzm;
            }
        }
        return null;
    }

    public final void zzc() {
        this.zzp = true;
    }

    public final boolean zzd() {
        return this.zzp;
    }

    public boolean isUpdateTypeAllowed(AppUpdateOptions appUpdateOptions) {
        return zza(appUpdateOptions) != null;
    }
}
