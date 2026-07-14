package c;

import H.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0169d implements Parcelable {
    public static final Parcelable.Creator<C0169d> CREATOR = new g(18);

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0167b f1986c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            try {
                if (this.f1986c == null) {
                    this.f1986c = new BinderC0168c(this);
                }
                parcel.writeStrongBinder(this.f1986c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i2, Bundle bundle) {
    }
}
