package io.flutter.embedding.engine.systemchannels;

import com.google.firebase.messaging.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PlatformViewsChannel2 {
    private static final String TAG = "PlatformViewsChannel2";
    private final MethodChannel channel;
    private PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler;

    /* loaded from: classes.dex */
    public interface PlatformViewsHandler {
        void clearFocus(int i2);

        void createPlatformView(PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i2);

        boolean isSurfaceControlEnabled();

        void onTouch(PlatformViewTouch platformViewTouch);

        void setDirection(int i2, int i3);
    }

    public PlatformViewsChannel2(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.1
            private void clearFocus(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel2.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                    result.success(null);
                } catch (IllegalStateException e2) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e2), null);
                }
            }

            private void create(MethodCall methodCall, MethodChannel.Result result) {
                ByteBuffer byteBuffer;
                Map map = (Map) methodCall.arguments();
                if (map.containsKey("params")) {
                    byteBuffer = ByteBuffer.wrap((byte[]) map.get("params"));
                } else {
                    byteBuffer = null;
                }
                try {
                    PlatformViewsChannel2.this.handler.createPlatformView(PlatformViewCreationRequest.createHCPPRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), ((Integer) map.get("direction")).intValue(), byteBuffer));
                    result.success(null);
                } catch (IllegalStateException e2) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e2), null);
                }
            }

            private void dispose(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel2.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get("id")).intValue());
                    result.success(null);
                } catch (IllegalStateException e2) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e2), null);
                }
            }

            private void isSurfaceControlEnabled(MethodCall methodCall, MethodChannel.Result result) {
                result.success(Boolean.valueOf(PlatformViewsChannel2.this.handler.isSurfaceControlEnabled()));
            }

            private void setDirection(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel2.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                    result.success(null);
                } catch (IllegalStateException e2) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e2), null);
                }
            }

            private void touch(MethodCall methodCall, MethodChannel.Result result) {
                List list = (List) methodCall.arguments();
                try {
                    PlatformViewsChannel2.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                    result.success(null);
                } catch (IllegalStateException e2) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e2), null);
                }
            }

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (PlatformViewsChannel2.this.handler == null) {
                    return;
                }
                Log.v(PlatformViewsChannel2.TAG, "Received '" + methodCall.method + "' message.");
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
                    case -756050293:
                        if (str.equals("clearFocus")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 110550847:
                        if (str.equals("touch")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 576796989:
                        if (str.equals("setDirection")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 751366695:
                        if (str.equals("isSurfaceControlEnabled")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1671767583:
                        if (str.equals("dispose")) {
                            c2 = 5;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        create(methodCall, result);
                        return;
                    case 1:
                        clearFocus(methodCall, result);
                        return;
                    case 2:
                        touch(methodCall, result);
                        return;
                    case 3:
                        setDirection(methodCall, result);
                        return;
                    case 4:
                        isSurfaceControlEnabled(methodCall, result);
                        return;
                    case 5:
                        dispose(methodCall, result);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        };
        this.parsingHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views_2", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
