package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.H;

/* loaded from: classes.dex */
final class zah extends zaj {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ H zab;
    final /* synthetic */ int zac;

    public zah(Intent intent, H h2, int i2) {
        this.zaa = intent;
        this.zab = h2;
        this.zac = i2;
    }

    @Override // com.google.android.gms.common.internal.zaj
    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
