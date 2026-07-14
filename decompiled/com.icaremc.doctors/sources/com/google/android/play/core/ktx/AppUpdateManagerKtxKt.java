package com.google.android.play.core.ktx;

import Q0.j;
import T0.d;
import U0.a;
import a.AbstractC0051a;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.H;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import kotlin.jvm.internal.h;
import l1.C0227e;
import l1.C0230h;
import l1.InterfaceC0228f;
import n1.i;
import n1.t;
import o1.c;
import p1.k;

/* loaded from: classes.dex */
public final class AppUpdateManagerKtxKt {
    public static final long getBytesDownloaded(AppUpdateInfo appUpdateInfo) {
        h.e(appUpdateInfo, "<this>");
        return appUpdateInfo.bytesDownloaded();
    }

    public static final Integer getClientVersionStalenessDays(AppUpdateInfo appUpdateInfo) {
        h.e(appUpdateInfo, "<this>");
        return appUpdateInfo.clientVersionStalenessDays();
    }

    public static final boolean getHasTerminalStatus(InstallState installState) {
        h.e(installState, "<this>");
        int installStatus = installState.installStatus();
        if (installStatus != 0 && installStatus != 11 && installStatus != 5 && installStatus != 6) {
            return false;
        }
        return true;
    }

    @InstallErrorCode
    public static final int getInstallErrorCode(InstallState installState) {
        h.e(installState, "<this>");
        return installState.installErrorCode();
    }

    @InstallStatus
    public static final int getInstallStatus(AppUpdateInfo appUpdateInfo) {
        h.e(appUpdateInfo, "<this>");
        return appUpdateInfo.installStatus();
    }

    public static final String getPackageName(InstallState installState) {
        h.e(installState, "<this>");
        String packageName = installState.packageName();
        h.d(packageName, "packageName()");
        return packageName;
    }

    public static final long getTotalBytesToDownload(AppUpdateInfo appUpdateInfo) {
        h.e(appUpdateInfo, "<this>");
        return appUpdateInfo.totalBytesToDownload();
    }

    public static final int getUpdatePriority(AppUpdateInfo appUpdateInfo) {
        h.e(appUpdateInfo, "<this>");
        return appUpdateInfo.updatePriority();
    }

    public static final boolean isFlexibleUpdateAllowed(AppUpdateInfo appUpdateInfo) {
        h.e(appUpdateInfo, "<this>");
        return appUpdateInfo.isUpdateTypeAllowed(0);
    }

    public static final boolean isImmediateUpdateAllowed(AppUpdateInfo appUpdateInfo) {
        h.e(appUpdateInfo, "<this>");
        return appUpdateInfo.isUpdateTypeAllowed(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object requestAppUpdateInfo(com.google.android.play.core.appupdate.AppUpdateManager r4, T0.d r5) {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1
            if (r0 == 0) goto L13
            r0 = r5
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1 r0 = (com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1 r0 = new com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            U0.a r1 = U0.a.f780c
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            a.AbstractC0051a.V(r5)
            goto L46
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            a.AbstractC0051a.V(r5)
            com.google.android.gms.tasks.Task r4 = r4.getAppUpdateInfo()
            java.lang.String r5 = "appUpdateInfo"
            kotlin.jvm.internal.h.d(r4, r5)
            r0.label = r3
            r5 = 0
            r2 = 2
            java.lang.Object r5 = runTask$default(r4, r5, r0, r2, r5)
            if (r5 != r1) goto L46
            return r1
        L46:
            java.lang.String r4 = "runTask(appUpdateInfo)"
            kotlin.jvm.internal.h.d(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AppUpdateManagerKtxKt.requestAppUpdateInfo(com.google.android.play.core.appupdate.AppUpdateManager, T0.d):java.lang.Object");
    }

    public static final Object requestCompleteUpdate(AppUpdateManager appUpdateManager, d dVar) {
        Task<Void> completeUpdate = appUpdateManager.completeUpdate();
        h.d(completeUpdate, "completeUpdate()");
        Object runTask$default = runTask$default(completeUpdate, null, dVar, 2, null);
        if (runTask$default == a.f780c) {
            return runTask$default;
        }
        return j.f722a;
    }

    public static final o1.d requestUpdateFlow(AppUpdateManager appUpdateManager) {
        h.e(appUpdateManager, "<this>");
        return k.a(new c(new AppUpdateManagerKtxKt$requestUpdateFlow$1(appUpdateManager, null), T0.j.f774c, -2, n1.a.f3306c), null, 0, n1.a.f3307d, 1);
    }

    public static final <T> Object runTask(Task<T> task, c1.a aVar, d dVar) {
        final C0230h c0230h = new C0230h(1, android.support.v4.media.session.a.v(dVar));
        c0230h.r();
        c0230h.t(new C0227e(0, new AppUpdateManagerKtxKt$runTask$3$1(aVar)));
        if (task.isComplete()) {
            if (task.isSuccessful()) {
                c0230h.resumeWith(task.getResult());
            } else {
                Exception exception = task.getException();
                h.b(exception);
                c0230h.resumeWith(AbstractC0051a.j(exception));
            }
        } else {
            task.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$3$2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(T t2) {
                    InterfaceC0228f.this.resumeWith(t2);
                }
            });
            task.addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$3$3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exception2) {
                    h.e(exception2, "exception");
                    InterfaceC0228f.this.resumeWith(AbstractC0051a.j(exception2));
                }
            });
        }
        Object q = c0230h.q();
        a aVar2 = a.f780c;
        return q;
    }

    public static /* synthetic */ Object runTask$default(Task task, c1.a aVar, d dVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = AppUpdateManagerKtxKt$runTask$2.INSTANCE;
        }
        return runTask(task, aVar, dVar);
    }

    public static final boolean startUpdateFlowForResult(AppUpdateManager appUpdateManager, AppUpdateInfo appUpdateInfo, final H fragment, AppUpdateOptions options, int i2) {
        h.e(appUpdateManager, "<this>");
        h.e(appUpdateInfo, "appUpdateInfo");
        h.e(fragment, "fragment");
        h.e(options, "options");
        return appUpdateManager.startUpdateFlowForResult(appUpdateInfo, new IntentSenderForResultStarter() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$startUpdateFlowForResult$1
            @Override // com.google.android.play.core.common.IntentSenderForResultStarter
            public final void startIntentSenderForResult(IntentSender p02, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
                h.e(p02, "p0");
                H.this.startIntentSenderForResult(p02, i3, intent, i4, i5, i6, bundle);
            }
        }, options, i2);
    }

    public static final <E> boolean tryOffer(t tVar, E e2) {
        h.e(tVar, "<this>");
        return !(tVar.i(e2) instanceof i);
    }

    public static final long getBytesDownloaded(InstallState installState) {
        h.e(installState, "<this>");
        return installState.bytesDownloaded();
    }

    @InstallStatus
    public static final int getInstallStatus(InstallState installState) {
        h.e(installState, "<this>");
        return installState.installStatus();
    }

    public static final long getTotalBytesToDownload(InstallState installState) {
        h.e(installState, "<this>");
        return installState.totalBytesToDownload();
    }
}
