package N;

import K.C0030e;
import K.InterfaceC0028c;
import K.Q;
import K.V;
import K.W;
import android.content.Context;
import java.util.List;
import l1.InterfaceC0242u;

/* loaded from: classes.dex */
public final class b implements e1.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f613a;

    /* renamed from: b, reason: collision with root package name */
    public final F.h f614b;

    /* renamed from: c, reason: collision with root package name */
    public final c1.l f615c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0242u f616d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f617e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public volatile F.h f618f;

    public b(String str, F.h hVar, c1.l lVar, InterfaceC0242u interfaceC0242u) {
        this.f613a = str;
        this.f614b = hVar;
        this.f615c = lVar;
        this.f616d = interfaceC0242u;
    }

    public final F.h a(Context thisRef, i1.j property) {
        F.h hVar;
        kotlin.jvm.internal.h.e(thisRef, "thisRef");
        kotlin.jvm.internal.h.e(property, "property");
        F.h hVar2 = this.f618f;
        if (hVar2 == null) {
            synchronized (this.f617e) {
                try {
                    if (this.f618f == null) {
                        Context applicationContext = thisRef.getApplicationContext();
                        InterfaceC0028c interfaceC0028c = this.f614b;
                        c1.l lVar = this.f615c;
                        kotlin.jvm.internal.h.d(applicationContext, "applicationContext");
                        List migrations = (List) lVar.invoke(applicationContext);
                        InterfaceC0242u interfaceC0242u = this.f616d;
                        M.a aVar = new M.a(1, applicationContext, this);
                        kotlin.jvm.internal.h.e(migrations, "migrations");
                        W w2 = new W(new V(1, aVar));
                        if (interfaceC0028c == null) {
                            interfaceC0028c = new A0.f(4);
                        }
                        this.f618f = new F.h(6, new F.h(6, new Q(w2, android.support.v4.media.session.a.y(new C0030e(migrations, null)), interfaceC0028c, interfaceC0242u)));
                    }
                    hVar = this.f618f;
                    kotlin.jvm.internal.h.b(hVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return hVar;
        }
        return hVar2;
    }
}
