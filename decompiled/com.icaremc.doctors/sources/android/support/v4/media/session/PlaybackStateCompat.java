package android.support.v4.media.session;

import H.g;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new g(12);

    /* renamed from: c, reason: collision with root package name */
    public final int f1038c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1039d;

    /* renamed from: e, reason: collision with root package name */
    public final long f1040e;

    /* renamed from: f, reason: collision with root package name */
    public final float f1041f;

    /* renamed from: g, reason: collision with root package name */
    public final long f1042g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1043h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f1044i;

    /* renamed from: j, reason: collision with root package name */
    public final long f1045j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1046k;

    /* renamed from: l, reason: collision with root package name */
    public final long f1047l;

    /* renamed from: m, reason: collision with root package name */
    public final Bundle f1048m;

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Object();

        /* renamed from: c, reason: collision with root package name */
        public final String f1049c;

        /* renamed from: d, reason: collision with root package name */
        public final CharSequence f1050d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1051e;

        /* renamed from: f, reason: collision with root package name */
        public final Bundle f1052f;

        public CustomAction(Parcel parcel) {
            this.f1049c = parcel.readString();
            this.f1050d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f1051e = parcel.readInt();
            this.f1052f = parcel.readBundle(a.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f1050d) + ", mIcon=" + this.f1051e + ", mExtras=" + this.f1052f;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f1049c);
            TextUtils.writeToParcel(this.f1050d, parcel, i2);
            parcel.writeInt(this.f1051e);
            parcel.writeBundle(this.f1052f);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f1038c = parcel.readInt();
        this.f1039d = parcel.readLong();
        this.f1041f = parcel.readFloat();
        this.f1045j = parcel.readLong();
        this.f1040e = parcel.readLong();
        this.f1042g = parcel.readLong();
        this.f1044i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1046k = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f1047l = parcel.readLong();
        this.f1048m = parcel.readBundle(a.class.getClassLoader());
        this.f1043h = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f1038c + ", position=" + this.f1039d + ", buffered position=" + this.f1040e + ", speed=" + this.f1041f + ", updated=" + this.f1045j + ", actions=" + this.f1042g + ", error code=" + this.f1043h + ", error message=" + this.f1044i + ", custom actions=" + this.f1046k + ", active item id=" + this.f1047l + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1038c);
        parcel.writeLong(this.f1039d);
        parcel.writeFloat(this.f1041f);
        parcel.writeLong(this.f1045j);
        parcel.writeLong(this.f1040e);
        parcel.writeLong(this.f1042g);
        TextUtils.writeToParcel(this.f1044i, parcel, i2);
        parcel.writeTypedList(this.f1046k);
        parcel.writeLong(this.f1047l);
        parcel.writeBundle(this.f1048m);
        parcel.writeInt(this.f1043h);
    }
}
