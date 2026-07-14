package J;

import a0.C0055D;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.G;
import m.b0;
import m.n0;

/* loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f327a;

    public /* synthetic */ b(int i2) {
        this.f327a = i2;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f327a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return c.f328d;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new C0055D(parcel, classLoader);
            case 2:
                return new G(parcel, classLoader);
            case 3:
                return new b0(parcel, classLoader);
            default:
                return new n0(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f327a) {
            case 0:
                return new c[i2];
            case 1:
                return new C0055D[i2];
            case 2:
                return new G[i2];
            case 3:
                return new b0[i2];
            default:
                return new n0[i2];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f327a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return c.f328d;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new C0055D(parcel, null);
            case 2:
                return new G(parcel, null);
            case 3:
                return new b0(parcel, null);
            default:
                return new n0(parcel, null);
        }
    }
}
