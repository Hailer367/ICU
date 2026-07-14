package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2097c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2098d;

    public /* synthetic */ p(int i2, Object obj) {
        this.f2097c = i2;
        this.f2098d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2097c) {
            case 0:
                ((SharedPreferencesQueue) this.f2098d).syncState();
                return;
            default:
                WithinAppServiceConnection.BindRequest.b((WithinAppServiceConnection.BindRequest) this.f2098d);
                return;
        }
    }
}
