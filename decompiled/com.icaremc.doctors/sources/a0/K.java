package a0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class K implements Parcelable {
    public static final Parcelable.Creator<K> CREATOR = new H.g(2);

    /* renamed from: c, reason: collision with root package name */
    public int f912c;

    /* renamed from: d, reason: collision with root package name */
    public int f913d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f914e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f915f;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f912c + ", mGapDir=" + this.f913d + ", mHasUnwantedGapAfter=" + this.f915f + ", mGapPerSpan=" + Arrays.toString(this.f914e) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f912c);
        parcel.writeInt(this.f913d);
        parcel.writeInt(this.f915f ? 1 : 0);
        int[] iArr = this.f914e;
        if (iArr != null && iArr.length > 0) {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f914e);
        } else {
            parcel.writeInt(0);
        }
    }
}
