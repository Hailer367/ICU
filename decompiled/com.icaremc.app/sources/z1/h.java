package z1;

import O.InterfaceC0080i;
import S2.l;
import T2.m;
import T2.q;
import android.content.Context;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ Y2.c[] f6647d;

    /* renamed from: a, reason: collision with root package name */
    public final String f6648a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadLocal f6649b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0080i f6650c;

    static {
        m mVar = new m(T2.b.f1629f, h.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        q.f1646a.getClass();
        f6647d = new Y2.c[]{mVar};
    }

    public h(Context context, String str) {
        T2.h.e(context, "context");
        T2.h.e(str, "name");
        this.f6648a = str;
        this.f6649b = new ThreadLocal();
        this.f6650c = android.support.v4.media.session.a.s(str, new A2.q(8, new C0748a(this, 0)), new C0748a(this, 1), 8).a(context, f6647d[0]);
    }

    public final void a(l lVar) {
    }
}
