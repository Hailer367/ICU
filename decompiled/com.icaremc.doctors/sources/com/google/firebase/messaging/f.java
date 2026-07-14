package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2076c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f2077d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2078e;

    public /* synthetic */ f(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource, int i2) {
        this.f2076c = i2;
        this.f2077d = firebaseMessaging;
        this.f2078e = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2076c) {
            case 0:
                this.f2077d.lambda$deleteToken$9(this.f2078e);
                return;
            case 1:
                this.f2077d.lambda$getToken$7(this.f2078e);
                return;
            default:
                this.f2077d.lambda$deleteToken$8(this.f2078e);
                return;
        }
    }
}
