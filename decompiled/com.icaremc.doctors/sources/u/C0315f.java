package u;

import a.AbstractC0051a;
import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.google.firebase.encoders.json.BuildConfig;

/* renamed from: u.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0315f {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3722a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f3723b;

    /* renamed from: c, reason: collision with root package name */
    public final M[] f3724c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3725d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3726e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3727f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3728g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3729h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f3730i;

    /* renamed from: j, reason: collision with root package name */
    public final PendingIntent f3731j;

    public C0315f(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, M[] mArr, boolean z, int i2, boolean z2, boolean z3) {
        this.f3726e = true;
        this.f3723b = iconCompat;
        if (iconCompat != null) {
            int i3 = iconCompat.f1289a;
            if ((i3 == -1 ? AbstractC0051a.D(iconCompat.f1290b) : i3) == 2) {
                this.f3729h = iconCompat.f();
            }
        }
        this.f3730i = C0319j.b(charSequence);
        this.f3731j = pendingIntent;
        this.f3722a = bundle == null ? new Bundle() : bundle;
        this.f3724c = mArr;
        this.f3725d = z;
        this.f3727f = i2;
        this.f3726e = z2;
        this.f3728g = z3;
    }

    public final IconCompat a() {
        int i2;
        if (this.f3723b == null && (i2 = this.f3729h) != 0) {
            this.f3723b = IconCompat.e(null, BuildConfig.FLAVOR, i2);
        }
        return this.f3723b;
    }
}
