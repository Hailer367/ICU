package q0;

import android.content.Context;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.WeakHashMap;
import java.util.zip.GZIPInputStream;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import p0.AbstractC0565d;

/* renamed from: q0.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0595C implements WebViewRendererClientBoundaryInterface, WebMessageCallbackBoundaryInterface, WebMessageListenerBoundaryInterface, InterfaceC0594B {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f5854c = {"WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5855a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5856b;

    public /* synthetic */ C0595C() {
        this.f5855a = 2;
    }

    public static String b(File file) {
        String canonicalPath = file.getCanonicalPath();
        if (!canonicalPath.endsWith("/")) {
            return canonicalPath.concat("/");
        }
        return canonicalPath;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005d, code lost:
    
        if (r5.equals("mhtml") == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.C0595C.g(java.lang.String):java.lang.String");
    }

    @Override // q0.InterfaceC0594B
    public String[] a() {
        return ((WebViewProviderFactoryBoundaryInterface) this.f5856b).getSupportedFeatures();
    }

    public boolean c() {
        return ((WebSettingsBoundaryInterface) this.f5856b).getEnterpriseAuthenticationAppLinkPolicyEnabled();
    }

    @Override // q0.InterfaceC0594B
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) k3.b.b(WebViewProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f5856b).createWebView(webView));
    }

    public int d() {
        return ((WebSettingsBoundaryInterface) this.f5856b).getForceDark();
    }

    public ServiceWorkerWebSettings e() {
        if (((ServiceWorkerWebSettings) this.f5856b) == null) {
            C0595C c0595c = y.f5931a;
            this.f5856b = (ServiceWorkerWebSettings) ((WebkitToCompatConverterBoundaryInterface) c0595c.f5856b).convertServiceWorkerSettings(Proxy.getInvocationHandler(null));
        }
        return (ServiceWorkerWebSettings) this.f5856b;
    }

    public boolean f() {
        return ((WebSettingsBoundaryInterface) this.f5856b).getSafeBrowsingEnabled();
    }

    @Override // q0.InterfaceC0594B
    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) k3.b.b(ProxyControllerBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f5856b).getProxyController());
    }

    @Override // q0.InterfaceC0594B
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) k3.b.b(StaticsBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f5856b).getStatics());
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        switch (this.f5855a) {
            case 0:
                return f5854c;
            case 3:
                return new String[]{"WEB_MESSAGE_CALLBACK_ON_MESSAGE"};
            default:
                return new String[]{"WEB_MESSAGE_LISTENER", "WEB_MESSAGE_ARRAY_BUFFER"};
        }
    }

    @Override // q0.InterfaceC0594B
    public TracingControllerBoundaryInterface getTracingController() {
        return (TracingControllerBoundaryInterface) k3.b.b(TracingControllerBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f5856b).getTracingController());
    }

    @Override // q0.InterfaceC0594B
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) k3.b.b(WebkitToCompatConverterBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f5856b).getWebkitToCompatConverter());
    }

    public boolean h() {
        return ((WebSettingsBoundaryInterface) this.f5856b).isAlgorithmicDarkeningAllowed();
    }

    public InputStream i(String str) {
        Context context = (Context) this.f5856b;
        if (str.length() > 1 && str.charAt(0) == '/') {
            str = str.substring(1);
        }
        String[] split = str.split("/", -1);
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            int lastIndexOf = str3.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str3 = str3.substring(0, lastIndexOf);
            }
            int identifier = context.getResources().getIdentifier(str3, str2, context.getPackageName());
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(identifier, typedValue, true);
            int i4 = typedValue.type;
            if (i4 == 3) {
                InputStream openRawResource = context.getResources().openRawResource(identifier);
                if (str.endsWith(".svgz")) {
                    return new GZIPInputStream(openRawResource);
                }
                return openRawResource;
            }
            throw new IOException(String.format("Expected %s resource to be of TYPE_STRING but was %d", str, Integer.valueOf(i4)));
        }
        throw new IllegalArgumentException("Incorrect resource path: ".concat(str));
    }

    public void j(boolean z) {
        ((WebSettingsBoundaryInterface) this.f5856b).setAlgorithmicDarkeningAllowed(z);
    }

    public void k(boolean z) {
        ((WebSettingsBoundaryInterface) this.f5856b).setEnterpriseAuthenticationAppLinkPolicyEnabled(z);
    }

    public void l(int i4) {
        ((WebSettingsBoundaryInterface) this.f5856b).setForceDark(i4);
    }

    public void m(int i4) {
        ((WebSettingsBoundaryInterface) this.f5856b).setForceDarkBehavior(i4);
    }

    public void n(boolean z) {
        ((WebSettingsBoundaryInterface) this.f5856b).setPaymentRequestEnabled(z);
    }

    public void o(boolean z) {
        ((WebSettingsBoundaryInterface) this.f5856b).setSafeBrowsingEnabled(z);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface
    public void onMessage(InvocationHandler invocationHandler, InvocationHandler invocationHandler2) {
        p0.n a4 = p.a((WebMessageBoundaryInterface) k3.b.b(WebMessageBoundaryInterface.class, invocationHandler2));
        if (a4 != null) {
            ((AbstractC0565d) this.f5856b).onMessage(new s(invocationHandler), a4);
        }
    }

    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    public void onPostMessage(WebView webView, InvocationHandler invocationHandler, Uri uri, boolean z, InvocationHandler invocationHandler2) {
        p0.n a4 = p.a((WebMessageBoundaryInterface) k3.b.b(WebMessageBoundaryInterface.class, invocationHandler));
        if (a4 != null) {
            JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) k3.b.b(JsReplyProxyBoundaryInterface.class, invocationHandler2);
            ((p0.v) this.f5856b).onPostMessage(webView, a4, uri, z, (i) jsReplyProxyBoundaryInterface.getOrCreatePeer(new h(jsReplyProxyBoundaryInterface, 0)));
        }
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public void onRendererResponsive(WebView webView, InvocationHandler invocationHandler) {
        WeakHashMap weakHashMap = E.f5858c;
        WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) k3.b.b(WebViewRendererBoundaryInterface.class, invocationHandler);
        ((AbstractC0565d) this.f5856b).onRenderProcessResponsive(webView, (E) webViewRendererBoundaryInterface.getOrCreatePeer(new h(webViewRendererBoundaryInterface, 1)));
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public void onRendererUnresponsive(WebView webView, InvocationHandler invocationHandler) {
        WeakHashMap weakHashMap = E.f5858c;
        WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) k3.b.b(WebViewRendererBoundaryInterface.class, invocationHandler);
        ((AbstractC0565d) this.f5856b).onRenderProcessUnresponsive(webView, (E) webViewRendererBoundaryInterface.getOrCreatePeer(new h(webViewRendererBoundaryInterface, 1)));
    }

    public /* synthetic */ C0595C(int i4, Object obj) {
        this.f5855a = i4;
        this.f5856b = obj;
    }
}
