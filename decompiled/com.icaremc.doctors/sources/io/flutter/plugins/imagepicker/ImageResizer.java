package io.flutter.plugins.imagepicker;

import P.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ImageResizer {
    private final Context context;
    private final ExifDataCopier exifDataCopier;

    public ImageResizer(Context context, ExifDataCopier exifDataCopier) {
        this.context = context;
        this.exifDataCopier = exifDataCopier;
    }

    private int calculateSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 <= i3 && i5 <= i2) {
            return 1;
        }
        int i7 = i4 / 2;
        int i8 = i5 / 2;
        while (i7 / i6 >= i3 && i8 / i6 >= i2) {
            i6 *= 2;
        }
        return i6;
    }

    private D.c calculateTargetSize(double d2, double d3, Double d4, Double d5) {
        boolean z;
        boolean z2;
        double d6;
        double d7;
        boolean z3;
        double d8 = d2 / d3;
        boolean z4 = false;
        if (d4 != null) {
            z = true;
        } else {
            z = false;
        }
        if (d5 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            d6 = Math.min(d2, Math.round(d4.doubleValue()));
        } else {
            d6 = d2;
        }
        if (z2) {
            d7 = Math.min(d3, Math.round(d5.doubleValue()));
        } else {
            d7 = d3;
        }
        if (z && d4.doubleValue() < d2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && d5.doubleValue() < d3) {
            z4 = true;
        }
        if (z3 || z4) {
            double d9 = d7 * d8;
            double d10 = d6 / d8;
            if (d10 > d7) {
                d6 = Math.round(d9);
            } else {
                d7 = Math.round(d10);
            }
        }
        return new D.c((float) d6, (float) d7);
    }

    private void copyExif(String str, String str2) {
        try {
            this.exifDataCopier.copyExif(new h(str), new h(str2));
        } catch (Exception e2) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + e2);
        }
    }

    private File createFile(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i2) {
        Bitmap.CompressFormat compressFormat;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean hasAlpha = bitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        if (hasAlpha) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        bitmap.compress(compressFormat, i2, byteArrayOutputStream);
        File createFile = createFile(this.context.getCacheDir(), str);
        FileOutputStream createOutputStream = createOutputStream(createFile);
        createOutputStream.write(byteArrayOutputStream.toByteArray());
        createOutputStream.close();
        return createFile;
    }

    private FileOutputStream createOutputStream(File file) {
        return new FileOutputStream(file);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i2, int i3, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i2, i3, z);
    }

    private Bitmap decodeFile(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    private File resizedImage(Bitmap bitmap, Double d2, Double d3, int i2, String str) {
        return createImageOnExternalDirectory(O.a.m("/scaled_", str), createScaledBitmap(bitmap, d2.intValue(), d3.intValue(), false), i2);
    }

    public D.c readFileDimensions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFile(str, options);
        return new D.c(options.outWidth, options.outHeight);
    }

    public String resizeImageIfNeeded(String str, Double d2, Double d3, int i2) {
        D.c readFileDimensions = readFileDimensions(str);
        float f2 = readFileDimensions.f168a;
        float f3 = readFileDimensions.f169b;
        if (f2 != -1.0f && f3 != -1.0f) {
            if (d2 == null && d3 == null && i2 >= 100) {
                return str;
            }
            try {
                String str2 = str.split("/")[r2.length - 1];
                D.c calculateTargetSize = calculateTargetSize(readFileDimensions.f168a, f3, d2, d3);
                BitmapFactory.Options options = new BitmapFactory.Options();
                float f4 = calculateTargetSize.f168a;
                float f5 = calculateTargetSize.f169b;
                options.inSampleSize = calculateSampleSize(options, (int) f4, (int) f5);
                Bitmap decodeFile = decodeFile(str, options);
                if (decodeFile == null) {
                    return str;
                }
                File resizedImage = resizedImage(decodeFile, Double.valueOf(calculateTargetSize.f168a), Double.valueOf(f5), i2, str2);
                copyExif(str, resizedImage.getPath());
                return resizedImage.getPath();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return str;
    }
}
