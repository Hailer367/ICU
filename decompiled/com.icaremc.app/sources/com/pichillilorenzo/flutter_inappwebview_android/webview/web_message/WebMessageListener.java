package com.pichillilorenzo.flutter_inappwebview_android.webview.web_message;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview_android.types.PluginScript;
import com.pichillilorenzo.flutter_inappwebview_android.types.UserScriptInjectionTime;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessageCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewInterface;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.a;
import p0.AbstractC0562a;
import p0.AbstractC0565d;
import p0.n;
import p0.v;
import q0.i;
import q0.q;
import q0.x;
import r2.k;
import s2.C0644p;
import s2.InterfaceC0634f;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class WebMessageListener implements Disposable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String LOG_TAG = "WebMessageListener";
    public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappwebview_web_message_listener_";
    public Set<String> allowedOriginRules;
    public WebMessageListenerChannelDelegate channelDelegate;
    public String id;
    public String jsObjectName;
    public v listener;
    public AbstractC0562a replyProxy;
    public InAppWebViewInterface webView;

    public WebMessageListener(String str, InAppWebViewInterface inAppWebViewInterface, InterfaceC0634f interfaceC0634f, String str2, Set<String> set) {
        this.id = str;
        this.webView = inAppWebViewInterface;
        this.jsObjectName = str2;
        this.allowedOriginRules = set;
        this.channelDelegate = new WebMessageListenerChannelDelegate(this, new C0644p(interfaceC0634f, METHOD_CHANNEL_NAME_PREFIX + this.id + "_" + this.jsObjectName));
        if (this.webView instanceof InAppWebView) {
            this.listener = new v() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageListener.1
                @Override // p0.v
                public void onPostMessage(WebView webView, n nVar, Uri uri, boolean z, AbstractC0562a abstractC0562a) {
                    String uri2;
                    WebMessageListener webMessageListener = WebMessageListener.this;
                    webMessageListener.replyProxy = abstractC0562a;
                    WebMessageListenerChannelDelegate webMessageListenerChannelDelegate = webMessageListener.channelDelegate;
                    if (webMessageListenerChannelDelegate != null) {
                        WebMessageCompatExt fromMapWebMessageCompat = WebMessageCompatExt.fromMapWebMessageCompat(nVar);
                        if (uri.toString().equals("null")) {
                            uri2 = null;
                        } else {
                            uri2 = uri.toString();
                        }
                        webMessageListenerChannelDelegate.onPostMessage(fromMapWebMessageCompat, uri2, z);
                    }
                }
            };
        }
    }

    public static WebMessageListener fromMap(InAppWebViewInterface inAppWebViewInterface, InterfaceC0634f interfaceC0634f, Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new WebMessageListener((String) map.get("id"), inAppWebViewInterface, interfaceC0634f, (String) map.get("jsObjectName"), new HashSet((List) map.get("allowedOriginRules")));
    }

    public void assertOriginRulesValid() {
        int i4 = 0;
        for (String str : this.allowedOriginRules) {
            if (str != null) {
                if (!str.isEmpty()) {
                    if (!"*".equals(str)) {
                        Uri parse = Uri.parse(str);
                        String scheme = parse.getScheme();
                        String host = parse.getHost();
                        String path = parse.getPath();
                        int port = parse.getPort();
                        if (scheme != null) {
                            if ((!"http".equals(scheme) && !"https".equals(scheme)) || (host != null && !host.isEmpty())) {
                                if (!"http".equals(scheme) && !"https".equals(scheme) && (host != null || port != -1)) {
                                    throw new Exception(k.b("allowedOriginRules ", str, " is invalid"));
                                }
                                if ((host != null && !host.isEmpty()) || port == -1) {
                                    if (path.isEmpty()) {
                                        if (host != null) {
                                            int indexOf = host.indexOf("*");
                                            if (indexOf == 0 && (indexOf != 0 || host.startsWith("*."))) {
                                                if (host.startsWith("[")) {
                                                    if (host.endsWith("]")) {
                                                        if (!Util.isIPv6(host.substring(1, host.length() - 1))) {
                                                            throw new Exception(k.b("allowedOriginRules ", str, " is invalid"));
                                                        }
                                                    } else {
                                                        throw new Exception(k.b("allowedOriginRules ", str, " is invalid"));
                                                    }
                                                }
                                            } else {
                                                throw new Exception(k.b("allowedOriginRules ", str, " is invalid"));
                                            }
                                        }
                                        i4++;
                                    } else {
                                        throw new Exception(k.b("allowedOriginRules ", str, " is invalid"));
                                    }
                                } else {
                                    throw new Exception(k.b("allowedOriginRules ", str, " is invalid"));
                                }
                            } else {
                                throw new Exception(k.b("allowedOriginRules ", str, " is invalid"));
                            }
                        } else {
                            throw new Exception(k.b("allowedOriginRules ", str, " is invalid"));
                        }
                    }
                } else {
                    throw new Exception("allowedOriginRules[" + i4 + "] is empty");
                }
            } else {
                throw new Exception("allowedOriginRules[" + i4 + "] is null");
            }
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        WebMessageListenerChannelDelegate webMessageListenerChannelDelegate = this.channelDelegate;
        if (webMessageListenerChannelDelegate != null) {
            webMessageListenerChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.listener = null;
        this.replyProxy = null;
        this.webView = null;
    }

    public void initJsInstance() {
        String str;
        if (this.webView != null) {
            String replaceAll = Util.replaceAll(this.jsObjectName, "'", "\\'");
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.allowedOriginRules) {
                if ("*".equals(str2)) {
                    arrayList.add("'*'");
                } else {
                    Uri parse = Uri.parse(str2);
                    Object obj = "null";
                    if (parse.getHost() == null) {
                        str = "null";
                    } else {
                        str = "'" + Util.replaceAll(parse.getHost(), "'", "\\'") + "'";
                    }
                    StringBuilder sb = new StringBuilder("{scheme: '");
                    sb.append(parse.getScheme());
                    sb.append("', host: ");
                    sb.append(str);
                    sb.append(", port: ");
                    if (parse.getPort() != -1) {
                        obj = Integer.valueOf(parse.getPort());
                    }
                    sb.append(obj);
                    sb.append("}");
                    arrayList.add(sb.toString());
                }
            }
            String join = TextUtils.join(", ", arrayList);
            StringBuilder sb2 = new StringBuilder("(function() {  var allowedOriginRules = [");
            sb2.append(join);
            sb2.append("];  var isPageBlank = window.location.href === 'about:blank';  var scheme = !isPageBlank ? window.location.protocol.replace(':', '') : null;  var host = !isPageBlank ? window.location.hostname : null;  var port = !isPageBlank ? window.location.port : null;  if (window.flutter_inappwebview._isOriginAllowed(allowedOriginRules, scheme, host, port)) {      window['");
            sb2.append(replaceAll);
            sb2.append("'] = new FlutterInAppWebViewWebMessageListener('");
            String c4 = k.c(sb2, replaceAll, "');  }})();");
            this.webView.getUserContentController().addPluginScript(new PluginScript("WebMessageListener-" + this.jsObjectName, c4, UserScriptInjectionTime.AT_DOCUMENT_START, null, $assertionsDisabled, null));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:17|(2:72|(1:74)(1:75))(1:21)|(2:69|(1:71))(1:24)|25|(8:29|30|31|32|33|(1:63)(1:48)|(1:50)|(2:56|57))|68|31|32|33|(1:35)|63|(0)|(1:62)(4:52|54|56|57)) */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isOriginAllowed(java.lang.String r12, java.lang.String r13, int r14) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageListener.isOriginAllowed(java.lang.String, java.lang.String, int):boolean");
    }

    public void postMessageForInAppWebView(WebMessageCompatExt webMessageCompatExt, InterfaceC0643o interfaceC0643o) {
        Object data;
        if (this.replyProxy != null && AbstractC0565d.a("WEB_MESSAGE_LISTENER") && (data = webMessageCompatExt.getData()) != null) {
            if (AbstractC0565d.a("WEB_MESSAGE_ARRAY_BUFFER") && webMessageCompatExt.getType() == 1) {
                byte[] bArr = (byte[]) data;
                i iVar = (i) this.replyProxy;
                iVar.getClass();
                if (x.f5922q.b()) {
                    iVar.f5870a.postMessageWithPayload(new a(new q(bArr)));
                } else {
                    throw x.a();
                }
            } else {
                AbstractC0562a abstractC0562a = this.replyProxy;
                String obj = data.toString();
                i iVar2 = (i) abstractC0562a;
                iVar2.getClass();
                if (x.f5899D.b()) {
                    iVar2.f5870a.postMessage(obj);
                } else {
                    throw x.a();
                }
            }
        }
        interfaceC0643o.success(Boolean.TRUE);
    }
}
