package io.flutter.plugin.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import io.flutter.embedding.engine.systemchannels.SensitiveContentChannel;

/* loaded from: classes.dex */
public class SensitiveContentPlugin implements SensitiveContentChannel.SensitiveContentMethodHandler {
    private Activity mFlutterActivity;
    private final int mFlutterViewId;
    private final SensitiveContentChannel mSensitiveContentChannel;

    public SensitiveContentPlugin(int i2, Activity activity, SensitiveContentChannel sensitiveContentChannel) {
        this.mFlutterActivity = activity;
        this.mFlutterViewId = i2;
        this.mSensitiveContentChannel = sensitiveContentChannel;
        sensitiveContentChannel.setSensitiveContentMethodHandler(this);
    }

    private String getFlutterViewNotFoundErrorReason() {
        return "FlutterView with ID " + this.mFlutterViewId + "not found";
    }

    private String getNotSupportedErrorReason() {
        return "isSupported() should be called before attempting to set content sensitivity as it is not supported on this device.";
    }

    public void destroy() {
        this.mSensitiveContentChannel.setSensitiveContentMethodHandler(null);
        this.mFlutterActivity = null;
    }

    @Override // io.flutter.embedding.engine.systemchannels.SensitiveContentChannel.SensitiveContentMethodHandler
    @SuppressLint({"NewApi"})
    public int getContentSensitivity() {
        int contentSensitivity;
        if (!isSupported()) {
            return 2;
        }
        View findViewById = this.mFlutterActivity.findViewById(this.mFlutterViewId);
        if (findViewById != null) {
            contentSensitivity = findViewById.getContentSensitivity();
            return contentSensitivity;
        }
        throw new IllegalArgumentException(getFlutterViewNotFoundErrorReason());
    }

    @Override // io.flutter.embedding.engine.systemchannels.SensitiveContentChannel.SensitiveContentMethodHandler
    public boolean isSupported() {
        if (Build.VERSION.SDK_INT >= 35) {
            return true;
        }
        return false;
    }

    @Override // io.flutter.embedding.engine.systemchannels.SensitiveContentChannel.SensitiveContentMethodHandler
    @SuppressLint({"NewApi"})
    public void setContentSensitivity(int i2) {
        int contentSensitivity;
        if (isSupported()) {
            View findViewById = this.mFlutterActivity.findViewById(this.mFlutterViewId);
            if (findViewById != null) {
                contentSensitivity = findViewById.getContentSensitivity();
                if (contentSensitivity != i2) {
                    findViewById.setContentSensitivity(i2);
                    findViewById.invalidate();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(getFlutterViewNotFoundErrorReason());
        }
        throw new IllegalStateException(getNotSupportedErrorReason());
    }
}
