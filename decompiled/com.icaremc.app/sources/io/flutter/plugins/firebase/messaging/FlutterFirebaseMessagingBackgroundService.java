package io.flutter.plugins.firebase.messaging;

import A2.t;
import f1.AbstractC0286a;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class FlutterFirebaseMessagingBackgroundService extends a {

    /* renamed from: m, reason: collision with root package name */
    public static final List f4409m = Collections.synchronizedList(new LinkedList());

    /* renamed from: n, reason: collision with root package name */
    public static t f4410n;

    @Override // io.flutter.plugins.firebase.messaging.a, android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (f4410n == null) {
            f4410n = new t(28);
        }
        t tVar = f4410n;
        if (!((AtomicBoolean) tVar.f99g).get()) {
            long j4 = AbstractC0286a.f3704c.getSharedPreferences("io.flutter.firebase.messaging.callback", 0).getLong("callback_handle", 0L);
            if (j4 != 0) {
                tVar.Y(j4, null);
            }
        }
    }
}
