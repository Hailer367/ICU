package D2;

import android.webkit.DownloadListener;
import s2.InterfaceC0634f;

/* renamed from: D2.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0038q implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    public final C0030i f426a;

    public C0038q(C0030i c0030i) {
        this.f426a = c0030i;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(final String str, final String str2, final String str3, final String str4, final long j4) {
        this.f426a.f401a.d(new Runnable() { // from class: D2.o
            @Override // java.lang.Runnable
            public final void run() {
                C0038q c0038q = C0038q.this;
                C0030i c0030i = c0038q.f426a;
                C0037p c0037p = new C0037p(0);
                String str5 = str;
                T2.h.e(str5, "urlArg");
                String str6 = str2;
                T2.h.e(str6, "userAgentArg");
                String str7 = str3;
                T2.h.e(str7, "contentDispositionArg");
                String str8 = str4;
                T2.h.e(str8, "mimetypeArg");
                L l3 = c0030i.f401a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(c0038q)) {
                    A2.i.p("missing-instance-error", "Callback to `DownloadListener.onDownloadStart` failed because native instance was not in the instance manager.", "");
                } else {
                    new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.DownloadListener.onDownloadStart", l3.b(), null).v(I2.f.C(c0038q, str5, str6, str7, str8, Long.valueOf(j4)), new A1.c(6, c0037p));
                }
            }
        });
    }
}
