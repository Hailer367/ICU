package s;

import android.os.Bundle;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0624a implements InterfaceC0625b {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f6116f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6117g;

    public C0624a(int i4, boolean z) {
        this.f6116f = z;
        this.f6117g = i4;
    }

    @Override // s.InterfaceC0625b
    public final Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.browser.trusted.displaymode.KEY_ID", 1);
        bundle.putBoolean("androidx.browser.trusted.displaymode.KEY_STICKY", this.f6116f);
        bundle.putInt("androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE", this.f6117g);
        return bundle;
    }
}
