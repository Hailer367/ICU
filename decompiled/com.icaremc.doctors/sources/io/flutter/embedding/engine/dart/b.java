package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DartMessenger.SerialTaskQueue f2371c;

    public /* synthetic */ b(DartMessenger.SerialTaskQueue serialTaskQueue) {
        this.f2371c = serialTaskQueue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DartMessenger.SerialTaskQueue.a(this.f2371c);
    }
}
