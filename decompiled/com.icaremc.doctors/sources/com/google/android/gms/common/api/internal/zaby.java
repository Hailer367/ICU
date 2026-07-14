package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zaby implements OnCompleteListener {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey zac;
    private final long zad;
    private final long zae;

    public zaby(GoogleApiManager googleApiManager, int i2, ApiKey apiKey, long j2, long j3, String str, String str2) {
        this.zaa = googleApiManager;
        this.zab = i2;
        this.zac = apiKey;
        this.zad = j2;
        this.zae = j3;
    }

    public static zaby zaa(GoogleApiManager googleApiManager, int i2, ApiKey apiKey) {
        boolean z;
        long j2;
        if (googleApiManager.zam()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if (config != null) {
                if (config.getMethodInvocationTelemetryEnabled()) {
                    z = config.getMethodTimingTelemetryEnabled();
                    zabk zag = googleApiManager.zag(apiKey);
                    if (zag != null) {
                        if (zag.zaf() instanceof BaseGmsClient) {
                            BaseGmsClient baseGmsClient = (BaseGmsClient) zag.zaf();
                            if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                                ConnectionTelemetryConfiguration zab = zab(zag, baseGmsClient, i2);
                                if (zab != null) {
                                    zag.zas();
                                    z = zab.getMethodTimingTelemetryEnabled();
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            return null;
                        }
                    }
                } else {
                    return null;
                }
            } else {
                z = true;
            }
            long j3 = 0;
            if (z) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = 0;
            }
            if (z) {
                j3 = SystemClock.elapsedRealtime();
            }
            return new zaby(googleApiManager, i2, apiKey, j2, j3, null, null);
        }
        return null;
    }

    private static ConnectionTelemetryConfiguration zab(zabk zabkVar, BaseGmsClient baseGmsClient, int i2) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i2) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i2))) || zabkVar.zar() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        zabk zag;
        boolean z;
        long j2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j3;
        long j4;
        int i8;
        GoogleApiManager googleApiManager = this.zaa;
        if (googleApiManager.zam()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zag = googleApiManager.zag(this.zac)) != null && (zag.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zag.zaf();
                long j5 = this.zad;
                boolean z2 = true;
                if (j5 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                if (config != null) {
                    z &= config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    int version = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration zab = zab(zag, baseGmsClient, this.zab);
                        if (zab != null) {
                            if (!zab.getMethodTimingTelemetryEnabled() || j5 <= 0) {
                                z2 = false;
                            }
                            maxMethodInvocationsInBatch = zab.getMaxMethodInvocationsLogged();
                            i2 = version;
                            j2 = j5;
                            z = z2;
                        } else {
                            return;
                        }
                    } else {
                        i2 = version;
                        j2 = j5;
                    }
                    i4 = batchPeriodMillis;
                    i3 = maxMethodInvocationsInBatch;
                } else {
                    j2 = j5;
                    i2 = 0;
                    i3 = 100;
                    i4 = 5000;
                }
                if (task.isSuccessful()) {
                    i7 = 0;
                    i6 = 0;
                } else if (task.isCanceled()) {
                    i6 = -1;
                    i7 = 100;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        i5 = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        if (connectionResult != null) {
                            i6 = connectionResult.getErrorCode();
                            i7 = i5;
                        }
                    } else {
                        i5 = 101;
                    }
                    i6 = -1;
                    i7 = i5;
                }
                if (z) {
                    long j6 = this.zae;
                    long currentTimeMillis = System.currentTimeMillis();
                    j3 = j2;
                    i8 = (int) (SystemClock.elapsedRealtime() - j6);
                    j4 = currentTimeMillis;
                } else {
                    j3 = 0;
                    j4 = 0;
                    i8 = -1;
                }
                googleApiManager.zar(new MethodInvocation(this.zab, i7, i6, j3, j4, null, null, gCoreServiceId, i8), i2, i4, i3);
            }
        }
    }
}
