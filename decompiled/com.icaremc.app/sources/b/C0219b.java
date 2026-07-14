package b;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import q1.AbstractC0602b;
import r.BinderC0612g;
import r.n;

/* renamed from: b.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0219b implements InterfaceC0221d {

    /* renamed from: f, reason: collision with root package name */
    public IBinder f3200f;

    public final boolean a(BinderC0612g binderC0612g, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            AbstractC0602b.a0(obtain, bundle);
            boolean z = false;
            this.f3200f.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3200f;
    }

    public final boolean d(BinderC0612g binderC0612g, Uri uri, Bundle bundle, List list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            AbstractC0602b.a0(obtain, uri);
            AbstractC0602b.a0(obtain, bundle);
            boolean z = false;
            if (list == null) {
                obtain.writeInt(-1);
            } else {
                int size = list.size();
                obtain.writeInt(size);
                for (int i4 = 0; i4 < size; i4++) {
                    AbstractC0602b.a0(obtain, (Parcelable) list.get(i4));
                }
            }
            this.f3200f.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean f(BinderC0612g binderC0612g) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            boolean z = false;
            this.f3200f.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int h(BinderC0612g binderC0612g, String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            obtain.writeString(str);
            AbstractC0602b.a0(obtain, bundle);
            this.f3200f.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean i(BinderC0612g binderC0612g, Uri uri) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            AbstractC0602b.a0(obtain, uri);
            boolean z = false;
            this.f3200f.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean j(BinderC0612g binderC0612g, Uri uri, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            AbstractC0602b.a0(obtain, uri);
            AbstractC0602b.a0(obtain, bundle);
            boolean z = false;
            this.f3200f.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean k(BinderC0612g binderC0612g, n nVar, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            obtain.writeStrongBinder(nVar);
            AbstractC0602b.a0(obtain, bundle);
            boolean z = false;
            this.f3200f.transact(14, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean l(BinderC0612g binderC0612g, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            AbstractC0602b.a0(obtain, bundle);
            boolean z = false;
            this.f3200f.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m(BinderC0612g binderC0612g, int i4, Uri uri, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeStrongInterface(binderC0612g);
            obtain.writeInt(i4);
            AbstractC0602b.a0(obtain, uri);
            AbstractC0602b.a0(obtain, bundle);
            boolean z = false;
            this.f3200f.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean n() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0221d.f3202b);
            obtain.writeLong(0L);
            boolean z = false;
            this.f3200f.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
