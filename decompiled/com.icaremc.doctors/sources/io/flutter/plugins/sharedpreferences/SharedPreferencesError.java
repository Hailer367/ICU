package io.flutter.plugins.sharedpreferences;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class SharedPreferencesError extends Throwable {
    private final String code;
    private final Object details;
    private final String message;

    public SharedPreferencesError(String code, String str, Object obj) {
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

    public /* synthetic */ SharedPreferencesError(String str, String str2, Object obj, int i2, e eVar) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : obj);
    }
}
