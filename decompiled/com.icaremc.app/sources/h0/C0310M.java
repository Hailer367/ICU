package h0;

/* renamed from: h0.M, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0310M {

    /* renamed from: a, reason: collision with root package name */
    public int f3855a;

    /* renamed from: b, reason: collision with root package name */
    public int f3856b;

    /* renamed from: c, reason: collision with root package name */
    public int f3857c;

    /* renamed from: d, reason: collision with root package name */
    public int f3858d;

    /* renamed from: e, reason: collision with root package name */
    public int f3859e;

    public final boolean a() {
        int i4;
        int i5;
        int i6;
        int i7 = this.f3855a;
        int i8 = 2;
        if ((i7 & 7) != 0) {
            int i9 = this.f3858d;
            int i10 = this.f3856b;
            if (i9 > i10) {
                i6 = 1;
            } else if (i9 == i10) {
                i6 = 2;
            } else {
                i6 = 4;
            }
            if ((i6 & i7) == 0) {
                return false;
            }
        }
        if ((i7 & 112) != 0) {
            int i11 = this.f3858d;
            int i12 = this.f3857c;
            if (i11 > i12) {
                i5 = 1;
            } else if (i11 == i12) {
                i5 = 2;
            } else {
                i5 = 4;
            }
            if (((i5 << 4) & i7) == 0) {
                return false;
            }
        }
        if ((i7 & 1792) != 0) {
            int i13 = this.f3859e;
            int i14 = this.f3856b;
            if (i13 > i14) {
                i4 = 1;
            } else if (i13 == i14) {
                i4 = 2;
            } else {
                i4 = 4;
            }
            if (((i4 << 8) & i7) == 0) {
                return false;
            }
        }
        if ((i7 & 28672) != 0) {
            int i15 = this.f3859e;
            int i16 = this.f3857c;
            if (i15 > i16) {
                i8 = 1;
            } else if (i15 != i16) {
                i8 = 4;
            }
            if ((i7 & (i8 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
