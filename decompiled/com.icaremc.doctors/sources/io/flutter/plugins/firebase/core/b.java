package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2401c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f2402d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Boolean f2403e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2404f;

    public /* synthetic */ b(String str, Boolean bool, TaskCompletionSource taskCompletionSource, int i2) {
        this.f2401c = i2;
        this.f2402d = str;
        this.f2403e = bool;
        this.f2404f = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2401c) {
            case 0:
                FlutterFirebaseCorePlugin.g(this.f2402d, this.f2403e, this.f2404f);
                return;
            default:
                FlutterFirebaseCorePlugin.i(this.f2402d, this.f2403e, this.f2404f);
                return;
        }
    }
}
