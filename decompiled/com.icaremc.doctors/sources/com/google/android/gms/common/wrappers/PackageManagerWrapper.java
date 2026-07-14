package com.google.android.gms.common.wrappers;

import D.b;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* loaded from: classes.dex */
public class PackageManagerWrapper {
    protected final Context zza;

    public PackageManagerWrapper(Context context) {
        this.zza = context;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(String str) {
        return this.zza.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int checkPermission(String str, String str2) {
        return this.zza.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String str, int i2) {
        return this.zza.getPackageManager().getApplicationInfo(str, i2);
    }

    @KeepForSdk
    public CharSequence getApplicationLabel(String str) {
        Context context = this.zza;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    @KeepForSdk
    public b getApplicationLabelAndIcon(String str) {
        Context context = this.zza;
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        return new b(context.getPackageManager().getApplicationLabel(applicationInfo), context.getPackageManager().getApplicationIcon(applicationInfo));
    }

    @KeepForSdk
    public PackageInfo getPackageInfo(String str, int i2) {
        return this.zza.getPackageManager().getPackageInfo(str, i2);
    }

    @KeepForSdk
    public String[] getPackagesForUid(int i2) {
        return this.zza.getPackageManager().getPackagesForUid(i2);
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        boolean isInstantApp;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.zza);
        }
        if (PlatformVersion.isAtLeastO()) {
            Context context = this.zza;
            String nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                isInstantApp = context.getPackageManager().isInstantApp(nameForUid);
                return isInstantApp;
            }
            return false;
        }
        return false;
    }

    public final boolean zza(int i2, String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) this.zza.getSystemService("appops");
            if (appOpsManager != null) {
                appOpsManager.checkPackage(i2, str);
                return true;
            }
            throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
        } catch (SecurityException unused) {
            return false;
        }
    }
}
