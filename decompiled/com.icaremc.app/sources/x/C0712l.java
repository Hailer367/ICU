package x;

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
import com.icaremc.app.R;
import io.flutter.plugin.platform.C0381e;
import java.util.ArrayList;

/* renamed from: x.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0712l {

    /* renamed from: B, reason: collision with root package name */
    public String f6383B;

    /* renamed from: C, reason: collision with root package name */
    public String f6384C;

    /* renamed from: D, reason: collision with root package name */
    public long f6385D;

    /* renamed from: F, reason: collision with root package name */
    public final boolean f6387F;

    /* renamed from: G, reason: collision with root package name */
    public final Notification f6388G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f6389H;

    /* renamed from: I, reason: collision with root package name */
    public final ArrayList f6390I;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6391a;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f6395e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f6396f;

    /* renamed from: g, reason: collision with root package name */
    public PendingIntent f6397g;

    /* renamed from: h, reason: collision with root package name */
    public PendingIntent f6398h;

    /* renamed from: i, reason: collision with root package name */
    public IconCompat f6399i;

    /* renamed from: j, reason: collision with root package name */
    public int f6400j;
    public int k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6402m;

    /* renamed from: n, reason: collision with root package name */
    public B f6403n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f6404o;

    /* renamed from: p, reason: collision with root package name */
    public int f6405p;

    /* renamed from: q, reason: collision with root package name */
    public int f6406q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6407r;

    /* renamed from: s, reason: collision with root package name */
    public String f6408s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6409t;

    /* renamed from: v, reason: collision with root package name */
    public boolean f6411v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6412w;

    /* renamed from: x, reason: collision with root package name */
    public String f6413x;

    /* renamed from: y, reason: collision with root package name */
    public Bundle f6414y;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f6392b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f6393c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f6394d = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public boolean f6401l = true;

    /* renamed from: u, reason: collision with root package name */
    public boolean f6410u = false;
    public int z = 0;

    /* renamed from: A, reason: collision with root package name */
    public int f6382A = 0;

    /* renamed from: E, reason: collision with root package name */
    public int f6386E = 0;

    public C0712l(Context context, String str) {
        Notification notification = new Notification();
        this.f6388G = notification;
        this.f6391a = context;
        this.f6383B = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.k = 0;
        this.f6390I = new ArrayList();
        this.f6387F = true;
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
        C0381e c0381e = new C0381e(this);
        C0712l c0712l = (C0712l) c0381e.f4328d;
        B b4 = c0712l.f6403n;
        if (b4 != null) {
            b4.b(c0381e);
        }
        Notification.Builder builder = (Notification.Builder) c0381e.f4327c;
        int i4 = c0381e.f4325a;
        if (Build.VERSION.SDK_INT >= 26) {
            notification = builder.build();
        } else {
            Notification build = builder.build();
            if (i4 != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && i4 == 2) {
                    build.sound = null;
                    build.vibrate = null;
                    build.defaults &= -4;
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && i4 == 1) {
                    build.sound = null;
                    build.vibrate = null;
                    build.defaults &= -4;
                }
            }
            notification = build;
        }
        if (b4 != null) {
            c0712l.f6403n.getClass();
        }
        if (b4 != null && (bundle = notification.extras) != null) {
            b4.a(bundle);
        }
        return notification;
    }

    public final void c(int i4, boolean z) {
        Notification notification = this.f6388G;
        if (z) {
            notification.flags = i4 | notification.flags;
        } else {
            notification.flags = (~i4) & notification.flags;
        }
    }

    public final void d(Bitmap bitmap) {
        IconCompat d4;
        if (bitmap == null) {
            d4 = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f6391a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
                }
            }
            d4 = IconCompat.d(bitmap);
        }
        this.f6399i = d4;
    }

    public final void e(Uri uri) {
        Notification notification = this.f6388G;
        notification.sound = uri;
        notification.audioStreamType = -1;
        notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
    }

    public final void f(B b4) {
        if (this.f6403n != b4) {
            this.f6403n = b4;
            if (b4 != null && b4.f6304a != this) {
                b4.f6304a = this;
                f(b4);
            }
        }
    }
}
