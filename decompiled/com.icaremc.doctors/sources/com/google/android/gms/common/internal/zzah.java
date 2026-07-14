package com.google.android.gms.common.internal;

import android.net.Uri;

/* loaded from: classes.dex */
public final class zzah {
    private static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Intent zza(android.content.Context r5, com.google.android.gms.common.internal.zzn r6) {
        /*
            java.lang.String r0 = "ServiceBindIntentUtils"
            java.lang.String r1 = r6.zza()
            if (r1 != 0) goto L16
            android.content.Intent r5 = new android.content.Intent
            r5.<init>()
            android.content.ComponentName r6 = r6.zzc()
            android.content.Intent r5 = r5.setComponent(r6)
            return r5
        L16:
            boolean r2 = r6.zzd()
            r3 = 0
            if (r2 == 0) goto Lad
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r4 = "serviceActionBundleKey"
            r2.putString(r4, r1)
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
            android.net.Uri r4 = com.google.android.gms.common.internal.zzah.zza     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
            android.content.ContentProviderClient r5 = r5.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
            if (r5 == 0) goto L46
            java.lang.String r4 = "serviceIntentCall"
            android.os.Bundle r2 = r5.call(r4, r3, r2)     // Catch: java.lang.Throwable -> L41
            r5.release()     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
            goto L5c
        L3d:
            r5 = move-exception
            goto L4e
        L3f:
            r5 = move-exception
            goto L4e
        L41:
            r2 = move-exception
            r5.release()     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
            throw r2     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
        L46:
            android.os.RemoteException r5 = new android.os.RemoteException     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
            java.lang.String r2 = "Failed to acquire ContentProviderClient"
            r5.<init>(r2)     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
            throw r5     // Catch: java.lang.IllegalArgumentException -> L3d android.os.RemoteException -> L3f
        L4e:
            java.lang.String r2 = "Dynamic intent resolution failed: "
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r2.concat(r5)
            android.util.Log.w(r0, r5)
            r2 = r3
        L5c:
            if (r2 != 0) goto L5f
            goto L75
        L5f:
            java.lang.String r5 = "serviceResponseIntentKey"
            android.os.Parcelable r5 = r2.getParcelable(r5)
            android.content.Intent r5 = (android.content.Intent) r5
            if (r5 == 0) goto L6b
            r3 = r5
            goto L75
        L6b:
            java.lang.String r5 = "serviceMissingResolutionIntentKey"
            android.os.Parcelable r5 = r2.getParcelable(r5)
            android.app.PendingIntent r5 = (android.app.PendingIntent) r5
            if (r5 != 0) goto L81
        L75:
            if (r3 != 0) goto Lad
            java.lang.String r5 = "Dynamic lookup for intent failed for action: "
            java.lang.String r5 = r5.concat(r1)
            android.util.Log.w(r0, r5)
            goto Lad
        L81:
            int r6 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r6 = r6 + 72
            r2.<init>(r6)
            java.lang.String r6 = "Dynamic lookup for intent failed for action "
            r2.append(r6)
            r2.append(r1)
            java.lang.String r6 = " but has possible resolution"
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            android.util.Log.w(r0, r6)
            com.google.android.gms.common.internal.zzaf r6 = new com.google.android.gms.common.internal.zzaf
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
            r1 = 25
            r0.<init>(r1, r5)
            r6.<init>(r0)
            throw r6
        Lad:
            if (r3 != 0) goto Lbd
            android.content.Intent r5 = new android.content.Intent
            r5.<init>(r1)
            java.lang.String r6 = r6.zzb()
            android.content.Intent r5 = r5.setPackage(r6)
            return r5
        Lbd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzah.zza(android.content.Context, com.google.android.gms.common.internal.zzn):android.content.Intent");
    }
}
