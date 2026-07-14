package com.google.android.play.core.appupdate;

import com.google.android.play.core.install.model.AppUpdateType;

/* loaded from: classes.dex */
public abstract class AppUpdateOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract AppUpdateOptions build();

        public abstract Builder setAllowAssetPackDeletion(boolean z);

        public abstract Builder setAppUpdateType(@AppUpdateType int i2);
    }

    public static AppUpdateOptions defaultOptions(@AppUpdateType int i2) {
        return newBuilder(i2).build();
    }

    public static Builder newBuilder(@AppUpdateType int i2) {
        zzv zzvVar = new zzv();
        zzvVar.setAppUpdateType(i2);
        zzvVar.setAllowAssetPackDeletion(false);
        return zzvVar;
    }

    public abstract boolean allowAssetPackDeletion();

    @AppUpdateType
    public abstract int appUpdateType();
}
