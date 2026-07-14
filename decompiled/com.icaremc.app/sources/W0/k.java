package W0;

import Z0.F;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import g1.BinderC0294a;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class k extends j1.g implements F {

    /* renamed from: g, reason: collision with root package name */
    public final int f1875g;

    public k(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        if (bArr.length == 25) {
            this.f1875g = Arrays.hashCode(bArr);
            return;
        }
        throw new IllegalArgumentException();
    }

    public static byte[] j(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof F) {
            try {
                F f4 = (F) obj;
                if (((k) f4).f1875g == this.f1875g) {
                    return Arrays.equals(i(), (byte[]) new BinderC0294a(((k) f4).i()).f3768g);
                }
            } catch (RemoteException e4) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
                return false;
            }
        }
        return false;
    }

    @Override // j1.g
    public final boolean h(int i4, Parcel parcel, Parcel parcel2) {
        if (i4 != 1) {
            if (i4 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.f1875g);
            return true;
        }
        BinderC0294a binderC0294a = new BinderC0294a(i());
        parcel2.writeNoException();
        int i5 = j1.h.f5052a;
        parcel2.writeStrongBinder(binderC0294a);
        return true;
    }

    public final int hashCode() {
        return this.f1875g;
    }

    public abstract byte[] i();
}
