package Z0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class i extends AbstractC0142a {
    public static final Parcelable.Creator<i> CREATOR = new L.g(7);

    /* renamed from: f, reason: collision with root package name */
    public final int f2146f;

    /* renamed from: g, reason: collision with root package name */
    public List f2147g;

    public i(int i4, List list) {
        this.f2146f = i4;
        this.f2147g = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f2146f);
        AbstractC0141a.O(parcel, 2, this.f2147g);
        AbstractC0141a.S(parcel, Q2);
    }
}
