package J;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class c implements Parcelable {

    /* renamed from: c, reason: collision with root package name */
    public final Parcelable f329c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f328d = new c();
    public static final Parcelable.Creator<c> CREATOR = new b(0);

    public c() {
        this.f329c = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f329c, i2);
    }

    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f329c = parcelable == f328d ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f329c = readParcelable == null ? f328d : readParcelable;
    }
}
