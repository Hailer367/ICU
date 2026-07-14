package j;

import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity;
import f.InterfaceC0280b;

/* renamed from: j.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0415j implements InterfaceC0280b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InAppBrowserActivity f4993a;

    public C0415j(InAppBrowserActivity inAppBrowserActivity) {
        this.f4993a = inAppBrowserActivity;
    }

    @Override // f.InterfaceC0280b
    public final void a(e.l lVar) {
        InAppBrowserActivity inAppBrowserActivity = this.f4993a;
        AbstractC0420o delegate = inAppBrowserActivity.getDelegate();
        delegate.a();
        inAppBrowserActivity.getSavedStateRegistry().a("androidx:appcompat");
        delegate.d();
    }
}
