package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zaax extends com.google.android.gms.internal.base.zao {
    final /* synthetic */ zaaz zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaax(zaaz zaazVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zaazVar);
        this.zaa = zaazVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 20);
                sb.append("Unknown message id: ");
                sb.append(i2);
                Log.w("GoogleApiClientImpl", sb.toString());
                return;
            }
            this.zaa.zai();
            return;
        }
        this.zaa.zaj();
    }
}
