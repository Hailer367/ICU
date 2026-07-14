package io.flutter.embedding.engine.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ImageDecoderHeifApi36Impl extends ImageDecoderDefaultImpl {
    public ImageDecoderHeifApi36Impl() {
        super(null);
    }

    @Override // io.flutter.embedding.engine.image.ImageDecoderDefaultImpl, io.flutter.embedding.engine.image.ImageDecoder
    public Bitmap decodeImage(ByteBuffer byteBuffer, Metadata metadata) {
        Bitmap decodeImage = super.decodeImage(byteBuffer, metadata);
        if (decodeImage != null) {
            return decodeImage;
        }
        return decodeImageFallback(byteBuffer, metadata);
    }

    public Bitmap decodeImageFallback(ByteBuffer byteBuffer, Metadata metadata) {
        byte[] bytes = ImageUtils.getBytes(byteBuffer);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        if (metadata.rotation != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(metadata.rotation);
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            decodeByteArray.recycle();
            return ImageUtils.applyFlipIfNeeded(createBitmap, metadata.orientation);
        }
        return ImageUtils.applyFlipIfNeeded(decodeByteArray, metadata.orientation);
    }
}
