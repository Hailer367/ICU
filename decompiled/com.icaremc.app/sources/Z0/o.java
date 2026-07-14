package Z0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class o extends AbstractC0142a {
    public static final Parcelable.Creator<o> CREATOR = new L.g(11);

    /* renamed from: f, reason: collision with root package name */
    public final int f2163f;

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f2164g;

    /* renamed from: h, reason: collision with root package name */
    public final W0.a f2165h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2166i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2167j;

    public o(int i4, IBinder iBinder, W0.a aVar, boolean z, boolean z3) {
        this.f2163f = i4;
        this.f2164g = iBinder;
        this.f2165h = aVar;
        this.f2166i = z;
        this.f2167j = z3;
    }

    public final boolean equals(Object obj) {
        Object e4;
        if (obj != null) {
            if (this != obj) {
                if (obj instanceof o) {
                    o oVar = (o) obj;
                    if (this.f2165h.equals(oVar.f2165h)) {
                        Object obj2 = null;
                        IBinder iBinder = this.f2164g;
                        if (iBinder == null) {
                            e4 = null;
                        } else {
                            int i4 = AbstractBinderC0135a.f2110g;
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                            if (queryLocalInterface instanceof InterfaceC0139e) {
                                e4 = (InterfaceC0139e) queryLocalInterface;
                            } else {
                                e4 = new E(iBinder);
                            }
                        }
                        IBinder iBinder2 = oVar.f2164g;
                        if (iBinder2 != null) {
                            int i5 = AbstractBinderC0135a.f2110g;
                            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                            if (queryLocalInterface2 instanceof InterfaceC0139e) {
                                obj2 = (InterfaceC0139e) queryLocalInterface2;
                            } else {
                                obj2 = new E(iBinder2);
                            }
                        }
                        if (r.g(e4, obj2)) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f2163f);
        IBinder iBinder = this.f2164g;
        if (iBinder != null) {
            int Q3 = AbstractC0141a.Q(parcel, 2);
            parcel.writeStrongBinder(iBinder);
            AbstractC0141a.S(parcel, Q3);
        }
        AbstractC0141a.L(parcel, 3, this.f2165h, i4);
        AbstractC0141a.P(parcel, 4, 4);
        parcel.writeInt(this.f2166i ? 1 : 0);
        AbstractC0141a.P(parcel, 5, 4);
        parcel.writeInt(this.f2167j ? 1 : 0);
        AbstractC0141a.S(parcel, Q2);
    }
}
