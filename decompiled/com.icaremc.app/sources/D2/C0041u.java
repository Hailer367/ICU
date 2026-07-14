package D2;

import android.content.Context;
import android.view.View;
import io.flutter.plugin.platform.InterfaceC0382f;
import s2.C0650v;

/* renamed from: D2.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0041u extends io.flutter.plugin.platform.g {

    /* renamed from: a, reason: collision with root package name */
    public final C0024c f436a;

    public C0041u(C0024c c0024c) {
        C0650v c0650v = C0650v.f6160a;
        this.f436a = c0024c;
    }

    @Override // io.flutter.plugin.platform.g
    public final InterfaceC0382f create(Context context, int i4, Object obj) {
        if (((Integer) obj) != null) {
            Object e4 = this.f436a.e(r3.intValue());
            if (e4 instanceof InterfaceC0382f) {
                return (InterfaceC0382f) e4;
            }
            if (e4 instanceof View) {
                return new C0040t((View) e4);
            }
            throw new IllegalStateException("Unable to find a PlatformView or View instance: " + obj + ", " + e4);
        }
        throw new IllegalStateException("An identifier is required to retrieve a View instance.");
    }
}
