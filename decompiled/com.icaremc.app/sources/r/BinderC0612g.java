package r;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import b.InterfaceC0218a;
import o.RunnableC0497X;

/* renamed from: r.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0612g extends Binder implements InterfaceC0218a {

    /* renamed from: f, reason: collision with root package name */
    public final Handler f5992f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC0606a f5993g;

    public BinderC0612g(AbstractC0606a abstractC0606a) {
        this.f5993g = abstractC0606a;
        attachInterface(this, InterfaceC0218a.f3199a);
        this.f5992f = new Handler(Looper.getMainLooper());
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        Bundle extraCallbackWithResult;
        String str = InterfaceC0218a.f3199a;
        if (i4 >= 1 && i4 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i4 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        boolean z = false;
        Handler handler = this.f5992f;
        AbstractC0606a abstractC0606a = this.f5993g;
        switch (i4) {
            case 2:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0497X(readInt, bundle, this));
                    return true;
                }
                return true;
            case 3:
                String readString = parcel.readString();
                Bundle bundle2 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0608c(this, readString, bundle2, 0));
                    return true;
                }
                return true;
            case 4:
                Bundle bundle3 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0607b(1, bundle3, this));
                }
                parcel2.writeNoException();
                return true;
            case 5:
                String readString2 = parcel.readString();
                Bundle bundle4 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0608c(this, readString2, bundle4, 1));
                }
                parcel2.writeNoException();
                return true;
            case 6:
                int readInt2 = parcel.readInt();
                Uri uri = (Uri) k3.b.a(parcel, Uri.CREATOR);
                if (parcel.readInt() != 0) {
                    z = true;
                }
                Bundle bundle5 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0609d(this, readInt2, uri, z, bundle5));
                    return true;
                }
                return true;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                String readString3 = parcel.readString();
                Bundle bundle6 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a == null) {
                    extraCallbackWithResult = null;
                } else {
                    extraCallbackWithResult = abstractC0606a.extraCallbackWithResult(readString3, bundle6);
                }
                parcel2.writeNoException();
                if (extraCallbackWithResult != null) {
                    parcel2.writeInt(1);
                    extraCallbackWithResult.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                int readInt3 = parcel.readInt();
                int readInt4 = parcel.readInt();
                Bundle bundle7 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0610e(this, readInt3, readInt4, bundle7));
                    return true;
                }
                return true;
            case 9:
                Bundle bundle8 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0607b(2, bundle8, this));
                    return true;
                }
                return true;
            case 10:
                int readInt5 = parcel.readInt();
                int readInt6 = parcel.readInt();
                int readInt7 = parcel.readInt();
                int readInt8 = parcel.readInt();
                int readInt9 = parcel.readInt();
                Bundle bundle9 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0611f(this, readInt5, readInt6, readInt7, readInt8, readInt9, bundle9));
                    return true;
                }
                return true;
            case 11:
                Bundle bundle10 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0607b(3, bundle10, this));
                    return true;
                }
                return true;
            case 12:
                Bundle bundle11 = (Bundle) k3.b.a(parcel, Bundle.CREATOR);
                if (abstractC0606a != null) {
                    handler.post(new RunnableC0607b(0, bundle11, this));
                    return true;
                }
                return true;
            default:
                return super.onTransact(i4, parcel, parcel2, i5);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
