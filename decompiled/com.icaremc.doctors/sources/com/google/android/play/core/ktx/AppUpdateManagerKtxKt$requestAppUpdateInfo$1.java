package com.google.android.play.core.ktx;

import T0.d;
import V0.c;
import V0.e;

@e(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt", f = "AppUpdateManagerKtx.kt", l = {226}, m = "requestAppUpdateInfo")
/* loaded from: classes.dex */
public final class AppUpdateManagerKtxKt$requestAppUpdateInfo$1 extends c {
    int label;
    /* synthetic */ Object result;

    public AppUpdateManagerKtxKt$requestAppUpdateInfo$1(d dVar) {
        super(dVar);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AppUpdateManagerKtxKt.requestAppUpdateInfo(null, this);
    }
}
