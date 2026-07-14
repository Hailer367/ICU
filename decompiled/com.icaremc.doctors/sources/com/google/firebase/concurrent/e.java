package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2027a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f2028b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f2029c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f2030d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f2031e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f2032f;

    public /* synthetic */ e(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j2, long j3, TimeUnit timeUnit, int i2) {
        this.f2027a = i2;
        this.f2028b = delegatingScheduledExecutorService;
        this.f2029c = runnable;
        this.f2030d = j2;
        this.f2031e = j3;
        this.f2032f = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        ScheduledFuture lambda$scheduleAtFixedRate$8;
        ScheduledFuture lambda$scheduleWithFixedDelay$11;
        switch (this.f2027a) {
            case 0:
                lambda$scheduleAtFixedRate$8 = this.f2028b.lambda$scheduleAtFixedRate$8(this.f2029c, this.f2030d, this.f2031e, this.f2032f, completer);
                return lambda$scheduleAtFixedRate$8;
            default:
                lambda$scheduleWithFixedDelay$11 = this.f2028b.lambda$scheduleWithFixedDelay$11(this.f2029c, this.f2030d, this.f2031e, this.f2032f, completer);
                return lambda$scheduleWithFixedDelay$11;
        }
    }
}
