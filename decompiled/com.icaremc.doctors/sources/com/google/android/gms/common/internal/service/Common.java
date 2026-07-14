package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class Common {

    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> API;

    @KeepForSdk
    public static final Api.ClientKey<zai> CLIENT_KEY;
    public static final zaf zaa;
    private static final Api.AbstractClientBuilder zab;

    static {
        Api.ClientKey<zai> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zac zacVar = new zac();
        zab = zacVar;
        API = new Api<>("Common.API", zacVar, clientKey);
        zaa = new zaf();
    }
}
