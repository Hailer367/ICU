package io.flutter.plugins.imagepicker;

import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class FlutterError extends RuntimeException {
    private final String code;
    private final Object details;
    private final String message;

    public FlutterError(String code, String str, Object obj) {
        h.e(code, "code");
        this.code = code;
        this.message = str;
        this.details = obj;
    }

    public final String getCode() {
        return this.code;
    }

    public final Object getDetails() {
        return this.details;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public /* synthetic */ FlutterError(String str, String str2, Object obj, int i2, kotlin.jvm.internal.e eVar) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : obj);
    }
}
