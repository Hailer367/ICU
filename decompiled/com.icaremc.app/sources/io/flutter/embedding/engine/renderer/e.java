package io.flutter.embedding.engine.renderer;

import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ImageReader f4200a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f4201b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public boolean f4202c = false;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlutterRenderer$ImageReaderSurfaceProducer f4203d;

    public e(FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer, ImageReader imageReader) {
        this.f4203d = flutterRenderer$ImageReaderSurfaceProducer;
        this.f4200a = imageReader;
        imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.d
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(ImageReader imageReader2) {
                Image image;
                boolean z;
                e eVar = e.this;
                FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer2 = eVar.f4203d;
                try {
                    image = imageReader2.acquireLatestImage();
                } catch (IllegalStateException e4) {
                    Log.e("ImageReaderSurfaceProducer", "onImageAvailable acquireLatestImage failed: " + e4);
                    image = null;
                }
                if (image != null) {
                    z = flutterRenderer$ImageReaderSurfaceProducer2.released;
                    if (!z && !eVar.f4202c) {
                        flutterRenderer$ImageReaderSurfaceProducer2.onImage(imageReader2, image);
                    } else {
                        image.close();
                    }
                }
            }
        }, new Handler(Looper.getMainLooper()));
    }
}
