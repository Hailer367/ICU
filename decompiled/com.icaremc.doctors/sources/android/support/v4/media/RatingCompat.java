package android.support.v4.media;

import H.g;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new g(7);

    /* renamed from: c, reason: collision with root package name */
    public final int f1027c;

    /* renamed from: d, reason: collision with root package name */
    public final float f1028d;

    public RatingCompat(int i2, float f2) {
        this.f1027c = i2;
        this.f1028d = f2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f1027c;
    }

    public final String toString() {
        String valueOf;
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f1027c);
        sb.append(" rating=");
        float f2 = this.f1028d;
        if (f2 < 0.0f) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(f2);
        }
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1027c);
        parcel.writeFloat(this.f1028d);
    }
}
