package io.flutter.embedding.engine.image;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface ImageDecoder {
    Bitmap decodeImage(ByteBuffer byteBuffer, Metadata metadata);
}
