package io.flutter.plugins.firebase.core;

import androidx.annotation.Keep;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p1.AbstractC0579h;
import u1.f;

@Keep
/* loaded from: classes.dex */
public interface FlutterFirebasePlugin {
    public static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    AbstractC0579h didReinitializeFirebaseCore();

    AbstractC0579h getPluginConstantsForFirebaseApp(f fVar);
}
