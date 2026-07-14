package B;

import android.net.Uri;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f68a;

    /* renamed from: b, reason: collision with root package name */
    public final int f69b;

    /* renamed from: c, reason: collision with root package name */
    public final int f70c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f71d;

    /* renamed from: e, reason: collision with root package name */
    public final String f72e;

    /* renamed from: f, reason: collision with root package name */
    public final int f73f;

    public m(Uri uri, int i2, int i3, boolean z, String str, int i4) {
        uri.getClass();
        this.f68a = uri;
        this.f69b = i2;
        this.f70c = i3;
        this.f71d = z;
        this.f72e = str;
        this.f73f = i4;
    }

    public m(String str, String str2) {
        this.f68a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.f69b = 0;
        this.f70c = 400;
        this.f71d = false;
        this.f72e = str2;
        this.f73f = 0;
    }
}
