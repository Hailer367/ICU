package com.pichillilorenzo.flutter_inappwebview_android.service_worker;

import R.j;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.SyncBaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceResponseExt;
import java.util.Map;
import p0.AbstractC0565d;
import p0.AbstractC0571j;
import q0.C0595C;
import q0.m;
import q0.x;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class ServiceWorkerChannelDelegate extends ChannelDelegateImpl {
    private ServiceWorkerManager serviceWorkerManager;

    /* loaded from: classes.dex */
    public static class ShouldInterceptRequestCallback extends BaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return WebResourceResponseExt.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class SyncShouldInterceptRequestCallback extends SyncBaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return new ShouldInterceptRequestCallback().decodeResult(obj);
        }
    }

    public ServiceWorkerChannelDelegate(ServiceWorkerManager serviceWorkerManager, C0644p c0644p) {
        super(c0644p);
        this.serviceWorkerManager = serviceWorkerManager;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.serviceWorkerManager = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        C0595C c0595c;
        ServiceWorkerManager.init();
        AbstractC0571j abstractC0571j = ServiceWorkerManager.serviceWorkerController;
        if (abstractC0571j != null) {
            c0595c = ((m) abstractC0571j).f5877c;
        } else {
            c0595c = null;
        }
        String str = c0641m.f6155a;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1332730774:
                if (str.equals("getAllowContentAccess")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1165005700:
                if (str.equals("setServiceWorkerClient")) {
                    c4 = 1;
                    break;
                }
                break;
            case -563397233:
                if (str.equals("getCacheMode")) {
                    c4 = 2;
                    break;
                }
                break;
            case 674894835:
                if (str.equals("getAllowFileAccess")) {
                    c4 = 3;
                    break;
                }
                break;
            case 985595395:
                if (str.equals("setCacheMode")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1083898794:
                if (str.equals("setBlockNetworkLoads")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1203480182:
                if (str.equals("setAllowContentAccess")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1594928487:
                if (str.equals("setAllowFileAccess")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1694822198:
                if (str.equals("getBlockNetworkLoads")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                if (c0595c != null && AbstractC0565d.a("SERVICE_WORKER_CONTENT_ACCESS")) {
                    x.f5915i.getClass();
                    interfaceC0643o.success(Boolean.valueOf(c0595c.e().getAllowContentAccess()));
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 1:
                if (this.serviceWorkerManager != null) {
                    this.serviceWorkerManager.setServiceWorkerClient((Boolean) c0641m.a("isNull"));
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 2:
                if (c0595c != null && AbstractC0565d.a("SERVICE_WORKER_CACHE_MODE")) {
                    x.f5914h.getClass();
                    interfaceC0643o.success(Integer.valueOf(c0595c.e().getCacheMode()));
                    return;
                } else {
                    interfaceC0643o.success(null);
                    return;
                }
            case 3:
                if (c0595c != null && AbstractC0565d.a("SERVICE_WORKER_FILE_ACCESS")) {
                    x.f5916j.getClass();
                    interfaceC0643o.success(Boolean.valueOf(c0595c.e().getAllowFileAccess()));
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 4:
                if (c0595c != null && AbstractC0565d.a("SERVICE_WORKER_CACHE_MODE")) {
                    int intValue = ((Integer) c0641m.a("mode")).intValue();
                    x.f5914h.getClass();
                    c0595c.e().setCacheMode(intValue);
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case 5:
                if (c0595c != null && AbstractC0565d.a("SERVICE_WORKER_BLOCK_NETWORK_LOADS")) {
                    boolean booleanValue = ((Boolean) c0641m.a("flag")).booleanValue();
                    x.k.getClass();
                    c0595c.e().setBlockNetworkLoads(booleanValue);
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case 6:
                if (c0595c != null && AbstractC0565d.a("SERVICE_WORKER_CONTENT_ACCESS")) {
                    boolean booleanValue2 = ((Boolean) c0641m.a("allow")).booleanValue();
                    x.f5915i.getClass();
                    c0595c.e().setAllowContentAccess(booleanValue2);
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                if (c0595c != null && AbstractC0565d.a("SERVICE_WORKER_FILE_ACCESS")) {
                    boolean booleanValue3 = ((Boolean) c0641m.a("allow")).booleanValue();
                    x.f5916j.getClass();
                    c0595c.e().setAllowFileAccess(booleanValue3);
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case j.BYTES_FIELD_NUMBER /* 8 */:
                if (c0595c != null && AbstractC0565d.a("SERVICE_WORKER_BLOCK_NETWORK_LOADS")) {
                    x.k.getClass();
                    interfaceC0643o.success(Boolean.valueOf(c0595c.e().getBlockNetworkLoads()));
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

    public void shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt, ShouldInterceptRequestCallback shouldInterceptRequestCallback) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("shouldInterceptRequest", webResourceRequestExt.toMap(), shouldInterceptRequestCallback);
    }

    public WebResourceResponseExt shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt) {
        C0644p channel = getChannel();
        if (channel == null) {
            return null;
        }
        return (WebResourceResponseExt) Util.invokeMethodAndWaitResult(channel, "shouldInterceptRequest", webResourceRequestExt.toMap(), new SyncShouldInterceptRequestCallback());
    }
}
