package F;

import android.net.Uri;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f511a;

    /* renamed from: b, reason: collision with root package name */
    public final int f512b;

    /* renamed from: c, reason: collision with root package name */
    public final int f513c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f514d;

    /* renamed from: e, reason: collision with root package name */
    public final String f515e;

    /* renamed from: f, reason: collision with root package name */
    public final int f516f;

    public l(Uri uri, int i4, int i5, boolean z, String str, int i6) {
        uri.getClass();
        this.f511a = uri;
        this.f512b = i4;
        this.f513c = i5;
        this.f514d = z;
        this.f515e = str;
        this.f516f = i6;
    }

    public l(String str, String str2) {
        this.f511a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.f512b = 0;
        this.f513c = 400;
        this.f514d = false;
        this.f515e = str2;
        this.f516f = 0;
    }
}
