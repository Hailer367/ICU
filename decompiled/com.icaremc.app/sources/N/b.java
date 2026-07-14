package N;

import android.os.Parcel;
import android.os.Parcelable;
import h0.C0300C;
import o.g1;
import o.v1;

/* loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1060a;

    public /* synthetic */ b(int i4) {
        this.f1060a = i4;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f1060a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return c.f1061g;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new C0300C(parcel, classLoader);
            case 2:
                return new g1(parcel, classLoader);
            default:
                return new v1(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f1060a) {
            case 0:
                return new c[i4];
            case 1:
                return new C0300C[i4];
            case 2:
                return new g1[i4];
            default:
                return new v1[i4];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1060a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return c.f1061g;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new C0300C(parcel, null);
            case 2:
                return new g1(parcel, null);
            default:
                return new v1(parcel, null);
        }
    }
}
