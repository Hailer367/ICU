package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* loaded from: classes.dex */
final class zac<R extends Result> extends BasePendingResult<R> {
    private final Result zae;

    public zac(Result result) {
        super(Looper.getMainLooper());
        this.zae = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        R r2 = (R) this.zae;
        if (status.getStatusCode() == r2.getStatus().getStatusCode()) {
            return r2;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
