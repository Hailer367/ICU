package com.pichillilorenzo.flutter_inappwebview_android.headless_in_app_webview;

import android.content.Context;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.FlutterWebView;
import java.util.HashMap;
import java.util.Map;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class HeadlessInAppWebViewManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "HeadlessInAppWebViewManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_headless_inappwebview";
    public InAppWebViewFlutterPlugin plugin;
    public final Map<String, HeadlessInAppWebView> webViews;

    public HeadlessInAppWebViewManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new C0644p(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.webViews = new HashMap();
        this.plugin = inAppWebViewFlutterPlugin;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        for (HeadlessInAppWebView headlessInAppWebView : this.webViews.values()) {
            if (headlessInAppWebView != null) {
                headlessInAppWebView.dispose();
            }
        }
        this.webViews.clear();
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        String str = (String) c0641m.a("id");
        String str2 = c0641m.f6155a;
        str2.getClass();
        if (!str2.equals("run")) {
            interfaceC0643o.notImplemented();
        } else {
            run(str, (HashMap) c0641m.a("params"));
            interfaceC0643o.success(Boolean.TRUE);
        }
    }

    public void run(String str, HashMap<String, Object> hashMap) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null) {
            Context context = inAppWebViewFlutterPlugin.activity;
            if (context != null || inAppWebViewFlutterPlugin.applicationContext != null) {
                if (context == null) {
                    context = inAppWebViewFlutterPlugin.applicationContext;
                }
                FlutterWebView flutterWebView = new FlutterWebView(inAppWebViewFlutterPlugin, context, str, hashMap);
                HeadlessInAppWebView headlessInAppWebView = new HeadlessInAppWebView(this.plugin, str, flutterWebView);
                this.webViews.put(str, headlessInAppWebView);
                headlessInAppWebView.prepare(hashMap);
                headlessInAppWebView.onWebViewCreated();
                flutterWebView.makeInitialLoad(hashMap);
            }
        }
    }
}
