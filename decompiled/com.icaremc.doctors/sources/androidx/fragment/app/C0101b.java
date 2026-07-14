package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0101b implements Parcelable {
    public static final Parcelable.Creator<C0101b> CREATOR = new H.g(13);

    /* renamed from: c, reason: collision with root package name */
    public final int[] f1582c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1583d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f1584e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f1585f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1586g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1587h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1588i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1589j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f1590k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1591l;

    /* renamed from: m, reason: collision with root package name */
    public final CharSequence f1592m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f1593n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f1594o;
    public final boolean p;

    public C0101b(C0099a c0099a) {
        int size = c0099a.f1735a.size();
        this.f1582c = new int[size * 6];
        if (c0099a.f1741g) {
            this.f1583d = new ArrayList(size);
            this.f1584e = new int[size];
            this.f1585f = new int[size];
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                q0 q0Var = (q0) c0099a.f1735a.get(i3);
                int i4 = i2 + 1;
                this.f1582c[i2] = q0Var.f1725a;
                ArrayList arrayList = this.f1583d;
                H h2 = q0Var.f1726b;
                arrayList.add(h2 != null ? h2.mWho : null);
                int[] iArr = this.f1582c;
                iArr[i4] = q0Var.f1727c ? 1 : 0;
                iArr[i2 + 2] = q0Var.f1728d;
                iArr[i2 + 3] = q0Var.f1729e;
                int i5 = i2 + 5;
                iArr[i2 + 4] = q0Var.f1730f;
                i2 += 6;
                iArr[i5] = q0Var.f1731g;
                this.f1584e[i3] = q0Var.f1732h.ordinal();
                this.f1585f[i3] = q0Var.f1733i.ordinal();
            }
            this.f1586g = c0099a.f1740f;
            this.f1587h = c0099a.f1742h;
            this.f1588i = c0099a.f1579r;
            this.f1589j = c0099a.f1743i;
            this.f1590k = c0099a.f1744j;
            this.f1591l = c0099a.f1745k;
            this.f1592m = c0099a.f1746l;
            this.f1593n = c0099a.f1747m;
            this.f1594o = c0099a.f1748n;
            this.p = c0099a.f1749o;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f1582c);
        parcel.writeStringList(this.f1583d);
        parcel.writeIntArray(this.f1584e);
        parcel.writeIntArray(this.f1585f);
        parcel.writeInt(this.f1586g);
        parcel.writeString(this.f1587h);
        parcel.writeInt(this.f1588i);
        parcel.writeInt(this.f1589j);
        TextUtils.writeToParcel(this.f1590k, parcel, 0);
        parcel.writeInt(this.f1591l);
        TextUtils.writeToParcel(this.f1592m, parcel, 0);
        parcel.writeStringList(this.f1593n);
        parcel.writeStringList(this.f1594o);
        parcel.writeInt(this.p ? 1 : 0);
    }

    public C0101b(Parcel parcel) {
        this.f1582c = parcel.createIntArray();
        this.f1583d = parcel.createStringArrayList();
        this.f1584e = parcel.createIntArray();
        this.f1585f = parcel.createIntArray();
        this.f1586g = parcel.readInt();
        this.f1587h = parcel.readString();
        this.f1588i = parcel.readInt();
        this.f1589j = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f1590k = (CharSequence) creator.createFromParcel(parcel);
        this.f1591l = parcel.readInt();
        this.f1592m = (CharSequence) creator.createFromParcel(parcel);
        this.f1593n = parcel.createStringArrayList();
        this.f1594o = parcel.createStringArrayList();
        this.p = parcel.readInt() != 0;
    }
}
