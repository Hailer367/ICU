package Z0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class z extends AbstractC0142a {
    public static final Parcelable.Creator<z> CREATOR = new L.g(13);

    /* renamed from: f, reason: collision with root package name */
    public Bundle f2188f;

    /* renamed from: g, reason: collision with root package name */
    public W0.c[] f2189g;

    /* renamed from: h, reason: collision with root package name */
    public int f2190h;

    /* renamed from: i, reason: collision with root package name */
    public C0137c f2191i;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.K(parcel, 1, this.f2188f);
        AbstractC0141a.N(parcel, 2, this.f2189g, i4);
        int i5 = this.f2190h;
        AbstractC0141a.P(parcel, 3, 4);
        parcel.writeInt(i5);
        AbstractC0141a.L(parcel, 4, this.f2191i, i4);
        AbstractC0141a.S(parcel, Q2);
    }
}
