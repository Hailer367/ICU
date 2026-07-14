package Z0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: Z0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0140f extends AbstractC0142a {
    public static final Parcelable.Creator<C0140f> CREATOR = new L.g(9);

    /* renamed from: f, reason: collision with root package name */
    public final int f2131f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2132g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2133h;

    /* renamed from: i, reason: collision with root package name */
    public final long f2134i;

    /* renamed from: j, reason: collision with root package name */
    public final long f2135j;
    public final String k;

    /* renamed from: l, reason: collision with root package name */
    public final String f2136l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2137m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2138n;

    public C0140f(int i4, int i5, int i6, long j4, long j5, String str, String str2, int i7, int i8) {
        this.f2131f = i4;
        this.f2132g = i5;
        this.f2133h = i6;
        this.f2134i = j4;
        this.f2135j = j5;
        this.k = str;
        this.f2136l = str2;
        this.f2137m = i7;
        this.f2138n = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f2131f);
        AbstractC0141a.P(parcel, 2, 4);
        parcel.writeInt(this.f2132g);
        AbstractC0141a.P(parcel, 3, 4);
        parcel.writeInt(this.f2133h);
        AbstractC0141a.P(parcel, 4, 8);
        parcel.writeLong(this.f2134i);
        AbstractC0141a.P(parcel, 5, 8);
        parcel.writeLong(this.f2135j);
        AbstractC0141a.M(parcel, 6, this.k);
        AbstractC0141a.M(parcel, 7, this.f2136l);
        AbstractC0141a.P(parcel, 8, 4);
        parcel.writeInt(this.f2137m);
        AbstractC0141a.P(parcel, 9, 4);
        parcel.writeInt(this.f2138n);
        AbstractC0141a.S(parcel, Q2);
    }
}
