package a0;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: a0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0072n implements Parcelable {
    public static final Parcelable.Creator<C0072n> CREATOR = new H.g(1);

    /* renamed from: c, reason: collision with root package name */
    public int f995c;

    /* renamed from: d, reason: collision with root package name */
    public int f996d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f997e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f995c);
        parcel.writeInt(this.f996d);
        parcel.writeInt(this.f997e ? 1 : 0);
    }
}
