package com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview;

import A2.i;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebViewClientCompat;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate;
import com.pichillilorenzo.flutter_inappwebview_android.plugin_scripts_js.JavaScriptBridgeJS;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomSchemeResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.NavigationAction;
import com.pichillilorenzo.flutter_inappwebview_android.types.NavigationActionPolicy;
import com.pichillilorenzo.flutter_inappwebview_android.types.SafeBrowsingResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceErrorExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceResponseExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebViewAssetLoaderExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import p0.AbstractC0565d;
import p0.AbstractC0567f;
import p0.p;
import q0.C0595C;
import q0.C0597b;
import q0.k;
import q0.t;
import q0.x;
import q0.y;

/* loaded from: classes.dex */
public class InAppWebViewClientCompat extends WebViewClientCompat {
    protected static final String LOG_TAG = "IAWebViewClientCompat";
    private static List<URLCredential> credentialsProposed;
    private static int previousAuthRequestFailureCount;
    private InAppBrowserDelegate inAppBrowserDelegate;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat$7, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$types$NavigationActionPolicy;

        static {
            int[] iArr = new int[NavigationActionPolicy.values().length];
            $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$types$NavigationActionPolicy = iArr;
            try {
                iArr[NavigationActionPolicy.ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$types$NavigationActionPolicy[NavigationActionPolicy.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public InAppWebViewClientCompat(InAppBrowserDelegate inAppBrowserDelegate) {
        this.inAppBrowserDelegate = inAppBrowserDelegate;
    }

    public static void access$601(InAppWebViewClientCompat inAppWebViewClientCompat, WebView webView, WebResourceRequest webResourceRequest, int i4, AbstractC0567f abstractC0567f) {
        inAppWebViewClientCompat.getClass();
        if (AbstractC0565d.a("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL")) {
            abstractC0567f.a(true);
            return;
        }
        throw x.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void allowShouldOverrideUrlLoading(WebView webView, String str, Map<String, String> map, boolean z) {
        if (z) {
            webView.loadUrl(str, map);
        }
    }

    public void dispose() {
        if (this.inAppBrowserDelegate != null) {
            this.inAppBrowserDelegate = null;
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        String url = webView.getUrl();
        InAppBrowserDelegate inAppBrowserDelegate = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate != null) {
            inAppBrowserDelegate.didUpdateVisitedHistory(url);
        }
        WebViewChannelDelegate webViewChannelDelegate = ((InAppWebView) webView).channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onUpdateVisitedHistory(url, z);
        }
    }

    public void loadCustomJavaScriptOnPageFinished(WebView webView) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.evaluateJavascript(inAppWebView.userContentController.generateWrappedCodeForDocumentEnd(), null);
    }

    public void loadCustomJavaScriptOnPageStarted(WebView webView) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (!AbstractC0565d.a("DOCUMENT_START_SCRIPT")) {
            inAppWebView.evaluateJavascript(inAppWebView.userContentController.generateWrappedCodeForDocumentStart(), null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(final WebView webView, final Message message, final Message message2) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        WebViewChannelDelegate.FormResubmissionCallback formResubmissionCallback = new WebViewChannelDelegate.FormResubmissionCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.6
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, s2.InterfaceC0643o
            public void error(String str, String str2, Object obj) {
                StringBuilder j4 = i.j(str, ", ");
                if (str2 == null) {
                    str2 = "";
                }
                i.r(j4, str2, InAppWebViewClientCompat.LOG_TAG);
                defaultBehaviour((Integer) null);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public void defaultBehaviour(Integer num) {
                InAppWebViewClientCompat.super.onFormResubmission(webView, message, message2);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public boolean nonNullSuccess(Integer num) {
                if (num.intValue() != 0) {
                    message.sendToTarget();
                    return false;
                }
                message2.sendToTarget();
                return false;
            }
        };
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onFormResubmission(inAppWebView.getUrl(), formResubmissionCallback);
        } else {
            formResubmissionCallback.defaultBehaviour(null);
        }
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onPageCommitVisible(WebView webView, String str) {
        WebViewChannelDelegate webViewChannelDelegate = ((InAppWebView) webView).channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onPageCommitVisible(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.isLoading = false;
        loadCustomJavaScriptOnPageFinished(inAppWebView);
        previousAuthRequestFailureCount = 0;
        credentialsProposed = null;
        super.onPageFinished(webView, str);
        InAppBrowserDelegate inAppBrowserDelegate = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate != null) {
            inAppBrowserDelegate.didFinishNavigation(str);
        }
        CookieManager.getInstance().flush();
        inAppWebView.evaluateJavascript(JavaScriptBridgeJS.PLATFORM_READY_JS_SOURCE, null);
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onLoadStop(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.isLoading = true;
        inAppWebView.disposeWebMessageChannels();
        inAppWebView.userContentController.resetContentWorlds();
        loadCustomJavaScriptOnPageStarted(inAppWebView);
        super.onPageStarted(webView, str, bitmap);
        InAppBrowserDelegate inAppBrowserDelegate = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate != null) {
            inAppBrowserDelegate.didStartNavigation(str);
        }
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onLoadStart(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0048  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceivedClientCertRequest(final android.webkit.WebView r9, final android.webkit.ClientCertRequest r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getUrl()
            java.lang.String r2 = r10.getHost()
            int r5 = r10.getPort()
            if (r0 == 0) goto L21
            java.net.URI r1 = new java.net.URI     // Catch: java.net.URISyntaxException -> L19
            r1.<init>(r0)     // Catch: java.net.URISyntaxException -> L19
            java.lang.String r0 = r1.getScheme()     // Catch: java.net.URISyntaxException -> L19
        L17:
            r3 = r0
            goto L24
        L19:
            r0 = move-exception
            java.lang.String r1 = "IAWebViewClientCompat"
            java.lang.String r3 = ""
            android.util.Log.e(r1, r3, r0)
        L21:
            java.lang.String r0 = "https"
            goto L17
        L24:
            com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace r1 = new com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace
            android.net.http.SslCertificate r6 = r9.getCertificate()
            r4 = 0
            r7 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            com.pichillilorenzo.flutter_inappwebview_android.types.ClientCertChallenge r0 = new com.pichillilorenzo.flutter_inappwebview_android.types.ClientCertChallenge
            java.security.Principal[] r2 = r10.getPrincipals()
            java.lang.String[] r3 = r10.getKeyTypes()
            r0.<init>(r1, r2, r3)
            r1 = r9
            com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView r1 = (com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView) r1
            com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat$4 r2 = new com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat$4
            r2.<init>()
            com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate r9 = r1.channelDelegate
            if (r9 == 0) goto L4c
            r9.onReceivedClientCertRequest(r0, r2)
            goto L50
        L4c:
            r9 = 0
            r2.defaultBehaviour(r9)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.onReceivedClientCertRequest(android.webkit.WebView, android.webkit.ClientCertRequest):void");
    }

    @Override // androidx.webkit.WebViewClientCompat
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, p pVar) {
        int i4;
        String str;
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (webResourceRequest.isForMainFrame()) {
            if (inAppWebView.customSettings.disableDefaultErrorPage.booleanValue()) {
                inAppWebView.stopLoading();
                inAppWebView.loadUrl("about:blank");
            }
            inAppWebView.isLoading = false;
            previousAuthRequestFailureCount = 0;
            credentialsProposed = null;
            if (this.inAppBrowserDelegate != null) {
                if (AbstractC0565d.a("WEB_RESOURCE_ERROR_GET_CODE")) {
                    t tVar = (t) pVar;
                    if (tVar.f5892a == null) {
                        C0595C c0595c = y.f5931a;
                        tVar.f5892a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) c0595c.f5856b).convertWebResourceError(Proxy.getInvocationHandler(tVar.f5893b));
                    }
                    i4 = tVar.f5892a.getErrorCode();
                } else {
                    i4 = -1;
                }
                if (AbstractC0565d.a("WEB_RESOURCE_ERROR_GET_DESCRIPTION")) {
                    t tVar2 = (t) pVar;
                    if (tVar2.f5892a == null) {
                        C0595C c0595c2 = y.f5931a;
                        tVar2.f5892a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) c0595c2.f5856b).convertWebResourceError(Proxy.getInvocationHandler(tVar2.f5893b));
                    }
                    str = tVar2.f5892a.getDescription().toString();
                } else {
                    str = "";
                }
                this.inAppBrowserDelegate.didFailNavigation(webResourceRequest.getUrl().toString(), i4, str);
            }
        }
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onReceivedError(WebResourceRequestExt.fromWebResourceRequest(webResourceRequest), WebResourceErrorExt.fromWebResourceError(pVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002d  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceivedHttpAuthRequest(final android.webkit.WebView r14, final android.webkit.HttpAuthHandler r15, final java.lang.String r16, final java.lang.String r17) {
        /*
            r13 = this;
            java.lang.String r0 = r14.getUrl()
            java.lang.String r1 = "https"
            r2 = 0
            if (r0 == 0) goto L21
            java.net.URI r3 = new java.net.URI     // Catch: java.net.URISyntaxException -> L19
            r3.<init>(r0)     // Catch: java.net.URISyntaxException -> L19
            java.lang.String r1 = r3.getScheme()     // Catch: java.net.URISyntaxException -> L19
            int r0 = r3.getPort()     // Catch: java.net.URISyntaxException -> L19
            r11 = r0
            r7 = r1
            goto L23
        L19:
            r0 = move-exception
            java.lang.String r3 = "IAWebViewClientCompat"
            java.lang.String r4 = ""
            android.util.Log.e(r3, r4, r0)
        L21:
            r7 = r1
            r11 = r2
        L23:
            int r0 = com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.previousAuthRequestFailureCount
            int r0 = r0 + 1
            com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.previousAuthRequestFailureCount = r0
            java.util.List<com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential> r0 = com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.credentialsProposed
            if (r0 != 0) goto L44
            android.content.Context r0 = r14.getContext()
            com.pichillilorenzo.flutter_inappwebview_android.credential_database.CredentialDatabase r0 = com.pichillilorenzo.flutter_inappwebview_android.credential_database.CredentialDatabase.getInstance(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            r6 = r16
            r8 = r17
            java.util.List r0 = r0.getHttpAuthCredentials(r6, r7, r8, r1)
            com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.credentialsProposed = r0
            goto L48
        L44:
            r6 = r16
            r8 = r17
        L48:
            java.util.List<com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential> r0 = com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.credentialsProposed
            r1 = 0
            if (r0 == 0) goto L5c
            int r0 = r0.size()
            if (r0 <= 0) goto L5c
            java.util.List<com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential> r0 = com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.credentialsProposed
            java.lang.Object r0 = r0.get(r2)
            com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential r0 = (com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential) r0
            goto L5d
        L5c:
            r0 = r1
        L5d:
            com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace r5 = new com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace
            android.net.http.SslCertificate r10 = r14.getCertificate()
            r9 = r11
            r11 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            com.pichillilorenzo.flutter_inappwebview_android.types.HttpAuthenticationChallenge r2 = new com.pichillilorenzo.flutter_inappwebview_android.types.HttpAuthenticationChallenge
            int r3 = com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.previousAuthRequestFailureCount
            r2.<init>(r5, r3, r0)
            r0 = r14
            com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView r0 = (com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView) r0
            com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat$2 r5 = new com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat$2
            r6 = r13
            r12 = r15
            r8 = r16
            r10 = r17
            r11 = r9
            r9 = r7
            r7 = r14
            r5.<init>()
            com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate r14 = r0.channelDelegate
            if (r14 == 0) goto L88
            r14.onReceivedHttpAuthRequest(r2, r5)
            goto L8b
        L88:
            r5.defaultBehaviour(r1)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.onReceivedHttpAuthRequest(android.webkit.WebView, android.webkit.HttpAuthHandler, java.lang.String, java.lang.String):void");
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewChannelDelegate webViewChannelDelegate = ((InAppWebView) webView).channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onReceivedHttpError(WebResourceRequestExt.fromWebResourceRequest(webResourceRequest), WebResourceResponseExt.fromWebResourceResponse(webResourceResponse));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewChannelDelegate webViewChannelDelegate = ((InAppWebView) webView).channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onReceivedLoginRequest(str, str2, str3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceivedSslError(final android.webkit.WebView r13, final android.webkit.SslErrorHandler r14, final android.net.http.SslError r15) {
        /*
            r12 = this;
            java.lang.String r0 = r15.getUrl()
            java.lang.String r1 = ""
            java.lang.String r2 = "https"
            java.net.URI r3 = new java.net.URI     // Catch: java.net.URISyntaxException -> L1f
            r3.<init>(r0)     // Catch: java.net.URISyntaxException -> L1f
            java.lang.String r4 = r3.getHost()     // Catch: java.net.URISyntaxException -> L1f
            java.lang.String r2 = r3.getScheme()     // Catch: java.net.URISyntaxException -> L1d
            int r0 = r3.getPort()     // Catch: java.net.URISyntaxException -> L1d
        L19:
            r9 = r0
            r7 = r2
            r6 = r4
            goto L28
        L1d:
            r0 = move-exception
            goto L21
        L1f:
            r0 = move-exception
            r4 = r1
        L21:
            java.lang.String r3 = "IAWebViewClientCompat"
            android.util.Log.e(r3, r1, r0)
            r0 = 0
            goto L19
        L28:
            com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace r5 = new com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace
            android.net.http.SslCertificate r10 = r15.getCertificate()
            r8 = 0
            r11 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11)
            com.pichillilorenzo.flutter_inappwebview_android.types.ServerTrustChallenge r15 = new com.pichillilorenzo.flutter_inappwebview_android.types.ServerTrustChallenge
            r15.<init>(r5)
            r0 = r13
            com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView r0 = (com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView) r0
            com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat$3 r1 = new com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat$3
            r1.<init>()
            com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate r13 = r0.channelDelegate
            if (r13 == 0) goto L48
            r13.onReceivedServerTrustAuthRequest(r15, r1)
            goto L4c
        L48:
            r13 = 0
            r1.defaultBehaviour(r13)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.onReceivedSslError(android.webkit.WebView, android.webkit.SslErrorHandler, android.net.http.SslError):void");
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (inAppWebView.customSettings.useOnRenderProcessGone.booleanValue() && inAppWebView.channelDelegate != null) {
            inAppWebView.channelDelegate.onRenderProcessGone(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
            return true;
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // androidx.webkit.WebViewClientCompat
    public void onSafeBrowsingHit(final WebView webView, final WebResourceRequest webResourceRequest, final int i4, final AbstractC0567f abstractC0567f) {
        WebViewChannelDelegate.SafeBrowsingHitCallback safeBrowsingHitCallback = new WebViewChannelDelegate.SafeBrowsingHitCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.5
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, s2.InterfaceC0643o
            public void error(String str, String str2, Object obj) {
                StringBuilder j4 = i.j(str, ", ");
                if (str2 == null) {
                    str2 = "";
                }
                i.r(j4, str2, InAppWebViewClientCompat.LOG_TAG);
                defaultBehaviour((SafeBrowsingResponse) null);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public void defaultBehaviour(SafeBrowsingResponse safeBrowsingResponse) {
                InAppWebViewClientCompat.access$601(InAppWebViewClientCompat.this, webView, webResourceRequest, i4, abstractC0567f);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public boolean nonNullSuccess(SafeBrowsingResponse safeBrowsingResponse) {
                Integer action = safeBrowsingResponse.getAction();
                if (action != null) {
                    boolean isReport = safeBrowsingResponse.isReport();
                    int intValue = action.intValue();
                    if (intValue != 0) {
                        if (intValue != 1) {
                            if (AbstractC0565d.a("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL")) {
                                abstractC0567f.a(isReport);
                                return false;
                            }
                        } else if (AbstractC0565d.a("SAFE_BROWSING_RESPONSE_PROCEED")) {
                            k kVar = (k) abstractC0567f;
                            kVar.getClass();
                            C0597b c0597b = x.f5919n;
                            if (c0597b.a()) {
                                kVar.c().proceed(isReport);
                                return false;
                            }
                            if (c0597b.b()) {
                                kVar.b().proceed(isReport);
                                return false;
                            }
                            throw x.a();
                        }
                    } else if (AbstractC0565d.a("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY")) {
                        k kVar2 = (k) abstractC0567f;
                        kVar2.getClass();
                        C0597b c0597b2 = x.f5918m;
                        if (c0597b2.a()) {
                            kVar2.c().backToSafety(isReport);
                            return false;
                        }
                        if (c0597b2.b()) {
                            kVar2.b().backToSafety(isReport);
                            return false;
                        }
                        throw x.a();
                    }
                }
                return true;
            }
        };
        WebViewChannelDelegate webViewChannelDelegate = ((InAppWebView) webView).channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onSafeBrowsingHit(webResourceRequest.getUrl().toString(), i4, safeBrowsingHitCallback);
        } else {
            safeBrowsingHitCallback.defaultBehaviour(null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f4, float f5) {
        super.onScaleChanged(webView, f4, f5);
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.zoomScale = f5 / Util.getPixelDensity(inAppWebView.getContext());
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onZoomScaleChanged(f4, f5);
        }
    }

    public void onShouldOverrideUrlLoading(final InAppWebView inAppWebView, final String str, String str2, final Map<String, String> map, final boolean z, boolean z3, boolean z4) {
        NavigationAction navigationAction = new NavigationAction(new URLRequest(str, str2, null, map), z, z3, z4);
        WebViewChannelDelegate.ShouldOverrideUrlLoadingCallback shouldOverrideUrlLoadingCallback = new WebViewChannelDelegate.ShouldOverrideUrlLoadingCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewClientCompat.1
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, s2.InterfaceC0643o
            public void error(String str3, String str4, Object obj) {
                StringBuilder j4 = i.j(str3, ", ");
                if (str4 == null) {
                    str4 = "";
                }
                i.r(j4, str4, InAppWebViewClientCompat.LOG_TAG);
                defaultBehaviour((NavigationActionPolicy) null);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public void defaultBehaviour(NavigationActionPolicy navigationActionPolicy) {
                InAppWebViewClientCompat.this.allowShouldOverrideUrlLoading(inAppWebView, str, map, z);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public boolean nonNullSuccess(NavigationActionPolicy navigationActionPolicy) {
                if (AnonymousClass7.$SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$types$NavigationActionPolicy[navigationActionPolicy.ordinal()] != 1) {
                    return false;
                }
                InAppWebViewClientCompat.this.allowShouldOverrideUrlLoading(inAppWebView, str, map, z);
                return false;
            }
        };
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.shouldOverrideUrlLoading(navigationAction, shouldOverrideUrlLoadingCallback);
        } else {
            shouldOverrideUrlLoadingCallback.defaultBehaviour(null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequestExt webResourceRequestExt) {
        CustomSchemeResponse onLoadResourceWithCustomScheme;
        WebResourceResponseExt shouldInterceptRequest;
        InAppWebView inAppWebView = (InAppWebView) webView;
        WebViewAssetLoaderExt webViewAssetLoaderExt = inAppWebView.webViewAssetLoaderExt;
        if (webViewAssetLoaderExt != null && webViewAssetLoaderExt.loader != null) {
            try {
                WebResourceResponse a4 = inAppWebView.webViewAssetLoaderExt.loader.a(Uri.parse(webResourceRequestExt.getUrl()));
                if (a4 != null) {
                    return a4;
                }
            } catch (Exception e4) {
                Log.e(LOG_TAG, "", e4);
            }
        }
        WebResourceResponse webResourceResponse = null;
        if (inAppWebView.customSettings.useShouldInterceptRequest.booleanValue()) {
            WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
            if (webViewChannelDelegate != null) {
                try {
                    shouldInterceptRequest = webViewChannelDelegate.shouldInterceptRequest(webResourceRequestExt);
                } catch (InterruptedException e5) {
                    Log.e(LOG_TAG, "", e5);
                    return null;
                }
            } else {
                shouldInterceptRequest = null;
            }
            if (shouldInterceptRequest == null) {
                return null;
            }
            String contentType = shouldInterceptRequest.getContentType();
            String contentEncoding = shouldInterceptRequest.getContentEncoding();
            byte[] data = shouldInterceptRequest.getData();
            Map<String, String> headers = shouldInterceptRequest.getHeaders();
            Integer statusCode = shouldInterceptRequest.getStatusCode();
            String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
            ByteArrayInputStream byteArrayInputStream = data != null ? new ByteArrayInputStream(data) : null;
            if (statusCode != null && reasonPhrase != null) {
                return new WebResourceResponse(contentType, contentEncoding, statusCode.intValue(), reasonPhrase, headers, byteArrayInputStream);
            }
            return new WebResourceResponse(contentType, contentEncoding, byteArrayInputStream);
        }
        String lowerCase = webResourceRequestExt.getUrl().split(":")[0].toLowerCase();
        try {
            lowerCase = Uri.parse(webResourceRequestExt.getUrl()).getScheme();
        } catch (Exception unused) {
        }
        List<String> list = inAppWebView.customSettings.resourceCustomSchemes;
        if (list != null && list.contains(lowerCase)) {
            WebViewChannelDelegate webViewChannelDelegate2 = inAppWebView.channelDelegate;
            if (webViewChannelDelegate2 != null) {
                try {
                    onLoadResourceWithCustomScheme = webViewChannelDelegate2.onLoadResourceWithCustomScheme(webResourceRequestExt);
                } catch (InterruptedException e6) {
                    Log.e(LOG_TAG, "", e6);
                    return null;
                }
            } else {
                onLoadResourceWithCustomScheme = null;
            }
            if (onLoadResourceWithCustomScheme != null) {
                try {
                    webResourceResponse = inAppWebView.contentBlockerHandler.checkUrl(inAppWebView, webResourceRequestExt, onLoadResourceWithCustomScheme.getContentType());
                } catch (Exception e7) {
                    Log.e(LOG_TAG, "", e7);
                }
                return webResourceResponse != null ? webResourceResponse : new WebResourceResponse(onLoadResourceWithCustomScheme.getContentType(), onLoadResourceWithCustomScheme.getContentType(), new ByteArrayInputStream(onLoadResourceWithCustomScheme.getData()));
            }
        }
        if (inAppWebView.contentBlockerHandler.getRuleList().size() <= 0) {
            return null;
        }
        try {
            return inAppWebView.contentBlockerHandler.checkUrl(inAppWebView, webResourceRequestExt);
        } catch (Exception e8) {
            Log.e(LOG_TAG, "", e8);
            return null;
        }
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean isRedirect;
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (!inAppWebView.customSettings.useShouldOverrideUrlLoading.booleanValue()) {
            return false;
        }
        if (AbstractC0565d.a("WEB_RESOURCE_REQUEST_IS_REDIRECT")) {
            x.f5917l.getClass();
            isRedirect = webResourceRequest.isRedirect();
        } else {
            isRedirect = webResourceRequest.isRedirect();
        }
        onShouldOverrideUrlLoading(inAppWebView, webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders(), webResourceRequest.isForMainFrame(), webResourceRequest.hasGesture(), isRedirect);
        if (inAppWebView.regexToCancelSubFramesLoadingCompiled != null) {
            if (webResourceRequest.isForMainFrame()) {
                return true;
            }
            return inAppWebView.regexToCancelSubFramesLoadingCompiled.matcher(webResourceRequest.getUrl().toString()).matches();
        }
        return webResourceRequest.isForMainFrame();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (!inAppWebView.customSettings.useShouldOverrideUrlLoading.booleanValue()) {
            return false;
        }
        onShouldOverrideUrlLoading(inAppWebView, str, "GET", null, true, false, false);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return shouldInterceptRequest(webView, new WebResourceRequestExt(str, null, false, false, true, "GET"));
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldInterceptRequest(webView, WebResourceRequestExt.fromWebResourceRequest(webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i4, String str, String str2) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (inAppWebView.customSettings.disableDefaultErrorPage.booleanValue()) {
            inAppWebView.stopLoading();
            inAppWebView.loadUrl("about:blank");
        }
        inAppWebView.isLoading = false;
        previousAuthRequestFailureCount = 0;
        credentialsProposed = null;
        InAppBrowserDelegate inAppBrowserDelegate = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate != null) {
            inAppBrowserDelegate.didFailNavigation(str2, i4, str);
        }
        WebResourceRequestExt webResourceRequestExt = new WebResourceRequestExt(str2, null, false, false, true, "GET");
        WebResourceErrorExt webResourceErrorExt = new WebResourceErrorExt(i4, str);
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onReceivedError(webResourceRequestExt, webResourceErrorExt);
        }
        super.onReceivedError(webView, i4, str, str2);
    }
}
