package u;

import a.AbstractC0051a;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: u.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0317h extends z {

    /* renamed from: e, reason: collision with root package name */
    public IconCompat f3732e;

    /* renamed from: f, reason: collision with root package name */
    public IconCompat f3733f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3734g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3735h;

    public static IconCompat e(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable instanceof Icon) {
                return IconCompat.b((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.d((Bitmap) parcelable);
            }
            return null;
        }
        return null;
    }

    @Override // u.z
    public final void b(C0308C c0308c) {
        Bitmap c2;
        Notification.Builder builder = c0308c.f3674b;
        Context context = c0308c.f3673a;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(builder).setBigContentTitle(this.f3805b);
        IconCompat iconCompat = this.f3732e;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                AbstractC0316g.a(bigContentTitle, iconCompat.h(context));
            } else {
                int i2 = iconCompat.f1289a;
                if (i2 == -1) {
                    i2 = AbstractC0051a.D(iconCompat.f1290b);
                }
                if (i2 == 1) {
                    IconCompat iconCompat2 = this.f3732e;
                    int i3 = iconCompat2.f1289a;
                    if (i3 == -1) {
                        Object obj = iconCompat2.f1290b;
                        if (obj instanceof Bitmap) {
                            c2 = (Bitmap) obj;
                        } else {
                            c2 = null;
                        }
                    } else if (i3 == 1) {
                        c2 = (Bitmap) iconCompat2.f1290b;
                    } else if (i3 == 5) {
                        c2 = IconCompat.c((Bitmap) iconCompat2.f1290b, true);
                    } else {
                        throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                    }
                    bigContentTitle = bigContentTitle.bigPicture(c2);
                }
            }
        }
        if (this.f3734g) {
            IconCompat iconCompat3 = this.f3733f;
            if (iconCompat3 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else {
                bigContentTitle.bigLargeIcon(iconCompat3.h(context));
            }
        }
        if (this.f3807d) {
            bigContentTitle.setSummaryText(this.f3806c);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            AbstractC0316g.c(bigContentTitle, this.f3735h);
            AbstractC0316g.b(bigContentTitle, null);
        }
    }

    @Override // u.z
    public final String c() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }

    @Override // u.z
    public final void d(Bundle bundle) {
        IconCompat e2;
        super.d(bundle);
        if (bundle.containsKey("android.largeIcon.big")) {
            this.f3733f = e(bundle.getParcelable("android.largeIcon.big"));
            this.f3734g = true;
        }
        Parcelable parcelable = bundle.getParcelable("android.picture");
        if (parcelable != null) {
            e2 = e(parcelable);
        } else {
            e2 = e(bundle.getParcelable("android.pictureIcon"));
        }
        this.f3732e = e2;
        this.f3735h = bundle.getBoolean("android.showBigPictureWhenCollapsed");
    }
}
