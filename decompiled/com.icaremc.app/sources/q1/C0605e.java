package q1;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import d2.C0261b;
import n.p;
import p1.C0580i;
import p1.C0585n;
import r1.o;

/* renamed from: q1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0605e {

    /* renamed from: a, reason: collision with root package name */
    public final j f5951a;

    /* renamed from: b, reason: collision with root package name */
    public final C0603c f5952b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f5953c;

    public C0605e(j jVar, C0603c c0603c, Context context) {
        new Handler(Looper.getMainLooper());
        this.f5951a = jVar;
        this.f5952b = c0603c;
        this.f5953c = context;
    }

    public static void c(C0601a c0601a, Activity activity, l lVar) {
        if (activity != null && c0601a != null && c0601a.b(lVar) != null && !c0601a.f5942j) {
            c0601a.f5942j = true;
            activity.startIntentSenderForResult(c0601a.b(lVar).getIntentSender(), 1276, null, 0, 0, 0, null);
        }
    }

    public final C0585n a() {
        String packageName = this.f5953c.getPackageName();
        j jVar = this.f5951a;
        o oVar = jVar.f5964a;
        if (oVar == null) {
            p pVar = j.f5962e;
            Object[] objArr = {-9};
            pVar.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", p.p((String) pVar.f5322g, "onError(%d)", objArr));
            }
            return AbstractC0602b.z(new X0.i(-9));
        }
        j.f5962e.o("requestUpdateInfo(%s)", packageName);
        C0580i c0580i = new C0580i();
        oVar.a().post(new f(oVar, c0580i, c0580i, new f(jVar, c0580i, packageName, c0580i), 2));
        return c0580i.f5821a;
    }

    public final synchronized void b(C0261b c0261b) {
        C0603c c0603c = this.f5952b;
        synchronized (c0603c) {
            c0603c.f5944a.o("registerListener", new Object[0]);
            c0603c.f5947d.add(c0261b);
            c0603c.a();
        }
    }
}
