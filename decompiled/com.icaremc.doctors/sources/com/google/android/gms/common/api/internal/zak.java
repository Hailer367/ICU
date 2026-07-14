package com.google.android.gms.common.api.internal;

import O.a;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public final class zak extends zap {
    private final SparseArray zad;

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.zad = new SparseArray();
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zakVar = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zakVar != null) {
            return zakVar;
        }
        return new zak(fragment);
    }

    private final zaj zai(int i2) {
        SparseArray sparseArray = this.zad;
        if (sparseArray.size() <= i2) {
            return null;
        }
        return (zaj) sparseArray.get(sparseArray.keyAt(i2));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.zad.size(); i2++) {
            zaj zai = zai(i2);
            if (zai != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zai.zaa);
                printWriter.println(":");
                zai.zab.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        SparseArray sparseArray = this.zad;
        boolean z = this.zaa;
        String valueOf = String.valueOf(sparseArray);
        StringBuilder sb = new StringBuilder(String.valueOf(z).length() + 9 + valueOf.length());
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.zab.get() == null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                zaj zai = zai(i2);
                if (zai != null) {
                    zai.zab.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        for (int i2 = 0; i2 < this.zad.size(); i2++) {
            zaj zai = zai(i2);
            if (zai != null) {
                zai.zab.disconnect();
            }
        }
    }

    public final void zab(int i2, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean z;
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        SparseArray sparseArray = this.zad;
        int indexOfKey = sparseArray.indexOfKey(i2);
        String h2 = a.h(new StringBuilder(String.valueOf(i2).length() + 43), "Already managing a GoogleApiClient with id ", i2);
        if (indexOfKey < 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, h2);
        zam zamVar = (zam) this.zab.get();
        boolean z2 = this.zaa;
        String valueOf = String.valueOf(zamVar);
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 32 + String.valueOf(z2).length() + 1 + valueOf.length());
        sb.append("starting AutoManage for client ");
        sb.append(i2);
        sb.append(" ");
        sb.append(z2);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        zaj zajVar = new zaj(this, i2, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zajVar);
        sparseArray.put(i2, zajVar);
        if (this.zaa && zamVar == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.connect();
        }
    }

    public final void zac(int i2) {
        SparseArray sparseArray = this.zad;
        zaj zajVar = (zaj) sparseArray.get(i2);
        sparseArray.remove(i2);
        if (zajVar != null) {
            GoogleApiClient googleApiClient = zajVar.zab;
            googleApiClient.unregisterConnectionFailedListener(zajVar);
            googleApiClient.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zad(ConnectionResult connectionResult, int i2) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zajVar = (zaj) this.zad.get(i2);
        if (zajVar != null) {
            zac(i2);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zajVar.zac;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zae() {
        for (int i2 = 0; i2 < this.zad.size(); i2++) {
            zaj zai = zai(i2);
            if (zai != null) {
                zai.zab.connect();
            }
        }
    }
}
