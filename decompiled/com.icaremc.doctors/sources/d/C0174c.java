package d;

import E.C0012l;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.M;
import androidx.lifecycle.V;

/* renamed from: d.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0174c implements c1.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2118c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ M f2119d;

    public /* synthetic */ C0174c(M m2, int i2) {
        this.f2118c = i2;
        this.f2119d = m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, W.f] */
    @Override // c1.a
    public final Object invoke() {
        Bundle bundle;
        switch (this.f2118c) {
            case 0:
                this.f2119d.reportFullyDrawn();
                return Q0.j.f722a;
            case 1:
                return k.b(this.f2119d);
            case 2:
                ?? obj = new Object();
                this.f2119d.getNavigationEventDispatcher().a(obj);
                return obj;
            case 3:
                M m2 = this.f2119d;
                Application application = m2.getApplication();
                if (m2.getIntent() != null) {
                    bundle = m2.getIntent().getExtras();
                } else {
                    bundle = null;
                }
                return new V(application, m2, bundle);
            default:
                M m3 = this.f2119d;
                t tVar = new t(new RunnableC0173b(m3, 0));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (!kotlin.jvm.internal.h.a(Looper.myLooper(), Looper.getMainLooper())) {
                        new Handler(Looper.getMainLooper()).post(new B0.e(1, m3, tVar));
                    } else {
                        m3.getLifecycle().a(new C0012l(1, tVar, m3));
                    }
                }
                return tVar;
        }
    }
}
