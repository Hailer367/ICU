package u;

import android.os.Bundle;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public C0319j f3804a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f3805b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f3806c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3807d = false;

    public void a(Bundle bundle) {
        if (this.f3807d) {
            bundle.putCharSequence("android.summaryText", this.f3806c);
        }
        CharSequence charSequence = this.f3805b;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        String c2 = c();
        if (c2 != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c2);
        }
    }

    public abstract void b(C0308C c0308c);

    public String c() {
        return null;
    }

    public void d(Bundle bundle) {
        if (bundle.containsKey("android.summaryText")) {
            this.f3806c = bundle.getCharSequence("android.summaryText");
            this.f3807d = true;
        }
        this.f3805b = bundle.getCharSequence("android.title.big");
    }
}
