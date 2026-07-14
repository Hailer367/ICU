package m;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class b0 extends J.c {
    public static final Parcelable.Creator<b0> CREATOR = new J.b(3);

    /* renamed from: e, reason: collision with root package name */
    public boolean f3114e;

    public b0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3114e = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f3114e + "}";
    }

    @Override // J.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeValue(Boolean.valueOf(this.f3114e));
    }
}
