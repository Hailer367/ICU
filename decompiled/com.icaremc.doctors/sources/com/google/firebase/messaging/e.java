package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements SuccessContinuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2074a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2075b;

    public /* synthetic */ e(String str, int i2) {
        this.f2074a = i2;
        this.f2075b = str;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        Task lambda$subscribeToTopic$10;
        Task lambda$unsubscribeFromTopic$11;
        switch (this.f2074a) {
            case 0:
                lambda$subscribeToTopic$10 = FirebaseMessaging.lambda$subscribeToTopic$10(this.f2075b, (TopicsSubscriber) obj);
                return lambda$subscribeToTopic$10;
            default:
                lambda$unsubscribeFromTopic$11 = FirebaseMessaging.lambda$unsubscribeFromTopic$11(this.f2075b, (TopicsSubscriber) obj);
                return lambda$unsubscribeFromTopic$11;
        }
    }
}
