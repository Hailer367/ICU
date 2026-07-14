package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Set;
import r.C0293e;
import r.j;

/* loaded from: classes.dex */
public final class zal {
    private int zad;
    private final C0293e zab = new j(0);
    private final TaskCompletionSource zac = new TaskCompletionSource();
    private boolean zae = false;
    private final C0293e zaa = new j(0);

    /* JADX WARN: Type inference failed for: r0v0, types: [r.e, r.j] */
    /* JADX WARN: Type inference failed for: r0v2, types: [r.e, r.j] */
    public zal(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zaa.put(((HasApiKey) it.next()).getApiKey(), null);
        }
        this.zad = this.zaa.f3573e;
    }

    public final Set zaa() {
        return this.zaa.keySet();
    }

    public final Task zab() {
        return this.zac.getTask();
    }

    public final void zac(ApiKey apiKey, ConnectionResult connectionResult, String str) {
        C0293e c0293e = this.zaa;
        c0293e.put(apiKey, connectionResult);
        C0293e c0293e2 = this.zab;
        c0293e2.put(apiKey, str);
        this.zad--;
        if (!connectionResult.isSuccess()) {
            this.zae = true;
        }
        if (this.zad == 0) {
            if (this.zae) {
                this.zac.setException(new AvailabilityException(c0293e));
            } else {
                this.zac.setResult(c0293e2);
            }
        }
    }
}
