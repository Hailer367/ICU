package com.google.android.gms.common.api.internal;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zaaq implements Runnable {
    final /* synthetic */ zaar zab;

    public /* synthetic */ zaaq(zaar zaarVar, byte[] bArr) {
        Objects.requireNonNull(zaarVar);
        this.zab = zaarVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock zas;
        zaar zaarVar = this.zab;
        zaarVar.zas().lock();
        try {
            try {
            } catch (RuntimeException e2) {
                this.zab.zar().zas(e2);
            }
            if (Thread.interrupted()) {
                zas = zaarVar.zas();
                zas.unlock();
            } else {
                zaa();
                zas = this.zab.zas();
                zas.unlock();
            }
        } catch (Throwable th) {
            this.zab.zas().unlock();
            throw th;
        }
    }

    public abstract void zaa();
}
