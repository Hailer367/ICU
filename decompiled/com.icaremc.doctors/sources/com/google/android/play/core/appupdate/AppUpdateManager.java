package com.google.android.play.core.appupdate;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import f.AbstractC0187c;

/* loaded from: classes.dex */
public interface AppUpdateManager {
    Task<Void> completeUpdate();

    Task<AppUpdateInfo> getAppUpdateInfo();

    void registerListener(InstallStateUpdatedListener installStateUpdatedListener);

    Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions);

    @Deprecated
    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i2, Activity activity, int i3);

    @Deprecated
    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i2, IntentSenderForResultStarter intentSenderForResultStarter, int i3);

    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i2);

    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i2);

    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, AbstractC0187c abstractC0187c, AppUpdateOptions appUpdateOptions);

    void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener);
}
