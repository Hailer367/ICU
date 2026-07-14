package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0170b implements Parcelable {
    public static final Parcelable.Creator<C0170b> CREATOR = new L.g(25);

    /* renamed from: f, reason: collision with root package name */
    public final int[] f2835f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f2836g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f2837h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f2838i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2839j;
    public final String k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2840l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2841m;

    /* renamed from: n, reason: collision with root package name */
    public final CharSequence f2842n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2843o;

    /* renamed from: p, reason: collision with root package name */
    public final CharSequence f2844p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f2845q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f2846r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f2847s;

    public C0170b(C0169a c0169a) {
        int size = c0169a.f2816a.size();
        this.f2835f = new int[size * 6];
        if (c0169a.f2822g) {
            this.f2836g = new ArrayList(size);
            this.f2837h = new int[size];
            this.f2838i = new int[size];
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Y y3 = (Y) c0169a.f2816a.get(i5);
                int i6 = i4 + 1;
                this.f2835f[i4] = y3.f2807a;
                ArrayList arrayList = this.f2836g;
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = y3.f2808b;
                arrayList.add(abstractComponentCallbacksC0187t != null ? abstractComponentCallbacksC0187t.f2928j : null);
                int[] iArr = this.f2835f;
                iArr[i6] = y3.f2809c ? 1 : 0;
                iArr[i4 + 2] = y3.f2810d;
                iArr[i4 + 3] = y3.f2811e;
                int i7 = i4 + 5;
                iArr[i4 + 4] = y3.f2812f;
                i4 += 6;
                iArr[i7] = y3.f2813g;
                this.f2837h[i5] = y3.f2814h.ordinal();
                this.f2838i[i5] = y3.f2815i.ordinal();
            }
            this.f2839j = c0169a.f2821f;
            this.k = c0169a.f2823h;
            this.f2840l = c0169a.f2832r;
            this.f2841m = c0169a.f2824i;
            this.f2842n = c0169a.f2825j;
            this.f2843o = c0169a.k;
            this.f2844p = c0169a.f2826l;
            this.f2845q = c0169a.f2827m;
            this.f2846r = c0169a.f2828n;
            this.f2847s = c0169a.f2829o;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeIntArray(this.f2835f);
        parcel.writeStringList(this.f2836g);
        parcel.writeIntArray(this.f2837h);
        parcel.writeIntArray(this.f2838i);
        parcel.writeInt(this.f2839j);
        parcel.writeString(this.k);
        parcel.writeInt(this.f2840l);
        parcel.writeInt(this.f2841m);
        TextUtils.writeToParcel(this.f2842n, parcel, 0);
        parcel.writeInt(this.f2843o);
        TextUtils.writeToParcel(this.f2844p, parcel, 0);
        parcel.writeStringList(this.f2845q);
        parcel.writeStringList(this.f2846r);
        parcel.writeInt(this.f2847s ? 1 : 0);
    }

    public C0170b(Parcel parcel) {
        this.f2835f = parcel.createIntArray();
        this.f2836g = parcel.createStringArrayList();
        this.f2837h = parcel.createIntArray();
        this.f2838i = parcel.createIntArray();
        this.f2839j = parcel.readInt();
        this.k = parcel.readString();
        this.f2840l = parcel.readInt();
        this.f2841m = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f2842n = (CharSequence) creator.createFromParcel(parcel);
        this.f2843o = parcel.readInt();
        this.f2844p = (CharSequence) creator.createFromParcel(parcel);
        this.f2845q = parcel.createStringArrayList();
        this.f2846r = parcel.createStringArrayList();
        this.f2847s = parcel.readInt() != 0;
    }
}
