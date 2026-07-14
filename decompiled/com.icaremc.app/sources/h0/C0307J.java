package h0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* renamed from: h0.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0307J implements Parcelable {
    public static final Parcelable.Creator<C0307J> CREATOR = new androidx.swiperefreshlayout.widget.k(5);

    /* renamed from: f, reason: collision with root package name */
    public int f3837f;

    /* renamed from: g, reason: collision with root package name */
    public int f3838g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f3839h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3840i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f3837f + ", mGapDir=" + this.f3838g + ", mHasUnwantedGapAfter=" + this.f3840i + ", mGapPerSpan=" + Arrays.toString(this.f3839h) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f3837f);
        parcel.writeInt(this.f3838g);
        parcel.writeInt(this.f3840i ? 1 : 0);
        int[] iArr = this.f3839h;
        if (iArr != null && iArr.length > 0) {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f3839h);
        } else {
            parcel.writeInt(0);
        }
    }
}
