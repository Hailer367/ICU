package x;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: x.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0708h {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f6366a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f6367b;

    /* renamed from: c, reason: collision with root package name */
    public final K[] f6368c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6369d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6370e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6371f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6372g;

    /* renamed from: h, reason: collision with root package name */
    public final int f6373h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f6374i;

    /* renamed from: j, reason: collision with root package name */
    public final PendingIntent f6375j;

    public C0708h(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, K[] kArr, boolean z, int i4, boolean z3, boolean z4) {
        this.f6370e = true;
        this.f6367b = iconCompat;
        if (iconCompat != null) {
            int i5 = iconCompat.f2508a;
            if ((i5 == -1 ? k3.b.n(iconCompat.f2509b) : i5) == 2) {
                this.f6373h = iconCompat.f();
            }
        }
        this.f6374i = C0712l.b(charSequence);
        this.f6375j = pendingIntent;
        this.f6366a = bundle == null ? new Bundle() : bundle;
        this.f6368c = kArr;
        this.f6369d = z;
        this.f6371f = i4;
        this.f6370e = z3;
        this.f6372g = z4;
    }

    public final IconCompat a() {
        int i4;
        if (this.f6367b == null && (i4 = this.f6373h) != 0) {
            this.f6367b = IconCompat.e(null, "", i4);
        }
        return this.f6367b;
    }
}
