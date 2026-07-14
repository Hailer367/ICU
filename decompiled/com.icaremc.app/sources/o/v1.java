package o;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class v1 extends N.c {
    public static final Parcelable.Creator<v1> CREATOR = new N.b(3);

    /* renamed from: h, reason: collision with root package name */
    public int f5721h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5722i;

    public v1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        boolean z;
        this.f5721h = parcel.readInt();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f5722i = z;
    }

    @Override // N.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f5721h);
        parcel.writeInt(this.f5722i ? 1 : 0);
    }
}
