package androidx.swiperefreshlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
public final class l extends View.BaseSavedState {
    public static final Parcelable.Creator<l> CREATOR = new k(0);

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3186f;

    public l(Parcelable parcelable, boolean z) {
        super(parcelable);
        this.f3186f = z;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeByte(this.f3186f ? (byte) 1 : (byte) 0);
    }

    public l(Parcel parcel) {
        super(parcel);
        this.f3186f = parcel.readByte() != 0;
    }
}
