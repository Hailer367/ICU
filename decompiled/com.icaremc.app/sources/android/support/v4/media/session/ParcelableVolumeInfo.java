package android.support.v4.media.session;

import L.g;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new g(23);

    /* renamed from: f, reason: collision with root package name */
    public int f2241f;

    /* renamed from: g, reason: collision with root package name */
    public int f2242g;

    /* renamed from: h, reason: collision with root package name */
    public int f2243h;

    /* renamed from: i, reason: collision with root package name */
    public int f2244i;

    /* renamed from: j, reason: collision with root package name */
    public int f2245j;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2241f);
        parcel.writeInt(this.f2243h);
        parcel.writeInt(this.f2244i);
        parcel.writeInt(this.f2245j);
        parcel.writeInt(this.f2242g);
    }
}
