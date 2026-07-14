package Z0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: Z0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0137c extends AbstractC0142a {
    public static final Parcelable.Creator<C0137c> CREATOR = new L.g(14);

    /* renamed from: f, reason: collision with root package name */
    public final h f2111f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2112g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2113h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f2114i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2115j;
    public final int[] k;

    public C0137c(h hVar, boolean z, boolean z3, int[] iArr, int i4, int[] iArr2) {
        this.f2111f = hVar;
        this.f2112g = z;
        this.f2113h = z3;
        this.f2114i = iArr;
        this.f2115j = i4;
        this.k = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.L(parcel, 1, this.f2111f, i4);
        AbstractC0141a.P(parcel, 2, 4);
        parcel.writeInt(this.f2112g ? 1 : 0);
        AbstractC0141a.P(parcel, 3, 4);
        parcel.writeInt(this.f2113h ? 1 : 0);
        int[] iArr = this.f2114i;
        if (iArr != null) {
            int Q3 = AbstractC0141a.Q(parcel, 4);
            parcel.writeIntArray(iArr);
            AbstractC0141a.S(parcel, Q3);
        }
        AbstractC0141a.P(parcel, 5, 4);
        parcel.writeInt(this.f2115j);
        int[] iArr2 = this.k;
        if (iArr2 != null) {
            int Q4 = AbstractC0141a.Q(parcel, 6);
            parcel.writeIntArray(iArr2);
            AbstractC0141a.S(parcel, Q4);
        }
        AbstractC0141a.S(parcel, Q2);
    }
}
