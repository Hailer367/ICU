package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0103c implements Parcelable {
    public static final Parcelable.Creator<C0103c> CREATOR = new H.g(14);

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1596c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1597d;

    public C0103c(Parcel parcel) {
        this.f1596c = parcel.createStringArrayList();
        this.f1597d = parcel.createTypedArrayList(C0101b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.f1596c);
        parcel.writeTypedList(this.f1597d);
    }
}
