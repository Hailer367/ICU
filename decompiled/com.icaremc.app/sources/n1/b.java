package n1;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.swiperefreshlayout.widget.k;

/* loaded from: classes.dex */
public final class b extends AbstractC0142a {
    public static final Parcelable.Creator<b> CREATOR = new k(7);

    /* renamed from: f, reason: collision with root package name */
    public final int f5374f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5375g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f5376h;

    public b(int i4, int i5, Intent intent) {
        this.f5374f = i4;
        this.f5375g = i5;
        this.f5376h = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f5374f);
        AbstractC0141a.P(parcel, 2, 4);
        parcel.writeInt(this.f5375g);
        AbstractC0141a.L(parcel, 3, this.f5376h, i4);
        AbstractC0141a.S(parcel, Q2);
    }
}
