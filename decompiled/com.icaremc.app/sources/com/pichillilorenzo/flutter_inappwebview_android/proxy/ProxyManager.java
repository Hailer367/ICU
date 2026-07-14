package com.pichillilorenzo.flutter_inappwebview_android.proxy;

import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ProxyRuleExt;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import p0.AbstractC0565d;
import p0.AbstractC0566e;
import p0.C0563b;
import q0.C0597b;
import q0.j;
import q0.x;
import q0.z;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class ProxyManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "ProxyManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_proxycontroller";
    public static AbstractC0566e proxyController;
    public InAppWebViewFlutterPlugin plugin;

    public ProxyManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new C0644p(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    private void clearProxyOverride(final InterfaceC0643o interfaceC0643o) {
        AbstractC0566e abstractC0566e = proxyController;
        if (abstractC0566e != null) {
            Executor executor = new Executor() { // from class: com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager.3
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            };
            Runnable runnable = new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager.4
                @Override // java.lang.Runnable
                public void run() {
                    interfaceC0643o.success(Boolean.TRUE);
                }
            };
            j jVar = (j) abstractC0566e;
            if (x.z.b()) {
                if (jVar.f5871a == null) {
                    jVar.f5871a = z.f5932a.getProxyController();
                }
                jVar.f5871a.clearProxyOverride(runnable, executor);
                return;
            }
            throw x.a();
        }
    }

    public static void init() {
        if (proxyController == null && AbstractC0565d.a("PROXY_OVERRIDE")) {
            if (AbstractC0565d.a("PROXY_OVERRIDE")) {
                proxyController = AbstractC0565d.f5800a;
                return;
            }
            throw new UnsupportedOperationException("Proxy override not supported");
        }
    }

    private void setProxyOverride(ProxySettings proxySettings, final InterfaceC0643o interfaceC0643o) {
        boolean z;
        if (proxyController != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = proxySettings.bypassRules.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next());
            }
            Iterator<String> it2 = proxySettings.directs.iterator();
            while (it2.hasNext()) {
                arrayList.add(new C0563b(it2.next(), "direct://"));
            }
            for (ProxyRuleExt proxyRuleExt : proxySettings.proxyRules) {
                if (proxyRuleExt.getSchemeFilter() != null) {
                    arrayList.add(new C0563b(proxyRuleExt.getSchemeFilter(), proxyRuleExt.getUrl()));
                } else {
                    arrayList.add(new C0563b("*", proxyRuleExt.getUrl()));
                }
            }
            Boolean bool = proxySettings.bypassSimpleHostnames;
            if (bool != null && bool.booleanValue()) {
                arrayList2.add("<local>");
            }
            Boolean bool2 = proxySettings.removeImplicitRules;
            if (bool2 != null && bool2.booleanValue()) {
                arrayList2.add("<-loopback>");
            }
            if (proxySettings.reverseBypassEnabled != null && AbstractC0565d.a("PROXY_OVERRIDE_REVERSE_BYPASS")) {
                z = proxySettings.reverseBypassEnabled.booleanValue();
            } else {
                z = false;
            }
            AbstractC0566e abstractC0566e = proxyController;
            Executor executor = new Executor() { // from class: com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager.1
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            };
            Runnable runnable = new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager.2
                @Override // java.lang.Runnable
                public void run() {
                    interfaceC0643o.success(Boolean.TRUE);
                }
            };
            j jVar = (j) abstractC0566e;
            jVar.getClass();
            C0597b c0597b = x.z;
            C0597b c0597b2 = x.f5901F;
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, unmodifiableList.size(), 2);
            for (int i4 = 0; i4 < unmodifiableList.size(); i4++) {
                strArr[i4][0] = ((C0563b) unmodifiableList.get(i4)).f5798a;
                strArr[i4][1] = ((C0563b) unmodifiableList.get(i4)).f5799b;
            }
            String[] strArr2 = (String[]) Collections.unmodifiableList(arrayList2).toArray(new String[0]);
            if (c0597b.b() && !z) {
                if (jVar.f5871a == null) {
                    jVar.f5871a = z.f5932a.getProxyController();
                }
                jVar.f5871a.setProxyOverride(strArr, strArr2, runnable, executor);
            } else {
                if (c0597b.b() && c0597b2.b()) {
                    if (jVar.f5871a == null) {
                        jVar.f5871a = z.f5932a.getProxyController();
                    }
                    jVar.f5871a.setProxyOverride(strArr, strArr2, runnable, executor, z);
                    return;
                }
                throw x.a();
            }
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        init();
        String str = c0641m.f6155a;
        str.getClass();
        if (!str.equals("clearProxyOverride")) {
            if (!str.equals("setProxyOverride")) {
                interfaceC0643o.notImplemented();
                return;
            }
            if (proxyController != null) {
                HashMap hashMap = (HashMap) c0641m.a("settings");
                ProxySettings proxySettings = new ProxySettings();
                if (hashMap != null) {
                    proxySettings.parse2((Map<String, Object>) hashMap);
                }
                setProxyOverride(proxySettings, interfaceC0643o);
                return;
            }
            interfaceC0643o.success(Boolean.FALSE);
            return;
        }
        if (proxyController != null) {
            clearProxyOverride(interfaceC0643o);
        } else {
            interfaceC0643o.success(Boolean.FALSE);
        }
    }
}
