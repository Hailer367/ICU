package com.google.android.play.core.ktx;

import Q0.j;
import T0.d;
import U0.a;
import android.app.Activity;
import androidx.fragment.app.H;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.install.InstallState;
import f.AbstractC0187c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public class AppUpdateResult {

    /* loaded from: classes.dex */
    public static final class Downloaded extends AppUpdateResult {
        private final AppUpdateManager appUpdateManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Downloaded(AppUpdateManager appUpdateManager) {
            super(null);
            h.e(appUpdateManager, "appUpdateManager");
            this.appUpdateManager = appUpdateManager;
        }

        public final Object completeUpdate(d dVar) {
            Object requestCompleteUpdate = AppUpdateManagerKtxKt.requestCompleteUpdate(this.appUpdateManager, dVar);
            if (requestCompleteUpdate == a.f780c) {
                return requestCompleteUpdate;
            }
            return j.f722a;
        }
    }

    /* loaded from: classes.dex */
    public static final class InProgress extends AppUpdateResult {
        private final InstallState installState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InProgress(InstallState installState) {
            super(null);
            h.e(installState, "installState");
            this.installState = installState;
        }

        public final InstallState getInstallState() {
            return this.installState;
        }
    }

    /* loaded from: classes.dex */
    public static final class NotAvailable extends AppUpdateResult {
        public static final NotAvailable INSTANCE = new NotAvailable();

        private NotAvailable() {
            super(null);
        }
    }

    private AppUpdateResult() {
    }

    public /* synthetic */ AppUpdateResult(e eVar) {
        this();
    }

    /* loaded from: classes.dex */
    public static final class Available extends AppUpdateResult {
        private final AppUpdateManager appUpdateManager;
        private final AppUpdateInfo updateInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Available(AppUpdateManager appUpdateManager, AppUpdateInfo updateInfo) {
            super(null);
            h.e(appUpdateManager, "appUpdateManager");
            h.e(updateInfo, "updateInfo");
            this.appUpdateManager = appUpdateManager;
            this.updateInfo = updateInfo;
        }

        public final AppUpdateInfo getUpdateInfo() {
            return this.updateInfo;
        }

        public final boolean startFlexibleUpdate(AbstractC0187c activityResultLauncher) {
            h.e(activityResultLauncher, "activityResultLauncher");
            return this.appUpdateManager.startUpdateFlowForResult(this.updateInfo, activityResultLauncher, AppUpdateOptions.newBuilder(0).build());
        }

        public final boolean startImmediateUpdate(AbstractC0187c activityResultLauncher) {
            h.e(activityResultLauncher, "activityResultLauncher");
            return this.appUpdateManager.startUpdateFlowForResult(this.updateInfo, activityResultLauncher, AppUpdateOptions.newBuilder(1).build());
        }

        public final boolean startFlexibleUpdate(Activity activity, int i2) {
            h.e(activity, "activity");
            return this.appUpdateManager.startUpdateFlowForResult(this.updateInfo, activity, AppUpdateOptions.newBuilder(0).build(), i2);
        }

        public final boolean startImmediateUpdate(Activity activity, int i2) {
            h.e(activity, "activity");
            return this.appUpdateManager.startUpdateFlowForResult(this.updateInfo, activity, AppUpdateOptions.newBuilder(1).build(), i2);
        }

        public final boolean startFlexibleUpdate(H fragment, int i2) {
            h.e(fragment, "fragment");
            AppUpdateManager appUpdateManager = this.appUpdateManager;
            AppUpdateInfo appUpdateInfo = this.updateInfo;
            AppUpdateOptions build = AppUpdateOptions.newBuilder(0).build();
            h.d(build, "newBuilder(AppUpdateType.FLEXIBLE).build()");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(appUpdateManager, appUpdateInfo, fragment, build, i2);
        }

        public final boolean startImmediateUpdate(H fragment, int i2) {
            h.e(fragment, "fragment");
            AppUpdateManager appUpdateManager = this.appUpdateManager;
            AppUpdateInfo appUpdateInfo = this.updateInfo;
            AppUpdateOptions build = AppUpdateOptions.newBuilder(1).build();
            h.d(build, "newBuilder(AppUpdateType.IMMEDIATE).build()");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(appUpdateManager, appUpdateInfo, fragment, build, i2);
        }
    }
}
