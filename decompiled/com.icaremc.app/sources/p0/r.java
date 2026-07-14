package p0;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import q0.C0595C;

/* loaded from: classes.dex */
public final class r implements s {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f5810h = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5811f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f5812g;

    public r(Context context, int i4) {
        this.f5811f = i4;
        switch (i4) {
            case 1:
                this.f5812g = new C0595C(1, context);
                return;
            default:
                this.f5812g = new C0595C(1, context);
                return;
        }
    }

    public boolean a(Context context) {
        String b4 = C0595C.b((File) this.f5812g);
        String b5 = C0595C.b(context.getCacheDir());
        String b6 = C0595C.b(context.getDataDir());
        if ((!b4.startsWith(b5) && !b4.startsWith(b6)) || b4.equals(b5) || b4.equals(b6)) {
            return false;
        }
        for (int i4 = 0; i4 < 5; i4++) {
            if (b4.startsWith(b6 + f5810h[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // p0.s
    public final WebResourceResponse handle(String str) {
        String str2;
        File file;
        switch (this.f5811f) {
            case 0:
                try {
                    C0595C c0595c = (C0595C) this.f5812g;
                    if (str.length() > 1 && str.charAt(0) == '/') {
                        str2 = str.substring(1);
                    } else {
                        str2 = str;
                    }
                    InputStream open = ((Context) c0595c.f5856b).getAssets().open(str2, 2);
                    if (str2.endsWith(".svgz")) {
                        open = new GZIPInputStream(open);
                    }
                    return new WebResourceResponse(C0595C.g(str), null, open);
                } catch (IOException e4) {
                    Log.e("WebViewAssetLoader", "Error opening asset path: " + str, e4);
                    return new WebResourceResponse(null, null, null);
                }
            case 1:
                try {
                    return new WebResourceResponse(C0595C.g(str), null, ((C0595C) this.f5812g).i(str));
                } catch (Resources.NotFoundException e5) {
                    Log.e("WebViewAssetLoader", "Resource not found from the path: " + str, e5);
                    return new WebResourceResponse(null, null, null);
                } catch (IOException e6) {
                    Log.e("WebViewAssetLoader", "Error opening resource from the path: " + str, e6);
                    return new WebResourceResponse(null, null, null);
                }
            default:
                File file2 = (File) this.f5812g;
                try {
                    String b4 = C0595C.b(file2);
                    String canonicalPath = new File(file2, str).getCanonicalPath();
                    if (canonicalPath.startsWith(b4)) {
                        file = new File(canonicalPath);
                    } else {
                        file = null;
                    }
                } catch (IOException e7) {
                    Log.e("WebViewAssetLoader", "Error opening the requested path: " + str, e7);
                }
                if (file != null) {
                    InputStream fileInputStream = new FileInputStream(file);
                    if (file.getPath().endsWith(".svgz")) {
                        fileInputStream = new GZIPInputStream(fileInputStream);
                    }
                    return new WebResourceResponse(C0595C.g(str), null, fileInputStream);
                }
                Log.e("WebViewAssetLoader", String.format("The requested file: %s is outside the mounted directory: %s", str, file2));
                return new WebResourceResponse(null, null, null);
        }
    }

    public r(Context context, File file) {
        this.f5811f = 2;
        try {
            this.f5812g = new File(C0595C.b(file));
            if (a(context)) {
                return;
            }
            throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
        } catch (IOException e4) {
            throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e4);
        }
    }
}
