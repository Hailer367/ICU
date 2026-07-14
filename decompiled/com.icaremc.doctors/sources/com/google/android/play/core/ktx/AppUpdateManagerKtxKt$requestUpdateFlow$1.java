package com.google.android.play.core.ktx;

import Q0.j;
import T0.d;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import c1.a;
import c1.p;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.ktx.AppUpdateResult;
import kotlin.jvm.internal.i;
import n1.q;
import n1.r;

@e(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1", f = "AppUpdateManagerKtx.kt", l = {90}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AppUpdateManagerKtxKt$requestUpdateFlow$1 extends h implements p {
    final /* synthetic */ AppUpdateManager $this_requestUpdateFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* renamed from: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass3 extends i implements a {
        final /* synthetic */ AppUpdatePassthroughListener $globalUpdateListener;
        final /* synthetic */ AppUpdateManager $this_requestUpdateFlow;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AppUpdateManager appUpdateManager, AppUpdatePassthroughListener appUpdatePassthroughListener) {
            super(0);
            this.$this_requestUpdateFlow = appUpdateManager;
            this.$globalUpdateListener = appUpdatePassthroughListener;
        }

        @Override // c1.a
        public final /* bridge */ /* synthetic */ Object invoke() {
            m0invoke();
            return j.f722a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m0invoke() {
            this.$this_requestUpdateFlow.unregisterListener(this.$globalUpdateListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUpdateManagerKtxKt$requestUpdateFlow$1(AppUpdateManager appUpdateManager, d dVar) {
        super(2, dVar);
        this.$this_requestUpdateFlow = appUpdateManager;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        AppUpdateManagerKtxKt$requestUpdateFlow$1 appUpdateManagerKtxKt$requestUpdateFlow$1 = new AppUpdateManagerKtxKt$requestUpdateFlow$1(this.$this_requestUpdateFlow, dVar);
        appUpdateManagerKtxKt$requestUpdateFlow$1.L$0 = obj;
        return appUpdateManagerKtxKt$requestUpdateFlow$1;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            final r rVar = (r) this.L$0;
            final AppUpdateManager appUpdateManager = this.$this_requestUpdateFlow;
            final AppUpdatePassthroughListener appUpdatePassthroughListener = new AppUpdatePassthroughListener(new InstallStateUpdatedListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$1
                @Override // com.google.android.play.core.listener.StateUpdatedListener
                public final void onStateUpdate(InstallState installState) {
                    kotlin.jvm.internal.h.e(installState, "installState");
                    if (installState.installStatus() == 11) {
                        AppUpdateManagerKtxKt.tryOffer(r.this, new AppUpdateResult.Downloaded(appUpdateManager));
                    } else {
                        AppUpdateManagerKtxKt.tryOffer(r.this, new AppUpdateResult.InProgress(installState));
                    }
                }
            }, new AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2(rVar));
            Task<AppUpdateInfo> appUpdateInfo = this.$this_requestUpdateFlow.getAppUpdateInfo();
            final AppUpdateManager appUpdateManager2 = this.$this_requestUpdateFlow;
            appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(AppUpdateInfo appUpdateInfo2) {
                    int updateAvailability = appUpdateInfo2.updateAvailability();
                    if (updateAvailability == 0) {
                        ((q) r.this).T(new InstallException(-2));
                    } else if (updateAvailability == 1) {
                        AppUpdateManagerKtxKt.tryOffer(r.this, AppUpdateResult.NotAvailable.INSTANCE);
                        ((q) r.this).T(null);
                    } else if (updateAvailability == 2 || updateAvailability == 3) {
                        if (appUpdateInfo2.installStatus() == 11) {
                            AppUpdateManagerKtxKt.tryOffer(r.this, new AppUpdateResult.Downloaded(appUpdateManager2));
                            ((q) r.this).T(null);
                        } else {
                            appUpdateManager2.registerListener(appUpdatePassthroughListener);
                            AppUpdateManagerKtxKt.tryOffer(r.this, new AppUpdateResult.Available(appUpdateManager2, appUpdateInfo2));
                        }
                    }
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1.2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exception) {
                    kotlin.jvm.internal.h.e(exception, "exception");
                    ((q) r.this).T(exception);
                }
            });
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_requestUpdateFlow, appUpdatePassthroughListener);
            this.label = 1;
            if (n1.j.b(rVar, anonymousClass3, this) == aVar) {
                return aVar;
            }
        }
        return j.f722a;
    }

    @Override // c1.p
    public final Object invoke(r rVar, d dVar) {
        return ((AppUpdateManagerKtxKt$requestUpdateFlow$1) create(rVar, dVar)).invokeSuspend(j.f722a);
    }
}
