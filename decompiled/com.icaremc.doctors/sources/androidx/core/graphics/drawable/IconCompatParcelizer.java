package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import g0.AbstractC0200a;
import g0.b;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC0200a abstractC0200a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1289a = abstractC0200a.f(iconCompat.f1289a, 1);
        byte[] bArr = iconCompat.f1291c;
        if (abstractC0200a.e(2)) {
            Parcel parcel = ((b) abstractC0200a).f2291e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f1291c = bArr;
        iconCompat.f1292d = abstractC0200a.g(iconCompat.f1292d, 3);
        iconCompat.f1293e = abstractC0200a.f(iconCompat.f1293e, 4);
        iconCompat.f1294f = abstractC0200a.f(iconCompat.f1294f, 5);
        iconCompat.f1295g = (ColorStateList) abstractC0200a.g(iconCompat.f1295g, 6);
        String str = iconCompat.f1297i;
        if (abstractC0200a.e(7)) {
            str = ((b) abstractC0200a).f2291e.readString();
        }
        iconCompat.f1297i = str;
        String str2 = iconCompat.f1298j;
        if (abstractC0200a.e(8)) {
            str2 = ((b) abstractC0200a).f2291e.readString();
        }
        iconCompat.f1298j = str2;
        iconCompat.f1296h = PorterDuff.Mode.valueOf(iconCompat.f1297i);
        switch (iconCompat.f1289a) {
            case -1:
                Parcelable parcelable = iconCompat.f1292d;
                if (parcelable != null) {
                    iconCompat.f1290b = parcelable;
                    return iconCompat;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f1292d;
                if (parcelable2 != null) {
                    iconCompat.f1290b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f1291c;
                iconCompat.f1290b = bArr3;
                iconCompat.f1289a = 3;
                iconCompat.f1293e = 0;
                iconCompat.f1294f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f1291c, Charset.forName("UTF-16"));
                iconCompat.f1290b = str3;
                if (iconCompat.f1289a == 2 && iconCompat.f1298j == null) {
                    iconCompat.f1298j = str3.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f1290b = iconCompat.f1291c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC0200a abstractC0200a) {
        abstractC0200a.getClass();
        iconCompat.f1297i = iconCompat.f1296h.name();
        switch (iconCompat.f1289a) {
            case -1:
                iconCompat.f1292d = (Parcelable) iconCompat.f1290b;
                break;
            case 1:
            case 5:
                iconCompat.f1292d = (Parcelable) iconCompat.f1290b;
                break;
            case 2:
                iconCompat.f1291c = ((String) iconCompat.f1290b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1291c = (byte[]) iconCompat.f1290b;
                break;
            case 4:
            case 6:
                iconCompat.f1291c = iconCompat.f1290b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i2 = iconCompat.f1289a;
        if (-1 != i2) {
            abstractC0200a.j(i2, 1);
        }
        byte[] bArr = iconCompat.f1291c;
        if (bArr != null) {
            abstractC0200a.i(2);
            Parcel parcel = ((b) abstractC0200a).f2291e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f1292d;
        if (parcelable != null) {
            abstractC0200a.k(parcelable, 3);
        }
        int i3 = iconCompat.f1293e;
        if (i3 != 0) {
            abstractC0200a.j(i3, 4);
        }
        int i4 = iconCompat.f1294f;
        if (i4 != 0) {
            abstractC0200a.j(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f1295g;
        if (colorStateList != null) {
            abstractC0200a.k(colorStateList, 6);
        }
        String str = iconCompat.f1297i;
        if (str != null) {
            abstractC0200a.i(7);
            ((b) abstractC0200a).f2291e.writeString(str);
        }
        String str2 = iconCompat.f1298j;
        if (str2 != null) {
            abstractC0200a.i(8);
            ((b) abstractC0200a).f2291e.writeString(str2);
        }
    }
}
