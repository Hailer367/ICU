package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import io.flutter.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FileUtils {
    private static void copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private static String getBaseName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    private static String getImageExtension(Context context, Uri uri) {
        String fileExtensionFromUrl;
        try {
            if (uri.getScheme().equals("content")) {
                fileExtensionFromUrl = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
            } else {
                fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            }
            if (fileExtensionFromUrl != null && !fileExtensionFromUrl.isEmpty()) {
                return "." + sanitizeFilename(fileExtensionFromUrl);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String getImageName(Context context, Uri uri) {
        Cursor queryImageName = queryImageName(context, uri);
        if (queryImageName != null) {
            try {
                if (queryImageName.moveToFirst() && queryImageName.getColumnCount() >= 1) {
                    String sanitizeFilename = sanitizeFilename(queryImageName.getString(0));
                    queryImageName.close();
                    return sanitizeFilename;
                }
            } catch (Throwable th) {
                try {
                    queryImageName.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (queryImageName != null) {
            queryImageName.close();
        }
        return null;
    }

    private static Cursor queryImageName(Context context, Uri uri) {
        return context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
    }

    public static File saferOpenFile(String str, String str2) {
        File file = new File(str);
        if (file.getCanonicalPath().startsWith(str2)) {
            return file;
        }
        throw new IllegalArgumentException("Trying to open path outside of the expected directory. File: " + file.getCanonicalPath() + " was expected to be within directory: " + str2 + ".");
    }

    public static String sanitizeFilename(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = {"..", "/"};
        String str2 = str.split("/")[r4.length - 1];
        for (int i2 = 0; i2 < 2; i2++) {
            str2 = str2.replace(strArr[i2], "_");
        }
        return str2;
    }

    public String getPathFromUri(Context context, Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                File file = new File(context.getCacheDir(), UUID.randomUUID().toString());
                file.mkdir();
                file.deleteOnExit();
                String imageName = getImageName(context, uri);
                String imageExtension = getImageExtension(context, uri);
                if (imageName == null) {
                    Log.w("FileUtils", "Cannot get file name for " + uri);
                    if (imageExtension == null) {
                        imageExtension = ".jpg";
                    }
                    imageName = "image_picker".concat(imageExtension);
                } else if (imageExtension != null) {
                    imageName = getBaseName(imageName) + imageExtension;
                }
                File saferOpenFile = saferOpenFile(new File(file, imageName).getPath(), file.getCanonicalPath());
                FileOutputStream fileOutputStream = new FileOutputStream(saferOpenFile);
                try {
                    copy(openInputStream, fileOutputStream);
                    String path = saferOpenFile.getPath();
                    fileOutputStream.close();
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                    return path;
                } finally {
                }
            } catch (Throwable th) {
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException | IllegalArgumentException | SecurityException unused) {
            return null;
        }
    }
}
