package io.flutter.plugins.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2417c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2418d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2419e;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f2417c = i2;
        this.f2418d = obj;
        this.f2419e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2417c) {
            case 0:
                FlutterFirebaseMessagingBackgroundService.lambda$onHandleWork$0((Intent) this.f2418d, (CountDownLatch) this.f2419e);
                return;
            default:
                FlutterFirebaseMessagingPlugin.lambda$getPluginConstantsForFirebaseApp$15((FirebaseApp) this.f2418d, (TaskCompletionSource) this.f2419e);
                return;
        }
    }
}
