package d;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.swiperefreshlayout.widget.k;

/* loaded from: classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new k(1);

    /* renamed from: f, reason: collision with root package name */
    public b f3426f;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        synchronized (this) {
            try {
                if (this.f3426f == null) {
                    this.f3426f = new c(this);
                }
                parcel.writeStrongBinder(this.f3426f.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i4, Bundle bundle) {
    }
}
