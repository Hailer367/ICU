package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: c.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0168c extends Binder implements InterfaceC0167b {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f1984d = 0;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0169d f1985c;

    public BinderC0168c(C0169d c0169d) {
        this.f1985c = c0169d;
        attachInterface(this, InterfaceC0167b.f1983b);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        String str = InterfaceC0167b.f1983b;
        if (i2 >= 1 && i2 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i2 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        if (i2 != 1) {
            return super.onTransact(i2, parcel, parcel2, i3);
        }
        this.f1985c.a(parcel.readInt(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
