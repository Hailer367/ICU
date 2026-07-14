package h0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: h0.K, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0308K implements Parcelable {
    public static final Parcelable.Creator<C0308K> CREATOR = new androidx.swiperefreshlayout.widget.k(6);

    /* renamed from: f, reason: collision with root package name */
    public int f3841f;

    /* renamed from: g, reason: collision with root package name */
    public int f3842g;

    /* renamed from: h, reason: collision with root package name */
    public int f3843h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f3844i;

    /* renamed from: j, reason: collision with root package name */
    public int f3845j;
    public int[] k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f3846l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3847m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3848n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3849o;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f3841f);
        parcel.writeInt(this.f3842g);
        parcel.writeInt(this.f3843h);
        if (this.f3843h > 0) {
            parcel.writeIntArray(this.f3844i);
        }
        parcel.writeInt(this.f3845j);
        if (this.f3845j > 0) {
            parcel.writeIntArray(this.k);
        }
        parcel.writeInt(this.f3847m ? 1 : 0);
        parcel.writeInt(this.f3848n ? 1 : 0);
        parcel.writeInt(this.f3849o ? 1 : 0);
        parcel.writeList(this.f3846l);
    }
}
