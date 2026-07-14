package D2;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import s2.C0649u;
import s2.InterfaceC0634f;

/* renamed from: D2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0028g extends A2.A {

    /* renamed from: e, reason: collision with root package name */
    public final L f389e;

    public C0028g(L l3) {
        super(2);
        this.f389e = l3;
    }

    public static final void l(String str, Object obj, Throwable th) {
        Log.w("PigeonProxyApiBaseCodec", "Failed to create new Dart proxy instance of " + str + ": " + obj + ". " + th);
    }

    @Override // A2.A, s2.C0650v
    public final Object f(byte b4, ByteBuffer byteBuffer) {
        T2.h.e(byteBuffer, "buffer");
        if (b4 == Byte.MIN_VALUE) {
            Object e4 = e(byteBuffer);
            T2.h.c(e4, "null cannot be cast to non-null type kotlin.Long");
            long longValue = ((Long) e4).longValue();
            Object e5 = ((C0024c) this.f389e.f297g).e(longValue);
            if (e5 == null) {
                Log.e("PigeonProxyApiBaseCodec", "Failed to find instance with identifier: " + longValue);
            }
            return e5;
        }
        return super.f(b4, byteBuffer);
    }

    @Override // A2.A, s2.C0650v
    public final void k(C0649u c0649u, Object obj) {
        r rVar;
        EnumC0031j enumC0031j;
        Map<String, String> requestHeaders;
        L l3 = this.f389e;
        InterfaceC0634f interfaceC0634f = (InterfaceC0634f) l3.f296f;
        C0024c c0024c = (C0024c) l3.f297g;
        if (!(obj instanceof Boolean) && !(obj instanceof byte[]) && !(obj instanceof Double) && !(obj instanceof double[]) && !(obj instanceof float[]) && !(obj instanceof Integer) && !(obj instanceof int[]) && !(obj instanceof List) && !(obj instanceof Long) && !(obj instanceof long[]) && !(obj instanceof Map) && !(obj instanceof String) && !(obj instanceof r) && !(obj instanceof EnumC0031j) && !(obj instanceof EnumC0044x) && !(obj instanceof O) && !(obj instanceof EnumC0043w) && !(obj instanceof i0) && obj != null) {
            if (obj instanceof WebResourceRequest) {
                WebResourceRequest webResourceRequest = (WebResourceRequest) obj;
                C0027f c0027f = new C0027f(0, obj);
                if (!c0024c.d(webResourceRequest)) {
                    long b4 = c0024c.b(webResourceRequest);
                    String uri = webResourceRequest.getUrl().toString();
                    boolean isForMainFrame = webResourceRequest.isForMainFrame();
                    boolean isRedirect = webResourceRequest.isRedirect();
                    boolean hasGesture = webResourceRequest.hasGesture();
                    String method = webResourceRequest.getMethod();
                    if (webResourceRequest.getRequestHeaders() == null) {
                        requestHeaders = Collections.EMPTY_MAP;
                    } else {
                        requestHeaders = webResourceRequest.getRequestHeaders();
                    }
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(b4), uri, Boolean.valueOf(isForMainFrame), Boolean.valueOf(isRedirect), Boolean.valueOf(hasGesture), method, requestHeaders), new C2.c(24, c0027f));
                }
            } else if (obj instanceof WebResourceResponse) {
                WebResourceResponse webResourceResponse = (WebResourceResponse) obj;
                C0027f c0027f2 = new C0027f(26, obj);
                if (!c0024c.d(webResourceResponse)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebResourceResponse.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(c0024c.b(webResourceResponse)), Long.valueOf(webResourceResponse.getStatusCode())), new C2.c(25, c0027f2));
                }
            } else if (obj instanceof WebResourceError) {
                WebResourceError webResourceError = (WebResourceError) obj;
                C0027f c0027f3 = new C0027f(12, obj);
                if (!c0024c.d(webResourceError)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebResourceError.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(c0024c.b(webResourceError)), Long.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription().toString()), new C2.c(22, c0027f3));
                }
            } else if (obj instanceof p0.p) {
                p0.p pVar = (p0.p) obj;
                C0027f c0027f4 = new C0027f(13, obj);
                if (!c0024c.d(pVar)) {
                    long b5 = c0024c.b(pVar);
                    q0.t tVar = (q0.t) pVar;
                    if (tVar.f5892a == null) {
                        tVar.f5892a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) q0.y.f5931a.f5856b).convertWebResourceError(Proxy.getInvocationHandler(tVar.f5893b));
                    }
                    long errorCode = tVar.f5892a.getErrorCode();
                    if (tVar.f5892a == null) {
                        tVar.f5892a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) q0.y.f5931a.f5856b).convertWebResourceError(Proxy.getInvocationHandler(tVar.f5893b));
                    }
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebResourceErrorCompat.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(b5), Long.valueOf(errorCode), tVar.f5892a.getDescription().toString()), new C2.c(23, c0027f4));
                }
            } else if (obj instanceof f0) {
                f0 f0Var = (f0) obj;
                C0027f c0027f5 = new C0027f(14, obj);
                if (!c0024c.d(f0Var)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebViewPoint.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(c0024c.b(f0Var)), Long.valueOf(f0Var.f387a), Long.valueOf(f0Var.f388b)), new J(2, c0027f5));
                }
            } else if (obj instanceof ConsoleMessage) {
                ConsoleMessage consoleMessage = (ConsoleMessage) obj;
                C0027f c0027f6 = new C0027f(15, obj);
                if (!c0024c.d(consoleMessage)) {
                    long b6 = c0024c.b(consoleMessage);
                    long lineNumber = consoleMessage.lineNumber();
                    String message = consoleMessage.message();
                    int i4 = AbstractC0032k.f413a[consoleMessage.messageLevel().ordinal()];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 != 4) {
                                    if (i4 != 5) {
                                        enumC0031j = EnumC0031j.UNKNOWN;
                                    } else {
                                        enumC0031j = EnumC0031j.DEBUG;
                                    }
                                } else {
                                    enumC0031j = EnumC0031j.ERROR;
                                }
                            } else {
                                enumC0031j = EnumC0031j.WARNING;
                            }
                        } else {
                            enumC0031j = EnumC0031j.LOG;
                        }
                    } else {
                        enumC0031j = EnumC0031j.TIP;
                    }
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.ConsoleMessage.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(b6), Long.valueOf(lineNumber), message, enumC0031j, consoleMessage.sourceId()), new C2.c(5, c0027f6));
                }
            } else if (obj instanceof CookieManager) {
                CookieManager cookieManager = (CookieManager) obj;
                C0027f c0027f7 = new C0027f(16, obj);
                if (!c0024c.d(cookieManager)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.CookieManager.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(cookieManager))), new C2.c(6, c0027f7));
                }
            } else if (obj instanceof WebView) {
                WebView webView = (WebView) obj;
                C0027f c0027f8 = new C0027f(17, obj);
                if (!c0024c.d(webView)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(webView))), new C2.c(29, c0027f8));
                }
            } else if (obj instanceof WebSettings) {
                WebSettings webSettings = (WebSettings) obj;
                C0027f c0027f9 = new C0027f(18, obj);
                if (!c0024c.d(webSettings)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(webSettings))), new C2.c(26, c0027f9));
                }
            } else if (obj instanceof C0042v) {
                if (!c0024c.d((C0042v) obj)) {
                    l("JavaScriptChannel", obj, H2.f.a(k3.b.f(new C0022a("new-instance-error", "Attempting to create a new Dart instance of JavaScriptChannel, but the class has a nonnull callback method.", ""))));
                }
            } else if (obj instanceof WebViewClient) {
                WebViewClient webViewClient = (WebViewClient) obj;
                C0027f c0027f10 = new C0027f(11, obj);
                if (!c0024c.d(webViewClient)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(webViewClient))), new J(0, c0027f10));
                }
            } else if (obj instanceof DownloadListener) {
                if (!c0024c.d((DownloadListener) obj)) {
                    l("DownloadListener", obj, H2.f.a(k3.b.f(new C0022a("new-instance-error", "Attempting to create a new Dart instance of DownloadListener, but the class has a nonnull callback method.", ""))));
                }
            } else if (obj instanceof W) {
                if (!c0024c.d((W) obj)) {
                    l("WebChromeClient", obj, H2.f.a(k3.b.f(new C0022a("new-instance-error", "Attempting to create a new Dart instance of WebChromeClient, but the class has a nonnull callback method.", ""))));
                }
            } else if (obj instanceof C0039s) {
                C0039s c0039s = (C0039s) obj;
                C0027f c0027f11 = new C0027f(19, obj);
                if (!c0024c.d(c0039s)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(c0039s))), new C2.c(10, c0027f11));
                }
            } else if (obj instanceof WebStorage) {
                WebStorage webStorage = (WebStorage) obj;
                C0027f c0027f12 = new C0027f(20, obj);
                if (!c0024c.d(webStorage)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebStorage.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(webStorage))), new C2.c(27, c0027f12));
                }
            } else if (obj instanceof WebChromeClient.FileChooserParams) {
                WebChromeClient.FileChooserParams fileChooserParams = (WebChromeClient.FileChooserParams) obj;
                C0027f c0027f13 = new C0027f(21, obj);
                if (!c0024c.d(fileChooserParams)) {
                    long b7 = c0024c.b(fileChooserParams);
                    boolean isCaptureEnabled = fileChooserParams.isCaptureEnabled();
                    List asList = Arrays.asList(fileChooserParams.getAcceptTypes());
                    int mode = fileChooserParams.getMode();
                    if (mode != 0) {
                        if (mode != 1) {
                            if (mode != 3) {
                                rVar = r.UNKNOWN;
                            } else {
                                rVar = r.SAVE;
                            }
                        } else {
                            rVar = r.OPEN_MULTIPLE;
                        }
                    } else {
                        rVar = r.OPEN;
                    }
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.FileChooserParams.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(b7), Boolean.valueOf(isCaptureEnabled), asList, rVar, fileChooserParams.getFilenameHint()), new C2.c(9, c0027f13));
                }
            } else if (obj instanceof PermissionRequest) {
                PermissionRequest permissionRequest = (PermissionRequest) obj;
                C0027f c0027f14 = new C0027f(22, obj);
                if (!c0024c.d(permissionRequest)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(c0024c.b(permissionRequest)), Arrays.asList(permissionRequest.getResources())), new C2.c(14, c0027f14));
                }
            } else if (obj instanceof WebChromeClient.CustomViewCallback) {
                WebChromeClient.CustomViewCallback customViewCallback = (WebChromeClient.CustomViewCallback) obj;
                C0027f c0027f15 = new C0027f(23, obj);
                if (!c0024c.d(customViewCallback)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(customViewCallback))), new C2.c(7, c0027f15));
                }
            } else if (obj instanceof View) {
                View view = (View) obj;
                C0027f c0027f16 = new C0027f(24, obj);
                if (!c0024c.d(view)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.View.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(view))), new C2.c(21, c0027f16));
                }
            } else if (obj instanceof GeolocationPermissions.Callback) {
                GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback) obj;
                C0027f c0027f17 = new C0027f(25, obj);
                if (!c0024c.d(callback)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(callback))), new C2.c(11, c0027f17));
                }
            } else if (obj instanceof HttpAuthHandler) {
                HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj;
                C0027f c0027f18 = new C0027f(1, obj);
                if (!c0024c.d(httpAuthHandler)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(httpAuthHandler))), new C2.c(12, c0027f18));
                }
            } else if (obj instanceof Message) {
                Message message2 = (Message) obj;
                C0027f c0027f19 = new C0027f(2, obj);
                if (!c0024c.d(message2)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(message2))), new C2.c(2, c0027f19));
                }
            } else if (obj instanceof ClientCertRequest) {
                ClientCertRequest clientCertRequest = (ClientCertRequest) obj;
                C0027f c0027f20 = new C0027f(3, obj);
                if (!c0024c.d(clientCertRequest)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(clientCertRequest))), new C2.c(4, c0027f20));
                }
            } else if (obj instanceof PrivateKey) {
                PrivateKey privateKey = (PrivateKey) obj;
                C0027f c0027f21 = new C0027f(4, obj);
                if (!c0024c.d(privateKey)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.PrivateKey.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(privateKey))), new C2.c(15, c0027f21));
                }
            } else if (obj instanceof X509Certificate) {
                X509Certificate x509Certificate = (X509Certificate) obj;
                C0027f c0027f22 = new C0027f(5, obj);
                if (!c0024c.d(x509Certificate)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.X509Certificate.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(x509Certificate))), new J(3, c0027f22));
                }
            } else if (obj instanceof SslErrorHandler) {
                SslErrorHandler sslErrorHandler = (SslErrorHandler) obj;
                C0027f c0027f23 = new C0027f(6, obj);
                if (!c0024c.d(sslErrorHandler)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(sslErrorHandler))), new C2.c(20, c0027f23));
                }
            } else if (obj instanceof SslError) {
                SslError sslError = (SslError) obj;
                C0027f c0027f24 = new C0027f(7, obj);
                if (!c0024c.d(sslError)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslError.pigeon_newInstance", l3.b(), null).v(I2.f.C(Long.valueOf(c0024c.b(sslError)), sslError.getCertificate(), sslError.getUrl()), new C2.c(18, c0027f24));
                }
            } else if (obj instanceof SslCertificate.DName) {
                SslCertificate.DName dName = (SslCertificate.DName) obj;
                C0027f c0027f25 = new C0027f(8, obj);
                if (!c0024c.d(dName)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(dName))), new C2.c(17, c0027f25));
                }
            } else if (obj instanceof SslCertificate) {
                SslCertificate sslCertificate = (SslCertificate) obj;
                C0027f c0027f26 = new C0027f(9, obj);
                if (!c0024c.d(sslCertificate)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(sslCertificate))), new C2.c(16, c0027f26));
                }
            } else if (obj instanceof Certificate) {
                Certificate certificate = (Certificate) obj;
                C0027f c0027f27 = new C0027f(10, obj);
                if (!c0024c.d(certificate)) {
                    new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.Certificate.pigeon_newInstance", l3.b(), null).v(android.support.v4.media.session.a.p(Long.valueOf(c0024c.b(certificate))), new C2.c(3, c0027f27));
                }
            }
            if (c0024c.d(obj)) {
                c0649u.write(128);
                c0024c.f();
                Long l4 = (Long) c0024c.f363b.get(new C0023b(obj));
                if (l4 != null) {
                    c0024c.f365d.put(l4, obj);
                }
                k(c0649u, l4);
                return;
            }
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass().getName() + "'");
        }
        super.k(c0649u, obj);
    }
}
