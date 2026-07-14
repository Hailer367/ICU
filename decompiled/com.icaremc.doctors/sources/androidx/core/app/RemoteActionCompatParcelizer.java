package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import g0.AbstractC0200a;
import g0.b;
import g0.c;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0200a abstractC0200a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVar = remoteActionCompat.f1282a;
        boolean z = true;
        if (abstractC0200a.e(1)) {
            cVar = abstractC0200a.h();
        }
        remoteActionCompat.f1282a = (IconCompat) cVar;
        CharSequence charSequence = remoteActionCompat.f1283b;
        if (abstractC0200a.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) abstractC0200a).f2291e);
        }
        remoteActionCompat.f1283b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f1284c;
        if (abstractC0200a.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) abstractC0200a).f2291e);
        }
        remoteActionCompat.f1284c = charSequence2;
        remoteActionCompat.f1285d = (PendingIntent) abstractC0200a.g(remoteActionCompat.f1285d, 4);
        boolean z2 = remoteActionCompat.f1286e;
        if (abstractC0200a.e(5)) {
            if (((b) abstractC0200a).f2291e.readInt() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        remoteActionCompat.f1286e = z2;
        boolean z3 = remoteActionCompat.f1287f;
        if (!abstractC0200a.e(6)) {
            z = z3;
        } else if (((b) abstractC0200a).f2291e.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f1287f = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0200a abstractC0200a) {
        abstractC0200a.getClass();
        IconCompat iconCompat = remoteActionCompat.f1282a;
        abstractC0200a.i(1);
        abstractC0200a.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1283b;
        abstractC0200a.i(2);
        Parcel parcel = ((b) abstractC0200a).f2291e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f1284c;
        abstractC0200a.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        abstractC0200a.k(remoteActionCompat.f1285d, 4);
        boolean z = remoteActionCompat.f1286e;
        abstractC0200a.i(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f1287f;
        abstractC0200a.i(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
