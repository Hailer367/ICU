package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2015a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f2016b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f2017c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f2018d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2019e;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Object obj, long j2, TimeUnit timeUnit, int i2) {
        this.f2015a = i2;
        this.f2016b = delegatingScheduledExecutorService;
        this.f2019e = obj;
        this.f2017c = j2;
        this.f2018d = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        ScheduledFuture lambda$schedule$2;
        ScheduledFuture lambda$schedule$5;
        switch (this.f2015a) {
            case 0:
                lambda$schedule$2 = this.f2016b.lambda$schedule$2((Runnable) this.f2019e, this.f2017c, this.f2018d, completer);
                return lambda$schedule$2;
            default:
                lambda$schedule$5 = this.f2016b.lambda$schedule$5((Callable) this.f2019e, this.f2017c, this.f2018d, completer);
                return lambda$schedule$5;
        }
    }
}
