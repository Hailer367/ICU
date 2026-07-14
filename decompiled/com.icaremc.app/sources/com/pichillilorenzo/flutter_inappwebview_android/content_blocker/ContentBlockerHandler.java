package com.pichillilorenzo.flutter_inappwebview_android.content_blocker;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLHandshakeException;

/* loaded from: classes.dex */
public class ContentBlockerHandler {
    protected static final String LOG_TAG = "ContentBlockerHandler";
    protected List<ContentBlocker> ruleList;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview_android.content_blocker.ContentBlockerHandler$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType;

        static {
            int[] iArr = new int[ContentBlockerActionType.values().length];
            $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType = iArr;
            try {
                iArr[ContentBlockerActionType.BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType[ContentBlockerActionType.CSS_DISPLAY_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType[ContentBlockerActionType.MAKE_HTTPS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ContentBlockerHandler() {
        this.ruleList = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
    public WebResourceResponse checkUrl(final InAppWebView inAppWebView, WebResourceRequestExt webResourceRequestExt, ContentBlockerTriggerResourceType contentBlockerTriggerResourceType) {
        URI uri;
        WebResourceResponse webResourceResponse;
        ?? r17;
        ContentBlockerAction contentBlockerAction;
        String str;
        HttpURLConnection makeHttpRequest;
        String str2;
        String[] strArr;
        String str3 = "charset=";
        WebResourceResponse webResourceResponse2 = null;
        if (inAppWebView.customSettings.contentBlockers == null) {
            return null;
        }
        String url = webResourceRequestExt.getUrl();
        boolean z = false;
        try {
            uri = new URI(url);
        } catch (URISyntaxException unused) {
            String str4 = url.split(":")[0];
            URL url2 = new URL(url.replace(str4, "https"));
            uri = new URI(str4, url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
        }
        String host = uri.getHost();
        int port = uri.getPort();
        String scheme = uri.getScheme();
        Iterator it = new CopyOnWriteArrayList(this.ruleList).iterator();
        while (it.hasNext()) {
            ContentBlocker contentBlocker = (ContentBlocker) it.next();
            ContentBlockerTrigger trigger = contentBlocker.getTrigger();
            List<ContentBlockerTriggerResourceType> resourceType = trigger.getResourceType();
            if (resourceType.contains(ContentBlockerTriggerResourceType.IMAGE)) {
                ContentBlockerTriggerResourceType contentBlockerTriggerResourceType2 = ContentBlockerTriggerResourceType.SVG_DOCUMENT;
                if (!resourceType.contains(contentBlockerTriggerResourceType2)) {
                    resourceType.add(contentBlockerTriggerResourceType2);
                }
            }
            ContentBlockerAction action = contentBlocker.getAction();
            if (trigger.getUrlFilterPatternCompiled().matcher(url).matches()) {
                if (!resourceType.isEmpty() && !resourceType.contains(contentBlockerTriggerResourceType)) {
                    return webResourceResponse2;
                }
                if (!trigger.getIfDomain().isEmpty()) {
                    for (String str5 : trigger.getIfDomain()) {
                        r17 = z;
                        if (str5.startsWith("*")) {
                            webResourceResponse = webResourceResponse2;
                            if (host.endsWith(str5.replace("*", ""))) {
                            }
                        } else {
                            webResourceResponse = webResourceResponse2;
                        }
                        if (!str5.equals(host)) {
                            webResourceResponse2 = webResourceResponse;
                            z = r17 == true ? 1 : 0;
                        }
                    }
                    return webResourceResponse2;
                }
                webResourceResponse = webResourceResponse2;
                r17 = z;
                if (!trigger.getUnlessDomain().isEmpty()) {
                    for (String str6 : trigger.getUnlessDomain()) {
                        if ((str6.startsWith("*") && host.endsWith(str6.replace("*", ""))) || str6.equals(host)) {
                            return webResourceResponse;
                        }
                    }
                }
                final String[] strArr2 = new String[1];
                if (!trigger.getLoadType().isEmpty() || !trigger.getIfTopUrl().isEmpty() || !trigger.getUnlessTopUrl().isEmpty()) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    new Handler(inAppWebView.getWebViewLooper()).post(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.content_blocker.ContentBlockerHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            strArr2[0] = inAppWebView.getUrl();
                            countDownLatch.countDown();
                        }
                    });
                    countDownLatch.await();
                }
                if (strArr2[r17] != null) {
                    if (trigger.getLoadType().isEmpty()) {
                        contentBlockerAction = action;
                        strArr = strArr2;
                    } else {
                        URI uri2 = new URI(strArr2[r17]);
                        String host2 = uri2.getHost();
                        int port2 = uri2.getPort();
                        String scheme2 = uri2.getScheme();
                        contentBlockerAction = action;
                        strArr = strArr2;
                        if ((trigger.getLoadType().contains("first-party") && host2 != null && (!scheme2.equals(scheme) || !host2.equals(host) || port2 != port)) || (trigger.getLoadType().contains("third-party") && host2 != null && host2.equals(host))) {
                            return webResourceResponse;
                        }
                    }
                    if (!trigger.getIfTopUrl().isEmpty()) {
                        Iterator<String> it2 = trigger.getIfTopUrl().iterator();
                        while (it2.hasNext()) {
                            if (strArr[r17].startsWith(it2.next())) {
                            }
                        }
                        return webResourceResponse;
                    }
                    if (!trigger.getUnlessTopUrl().isEmpty()) {
                        Iterator<String> it3 = trigger.getUnlessTopUrl().iterator();
                        while (it3.hasNext()) {
                            if (strArr[r17].startsWith(it3.next())) {
                                return webResourceResponse;
                            }
                        }
                    }
                } else {
                    contentBlockerAction = action;
                }
                int i4 = AnonymousClass3.$SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType[contentBlockerAction.getType().ordinal()];
                if (i4 == 1) {
                    return new WebResourceResponse("", "", webResourceResponse);
                }
                if (i4 != 2) {
                    if (i4 == 3 && scheme.equals("http") && ((port == -1 || port == 80) && (makeHttpRequest = Util.makeHttpRequest(url.replace("http://", "https://"), webResourceRequestExt.getMethod(), webResourceRequestExt.getHeaders())) != null)) {
                        try {
                            try {
                                byte[] readAllBytes = Util.readAllBytes(makeHttpRequest.getInputStream());
                                if (readAllBytes == null) {
                                    makeHttpRequest.disconnect();
                                    return webResourceResponse;
                                }
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readAllBytes);
                                String contentEncoding = makeHttpRequest.getContentEncoding();
                                String contentType = makeHttpRequest.getContentType();
                                if (contentType == null) {
                                    str2 = "text/plain";
                                } else {
                                    String[] split = contentType.split(";");
                                    String trim = split[r17].trim();
                                    if (contentEncoding == null) {
                                        if (split.length > 1 && split[1].contains(str3)) {
                                            contentEncoding = split[1].replace(str3, "").trim();
                                        } else {
                                            contentEncoding = "utf-8";
                                        }
                                    }
                                    str2 = trim;
                                }
                                String str7 = contentEncoding;
                                String responseMessage = makeHttpRequest.getResponseMessage();
                                if (responseMessage != null) {
                                    HashMap hashMap = new HashMap();
                                    for (Map.Entry<String, List<String>> entry : makeHttpRequest.getHeaderFields().entrySet()) {
                                        str = str3;
                                        try {
                                            hashMap.put(entry.getKey(), TextUtils.join(",", entry.getValue()));
                                            str3 = str;
                                        } catch (Exception e4) {
                                            e = e4;
                                            if (!(e instanceof SSLHandshakeException)) {
                                                Log.e(LOG_TAG, "", e);
                                            }
                                            makeHttpRequest.disconnect();
                                            webResourceResponse2 = webResourceResponse;
                                            z = r17;
                                            str3 = str;
                                        }
                                    }
                                    WebResourceResponse webResourceResponse3 = new WebResourceResponse(str2, str7, makeHttpRequest.getResponseCode(), responseMessage, hashMap, byteArrayInputStream);
                                    makeHttpRequest.disconnect();
                                    return webResourceResponse3;
                                }
                                WebResourceResponse webResourceResponse4 = new WebResourceResponse(str2, str7, byteArrayInputStream);
                                makeHttpRequest.disconnect();
                                return webResourceResponse4;
                            } catch (Exception e5) {
                                e = e5;
                                str = str3;
                            }
                        } catch (Throwable th) {
                            makeHttpRequest.disconnect();
                            throw th;
                        }
                    } else {
                        webResourceResponse2 = webResourceResponse;
                        z = r17;
                    }
                } else {
                    str = str3;
                    String selector = contentBlockerAction.getSelector();
                    final String str8 = "(function(d) {    function hide () {        if (d.body != null && !d.getElementById('flutter_inappwebview-css-display-none-style')) {            var c = d.createElement('style');            c.id = 'flutter_inappwebview-css-display-none-style';            c.innerHTML = '" + selector + " { display: none !important; }';            d.body.appendChild(c);        }       d.querySelectorAll('" + selector + "').forEach(function (item, index) {            item.setAttribute('style', 'display: none !important;');        });    };    hide();    d.addEventListener('DOMContentLoaded', function(event) { hide(); }); })(document);";
                    new Handler(inAppWebView.getWebViewLooper()).postDelayed(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.content_blocker.ContentBlockerHandler.2
                        @Override // java.lang.Runnable
                        public void run() {
                            inAppWebView.evaluateJavascript(str8, null);
                        }
                    }, 800L);
                }
                webResourceResponse2 = webResourceResponse;
                z = r17;
                str3 = str;
            }
        }
        return webResourceResponse2;
    }

    public ContentBlockerTriggerResourceType getResourceTypeFromContentType(String str) {
        ContentBlockerTriggerResourceType contentBlockerTriggerResourceType = ContentBlockerTriggerResourceType.RAW;
        if (str.equals("text/css")) {
            return ContentBlockerTriggerResourceType.STYLE_SHEET;
        }
        if (str.equals("image/svg+xml")) {
            return ContentBlockerTriggerResourceType.SVG_DOCUMENT;
        }
        if (str.startsWith("image/")) {
            return ContentBlockerTriggerResourceType.IMAGE;
        }
        if (str.startsWith("font/")) {
            return ContentBlockerTriggerResourceType.FONT;
        }
        if (!str.startsWith("audio/") && !str.startsWith("video/") && !str.equals("application/ogg")) {
            if (str.endsWith("javascript")) {
                return ContentBlockerTriggerResourceType.SCRIPT;
            }
            if (str.startsWith("text/")) {
                return ContentBlockerTriggerResourceType.DOCUMENT;
            }
            return contentBlockerTriggerResourceType;
        }
        return ContentBlockerTriggerResourceType.MEDIA;
    }

    public ContentBlockerTriggerResourceType getResourceTypeFromUrl(WebResourceRequestExt webResourceRequestExt) {
        HttpURLConnection makeHttpRequest;
        ContentBlockerTriggerResourceType contentBlockerTriggerResourceType = ContentBlockerTriggerResourceType.RAW;
        String url = webResourceRequestExt.getUrl();
        if ((url.startsWith("http://") || url.startsWith("https://")) && (makeHttpRequest = Util.makeHttpRequest(url, "HEAD", webResourceRequestExt.getHeaders())) != null) {
            try {
                String contentType = makeHttpRequest.getContentType();
                if (contentType != null) {
                    contentBlockerTriggerResourceType = getResourceTypeFromContentType(contentType.split(";")[0].trim());
                }
                return contentBlockerTriggerResourceType;
            } catch (Exception e4) {
                Log.e(LOG_TAG, "", e4);
                return contentBlockerTriggerResourceType;
            } finally {
                makeHttpRequest.disconnect();
            }
        }
        return contentBlockerTriggerResourceType;
    }

    public List<ContentBlocker> getRuleList() {
        return this.ruleList;
    }

    public void setRuleList(List<ContentBlocker> list) {
        this.ruleList = list;
    }

    public ContentBlockerHandler(List<ContentBlocker> list) {
        new ArrayList();
        this.ruleList = list;
    }

    public WebResourceResponse checkUrl(InAppWebView inAppWebView, WebResourceRequestExt webResourceRequestExt) {
        return checkUrl(inAppWebView, webResourceRequestExt, getResourceTypeFromUrl(webResourceRequestExt));
    }

    public WebResourceResponse checkUrl(InAppWebView inAppWebView, WebResourceRequestExt webResourceRequestExt, String str) {
        return checkUrl(inAppWebView, webResourceRequestExt, getResourceTypeFromContentType(str));
    }
}
