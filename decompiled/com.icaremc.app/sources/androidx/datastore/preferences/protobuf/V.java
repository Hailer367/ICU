package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0144a f2599a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2600b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f2601c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2602d;

    public V(AbstractC0165w abstractC0165w, String str, Object[] objArr) {
        this.f2599a = abstractC0165w;
        this.f2600b = str;
        this.f2601c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f2602d = charAt;
            return;
        }
        int i4 = charAt & 8191;
        int i5 = 13;
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char charAt2 = str.charAt(i6);
            if (charAt2 >= 55296) {
                i4 |= (charAt2 & 8191) << i5;
                i5 += 13;
                i6 = i7;
            } else {
                this.f2602d = i4 | (charAt2 << i5);
                return;
            }
        }
    }

    public final int a() {
        int i4 = this.f2602d;
        if ((i4 & 1) != 0) {
            return 1;
        }
        if ((i4 & 4) == 4) {
            return 3;
        }
        return 2;
    }
}
