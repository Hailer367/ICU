package io.flutter.plugins.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2420c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f2421d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2422e;

    public /* synthetic */ c(Map map, TaskCompletionSource taskCompletionSource, int i2) {
        this.f2420c = i2;
        this.f2421d = map;
        this.f2422e = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2420c) {
            case 0:
                FlutterFirebaseMessagingPlugin.e(this.f2421d, this.f2422e);
                return;
            case 1:
                FlutterFirebaseMessagingPlugin.m(this.f2421d, this.f2422e);
                return;
            case 2:
                FlutterFirebaseMessagingPlugin.c(this.f2421d, this.f2422e);
                return;
            default:
                FlutterFirebaseMessagingPlugin.a(this.f2421d, this.f2422e);
                return;
        }
    }
}
