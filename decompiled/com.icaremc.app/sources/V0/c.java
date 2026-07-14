package V0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1683a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1683a) {
            case 0:
                int X3 = AbstractC0602b.X(parcel);
                Intent intent = null;
                while (parcel.dataPosition() < X3) {
                    int readInt = parcel.readInt();
                    if (((char) readInt) != 1) {
                        AbstractC0602b.T(parcel, readInt);
                    } else {
                        intent = (Intent) AbstractC0602b.o(parcel, readInt, Intent.CREATOR);
                    }
                }
                AbstractC0602b.w(parcel, X3);
                return new a(intent);
            default:
                return new g(parcel.readStrongBinder());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        switch (this.f1683a) {
            case 0:
                return new a[i4];
            default:
                return new g[i4];
        }
    }
}
