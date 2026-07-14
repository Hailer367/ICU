package d0;

import android.window.OnBackInvokedCallback;
import h2.AbstractActivityC0349b;
import j.LayoutInflaterFactory2C0393A;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3459a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3460b;

    public /* synthetic */ j(int i4, Object obj) {
        this.f3459a = i4;
        this.f3460b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f3459a) {
            case 0:
                ((i) this.f3460b).a();
                return;
            case 1:
                ((AbstractActivityC0349b) this.f3460b).onBackPressed();
                return;
            case 2:
                ((LayoutInflaterFactory2C0393A) this.f3460b).E();
                return;
            default:
                ((Runnable) this.f3460b).run();
                return;
        }
    }
}
