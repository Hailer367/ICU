package com.pichillilorenzo.flutter_inappwebview_android.webview;

import R.j;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.FlutterWebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p0.AbstractC0565d;
import p0.w;
import q0.C0597b;
import q0.x;
import q0.z;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class InAppWebViewManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "InAppWebViewManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_manager";
    public final Map<String, FlutterWebView> keepAliveWebViews;
    public InAppWebViewFlutterPlugin plugin;
    public int windowAutoincrementId;
    public final Map<Integer, Message> windowWebViewMessages;

    public InAppWebViewManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new C0644p(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.keepAliveWebViews = new HashMap();
        this.windowWebViewMessages = new HashMap();
        this.windowAutoincrementId = 0;
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public void clearAllCache(Context context, boolean z) {
        WebView webView = new WebView(context);
        webView.clearCache(z);
        webView.destroy();
    }

    public Map<String, Object> convertWebViewPackageToMap(PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("versionName", packageInfo.versionName);
        hashMap.put("packageName", packageInfo.packageName);
        return hashMap;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        Iterator<FlutterWebView> it = this.keepAliveWebViews.values().iterator();
        while (it.hasNext()) {
            String str = it.next().keepAliveId;
            if (str != null) {
                disposeKeepAlive(str);
            }
        }
        this.keepAliveWebViews.clear();
        this.windowWebViewMessages.clear();
        this.plugin = null;
    }

    public void disposeKeepAlive(String str) {
        ViewGroup viewGroup;
        FlutterWebView flutterWebView = this.keepAliveWebViews.get(str);
        if (flutterWebView != null) {
            flutterWebView.keepAliveId = null;
            View view = flutterWebView.getView();
            if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
                viewGroup.removeView(view);
            }
            flutterWebView.dispose();
        }
        if (this.keepAliveWebViews.containsKey(str)) {
            this.keepAliveWebViews.put(str, null);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, final InterfaceC0643o interfaceC0643o) {
        Uri safeBrowsingPrivacyPolicyUrl;
        Context context;
        PackageInfo packageInfo;
        String str = c0641m.f6155a;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1496477679:
                if (str.equals("disableWebView")) {
                    c4 = 0;
                    break;
                }
                break;
            case -910403233:
                if (str.equals("setWebContentsDebuggingEnabled")) {
                    c4 = 1;
                    break;
                }
                break;
            case -633518365:
                if (str.equals("getVariationsHeader")) {
                    c4 = 2;
                    break;
                }
                break;
            case -436220260:
                if (str.equals("clearClientCertPreferences")) {
                    c4 = 3;
                    break;
                }
                break;
            case 258673215:
                if (str.equals("getSafeBrowsingPrivacyPolicyUrl")) {
                    c4 = 4;
                    break;
                }
                break;
            case 426229521:
                if (str.equals("setSafeBrowsingAllowlist")) {
                    c4 = 5;
                    break;
                }
                break;
            case 643643439:
                if (str.equals("getDefaultUserAgent")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1033609166:
                if (str.equals("clearAllCache")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1586319888:
                if (str.equals("getCurrentWebViewPackage")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1667434977:
                if (str.equals("isMultiProcessEnabled")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1867011305:
                if (str.equals("disposeKeepAlive")) {
                    c4 = '\n';
                    break;
                }
                break;
        }
        Map<String, Object> map = null;
        switch (c4) {
            case 0:
                if (Build.VERSION.SDK_INT >= 28) {
                    WebView.disableWebView();
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case 1:
                WebView.setWebContentsDebuggingEnabled(((Boolean) c0641m.a("debuggingEnabled")).booleanValue());
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case 2:
                if (AbstractC0565d.a("GET_VARIATIONS_HEADER")) {
                    Uri uri = w.f5818a;
                    if (x.f5902G.b()) {
                        interfaceC0643o.success(z.f5932a.getStatics().getVariationsHeader());
                        return;
                    }
                    throw x.a();
                }
                interfaceC0643o.success(null);
                return;
            case 3:
                WebView.clearClientCertPreferences(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        interfaceC0643o.success(Boolean.TRUE);
                    }
                });
                return;
            case 4:
                if (AbstractC0565d.a("SAFE_BROWSING_PRIVACY_POLICY_URL")) {
                    Uri uri2 = w.f5818a;
                    C0597b c0597b = x.f5912f;
                    if (c0597b.a()) {
                        safeBrowsingPrivacyPolicyUrl = WebView.getSafeBrowsingPrivacyPolicyUrl();
                    } else if (c0597b.b()) {
                        safeBrowsingPrivacyPolicyUrl = z.f5932a.getStatics().getSafeBrowsingPrivacyPolicyUrl();
                    } else {
                        throw x.a();
                    }
                    interfaceC0643o.success(safeBrowsingPrivacyPolicyUrl.toString());
                    return;
                }
                interfaceC0643o.success(null);
                return;
            case 5:
                if (AbstractC0565d.a("SAFE_BROWSING_ALLOWLIST")) {
                    w.h(new HashSet((List) c0641m.a("hosts")), new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager.2
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(Boolean bool) {
                            interfaceC0643o.success(bool);
                        }
                    });
                    return;
                }
                if (AbstractC0565d.a("SAFE_BROWSING_WHITELIST")) {
                    List list = (List) c0641m.a("hosts");
                    ValueCallback<Boolean> valueCallback = new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager.3
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(Boolean bool) {
                            interfaceC0643o.success(bool);
                        }
                    };
                    Uri uri3 = w.f5818a;
                    w.h(new HashSet(list), valueCallback);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 6:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
                if (inAppWebViewFlutterPlugin != null) {
                    interfaceC0643o.success(WebSettings.getDefaultUserAgent(inAppWebViewFlutterPlugin.applicationContext));
                    return;
                } else {
                    interfaceC0643o.success(null);
                    return;
                }
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = this.plugin;
                if (inAppWebViewFlutterPlugin2 != null) {
                    Context context2 = inAppWebViewFlutterPlugin2.activity;
                    if (context2 == null) {
                        context2 = inAppWebViewFlutterPlugin2.applicationContext;
                    }
                    if (context2 != null) {
                        clearAllCache(context2, ((Boolean) c0641m.a("includeDiskFiles")).booleanValue());
                    }
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case j.BYTES_FIELD_NUMBER /* 8 */:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin3 = this.plugin;
                if (inAppWebViewFlutterPlugin3 != null) {
                    context = inAppWebViewFlutterPlugin3.activity;
                    if (context == null) {
                        context = inAppWebViewFlutterPlugin3.applicationContext;
                    }
                } else {
                    context = null;
                }
                if (context != null) {
                    packageInfo = w.d(context);
                } else {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    map = convertWebViewPackageToMap(packageInfo);
                }
                interfaceC0643o.success(map);
                return;
            case '\t':
                if (AbstractC0565d.a("MULTI_PROCESS")) {
                    Uri uri4 = w.f5818a;
                    if (x.f5896A.b()) {
                        interfaceC0643o.success(Boolean.valueOf(z.f5932a.getStatics().isMultiProcessEnabled()));
                        return;
                    }
                    throw x.a();
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case '\n':
                String str2 = (String) c0641m.a("keepAliveId");
                if (str2 != null) {
                    disposeKeepAlive(str2);
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            default:
                interfaceC0643o.notImplemented();
                return;
        }
    }
}
