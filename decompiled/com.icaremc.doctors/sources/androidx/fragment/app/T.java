package androidx.fragment.app;

import android.os.Handler;
import io.flutter.embedding.android.FlutterFragmentActivity;

/* loaded from: classes.dex */
public abstract class T extends P {

    /* renamed from: c, reason: collision with root package name */
    public final FlutterFragmentActivity f1566c;

    /* renamed from: d, reason: collision with root package name */
    public final FlutterFragmentActivity f1567d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f1568e;

    /* renamed from: f, reason: collision with root package name */
    public final i0 f1569f;

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.fragment.app.i0, androidx.fragment.app.h0] */
    public T(FlutterFragmentActivity flutterFragmentActivity) {
        Handler handler = new Handler();
        this.f1566c = flutterFragmentActivity;
        this.f1567d = flutterFragmentActivity;
        this.f1568e = handler;
        this.f1569f = new h0();
    }
}
