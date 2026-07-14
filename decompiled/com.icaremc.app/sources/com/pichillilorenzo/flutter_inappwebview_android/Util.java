package com.pichillilorenzo.flutter_inappwebview_android;

import R1.c;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.pichillilorenzo.flutter_inappwebview_android.types.Size2D;
import com.pichillilorenzo.flutter_inappwebview_android.types.SyncBaseCallbackResultImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import m2.C0447e;
import org.json.JSONArray;
import org.json.JSONObject;
import r2.k;
import s2.C0644p;

/* loaded from: classes.dex */
public class Util {
    public static final String ANDROID_ASSET_URL = "file:///android_asset/";
    static final String LOG_TAG = "Util";

    /* loaded from: classes.dex */
    public static class PrivateKeyAndCertificates {
        public X509Certificate[] certificates;
        public PrivateKey privateKey;

        public PrivateKeyAndCertificates(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.privateKey = privateKey;
            this.certificates = x509CertificateArr;
        }
    }

    private Util() {
    }

    public static String JSONStringify(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj).toString();
        }
        if (obj instanceof List) {
            return new JSONArray((Collection) obj).toString();
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        return JSONObject.wrap(obj).toString();
    }

    public static Drawable drawableFromBytes(Context context, byte[] bArr) {
        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }

    public static InputStream getFileAsset(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str) {
        return inAppWebViewFlutterPlugin.applicationContext.getResources().getAssets().open(((C0447e) ((c) inAppWebViewFlutterPlugin.flutterAssets).f1532g).b(str));
    }

    public static Size2D getFullscreenSize(Context context) {
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        int navigationBars;
        int displayCutout;
        Insets insetsIgnoringVisibility;
        int i4;
        int i5;
        int i6;
        int i7;
        Rect bounds;
        Size2D size2D = new Size2D(-1.0d, -1.0d);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                windowInsets = currentWindowMetrics.getWindowInsets();
                navigationBars = WindowInsets.Type.navigationBars();
                displayCutout = WindowInsets.Type.displayCutout();
                insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(navigationBars | displayCutout);
                i4 = insetsIgnoringVisibility.right;
                i5 = insetsIgnoringVisibility.left;
                int i8 = i5 + i4;
                i6 = insetsIgnoringVisibility.top;
                i7 = insetsIgnoringVisibility.bottom;
                bounds = currentWindowMetrics.getBounds();
                size2D.setWidth(bounds.width() - i8);
                size2D.setHeight(bounds.height() - (i7 + i6));
                return size2D;
            }
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            size2D.setWidth(r1.widthPixels);
            size2D.setHeight(r1.heightPixels);
        }
        return size2D;
    }

    public static <T> T getOrDefault(Map<String, Object> map, String str, T t3) {
        if (map.containsKey(str)) {
            return (T) map.get(str);
        }
        return t3;
    }

    public static float getPixelDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static String getUrlAsset(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str) {
        String b4 = ((C0447e) ((c) inAppWebViewFlutterPlugin.flutterAssets).f1532g).b(str);
        try {
            InputStream fileAsset = getFileAsset(inAppWebViewFlutterPlugin, str);
            if (fileAsset != null) {
                fileAsset.close();
            }
            e = null;
        } catch (IOException e4) {
            e = e4;
        }
        if (e == null) {
            return k.d(ANDROID_ASSET_URL, b4);
        }
        throw e;
    }

    public static X509Certificate getX509CertFromSslCertHack(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray == null) {
            return null;
        }
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
        } catch (CertificateException unused) {
            return null;
        }
    }

    public static <T> T invokeMethodAndWaitResult(final C0644p c0644p, final String str, final Object obj, final SyncBaseCallbackResultImpl<T> syncBaseCallbackResultImpl) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.Util.1
            @Override // java.lang.Runnable
            public void run() {
                C0644p.this.a(str, obj, syncBaseCallbackResultImpl);
            }
        });
        syncBaseCallbackResultImpl.latch.await();
        return syncBaseCallbackResultImpl.result;
    }

    public static <O> Object invokeMethodIfExists(O o3, String str, Object... objArr) {
        for (Method method : o3.getClass().getMethods()) {
            if (method.getName().equals(str)) {
                try {
                    return method.invoke(o3, objArr);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static boolean isClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isIPv6(String str) {
        try {
            InetAddress.getByName(str);
            return true;
        } catch (UnknownHostException unused) {
            return false;
        }
    }

    public static PrivateKeyAndCertificates loadPrivateKeyAndCertificate(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str, String str2, String str3) {
        InputStream inputStream;
        String str4;
        PrivateKeyAndCertificates privateKeyAndCertificates = null;
        try {
            inputStream = getFileAsset(inAppWebViewFlutterPlugin, str);
        } catch (IOException unused) {
            inputStream = null;
        }
        try {
            try {
                if (inputStream == null) {
                    try {
                        inputStream = new FileInputStream(str);
                    } catch (Exception e4) {
                        Log.e(LOG_TAG, "", e4);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                }
                KeyStore keyStore = KeyStore.getInstance(str3);
                if (str2 == null) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                keyStore.load(inputStream, str4.toCharArray());
                String nextElement = keyStore.aliases().nextElement();
                if (str2 == null) {
                    str2 = "";
                }
                Key key = keyStore.getKey(nextElement, str2.toCharArray());
                if (key instanceof PrivateKey) {
                    privateKeyAndCertificates = new PrivateKeyAndCertificates((PrivateKey) key, new X509Certificate[]{(X509Certificate) keyStore.getCertificate(nextElement)});
                }
                inputStream.close();
                inputStream.close();
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        Log.e(LOG_TAG, "", e5);
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            Log.e(LOG_TAG, "", e6);
        }
        return privateKeyAndCertificates;
    }

    public static void log(String str, String str2) {
        int min;
        int length = str2.length();
        int i4 = 0;
        while (i4 < length) {
            int indexOf = str2.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.d(str, str2.substring(i4, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i4 = min;
                }
            }
            i4 = min + 1;
        }
    }

    public static HttpURLConnection makeHttpRequest(String str, String str2, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e4) {
            e = e4;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setRequestMethod(str2);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(true);
            if ("GET".equalsIgnoreCase(str2)) {
                httpURLConnection.setDoOutput(false);
            }
            httpURLConnection.connect();
            return httpURLConnection;
        } catch (Exception e5) {
            e = e5;
            if (!(e instanceof SSLHandshakeException)) {
                Log.e(LOG_TAG, "", e);
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        }
    }

    public static String normalizeIPv6(String str) {
        if (isIPv6(str)) {
            return InetAddress.getByName(str).getCanonicalHostName();
        }
        throw new Exception(k.d("Invalid address: ", str));
    }

    public static boolean objEquals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static byte[] readAllBytes(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream == null) {
            return null;
        }
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read(bArr2, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            } catch (IOException e4) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e4.addSuppressed(e5);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e6) {
                    e4.addSuppressed(e6);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException unused2) {
                    throw th;
                }
            }
        }
        bArr = byteArrayOutputStream.toByteArray();
        try {
            inputStream.close();
        } catch (IOException unused3) {
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused4) {
            return bArr;
        }
    }

    public static String replaceAll(String str, String str2, String str3) {
        return TextUtils.join(str3, str.split(Pattern.quote(str2)));
    }
}
