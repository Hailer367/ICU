package com.google.firebase.installations;

import D2.J;
import D2.K;
import H1.g;
import K1.d;
import K1.e;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import f1.AbstractC0286a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import r2.c;
import u1.f;
import w1.InterfaceC0696a;
import w1.InterfaceC0697b;
import x1.C0721a;
import x1.b;
import x1.o;
import y1.i;

@Keep
/* loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static e lambda$getComponents$0(b bVar) {
        return new d((f) bVar.a(f.class), bVar.d(g.class), (ExecutorService) bVar.e(new o(InterfaceC0696a.class, ExecutorService.class)), new i((Executor) bVar.e(new o(InterfaceC0697b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0721a> getComponents() {
        c cVar = new c(e.class, new Class[0]);
        cVar.f6052c = LIBRARY_NAME;
        cVar.a(x1.g.a(f.class));
        cVar.a(new x1.g(0, 1, g.class));
        cVar.a(new x1.g(new o(InterfaceC0696a.class, ExecutorService.class), 1, 0));
        cVar.a(new x1.g(new o(InterfaceC0697b.class, Executor.class), 1, 0));
        cVar.f6055f = new K(15);
        C0721a b4 = cVar.b();
        Object obj = new Object();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(o.a(H1.f.class));
        return Arrays.asList(b4, new C0721a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new J(21, obj), hashSet3), AbstractC0286a.c(LIBRARY_NAME, "19.1.0"));
    }
}
