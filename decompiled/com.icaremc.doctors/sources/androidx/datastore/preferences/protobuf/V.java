package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0074a f1380a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1381b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f1382c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1383d;

    public V(AbstractC0095w abstractC0095w, String str, Object[] objArr) {
        this.f1380a = abstractC0095w;
        this.f1381b = str;
        this.f1382c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f1383d = charAt;
            return;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 >= 55296) {
                i2 |= (charAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            } else {
                this.f1383d = i2 | (charAt2 << i3);
                return;
            }
        }
    }

    public final int a() {
        int i2 = this.f1383d;
        if ((i2 & 1) != 0) {
            return 1;
        }
        if ((i2 & 4) == 4) {
            return 3;
        }
        return 2;
    }
}
