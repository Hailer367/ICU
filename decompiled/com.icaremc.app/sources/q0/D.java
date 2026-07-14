package q0;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p0.AbstractC0565d;

/* loaded from: classes.dex */
public final class D extends WebViewRenderProcessClient {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0565d f5857a;

    public D(AbstractC0565d abstractC0565d) {
        this.f5857a = abstractC0565d;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [q0.E, java.lang.Object] */
    public final void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap weakHashMap = E.f5858c;
        E e4 = (E) weakHashMap.get(webViewRenderProcess);
        E e5 = e4;
        if (e4 == null) {
            ?? obj = new Object();
            obj.f5860b = new WeakReference(webViewRenderProcess);
            weakHashMap.put(webViewRenderProcess, obj);
            e5 = obj;
        }
        this.f5857a.onRenderProcessResponsive(webView, e5);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [q0.E, java.lang.Object] */
    public final void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap weakHashMap = E.f5858c;
        E e4 = (E) weakHashMap.get(webViewRenderProcess);
        E e5 = e4;
        if (e4 == null) {
            ?? obj = new Object();
            obj.f5860b = new WeakReference(webViewRenderProcess);
            weakHashMap.put(webViewRenderProcess, obj);
            e5 = obj;
        }
        this.f5857a.onRenderProcessUnresponsive(webView, e5);
    }
}
