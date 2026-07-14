package io.flutter.embedding.engine.systemchannels;

import com.google.firebase.messaging.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PlatformViewsChannel {
    private static final String TAG = "PlatformViewsChannel";
    private final MethodChannel channel;
    private PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler;

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements MethodChannel.MethodCallHandler {
        public AnonymousClass1() {
        }

        private void clearFocus(MethodCall methodCall, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void create(MethodCall methodCall, MethodChannel.Result result) {
            boolean z;
            ByteBuffer byteBuffer;
            boolean z2;
            double d2;
            Map map = (Map) methodCall.arguments();
            if (map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            if (map.containsKey("params")) {
                byteBuffer = ByteBuffer.wrap((byte[]) map.get("params"));
            } else {
                byteBuffer = null;
            }
            try {
                if (z) {
                    PlatformViewsChannel.this.handler.createForPlatformViewLayer(PlatformViewCreationRequest.createHybridCompositionRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), ((Integer) map.get("direction")).intValue(), byteBuffer));
                    result.success(null);
                    return;
                }
                if (map.containsKey("hybridFallback") && ((Boolean) map.get("hybridFallback")).booleanValue()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int intValue = ((Integer) map.get("id")).intValue();
                String str = (String) map.get("viewType");
                double d3 = 0.0d;
                if (map.containsKey("top")) {
                    d2 = ((Double) map.get("top")).doubleValue();
                } else {
                    d2 = 0.0d;
                }
                if (map.containsKey("left")) {
                    d3 = ((Double) map.get("left")).doubleValue();
                }
                long createForTextureLayer = PlatformViewsChannel.this.handler.createForTextureLayer(PlatformViewCreationRequest.createTLHCWithFallbackRequest(intValue, str, d2, d3, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z2, byteBuffer));
                if (createForTextureLayer == -2) {
                    if (z2) {
                        result.success(null);
                        return;
                    }
                    throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                }
                result.success(Long.valueOf(createForTextureLayer));
            } catch (IllegalStateException e2) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void dispose(MethodCall methodCall, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get("id")).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        public static /* synthetic */ void lambda$resize$0(MethodChannel.Result result, PlatformViewBufferSize platformViewBufferSize) {
            if (platformViewBufferSize == null) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Failed to resize the platform view", null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("width", Double.valueOf(platformViewBufferSize.width));
            hashMap.put("height", Double.valueOf(platformViewBufferSize.height));
            result.success(hashMap);
        }

        private void offset(MethodCall methodCall, MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.offset(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void resize(MethodCall methodCall, MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.resize(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new a(result));
            } catch (IllegalStateException e2) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void setDirection(MethodCall methodCall, MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void synchronizeToNativeViewHierarchy(MethodCall methodCall, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void touch(MethodCall methodCall, MethodChannel.Result result) {
            List list = (List) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            if (PlatformViewsChannel.this.handler == null) {
                return;
            }
            Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
            String str = methodCall.method;
            str.getClass();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1352294148:
                    if (str.equals("create")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1019779949:
                    if (str.equals("offset")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -756050293:
                    if (str.equals("clearFocus")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -308988850:
                    if (str.equals("synchronizeToNativeViewHierarchy")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 110550847:
                    if (str.equals("touch")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 576796989:
                    if (str.equals("setDirection")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    create(methodCall, result);
                    return;
                case 1:
                    offset(methodCall, result);
                    return;
                case 2:
                    resize(methodCall, result);
                    return;
                case 3:
                    clearFocus(methodCall, result);
                    return;
                case 4:
                    synchronizeToNativeViewHierarchy(methodCall, result);
                    return;
                case 5:
                    touch(methodCall, result);
                    return;
                case 6:
                    setDirection(methodCall, result);
                    return;
                case 7:
                    dispose(methodCall, result);
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface PlatformViewBufferResized {
        void run(PlatformViewBufferSize platformViewBufferSize);
    }

    /* loaded from: classes.dex */
    public static class PlatformViewBufferSize {
        public final int height;
        public final int width;

        public PlatformViewBufferSize(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }
    }

    /* loaded from: classes.dex */
    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i2, double d2, double d3) {
            this.viewId = i2;
            this.newLogicalWidth = d2;
            this.newLogicalHeight = d3;
        }
    }

    /* loaded from: classes.dex */
    public interface PlatformViewsHandler {
        public static final long NON_TEXTURE_FALLBACK = -2;

        void clearFocus(int i2);

        void createForPlatformViewLayer(PlatformViewCreationRequest platformViewCreationRequest);

        long createForTextureLayer(PlatformViewCreationRequest platformViewCreationRequest);

        void createPlatformViewHcpp(PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i2);

        boolean isHcppEnabled();

        void offset(int i2, double d2, double d3);

        void onTouch(PlatformViewTouch platformViewTouch);

        void resize(PlatformViewResizeRequest platformViewResizeRequest, PlatformViewBufferResized platformViewBufferResized);

        void setDirection(int i2, int i3);

        void synchronizeToNativeViewHierarchy(boolean z);
    }

    public PlatformViewsChannel(DartExecutor dartExecutor) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.parsingHandler = anonymousClass1;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(anonymousClass1);
    }

    public static String detailedExceptionString(Exception exc) {
        return Log.getStackTraceString(exc);
    }

    public void invokeViewFocused(int i2) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            return;
        }
        methodChannel.invokeMethod("viewFocused", Integer.valueOf(i2));
    }

    public void setPlatformViewsHandler(PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}
