package Z0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class h extends AbstractC0142a {
    public static final Parcelable.Creator<h> CREATOR = new L.g(12);

    /* renamed from: f, reason: collision with root package name */
    public final int f2141f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2142g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2143h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2144i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2145j;

    public h(int i4, boolean z, boolean z3, int i5, int i6) {
        this.f2141f = i4;
        this.f2142g = z;
        this.f2143h = z3;
        this.f2144i = i5;
        this.f2145j = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f2141f);
        AbstractC0141a.P(parcel, 2, 4);
        parcel.writeInt(this.f2142g ? 1 : 0);
        AbstractC0141a.P(parcel, 3, 4);
        parcel.writeInt(this.f2143h ? 1 : 0);
        AbstractC0141a.P(parcel, 4, 4);
        parcel.writeInt(this.f2144i);
        AbstractC0141a.P(parcel, 5, 4);
        parcel.writeInt(this.f2145j);
        AbstractC0141a.S(parcel, Q2);
    }
}
