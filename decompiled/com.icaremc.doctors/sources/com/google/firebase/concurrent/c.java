package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2020c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Runnable f2021d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f2022e;

    public /* synthetic */ c(Runnable runnable, DelegatingScheduledFuture.Completer completer, int i2) {
        this.f2020c = i2;
        this.f2021d = runnable;
        this.f2022e = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2020c) {
            case 0:
                DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.f2021d, this.f2022e);
                return;
            case 1:
                DelegatingScheduledExecutorService.lambda$schedule$0(this.f2021d, this.f2022e);
                return;
            default:
                DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.f2021d, this.f2022e);
                return;
        }
    }
}
