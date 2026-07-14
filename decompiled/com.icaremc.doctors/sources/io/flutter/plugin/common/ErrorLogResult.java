package io.flutter.plugin.common;

import com.google.firebase.encoders.json.BuildConfig;
import io.flutter.Log;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes.dex */
public class ErrorLogResult implements MethodChannel.Result {
    private int level;
    private String tag;

    public ErrorLogResult(String str) {
        this(str, Log.WARN);
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void error(String str, String str2, Object obj) {
        String str3;
        if (obj != null) {
            str3 = " details: " + obj;
        } else {
            str3 = BuildConfig.FLAVOR;
        }
        int i2 = this.level;
        if (i2 < Log.WARN) {
            return;
        }
        Log.println(i2, this.tag, str2 + str3);
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void notImplemented() {
        int i2 = this.level;
        if (i2 < Log.WARN) {
            return;
        }
        Log.println(i2, this.tag, "method not implemented");
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void success(Object obj) {
    }

    public ErrorLogResult(String str, int i2) {
        this.tag = str;
        this.level = i2;
    }
}
