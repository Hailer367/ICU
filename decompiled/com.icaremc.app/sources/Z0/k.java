package Z0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class k extends AbstractC0142a {
    public static final Parcelable.Creator<k> CREATOR = new L.g(8);

    /* renamed from: f, reason: collision with root package name */
    public final int f2149f;

    /* renamed from: g, reason: collision with root package name */
    public final String f2150g;

    /* renamed from: h, reason: collision with root package name */
    public final long f2151h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2152i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2153j;

    public k(int i4, String str, long j4, int i5, boolean z) {
        this.f2149f = i4;
        this.f2150g = str;
        this.f2151h = j4;
        this.f2152i = i5;
        this.f2153j = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f2149f);
        AbstractC0141a.M(parcel, 2, this.f2150g);
        AbstractC0141a.P(parcel, 3, 8);
        parcel.writeLong(this.f2151h);
        AbstractC0141a.P(parcel, 4, 4);
        parcel.writeInt(this.f2152i);
        AbstractC0141a.P(parcel, 5, 4);
        parcel.writeInt(this.f2153j ? 1 : 0);
        AbstractC0141a.S(parcel, Q2);
    }
}
