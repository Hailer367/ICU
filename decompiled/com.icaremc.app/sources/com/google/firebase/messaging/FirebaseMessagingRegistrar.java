package com.google.firebase.messaging;

import G1.c;
import H1.h;
import I1.a;
import K1.e;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import f1.AbstractC0286a;
import java.util.Arrays;
import java.util.List;
import u1.f;
import x1.C0721a;
import x1.b;
import x1.g;
import x1.o;

@Keep
/* loaded from: classes.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(o oVar, b bVar) {
        f fVar = (f) bVar.a(f.class);
        if (bVar.a(a.class) == null) {
            return new FirebaseMessaging(fVar, bVar.d(R1.b.class), bVar.d(h.class), (e) bVar.a(e.class), bVar.f(oVar), (c) bVar.a(c.class));
        }
        throw new ClassCastException();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<C0721a> getComponents() {
        o oVar = new o(A1.b.class, F0.e.class);
        boolean z = false;
        r2.c cVar = new r2.c(FirebaseMessaging.class, new Class[0]);
        cVar.f6052c = LIBRARY_NAME;
        cVar.a(g.a(f.class));
        cVar.a(new g(0, 0, a.class));
        cVar.a(new g(0, 1, R1.b.class));
        cVar.a(new g(0, 1, h.class));
        cVar.a(g.a(e.class));
        cVar.a(new g(oVar, 0, 1));
        cVar.a(g.a(c.class));
        cVar.f6055f = new H1.b(oVar, 1);
        if (cVar.f6050a == 0) {
            z = true;
        }
        if (z) {
            cVar.f6050a = 1;
            return Arrays.asList(cVar.b(), AbstractC0286a.c(LIBRARY_NAME, "25.0.2"));
        }
        throw new IllegalStateException("Instantiation type has already been set.");
    }
}
