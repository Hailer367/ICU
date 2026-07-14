package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2037a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f2038b;

    public /* synthetic */ h(Runnable runnable, int i2) {
        this.f2037a = i2;
        this.f2038b = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f2037a) {
            case 0:
                return LimitedConcurrencyExecutorService.c(this.f2038b);
            default:
                return PausableExecutorServiceImpl.a(this.f2038b);
        }
    }
}
