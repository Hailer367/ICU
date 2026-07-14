package r;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import b.InterfaceC0222e;

/* loaded from: classes.dex */
public final class n extends Binder implements InterfaceC0222e {

    /* renamed from: f, reason: collision with root package name */
    public final Handler f6009f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p f6010g;

    public n(p pVar) {
        this.f6010g = pVar;
        attachInterface(this, InterfaceC0222e.f3203c);
        this.f6009f = new Handler(Looper.getMainLooper());
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        String str = InterfaceC0222e.f3203c;
        if (i4 >= 1 && i4 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i4 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        Object obj = null;
        boolean z = false;
        p pVar = this.f6010g;
        Handler handler = this.f6009f;
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                if (parcel.readInt() != 0) {
                    z = true;
                }
                Parcelable.Creator creator = Bundle.CREATOR;
                if (parcel.readInt() != 0) {
                    obj = creator.createFromParcel(parcel);
                }
                handler.post(new RunnableC0618m(0, pVar, (Bundle) obj, z));
                return true;
            }
            int readInt = parcel.readInt();
            Parcelable.Creator creator2 = Bundle.CREATOR;
            if (parcel.readInt() != 0) {
                obj = creator2.createFromParcel(parcel);
            }
            handler.post(new e.j(pVar, readInt, (Bundle) obj, 3));
            return true;
        }
        if (parcel.readInt() != 0) {
            z = true;
        }
        Parcelable.Creator creator3 = Bundle.CREATOR;
        if (parcel.readInt() != 0) {
            obj = creator3.createFromParcel(parcel);
        }
        handler.post(new RunnableC0618m(1, pVar, (Bundle) obj, z));
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
