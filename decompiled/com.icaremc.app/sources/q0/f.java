package q0;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import p0.AbstractC0569h;

/* loaded from: classes.dex */
public final class f extends ServiceWorkerClient {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0569h f5866a;

    public f(AbstractC0569h abstractC0569h) {
        this.f5866a = abstractC0569h;
    }

    @Override // android.webkit.ServiceWorkerClient
    public final WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        return this.f5866a.shouldInterceptRequest(webResourceRequest);
    }
}
