package androidx.versionedparcelable;

import H.g;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import g0.b;
import g0.c;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new g(21);

    /* renamed from: c, reason: collision with root package name */
    public final c f1960c;

    public ParcelImpl(Parcel parcel) {
        this.f1960c = new b(parcel).h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        new b(parcel).l(this.f1960c);
    }
}
