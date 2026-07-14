package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Batch extends BasePendingResult<BatchResult> {
    private int zae;
    private boolean zaf;
    private boolean zag;
    private final PendingResult[] zah;
    private final Object zai;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final List zaa = new ArrayList();
        private final GoogleApiClient zab;

        public Builder(GoogleApiClient googleApiClient) {
            this.zab = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            List list = this.zaa;
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(list.size());
            list.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zaa, this.zab, null);
        }
    }

    public /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, byte[] bArr) {
        super(googleApiClient);
        this.zai = new Object();
        int size = list.size();
        this.zae = size;
        PendingResult[] pendingResultArr = new PendingResult[size];
        this.zah = pendingResultArr;
        if (!list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                PendingResult pendingResult = (PendingResult) list.get(i2);
                this.zah[i2] = pendingResult;
                pendingResult.addStatusListener(new zaa(this));
            }
            return;
        }
        setResult(new BatchResult(Status.RESULT_SUCCESS, pendingResultArr));
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        int i2 = 0;
        while (true) {
            PendingResult[] pendingResultArr = this.zah;
            if (i2 < pendingResultArr.length) {
                pendingResultArr[i2].cancel();
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zah);
    }

    public final /* synthetic */ int zab() {
        return this.zae;
    }

    public final /* synthetic */ void zac(int i2) {
        this.zae = i2;
    }

    public final /* synthetic */ boolean zad() {
        return this.zaf;
    }

    public final /* synthetic */ void zae(boolean z) {
        this.zaf = true;
    }

    public final /* synthetic */ boolean zaf() {
        return this.zag;
    }

    public final /* synthetic */ void zag(boolean z) {
        this.zag = true;
    }

    public final /* synthetic */ PendingResult[] zah() {
        return this.zah;
    }

    public final /* synthetic */ Object zai() {
        return this.zai;
    }
}
