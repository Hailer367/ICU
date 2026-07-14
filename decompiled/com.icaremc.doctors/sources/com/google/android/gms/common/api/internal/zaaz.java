package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.M;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.firebase.encoders.json.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class zaaz extends GoogleApiClient implements zabu {
    zabs zab;
    final Map zac;
    Set zad;
    final ClientSettings zae;
    final Map zaf;
    final Api.AbstractClientBuilder zag;
    Set zah;
    final zacu zai;
    private final Lock zaj;
    private final com.google.android.gms.common.internal.zan zak;
    private final int zam;
    private final Context zan;
    private final Looper zao;
    private volatile boolean zap;
    private long zaq;
    private long zar;
    private final zaax zas;
    private final GoogleApiAvailability zat;
    private final ListenerHolders zau;
    private final ArrayList zav;
    private Integer zaw;
    private final com.google.android.gms.common.internal.zam zax;
    private zabv zal = null;
    final Queue zaa = new LinkedList();

    public zaaz(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder abstractClientBuilder, Map map, List list, List list2, Map map2, int i2, int i3, ArrayList arrayList) {
        this.zaq = true != ClientLibraryUtils.isPackageSide() ? 120000L : 10000L;
        this.zar = 5000L;
        this.zad = new HashSet();
        this.zau = new ListenerHolders();
        this.zaw = null;
        this.zah = null;
        zaat zaatVar = new zaat(this);
        this.zax = zaatVar;
        this.zan = context;
        this.zaj = lock;
        this.zak = new com.google.android.gms.common.internal.zan(looper, zaatVar);
        this.zao = looper;
        this.zas = new zaax(this, looper);
        this.zat = googleApiAvailability;
        this.zam = i2;
        if (i2 >= 0) {
            this.zaw = Integer.valueOf(i3);
        }
        this.zaf = map;
        this.zac = map2;
        this.zav = arrayList;
        this.zai = new zacu();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zak.zaf((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zak.zai((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.zae = clientSettings;
        this.zag = abstractClientBuilder;
    }

    public static int zaf(Iterable iterable, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            Api.Client client = (Api.Client) it.next();
            z2 |= client.requiresSignIn();
            z3 |= client.providesSignIn();
        }
        if (z2) {
            if (z3 && z) {
                return 2;
            }
            return 1;
        }
        return 3;
    }

    public static String zag(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    private final void zal(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.zaa.zaa(googleApiClient).setResultCallback(new zaaw(this, statusPendingResult, z, googleApiClient));
    }

    private final void zam(int i2) {
        zaaz zaazVar;
        Integer num = this.zaw;
        if (num == null) {
            this.zaw = Integer.valueOf(i2);
        } else if (num.intValue() != i2) {
            String zag = zag(this.zaw.intValue());
            String zag2 = zag(i2);
            StringBuilder sb = new StringBuilder(zag.length() + zag2.length() + 51);
            sb.append("Cannot use sign-in mode: ");
            sb.append(zag2);
            sb.append(". Mode was already set to ");
            sb.append(zag);
            throw new IllegalStateException(sb.toString());
        }
        if (this.zal != null) {
            return;
        }
        Map map = this.zac;
        boolean z = false;
        boolean z2 = false;
        for (Api.Client client : map.values()) {
            z |= client.requiresSignIn();
            z2 |= client.providesSignIn();
        }
        int intValue = this.zaw.intValue();
        if (intValue != 1) {
            if (intValue != 2 || !z) {
                zaazVar = this;
            } else {
                this.zal = zax.zaa(this.zan, this, this.zaj, this.zao, this.zat, map, this.zae, this.zaf, this.zag, this.zav);
                return;
            }
        } else {
            zaazVar = this;
            if (z) {
                if (z2) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            } else {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
        }
        zaazVar.zal = new zabd(zaazVar.zan, zaazVar, zaazVar.zaj, zaazVar.zao, zaazVar.zat, map, zaazVar.zae, zaazVar.zaf, zaazVar.zag, zaazVar.zav, this);
    }

    private final void zan() {
        this.zak.zab();
        ((zabv) Preconditions.checkNotNull(this.zal)).zae();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect() {
        boolean z = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Lock lock = this.zaj;
        lock.lock();
        try {
            if (this.zam >= 0) {
                if (this.zaw == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zaf(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            zam(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            ConnectionResult zaf = ((zabv) Preconditions.checkNotNull(this.zal)).zaf();
            lock.unlock();
            return zaf;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.zaw;
        boolean z = true;
        if (num != null && num.intValue() == 2) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.zac.containsKey(Common.CLIENT_KEY)) {
            zal(this, statusPendingResult, false);
            return statusPendingResult;
        }
        AtomicReference atomicReference = new AtomicReference();
        zaau zaauVar = new zaau(this, atomicReference, statusPendingResult);
        zaav zaavVar = new zaav(this, statusPendingResult);
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.zan);
        builder.addApi(Common.API);
        builder.addConnectionCallbacks(zaauVar);
        builder.addOnConnectionFailedListener(zaavVar);
        builder.setHandler(this.zas);
        GoogleApiClient build = builder.build();
        atomicReference.set(build);
        build.connect();
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        Lock lock = this.zaj;
        lock.lock();
        try {
            int i2 = 2;
            boolean z = false;
            if (this.zam >= 0) {
                Preconditions.checkState(this.zaw != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zaf(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) Preconditions.checkNotNull(this.zaw)).intValue();
            lock.lock();
            try {
                if (intValue == 3 || intValue == 1) {
                    i2 = intValue;
                } else if (intValue != 2) {
                    i2 = intValue;
                    StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 22);
                    sb.append("Illegal sign-in mode: ");
                    sb.append(i2);
                    Preconditions.checkArgument(z, sb.toString());
                    zam(i2);
                    zan();
                    this.zaj.unlock();
                    return;
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(i2).length() + 22);
                sb2.append("Illegal sign-in mode: ");
                sb2.append(i2);
                Preconditions.checkArgument(z, sb2.toString());
                zam(i2);
                zan();
                this.zaj.unlock();
                return;
            } finally {
                this.zaj.unlock();
            }
            z = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        Lock lock = this.zaj;
        lock.lock();
        try {
            this.zai.zab();
            zabv zabvVar = this.zal;
            if (zabvVar != null) {
                zabvVar.zah();
            }
            this.zau.zab();
            Queue<BaseImplementation.ApiMethodImpl> queue = this.zaa;
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : queue) {
                apiMethodImpl.zan(null);
                apiMethodImpl.cancel();
            }
            queue.clear();
            if (this.zal != null) {
                zad();
                this.zak.zaa();
            }
            lock.unlock();
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.zan);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.zap);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zai.zab.size());
        zabv zabvVar = this.zal;
        if (zabvVar != null) {
            zabvVar.zan(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t2) {
        String str;
        Api<?> api = t2.getApi();
        boolean containsKey = this.zac.containsKey(t2.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        Lock lock = this.zaj;
        lock.lock();
        try {
            zabv zabvVar = this.zal;
            if (zabvVar == null) {
                this.zaa.add(t2);
            } else {
                t2 = (T) zabvVar.zab(t2);
            }
            lock.unlock();
            return t2;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t2) {
        String str;
        Map map = this.zac;
        Api<?> api = t2.getApi();
        boolean containsKey = map.containsKey(t2.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        Lock lock = this.zaj;
        lock.lock();
        try {
            zabv zabvVar = this.zal;
            if (zabvVar != null) {
                if (this.zap) {
                    Queue queue = this.zaa;
                    queue.add(t2);
                    while (!queue.isEmpty()) {
                        BaseImplementation.ApiMethodImpl apiMethodImpl = (BaseImplementation.ApiMethodImpl) queue.remove();
                        this.zai.zaa(apiMethodImpl);
                        apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                    }
                    lock.unlock();
                    return t2;
                }
                return (T) zabvVar.zac(t2);
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        C c2 = (C) this.zac.get(anyClientKey);
        Preconditions.checkNotNull(c2, "Appropriate Api was not requested.");
        return c2;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        Lock lock = this.zaj;
        lock.lock();
        try {
            if (!isConnected() && !this.zap) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (this.zac.containsKey(api.zac())) {
                ConnectionResult zad = ((zabv) Preconditions.checkNotNull(this.zal)).zad(api);
                if (zad == null) {
                    if (this.zap) {
                        connectionResult = ConnectionResult.RESULT_SUCCESS;
                    } else {
                        Log.w("GoogleApiClientImpl", zae());
                        String zad2 = api.zad();
                        StringBuilder sb = new StringBuilder(String.valueOf(zad2).length() + 100);
                        sb.append(zad2);
                        sb.append(" requested in getConnectionResult is not connected but is not present in the failed  connections map");
                        Log.wtf("GoogleApiClientImpl", sb.toString(), new Exception());
                        connectionResult = new ConnectionResult(8, null);
                    }
                    lock.unlock();
                    return connectionResult;
                }
                lock.unlock();
                return zad;
            }
            String zad3 = api.zad();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zad3).length() + 42);
            sb2.append(zad3);
            sb2.append(" was never registered with GoogleApiClient");
            throw new IllegalArgumentException(sb2.toString());
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.zan;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zao;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasApi(Api<?> api) {
        return this.zac.containsKey(api.zac());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(Api<?> api) {
        Api.Client client;
        if (!isConnected() || (client = (Api.Client) this.zac.get(api.zac())) == null || !client.isConnected()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        zabv zabvVar = this.zal;
        if (zabvVar != null && zabvVar.zai()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        zabv zabvVar = this.zal;
        if (zabvVar != null && zabvVar.zaj()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zak.zag(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zak.zaj(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zabv zabvVar = this.zal;
        if (zabvVar != null && zabvVar.zak(signInConnectionListener)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void maybeSignOut() {
        zabv zabvVar = this.zal;
        if (zabvVar != null) {
            zabvVar.zam();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zaf(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zai(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> registerListener(L l2) {
        this.zaj.lock();
        try {
            return this.zau.zaa(l2, this.zao, "NO_TYPE");
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(M m2) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) m2);
        int i2 = this.zam;
        if (i2 >= 0) {
            zak.zaa(lifecycleActivity).zac(i2);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zah(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zak(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zaa(Bundle bundle) {
        while (true) {
            Queue queue = this.zaa;
            if (!queue.isEmpty()) {
                execute((BaseImplementation.ApiMethodImpl) queue.remove());
            } else {
                this.zak.zac(bundle);
                return;
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zab(ConnectionResult connectionResult) {
        if (!this.zat.isPlayServicesPossiblyUpdating(this.zan, connectionResult.getErrorCode())) {
            zad();
        }
        if (!this.zap) {
            com.google.android.gms.common.internal.zan zanVar = this.zak;
            zanVar.zae(connectionResult);
            zanVar.zaa();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zac(int i2, boolean z) {
        if (i2 == 1) {
            if (!z && !this.zap) {
                this.zap = true;
                if (this.zab == null && !ClientLibraryUtils.isPackageSide()) {
                    try {
                        this.zab = this.zat.zag(this.zan.getApplicationContext(), new zaay(this));
                    } catch (SecurityException unused) {
                    }
                }
                zaax zaaxVar = this.zas;
                zaaxVar.sendMessageDelayed(zaaxVar.obtainMessage(1), this.zaq);
                zaaxVar.sendMessageDelayed(zaaxVar.obtainMessage(2), this.zar);
            }
            i2 = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zai.zab.toArray(new BasePendingResult[0])) {
            basePendingResult.forceFailureUnlessReady(zacu.zaa);
        }
        com.google.android.gms.common.internal.zan zanVar = this.zak;
        zanVar.zad(i2);
        zanVar.zaa();
        if (i2 == 2) {
            zan();
        }
    }

    public final boolean zad() {
        if (!this.zap) {
            return false;
        }
        this.zap = false;
        zaax zaaxVar = this.zas;
        zaaxVar.removeMessages(2);
        zaaxVar.removeMessages(1);
        zabs zabsVar = this.zab;
        if (zabsVar != null) {
            zabsVar.zab();
            this.zab = null;
        }
        return true;
    }

    public final String zae() {
        StringWriter stringWriter = new StringWriter();
        dump(BuildConfig.FLAVOR, null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public final /* synthetic */ void zah(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        zal(googleApiClient, statusPendingResult, true);
    }

    public final /* synthetic */ void zai() {
        this.zaj.lock();
        try {
            if (this.zap) {
                zan();
            }
        } finally {
            this.zaj.unlock();
        }
    }

    public final /* synthetic */ void zaj() {
        this.zaj.lock();
        try {
            if (zad()) {
                zan();
            }
        } finally {
            this.zaj.unlock();
        }
    }

    public final /* synthetic */ Context zak() {
        return this.zan;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zao(zacs zacsVar) {
        this.zaj.lock();
        try {
            if (this.zah == null) {
                this.zah = new HashSet();
            }
            this.zah.add(zacsVar);
            this.zaj.unlock();
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        if (r4 != false) goto L20;
     */
    @Override // com.google.android.gms.common.api.GoogleApiClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zap(com.google.android.gms.common.api.internal.zacs r4) {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.zaj
            r0.lock()
            java.util.Set r1 = r3.zah     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = "GoogleApiClientImpl"
            if (r1 != 0) goto L18
            java.lang.String r4 = "Attempted to remove pending transform when no transforms are registered."
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Throwable -> L16
            r0.<init>()     // Catch: java.lang.Throwable -> L16
            android.util.Log.wtf(r2, r4, r0)     // Catch: java.lang.Throwable -> L16
            goto L46
        L16:
            r4 = move-exception
            goto L53
        L18:
            boolean r4 = r1.remove(r4)     // Catch: java.lang.Throwable -> L16
            if (r4 != 0) goto L29
            java.lang.String r4 = "Failed to remove pending transform - this may lead to memory leaks!"
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Throwable -> L16
            r0.<init>()     // Catch: java.lang.Throwable -> L16
            android.util.Log.wtf(r2, r4, r0)     // Catch: java.lang.Throwable -> L16
            goto L46
        L29:
            r0.lock()     // Catch: java.lang.Throwable -> L16
            java.util.Set r4 = r3.zah     // Catch: java.lang.Throwable -> L4c
            if (r4 != 0) goto L34
            r0.unlock()     // Catch: java.lang.Throwable -> L16
            goto L3f
        L34:
            boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> L4c
            java.util.concurrent.locks.Lock r0 = r3.zaj     // Catch: java.lang.Throwable -> L16
            r0.unlock()     // Catch: java.lang.Throwable -> L16
            if (r4 == 0) goto L46
        L3f:
            com.google.android.gms.common.api.internal.zabv r4 = r3.zal     // Catch: java.lang.Throwable -> L16
            if (r4 == 0) goto L46
            r4.zal()     // Catch: java.lang.Throwable -> L16
        L46:
            java.util.concurrent.locks.Lock r4 = r3.zaj
            r4.unlock()
            return
        L4c:
            r4 = move-exception
            java.util.concurrent.locks.Lock r0 = r3.zaj     // Catch: java.lang.Throwable -> L16
            r0.unlock()     // Catch: java.lang.Throwable -> L16
            throw r4     // Catch: java.lang.Throwable -> L16
        L53:
            java.util.concurrent.locks.Lock r0 = r3.zaj
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaaz.zap(com.google.android.gms.common.api.internal.zacs):void");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j2, TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        Lock lock = this.zaj;
        lock.lock();
        try {
            Integer num = this.zaw;
            if (num == null) {
                this.zaw = Integer.valueOf(zaf(this.zac.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zam(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            ConnectionResult zag = ((zabv) Preconditions.checkNotNull(this.zal)).zag(j2, timeUnit);
            lock.unlock();
            return zag;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i2) {
        this.zaj.lock();
        boolean z = true;
        if (i2 != 3 && i2 != 1) {
            if (i2 == 2) {
                i2 = 2;
            } else {
                z = false;
            }
        }
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 22);
            sb.append("Illegal sign-in mode: ");
            sb.append(i2);
            Preconditions.checkArgument(z, sb.toString());
            zam(i2);
            zan();
        } finally {
            this.zaj.unlock();
        }
    }
}
