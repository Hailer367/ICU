package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements Continuation, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2088a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2089b;

    public /* synthetic */ l(int i2, Object obj) {
        this.f2088a = i2;
        this.f2089b = obj;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f2088a) {
            case 1:
                WakeLockHolder.completeWakefulIntent((Intent) this.f2089b);
                return;
            case 2:
                WithinAppServiceBinder.a((WithinAppServiceConnection.BindRequest) this.f2089b, task);
                return;
            default:
                ((ScheduledFuture) this.f2089b).cancel(false);
                return;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return GmsRpc.a((GmsRpc) this.f2089b, task);
    }
}
