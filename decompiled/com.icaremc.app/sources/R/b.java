package R;

import A2.q;
import O.C0076e;
import O.N;
import O.S;
import O.T;
import android.content.Context;
import b3.InterfaceC0243s;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1515a;

    /* renamed from: b, reason: collision with root package name */
    public final q f1516b;

    /* renamed from: c, reason: collision with root package name */
    public final S2.l f1517c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0243s f1518d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1519e;

    /* renamed from: f, reason: collision with root package name */
    public volatile R1.c f1520f;

    public b(String str, q qVar, S2.l lVar, InterfaceC0243s interfaceC0243s) {
        T2.h.e(str, "name");
        this.f1515a = str;
        this.f1516b = qVar;
        this.f1517c = lVar;
        this.f1518d = interfaceC0243s;
        this.f1519e = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final R1.c a(Context context, Y2.c cVar) {
        R1.c cVar2;
        T2.h.e(context, "thisRef");
        T2.h.e(cVar, "property");
        R1.c cVar3 = this.f1520f;
        if (cVar3 == null) {
            synchronized (this.f1519e) {
                try {
                    if (this.f1520f == null) {
                        Context applicationContext = context.getApplicationContext();
                        q qVar = this.f1516b;
                        S2.l lVar = this.f1517c;
                        T2.h.d(applicationContext, "applicationContext");
                        List list = (List) lVar.f(applicationContext);
                        InterfaceC0243s interfaceC0243s = this.f1518d;
                        Q.a aVar = new Q.a(1, applicationContext, this);
                        T2.h.e(list, "migrations");
                        this.f1520f = new R1.c(11, new R1.c(11, new N(new T(new S(1, aVar)), android.support.v4.media.session.a.p(new C0076e(list, null)), qVar != null ? qVar : new Object(), interfaceC0243s)));
                    }
                    cVar2 = this.f1520f;
                    T2.h.b(cVar2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return cVar2;
        }
        return cVar3;
    }
}
