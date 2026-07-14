package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zar {
    final /* synthetic */ BasePendingResult zaa;

    public /* synthetic */ zar(BasePendingResult basePendingResult, byte[] bArr) {
        Objects.requireNonNull(basePendingResult);
        this.zaa = basePendingResult;
    }

    public final void finalize() {
        BasePendingResult.zal(this.zaa.zam());
        super.finalize();
    }
}
