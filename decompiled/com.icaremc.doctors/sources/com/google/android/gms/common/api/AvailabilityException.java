package com.google.android.gms.common.api;

import O.a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import r.C0289a;
import r.C0290b;
import r.C0293e;

/* loaded from: classes.dex */
public class AvailabilityException extends Exception {
    private final C0293e zaa;

    public AvailabilityException(C0293e c0293e) {
        this.zaa = c0293e;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        C0293e c0293e = this.zaa;
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        Object obj = c0293e.get(apiKey);
        String zaa = apiKey.zaa();
        Preconditions.checkArgument(obj != null, a.j(new StringBuilder(String.valueOf(zaa).length() + 58), "The given API (", zaa, ") was not part of the availability request."));
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) c0293e.get(apiKey));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        C0293e c0293e = this.zaa;
        Iterator it = ((C0290b) c0293e.keySet()).iterator();
        boolean z = true;
        while (true) {
            C0289a c0289a = (C0289a) it;
            if (!c0289a.hasNext()) {
                break;
            }
            ApiKey apiKey = (ApiKey) c0289a.next();
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) c0293e.get(apiKey));
            z &= !connectionResult.isSuccess();
            String zaa = apiKey.zaa();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(zaa).length() + 2 + valueOf.length());
            sb.append(zaa);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        C0293e c0293e = this.zaa;
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        Object obj = c0293e.get(apiKey);
        String zaa = apiKey.zaa();
        Preconditions.checkArgument(obj != null, a.j(new StringBuilder(String.valueOf(zaa).length() + 58), "The given API (", zaa, ") was not part of the availability request."));
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) c0293e.get(apiKey));
    }
}
