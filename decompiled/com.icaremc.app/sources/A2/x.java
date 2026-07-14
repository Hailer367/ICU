package A2;

import D2.Y;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import f1.AbstractC0286a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class x implements T.j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f117a;

    @Override // T.j
    public void a(AbstractC0286a abstractC0286a) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new T.a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new Y(this, abstractC0286a, threadPoolExecutor, 4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0031, code lost:
    
        if (r11 < 100) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8 A[Catch: IOException -> 0x0123, TRY_LEAVE, TryCatch #1 {IOException -> 0x0123, blocks: (B:10:0x0036, B:16:0x0050, B:18:0x0061, B:20:0x0076, B:24:0x0083, B:31:0x00b2, B:36:0x00df, B:40:0x00e8, B:43:0x011e, B:48:0x010b, B:49:0x00cc, B:50:0x00d2, B:52:0x00d6, B:54:0x00da, B:58:0x0099, B:60:0x00a1, B:61:0x00ac, B:42:0x00fc), top: B:9:0x0036, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6 A[Catch: IOException -> 0x0123, TryCatch #1 {IOException -> 0x0123, blocks: (B:10:0x0036, B:16:0x0050, B:18:0x0061, B:20:0x0076, B:24:0x0083, B:31:0x00b2, B:36:0x00df, B:40:0x00e8, B:43:0x011e, B:48:0x010b, B:49:0x00cc, B:50:0x00d2, B:52:0x00d6, B:54:0x00da, B:58:0x0099, B:60:0x00a1, B:61:0x00ac, B:42:0x00fc), top: B:9:0x0036, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b(java.lang.String r24, java.lang.Double r25, java.lang.Double r26, int r27) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.x.b(java.lang.String, java.lang.Double, java.lang.Double, int):java.lang.String");
    }

    public File c(Bitmap bitmap, Double d4, Double d5, int i4, String str) {
        Bitmap.CompressFormat compressFormat;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, d4.intValue(), d5.intValue(), false);
        String d6 = r2.k.d("/scaled_", str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean hasAlpha = createScaledBitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        if (hasAlpha) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        createScaledBitmap.compress(compressFormat, i4, byteArrayOutputStream);
        File file = new File(this.f117a.getCacheDir(), d6);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.close();
        return file;
    }

    public x(Activity activity, W0.g gVar) {
        this.f117a = activity;
    }

    public x(Context context) {
        this.f117a = context.getApplicationContext();
    }
}
