package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2023c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f2024d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f2025e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f2026f;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer, int i2) {
        this.f2023c = i2;
        this.f2024d = delegatingScheduledExecutorService;
        this.f2025e = runnable;
        this.f2026f = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2023c) {
            case 0:
                this.f2024d.lambda$scheduleWithFixedDelay$10(this.f2025e, this.f2026f);
                return;
            case 1:
                this.f2024d.lambda$scheduleAtFixedRate$7(this.f2025e, this.f2026f);
                return;
            default:
                this.f2024d.lambda$schedule$1(this.f2025e, this.f2026f);
                return;
        }
    }
}
