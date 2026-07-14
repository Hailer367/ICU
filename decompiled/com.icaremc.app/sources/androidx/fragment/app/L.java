package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class L implements Parcelable {
    public static final Parcelable.Creator<L> CREATOR = new L.g(27);

    /* renamed from: f, reason: collision with root package name */
    public String f2730f;

    /* renamed from: g, reason: collision with root package name */
    public int f2731g;

    public L(String str, int i4) {
        this.f2730f = str;
        this.f2731g = i4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2730f);
        parcel.writeInt(this.f2731g);
    }
}
