package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import com.google.firebase.messaging.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes.dex */
public class ScribeChannel {
    public static final String METHOD_IS_FEATURE_AVAILABLE = "Scribe.isFeatureAvailable";
    public static final String METHOD_IS_STYLUS_HANDWRITING_AVAILABLE = "Scribe.isStylusHandwritingAvailable";
    public static final String METHOD_START_STYLUS_HANDWRITING = "Scribe.startStylusHandwriting";
    private static final String TAG = "ScribeChannel";
    public final MethodChannel channel;
    public final MethodChannel.MethodCallHandler parsingMethodHandler;
    private ScribeMethodHandler scribeMethodHandler;

    /* loaded from: classes.dex */
    public interface ScribeMethodHandler {
        boolean isFeatureAvailable();

        boolean isStylusHandwritingAvailable();

        void startStylusHandwriting();
    }

    public ScribeChannel(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.ScribeChannel.1
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (ScribeChannel.this.scribeMethodHandler == null) {
                    Log.v(ScribeChannel.TAG, "No ScribeMethodHandler registered. Scribe call not handled.");
                    return;
                }
                String str = methodCall.method;
                Log.v(ScribeChannel.TAG, "Received '" + str + "' message.");
                str.getClass();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -705821951:
                        if (str.equals(ScribeChannel.METHOD_IS_FEATURE_AVAILABLE)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1759284829:
                        if (str.equals(ScribeChannel.METHOD_START_STYLUS_HANDWRITING)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 2119738044:
                        if (str.equals(ScribeChannel.METHOD_IS_STYLUS_HANDWRITING_AVAILABLE)) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        ScribeChannel.this.isFeatureAvailable(methodCall, result);
                        return;
                    case 1:
                        ScribeChannel.this.startStylusHandwriting(methodCall, result);
                        return;
                    case 2:
                        ScribeChannel.this.isStylusHandwritingAvailable(methodCall, result);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/scribe", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isFeatureAvailable(MethodCall methodCall, MethodChannel.Result result) {
        try {
            result.success(Boolean.valueOf(this.scribeMethodHandler.isFeatureAvailable()));
        } catch (IllegalStateException e2) {
            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e2.getMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isStylusHandwritingAvailable(MethodCall methodCall, MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT < 34) {
            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Requires API level 34 or higher.", null);
            return;
        }
        try {
            result.success(Boolean.valueOf(this.scribeMethodHandler.isStylusHandwritingAvailable()));
        } catch (IllegalStateException e2) {
            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e2.getMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startStylusHandwriting(MethodCall methodCall, MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT < 33) {
            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Requires API level 33 or higher.", null);
            return;
        }
        try {
            this.scribeMethodHandler.startStylusHandwriting();
            result.success(null);
        } catch (IllegalStateException e2) {
            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e2.getMessage(), null);
        }
    }

    public void setScribeMethodHandler(ScribeMethodHandler scribeMethodHandler) {
        this.scribeMethodHandler = scribeMethodHandler;
    }
}
