package x;

import android.os.Bundle;
import io.flutter.plugin.platform.C0381e;

/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public C0712l f6304a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f6305b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f6306c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6307d = false;

    public void a(Bundle bundle) {
        if (this.f6307d) {
            bundle.putCharSequence("android.summaryText", this.f6306c);
        }
        CharSequence charSequence = this.f6305b;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        String c4 = c();
        if (c4 != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c4);
        }
    }

    public abstract void b(C0381e c0381e);

    public String c() {
        return null;
    }

    public void d(Bundle bundle) {
        if (bundle.containsKey("android.summaryText")) {
            this.f6306c = bundle.getCharSequence("android.summaryText");
            this.f6307d = true;
        }
        this.f6305b = bundle.getCharSequence("android.title.big");
    }
}
