package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.Objects;

/* loaded from: classes.dex */
final class zad implements zah {
    final /* synthetic */ FrameLayout zaa;
    final /* synthetic */ LayoutInflater zab;
    final /* synthetic */ ViewGroup zac;
    final /* synthetic */ Bundle zad;
    final /* synthetic */ DeferredLifecycleHelper zae;

    public zad(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zaa = frameLayout;
        this.zab = layoutInflater;
        this.zac = viewGroup;
        this.zad = bundle;
        Objects.requireNonNull(deferredLifecycleHelper);
        this.zae = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab(LifecycleDelegate lifecycleDelegate) {
        FrameLayout frameLayout = this.zaa;
        frameLayout.removeAllViews();
        frameLayout.addView(this.zae.zaa().onCreateView(this.zab, this.zac, this.zad));
    }
}
