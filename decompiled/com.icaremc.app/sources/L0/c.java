package L0;

/* loaded from: classes.dex */
public enum c implements F1.c {
    REASON_UNKNOWN(0),
    MESSAGE_TOO_OLD(1),
    CACHE_FULL(2),
    PAYLOAD_TOO_BIG(3),
    MAX_RETRIES_REACHED(4),
    INVALID_PAYLOD(5),
    SERVER_ERROR(6);


    /* renamed from: f, reason: collision with root package name */
    public final int f990f;

    c(int i4) {
        this.f990f = i4;
    }

    @Override // F1.c
    public final int a() {
        return this.f990f;
    }
}
