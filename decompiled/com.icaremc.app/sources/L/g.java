package L;

import P1.w;
import Z0.C0137c;
import Z0.C0138d;
import Z0.C0140f;
import Z0.k;
import Z0.n;
import Z0.o;
import Z0.z;
import a.AbstractC0141a;
import android.os.IBinder;
import android.os.Parcel;
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
import androidx.fragment.app.C0170b;
import androidx.fragment.app.C0171c;
import androidx.fragment.app.L;
import androidx.fragment.app.S;
import androidx.fragment.app.W;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class g implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f969a;

    public /* synthetic */ g(int i4) {
        this.f969a = i4;
    }

    public static void a(C0138d c0138d, Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        int i5 = c0138d.f2118f;
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(i5);
        int i6 = c0138d.f2119g;
        AbstractC0141a.P(parcel, 2, 4);
        parcel.writeInt(i6);
        int i7 = c0138d.f2120h;
        AbstractC0141a.P(parcel, 3, 4);
        parcel.writeInt(i7);
        AbstractC0141a.M(parcel, 4, c0138d.f2121i);
        IBinder iBinder = c0138d.f2122j;
        if (iBinder != null) {
            int Q3 = AbstractC0141a.Q(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            AbstractC0141a.S(parcel, Q3);
        }
        AbstractC0141a.N(parcel, 6, c0138d.k, i4);
        AbstractC0141a.K(parcel, 7, c0138d.f2123l);
        AbstractC0141a.L(parcel, 8, c0138d.f2124m, i4);
        AbstractC0141a.N(parcel, 10, c0138d.f2125n, i4);
        AbstractC0141a.N(parcel, 11, c0138d.f2126o, i4);
        boolean z = c0138d.f2127p;
        AbstractC0141a.P(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i8 = c0138d.f2128q;
        AbstractC0141a.P(parcel, 13, 4);
        parcel.writeInt(i8);
        boolean z3 = c0138d.f2129r;
        AbstractC0141a.P(parcel, 14, 4);
        parcel.writeInt(z3 ? 1 : 0);
        AbstractC0141a.M(parcel, 15, c0138d.f2130s);
        AbstractC0141a.S(parcel, Q2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 607
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // android.os.Parcelable.Creator
    public final java.lang.Object createFromParcel(android.os.Parcel r24) {
        /*
            Method dump skipped, instructions count: 1904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L.g.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f969a) {
            case 0:
                return new h[i4];
            case 1:
                return new w[i4];
            case 2:
                return new GoogleSignInAccount[i4];
            case 3:
                return new W0.a[i4];
            case 4:
                return new W0.c[i4];
            case 5:
                return new Scope[i4];
            case 6:
                return new Status[i4];
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return new Z0.i[i4];
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return new k[i4];
            case 9:
                return new C0140f[i4];
            case 10:
                return new n[i4];
            case 11:
                return new o[i4];
            case 12:
                return new Z0.h[i4];
            case 13:
                return new z[i4];
            case 14:
                return new C0137c[i4];
            case 15:
                return new C0138d[i4];
            case 16:
                return new MediaBrowserCompat$MediaItem[i4];
            case 17:
                return new MediaDescriptionCompat[i4];
            case 18:
                return new MediaMetadataCompat[i4];
            case 19:
                return new RatingCompat[i4];
            case 20:
                return new MediaSessionCompat$QueueItem[i4];
            case 21:
                return new MediaSessionCompat$ResultReceiverWrapper[i4];
            case 22:
                return new MediaSessionCompat$Token[i4];
            case 23:
                return new ParcelableVolumeInfo[i4];
            case 24:
                return new PlaybackStateCompat[i4];
            case 25:
                return new C0170b[i4];
            case 26:
                return new C0171c[i4];
            case 27:
                return new L[i4];
            case 28:
                return new S[i4];
            default:
                return new W[i4];
        }
    }
}
