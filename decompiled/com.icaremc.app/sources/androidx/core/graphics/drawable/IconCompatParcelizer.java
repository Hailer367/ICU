package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import o0.AbstractC0557a;
import o0.C0558b;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC0557a abstractC0557a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2508a = abstractC0557a.f(iconCompat.f2508a, 1);
        byte[] bArr = iconCompat.f2510c;
        if (abstractC0557a.e(2)) {
            Parcel parcel = ((C0558b) abstractC0557a).f5763e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f2510c = bArr;
        iconCompat.f2511d = abstractC0557a.g(iconCompat.f2511d, 3);
        iconCompat.f2512e = abstractC0557a.f(iconCompat.f2512e, 4);
        iconCompat.f2513f = abstractC0557a.f(iconCompat.f2513f, 5);
        iconCompat.f2514g = (ColorStateList) abstractC0557a.g(iconCompat.f2514g, 6);
        String str = iconCompat.f2516i;
        if (abstractC0557a.e(7)) {
            str = ((C0558b) abstractC0557a).f5763e.readString();
        }
        iconCompat.f2516i = str;
        String str2 = iconCompat.f2517j;
        if (abstractC0557a.e(8)) {
            str2 = ((C0558b) abstractC0557a).f5763e.readString();
        }
        iconCompat.f2517j = str2;
        iconCompat.f2515h = PorterDuff.Mode.valueOf(iconCompat.f2516i);
        switch (iconCompat.f2508a) {
            case -1:
                Parcelable parcelable = iconCompat.f2511d;
                if (parcelable != null) {
                    iconCompat.f2509b = parcelable;
                    return iconCompat;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f2511d;
                if (parcelable2 != null) {
                    iconCompat.f2509b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f2510c;
                iconCompat.f2509b = bArr3;
                iconCompat.f2508a = 3;
                iconCompat.f2512e = 0;
                iconCompat.f2513f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f2510c, Charset.forName("UTF-16"));
                iconCompat.f2509b = str3;
                if (iconCompat.f2508a == 2 && iconCompat.f2517j == null) {
                    iconCompat.f2517j = str3.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f2509b = iconCompat.f2510c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC0557a abstractC0557a) {
        abstractC0557a.getClass();
        iconCompat.f2516i = iconCompat.f2515h.name();
        switch (iconCompat.f2508a) {
            case -1:
                iconCompat.f2511d = (Parcelable) iconCompat.f2509b;
                break;
            case 1:
            case 5:
                iconCompat.f2511d = (Parcelable) iconCompat.f2509b;
                break;
            case 2:
                iconCompat.f2510c = ((String) iconCompat.f2509b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f2510c = (byte[]) iconCompat.f2509b;
                break;
            case 4:
            case 6:
                iconCompat.f2510c = iconCompat.f2509b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i4 = iconCompat.f2508a;
        if (-1 != i4) {
            abstractC0557a.j(i4, 1);
        }
        byte[] bArr = iconCompat.f2510c;
        if (bArr != null) {
            abstractC0557a.i(2);
            Parcel parcel = ((C0558b) abstractC0557a).f5763e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f2511d;
        if (parcelable != null) {
            abstractC0557a.k(parcelable, 3);
        }
        int i5 = iconCompat.f2512e;
        if (i5 != 0) {
            abstractC0557a.j(i5, 4);
        }
        int i6 = iconCompat.f2513f;
        if (i6 != 0) {
            abstractC0557a.j(i6, 5);
        }
        ColorStateList colorStateList = iconCompat.f2514g;
        if (colorStateList != null) {
            abstractC0557a.k(colorStateList, 6);
        }
        String str = iconCompat.f2516i;
        if (str != null) {
            abstractC0557a.i(7);
            ((C0558b) abstractC0557a).f5763e.writeString(str);
        }
        String str2 = iconCompat.f2517j;
        if (str2 != null) {
            abstractC0557a.i(8);
            ((C0558b) abstractC0557a).f5763e.writeString(str2);
        }
    }
}
