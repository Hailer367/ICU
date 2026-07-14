package H;

import a0.C0072n;
import a0.K;
import a0.L;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.fragment.app.C0101b;
import androidx.fragment.app.C0103c;
import androidx.fragment.app.C0106d0;
import androidx.fragment.app.j0;
import androidx.fragment.app.m0;
import androidx.versionedparcelable.ParcelImpl;
import c.C0169d;
import com.google.android.gms.common.ConnectionResult;
import f.C0185a;
import f.C0195k;

/* loaded from: classes.dex */
public final class g implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f303a;

    public /* synthetic */ g(int i2) {
        this.f303a = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x01ac  */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View$BaseSavedState, H.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13, types: [android.support.v4.media.session.ParcelableVolumeInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object, androidx.fragment.app.d0] */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.fragment.app.j0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [a0.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v20, types: [c.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3, types: [a0.K, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [a0.L, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v23, types: [c.a, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createFromParcel(final android.os.Parcel r14) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H.g.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f303a) {
            case 0:
                return new h[i2];
            case 1:
                return new C0072n[i2];
            case 2:
                return new K[i2];
            case 3:
                return new L[i2];
            case 4:
                return new MediaBrowserCompat$MediaItem[i2];
            case 5:
                return new MediaDescriptionCompat[i2];
            case 6:
                return new MediaMetadataCompat[i2];
            case 7:
                return new RatingCompat[i2];
            case 8:
                return new MediaSessionCompat$QueueItem[i2];
            case 9:
                return new MediaSessionCompat$ResultReceiverWrapper[i2];
            case 10:
                return new MediaSessionCompat$Token[i2];
            case 11:
                return new ParcelableVolumeInfo[i2];
            case 12:
                return new PlaybackStateCompat[i2];
            case 13:
                return new C0101b[i2];
            case 14:
                return new C0103c[i2];
            case 15:
                return new C0106d0[i2];
            case 16:
                return new j0[i2];
            case 17:
                return new m0[i2];
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                return new C0169d[i2];
            case 19:
                return new C0185a[i2];
            case 20:
                return new C0195k[i2];
            default:
                return new ParcelImpl[i2];
        }
    }
}
