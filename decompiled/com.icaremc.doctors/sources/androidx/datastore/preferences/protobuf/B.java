package androidx.datastore.preferences.protobuf;

import com.google.firebase.encoders.json.BuildConfig;
import java.io.Serializable;

/* loaded from: classes.dex */
public enum B {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, BuildConfig.FLAVOR),
    BYTE_STRING(C0080g.class, C0080g.f1417e),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);


    /* renamed from: c, reason: collision with root package name */
    public final Object f1338c;

    B(Class cls, Serializable serializable) {
        this.f1338c = serializable;
    }
}
