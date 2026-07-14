package io.flutter.plugins.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2428c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseMessagingPlugin f2429d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2430e;

    public /* synthetic */ g(FlutterFirebaseMessagingPlugin flutterFirebaseMessagingPlugin, TaskCompletionSource taskCompletionSource, int i2) {
        this.f2428c = i2;
        this.f2429d = flutterFirebaseMessagingPlugin;
        this.f2430e = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2428c) {
            case 0:
                this.f2429d.lambda$requestPermissions$12(this.f2430e);
                return;
            case 1:
                this.f2429d.lambda$getToken$3(this.f2430e);
                return;
            case 2:
                this.f2429d.lambda$getPermissions$13(this.f2430e);
                return;
            default:
                this.f2429d.lambda$getInitialMessage$9(this.f2430e);
                return;
        }
    }
}
