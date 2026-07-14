package android.support.v4.media;

import L.g;
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
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new g(17);

    /* renamed from: f, reason: collision with root package name */
    public final String f2226f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f2227g;

    /* renamed from: h, reason: collision with root package name */
    public final CharSequence f2228h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f2229i;

    /* renamed from: j, reason: collision with root package name */
    public final Bitmap f2230j;
    public final Uri k;

    /* renamed from: l, reason: collision with root package name */
    public final Bundle f2231l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f2232m;

    /* renamed from: n, reason: collision with root package name */
    public MediaDescription f2233n;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f2226f = str;
        this.f2227g = charSequence;
        this.f2228h = charSequence2;
        this.f2229i = charSequence3;
        this.f2230j = bitmap;
        this.k = uri;
        this.f2231l = bundle;
        this.f2232m = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f2227g) + ", " + ((Object) this.f2228h) + ", " + ((Object) this.f2229i);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        MediaDescription mediaDescription = this.f2233n;
        if (mediaDescription == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f2226f);
            builder.setTitle(this.f2227g);
            builder.setSubtitle(this.f2228h);
            builder.setDescription(this.f2229i);
            builder.setIconBitmap(this.f2230j);
            builder.setIconUri(this.k);
            builder.setExtras(this.f2231l);
            builder.setMediaUri(this.f2232m);
            mediaDescription = builder.build();
            this.f2233n = mediaDescription;
        }
        mediaDescription.writeToParcel(parcel, i4);
    }
}
