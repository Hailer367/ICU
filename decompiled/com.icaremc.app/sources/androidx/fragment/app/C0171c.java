package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0171c implements Parcelable {
    public static final Parcelable.Creator<C0171c> CREATOR = new L.g(26);

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f2849f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f2850g;

    public C0171c(Parcel parcel) {
        this.f2849f = parcel.createStringArrayList();
        this.f2850g = parcel.createTypedArrayList(C0170b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeStringList(this.f2849f);
        parcel.writeTypedList(this.f2850g);
    }
}
