package D2;

import android.webkit.JavascriptInterface;

/* renamed from: D2.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0042v {

    /* renamed from: a, reason: collision with root package name */
    public final String f437a;

    /* renamed from: b, reason: collision with root package name */
    public final C0034m f438b;

    public C0042v(String str, C0034m c0034m) {
        this.f437a = str;
        this.f438b = c0034m;
    }

    @JavascriptInterface
    public void postMessage(String str) {
        this.f438b.f416a.d(new A.j(1, this, str));
    }
}
