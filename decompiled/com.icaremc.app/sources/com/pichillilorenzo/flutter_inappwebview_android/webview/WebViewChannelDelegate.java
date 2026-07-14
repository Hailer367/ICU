package com.pichillilorenzo.flutter_inappwebview_android.webview;

import R.j;
import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserSettings;
import com.pichillilorenzo.flutter_inappwebview_android.print_job.PrintJobSettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ClientCertChallenge;
import com.pichillilorenzo.flutter_inappwebview_android.types.ClientCertResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.ContentWorld;
import com.pichillilorenzo.flutter_inappwebview_android.types.CreateWindowAction;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomSchemeResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.DownloadStartRequest;
import com.pichillilorenzo.flutter_inappwebview_android.types.GeolocationPermissionShowPromptResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.HitTestResult;
import com.pichillilorenzo.flutter_inappwebview_android.types.HttpAuthResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.HttpAuthenticationChallenge;
import com.pichillilorenzo.flutter_inappwebview_android.types.JsAlertResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.JsBeforeUnloadResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.JsConfirmResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.JsPromptResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.NavigationAction;
import com.pichillilorenzo.flutter_inappwebview_android.types.NavigationActionPolicy;
import com.pichillilorenzo.flutter_inappwebview_android.types.PermissionResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.SafeBrowsingResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.ServerTrustAuthResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.ServerTrustChallenge;
import com.pichillilorenzo.flutter_inappwebview_android.types.SslCertificateExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.SyncBaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview_android.types.UserScript;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessageCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePortCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceErrorExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceResponseExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewSettings;
import com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageChannel;
import com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p0.AbstractC0565d;
import p0.n;
import p0.o;
import p0.w;
import q0.C0597b;
import q0.x;
import q0.z;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class WebViewChannelDelegate extends ChannelDelegateImpl {
    static final String LOG_TAG = "WebViewChannelDelegate";
    private InAppWebView webView;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate$8, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods;

        static {
            int[] iArr = new int[WebViewChannelDelegateMethods.values().length];
            $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods = iArr;
            try {
                iArr[WebViewChannelDelegateMethods.getUrl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getTitle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getProgress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.loadUrl.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.postUrl.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.loadData.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.loadFile.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.evaluateJavascript.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.injectJavascriptFileFromUrl.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.injectCSSCode.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.injectCSSFileFromUrl.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.reload.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.goBack.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canGoBack.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.goForward.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canGoForward.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.goBackOrForward.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canGoBackOrForward.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.stopLoading.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.isLoading.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.takeScreenshot.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.setSettings.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getSettings.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.close.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.show.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.hide.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.isHidden.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getCopyBackForwardList.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.startSafeBrowsing.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearCache.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearSslPreferences.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.findAll.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.findNext.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearMatches.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.scrollTo.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.scrollBy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.pause.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.resume.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.pauseTimers.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.resumeTimers.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.printCurrentPage.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getContentHeight.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getContentWidth.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.zoomBy.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getOriginalUrl.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getZoomScale.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getSelectedText.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getHitTestResult.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.pageDown.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.pageUp.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.saveWebArchive.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.zoomIn.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.zoomOut.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearFocus.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.setContextMenu.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.requestFocusNodeHref.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.requestImageRef.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getScrollX.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getScrollY.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getCertificate.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearHistory.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.addUserScript.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.removeUserScript.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.removeUserScriptsByGroupName.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.removeAllUserScripts.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.callAsyncJavaScript.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.isSecureContext.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.createWebMessageChannel.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.postWebMessage.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.addWebMessageListener.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canScrollVertically.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canScrollHorizontally.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.isInFullscreen.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearFormData.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CallJsHandlerCallback extends BaseCallbackResultImpl<Object> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Object decodeResult(Object obj) {
            return obj;
        }
    }

    /* loaded from: classes.dex */
    public static class CreateWindowCallback extends BaseCallbackResultImpl<Boolean> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Boolean decodeResult(Object obj) {
            return Boolean.valueOf((obj instanceof Boolean) && ((Boolean) obj).booleanValue());
        }
    }

    /* loaded from: classes.dex */
    public static class FormResubmissionCallback extends BaseCallbackResultImpl<Integer> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Integer decodeResult(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class GeolocationPermissionsShowPromptCallback extends BaseCallbackResultImpl<GeolocationPermissionShowPromptResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public GeolocationPermissionShowPromptResponse decodeResult(Object obj) {
            return GeolocationPermissionShowPromptResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class JsAlertCallback extends BaseCallbackResultImpl<JsAlertResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public JsAlertResponse decodeResult(Object obj) {
            return JsAlertResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class JsBeforeUnloadCallback extends BaseCallbackResultImpl<JsBeforeUnloadResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public JsBeforeUnloadResponse decodeResult(Object obj) {
            return JsBeforeUnloadResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class JsConfirmCallback extends BaseCallbackResultImpl<JsConfirmResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public JsConfirmResponse decodeResult(Object obj) {
            return JsConfirmResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class JsPromptCallback extends BaseCallbackResultImpl<JsPromptResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public JsPromptResponse decodeResult(Object obj) {
            return JsPromptResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class LoadResourceWithCustomSchemeCallback extends BaseCallbackResultImpl<CustomSchemeResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public CustomSchemeResponse decodeResult(Object obj) {
            return CustomSchemeResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class PermissionRequestCallback extends BaseCallbackResultImpl<PermissionResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public PermissionResponse decodeResult(Object obj) {
            return PermissionResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class PrintRequestCallback extends BaseCallbackResultImpl<Boolean> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Boolean decodeResult(Object obj) {
            return Boolean.valueOf((obj instanceof Boolean) && ((Boolean) obj).booleanValue());
        }
    }

    /* loaded from: classes.dex */
    public static class ReceivedClientCertRequestCallback extends BaseCallbackResultImpl<ClientCertResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public ClientCertResponse decodeResult(Object obj) {
            return ClientCertResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class ReceivedHttpAuthRequestCallback extends BaseCallbackResultImpl<HttpAuthResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public HttpAuthResponse decodeResult(Object obj) {
            return HttpAuthResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class ReceivedServerTrustAuthRequestCallback extends BaseCallbackResultImpl<ServerTrustAuthResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public ServerTrustAuthResponse decodeResult(Object obj) {
            return ServerTrustAuthResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class RenderProcessResponsiveCallback extends BaseCallbackResultImpl<Integer> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Integer decodeResult(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class RenderProcessUnresponsiveCallback extends BaseCallbackResultImpl<Integer> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Integer decodeResult(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class SafeBrowsingHitCallback extends BaseCallbackResultImpl<SafeBrowsingResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public SafeBrowsingResponse decodeResult(Object obj) {
            return SafeBrowsingResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class ShouldInterceptRequestCallback extends BaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return WebResourceResponseExt.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class ShouldOverrideUrlLoadingCallback extends BaseCallbackResultImpl<NavigationActionPolicy> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public NavigationActionPolicy decodeResult(Object obj) {
            return NavigationActionPolicy.fromValue(obj instanceof Integer ? ((Integer) obj).intValue() : NavigationActionPolicy.CANCEL.rawValue());
        }
    }

    /* loaded from: classes.dex */
    public static class SyncLoadResourceWithCustomSchemeCallback extends SyncBaseCallbackResultImpl<CustomSchemeResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public CustomSchemeResponse decodeResult(Object obj) {
            return new LoadResourceWithCustomSchemeCallback().decodeResult(obj);
        }
    }

    /* loaded from: classes.dex */
    public static class SyncShouldInterceptRequestCallback extends SyncBaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return new ShouldInterceptRequestCallback().decodeResult(obj);
        }
    }

    public WebViewChannelDelegate(InAppWebView inAppWebView, C0644p c0644p) {
        super(c0644p);
        this.webView = inAppWebView;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.webView = null;
    }

    public void onCallJsHandler(String str, String str2, CallJsHandlerCallback callJsHandlerCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            callJsHandlerCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("handlerName", str);
        hashMap.put("args", str2);
        channel.a("onCallJsHandler", hashMap, callJsHandlerCallback);
    }

    public void onCloseWindow() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onCloseWindow", new HashMap(), null);
    }

    public void onConsoleMessage(String str, int i4) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("message", str);
        hashMap.put("messageLevel", Integer.valueOf(i4));
        channel.a("onConsoleMessage", hashMap, null);
    }

    public void onContextMenuActionItemClicked(int i4, String str) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i4));
        hashMap.put("androidId", Integer.valueOf(i4));
        hashMap.put("iosId", null);
        hashMap.put("title", str);
        channel.a("onContextMenuActionItemClicked", hashMap, null);
    }

    public void onCreateContextMenu(HitTestResult hitTestResult) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onCreateContextMenu", hitTestResult.toMap(), null);
    }

    public void onCreateWindow(CreateWindowAction createWindowAction, CreateWindowCallback createWindowCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            createWindowCallback.defaultBehaviour(null);
        } else {
            channel.a("onCreateWindow", createWindowAction.toMap(), createWindowCallback);
        }
    }

    public void onDownloadStartRequest(DownloadStartRequest downloadStartRequest) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onDownloadStartRequest", downloadStartRequest.toMap(), null);
    }

    public void onEnterFullscreen() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onEnterFullscreen", new HashMap(), null);
    }

    public void onExitFullscreen() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onExitFullscreen", new HashMap(), null);
    }

    @Deprecated
    public void onFindResultReceived(int i4, int i5, boolean z) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("activeMatchOrdinal", Integer.valueOf(i4));
        hashMap.put("numberOfMatches", Integer.valueOf(i5));
        hashMap.put("isDoneCounting", Boolean.valueOf(z));
        channel.a("onFindResultReceived", hashMap, null);
    }

    public void onFormResubmission(String str, FormResubmissionCallback formResubmissionCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            formResubmissionCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        channel.a("onFormResubmission", hashMap, formResubmissionCallback);
    }

    public void onGeolocationPermissionsHidePrompt() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onGeolocationPermissionsHidePrompt", new HashMap(), null);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsShowPromptCallback geolocationPermissionsShowPromptCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            geolocationPermissionsShowPromptCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("origin", str);
        channel.a("onGeolocationPermissionsShowPrompt", hashMap, geolocationPermissionsShowPromptCallback);
    }

    public void onHideContextMenu() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onHideContextMenu", new HashMap(), null);
    }

    public void onJsAlert(String str, String str2, Boolean bool, JsAlertCallback jsAlertCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            jsAlertCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("isMainFrame", bool);
        channel.a("onJsAlert", hashMap, jsAlertCallback);
    }

    public void onJsBeforeUnload(String str, String str2, JsBeforeUnloadCallback jsBeforeUnloadCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            jsBeforeUnloadCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        channel.a("onJsBeforeUnload", hashMap, jsBeforeUnloadCallback);
    }

    public void onJsConfirm(String str, String str2, Boolean bool, JsConfirmCallback jsConfirmCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            jsConfirmCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("isMainFrame", bool);
        channel.a("onJsConfirm", hashMap, jsConfirmCallback);
    }

    public void onJsPrompt(String str, String str2, String str3, Boolean bool, JsPromptCallback jsPromptCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            jsPromptCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("defaultValue", str3);
        hashMap.put("isMainFrame", bool);
        channel.a("onJsPrompt", hashMap, jsPromptCallback);
    }

    public void onLoadResourceWithCustomScheme(WebResourceRequestExt webResourceRequestExt, LoadResourceWithCustomSchemeCallback loadResourceWithCustomSchemeCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            loadResourceWithCustomSchemeCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request", webResourceRequestExt.toMap());
        channel.a("onLoadResourceWithCustomScheme", hashMap, loadResourceWithCustomSchemeCallback);
    }

    public void onLoadStart(String str) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        channel.a("onLoadStart", hashMap, null);
    }

    public void onLoadStop(String str) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        channel.a("onLoadStop", hashMap, null);
    }

    public void onLongPressHitTestResult(HitTestResult hitTestResult) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onLongPressHitTestResult", hitTestResult.toMap(), null);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, final InterfaceC0643o interfaceC0643o) {
        String str;
        try {
            boolean z = true;
            Object obj = null;
            switch (AnonymousClass8.$SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.valueOf(c0641m.f6155a).ordinal()]) {
                case 1:
                    InAppWebView inAppWebView = this.webView;
                    if (inAppWebView != null) {
                        obj = inAppWebView.getUrl();
                    }
                    interfaceC0643o.success(obj);
                    return;
                case 2:
                    InAppWebView inAppWebView2 = this.webView;
                    if (inAppWebView2 != null) {
                        obj = inAppWebView2.getTitle();
                    }
                    interfaceC0643o.success(obj);
                    return;
                case 3:
                    InAppWebView inAppWebView3 = this.webView;
                    if (inAppWebView3 != null) {
                        obj = Integer.valueOf(inAppWebView3.getProgress());
                    }
                    interfaceC0643o.success(obj);
                    return;
                case 4:
                    if (this.webView != null) {
                        this.webView.loadUrl(URLRequest.fromMap((Map) c0641m.a("urlRequest")));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 5:
                    if (this.webView != null) {
                        this.webView.postUrl((String) c0641m.a("url"), (byte[]) c0641m.a("postData"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 6:
                    if (this.webView != null) {
                        this.webView.loadDataWithBaseURL((String) c0641m.a("baseUrl"), (String) c0641m.a("data"), (String) c0641m.a("mimeType"), (String) c0641m.a("encoding"), (String) c0641m.a("historyUrl"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case j.DOUBLE_FIELD_NUMBER /* 7 */:
                    if (this.webView != null) {
                        try {
                            this.webView.loadFile((String) c0641m.a("assetFilePath"));
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            interfaceC0643o.error(LOG_TAG, e4.getMessage(), null);
                            return;
                        }
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case j.BYTES_FIELD_NUMBER /* 8 */:
                    if (this.webView != null) {
                        this.webView.evaluateJavascript((String) c0641m.a("source"), ContentWorld.fromMap((Map) c0641m.a("contentWorld")), new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.1
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str2) {
                                interfaceC0643o.success(str2);
                            }
                        });
                        return;
                    }
                    interfaceC0643o.success(null);
                    return;
                case 9:
                    if (this.webView != null) {
                        this.webView.injectJavascriptFileFromUrl((String) c0641m.a("urlFile"), (Map) c0641m.a("scriptHtmlTagAttributes"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 10:
                    if (this.webView != null) {
                        this.webView.injectCSSCode((String) c0641m.a("source"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 11:
                    if (this.webView != null) {
                        this.webView.injectCSSFileFromUrl((String) c0641m.a("urlFile"), (Map) c0641m.a("cssLinkHtmlTagAttributes"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 12:
                    InAppWebView inAppWebView4 = this.webView;
                    if (inAppWebView4 != null) {
                        inAppWebView4.reload();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 13:
                    InAppWebView inAppWebView5 = this.webView;
                    if (inAppWebView5 != null) {
                        inAppWebView5.goBack();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 14:
                    InAppWebView inAppWebView6 = this.webView;
                    if (inAppWebView6 == null || !inAppWebView6.canGoBack()) {
                        z = false;
                    }
                    interfaceC0643o.success(Boolean.valueOf(z));
                    return;
                case 15:
                    InAppWebView inAppWebView7 = this.webView;
                    if (inAppWebView7 != null) {
                        inAppWebView7.goForward();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 16:
                    InAppWebView inAppWebView8 = this.webView;
                    if (inAppWebView8 == null || !inAppWebView8.canGoForward()) {
                        z = false;
                    }
                    interfaceC0643o.success(Boolean.valueOf(z));
                    return;
                case 17:
                    InAppWebView inAppWebView9 = this.webView;
                    if (inAppWebView9 != null) {
                        inAppWebView9.goBackOrForward(((Integer) c0641m.a("steps")).intValue());
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 18:
                    InAppWebView inAppWebView10 = this.webView;
                    if (inAppWebView10 == null || !inAppWebView10.canGoBackOrForward(((Integer) c0641m.a("steps")).intValue())) {
                        z = false;
                    }
                    interfaceC0643o.success(Boolean.valueOf(z));
                    return;
                case 19:
                    InAppWebView inAppWebView11 = this.webView;
                    if (inAppWebView11 != null) {
                        inAppWebView11.stopLoading();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 20:
                    InAppWebView inAppWebView12 = this.webView;
                    if (inAppWebView12 == null || !inAppWebView12.isLoading()) {
                        z = false;
                    }
                    interfaceC0643o.success(Boolean.valueOf(z));
                    return;
                case 21:
                    if (this.webView != null) {
                        this.webView.takeScreenshot((Map) c0641m.a("screenshotConfiguration"), interfaceC0643o);
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 22:
                    InAppWebView inAppWebView13 = this.webView;
                    if (inAppWebView13 != null && (inAppWebView13.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                        InAppBrowserActivity inAppBrowserActivity = (InAppBrowserActivity) this.webView.getInAppBrowserDelegate();
                        InAppBrowserSettings inAppBrowserSettings = new InAppBrowserSettings();
                        HashMap<String, Object> hashMap = (HashMap) c0641m.a("settings");
                        inAppBrowserSettings.parse2((Map<String, Object>) hashMap);
                        inAppBrowserActivity.setSettings(inAppBrowserSettings, hashMap);
                    } else if (this.webView != null) {
                        InAppWebViewSettings inAppWebViewSettings = new InAppWebViewSettings();
                        HashMap<String, Object> hashMap2 = (HashMap) c0641m.a("settings");
                        inAppWebViewSettings.parse2((Map<String, Object>) hashMap2);
                        this.webView.setSettings(inAppWebViewSettings, hashMap2);
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 23:
                    InAppWebView inAppWebView14 = this.webView;
                    if (inAppWebView14 != null && (inAppWebView14.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                        interfaceC0643o.success(((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).getCustomSettings());
                        return;
                    }
                    InAppWebView inAppWebView15 = this.webView;
                    if (inAppWebView15 != null) {
                        obj = inAppWebView15.getCustomSettings();
                    }
                    interfaceC0643o.success(obj);
                    return;
                case 24:
                    InAppWebView inAppWebView16 = this.webView;
                    if (inAppWebView16 != null && (inAppWebView16.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                        ((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).close(interfaceC0643o);
                        return;
                    } else {
                        interfaceC0643o.notImplemented();
                        return;
                    }
                case 25:
                    InAppWebView inAppWebView17 = this.webView;
                    if (inAppWebView17 != null && (inAppWebView17.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                        ((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).show();
                        interfaceC0643o.success(Boolean.TRUE);
                        return;
                    } else {
                        interfaceC0643o.notImplemented();
                        return;
                    }
                case 26:
                    InAppWebView inAppWebView18 = this.webView;
                    if (inAppWebView18 != null && (inAppWebView18.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                        ((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).hide();
                        interfaceC0643o.success(Boolean.TRUE);
                        return;
                    } else {
                        interfaceC0643o.notImplemented();
                        return;
                    }
                case 27:
                    InAppWebView inAppWebView19 = this.webView;
                    if (inAppWebView19 != null && (inAppWebView19.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                        interfaceC0643o.success(Boolean.valueOf(((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).isHidden));
                        return;
                    } else {
                        interfaceC0643o.notImplemented();
                        return;
                    }
                case 28:
                    InAppWebView inAppWebView20 = this.webView;
                    if (inAppWebView20 != null) {
                        obj = inAppWebView20.getCopyBackForwardList();
                    }
                    interfaceC0643o.success(obj);
                    return;
                case 29:
                    if (this.webView != null && AbstractC0565d.a("START_SAFE_BROWSING")) {
                        Context context = this.webView.getContext();
                        ValueCallback<Boolean> valueCallback = new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.2
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(Boolean bool) {
                                interfaceC0643o.success(bool);
                            }
                        };
                        Uri uri = w.f5818a;
                        C0597b c0597b = x.f5909c;
                        if (c0597b.a()) {
                            WebView.startSafeBrowsing(context, valueCallback);
                            return;
                        } else {
                            if (c0597b.b()) {
                                z.f5932a.getStatics().initSafeBrowsing(context, valueCallback);
                                return;
                            }
                            throw x.a();
                        }
                    }
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                case 30:
                    InAppWebView inAppWebView21 = this.webView;
                    if (inAppWebView21 != null) {
                        inAppWebView21.clearAllCache();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 31:
                    InAppWebView inAppWebView22 = this.webView;
                    if (inAppWebView22 != null) {
                        inAppWebView22.clearSslPreferences();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 32:
                    if (this.webView != null) {
                        this.webView.findAllAsync((String) c0641m.a("find"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 33:
                    if (this.webView != null) {
                        this.webView.findNext(((Boolean) c0641m.a("forward")).booleanValue());
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 34:
                    InAppWebView inAppWebView23 = this.webView;
                    if (inAppWebView23 != null) {
                        inAppWebView23.clearMatches();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 35:
                    if (this.webView != null) {
                        this.webView.scrollTo((Integer) c0641m.a("x"), (Integer) c0641m.a("y"), (Boolean) c0641m.a("animated"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 36:
                    if (this.webView != null) {
                        this.webView.scrollBy((Integer) c0641m.a("x"), (Integer) c0641m.a("y"), (Boolean) c0641m.a("animated"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 37:
                    InAppWebView inAppWebView24 = this.webView;
                    if (inAppWebView24 != null) {
                        inAppWebView24.onPause();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 38:
                    InAppWebView inAppWebView25 = this.webView;
                    if (inAppWebView25 != null) {
                        inAppWebView25.onResume();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 39:
                    InAppWebView inAppWebView26 = this.webView;
                    if (inAppWebView26 != null) {
                        inAppWebView26.pauseTimers();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 40:
                    InAppWebView inAppWebView27 = this.webView;
                    if (inAppWebView27 != null) {
                        inAppWebView27.resumeTimers();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 41:
                    if (this.webView != null) {
                        PrintJobSettings printJobSettings = new PrintJobSettings();
                        Map<String, Object> map = (Map) c0641m.a("settings");
                        if (map != null) {
                            printJobSettings.parse2(map);
                        }
                        interfaceC0643o.success(this.webView.printCurrentPage(printJobSettings));
                        return;
                    }
                    interfaceC0643o.success(null);
                    return;
                case 42:
                    InAppWebView inAppWebView28 = this.webView;
                    if (inAppWebView28 != null) {
                        interfaceC0643o.success(Integer.valueOf(inAppWebView28.getContentHeight()));
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 43:
                    InAppWebView inAppWebView29 = this.webView;
                    if (inAppWebView29 != null) {
                        inAppWebView29.getContentWidth(new ValueCallback<Integer>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.3
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(Integer num) {
                                interfaceC0643o.success(num);
                            }
                        });
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 44:
                    if (this.webView != null) {
                        this.webView.zoomBy((float) ((Double) c0641m.a("zoomFactor")).doubleValue());
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 45:
                    InAppWebView inAppWebView30 = this.webView;
                    if (inAppWebView30 != null) {
                        obj = inAppWebView30.getOriginalUrl();
                    }
                    interfaceC0643o.success(obj);
                    return;
                case 46:
                    InAppWebView inAppWebView31 = this.webView;
                    if (inAppWebView31 != null) {
                        interfaceC0643o.success(Float.valueOf(inAppWebView31.getZoomScale()));
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 47:
                    InAppWebView inAppWebView32 = this.webView;
                    if (inAppWebView32 != null) {
                        inAppWebView32.getSelectedText(new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.4
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str2) {
                                interfaceC0643o.success(str2);
                            }
                        });
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 48:
                    InAppWebView inAppWebView33 = this.webView;
                    if (inAppWebView33 != null) {
                        interfaceC0643o.success(HitTestResult.fromWebViewHitTestResult(inAppWebView33.getHitTestResult()).toMap());
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 49:
                    if (this.webView != null) {
                        interfaceC0643o.success(Boolean.valueOf(this.webView.pageDown(((Boolean) c0641m.a("bottom")).booleanValue())));
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 50:
                    if (this.webView != null) {
                        interfaceC0643o.success(Boolean.valueOf(this.webView.pageUp(((Boolean) c0641m.a("top")).booleanValue())));
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 51:
                    if (this.webView != null) {
                        this.webView.saveWebArchive((String) c0641m.a("filePath"), ((Boolean) c0641m.a("autoname")).booleanValue(), new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.5
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str2) {
                                interfaceC0643o.success(str2);
                            }
                        });
                        return;
                    }
                    interfaceC0643o.success(null);
                    return;
                case 52:
                    InAppWebView inAppWebView34 = this.webView;
                    if (inAppWebView34 != null) {
                        interfaceC0643o.success(Boolean.valueOf(inAppWebView34.zoomIn()));
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 53:
                    InAppWebView inAppWebView35 = this.webView;
                    if (inAppWebView35 != null) {
                        interfaceC0643o.success(Boolean.valueOf(inAppWebView35.zoomOut()));
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 54:
                    InAppWebView inAppWebView36 = this.webView;
                    if (inAppWebView36 != null) {
                        inAppWebView36.clearFocus();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 55:
                    if (this.webView != null) {
                        this.webView.setContextMenu((Map) c0641m.a("contextMenu"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 56:
                    InAppWebView inAppWebView37 = this.webView;
                    if (inAppWebView37 != null) {
                        interfaceC0643o.success(inAppWebView37.requestFocusNodeHref());
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 57:
                    InAppWebView inAppWebView38 = this.webView;
                    if (inAppWebView38 != null) {
                        interfaceC0643o.success(inAppWebView38.requestImageRef());
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 58:
                    InAppWebView inAppWebView39 = this.webView;
                    if (inAppWebView39 != null) {
                        interfaceC0643o.success(Integer.valueOf(inAppWebView39.getScrollX()));
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 59:
                    InAppWebView inAppWebView40 = this.webView;
                    if (inAppWebView40 != null) {
                        interfaceC0643o.success(Integer.valueOf(inAppWebView40.getScrollY()));
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 60:
                    InAppWebView inAppWebView41 = this.webView;
                    if (inAppWebView41 != null) {
                        interfaceC0643o.success(SslCertificateExt.toMap(inAppWebView41.getCertificate()));
                        return;
                    } else {
                        interfaceC0643o.success(null);
                        return;
                    }
                case 61:
                    InAppWebView inAppWebView42 = this.webView;
                    if (inAppWebView42 != null) {
                        inAppWebView42.clearHistory();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 62:
                    InAppWebView inAppWebView43 = this.webView;
                    if (inAppWebView43 != null && inAppWebView43.getUserContentController() != null) {
                        interfaceC0643o.success(Boolean.valueOf(this.webView.getUserContentController().addUserOnlyScript(UserScript.fromMap((Map) c0641m.a("userScript")))));
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 63:
                    InAppWebView inAppWebView44 = this.webView;
                    if (inAppWebView44 != null && inAppWebView44.getUserContentController() != null) {
                        interfaceC0643o.success(Boolean.valueOf(this.webView.getUserContentController().removeUserOnlyScriptAt(((Integer) c0641m.a("index")).intValue(), UserScript.fromMap((Map) c0641m.a("userScript")).getInjectionTime())));
                        return;
                    }
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                case 64:
                    InAppWebView inAppWebView45 = this.webView;
                    if (inAppWebView45 != null && inAppWebView45.getUserContentController() != null) {
                        this.webView.getUserContentController().removeUserOnlyScriptsByGroupName((String) c0641m.a("groupName"));
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 65:
                    InAppWebView inAppWebView46 = this.webView;
                    if (inAppWebView46 != null && inAppWebView46.getUserContentController() != null) {
                        this.webView.getUserContentController().removeAllUserOnlyScripts();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 66:
                    if (this.webView != null) {
                        this.webView.callAsyncJavaScript((String) c0641m.a("functionBody"), (Map) c0641m.a("arguments"), ContentWorld.fromMap((Map) c0641m.a("contentWorld")), new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.6
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str2) {
                                interfaceC0643o.success(str2);
                            }
                        });
                        return;
                    }
                    interfaceC0643o.success(null);
                    return;
                case 67:
                    InAppWebView inAppWebView47 = this.webView;
                    if (inAppWebView47 != null) {
                        inAppWebView47.isSecureContext(new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.7
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(Boolean bool) {
                                interfaceC0643o.success(bool);
                            }
                        });
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 68:
                    if (this.webView != null) {
                        if (AbstractC0565d.a("CREATE_WEB_MESSAGE_CHANNEL")) {
                            interfaceC0643o.success(this.webView.createCompatWebMessageChannel().toMap());
                            return;
                        } else {
                            interfaceC0643o.success(null);
                            return;
                        }
                    }
                    interfaceC0643o.success(null);
                    return;
                case 69:
                    if (this.webView != null && AbstractC0565d.a("POST_WEB_MESSAGE")) {
                        WebMessageCompatExt fromMap = WebMessageCompatExt.fromMap((Map) c0641m.a("message"));
                        String str2 = (String) c0641m.a("targetOrigin");
                        ArrayList arrayList = new ArrayList();
                        List<WebMessagePortCompatExt> ports = fromMap.getPorts();
                        if (ports != null) {
                            for (WebMessagePortCompatExt webMessagePortCompatExt : ports) {
                                WebMessageChannel webMessageChannel = this.webView.getWebMessageChannels().get(webMessagePortCompatExt.getWebMessageChannelId());
                                if (webMessageChannel != null && this.webView != null) {
                                    arrayList.add(webMessageChannel.compatPorts.get(webMessagePortCompatExt.getIndex()));
                                }
                            }
                        }
                        Object data = fromMap.getData();
                        if (this.webView != null) {
                            try {
                                if (AbstractC0565d.a("WEB_MESSAGE_ARRAY_BUFFER") && data != null && fromMap.getType() == 1) {
                                    w.g(this.webView, new n((byte[]) data, (o[]) arrayList.toArray(new o[0])), Uri.parse(str2));
                                } else {
                                    InAppWebView inAppWebView48 = this.webView;
                                    if (data != null) {
                                        str = data.toString();
                                    } else {
                                        str = null;
                                    }
                                    w.g(inAppWebView48, new n(str, (o[]) arrayList.toArray(new o[0])), Uri.parse(str2));
                                }
                                interfaceC0643o.success(Boolean.TRUE);
                                return;
                            } catch (Exception e5) {
                                interfaceC0643o.error(LOG_TAG, e5.getMessage(), null);
                                return;
                            }
                        }
                        return;
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 70:
                    if (this.webView != null) {
                        Map map2 = (Map) c0641m.a("webMessageListener");
                        InAppWebView inAppWebView49 = this.webView;
                        WebMessageListener fromMap2 = WebMessageListener.fromMap(inAppWebView49, inAppWebView49.getPlugin().messenger, map2);
                        if (this.webView != null && AbstractC0565d.a("WEB_MESSAGE_LISTENER")) {
                            try {
                                this.webView.addWebMessageListener(fromMap2);
                                interfaceC0643o.success(Boolean.TRUE);
                                return;
                            } catch (Exception e6) {
                                interfaceC0643o.error(LOG_TAG, e6.getMessage(), null);
                                return;
                            }
                        }
                        interfaceC0643o.success(Boolean.TRUE);
                        return;
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                case 71:
                    InAppWebView inAppWebView50 = this.webView;
                    if (inAppWebView50 != null) {
                        interfaceC0643o.success(Boolean.valueOf(inAppWebView50.canScrollVertically()));
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 72:
                    InAppWebView inAppWebView51 = this.webView;
                    if (inAppWebView51 != null) {
                        interfaceC0643o.success(Boolean.valueOf(inAppWebView51.canScrollHorizontally()));
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 73:
                    InAppWebView inAppWebView52 = this.webView;
                    if (inAppWebView52 != null) {
                        interfaceC0643o.success(Boolean.valueOf(inAppWebView52.isInFullscreen()));
                        return;
                    } else {
                        interfaceC0643o.success(Boolean.FALSE);
                        return;
                    }
                case 74:
                    InAppWebView inAppWebView53 = this.webView;
                    if (inAppWebView53 != null) {
                        inAppWebView53.clearFormData();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                default:
                    return;
            }
        } catch (IllegalArgumentException unused) {
            interfaceC0643o.notImplemented();
        }
    }

    public void onOverScrolled(int i4, int i5, boolean z, boolean z3) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("x", Integer.valueOf(i4));
        hashMap.put("y", Integer.valueOf(i5));
        hashMap.put("clampedX", Boolean.valueOf(z));
        hashMap.put("clampedY", Boolean.valueOf(z3));
        channel.a("onOverScrolled", hashMap, null);
    }

    public void onPageCommitVisible(String str) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        channel.a("onPageCommitVisible", hashMap, null);
    }

    public void onPermissionRequest(String str, List<String> list, Object obj, PermissionRequestCallback permissionRequestCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            permissionRequestCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("origin", str);
        hashMap.put("resources", list);
        hashMap.put("frame", obj);
        channel.a("onPermissionRequest", hashMap, permissionRequestCallback);
    }

    public void onPermissionRequestCanceled(String str, List<String> list) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("origin", str);
        hashMap.put("resources", list);
        channel.a("onPermissionRequestCanceled", hashMap, null);
    }

    public void onPrintRequest(String str, String str2, PrintRequestCallback printRequestCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            printRequestCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("printJobId", str2);
        channel.a("onPrintRequest", hashMap, printRequestCallback);
    }

    public void onProgressChanged(int i4) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("progress", Integer.valueOf(i4));
        channel.a("onProgressChanged", hashMap, null);
    }

    public void onReceivedClientCertRequest(ClientCertChallenge clientCertChallenge, ReceivedClientCertRequestCallback receivedClientCertRequestCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            receivedClientCertRequestCallback.defaultBehaviour(null);
        } else {
            channel.a("onReceivedClientCertRequest", clientCertChallenge.toMap(), receivedClientCertRequestCallback);
        }
    }

    public void onReceivedError(WebResourceRequestExt webResourceRequestExt, WebResourceErrorExt webResourceErrorExt) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request", webResourceRequestExt.toMap());
        hashMap.put("error", webResourceErrorExt.toMap());
        channel.a("onReceivedError", hashMap, null);
    }

    public void onReceivedHttpAuthRequest(HttpAuthenticationChallenge httpAuthenticationChallenge, ReceivedHttpAuthRequestCallback receivedHttpAuthRequestCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            receivedHttpAuthRequestCallback.defaultBehaviour(null);
        } else {
            channel.a("onReceivedHttpAuthRequest", httpAuthenticationChallenge.toMap(), receivedHttpAuthRequestCallback);
        }
    }

    public void onReceivedHttpError(WebResourceRequestExt webResourceRequestExt, WebResourceResponseExt webResourceResponseExt) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request", webResourceRequestExt.toMap());
        hashMap.put("errorResponse", webResourceResponseExt.toMap());
        channel.a("onReceivedHttpError", hashMap, null);
    }

    public void onReceivedIcon(byte[] bArr) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("icon", bArr);
        channel.a("onReceivedIcon", hashMap, null);
    }

    public void onReceivedLoginRequest(String str, String str2, String str3) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, str);
        hashMap.put("account", str2);
        hashMap.put("args", str3);
        channel.a("onReceivedLoginRequest", hashMap, null);
    }

    public void onReceivedServerTrustAuthRequest(ServerTrustChallenge serverTrustChallenge, ReceivedServerTrustAuthRequestCallback receivedServerTrustAuthRequestCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            receivedServerTrustAuthRequestCallback.defaultBehaviour(null);
        } else {
            channel.a("onReceivedServerTrustAuthRequest", serverTrustChallenge.toMap(), receivedServerTrustAuthRequestCallback);
        }
    }

    public void onReceivedTouchIconUrl(String str, boolean z) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("precomposed", Boolean.valueOf(z));
        channel.a("onReceivedTouchIconUrl", hashMap, null);
    }

    public void onRenderProcessGone(boolean z, int i4) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("didCrash", Boolean.valueOf(z));
        hashMap.put("rendererPriorityAtExit", Integer.valueOf(i4));
        channel.a("onRenderProcessGone", hashMap, null);
    }

    public void onRenderProcessResponsive(String str, RenderProcessResponsiveCallback renderProcessResponsiveCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            renderProcessResponsiveCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        channel.a("onRenderProcessResponsive", hashMap, renderProcessResponsiveCallback);
    }

    public void onRenderProcessUnresponsive(String str, RenderProcessUnresponsiveCallback renderProcessUnresponsiveCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            renderProcessUnresponsiveCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        channel.a("onRenderProcessUnresponsive", hashMap, renderProcessUnresponsiveCallback);
    }

    public void onRequestFocus() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onRequestFocus", new HashMap(), null);
    }

    public void onSafeBrowsingHit(String str, int i4, SafeBrowsingHitCallback safeBrowsingHitCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            safeBrowsingHitCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("threatType", Integer.valueOf(i4));
        channel.a("onSafeBrowsingHit", hashMap, safeBrowsingHitCallback);
    }

    public void onScrollChanged(int i4, int i5) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("x", Integer.valueOf(i4));
        hashMap.put("y", Integer.valueOf(i5));
        channel.a("onScrollChanged", hashMap, null);
    }

    public void onTitleChanged(String str) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("title", str);
        channel.a("onTitleChanged", hashMap, null);
    }

    public void onUpdateVisitedHistory(String str, boolean z) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("isReload", Boolean.valueOf(z));
        channel.a("onUpdateVisitedHistory", hashMap, null);
    }

    public void onZoomScaleChanged(float f4, float f5) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("oldScale", Float.valueOf(f4));
        hashMap.put("newScale", Float.valueOf(f5));
        channel.a("onZoomScaleChanged", hashMap, null);
    }

    public void shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt, ShouldInterceptRequestCallback shouldInterceptRequestCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            shouldInterceptRequestCallback.defaultBehaviour(null);
        } else {
            channel.a("shouldInterceptRequest", webResourceRequestExt.toMap(), shouldInterceptRequestCallback);
        }
    }

    public void shouldOverrideUrlLoading(NavigationAction navigationAction, ShouldOverrideUrlLoadingCallback shouldOverrideUrlLoadingCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            shouldOverrideUrlLoadingCallback.defaultBehaviour(null);
        } else {
            channel.a("shouldOverrideUrlLoading", navigationAction.toMap(), shouldOverrideUrlLoadingCallback);
        }
    }

    public WebResourceResponseExt shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt) {
        C0644p channel = getChannel();
        if (channel == null) {
            return null;
        }
        return (WebResourceResponseExt) Util.invokeMethodAndWaitResult(channel, "shouldInterceptRequest", webResourceRequestExt.toMap(), new SyncShouldInterceptRequestCallback());
    }

    public CustomSchemeResponse onLoadResourceWithCustomScheme(WebResourceRequestExt webResourceRequestExt) {
        C0644p channel = getChannel();
        if (channel == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request", webResourceRequestExt.toMap());
        return (CustomSchemeResponse) Util.invokeMethodAndWaitResult(channel, "onLoadResourceWithCustomScheme", hashMap, new SyncLoadResourceWithCustomSchemeCallback());
    }
}
