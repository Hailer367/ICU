package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class zzl implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.zzb(context, str);
        int i2 = 1;
        int zza = iVersions.zza(context, str, true);
        selectionResult.remoteVersion = zza;
        int i3 = selectionResult.localVersion;
        if (i3 == 0) {
            i3 = 0;
            if (zza == 0) {
                i2 = 0;
                selectionResult.selection = i2;
                return selectionResult;
            }
        }
        if (zza < i3) {
            i2 = -1;
        }
        selectionResult.selection = i2;
        return selectionResult;
    }
}
