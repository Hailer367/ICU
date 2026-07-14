package o;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class g1 extends N.c {
    public static final Parcelable.Creator<g1> CREATOR = new N.b(2);

    /* renamed from: h, reason: collision with root package name */
    public boolean f5584h;

    public g1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5584h = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f5584h + "}";
    }

    @Override // N.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeValue(Boolean.valueOf(this.f5584h));
    }
}
