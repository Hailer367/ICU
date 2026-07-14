package h0;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: h0.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0300C extends N.c {
    public static final Parcelable.Creator<C0300C> CREATOR = new N.b(1);

    /* renamed from: h, reason: collision with root package name */
    public Parcelable f3823h;

    public C0300C(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3823h = parcel.readParcelable(classLoader == null ? AbstractC0333u.class.getClassLoader() : classLoader);
    }

    @Override // N.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.f3823h, 0);
    }
}
