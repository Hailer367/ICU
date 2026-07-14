package Z0;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class E implements InterfaceC0139e, IInterface {

    /* renamed from: f, reason: collision with root package name */
    public final IBinder f2109f;

    public E(IBinder iBinder) {
        this.f2109f = iBinder;
    }

    public final Account a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
        obtain = Parcel.obtain();
        try {
            this.f2109f.transact(2, obtain, obtain, 0);
            obtain.readException();
            obtain.recycle();
            return (Account) j1.h.a(obtain, Account.CREATOR);
        } catch (RuntimeException e4) {
            throw e4;
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2109f;
    }
}
