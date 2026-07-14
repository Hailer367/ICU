package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2405c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f2406d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2407e;

    public /* synthetic */ c(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, TaskCompletionSource taskCompletionSource, int i2) {
        this.f2405c = i2;
        this.f2406d = flutterFirebaseCorePlugin;
        this.f2407e = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2405c) {
            case 0:
                this.f2406d.lambda$optionsFromResource$5(this.f2407e);
                return;
            default:
                this.f2406d.lambda$initializeCore$4(this.f2407e);
                return;
        }
    }
}
