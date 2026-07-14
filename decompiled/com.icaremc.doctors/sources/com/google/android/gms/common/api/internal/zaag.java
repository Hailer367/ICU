package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class zaag implements zaba {
    private final zabd zaa;
    private boolean zab = false;

    public zaag(zabd zabdVar) {
        this.zaa = zabdVar;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaa() {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zac(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final BaseImplementation.ApiMethodImpl zac(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        try {
            zabd zabdVar = this.zaa;
            zaaz zaazVar = zabdVar.zag;
            zaazVar.zai.zaa(apiMethodImpl);
            Api.Client client = (Api.Client) zaazVar.zac.get(apiMethodImpl.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (!client.isConnected() && zabdVar.zab.containsKey(apiMethodImpl.getClientKey())) {
                apiMethodImpl.setFailedResult(new Status(17));
                return apiMethodImpl;
            }
            apiMethodImpl.run(client);
            return apiMethodImpl;
        } catch (DeadObjectException unused) {
            this.zaa.zar(new zaae(this, this));
            return apiMethodImpl;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final boolean zad() {
        if (!this.zab) {
            zabd zabdVar = this.zaa;
            Set set = zabdVar.zag.zah;
            if (set != null && !set.isEmpty()) {
                this.zab = true;
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((zacs) it.next()).zab();
                }
                return false;
            }
            zabdVar.zaq(null);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zae() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zar(new zaaf(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaf(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zag(ConnectionResult connectionResult, Api api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zah(int i2) {
        zabd zabdVar = this.zaa;
        zabdVar.zaq(null);
        zabdVar.zah.zac(i2, this.zab);
    }

    public final void zai() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zag.zai.zab();
            zad();
        }
    }

    public final /* synthetic */ zabd zaj() {
        return this.zaa;
    }
}
