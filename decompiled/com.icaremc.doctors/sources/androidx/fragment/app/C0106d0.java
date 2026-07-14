package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: androidx.fragment.app.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0106d0 implements Parcelable {
    public static final Parcelable.Creator<C0106d0> CREATOR = new H.g(15);

    /* renamed from: c, reason: collision with root package name */
    public String f1603c;

    /* renamed from: d, reason: collision with root package name */
    public int f1604d;

    public C0106d0(String str, int i2) {
        this.f1603c = str;
        this.f1604d = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f1603c);
        parcel.writeInt(this.f1604d);
    }
}
