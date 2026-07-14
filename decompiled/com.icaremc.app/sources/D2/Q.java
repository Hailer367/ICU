package D2;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes.dex */
public final class Q extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f317a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S f318b;

    public Q(S s3, WebView webView) {
        this.f318b = s3;
        this.f317a = webView;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.f318b.f319a;
        WebView webView2 = this.f317a;
        if (!webViewClient.shouldOverrideUrlLoading(webView2, webResourceRequest)) {
            webView2.loadUrl(webResourceRequest.getUrl().toString());
            return true;
        }
        return true;
    }
}
