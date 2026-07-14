package i2;

import A2.t;
import android.content.Context;
import h2.AbstractActivityC0349b;
import io.flutter.plugin.platform.r;
import j2.C0426a;
import java.util.ArrayList;
import java.util.List;
import m2.C0447e;
import s2.C0644p;

/* renamed from: i2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0372g {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4144a = new ArrayList();

    public C0372g(AbstractActivityC0349b abstractActivityC0349b, String[] strArr) {
        C0447e c0447e = (C0447e) t.O().f99g;
        if (!c0447e.f5203a) {
            c0447e.d(abstractActivityC0349b.getApplicationContext());
            c0447e.a(abstractActivityC0349b.getApplicationContext(), strArr);
        }
    }

    public final C0368c a(C0371f c0371f) {
        C0368c c0368c;
        Context context = c0371f.f4138a;
        C0426a c0426a = c0371f.f4139b;
        String str = c0371f.f4140c;
        List<String> list = c0371f.f4141d;
        r rVar = new r();
        boolean z = c0371f.f4142e;
        boolean z3 = c0371f.f4143f;
        if (c0426a == null) {
            C0447e c0447e = (C0447e) t.O().f99g;
            if (c0447e.f5203a) {
                c0426a = new C0426a((String) c0447e.f5206d.f1439c, "main");
            } else {
                throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
            }
        }
        C0426a c0426a2 = c0426a;
        ArrayList arrayList = this.f4144a;
        if (arrayList.size() == 0) {
            c0368c = new C0368c(context, null, rVar, null, z, z3);
            if (str != null) {
                ((C0644p) c0368c.f4114i.f4911g).a("setInitialRoute", str, null);
            }
            c0368c.f4108c.d(c0426a2, list);
        } else {
            C0368c c0368c2 = (C0368c) arrayList.get(0);
            if (c0368c2.f4106a.isAttached()) {
                c0368c = new C0368c(context, c0368c2.f4106a.spawn(c0426a2.f5055c, c0426a2.f5054b, str, list, C0368c.f4105y), rVar, null, z, z3);
            } else {
                throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
            }
        }
        arrayList.add(c0368c);
        c0368c.f4126v.add(new C0370e(this, c0368c));
        return c0368c;
    }
}
