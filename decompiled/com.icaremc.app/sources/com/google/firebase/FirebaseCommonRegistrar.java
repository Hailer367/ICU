package com.google.firebase;

import D2.K;
import H1.e;
import H1.h;
import R1.a;
import R1.b;
import android.content.Context;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import f1.AbstractC0286a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import q1.AbstractC0602b;
import r2.c;
import u1.f;
import w1.InterfaceC0696a;
import x1.C0721a;
import x1.g;
import x1.o;

/* loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(o.a(b.class));
        for (Class cls : new Class[0]) {
            AbstractC0602b.h(cls, "Null interface");
            hashSet.add(o.a(cls));
        }
        g gVar = new g(2, 0, a.class);
        if (!hashSet.contains(gVar.f6475a)) {
            hashSet2.add(gVar);
            arrayList.add(new C0721a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new K(21), hashSet3));
            o oVar = new o(InterfaceC0696a.class, Executor.class);
            c cVar = new c(e.class, new Class[]{H1.g.class, h.class});
            cVar.a(g.a(Context.class));
            cVar.a(g.a(f.class));
            cVar.a(new g(2, 0, H1.f.class));
            cVar.a(new g(1, 1, b.class));
            cVar.a(new g(oVar, 1, 0));
            cVar.f6055f = new H1.b(oVar, 0);
            arrayList.add(cVar.b());
            arrayList.add(AbstractC0286a.c("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
            arrayList.add(AbstractC0286a.c("fire-core", "22.0.1"));
            arrayList.add(AbstractC0286a.c("device-name", a(Build.PRODUCT)));
            arrayList.add(AbstractC0286a.c("device-model", a(Build.DEVICE)));
            arrayList.add(AbstractC0286a.c("device-brand", a(Build.BRAND)));
            arrayList.add(AbstractC0286a.k("android-target-sdk", new V1.f(2)));
            arrayList.add(AbstractC0286a.k("android-min-sdk", new V1.f(3)));
            arrayList.add(AbstractC0286a.k("android-platform", new V1.f(4)));
            arrayList.add(AbstractC0286a.k("android-installer", new V1.f(5)));
            try {
                H2.b.f671g.getClass();
                str = "2.2.20";
            } catch (NoClassDefFoundError unused) {
                str = null;
            }
            if (str != null) {
                arrayList.add(AbstractC0286a.c("kotlin", str));
            }
            return arrayList;
        }
        throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
    }
}
