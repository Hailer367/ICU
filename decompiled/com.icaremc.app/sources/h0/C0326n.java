package h0;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: h0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0326n implements Parcelable {
    public static final Parcelable.Creator<C0326n> CREATOR = new androidx.swiperefreshlayout.widget.k(4);

    /* renamed from: f, reason: collision with root package name */
    public int f3921f;

    /* renamed from: g, reason: collision with root package name */
    public int f3922g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3923h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f3921f);
        parcel.writeInt(this.f3922g);
        parcel.writeInt(this.f3923h ? 1 : 0);
    }
}
