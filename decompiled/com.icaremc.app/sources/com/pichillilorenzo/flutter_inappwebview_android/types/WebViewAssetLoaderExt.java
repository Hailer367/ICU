package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.util.Log;
import android.webkit.WebResourceResponse;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p0.s;
import p0.u;
import r2.k;
import s2.C0644p;

/* loaded from: classes.dex */
public class WebViewAssetLoaderExt implements Disposable {
    public List<PathHandlerExt> customPathHandlers;
    public u loader;

    /* loaded from: classes.dex */
    public static class PathHandlerExt implements s, Disposable {
        protected static final String LOG_TAG = "PathHandlerExt";
        public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappwebview_custompathhandler_";
        public PathHandlerExtChannelDelegate channelDelegate;
        public String id;

        public PathHandlerExt(String str, InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
            this.id = str;
            this.channelDelegate = new PathHandlerExtChannelDelegate(this, new C0644p(inAppWebViewFlutterPlugin.messenger, k.d(METHOD_CHANNEL_NAME_PREFIX, str)));
        }

        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
        public void dispose() {
            PathHandlerExtChannelDelegate pathHandlerExtChannelDelegate = this.channelDelegate;
            if (pathHandlerExtChannelDelegate != null) {
                pathHandlerExtChannelDelegate.dispose();
                this.channelDelegate = null;
            }
        }

        @Override // p0.s
        public WebResourceResponse handle(String str) {
            PathHandlerExtChannelDelegate pathHandlerExtChannelDelegate = this.channelDelegate;
            ByteArrayInputStream byteArrayInputStream = null;
            if (pathHandlerExtChannelDelegate != null) {
                try {
                    WebResourceResponseExt handle = pathHandlerExtChannelDelegate.handle(str);
                    if (handle != null) {
                        String contentType = handle.getContentType();
                        String contentEncoding = handle.getContentEncoding();
                        byte[] data = handle.getData();
                        Map<String, String> headers = handle.getHeaders();
                        Integer statusCode = handle.getStatusCode();
                        String reasonPhrase = handle.getReasonPhrase();
                        if (data != null) {
                            byteArrayInputStream = new ByteArrayInputStream(data);
                        }
                        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        if (statusCode != null && reasonPhrase != null) {
                            return new WebResourceResponse(contentType, contentEncoding, statusCode.intValue(), reasonPhrase, headers, byteArrayInputStream2);
                        }
                        return new WebResourceResponse(contentType, contentEncoding, byteArrayInputStream2);
                    }
                } catch (InterruptedException e4) {
                    Log.e(LOG_TAG, "", e4);
                }
            }
            return null;
        }
    }

    public WebViewAssetLoaderExt(u uVar, List<PathHandlerExt> list) {
        this.loader = uVar;
        this.customPathHandlers = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        switch(r10) {
            case 0: goto L59;
            case 1: goto L58;
            case 2: goto L57;
            default: goto L61;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
    
        r5 = (java.lang.String) r5.get("directory");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
    
        if (r5 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
    
        r0.add(new H.b(r7, new p0.r(r13, new java.io.File(r5))));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ca, code lost:
    
        r0.add(new H.b(r7, new p0.r(r13, 0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d9, code lost:
    
        r0.add(new H.b(r7, new p0.r(r13, 1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008f, code lost:
    
        r5 = (java.lang.String) r5.get("id");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0097, code lost:
    
        if (r5 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009a, code lost:
    
        r6 = new com.pichillilorenzo.flutter_inappwebview_android.types.WebViewAssetLoaderExt.PathHandlerExt(r5, r12);
        r0.add(new H.b(r7, r6));
        r3.add(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.pichillilorenzo.flutter_inappwebview_android.types.WebViewAssetLoaderExt fromMap(java.util.Map<java.lang.String, java.lang.Object> r11, com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin r12, android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview_android.types.WebViewAssetLoaderExt.fromMap(java.util.Map, com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin, android.content.Context):com.pichillilorenzo.flutter_inappwebview_android.types.WebViewAssetLoaderExt");
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        Iterator<PathHandlerExt> it = this.customPathHandlers.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
        this.customPathHandlers.clear();
    }

    /* loaded from: classes.dex */
    public static class PathHandlerExtChannelDelegate extends ChannelDelegateImpl {
        private PathHandlerExt pathHandler;

        /* loaded from: classes.dex */
        public static class HandleCallback extends BaseCallbackResultImpl<WebResourceResponseExt> {
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public WebResourceResponseExt decodeResult(Object obj) {
                return WebResourceResponseExt.fromMap((Map) obj);
            }
        }

        /* loaded from: classes.dex */
        public static class SyncHandleCallback extends SyncBaseCallbackResultImpl<WebResourceResponseExt> {
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public WebResourceResponseExt decodeResult(Object obj) {
                return new HandleCallback().decodeResult(obj);
            }
        }

        public PathHandlerExtChannelDelegate(PathHandlerExt pathHandlerExt, C0644p c0644p) {
            super(c0644p);
            this.pathHandler = pathHandlerExt;
        }

        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
        public void dispose() {
            super.dispose();
            this.pathHandler = null;
        }

        public void handle(String str, HandleCallback handleCallback) {
            C0644p channel = getChannel();
            if (channel == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("path", str);
            channel.a("handle", hashMap, handleCallback);
        }

        public WebResourceResponseExt handle(String str) {
            C0644p channel = getChannel();
            if (channel == null) {
                return null;
            }
            SyncHandleCallback syncHandleCallback = new SyncHandleCallback();
            HashMap hashMap = new HashMap();
            hashMap.put("path", str);
            return (WebResourceResponseExt) Util.invokeMethodAndWaitResult(channel, "handle", hashMap, syncHandleCallback);
        }
    }
}
