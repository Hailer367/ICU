package e;

import I.C0059m;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.AbstractActivityC0192y;
import androidx.lifecycle.P;

/* renamed from: e.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0268c implements S2.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3548f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0192y f3549g;

    public /* synthetic */ C0268c(AbstractActivityC0192y abstractActivityC0192y, int i4) {
        this.f3548f = i4;
        this.f3549g = abstractActivityC0192y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, d0.e] */
    @Override // S2.a
    public final Object a() {
        Bundle bundle;
        switch (this.f3548f) {
            case 0:
                this.f3549g.reportFullyDrawn();
                return H2.i.f681a;
            case 1:
                return l.b(this.f3549g);
            case 2:
                ?? obj = new Object();
                this.f3549g.getNavigationEventDispatcher().a(obj);
                return obj;
            case 3:
                AbstractActivityC0192y abstractActivityC0192y = this.f3549g;
                Application application = abstractActivityC0192y.getApplication();
                if (abstractActivityC0192y.getIntent() != null) {
                    bundle = abstractActivityC0192y.getIntent().getExtras();
                } else {
                    bundle = null;
                }
                return new P(application, abstractActivityC0192y, bundle);
            default:
                AbstractActivityC0192y abstractActivityC0192y2 = this.f3549g;
                t tVar = new t(new RunnableC0267b(abstractActivityC0192y2, 0));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (!T2.h.a(Looper.myLooper(), Looper.getMainLooper())) {
                        new Handler(Looper.getMainLooper()).post(new A.j(6, abstractActivityC0192y2, tVar));
                    } else {
                        abstractActivityC0192y2.getLifecycle().a(new C0059m(1, tVar, abstractActivityC0192y2));
                    }
                }
                return tVar;
        }
    }
}
