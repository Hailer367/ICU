package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import R.j;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import b.C0219b;
import b.InterfaceC0221d;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsSecondaryToolbar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r.BinderC0612g;
import r.o;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class ChromeCustomTabsChannelDelegate extends ChannelDelegateImpl {
    private ChromeCustomTabsActivity chromeCustomTabsActivity;

    public ChromeCustomTabsChannelDelegate(ChromeCustomTabsActivity chromeCustomTabsActivity, C0644p c0644p) {
        super(c0644p);
        this.chromeCustomTabsActivity = chromeCustomTabsActivity;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.chromeCustomTabsActivity = null;
    }

    public void onClosed() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onClosed", new HashMap(), null);
    }

    public void onCompletedInitialLoad() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onCompletedInitialLoad", new HashMap(), null);
    }

    public void onGreatestScrollPercentageIncreased(int i4) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scrollPercentage", Integer.valueOf(i4));
        channel.a("onGreatestScrollPercentageIncreased", hashMap, null);
    }

    public void onItemActionPerform(int i4, String str, String str2) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i4));
        hashMap.put("url", str);
        hashMap.put("title", str2);
        channel.a("onItemActionPerform", hashMap, null);
    }

    public void onMessageChannelReady() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onMessageChannelReady", new HashMap(), null);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        o oVar;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        Activity activity;
        Uri uri;
        int i4;
        String str = c0641m.f6155a;
        str.getClass();
        boolean z = false;
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1526944655:
                if (str.equals("isEngagementSignalsApiAvailable")) {
                    c4 = 0;
                    break;
                }
                break;
            case -675108676:
                if (str.equals("launchUrl")) {
                    c4 = 1;
                    break;
                }
                break;
            case -334843312:
                if (str.equals("updateSecondaryToolbar")) {
                    c4 = 2;
                    break;
                }
                break;
            case 50870385:
                if (str.equals("updateActionButton")) {
                    c4 = 3;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1256059502:
                if (str.equals("validateRelationship")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1392239787:
                if (str.equals("requestPostMessageChannel")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1490029383:
                if (str.equals("postMessage")) {
                    c4 = 7;
                    break;
                }
                break;
            case 2000053463:
                if (str.equals("mayLaunchUrl")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        Bundle bundle = null;
        switch (c4) {
            case 0:
                ChromeCustomTabsActivity chromeCustomTabsActivity = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity != null && (oVar = chromeCustomTabsActivity.customTabsSession) != null) {
                    try {
                        interfaceC0643o.success(Boolean.valueOf(oVar.b(new Bundle())));
                        return;
                    } catch (Throwable unused) {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 1:
                if (this.chromeCustomTabsActivity != null) {
                    String str2 = (String) c0641m.a("url");
                    if (str2 != null) {
                        this.chromeCustomTabsActivity.launchUrl(str2, (Map) c0641m.a("headers"), (String) c0641m.a("referrer"), (List) c0641m.a("otherLikelyURLs"));
                        interfaceC0643o.success(Boolean.TRUE);
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 2:
                if (this.chromeCustomTabsActivity != null) {
                    this.chromeCustomTabsActivity.updateSecondaryToolbar(CustomTabsSecondaryToolbar.fromMap((Map) c0641m.a("secondaryToolbar")));
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 3:
                if (this.chromeCustomTabsActivity != null) {
                    this.chromeCustomTabsActivity.updateActionButton((byte[]) c0641m.a("icon"), (String) c0641m.a("description"));
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 4:
                ChromeCustomTabsActivity chromeCustomTabsActivity2 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity2 != null) {
                    chromeCustomTabsActivity2.onStop();
                    this.chromeCustomTabsActivity.onDestroy();
                    this.chromeCustomTabsActivity.close();
                    ChromeSafariBrowserManager chromeSafariBrowserManager = this.chromeCustomTabsActivity.manager;
                    if (chromeSafariBrowserManager != null && (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) != null && (activity = inAppWebViewFlutterPlugin.activity) != null) {
                        Intent intent = new Intent(activity, activity.getClass());
                        intent.addFlags(67108864);
                        intent.addFlags(536870912);
                        activity.startActivity(intent);
                    }
                    this.chromeCustomTabsActivity.dispose();
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 5:
                ChromeCustomTabsActivity chromeCustomTabsActivity3 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity3 != null && chromeCustomTabsActivity3.customTabsSession != null) {
                    Integer num = (Integer) c0641m.a("relation");
                    String str3 = (String) c0641m.a("origin");
                    o oVar2 = this.chromeCustomTabsActivity.customTabsSession;
                    int intValue = num.intValue();
                    Uri parse = Uri.parse(str3);
                    oVar2.getClass();
                    if (intValue >= 1 && intValue <= 2) {
                        try {
                            z = ((C0219b) oVar2.f6012b).m(oVar2.f6013c, intValue, parse, oVar2.a(null));
                        } catch (RemoteException unused2) {
                        }
                    }
                    interfaceC0643o.success(Boolean.valueOf(z));
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 6:
                ChromeCustomTabsActivity chromeCustomTabsActivity4 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity4 != null && chromeCustomTabsActivity4.customTabsSession != null) {
                    String str4 = (String) c0641m.a("sourceOrigin");
                    String str5 = (String) c0641m.a("targetOrigin");
                    o oVar3 = this.chromeCustomTabsActivity.customTabsSession;
                    Uri parse2 = Uri.parse(str4);
                    if (str5 != null) {
                        uri = Uri.parse(str5);
                    } else {
                        uri = null;
                    }
                    Bundle bundle2 = new Bundle();
                    BinderC0612g binderC0612g = oVar3.f6013c;
                    InterfaceC0221d interfaceC0221d = oVar3.f6012b;
                    try {
                        Bundle bundle3 = new Bundle();
                        if (uri != null) {
                            bundle3.putParcelable("target_origin", uri);
                        }
                        if (!bundle3.isEmpty()) {
                            bundle = bundle3;
                        }
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                            z = ((C0219b) interfaceC0221d).j(binderC0612g, parse2, bundle2);
                        } else {
                            z = ((C0219b) interfaceC0221d).i(binderC0612g, parse2);
                        }
                    } catch (RemoteException unused3) {
                    }
                    interfaceC0643o.success(Boolean.valueOf(z));
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                ChromeCustomTabsActivity chromeCustomTabsActivity5 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity5 != null && chromeCustomTabsActivity5.customTabsSession != null) {
                    String str6 = (String) c0641m.a("message");
                    o oVar4 = this.chromeCustomTabsActivity.customTabsSession;
                    Bundle a4 = oVar4.a(new Bundle());
                    synchronized (oVar4.f6011a) {
                        try {
                            try {
                                i4 = ((C0219b) oVar4.f6012b).h(oVar4.f6013c, str6, a4);
                            } finally {
                            }
                        } catch (RemoteException unused4) {
                            i4 = -2;
                        }
                    }
                    interfaceC0643o.success(Integer.valueOf(i4));
                    return;
                }
                interfaceC0643o.success(-3);
                return;
            case j.BYTES_FIELD_NUMBER /* 8 */:
                if (this.chromeCustomTabsActivity != null) {
                    interfaceC0643o.success(Boolean.valueOf(this.chromeCustomTabsActivity.mayLaunchUrl((String) c0641m.a("url"), (List) c0641m.a("otherLikelyURLs"))));
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

    public void onNavigationEvent(int i4) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("navigationEvent", Integer.valueOf(i4));
        channel.a("onNavigationEvent", hashMap, null);
    }

    public void onOpened() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onOpened", new HashMap(), null);
    }

    public void onPostMessage(String str) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("message", str);
        channel.a("onPostMessage", hashMap, null);
    }

    public void onRelationshipValidationResult(int i4, Uri uri, boolean z) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("relation", Integer.valueOf(i4));
        hashMap.put("requestedOrigin", uri.toString());
        hashMap.put("result", Boolean.valueOf(z));
        channel.a("onRelationshipValidationResult", hashMap, null);
    }

    public void onSecondaryItemActionPerform(String str, String str2) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("url", str2);
        channel.a("onSecondaryItemActionPerform", hashMap, null);
    }

    public void onServiceConnected() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onServiceConnected", new HashMap(), null);
    }

    public void onSessionEnded(boolean z) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("didUserInteract", Boolean.valueOf(z));
        channel.a("onSessionEnded", hashMap, null);
    }

    public void onVerticalScrollEvent(boolean z) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isDirectionUp", Boolean.valueOf(z));
        channel.a("onVerticalScrollEvent", hashMap, null);
    }
}
