package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2373c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f2374d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f2375e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String[] f2376f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Handler f2377g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Runnable f2378h;

    public /* synthetic */ a(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable, int i2) {
        this.f2373c = i2;
        this.f2374d = flutterLoader;
        this.f2375e = context;
        this.f2376f = strArr;
        this.f2377g = handler;
        this.f2378h = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2373c) {
            case 0:
                FlutterLoader.b(this.f2374d, this.f2375e, this.f2376f, this.f2377g, this.f2378h);
                return;
            default:
                FlutterLoader.a(this.f2374d, this.f2375e, this.f2376f, this.f2377g, this.f2378h);
                return;
        }
    }
}
