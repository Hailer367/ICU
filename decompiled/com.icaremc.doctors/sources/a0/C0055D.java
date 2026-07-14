package a0;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: a0.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0055D extends J.c {
    public static final Parcelable.Creator<C0055D> CREATOR = new J.b(1);

    /* renamed from: e, reason: collision with root package name */
    public Parcelable f897e;

    public C0055D(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f897e = parcel.readParcelable(classLoader == null ? v.class.getClassLoader() : classLoader);
    }

    @Override // J.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.f897e, 0);
    }
}
