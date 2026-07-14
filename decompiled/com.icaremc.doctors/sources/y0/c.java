package y0;

import com.google.firebase.encoders.proto.ProtoEnum;

/* loaded from: classes.dex */
public enum c implements ProtoEnum {
    REASON_UNKNOWN(0),
    MESSAGE_TOO_OLD(1),
    CACHE_FULL(2),
    PAYLOAD_TOO_BIG(3),
    MAX_RETRIES_REACHED(4),
    INVALID_PAYLOD(5),
    SERVER_ERROR(6);


    /* renamed from: c, reason: collision with root package name */
    public final int f3998c;

    c(int i2) {
        this.f3998c = i2;
    }

    @Override // com.google.firebase.encoders.proto.ProtoEnum
    public final int getNumber() {
        return this.f3998c;
    }
}
