package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class S implements Parcelable {
    public static final Parcelable.Creator<S> CREATOR = new L.g(28);

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f2774f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f2775g;

    /* renamed from: h, reason: collision with root package name */
    public C0170b[] f2776h;

    /* renamed from: i, reason: collision with root package name */
    public int f2777i;

    /* renamed from: j, reason: collision with root package name */
    public String f2778j;
    public ArrayList k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f2779l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f2780m;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeStringList(this.f2774f);
        parcel.writeStringList(this.f2775g);
        parcel.writeTypedArray(this.f2776h, i4);
        parcel.writeInt(this.f2777i);
        parcel.writeString(this.f2778j);
        parcel.writeStringList(this.k);
        parcel.writeTypedList(this.f2779l);
        parcel.writeTypedList(this.f2780m);
    }
}
