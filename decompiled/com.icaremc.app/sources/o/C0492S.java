package o;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* renamed from: o.S, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0492S extends View.BaseSavedState {
    public static final Parcelable.Creator<C0492S> CREATOR = new androidx.swiperefreshlayout.widget.k(10);

    /* renamed from: f, reason: collision with root package name */
    public boolean f5515f;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeByte(this.f5515f ? (byte) 1 : (byte) 0);
    }
}
