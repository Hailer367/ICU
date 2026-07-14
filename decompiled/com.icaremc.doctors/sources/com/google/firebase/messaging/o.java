package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Continuation, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2095a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2096b;

    public /* synthetic */ o(Object obj, Object obj2) {
        this.f2095a = obj;
        this.f2096b = obj2;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        EnhancedIntentService.b((EnhancedIntentService) this.f2095a, (Intent) this.f2096b, task);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return RequestDeduplicator.a((RequestDeduplicator) this.f2095a, (String) this.f2096b, task);
    }
}
