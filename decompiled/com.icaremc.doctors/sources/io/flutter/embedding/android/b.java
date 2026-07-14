package io.flutter.embedding.android;

import io.flutter.embedding.android.FlutterMeasureSpec;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements FlutterMeasureSpec.MeasureCallback, KeyEventChannel.EventResponseHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2356b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f2355a = i2;
        this.f2356b = obj;
    }

    @Override // io.flutter.embedding.engine.systemchannels.KeyEventChannel.EventResponseHandler
    public void onFrameworkResponse(boolean z) {
        ((KeyboardManager.Responder.OnKeyEventHandledCallback) this.f2356b).onKeyEventHandled(z);
    }

    @Override // io.flutter.embedding.android.FlutterMeasureSpec.MeasureCallback
    public void onMeasure(int i2, int i3) {
        switch (this.f2355a) {
            case 0:
                ((FlutterImageView) this.f2356b).setMeasuredDimension(i2, i3);
                return;
            case 1:
                FlutterSurfaceView.a((FlutterSurfaceView) this.f2356b, i2, i3);
                return;
            default:
                FlutterTextureView.a((FlutterTextureView) this.f2356b, i2, i3);
                return;
        }
    }
}
