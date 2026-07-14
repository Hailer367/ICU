package io.flutter.embedding.engine.image;

import io.flutter.embedding.engine.image.FlutterImageDecoder;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Metadata {
    int height;
    String mimeType;
    int orientation;
    int originalHeight;
    int originalWidth;
    int rotation;
    int width;

    public static Metadata create(ByteBuffer byteBuffer, FlutterImageDecoder.HeaderListener headerListener) {
        Metadata metadata = new Metadata();
        byte[] bytes = ImageUtils.getBytes(byteBuffer);
        BitmapMetadataReader.read(bytes, metadata);
        if (metadata.isHeif()) {
            MediaMetadataReader.read(bytes, metadata);
            headerListener.onImageHeader(metadata.width, metadata.height);
            ExifMetadataReader.read(bytes, metadata);
        }
        return metadata;
    }

    public boolean isHeif() {
        return "image/heif".equals(this.mimeType);
    }
}
