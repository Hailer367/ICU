package a0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class L implements Parcelable {
    public static final Parcelable.Creator<L> CREATOR = new H.g(3);

    /* renamed from: c, reason: collision with root package name */
    public int f916c;

    /* renamed from: d, reason: collision with root package name */
    public int f917d;

    /* renamed from: e, reason: collision with root package name */
    public int f918e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f919f;

    /* renamed from: g, reason: collision with root package name */
    public int f920g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f921h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f922i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f923j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f924k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f925l;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f916c);
        parcel.writeInt(this.f917d);
        parcel.writeInt(this.f918e);
        if (this.f918e > 0) {
            parcel.writeIntArray(this.f919f);
        }
        parcel.writeInt(this.f920g);
        if (this.f920g > 0) {
            parcel.writeIntArray(this.f921h);
        }
        parcel.writeInt(this.f923j ? 1 : 0);
        parcel.writeInt(this.f924k ? 1 : 0);
        parcel.writeInt(this.f925l ? 1 : 0);
        parcel.writeList(this.f922i);
    }
}
