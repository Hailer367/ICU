package com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.find_interaction.FindInteractionController;
import com.pichillilorenzo.flutter_inappwebview_android.pull_to_refresh.PullToRefreshLayout;
import com.pichillilorenzo.flutter_inappwebview_android.pull_to_refresh.PullToRefreshSettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview_android.types.UserScript;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager;
import com.pichillilorenzo.flutter_inappwebview_android.webview.PlatformWebView;
import h2.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p0.AbstractC0565d;

/* loaded from: classes.dex */
public class FlutterWebView implements PlatformWebView {
    static final String LOG_TAG = "IAWFlutterWebView";
    public String keepAliveId;
    public PullToRefreshLayout pullToRefreshLayout;
    public InAppWebView webView;

    public FlutterWebView(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, Context context, Object obj, HashMap<String, Object> hashMap) {
        p pVar;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2;
        Object obj2;
        Context context2;
        DisplayListenerProxy displayListenerProxy = new DisplayListenerProxy();
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        displayListenerProxy.onPreWebViewInitialization(displayManager);
        this.keepAliveId = (String) hashMap.get("keepAliveId");
        Map<String, Object> map = (Map) hashMap.get("initialSettings");
        Map map2 = (Map) hashMap.get("contextMenu");
        Integer num = (Integer) hashMap.get("windowId");
        List list = (List) hashMap.get("initialUserScripts");
        Map<String, Object> map3 = (Map) hashMap.get("pullToRefreshSettings");
        InAppWebViewSettings inAppWebViewSettings = new InAppWebViewSettings();
        inAppWebViewSettings.parse2(map);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(UserScript.fromMap((Map) it.next()));
            }
        }
        if (inAppWebViewSettings.useHybridComposition.booleanValue()) {
            pVar = null;
            inAppWebViewFlutterPlugin2 = inAppWebViewFlutterPlugin;
            context2 = context;
            obj2 = obj;
        } else {
            pVar = inAppWebViewFlutterPlugin.flutterView;
            inAppWebViewFlutterPlugin2 = inAppWebViewFlutterPlugin;
            obj2 = obj;
            context2 = context;
        }
        this.webView = new InAppWebView(context2, inAppWebViewFlutterPlugin2, obj2, num, inAppWebViewSettings, map2, pVar, arrayList);
        displayListenerProxy.onPostWebViewInitialization(displayManager);
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        PullToRefreshSettings pullToRefreshSettings = new PullToRefreshSettings();
        pullToRefreshSettings.parse2(map3);
        PullToRefreshLayout pullToRefreshLayout = new PullToRefreshLayout(context, inAppWebViewFlutterPlugin, obj2, pullToRefreshSettings);
        this.pullToRefreshLayout = pullToRefreshLayout;
        pullToRefreshLayout.addView(this.webView);
        this.pullToRefreshLayout.prepare();
        FindInteractionController findInteractionController = new FindInteractionController(this.webView, inAppWebViewFlutterPlugin, obj2, null);
        this.webView.findInteractionController = findInteractionController;
        findInteractionController.prepare();
        this.webView.prepare();
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.webview.PlatformWebView, io.flutter.plugin.platform.InterfaceC0382f
    public void dispose() {
        InAppWebView inAppWebView;
        if (this.keepAliveId == null && (inAppWebView = this.webView) != null) {
            inAppWebView.dispose();
            this.webView = null;
            PullToRefreshLayout pullToRefreshLayout = this.pullToRefreshLayout;
            if (pullToRefreshLayout != null) {
                pullToRefreshLayout.dispose();
                this.pullToRefreshLayout = null;
            }
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.webview.PlatformWebView, io.flutter.plugin.platform.InterfaceC0382f
    public View getView() {
        PullToRefreshLayout pullToRefreshLayout = this.pullToRefreshLayout;
        if (pullToRefreshLayout != null) {
            return pullToRefreshLayout;
        }
        return this.webView;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.webview.PlatformWebView
    public void makeInitialLoad(HashMap<String, Object> hashMap) {
        URLRequest fromMap;
        InAppWebViewManager inAppWebViewManager;
        Message message;
        if (this.webView != null) {
            Integer num = (Integer) hashMap.get("windowId");
            Map map = (Map) hashMap.get("initialUrlRequest");
            String str = (String) hashMap.get("initialFile");
            Map map2 = (Map) hashMap.get("initialData");
            if (num != null) {
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.webView.plugin;
                if (inAppWebViewFlutterPlugin != null && (inAppWebViewManager = inAppWebViewFlutterPlugin.inAppWebViewManager) != null && (message = inAppWebViewManager.windowWebViewMessages.get(num)) != null) {
                    ((WebView.WebViewTransport) message.obj).setWebView(this.webView);
                    message.sendToTarget();
                    if (AbstractC0565d.a("DOCUMENT_START_SCRIPT")) {
                        this.webView.post(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.FlutterWebView.1
                            @Override // java.lang.Runnable
                            public void run() {
                                InAppWebView inAppWebView = FlutterWebView.this.webView;
                                if (inAppWebView != null) {
                                    inAppWebView.prepareAndAddUserScripts();
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            if (str != null) {
                try {
                    this.webView.loadFile(str);
                    return;
                } catch (IOException e4) {
                    Log.e(LOG_TAG, str.concat(" asset file cannot be found!"), e4);
                    return;
                }
            }
            if (map2 != null) {
                this.webView.loadDataWithBaseURL((String) map2.get("baseUrl"), (String) map2.get("data"), (String) map2.get("mimeType"), (String) map2.get("encoding"), (String) map2.get("historyUrl"));
                return;
            }
            if (map != null && (fromMap = URLRequest.fromMap(map)) != null) {
                this.webView.loadUrl(fromMap);
            }
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.webview.PlatformWebView, io.flutter.plugin.platform.InterfaceC0382f
    public void onFlutterViewAttached(View view) {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null && !inAppWebView.customSettings.useHybridComposition.booleanValue()) {
            this.webView.setContainerView(view);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.webview.PlatformWebView, io.flutter.plugin.platform.InterfaceC0382f
    public void onFlutterViewDetached() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null && !inAppWebView.customSettings.useHybridComposition.booleanValue()) {
            this.webView.setContainerView(null);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.webview.PlatformWebView, io.flutter.plugin.platform.InterfaceC0382f
    public void onInputConnectionLocked() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null && inAppWebView.inAppBrowserDelegate == null && !inAppWebView.customSettings.useHybridComposition.booleanValue()) {
            this.webView.lockInputConnection();
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.webview.PlatformWebView, io.flutter.plugin.platform.InterfaceC0382f
    public void onInputConnectionUnlocked() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null && inAppWebView.inAppBrowserDelegate == null && !inAppWebView.customSettings.useHybridComposition.booleanValue()) {
            this.webView.unlockInputConnection();
        }
    }
}
