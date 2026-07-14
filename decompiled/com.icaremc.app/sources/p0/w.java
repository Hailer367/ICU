package p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewRenderProcessClient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;
import q0.C0593A;
import q0.C0595C;
import q0.C0597b;
import q0.D;
import q0.z;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f5818a = Uri.parse("*");

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f5819b = Uri.parse("");

    /* renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f5820c = new WeakHashMap();

    public static q0.l a(WebView webView, String str, Set set) {
        if (q0.x.f5900E.b()) {
            C0593A f4 = f(webView);
            return new q0.l((ScriptHandlerBoundaryInterface) k3.b.b(ScriptHandlerBoundaryInterface.class, f4.f5853a.addDocumentStartJavaScript(str, (String[]) set.toArray(new String[0]))));
        }
        throw q0.x.a();
    }

    public static void b(WebView webView) {
        Looper webViewLooper;
        if (Build.VERSION.SDK_INT >= 28) {
            webViewLooper = webView.getWebViewLooper();
            if (webViewLooper == Looper.myLooper()) {
                return;
            }
            throw new RuntimeException("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + webViewLooper + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + ")");
        }
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("checkThread", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(webView, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static PackageInfo c() {
        PackageInfo currentWebViewPackage;
        if (Build.VERSION.SDK_INT >= 26) {
            currentWebViewPackage = WebView.getCurrentWebViewPackage();
            return currentWebViewPackage;
        }
        try {
            return e();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static PackageInfo d(Context context) {
        PackageInfo c4 = c();
        if (c4 != null) {
            return c4;
        }
        try {
            String str = (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", null).invoke(null, null);
            if (str != null) {
                return context.getPackageManager().getPackageInfo(str, 0);
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return null;
    }

    public static PackageInfo e() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static C0593A f(WebView webView) {
        if (q0.x.f5905J.b()) {
            WeakHashMap weakHashMap = f5820c;
            C0593A c0593a = (C0593A) weakHashMap.get(webView);
            if (c0593a == null) {
                C0593A c0593a2 = new C0593A(z.f5932a.createWebView(webView));
                weakHashMap.put(webView, c0593a2);
                return c0593a2;
            }
            return c0593a;
        }
        return new C0593A(z.f5932a.createWebView(webView));
    }

    public static void g(WebView webView, n nVar, Uri uri) {
        int i4 = nVar.f5809d;
        if (f5818a.equals(uri)) {
            uri = f5819b;
        }
        C0597b c0597b = q0.x.f5924s;
        if (i4 == 0) {
            webView.postWebMessage(q0.s.b(nVar), uri);
            return;
        }
        if (c0597b.b() && (i4 == 0 || (i4 == 1 && q0.x.f5922q.b()))) {
            b(webView);
            f(webView).f5853a.postMessageToMainFrame(new k3.a(new q0.p(nVar)), uri);
            return;
        }
        throw q0.x.a();
    }

    public static void h(HashSet hashSet, ValueCallback valueCallback) {
        C0597b c0597b = q0.x.f5911e;
        C0597b c0597b2 = q0.x.f5910d;
        if (c0597b.b()) {
            z.f5932a.getStatics().setSafeBrowsingAllowlist(hashSet, valueCallback);
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        if (c0597b2.a()) {
            WebView.setSafeBrowsingWhitelist(arrayList, valueCallback);
        } else {
            if (c0597b2.b()) {
                z.f5932a.getStatics().setSafeBrowsingWhitelist(arrayList, valueCallback);
                return;
            }
            throw q0.x.a();
        }
    }

    public static void i(InAppWebView inAppWebView, InAppWebViewRenderProcessClient inAppWebViewRenderProcessClient) {
        C0597b c0597b = q0.x.f5929x;
        k3.a aVar = null;
        D d4 = null;
        if (c0597b.a()) {
            if (inAppWebViewRenderProcessClient != null) {
                d4 = new D(inAppWebViewRenderProcessClient);
            }
            inAppWebView.setWebViewRenderProcessClient(d4);
        } else {
            if (c0597b.b()) {
                b(inAppWebView);
                C0593A f4 = f(inAppWebView);
                if (inAppWebViewRenderProcessClient != null) {
                    aVar = new k3.a(new C0595C(0, inAppWebViewRenderProcessClient));
                }
                f4.f5853a.setWebViewRendererClient(aVar);
                return;
            }
            throw q0.x.a();
        }
    }
}
