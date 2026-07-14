package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.install.InstallException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes.dex */
final class zzr {
    private static final com.google.android.play.core.appupdate.internal.zzm zzb = new com.google.android.play.core.appupdate.internal.zzm("AppUpdateService");
    private static final Intent zzc = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    com.google.android.play.core.appupdate.internal.zzx zza;
    private final String zzd;
    private final Context zze;
    private final zzt zzf;

    public zzr(Context context, zzt zztVar) {
        this.zzd = context.getPackageName();
        this.zze = context;
        this.zzf = zztVar;
        if (com.google.android.play.core.appupdate.internal.zzab.zza(context)) {
            this.zza = new com.google.android.play.core.appupdate.internal.zzx(com.google.android.play.core.appupdate.internal.zzz.zza(context), zzb, "AppUpdateService", zzc, zzl.zza, null);
        }
    }

    public static /* bridge */ /* synthetic */ Bundle zzb(zzr zzrVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(zzi());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(zzrVar.zze.getPackageManager().getPackageInfo(zzrVar.zze.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            zzb.zzb("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    public static /* bridge */ /* synthetic */ AppUpdateInfo zzf(zzr zzrVar, Bundle bundle, String str) {
        Integer valueOf;
        int i2 = bundle.getInt("version.code", -1);
        int i3 = bundle.getInt("update.availability");
        int i4 = bundle.getInt("install.status", 0);
        if (bundle.getInt("client.version.staleness", -1) == -1) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(bundle.getInt("client.version.staleness"));
        }
        Integer num = valueOf;
        int i5 = bundle.getInt("in.app.update.priority", 0);
        long j2 = bundle.getLong("bytes.downloaded");
        long j3 = bundle.getLong("total.bytes.to.download");
        long j4 = bundle.getLong("additional.size.required");
        long zza = zzrVar.zzf.zza();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("blocking.intent");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("nonblocking.intent");
        PendingIntent pendingIntent3 = (PendingIntent) bundle.getParcelable("blocking.destructive.intent");
        PendingIntent pendingIntent4 = (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent");
        HashMap hashMap = new HashMap();
        hashMap.put("blocking.destructive.intent", zzk(bundle.getIntegerArrayList("update.precondition.failures:blocking.destructive.intent")));
        hashMap.put("nonblocking.destructive.intent", zzk(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.destructive.intent")));
        hashMap.put("blocking.intent", zzk(bundle.getIntegerArrayList("update.precondition.failures:blocking.intent")));
        hashMap.put("nonblocking.intent", zzk(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.intent")));
        return AppUpdateInfo.zzb(str, i2, i3, i4, num, i5, j2, j3, j4, zza, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle zzi() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Map zza = com.google.android.play.core.appupdate.internal.zzi.zza("app_update");
        bundle2.putInt("playcore_version_code", ((Integer) zza.get("java")).intValue());
        if (zza.containsKey("native")) {
            bundle2.putInt("playcore_native_version", ((Integer) zza.get("native")).intValue());
        }
        if (zza.containsKey("unity")) {
            bundle2.putInt("playcore_unity_version", ((Integer) zza.get("unity")).intValue());
        }
        bundle.putAll(bundle2);
        bundle.putInt("playcore.version.code", 11004);
        return bundle;
    }

    private static Task zzj() {
        zzb.zzb("onError(%d)", -9);
        return Tasks.forException(new InstallException(-9));
    }

    private static HashSet zzk(ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        if (arrayList != null) {
            hashSet.addAll(arrayList);
        }
        return hashSet;
    }

    public final Task zzd(String str) {
        if (this.zza == null) {
            return zzj();
        }
        zzb.zzd("completeUpdate(%s)", str);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzn(this, taskCompletionSource, taskCompletionSource, str), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task zze(String str) {
        if (this.zza == null) {
            return zzj();
        }
        zzb.zzd("requestUpdateInfo(%s)", str);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzm(this, taskCompletionSource, str, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
