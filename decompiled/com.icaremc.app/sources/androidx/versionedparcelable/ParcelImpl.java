package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.swiperefreshlayout.widget.k;
import o0.C0558b;
import o0.InterfaceC0559c;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new k(11);

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0559c f3187f;

    public ParcelImpl(Parcel parcel) {
        this.f3187f = new C0558b(parcel).h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        new C0558b(parcel).l(this.f3187f);
    }
}
