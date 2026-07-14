package android.support.v4.media;

import L.g;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new g(19);

    /* renamed from: f, reason: collision with root package name */
    public final int f2235f;

    /* renamed from: g, reason: collision with root package name */
    public final float f2236g;

    public RatingCompat(int i4, float f4) {
        this.f2235f = i4;
        this.f2236g = f4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f2235f;
    }

    public final String toString() {
        String valueOf;
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f2235f);
        sb.append(" rating=");
        float f4 = this.f2236g;
        if (f4 < 0.0f) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(f4);
        }
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2235f);
        parcel.writeFloat(this.f2236g);
    }
}
