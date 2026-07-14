package io.flutter.embedding.engine.image;

import P.d;
import P.h;
import io.flutter.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ExifMetadataReader {
    private static final String TAG = "ExifMetadataReader";

    public static void read(byte[] bArr, Metadata metadata) {
        int i2;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                h hVar = new h(byteArrayInputStream);
                d c2 = hVar.c("Orientation");
                if (c2 != null) {
                    try {
                        i2 = c2.i(hVar.f698g);
                    } catch (NumberFormatException unused) {
                        i2 = 1;
                    }
                    metadata.orientation = i2;
                    byteArrayInputStream.close();
                }
                i2 = 1;
                metadata.orientation = i2;
                byteArrayInputStream.close();
            } finally {
            }
        } catch (IOException e2) {
            Log.e(TAG, "Failed to read EXIF metadata", e2);
        }
    }
}
