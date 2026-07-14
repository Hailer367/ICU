package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.signatureverification.SignatureVerificationConfigurationProvider;
import com.google.android.gms.dynamite.DynamiteModule;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class PackageSignatureVerifier {
    static volatile zzac zza;
    private static zzad zzb;

    private static synchronized zzad zza(Context context) {
        zzad zzadVar;
        synchronized (PackageSignatureVerifier.class) {
            try {
                if (zzb == null) {
                    zzb = new zzad(context);
                }
                zzadVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzadVar;
    }

    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        String str2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        int i2 = zzo.zzh;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzo.zzb();
                if (zzo.zzg.zzi()) {
                    SignatureVerificationConfigurationProvider.zza().zza();
                    String valueOf = String.valueOf(str);
                    if (true != honorsDebugCertificates) {
                        str2 = "-0";
                    } else {
                        str2 = "-1";
                    }
                    String concat = valueOf.concat(str2);
                    if (zza != null && zza.zza().equals(concat)) {
                        return zza.zzb();
                    }
                    str.getClass();
                    zza(context);
                    zzv zzvVar = new zzv(null);
                    zzvVar.zza(str);
                    zzvVar.zzb(honorsDebugCertificates);
                    zzvVar.zzc(false);
                    zzy zzc = zzo.zzc(zzvVar.zzd());
                    if (zzc.zza) {
                        PackageVerificationResult zzd = PackageVerificationResult.zzd(str, zzc.zzd, null);
                        zza = new zzac(concat, zzd);
                        return zzd;
                    }
                    String str3 = zzc.zzb;
                    Preconditions.checkNotNull(str3);
                    return PackageVerificationResult.zza(str, str3, zzc.zzc, null);
                }
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
        }
        throw new zzae();
    }

    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzc();
            return queryPackageSignatureVerified;
        } catch (SecurityException e2) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (queryPackageSignatureVerified2.zzb()) {
                Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e2);
            }
            return queryPackageSignatureVerified2;
        }
    }
}
