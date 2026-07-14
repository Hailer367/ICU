package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.C0099a;
import androidx.fragment.app.H;
import androidx.fragment.app.M;
import androidx.fragment.app.h0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzd extends H implements LifecycleFragment {
    private static final WeakHashMap zza = new WeakHashMap();
    private final zzc zzb = new zzc();

    public static zzd zza(M m2) {
        zzd zzdVar;
        h0 supportFragmentManager = m2.getSupportFragmentManager();
        WeakHashMap weakHashMap = zza;
        WeakReference weakReference = (WeakReference) weakHashMap.get(m2);
        if (weakReference != null && (zzdVar = (zzd) weakReference.get()) != null) {
            return zzdVar;
        }
        try {
            zzd zzdVar2 = (zzd) supportFragmentManager.D("SLifecycleFragmentImpl");
            if (zzdVar2 == null || zzdVar2.isRemoving()) {
                zzdVar2 = new zzd();
                C0099a c0099a = new C0099a(supportFragmentManager);
                c0099a.c(0, zzdVar2, "SLifecycleFragmentImpl");
                c0099a.e(true);
            }
            weakHashMap.put(m2, new WeakReference(zzdVar2));
            return zzdVar2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        this.zzb.zzb(str, lifecycleCallback);
    }

    @Override // androidx.fragment.app.H
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.zzb.zzl(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (T) this.zzb.zza(str, cls);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final Activity getLifecycleActivity() {
        return getActivity();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        return this.zzb.zzd();
    }

    @Override // androidx.fragment.app.H
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.zzb.zzh(i2, i3, intent);
    }

    @Override // androidx.fragment.app.H
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzb.zze(bundle);
    }

    @Override // androidx.fragment.app.H
    public final void onDestroy() {
        super.onDestroy();
        this.zzb.zzk();
    }

    @Override // androidx.fragment.app.H
    public final void onResume() {
        super.onResume();
        this.zzb.zzg();
    }

    @Override // androidx.fragment.app.H
    public final void onSaveInstanceState(Bundle bundle) {
        this.zzb.zzi(bundle);
    }

    @Override // androidx.fragment.app.H
    public final void onStart() {
        super.onStart();
        this.zzb.zzf();
    }

    @Override // androidx.fragment.app.H
    public final void onStop() {
        super.onStop();
        this.zzb.zzj();
    }
}
