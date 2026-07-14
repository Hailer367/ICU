package io.flutter.plugins.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2426c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2427d;

    public /* synthetic */ f(int i2, TaskCompletionSource taskCompletionSource) {
        this.f2426c = i2;
        this.f2427d = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2426c) {
            case 0:
                this.f2427d.setResult(null);
                return;
            default:
                FlutterFirebaseMessagingPlugin.lambda$deleteToken$2(this.f2427d);
                return;
        }
    }
}
