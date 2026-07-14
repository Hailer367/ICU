package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2012c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2013d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2014e;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f2012c = i2;
        this.f2013d = obj;
        this.f2014e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2012c) {
            case 0:
                ((CustomThreadFactory) this.f2013d).lambda$newThread$0((Runnable) this.f2014e);
                return;
            case 1:
                DelegatingScheduledExecutorService.d((Callable) this.f2013d, (DelegatingScheduledFuture.Completer) this.f2014e);
                return;
            default:
                LimitedConcurrencyExecutor.a((LimitedConcurrencyExecutor) this.f2013d, (Runnable) this.f2014e);
                return;
        }
    }
}
