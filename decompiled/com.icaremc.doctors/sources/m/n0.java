package m;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class n0 extends J.c {
    public static final Parcelable.Creator<n0> CREATOR = new J.b(4);

    /* renamed from: e, reason: collision with root package name */
    public int f3203e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3204f;

    public n0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        boolean z;
        this.f3203e = parcel.readInt();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3204f = z;
    }

    @Override // J.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f3203e);
        parcel.writeInt(this.f3204f ? 1 : 0);
    }
}
