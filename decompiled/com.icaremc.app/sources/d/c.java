package d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class c extends Binder implements b {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f3424g = 0;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f3425f;

    public c(d dVar) {
        this.f3425f = dVar;
        attachInterface(this, b.f3423e);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        String str = b.f3423e;
        if (i4 >= 1 && i4 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i4 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        if (i4 != 1) {
            return super.onTransact(i4, parcel, parcel2, i5);
        }
        this.f3425f.a(parcel.readInt(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
