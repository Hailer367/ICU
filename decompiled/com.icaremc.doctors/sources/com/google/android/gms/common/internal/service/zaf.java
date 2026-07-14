package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes.dex */
public final class zaf {
    public final PendingResult zaa(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zad(this, googleApiClient));
    }
}
