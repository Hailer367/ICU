package android.support.v4.media.session;

import H.g;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new g(11);

    /* renamed from: c, reason: collision with root package name */
    public int f1033c;

    /* renamed from: d, reason: collision with root package name */
    public int f1034d;

    /* renamed from: e, reason: collision with root package name */
    public int f1035e;

    /* renamed from: f, reason: collision with root package name */
    public int f1036f;

    /* renamed from: g, reason: collision with root package name */
    public int f1037g;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1033c);
        parcel.writeInt(this.f1035e);
        parcel.writeInt(this.f1036f);
        parcel.writeInt(this.f1037g);
        parcel.writeInt(this.f1034d);
    }
}
