package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import r.C0294f;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class GoogleApiManager implements Handler.Callback {
    private static GoogleApiManager zah;
    private TelemetryData zaf;
    private TelemetryLoggingClient zag;
    private final Context zaj;
    private final GoogleApiAvailability zak;
    private final com.google.android.gms.common.internal.zao zal;
    private final Handler zas;
    private volatile boolean zat;
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    private static final Object zae = new Object();
    private static volatile boolean zai = false;
    private long zac = 10000;
    private boolean zad = false;
    private final AtomicInteger zam = new AtomicInteger(1);
    private final AtomicInteger zan = new AtomicInteger(0);
    private final Map zao = new ConcurrentHashMap(5, 0.75f, 1);
    private zaab zap = null;
    private final Set zaq = new C0294f(0);
    private final Set zar = new C0294f(0);

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zat = true;
        this.zaj = context;
        com.google.android.gms.internal.base.zao zaoVar = new com.google.android.gms.internal.base.zao(looper, this);
        this.zas = zaoVar;
        this.zak = googleApiAvailability;
        this.zal = new com.google.android.gms.common.internal.zao(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zat = false;
        }
        zaoVar.sendMessage(zaoVar.obtainMessage(6));
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (zae) {
            try {
                GoogleApiManager googleApiManager = zah;
                if (googleApiManager != null) {
                    googleApiManager.zan.incrementAndGet();
                    Handler handler = googleApiManager.zas;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final zabk zaH(GoogleApi googleApi) {
        Map map = this.zao;
        ApiKey apiKey = googleApi.getApiKey();
        zabk zabkVar = (zabk) map.get(apiKey);
        if (zabkVar == null) {
            zabkVar = new zabk(this, googleApi);
            map.put(apiKey, zabkVar);
        }
        if (zabkVar.zap()) {
            this.zar.add(apiKey);
        }
        zabkVar.zam();
        return zabkVar;
    }

    private final void zaI(TaskCompletionSource taskCompletionSource, int i2, GoogleApi googleApi) {
        zaby zaa2;
        if (i2 != 0 && (zaa2 = zaby.zaa(this, i2, googleApi.getApiKey())) != null) {
            Task task = taskCompletionSource.getTask();
            final Handler handler = this.zas;
            Objects.requireNonNull(handler);
            task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.zabp
                @Override // java.util.concurrent.Executor
                public final /* synthetic */ void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, zaa2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zaJ(ApiKey apiKey, ConnectionResult connectionResult) {
        String zaa2 = apiKey.zaa();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(zaa2).length() + 63 + valueOf.length());
        sb.append("API: ");
        sb.append(zaa2);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(connectionResult, sb.toString());
    }

    private final void zaK() {
        TelemetryData telemetryData = this.zaf;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || zam()) {
                zaL().log(telemetryData);
            }
            this.zaf = null;
        }
    }

    private final TelemetryLoggingClient zaL() {
        if (this.zag == null) {
            this.zag = TelemetryLogging.getClient(this.zaj);
        }
        return this.zag;
    }

    public static GoogleApiManager zaa(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zae) {
            try {
                if (zah == null) {
                    zah = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
                    if (zai) {
                        final Handler handler = zah.zas;
                        Objects.requireNonNull(handler);
                        GmsClient.zag(new Executor() { // from class: com.google.android.gms.common.api.internal.zabo
                            @Override // java.util.concurrent.Executor
                            public final /* synthetic */ void execute(Runnable runnable) {
                                handler.post(runnable);
                            }
                        });
                    }
                }
                googleApiManager = zah;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    public static GoogleApiManager zab() {
        GoogleApiManager googleApiManager;
        synchronized (zae) {
            Preconditions.checkNotNull(zah, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zah;
        }
        return googleApiManager;
    }

    public static boolean zas() {
        synchronized (zae) {
            try {
                if (zah == null) {
                    zai = true;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zat() {
        return zai;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        long j2 = 300000;
        zabk zabkVar = null;
        switch (i2) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.zac = j2;
                Handler handler = this.zas;
                handler.removeMessages(12);
                Iterator it = this.zao.keySet().iterator();
                while (it.hasNext()) {
                    handler.sendMessageDelayed(handler.obtainMessage(12, (ApiKey) it.next()), this.zac);
                }
                return true;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator it2 = zalVar.zaa().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        ApiKey apiKey = (ApiKey) it2.next();
                        zabk zabkVar2 = (zabk) this.zao.get(apiKey);
                        if (zabkVar2 == null) {
                            zalVar.zac(apiKey, new ConnectionResult(13), null);
                        } else if (zabkVar2.zao()) {
                            zalVar.zac(apiKey, ConnectionResult.RESULT_SUCCESS, zabkVar2.zaf().getEndpointPackageName());
                        } else {
                            ConnectionResult zai2 = zabkVar2.zai();
                            if (zai2 != null) {
                                zalVar.zac(apiKey, zai2, null);
                            } else {
                                zabkVar2.zan(zalVar);
                                zabkVar2.zam();
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (zabk zabkVar3 : this.zao.values()) {
                    zabkVar3.zah();
                    zabkVar3.zam();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zacc zaccVar = (zacc) message.obj;
                Map map = this.zao;
                GoogleApi googleApi = zaccVar.zac;
                zabk zabkVar4 = (zabk) map.get(googleApi.getApiKey());
                if (zabkVar4 == null) {
                    zabkVar4 = zaH(googleApi);
                }
                if (zabkVar4.zap() && this.zan.get() != zaccVar.zab) {
                    zaccVar.zaa.zad(zaa);
                    zabkVar4.zae();
                } else {
                    zabkVar4.zad(zaccVar.zaa);
                }
                return true;
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it3 = this.zao.values().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        zabk zabkVar5 = (zabk) it3.next();
                        if (zabkVar5.zaq() == i3) {
                            zabkVar = zabkVar5;
                        }
                    }
                }
                if (zabkVar != null) {
                    if (connectionResult.getErrorCode() == 13) {
                        String errorString = this.zak.getErrorString(connectionResult.getErrorCode());
                        String errorMessage = connectionResult.getErrorMessage();
                        StringBuilder sb = new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length());
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(errorString);
                        sb.append(": ");
                        sb.append(errorMessage);
                        zabkVar.zav(new Status(17, sb.toString()));
                    } else {
                        zabkVar.zav(zaJ(zabkVar.zaA(), connectionResult));
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 65);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                }
                return true;
            case 6:
                Context context = this.zaj;
                if (context.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) context.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabf(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zac = 300000L;
                    }
                }
                return true;
            case 7:
                zaH((GoogleApi) message.obj);
                return true;
            case 9:
                Map map2 = this.zao;
                if (map2.containsKey(message.obj)) {
                    ((zabk) map2.get(message.obj)).zaj();
                }
                return true;
            case 10:
                Set set = this.zar;
                Iterator it4 = set.iterator();
                while (it4.hasNext()) {
                    zabk zabkVar6 = (zabk) this.zao.remove((ApiKey) it4.next());
                    if (zabkVar6 != null) {
                        zabkVar6.zae();
                    }
                }
                set.clear();
                return true;
            case 11:
                Map map3 = this.zao;
                if (map3.containsKey(message.obj)) {
                    ((zabk) map3.get(message.obj)).zak();
                }
                return true;
            case 12:
                Map map4 = this.zao;
                if (map4.containsKey(message.obj)) {
                    ((zabk) map4.get(message.obj)).zal();
                }
                return true;
            case 14:
                zaac zaacVar = (zaac) message.obj;
                ApiKey zaa2 = zaacVar.zaa();
                Map map5 = this.zao;
                if (!map5.containsKey(zaa2)) {
                    zaacVar.zab().setResult(Boolean.FALSE);
                } else {
                    zaacVar.zab().setResult(Boolean.valueOf(((zabk) map5.get(zaa2)).zaw(false)));
                }
                return true;
            case 15:
                zabl zablVar = (zabl) message.obj;
                Map map6 = this.zao;
                if (map6.containsKey(zablVar.zaa())) {
                    ((zabk) map6.get(zablVar.zaa())).zax(zablVar);
                }
                return true;
            case 16:
                zabl zablVar2 = (zabl) message.obj;
                Map map7 = this.zao;
                if (map7.containsKey(zablVar2.zaa())) {
                    ((zabk) map7.get(zablVar2.zaa())).zay(zablVar2);
                }
                return true;
            case 17:
                zaK();
                return true;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                zabz zabzVar = (zabz) message.obj;
                long j3 = zabzVar.zac;
                if (j3 == 0) {
                    zaL().log(new TelemetryData(zabzVar.zab, Arrays.asList(zabzVar.zaa)));
                } else {
                    TelemetryData telemetryData = this.zaf;
                    if (telemetryData != null) {
                        List zab2 = telemetryData.zab();
                        if (telemetryData.zaa() == zabzVar.zab && (zab2 == null || zab2.size() < zabzVar.zad)) {
                            this.zaf.zac(zabzVar.zaa);
                        } else {
                            this.zas.removeMessages(17);
                            zaK();
                        }
                    }
                    if (this.zaf == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zabzVar.zaa);
                        this.zaf = new TelemetryData(zabzVar.zab, arrayList);
                        Handler handler2 = this.zas;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), j3);
                    }
                }
                return true;
            case 19:
                this.zad = false;
                return true;
            default:
                StringBuilder sb3 = new StringBuilder(String.valueOf(i2).length() + 20);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
    }

    public final /* synthetic */ GoogleApiAvailability zaA() {
        return this.zak;
    }

    public final /* synthetic */ com.google.android.gms.common.internal.zao zaB() {
        return this.zal;
    }

    public final /* synthetic */ Map zaC() {
        return this.zao;
    }

    public final /* synthetic */ zaab zaD() {
        return this.zap;
    }

    public final /* synthetic */ Set zaE() {
        return this.zaq;
    }

    public final /* synthetic */ Handler zaF() {
        return this.zas;
    }

    public final /* synthetic */ boolean zaG() {
        return this.zat;
    }

    public final int zac() {
        return this.zam.getAndIncrement();
    }

    public final void zad(GoogleApi googleApi) {
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void zae(zaab zaabVar) {
        synchronized (zae) {
            try {
                if (this.zap != zaabVar) {
                    this.zap = zaabVar;
                    this.zaq.clear();
                }
                this.zaq.addAll(zaabVar.zab());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zaf(zaab zaabVar) {
        synchronized (zae) {
            try {
                if (this.zap == zaabVar) {
                    this.zap = null;
                    this.zaq.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zabk zag(ApiKey apiKey) {
        return (zabk) this.zao.get(apiKey);
    }

    public final Task zah(Iterable iterable) {
        zal zalVar = new zal(iterable);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(2, zalVar));
        return zalVar.zab();
    }

    public final void zai() {
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final Task zaj(GoogleApi googleApi) {
        zaac zaacVar = new zaac(googleApi.getApiKey());
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(14, zaacVar));
        return zaacVar.zab().getTask();
    }

    public final void zak(GoogleApi googleApi, int i2, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zacc zaccVar = new zacc(new zae(i2, apiMethodImpl), this.zan.get(), googleApi);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(4, zaccVar));
    }

    public final void zal(GoogleApi googleApi, int i2, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaI(taskCompletionSource, taskApiCall.zab(), googleApi);
        zacc zaccVar = new zacc(new zag(i2, taskApiCall, taskCompletionSource, statusExceptionMapper), this.zan.get(), googleApi);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(4, zaccVar));
    }

    public final boolean zam() {
        if (this.zad) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int zab2 = this.zal.zab(this.zaj, 203400000);
        if (zab2 != -1 && zab2 != 0) {
            return false;
        }
        return true;
    }

    public final Task zan(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaI(taskCompletionSource, registerListenerMethod.zab(), googleApi);
        zacc zaccVar = new zacc(new zaf(new zacd(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource), this.zan.get(), googleApi);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(8, zaccVar));
        return taskCompletionSource.getTask();
    }

    public final Task zao(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, int i2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaI(taskCompletionSource, i2, googleApi);
        zacc zaccVar = new zacc(new zah(listenerKey, taskCompletionSource), this.zan.get(), googleApi);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(13, zaccVar));
        return taskCompletionSource.getTask();
    }

    public final boolean zap(ConnectionResult connectionResult, int i2) {
        return this.zak.zad(this.zaj, connectionResult, i2);
    }

    public final void zaq(ConnectionResult connectionResult, int i2) {
        if (!zap(connectionResult, i2)) {
            Handler handler = this.zas;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
        }
    }

    public final void zar(MethodInvocation methodInvocation, int i2, long j2, int i3) {
        zabz zabzVar = new zabz(methodInvocation, i2, j2, i3);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(18, zabzVar));
    }

    public final /* synthetic */ long zaw() {
        return this.zac;
    }

    public final /* synthetic */ void zax(boolean z) {
        this.zad = true;
    }

    public final /* synthetic */ Context zaz() {
        return this.zaj;
    }
}
