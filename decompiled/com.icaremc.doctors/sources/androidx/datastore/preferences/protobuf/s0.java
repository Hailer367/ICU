package androidx.datastore.preferences.protobuf;

import com.google.firebase.encoders.json.BuildConfig;
import java.io.Serializable;

/* loaded from: classes.dex */
public enum s0 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(BuildConfig.FLAVOR),
    BYTE_STRING(C0080g.f1417e),
    ENUM(null),
    MESSAGE(null);


    /* renamed from: c, reason: collision with root package name */
    public final Object f1489c;

    s0(Serializable serializable) {
        this.f1489c = serializable;
    }
}
