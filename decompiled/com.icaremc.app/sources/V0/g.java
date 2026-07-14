package V0;

import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new c(1);

    /* renamed from: f, reason: collision with root package name */
    public final Messenger f1689f;

    public g(IBinder iBinder) {
        this.f1689f = new Messenger(iBinder);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            try {
                Messenger messenger = this.f1689f;
                messenger.getClass();
                IBinder binder = messenger.getBinder();
                Messenger messenger2 = ((g) obj).f1689f;
                messenger2.getClass();
                return binder.equals(messenger2.getBinder());
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        Messenger messenger = this.f1689f;
        messenger.getClass();
        return messenger.getBinder().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Messenger messenger = this.f1689f;
        messenger.getClass();
        parcel.writeStrongBinder(messenger.getBinder());
    }
}
