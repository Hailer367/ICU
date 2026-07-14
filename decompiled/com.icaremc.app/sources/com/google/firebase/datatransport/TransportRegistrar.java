package com.google.firebase.datatransport;

import A1.c;
import F0.e;
import G0.a;
import I0.s;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import f1.AbstractC0286a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import q1.AbstractC0602b;
import x1.C0721a;
import x1.b;
import x1.g;
import x1.o;

@Keep
/* loaded from: classes.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public static /* synthetic */ e lambda$getComponents$0(b bVar) {
        s.b((Context) bVar.a(Context.class));
        return s.a().c(a.f557f);
    }

    public static /* synthetic */ e lambda$getComponents$1(b bVar) {
        s.b((Context) bVar.a(Context.class));
        return s.a().c(a.f557f);
    }

    public static /* synthetic */ e lambda$getComponents$2(b bVar) {
        s.b((Context) bVar.a(Context.class));
        return s.a().c(a.f556e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0721a> getComponents() {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(o.a(e.class));
        for (Class cls : new Class[0]) {
            AbstractC0602b.h(cls, "Null interface");
            hashSet.add(o.a(cls));
        }
        g a4 = g.a(Context.class);
        if (!hashSet.contains(a4.f6475a)) {
            hashSet2.add(a4);
            C0721a c0721a = new C0721a(LIBRARY_NAME, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new c(0), hashSet3);
            r2.c a5 = C0721a.a(new o(A1.a.class, e.class));
            a5.a(g.a(Context.class));
            a5.f6055f = new c(1);
            C0721a b4 = a5.b();
            r2.c a6 = C0721a.a(new o(A1.b.class, e.class));
            a6.a(g.a(Context.class));
            a6.f6055f = new c(2);
            return Arrays.asList(c0721a, b4, a6.b(), AbstractC0286a.c(LIBRARY_NAME, "18.2.0"));
        }
        throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
    }
}
