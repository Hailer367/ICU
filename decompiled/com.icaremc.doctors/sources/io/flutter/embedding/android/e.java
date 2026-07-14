package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyboardMap;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundExecutor;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2359c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2360d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2361e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f2362f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f2363g;

    public /* synthetic */ e(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, long j2, KeyEvent keyEvent, int i2) {
        this.f2359c = i2;
        this.f2360d = keyEmbedderResponder;
        this.f2361e = keyPair;
        this.f2362f = j2;
        this.f2363g = keyEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2359c) {
            case 0:
                ((KeyEmbedderResponder) this.f2360d).lambda$synchronizePressingKey$0((KeyboardMap.KeyPair) this.f2361e, this.f2362f, (KeyEvent) this.f2363g);
                return;
            case 1:
                ((KeyEmbedderResponder) this.f2360d).lambda$synchronizePressingKey$1((KeyboardMap.KeyPair) this.f2361e, this.f2362f, (KeyEvent) this.f2363g);
                return;
            default:
                FlutterFirebaseMessagingBackgroundExecutor.b((FlutterFirebaseMessagingBackgroundExecutor) this.f2360d, (FlutterLoader) this.f2361e, (FlutterShellArgs) this.f2363g, this.f2362f);
                return;
        }
    }

    public /* synthetic */ e(FlutterFirebaseMessagingBackgroundExecutor flutterFirebaseMessagingBackgroundExecutor, FlutterLoader flutterLoader, FlutterShellArgs flutterShellArgs, long j2) {
        this.f2359c = 2;
        this.f2360d = flutterFirebaseMessagingBackgroundExecutor;
        this.f2361e = flutterLoader;
        this.f2363g = flutterShellArgs;
        this.f2362f = j2;
    }
}
