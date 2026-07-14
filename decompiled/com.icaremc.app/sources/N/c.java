package N;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class c implements Parcelable {

    /* renamed from: f, reason: collision with root package name */
    public final Parcelable f1062f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f1061g = new c();
    public static final Parcelable.Creator<c> CREATOR = new b(0);

    public c() {
        this.f1062f = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f1062f, i4);
    }

    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1062f = parcelable == f1061g ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f1062f = readParcelable == null ? f1061g : readParcelable;
    }
}
