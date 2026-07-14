package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zabh implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabk zab;

    public zabh(zabk zabkVar, int i2) {
        this.zaa = i2;
        Objects.requireNonNull(zabkVar);
        this.zab = zabkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zau(this.zaa);
    }
}
