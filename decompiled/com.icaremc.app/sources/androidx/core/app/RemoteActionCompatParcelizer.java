package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import o0.AbstractC0557a;
import o0.C0558b;
import o0.InterfaceC0559c;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0557a abstractC0557a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        InterfaceC0559c interfaceC0559c = remoteActionCompat.f2502a;
        boolean z = true;
        if (abstractC0557a.e(1)) {
            interfaceC0559c = abstractC0557a.h();
        }
        remoteActionCompat.f2502a = (IconCompat) interfaceC0559c;
        CharSequence charSequence = remoteActionCompat.f2503b;
        if (abstractC0557a.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0558b) abstractC0557a).f5763e);
        }
        remoteActionCompat.f2503b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f2504c;
        if (abstractC0557a.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0558b) abstractC0557a).f5763e);
        }
        remoteActionCompat.f2504c = charSequence2;
        remoteActionCompat.f2505d = (PendingIntent) abstractC0557a.g(remoteActionCompat.f2505d, 4);
        boolean z3 = remoteActionCompat.f2506e;
        if (abstractC0557a.e(5)) {
            if (((C0558b) abstractC0557a).f5763e.readInt() != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        remoteActionCompat.f2506e = z3;
        boolean z4 = remoteActionCompat.f2507f;
        if (!abstractC0557a.e(6)) {
            z = z4;
        } else if (((C0558b) abstractC0557a).f5763e.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f2507f = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0557a abstractC0557a) {
        abstractC0557a.getClass();
        IconCompat iconCompat = remoteActionCompat.f2502a;
        abstractC0557a.i(1);
        abstractC0557a.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f2503b;
        abstractC0557a.i(2);
        Parcel parcel = ((C0558b) abstractC0557a).f5763e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f2504c;
        abstractC0557a.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        abstractC0557a.k(remoteActionCompat.f2505d, 4);
        boolean z = remoteActionCompat.f2506e;
        abstractC0557a.i(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z3 = remoteActionCompat.f2507f;
        abstractC0557a.i(6);
        parcel.writeInt(z3 ? 1 : 0);
    }
}
