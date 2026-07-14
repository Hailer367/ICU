package com.pichillilorenzo.flutter_inappwebview_android.service_worker;

import android.util.Log;
import android.webkit.ServiceWorkerController;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceResponseExt;
import java.io.ByteArrayInputStream;
import java.util.Map;
import p0.AbstractC0565d;
import p0.AbstractC0569h;
import p0.AbstractC0570i;
import p0.AbstractC0571j;
import q0.f;
import q0.m;
import q0.x;
import s2.C0644p;

/* loaded from: classes.dex */
public class ServiceWorkerManager implements Disposable {
    protected static final String LOG_TAG = "ServiceWorkerManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_serviceworkercontroller";
    public static AbstractC0571j serviceWorkerController;
    public ServiceWorkerChannelDelegate channelDelegate;
    public InAppWebViewFlutterPlugin plugin;

    /* loaded from: classes.dex */
    public static final class DummyServiceWorkerClientCompat extends AbstractC0569h {
        static final AbstractC0569h INSTANCE = new DummyServiceWorkerClientCompat();

        private DummyServiceWorkerClientCompat() {
        }

        @Override // p0.AbstractC0569h
        public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
            return null;
        }
    }

    public ServiceWorkerManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        this.channelDelegate = new ServiceWorkerChannelDelegate(this, new C0644p(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
    }

    private AbstractC0569h dummyServiceWorkerClientCompat() {
        return DummyServiceWorkerClientCompat.INSTANCE;
    }

    public static void init() {
        if (serviceWorkerController == null && AbstractC0565d.a("SERVICE_WORKER_BASIC_USAGE")) {
            serviceWorkerController = AbstractC0570i.f5801a;
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        ServiceWorkerChannelDelegate serviceWorkerChannelDelegate = this.channelDelegate;
        if (serviceWorkerChannelDelegate != null) {
            serviceWorkerChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.plugin = null;
    }

    public void setServiceWorkerClient(Boolean bool) {
        AbstractC0569h abstractC0569h;
        AbstractC0571j abstractC0571j = serviceWorkerController;
        if (abstractC0571j != null) {
            if (bool.booleanValue()) {
                abstractC0569h = dummyServiceWorkerClientCompat();
            } else {
                abstractC0569h = new AbstractC0569h() { // from class: com.pichillilorenzo.flutter_inappwebview_android.service_worker.ServiceWorkerManager.1
                    @Override // p0.AbstractC0569h
                    public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
                        WebResourceResponseExt shouldInterceptRequest;
                        WebResourceRequestExt fromWebResourceRequest = WebResourceRequestExt.fromWebResourceRequest(webResourceRequest);
                        ServiceWorkerChannelDelegate serviceWorkerChannelDelegate = ServiceWorkerManager.this.channelDelegate;
                        ByteArrayInputStream byteArrayInputStream = null;
                        if (serviceWorkerChannelDelegate != null) {
                            try {
                                shouldInterceptRequest = serviceWorkerChannelDelegate.shouldInterceptRequest(fromWebResourceRequest);
                            } catch (InterruptedException e4) {
                                Log.e(ServiceWorkerManager.LOG_TAG, "", e4);
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
                        if (data != null) {
                            byteArrayInputStream = new ByteArrayInputStream(data);
                        }
                        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        if (statusCode != null && reasonPhrase != null) {
                            return new WebResourceResponse(contentType, contentEncoding, statusCode.intValue(), reasonPhrase, headers, byteArrayInputStream2);
                        }
                        return new WebResourceResponse(contentType, contentEncoding, byteArrayInputStream2);
                    }
                };
            }
            m mVar = (m) abstractC0571j;
            x.f5913g.getClass();
            if (abstractC0569h == null) {
                if (mVar.f5875a == null) {
                    mVar.f5875a = ServiceWorkerController.getInstance();
                }
                mVar.f5875a.setServiceWorkerClient(null);
            } else {
                if (mVar.f5875a == null) {
                    mVar.f5875a = ServiceWorkerController.getInstance();
                }
                mVar.f5875a.setServiceWorkerClient(new f(abstractC0569h));
            }
        }
    }
}
