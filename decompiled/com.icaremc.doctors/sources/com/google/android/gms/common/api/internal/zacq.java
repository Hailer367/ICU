package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
final class zacq implements Runnable {
    final /* synthetic */ Result zaa;
    final /* synthetic */ zacs zab;

    public zacq(zacs zacsVar, Result result) {
        this.zaa = result;
        Objects.requireNonNull(zacsVar);
        this.zab = zacsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                ThreadLocal threadLocal = BasePendingResult.zaa;
                threadLocal.set(Boolean.TRUE);
                zacs zacsVar = this.zab;
                zacsVar.zah().sendMessage(zacsVar.zah().obtainMessage(0, ((ResultTransform) Preconditions.checkNotNull(zacsVar.zad())).onSuccess(this.zaa)));
                threadLocal.set(Boolean.FALSE);
                zacs zacsVar2 = this.zab;
                zacs.zan(this.zaa);
                GoogleApiClient googleApiClient = (GoogleApiClient) zacsVar2.zag().get();
                if (googleApiClient != null) {
                    googleApiClient.zap(zacsVar2);
                }
            } catch (RuntimeException e2) {
                zacs zacsVar3 = this.zab;
                zacsVar3.zah().sendMessage(zacsVar3.zah().obtainMessage(1, e2));
                BasePendingResult.zaa.set(Boolean.FALSE);
                zacs zacsVar4 = this.zab;
                zacs.zan(this.zaa);
                GoogleApiClient googleApiClient2 = (GoogleApiClient) zacsVar4.zag().get();
                if (googleApiClient2 != null) {
                    googleApiClient2.zap(zacsVar4);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zacs zacsVar5 = this.zab;
            zacs.zan(this.zaa);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) zacsVar5.zag().get();
            if (googleApiClient3 != null) {
                googleApiClient3.zap(zacsVar5);
            }
            throw th;
        }
    }
}
