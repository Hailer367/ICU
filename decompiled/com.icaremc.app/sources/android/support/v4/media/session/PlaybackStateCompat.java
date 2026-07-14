package android.support.v4.media.session;

import L.g;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new g(24);

    /* renamed from: f, reason: collision with root package name */
    public final int f2246f;

    /* renamed from: g, reason: collision with root package name */
    public final long f2247g;

    /* renamed from: h, reason: collision with root package name */
    public final long f2248h;

    /* renamed from: i, reason: collision with root package name */
    public final float f2249i;

    /* renamed from: j, reason: collision with root package name */
    public final long f2250j;
    public final int k;

    /* renamed from: l, reason: collision with root package name */
    public final CharSequence f2251l;

    /* renamed from: m, reason: collision with root package name */
    public final long f2252m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f2253n;

    /* renamed from: o, reason: collision with root package name */
    public final long f2254o;

    /* renamed from: p, reason: collision with root package name */
    public final Bundle f2255p;

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Object();

        /* renamed from: f, reason: collision with root package name */
        public final String f2256f;

        /* renamed from: g, reason: collision with root package name */
        public final CharSequence f2257g;

        /* renamed from: h, reason: collision with root package name */
        public final int f2258h;

        /* renamed from: i, reason: collision with root package name */
        public final Bundle f2259i;

        public CustomAction(Parcel parcel) {
            this.f2256f = parcel.readString();
            this.f2257g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2258h = parcel.readInt();
            this.f2259i = parcel.readBundle(a.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f2257g) + ", mIcon=" + this.f2258h + ", mExtras=" + this.f2259i;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f2256f);
            TextUtils.writeToParcel(this.f2257g, parcel, i4);
            parcel.writeInt(this.f2258h);
            parcel.writeBundle(this.f2259i);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f2246f = parcel.readInt();
        this.f2247g = parcel.readLong();
        this.f2249i = parcel.readFloat();
        this.f2252m = parcel.readLong();
        this.f2248h = parcel.readLong();
        this.f2250j = parcel.readLong();
        this.f2251l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2253n = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f2254o = parcel.readLong();
        this.f2255p = parcel.readBundle(a.class.getClassLoader());
        this.k = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f2246f + ", position=" + this.f2247g + ", buffered position=" + this.f2248h + ", speed=" + this.f2249i + ", updated=" + this.f2252m + ", actions=" + this.f2250j + ", error code=" + this.k + ", error message=" + this.f2251l + ", custom actions=" + this.f2253n + ", active item id=" + this.f2254o + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2246f);
        parcel.writeLong(this.f2247g);
        parcel.writeFloat(this.f2249i);
        parcel.writeLong(this.f2252m);
        parcel.writeLong(this.f2248h);
        parcel.writeLong(this.f2250j);
        TextUtils.writeToParcel(this.f2251l, parcel, i4);
        parcel.writeTypedList(this.f2253n);
        parcel.writeLong(this.f2254o);
        parcel.writeBundle(this.f2255p);
        parcel.writeInt(this.k);
    }
}
