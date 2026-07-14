package X0;

import A2.t;
import Y0.q;
import Y0.s;
import Z0.r;
import android.content.AttributionSource;
import android.content.Context;
import android.os.Build;
import h1.HandlerC0340e;
import java.util.Collections;
import java.util.Set;
import p1.C0580i;
import p1.C0585n;
import t.C0657f;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1992a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1993b;

    /* renamed from: c, reason: collision with root package name */
    public final R1.c f1994c;

    /* renamed from: d, reason: collision with root package name */
    public final E0.a f1995d;

    /* renamed from: e, reason: collision with root package name */
    public final b f1996e;

    /* renamed from: f, reason: collision with root package name */
    public final Y0.a f1997f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1998g;

    /* renamed from: h, reason: collision with root package name */
    public final W0.g f1999h;

    /* renamed from: i, reason: collision with root package name */
    public final Y0.d f2000i;

    public e(Context context, E0.a aVar, b bVar, d dVar) {
        String str;
        AttributionSource attributionSource;
        r.f(context, "Null context is not permitted.");
        r.f(aVar, "Api must not be null.");
        r.f(dVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        r.f(applicationContext, "The provided context did not have an application context.");
        this.f1992a = applicationContext;
        int i4 = Build.VERSION.SDK_INT;
        R1.c cVar = null;
        if (i4 >= 30 && i4 >= 30) {
            str = C.c.b(context);
        } else {
            str = null;
        }
        this.f1993b = str;
        if (i4 >= 31) {
            attributionSource = context.getAttributionSource();
            cVar = new R1.c(20, attributionSource);
        }
        this.f1994c = cVar;
        this.f1995d = aVar;
        this.f1996e = bVar;
        this.f1997f = new Y0.a(aVar, bVar, str);
        Y0.d c4 = Y0.d.c(applicationContext);
        this.f2000i = c4;
        this.f1998g = c4.f2037h.getAndIncrement();
        this.f1999h = dVar.f1991a;
        HandlerC0340e handlerC0340e = c4.f2041m;
        handlerC0340e.sendMessage(handlerC0340e.obtainMessage(7, this));
    }

    public final t a() {
        t tVar = new t(13, false);
        Set set = Collections.EMPTY_SET;
        if (((C0657f) tVar.f99g) == null) {
            tVar.f99g = new C0657f(0);
        }
        ((C0657f) tVar.f99g).addAll(set);
        Context context = this.f1992a;
        tVar.f101i = context.getClass().getName();
        tVar.f100h = context.getPackageName();
        return tVar;
    }

    public final C0585n b(Y0.h hVar) {
        C0580i c0580i = new C0580i();
        Y0.d dVar = this.f2000i;
        HandlerC0340e handlerC0340e = dVar.f2041m;
        handlerC0340e.sendMessage(handlerC0340e.obtainMessage(4, new q(new s(hVar, c0580i, this.f1999h), dVar.f2038i.get(), this)));
        return c0580i.f5821a;
    }
}
