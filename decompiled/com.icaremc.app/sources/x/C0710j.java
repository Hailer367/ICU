package x;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import io.flutter.plugin.platform.C0381e;

/* renamed from: x.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0710j extends B {

    /* renamed from: e, reason: collision with root package name */
    public IconCompat f6376e;

    /* renamed from: f, reason: collision with root package name */
    public IconCompat f6377f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6378g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6379h;

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

    @Override // x.B
    public final void b(C0381e c0381e) {
        Bitmap c4;
        Notification.Builder builder = (Notification.Builder) c0381e.f4327c;
        Context context = c0381e.f4326b;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(builder).setBigContentTitle(this.f6305b);
        IconCompat iconCompat = this.f6376e;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                AbstractC0709i.a(bigContentTitle, iconCompat.h(context));
            } else {
                int i4 = iconCompat.f2508a;
                if (i4 == -1) {
                    i4 = k3.b.n(iconCompat.f2509b);
                }
                if (i4 == 1) {
                    IconCompat iconCompat2 = this.f6376e;
                    int i5 = iconCompat2.f2508a;
                    if (i5 == -1) {
                        Object obj = iconCompat2.f2509b;
                        if (obj instanceof Bitmap) {
                            c4 = (Bitmap) obj;
                        } else {
                            c4 = null;
                        }
                    } else if (i5 == 1) {
                        c4 = (Bitmap) iconCompat2.f2509b;
                    } else if (i5 == 5) {
                        c4 = IconCompat.c((Bitmap) iconCompat2.f2509b, true);
                    } else {
                        throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                    }
                    bigContentTitle = bigContentTitle.bigPicture(c4);
                }
            }
        }
        if (this.f6378g) {
            IconCompat iconCompat3 = this.f6377f;
            if (iconCompat3 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else {
                bigContentTitle.bigLargeIcon(iconCompat3.h(context));
            }
        }
        if (this.f6307d) {
            bigContentTitle.setSummaryText(this.f6306c);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            AbstractC0709i.c(bigContentTitle, this.f6379h);
            AbstractC0709i.b(bigContentTitle, null);
        }
    }

    @Override // x.B
    public final String c() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }

    @Override // x.B
    public final void d(Bundle bundle) {
        IconCompat e4;
        super.d(bundle);
        if (bundle.containsKey("android.largeIcon.big")) {
            this.f6377f = e(bundle.getParcelable("android.largeIcon.big"));
            this.f6378g = true;
        }
        Parcelable parcelable = bundle.getParcelable("android.picture");
        if (parcelable != null) {
            e4 = e(parcelable);
        } else {
            e4 = e(bundle.getParcelable("android.pictureIcon"));
        }
        this.f6376e = e4;
        this.f6379h = bundle.getBoolean("android.showBigPictureWhenCollapsed");
    }
}
