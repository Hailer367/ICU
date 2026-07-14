package n1;

import Z0.o;
import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.swiperefreshlayout.widget.k;

/* loaded from: classes.dex */
public final class e extends AbstractC0142a {
    public static final Parcelable.Creator<e> CREATOR = new k(9);

    /* renamed from: f, reason: collision with root package name */
    public final int f5379f;

    /* renamed from: g, reason: collision with root package name */
    public final W0.a f5380g;

    /* renamed from: h, reason: collision with root package name */
    public final o f5381h;

    public e(int i4, W0.a aVar, o oVar) {
        this.f5379f = i4;
        this.f5380g = aVar;
        this.f5381h = oVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f5379f);
        AbstractC0141a.L(parcel, 2, this.f5380g, i4);
        AbstractC0141a.L(parcel, 3, this.f5381h, i4);
        AbstractC0141a.S(parcel, Q2);
    }
}
