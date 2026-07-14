package io.flutter.embedding.engine.image;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Size;
import io.flutter.Log;
import io.flutter.embedding.engine.image.FlutterImageDecoder;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ImageDecoderDefaultImpl implements ImageDecoder {
    private static final String TAG = "FlutterImageDecoderImplDefault";
    private final FlutterImageDecoder.HeaderListener listener;

    public ImageDecoderDefaultImpl(FlutterImageDecoder.HeaderListener headerListener) {
        this.listener = headerListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decodeImage$0(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        ColorSpace colorSpace;
        Size size;
        ColorSpace.Named unused;
        unused = ColorSpace.Named.SRGB;
        colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        imageDecoder.setTargetColorSpace(colorSpace);
        imageDecoder.setAllocator(1);
        if (this.listener != null) {
            size = imageInfo.getSize();
            this.listener.onImageHeader(size.getWidth(), size.getHeight());
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [io.flutter.embedding.engine.image.b] */
    @Override // io.flutter.embedding.engine.image.ImageDecoder
    public Bitmap decodeImage(ByteBuffer byteBuffer, Metadata metadata) {
        ImageDecoder.Source createSource;
        Bitmap decodeBitmap;
        createSource = android.graphics.ImageDecoder.createSource(byteBuffer);
        try {
            decodeBitmap = android.graphics.ImageDecoder.decodeBitmap(createSource, new ImageDecoder.OnHeaderDecodedListener() { // from class: io.flutter.embedding.engine.image.b
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    ImageDecoderDefaultImpl.this.lambda$decodeImage$0(imageDecoder, imageInfo, source);
                }
            });
            return decodeBitmap;
        } catch (IOException e2) {
            Log.e(TAG, "Failed to decode image", e2);
            return null;
        }
    }
}
