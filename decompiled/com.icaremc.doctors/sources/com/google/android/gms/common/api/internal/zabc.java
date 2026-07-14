package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zabc extends com.google.android.gms.internal.base.zao {
    final /* synthetic */ zabd zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zabc(zabd zabdVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zabdVar);
        this.zaa = zabdVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 20);
                sb.append("Unknown message id: ");
                sb.append(i2);
                Log.w("GACStateManager", sb.toString());
                return;
            }
            throw ((RuntimeException) message.obj);
        }
        ((zabb) message.obj).zab(this.zaa);
    }
}
