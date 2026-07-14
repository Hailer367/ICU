package com.google.firebase.messaging;

import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements OnSuccessListener, FirebaseInstanceIdInternal.NewTokenListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2081a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f2082b;

    public /* synthetic */ h(FirebaseMessaging firebaseMessaging, int i2) {
        this.f2081a = i2;
        this.f2082b = firebaseMessaging;
    }

    @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
    public void onNewToken(String str) {
        this.f2082b.lambda$new$1(str);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        switch (this.f2081a) {
            case 0:
                this.f2082b.lambda$new$3((TopicsSubscriber) obj);
                return;
            case 1:
            default:
                this.f2082b.lambda$handleProxiedNotificationData$5((CloudMessage) obj);
                return;
            case 2:
                this.f2082b.lambda$setNotificationDelegationEnabled$6((Void) obj);
                return;
        }
    }
}
