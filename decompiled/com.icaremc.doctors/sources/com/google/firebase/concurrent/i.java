package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2039a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f2040b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2041c;

    public /* synthetic */ i(Runnable runnable, Object obj, int i2) {
        this.f2039a = i2;
        this.f2040b = runnable;
        this.f2041c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object lambda$submit$0;
        Object lambda$submit$02;
        switch (this.f2039a) {
            case 0:
                lambda$submit$0 = LimitedConcurrencyExecutorService.lambda$submit$0(this.f2040b, this.f2041c);
                return lambda$submit$0;
            default:
                lambda$submit$02 = PausableExecutorServiceImpl.lambda$submit$0(this.f2040b, this.f2041c);
                return lambda$submit$02;
        }
    }
}
