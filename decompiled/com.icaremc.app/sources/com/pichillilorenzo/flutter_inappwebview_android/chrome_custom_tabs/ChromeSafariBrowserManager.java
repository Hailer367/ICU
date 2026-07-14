package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import r.AbstractC0613h;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class ChromeSafariBrowserManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "ChromeBrowserManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_chromesafaribrowser";
    public static final Map<String, ChromeSafariBrowserManager> shared = new HashMap();
    public final Map<String, ChromeCustomTabsActivity> browsers;
    public String id;
    public InAppWebViewFlutterPlugin plugin;

    public ChromeSafariBrowserManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new C0644p(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.browsers = new HashMap();
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
        this.plugin = inAppWebViewFlutterPlugin;
        shared.put(uuid, this);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        for (ChromeCustomTabsActivity chromeCustomTabsActivity : this.browsers.values()) {
            if (chromeCustomTabsActivity != null) {
                chromeCustomTabsActivity.close();
                chromeCustomTabsActivity.dispose();
            }
        }
        this.browsers.clear();
        shared.remove(this.id);
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        Activity activity;
        String str = (String) c0641m.a("id");
        String str2 = c0641m.f6155a;
        str2.getClass();
        char c4 = 65535;
        switch (str2.hashCode()) {
            case -1382009261:
                if (str2.equals("getMaxToolbarItems")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3417674:
                if (str2.equals("open")) {
                    c4 = 1;
                    break;
                }
                break;
            case 268490427:
                if (str2.equals("getPackageName")) {
                    c4 = 2;
                    break;
                }
                break;
            case 444517567:
                if (str2.equals("isAvailable")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                interfaceC0643o.success(5);
                return;
            case 1:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
                if (inAppWebViewFlutterPlugin != null && inAppWebViewFlutterPlugin.activity != null) {
                    open(this.plugin.activity, str, (String) c0641m.a("url"), (HashMap) c0641m.a("headers"), (String) c0641m.a("referrer"), (ArrayList) c0641m.a("otherLikelyURLs"), (HashMap) c0641m.a("settings"), (HashMap) c0641m.a("actionButton"), (HashMap) c0641m.a("secondaryToolbar"), (List) c0641m.a("menuItemList"), interfaceC0643o);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 2:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = this.plugin;
                if (inAppWebViewFlutterPlugin2 != null && inAppWebViewFlutterPlugin2.activity != null) {
                    interfaceC0643o.success(AbstractC0613h.a(this.plugin.activity, (ArrayList) c0641m.a("packages"), ((Boolean) c0641m.a("ignoreDefault")).booleanValue()));
                    return;
                } else {
                    interfaceC0643o.success(null);
                    return;
                }
            case 3:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin3 = this.plugin;
                if (inAppWebViewFlutterPlugin3 != null && (activity = inAppWebViewFlutterPlugin3.activity) != null) {
                    interfaceC0643o.success(Boolean.valueOf(CustomTabActivityHelper.isAvailable(activity)));
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            default:
                interfaceC0643o.notImplemented();
                return;
        }
    }

    public void open(Activity activity, String str, String str2, HashMap<String, Object> hashMap, String str3, ArrayList<String> arrayList, HashMap<String, Object> hashMap2, HashMap<String, Object> hashMap3, HashMap<String, Object> hashMap4, List<HashMap<String, Object>> list, InterfaceC0643o interfaceC0643o) {
        Class cls;
        Bundle bundle = new Bundle();
        bundle.putString("url", str2);
        bundle.putString("id", str);
        bundle.putString("managerId", this.id);
        bundle.putSerializable("headers", hashMap);
        bundle.putString("referrer", str3);
        bundle.putSerializable("otherLikelyURLs", arrayList);
        bundle.putSerializable("settings", hashMap2);
        bundle.putSerializable("actionButton", hashMap3);
        bundle.putSerializable("secondaryToolbar", hashMap4);
        bundle.putSerializable("menuItemList", (Serializable) list);
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = (Boolean) Util.getOrDefault(hashMap2, "isSingleInstance", bool);
        Boolean bool3 = (Boolean) Util.getOrDefault(hashMap2, "isTrustedWebActivity", bool);
        if (CustomTabActivityHelper.isAvailable(activity)) {
            if (!bool2.booleanValue()) {
                cls = !bool3.booleanValue() ? ChromeCustomTabsActivity.class : TrustedWebActivity.class;
            } else {
                cls = !bool3.booleanValue() ? ChromeCustomTabsActivitySingleInstance.class : TrustedWebActivitySingleInstance.class;
            }
            Intent intent = new Intent(activity, (Class<?>) cls);
            intent.putExtras(bundle);
            if (((Boolean) Util.getOrDefault(hashMap2, "noHistory", bool)).booleanValue()) {
                intent.addFlags(1073741824);
            }
            activity.startActivity(intent);
            interfaceC0643o.success(Boolean.TRUE);
            return;
        }
        interfaceC0643o.error(LOG_TAG, "ChromeCustomTabs is not available!", null);
    }
}
