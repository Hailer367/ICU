package io.flutter.embedding.engine.image;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import io.flutter.Log;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
class ImageUtils {
    private static final String TAG = "ImageUtils";

    public static Bitmap applyFlipIfNeeded(Bitmap bitmap, int i2) {
        if (bitmap == null || !isFlipCase(i2)) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (i2 != 2) {
            if (i2 != 7) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        return bitmap;
                    }
                    matrix.setScale(1.0f, -1.0f, width / 2.0f, height / 2.0f);
                } else {
                    matrix.setScale(1.0f, -1.0f, width / 2.0f, height / 2.0f);
                }
            } else {
                matrix.setScale(-1.0f, 1.0f, width / 2.0f, height / 2.0f);
            }
        } else {
            matrix.setScale(-1.0f, 1.0f, width / 2.0f, height / 2.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static byte[] getBytes(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        byteBuffer.rewind();
        return bArr;
    }

    public static boolean isFlipCase(int i2) {
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 8:
                return false;
            case 2:
            case 4:
            case 5:
            case 7:
                return true;
            default:
                Log.e(TAG, "Unknown EXIF orientation: " + i2);
                return false;
        }
    }
}
