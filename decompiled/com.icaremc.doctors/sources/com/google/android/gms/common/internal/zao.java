package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class zao {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zao() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i2 = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zab = zab(context, minApkVersion);
        if (zab != -1) {
            return zab;
        }
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            int i3 = 0;
            while (true) {
                try {
                    if (i3 < sparseIntArray.size()) {
                        int keyAt = sparseIntArray.keyAt(i3);
                        if (keyAt > minApkVersion && sparseIntArray.get(keyAt) == 0) {
                            break;
                        }
                        i3++;
                    } else {
                        i2 = -1;
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i2 == -1) {
                i2 = this.zab.isGooglePlayServicesAvailable(context, minApkVersion);
            }
            sparseIntArray.put(minApkVersion, i2);
        }
        return i2;
    }

    public final int zab(Context context, int i2) {
        int i3;
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            i3 = sparseIntArray.get(i2, -1);
        }
        return i3;
    }

    public final void zac() {
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
    }

    public zao(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}
