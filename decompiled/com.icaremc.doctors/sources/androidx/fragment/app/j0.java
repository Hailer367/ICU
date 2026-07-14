package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j0 implements Parcelable {
    public static final Parcelable.Creator<j0> CREATOR = new H.g(16);

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f1657c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f1658d;

    /* renamed from: e, reason: collision with root package name */
    public C0101b[] f1659e;

    /* renamed from: f, reason: collision with root package name */
    public int f1660f;

    /* renamed from: g, reason: collision with root package name */
    public String f1661g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f1662h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f1663i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f1664j;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.f1657c);
        parcel.writeStringList(this.f1658d);
        parcel.writeTypedArray(this.f1659e, i2);
        parcel.writeInt(this.f1660f);
        parcel.writeString(this.f1661g);
        parcel.writeStringList(this.f1662h);
        parcel.writeTypedList(this.f1663i);
        parcel.writeTypedList(this.f1664j);
    }
}
