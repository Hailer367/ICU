package u;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.icaremc.doctors.R;
import java.util.ArrayList;

/* renamed from: u.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0319j {

    /* renamed from: B, reason: collision with root package name */
    public String f3739B;

    /* renamed from: C, reason: collision with root package name */
    public String f3740C;

    /* renamed from: D, reason: collision with root package name */
    public long f3741D;

    /* renamed from: F, reason: collision with root package name */
    public final boolean f3743F;

    /* renamed from: G, reason: collision with root package name */
    public final Notification f3744G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f3745H;

    /* renamed from: I, reason: collision with root package name */
    public final ArrayList f3746I;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3747a;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f3751e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f3752f;

    /* renamed from: g, reason: collision with root package name */
    public PendingIntent f3753g;

    /* renamed from: h, reason: collision with root package name */
    public PendingIntent f3754h;

    /* renamed from: i, reason: collision with root package name */
    public IconCompat f3755i;

    /* renamed from: j, reason: collision with root package name */
    public int f3756j;

    /* renamed from: k, reason: collision with root package name */
    public int f3757k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3759m;

    /* renamed from: n, reason: collision with root package name */
    public z f3760n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f3761o;
    public int p;
    public int q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3762r;

    /* renamed from: s, reason: collision with root package name */
    public String f3763s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3764t;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3766v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3767w;

    /* renamed from: x, reason: collision with root package name */
    public String f3768x;
    public Bundle y;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3748b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3749c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f3750d = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public boolean f3758l = true;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3765u = false;
    public int z = 0;

    /* renamed from: A, reason: collision with root package name */
    public int f3738A = 0;

    /* renamed from: E, reason: collision with root package name */
    public int f3742E = 0;

    public C0319j(Context context, String str) {
        Notification notification = new Notification();
        this.f3744G = notification;
        this.f3747a = context;
        this.f3739B = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f3757k = 0;
        this.f3746I = new ArrayList();
        this.f3743F = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        if (charSequence == null) {
            return charSequence;
        }
        if (charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }

    public final Notification a() {
        Notification notification;
        Bundle bundle;
        C0308C c0308c = new C0308C(this);
        C0319j c0319j = c0308c.f3675c;
        z zVar = c0319j.f3760n;
        if (zVar != null) {
            zVar.b(c0308c);
        }
        int i2 = Build.VERSION.SDK_INT;
        Notification.Builder builder = c0308c.f3674b;
        if (i2 >= 26) {
            notification = builder.build();
        } else {
            Notification build = builder.build();
            int i3 = c0308c.f3677e;
            if (i3 != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && i3 == 2) {
                    build.sound = null;
                    build.vibrate = null;
                    build.defaults &= -4;
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && i3 == 1) {
                    build.sound = null;
                    build.vibrate = null;
                    build.defaults &= -4;
                }
            }
            notification = build;
        }
        if (zVar != null) {
            c0319j.f3760n.getClass();
        }
        if (zVar != null && (bundle = notification.extras) != null) {
            zVar.a(bundle);
        }
        return notification;
    }

    public final void c(int i2, boolean z) {
        Notification notification = this.f3744G;
        if (z) {
            notification.flags = i2 | notification.flags;
        } else {
            notification.flags = (~i2) & notification.flags;
        }
    }

    public final void d(Bitmap bitmap) {
        IconCompat d2;
        if (bitmap == null) {
            d2 = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f3747a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
                }
            }
            d2 = IconCompat.d(bitmap);
        }
        this.f3755i = d2;
    }

    public final void e(Uri uri) {
        Notification notification = this.f3744G;
        notification.sound = uri;
        notification.audioStreamType = -1;
        notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
    }

    public final void f(z zVar) {
        if (this.f3760n != zVar) {
            this.f3760n = zVar;
            if (zVar != null && zVar.f3804a != this) {
                zVar.f3804a = this;
                f(zVar);
            }
        }
    }
}
