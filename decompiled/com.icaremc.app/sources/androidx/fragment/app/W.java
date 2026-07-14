package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class W implements Parcelable {
    public static final Parcelable.Creator<W> CREATOR = new L.g(29);

    /* renamed from: f, reason: collision with root package name */
    public final String f2789f;

    /* renamed from: g, reason: collision with root package name */
    public final String f2790g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2791h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2792i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2793j;
    public final String k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f2794l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f2795m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f2796n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f2797o;

    /* renamed from: p, reason: collision with root package name */
    public final int f2798p;

    /* renamed from: q, reason: collision with root package name */
    public final String f2799q;

    /* renamed from: r, reason: collision with root package name */
    public final int f2800r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f2801s;

    public W(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        this.f2789f = abstractComponentCallbacksC0187t.getClass().getName();
        this.f2790g = abstractComponentCallbacksC0187t.f2928j;
        this.f2791h = abstractComponentCallbacksC0187t.f2936s;
        this.f2792i = abstractComponentCallbacksC0187t.f2904B;
        this.f2793j = abstractComponentCallbacksC0187t.f2905C;
        this.k = abstractComponentCallbacksC0187t.f2906D;
        this.f2794l = abstractComponentCallbacksC0187t.f2909G;
        this.f2795m = abstractComponentCallbacksC0187t.f2934q;
        this.f2796n = abstractComponentCallbacksC0187t.f2908F;
        this.f2797o = abstractComponentCallbacksC0187t.f2907E;
        this.f2798p = abstractComponentCallbacksC0187t.f2918Q.ordinal();
        this.f2799q = abstractComponentCallbacksC0187t.f2930m;
        this.f2800r = abstractComponentCallbacksC0187t.f2931n;
        this.f2801s = abstractComponentCallbacksC0187t.f2914L;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2789f);
        sb.append(" (");
        sb.append(this.f2790g);
        sb.append(")}:");
        if (this.f2791h) {
            sb.append(" fromLayout");
        }
        int i4 = this.f2793j;
        if (i4 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i4));
        }
        String str = this.k;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f2794l) {
            sb.append(" retainInstance");
        }
        if (this.f2795m) {
            sb.append(" removing");
        }
        if (this.f2796n) {
            sb.append(" detached");
        }
        if (this.f2797o) {
            sb.append(" hidden");
        }
        String str2 = this.f2799q;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.f2800r);
        }
        if (this.f2801s) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2789f);
        parcel.writeString(this.f2790g);
        parcel.writeInt(this.f2791h ? 1 : 0);
        parcel.writeInt(this.f2792i);
        parcel.writeInt(this.f2793j);
        parcel.writeString(this.k);
        parcel.writeInt(this.f2794l ? 1 : 0);
        parcel.writeInt(this.f2795m ? 1 : 0);
        parcel.writeInt(this.f2796n ? 1 : 0);
        parcel.writeInt(this.f2797o ? 1 : 0);
        parcel.writeInt(this.f2798p);
        parcel.writeString(this.f2799q);
        parcel.writeInt(this.f2800r);
        parcel.writeInt(this.f2801s ? 1 : 0);
    }

    public W(Parcel parcel) {
        this.f2789f = parcel.readString();
        this.f2790g = parcel.readString();
        this.f2791h = parcel.readInt() != 0;
        this.f2792i = parcel.readInt();
        this.f2793j = parcel.readInt();
        this.k = parcel.readString();
        this.f2794l = parcel.readInt() != 0;
        this.f2795m = parcel.readInt() != 0;
        this.f2796n = parcel.readInt() != 0;
        this.f2797o = parcel.readInt() != 0;
        this.f2798p = parcel.readInt();
        this.f2799q = parcel.readString();
        this.f2800r = parcel.readInt();
        this.f2801s = parcel.readInt() != 0;
    }
}
