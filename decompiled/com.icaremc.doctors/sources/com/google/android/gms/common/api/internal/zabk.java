package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import r.j;

/* loaded from: classes.dex */
public final class zabk implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zat {
    final /* synthetic */ GoogleApiManager zaa;
    private final Queue zab;
    private final Api.Client zac;
    private final ApiKey zad;
    private final zaaa zae;
    private final Set zaf;
    private final Map zag;
    private final int zah;
    private final zacm zai;
    private boolean zaj;
    private final List zak;
    private ConnectionResult zal;
    private int zam;

    public zabk(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        Objects.requireNonNull(googleApiManager);
        this.zaa = googleApiManager;
        this.zab = new LinkedList();
        this.zaf = new HashSet();
        this.zag = new HashMap();
        this.zak = new ArrayList();
        this.zal = null;
        this.zam = 0;
        Api.Client zaf = googleApi.zaf(googleApiManager.zaF().getLooper(), this);
        this.zac = zaf;
        this.zad = googleApi.getApiKey();
        this.zae = new zaaa();
        this.zah = googleApi.zab();
        if (zaf.requiresSignIn()) {
            this.zai = googleApi.zac(googleApiManager.zaz(), googleApiManager.zaF());
        } else {
            this.zai = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaC, reason: merged with bridge method [inline-methods] */
    public final void zat() {
        zah();
        zaN(ConnectionResult.RESULT_SUCCESS);
        zaK();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            RegisterListenerMethod registerListenerMethod = ((zacd) it.next()).zaa;
            if (zaO(registerListenerMethod.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    registerListenerMethod.registerListener(this.zac, new TaskCompletionSource<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException e2) {
                    e = e2;
                    Log.e("GoogleApiManager", "Failed to register listener on re-connection.", e);
                    it.remove();
                } catch (RuntimeException e3) {
                    e = e3;
                    Log.e("GoogleApiManager", "Failed to register listener on re-connection.", e);
                    it.remove();
                }
            }
        }
        zaF();
        zaL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaD, reason: merged with bridge method [inline-methods] */
    public final void zau(int i2) {
        zah();
        this.zaj = true;
        this.zae.zae(i2, this.zac.getLastDisconnectMessage());
        ApiKey apiKey = this.zad;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 9, apiKey), 5000L);
        googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 11, apiKey), 120000L);
        googleApiManager.zaB().zac();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            ((zacd) it.next()).zac.run();
        }
    }

    private final boolean zaE(ConnectionResult connectionResult) {
        Object obj;
        obj = GoogleApiManager.zae;
        synchronized (obj) {
            try {
                GoogleApiManager googleApiManager = this.zaa;
                if (googleApiManager.zaD() != null && googleApiManager.zaE().contains(this.zad)) {
                    googleApiManager.zaD().zaf(connectionResult, this.zah);
                    googleApiManager.zaA().zae(googleApiManager.zaz(), connectionResult, true);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zaF() {
        Queue queue = this.zab;
        ArrayList arrayList = new ArrayList(queue);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zai zaiVar = (zai) arrayList.get(i2);
            if (this.zac.isConnected()) {
                if (zaG(zaiVar)) {
                    queue.remove(zaiVar);
                }
            } else {
                return;
            }
        }
    }

    private final boolean zaG(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            zaH(zaiVar);
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature zaO = zaO(zacVar.zaa(this));
        if (zaO == null) {
            zaH(zaiVar);
            return true;
        }
        String name = this.zac.getClass().getName();
        String name2 = zaO.getName();
        long version = zaO.getVersion();
        int length = name.length();
        StringBuilder sb = new StringBuilder(length + 53 + String.valueOf(name2).length() + 2 + String.valueOf(version).length() + 2);
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(name2);
        sb.append(", ");
        sb.append(version);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        GoogleApiManager googleApiManager = this.zaa;
        if (googleApiManager.zaG() && zacVar.zab(this)) {
            int zac = zacVar.zac(this);
            zabl zablVar = new zabl(this.zad, zaO, null);
            List list = this.zak;
            int indexOf = list.indexOf(zablVar);
            if (indexOf >= 0) {
                zabl zablVar2 = (zabl) list.get(indexOf);
                googleApiManager.zaF().removeMessages(15, zablVar2);
                googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 15, zablVar2), 5000L);
                return false;
            }
            list.add(zablVar);
            googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 15, zablVar), 5000L);
            googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 16, zablVar), 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null, null, Integer.valueOf(zac));
            if (!zaE(connectionResult)) {
                if (googleApiManager.zap(connectionResult, this.zah)) {
                    String name3 = zaO.getName();
                    long version2 = zaO.getVersion();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(name3).length() + 55 + String.valueOf(version2).length());
                    sb2.append("Notification displayed for missing feature: ");
                    sb2.append(name3);
                    sb2.append(", version: ");
                    sb2.append(version2);
                    Log.w("GoogleApiManager", sb2.toString());
                    return false;
                }
                return false;
            }
            String name4 = zaO.getName();
            long version3 = zaO.getVersion();
            StringBuilder sb3 = new StringBuilder(String.valueOf(name4).length() + 61 + String.valueOf(version3).length());
            sb3.append("A dialog should be displayed for missing feature: ");
            sb3.append(name4);
            sb3.append(", version: ");
            sb3.append(version3);
            Log.w("GoogleApiManager", sb3.toString());
            return false;
        }
        zacVar.zae(new UnsupportedApiCallException(zaO));
        return true;
    }

    private final void zaH(zai zaiVar) {
        zaiVar.zaf(this.zae, zap());
        try {
            zaiVar.zag(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void zaI(Status status, Exception exc, boolean z) {
        boolean z2;
        Preconditions.checkHandlerThread(this.zaa.zaF());
        boolean z3 = true;
        if (status != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (exc != null) {
            z3 = false;
        }
        if (z2 != z3) {
            Iterator it = this.zab.iterator();
            while (it.hasNext()) {
                zai zaiVar = (zai) it.next();
                if (!z || zaiVar.zac == 2) {
                    if (status != null) {
                        zaiVar.zad(status);
                    } else {
                        zaiVar.zae(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaJ, reason: merged with bridge method [inline-methods] */
    public final void zav(Status status) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        zaI(status, null, false);
    }

    private final void zaK() {
        if (this.zaj) {
            GoogleApiManager googleApiManager = this.zaa;
            ApiKey apiKey = this.zad;
            googleApiManager.zaF().removeMessages(11, apiKey);
            googleApiManager.zaF().removeMessages(9, apiKey);
            this.zaj = false;
        }
    }

    private final void zaL() {
        ApiKey apiKey = this.zad;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zaF().removeMessages(12, apiKey);
        googleApiManager.zaF().sendMessageDelayed(googleApiManager.zaF().obtainMessage(12, apiKey), googleApiManager.zaw());
    }

    private final boolean zaM(boolean z) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        Api.Client client = this.zac;
        if (client.isConnected() && this.zag.isEmpty()) {
            if (this.zae.zac()) {
                if (z) {
                    zaL();
                    return false;
                }
                return false;
            }
            client.disconnect("Timing out service connection.");
            return true;
        }
        return false;
    }

    private final void zaN(ConnectionResult connectionResult) {
        String str;
        Set<zal> set = this.zaf;
        for (zal zalVar : set) {
            if (com.google.android.gms.common.internal.Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                str = this.zac.getEndpointPackageName();
            } else {
                str = null;
            }
            zalVar.zac(this.zad, connectionResult, str);
        }
        set.clear();
    }

    private final Feature zaO(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            j jVar = new j(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                jVar.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l2 = (Long) jVar.get(feature2.getName());
                if (l2 == null || l2.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        GoogleApiManager googleApiManager = this.zaa;
        if (Looper.myLooper() == googleApiManager.zaF().getLooper()) {
            zat();
        } else {
            googleApiManager.zaF().post(new zabg(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zac(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        GoogleApiManager googleApiManager = this.zaa;
        if (Looper.myLooper() == googleApiManager.zaF().getLooper()) {
            zau(i2);
        } else {
            googleApiManager.zaF().post(new zabh(this, i2));
        }
    }

    public final /* synthetic */ ApiKey zaA() {
        return this.zad;
    }

    public final /* synthetic */ boolean zaB() {
        return this.zaj;
    }

    @Override // com.google.android.gms.common.api.internal.zat
    public final void zaa(ConnectionResult connectionResult, Api api, boolean z) {
        throw null;
    }

    public final void zab(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        Api.Client client = this.zac;
        String name = client.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(name.length() + 25 + valueOf.length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(valueOf);
        client.disconnect(sb.toString());
        zac(connectionResult, null);
    }

    public final void zac(ConnectionResult connectionResult, Exception exc) {
        Status zaJ;
        Status zaJ2;
        Status zaJ3;
        Status zaJ4;
        Status status;
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zaF());
        zacm zacmVar = this.zai;
        if (zacmVar != null) {
            zacmVar.zad();
        }
        zah();
        googleApiManager.zaB().zac();
        zaN(connectionResult);
        if ((this.zac instanceof com.google.android.gms.common.internal.service.zau) && connectionResult.getErrorCode() != 24) {
            googleApiManager.zax(true);
            googleApiManager.zaF().sendMessageDelayed(googleApiManager.zaF().obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            status = GoogleApiManager.zab;
            zav(status);
            return;
        }
        if (connectionResult.getErrorCode() == 25) {
            zaJ4 = GoogleApiManager.zaJ(this.zad, connectionResult);
            zav(zaJ4);
            return;
        }
        Queue queue = this.zab;
        if (queue.isEmpty()) {
            this.zal = connectionResult;
            return;
        }
        if (exc != null) {
            Preconditions.checkHandlerThread(googleApiManager.zaF());
            zaI(null, exc, false);
            return;
        }
        if (googleApiManager.zaG()) {
            ApiKey apiKey = this.zad;
            zaJ2 = GoogleApiManager.zaJ(apiKey, connectionResult);
            zaI(zaJ2, null, true);
            if (!queue.isEmpty() && !zaE(connectionResult) && !googleApiManager.zap(connectionResult, this.zah)) {
                if (connectionResult.getErrorCode() == 18) {
                    this.zaj = true;
                }
                if (this.zaj) {
                    googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 9, apiKey), 5000L);
                    return;
                } else {
                    zaJ3 = GoogleApiManager.zaJ(apiKey, connectionResult);
                    zav(zaJ3);
                    return;
                }
            }
            return;
        }
        zaJ = GoogleApiManager.zaJ(this.zad, connectionResult);
        zav(zaJ);
    }

    public final void zad(zai zaiVar) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        if (this.zac.isConnected()) {
            if (zaG(zaiVar)) {
                zaL();
                return;
            } else {
                this.zab.add(zaiVar);
                return;
            }
        }
        this.zab.add(zaiVar);
        ConnectionResult connectionResult = this.zal;
        if (connectionResult != null && connectionResult.hasResolution()) {
            zac(this.zal, null);
        } else {
            zam();
        }
    }

    public final void zae() {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        zav(GoogleApiManager.zaa);
        this.zae.zad();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zad(new zah(listenerKey, new TaskCompletionSource()));
        }
        zaN(new ConnectionResult(4));
        Api.Client client = this.zac;
        if (client.isConnected()) {
            client.onUserSignOut(new zabj(this));
        }
    }

    public final Api.Client zaf() {
        return this.zac;
    }

    public final Map zag() {
        return this.zag;
    }

    public final void zah() {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        this.zal = null;
    }

    public final ConnectionResult zai() {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        return this.zal;
    }

    public final void zaj() {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        if (this.zaj) {
            zam();
        }
    }

    public final void zak() {
        Status status;
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zaF());
        if (this.zaj) {
            zaK();
            if (googleApiManager.zaA().isGooglePlayServicesAvailable(googleApiManager.zaz()) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            zav(status);
            this.zac.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean zal() {
        return zaM(true);
    }

    public final void zam() {
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zaF());
        Api.Client client = this.zac;
        if (!client.isConnected() && !client.isConnecting()) {
            try {
                int zaa = googleApiManager.zaB().zaa(googleApiManager.zaz(), client);
                if (zaa != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(zaa, null);
                    String name = this.zac.getClass().getName();
                    String connectionResult2 = connectionResult.toString();
                    StringBuilder sb = new StringBuilder(name.length() + 35 + connectionResult2.length());
                    sb.append("The service for ");
                    sb.append(name);
                    sb.append(" is not available: ");
                    sb.append(connectionResult2);
                    Log.w("GoogleApiManager", sb.toString());
                    zac(connectionResult, null);
                    return;
                }
                zabn zabnVar = new zabn(googleApiManager, client, this.zad);
                if (client.requiresSignIn()) {
                    ((zacm) Preconditions.checkNotNull(this.zai)).zac(zabnVar);
                }
                try {
                    client.connect(zabnVar);
                } catch (SecurityException e2) {
                    zac(new ConnectionResult(10), e2);
                }
            } catch (IllegalStateException e3) {
                zac(new ConnectionResult(10), e3);
            }
        }
    }

    public final void zan(zal zalVar) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        this.zaf.add(zalVar);
    }

    public final boolean zao() {
        return this.zac.isConnected();
    }

    public final boolean zap() {
        return this.zac.requiresSignIn();
    }

    public final int zaq() {
        return this.zah;
    }

    public final int zar() {
        return this.zam;
    }

    public final void zas() {
        this.zam++;
    }

    public final /* synthetic */ boolean zaw(boolean z) {
        return zaM(false);
    }

    public final /* synthetic */ void zax(zabl zablVar) {
        if (this.zak.contains(zablVar) && !this.zaj) {
            if (!this.zac.isConnected()) {
                zam();
            } else {
                zaF();
            }
        }
    }

    public final /* synthetic */ void zay(zabl zablVar) {
        Feature[] zaa;
        if (this.zak.remove(zablVar)) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zaF().removeMessages(15, zablVar);
            googleApiManager.zaF().removeMessages(16, zablVar);
            Feature zab = zablVar.zab();
            Queue<zai> queue = this.zab;
            ArrayList arrayList = new ArrayList(queue.size());
            for (zai zaiVar : queue) {
                if ((zaiVar instanceof zac) && (zaa = ((zac) zaiVar).zaa(this)) != null && ArrayUtils.contains(zaa, zab)) {
                    arrayList.add(zaiVar);
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                zai zaiVar2 = (zai) arrayList.get(i2);
                queue.remove(zaiVar2);
                zaiVar2.zae(new UnsupportedApiCallException(zab));
            }
        }
    }

    public final /* synthetic */ Api.Client zaz() {
        return this.zac;
    }
}
