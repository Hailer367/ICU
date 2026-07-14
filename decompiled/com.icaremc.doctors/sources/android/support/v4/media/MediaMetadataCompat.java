package android.support.v4.media;

import H.g;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.a;
import r.j;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f1026c;

    static {
        j jVar = new j(0);
        jVar.put("android.media.metadata.TITLE", 1);
        jVar.put("android.media.metadata.ARTIST", 1);
        jVar.put("android.media.metadata.DURATION", 0);
        jVar.put("android.media.metadata.ALBUM", 1);
        jVar.put("android.media.metadata.AUTHOR", 1);
        jVar.put("android.media.metadata.WRITER", 1);
        jVar.put("android.media.metadata.COMPOSER", 1);
        jVar.put("android.media.metadata.COMPILATION", 1);
        jVar.put("android.media.metadata.DATE", 1);
        jVar.put("android.media.metadata.YEAR", 0);
        jVar.put("android.media.metadata.GENRE", 1);
        jVar.put("android.media.metadata.TRACK_NUMBER", 0);
        jVar.put("android.media.metadata.NUM_TRACKS", 0);
        jVar.put("android.media.metadata.DISC_NUMBER", 0);
        jVar.put("android.media.metadata.ALBUM_ARTIST", 1);
        jVar.put("android.media.metadata.ART", 2);
        jVar.put("android.media.metadata.ART_URI", 1);
        jVar.put("android.media.metadata.ALBUM_ART", 2);
        jVar.put("android.media.metadata.ALBUM_ART_URI", 1);
        jVar.put("android.media.metadata.USER_RATING", 3);
        jVar.put("android.media.metadata.RATING", 3);
        jVar.put("android.media.metadata.DISPLAY_TITLE", 1);
        jVar.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        jVar.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        jVar.put("android.media.metadata.DISPLAY_ICON", 2);
        jVar.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        jVar.put("android.media.metadata.MEDIA_ID", 1);
        jVar.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        jVar.put("android.media.metadata.MEDIA_URI", 1);
        jVar.put("android.media.metadata.ADVERTISEMENT", 0);
        jVar.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        CREATOR = new g(6);
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f1026c = parcel.readBundle(a.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f1026c);
    }
}
