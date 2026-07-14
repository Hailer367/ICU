package io.flutter.embedding.engine.image;

/* loaded from: classes.dex */
public class FlutterImageDecoder {

    /* loaded from: classes.dex */
    public interface HeaderListener {
        void onImageHeader(int i2, int i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap decodeImage(java.nio.ByteBuffer r3, io.flutter.embedding.engine.image.FlutterImageDecoder.HeaderListener r4) {
        /*
            io.flutter.embedding.engine.image.Metadata r0 = io.flutter.embedding.engine.image.Metadata.create(r3, r4)
            boolean r1 = r0.isHeif()
            if (r1 == 0) goto L1e
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 36
            if (r1 != r2) goto L16
            io.flutter.embedding.engine.image.ImageDecoderHeifApi36Impl r1 = new io.flutter.embedding.engine.image.ImageDecoderHeifApi36Impl
            r1.<init>()
            goto L1f
        L16:
            if (r1 >= r2) goto L1e
            io.flutter.embedding.engine.image.ImageDecoderHeifPre36Impl r1 = new io.flutter.embedding.engine.image.ImageDecoderHeifPre36Impl
            r1.<init>()
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L26
            io.flutter.embedding.engine.image.ImageDecoderDefaultImpl r1 = new io.flutter.embedding.engine.image.ImageDecoderDefaultImpl
            r1.<init>(r4)
        L26:
            android.graphics.Bitmap r3 = r1.decodeImage(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.image.FlutterImageDecoder.decodeImage(java.nio.ByteBuffer, io.flutter.embedding.engine.image.FlutterImageDecoder$HeaderListener):android.graphics.Bitmap");
    }
}
