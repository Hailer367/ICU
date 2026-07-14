package android.support.v4.media;

import H.g;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new g(5);

    /* renamed from: c, reason: collision with root package name */
    public final String f1017c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f1018d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f1019e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f1020f;

    /* renamed from: g, reason: collision with root package name */
    public final Bitmap f1021g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f1022h;

    /* renamed from: i, reason: collision with root package name */
    public final Bundle f1023i;

    /* renamed from: j, reason: collision with root package name */
    public final Uri f1024j;

    /* renamed from: k, reason: collision with root package name */
    public MediaDescription f1025k;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f1017c = str;
        this.f1018d = charSequence;
        this.f1019e = charSequence2;
        this.f1020f = charSequence3;
        this.f1021g = bitmap;
        this.f1022h = uri;
        this.f1023i = bundle;
        this.f1024j = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f1018d) + ", " + ((Object) this.f1019e) + ", " + ((Object) this.f1020f);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        MediaDescription mediaDescription = this.f1025k;
        if (mediaDescription == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f1017c);
            builder.setTitle(this.f1018d);
            builder.setSubtitle(this.f1019e);
            builder.setDescription(this.f1020f);
            builder.setIconBitmap(this.f1021g);
            builder.setIconUri(this.f1022h);
            builder.setExtras(this.f1023i);
            builder.setMediaUri(this.f1024j);
            mediaDescription = builder.build();
            this.f1025k = mediaDescription;
        }
        mediaDescription.writeToParcel(parcel, i2);
    }
}
