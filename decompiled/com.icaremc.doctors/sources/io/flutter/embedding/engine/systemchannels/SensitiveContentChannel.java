package io.flutter.embedding.engine.systemchannels;

import android.annotation.SuppressLint;
import com.google.firebase.messaging.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;

/* loaded from: classes.dex */
public class SensitiveContentChannel {
    public static final int AUTO_SENSITIVE_CONTENT_SENSITIVITY = 0;
    public static final int NOT_SENSITIVE_CONTENT_SENSITIVITY = 2;
    public static final int SENSITIVE_CONTENT_SENSITIVITY = 1;
    private static final String TAG = "SensitiveContentChannel";
    public static final int UNKNOWN_CONTENT_SENSITIVITY = 3;
    public final MethodChannel channel;
    public final MethodChannel.MethodCallHandler parsingMethodHandler;
    private SensitiveContentMethodHandler sensitiveContentMethodHandler;

    /* loaded from: classes.dex */
    public interface SensitiveContentMethodHandler {
        int getContentSensitivity();

        boolean isSupported();

        void setContentSensitivity(int i2);
    }

    public SensitiveContentChannel(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.SensitiveContentChannel.1
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (SensitiveContentChannel.this.sensitiveContentMethodHandler != null) {
                    String str = methodCall.method;
                    Log.v(SensitiveContentChannel.TAG, "Received '" + str + "' message.");
                    str.getClass();
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case -1937987631:
                            if (str.equals("SensitiveContent.getContentSensitivity")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 598223325:
                            if (str.equals("SensitiveContent.setContentSensitivity")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1615625817:
                            if (str.equals("SensitiveContent.isSupported")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            try {
                                result.success(Integer.valueOf(SensitiveContentChannel.this.serializeContentSensitivity(SensitiveContentChannel.this.sensitiveContentMethodHandler.getContentSensitivity())));
                                return;
                            } catch (IllegalArgumentException | IllegalStateException e2) {
                                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e2.getMessage(), null);
                                return;
                            }
                        case 1:
                            try {
                                SensitiveContentChannel.this.sensitiveContentMethodHandler.setContentSensitivity(SensitiveContentChannel.this.deserializeContentSensitivity(((Integer) methodCall.arguments()).intValue()));
                                return;
                            } catch (IllegalArgumentException | IllegalStateException e3) {
                                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e3.getMessage(), null);
                                return;
                            }
                        case 2:
                            result.success(Boolean.valueOf(SensitiveContentChannel.this.sensitiveContentMethodHandler.isSupported()));
                            return;
                        default:
                            Log.v(SensitiveContentChannel.TAG, "Method " + str + " is not implemented for the SensitiveContentChannel.");
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/sensitivecontent", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"InlinedApi"})
    public int deserializeContentSensitivity(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
            throw new IllegalArgumentException("contentSensitivityIndex " + i2 + " not known to the SensitiveContentChannel.");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"InlinedApi"})
    public int serializeContentSensitivity(int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                return 3;
            }
        }
        return i3;
    }

    public void setSensitiveContentMethodHandler(SensitiveContentMethodHandler sensitiveContentMethodHandler) {
        this.sensitiveContentMethodHandler = sensitiveContentMethodHandler;
    }
}
