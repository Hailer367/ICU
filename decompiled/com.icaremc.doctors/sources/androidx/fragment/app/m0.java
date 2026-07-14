package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class m0 implements Parcelable {
    public static final Parcelable.Creator<m0> CREATOR = new H.g(17);

    /* renamed from: c, reason: collision with root package name */
    public final String f1679c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1680d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1681e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1682f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1683g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1684h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f1685i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f1686j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f1687k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f1688l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1689m;

    /* renamed from: n, reason: collision with root package name */
    public final String f1690n;

    /* renamed from: o, reason: collision with root package name */
    public final int f1691o;
    public final boolean p;

    public m0(H h2) {
        this.f1679c = h2.getClass().getName();
        this.f1680d = h2.mWho;
        this.f1681e = h2.mFromLayout;
        this.f1682f = h2.mFragmentId;
        this.f1683g = h2.mContainerId;
        this.f1684h = h2.mTag;
        this.f1685i = h2.mRetainInstance;
        this.f1686j = h2.mRemoving;
        this.f1687k = h2.mDetached;
        this.f1688l = h2.mHidden;
        this.f1689m = h2.mMaxState.ordinal();
        this.f1690n = h2.mTargetWho;
        this.f1691o = h2.mTargetRequestCode;
        this.p = h2.mUserVisibleHint;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1679c);
        sb.append(" (");
        sb.append(this.f1680d);
        sb.append(")}:");
        if (this.f1681e) {
            sb.append(" fromLayout");
        }
        int i2 = this.f1683g;
        if (i2 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i2));
        }
        String str = this.f1684h;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f1685i) {
            sb.append(" retainInstance");
        }
        if (this.f1686j) {
            sb.append(" removing");
        }
        if (this.f1687k) {
            sb.append(" detached");
        }
        if (this.f1688l) {
            sb.append(" hidden");
        }
        String str2 = this.f1690n;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.f1691o);
        }
        if (this.p) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f1679c);
        parcel.writeString(this.f1680d);
        parcel.writeInt(this.f1681e ? 1 : 0);
        parcel.writeInt(this.f1682f);
        parcel.writeInt(this.f1683g);
        parcel.writeString(this.f1684h);
        parcel.writeInt(this.f1685i ? 1 : 0);
        parcel.writeInt(this.f1686j ? 1 : 0);
        parcel.writeInt(this.f1687k ? 1 : 0);
        parcel.writeInt(this.f1688l ? 1 : 0);
        parcel.writeInt(this.f1689m);
        parcel.writeString(this.f1690n);
        parcel.writeInt(this.f1691o);
        parcel.writeInt(this.p ? 1 : 0);
    }

    public m0(Parcel parcel) {
        this.f1679c = parcel.readString();
        this.f1680d = parcel.readString();
        this.f1681e = parcel.readInt() != 0;
        this.f1682f = parcel.readInt();
        this.f1683g = parcel.readInt();
        this.f1684h = parcel.readString();
        this.f1685i = parcel.readInt() != 0;
        this.f1686j = parcel.readInt() != 0;
        this.f1687k = parcel.readInt() != 0;
        this.f1688l = parcel.readInt() != 0;
        this.f1689m = parcel.readInt();
        this.f1690n = parcel.readString();
        this.f1691o = parcel.readInt();
        this.p = parcel.readInt() != 0;
    }
}
