package androidx.swiperefreshlayout.widget;

import Z0.o;
import android.content.Intent;
import android.content.IntentSender;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.versionedparcelable.ParcelImpl;
import g.C0289a;
import h0.C0307J;
import h0.C0308K;
import h0.C0326n;
import java.util.ArrayList;
import o.C0492S;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class k implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3185a;

    public /* synthetic */ k(int i4) {
        this.f3185a = i4;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [android.view.View$BaseSavedState, o.S, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, d.d] */
    /* JADX WARN: Type inference failed for: r0v7, types: [h0.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [h0.J, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v9, types: [h0.K, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [d.a, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z;
        boolean z3;
        d.b bVar = null;
        W0.a aVar = null;
        Intent intent = null;
        Intent intent2 = null;
        boolean z4 = false;
        boolean z5 = false;
        int i4 = 0;
        boolean z6 = false;
        boolean z7 = false;
        switch (this.f3185a) {
            case 0:
                return new l(parcel);
            case 1:
                ?? obj = new Object();
                IBinder readStrongBinder = parcel.readStrongBinder();
                int i5 = d.c.f3424g;
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(d.b.f3423e);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof d.b)) {
                        bVar = (d.b) queryLocalInterface;
                    } else {
                        ?? obj2 = new Object();
                        obj2.f3422f = readStrongBinder;
                        bVar = obj2;
                    }
                }
                obj.f3426f = bVar;
                return obj;
            case 2:
                T2.h.e(parcel, "parcel");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    intent2 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                }
                return new C0289a(intent2, readInt);
            case 3:
                T2.h.e(parcel, "inParcel");
                Parcelable readParcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                T2.h.b(readParcelable);
                return new g.j((IntentSender) readParcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 4:
                ?? obj3 = new Object();
                obj3.f3921f = parcel.readInt();
                obj3.f3922g = parcel.readInt();
                if (parcel.readInt() == 1) {
                    z4 = true;
                }
                obj3.f3923h = z4;
                return obj3;
            case 5:
                ?? obj4 = new Object();
                obj4.f3837f = parcel.readInt();
                obj4.f3838g = parcel.readInt();
                if (parcel.readInt() == 1) {
                    z7 = true;
                }
                obj4.f3840i = z7;
                int readInt2 = parcel.readInt();
                if (readInt2 > 0) {
                    int[] iArr = new int[readInt2];
                    obj4.f3839h = iArr;
                    parcel.readIntArray(iArr);
                }
                return obj4;
            case 6:
                ?? obj5 = new Object();
                obj5.f3841f = parcel.readInt();
                obj5.f3842g = parcel.readInt();
                int readInt3 = parcel.readInt();
                obj5.f3843h = readInt3;
                if (readInt3 > 0) {
                    int[] iArr2 = new int[readInt3];
                    obj5.f3844i = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int readInt4 = parcel.readInt();
                obj5.f3845j = readInt4;
                if (readInt4 > 0) {
                    int[] iArr3 = new int[readInt4];
                    obj5.k = iArr3;
                    parcel.readIntArray(iArr3);
                }
                if (parcel.readInt() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                obj5.f3847m = z;
                if (parcel.readInt() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                obj5.f3848n = z3;
                if (parcel.readInt() == 1) {
                    z6 = true;
                }
                obj5.f3849o = z6;
                obj5.f3846l = parcel.readArrayList(C0307J.class.getClassLoader());
                return obj5;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                int X3 = AbstractC0602b.X(parcel);
                int i6 = 0;
                while (parcel.dataPosition() < X3) {
                    int readInt5 = parcel.readInt();
                    char c4 = (char) readInt5;
                    if (c4 != 1) {
                        if (c4 != 2) {
                            if (c4 != 3) {
                                AbstractC0602b.T(parcel, readInt5);
                            } else {
                                intent = (Intent) AbstractC0602b.o(parcel, readInt5, Intent.CREATOR);
                            }
                        } else {
                            i6 = AbstractC0602b.M(parcel, readInt5);
                        }
                    } else {
                        i4 = AbstractC0602b.M(parcel, readInt5);
                    }
                }
                AbstractC0602b.w(parcel, X3);
                return new n1.b(i4, i6, intent);
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                int X4 = AbstractC0602b.X(parcel);
                ArrayList<String> arrayList = null;
                String str = null;
                while (parcel.dataPosition() < X4) {
                    int readInt6 = parcel.readInt();
                    char c5 = (char) readInt6;
                    if (c5 != 1) {
                        if (c5 != 2) {
                            AbstractC0602b.T(parcel, readInt6);
                        } else {
                            str = AbstractC0602b.p(parcel, readInt6);
                        }
                    } else {
                        int N3 = AbstractC0602b.N(parcel, readInt6);
                        int dataPosition = parcel.dataPosition();
                        if (N3 == 0) {
                            arrayList = null;
                        } else {
                            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                            parcel.setDataPosition(dataPosition + N3);
                            arrayList = createStringArrayList;
                        }
                    }
                }
                AbstractC0602b.w(parcel, X4);
                return new n1.d(str, arrayList);
            case 9:
                int X5 = AbstractC0602b.X(parcel);
                int i7 = 0;
                o oVar = null;
                while (parcel.dataPosition() < X5) {
                    int readInt7 = parcel.readInt();
                    char c6 = (char) readInt7;
                    if (c6 != 1) {
                        if (c6 != 2) {
                            if (c6 != 3) {
                                AbstractC0602b.T(parcel, readInt7);
                            } else {
                                oVar = (o) AbstractC0602b.o(parcel, readInt7, o.CREATOR);
                            }
                        } else {
                            aVar = (W0.a) AbstractC0602b.o(parcel, readInt7, W0.a.CREATOR);
                        }
                    } else {
                        i7 = AbstractC0602b.M(parcel, readInt7);
                    }
                }
                AbstractC0602b.w(parcel, X5);
                return new n1.e(i7, aVar, oVar);
            case 10:
                ?? baseSavedState = new View.BaseSavedState(parcel);
                if (parcel.readByte() != 0) {
                    z5 = true;
                }
                baseSavedState.f5515f = z5;
                return baseSavedState;
            default:
                return new ParcelImpl(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f3185a) {
            case 0:
                return new l[i4];
            case 1:
                return new d.d[i4];
            case 2:
                return new C0289a[i4];
            case 3:
                return new g.j[i4];
            case 4:
                return new C0326n[i4];
            case 5:
                return new C0307J[i4];
            case 6:
                return new C0308K[i4];
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return new n1.b[i4];
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return new n1.d[i4];
            case 9:
                return new n1.e[i4];
            case 10:
                return new C0492S[i4];
            default:
                return new ParcelImpl[i4];
        }
    }
}
