package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class zao extends Handler {
    private final Looper zaa;

    public zao() {
        this.zaa = Looper.getMainLooper();
    }

    public zao(Looper looper) {
        super(looper);
        this.zaa = Looper.getMainLooper();
    }

    public zao(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zaa = Looper.getMainLooper();
    }
}
