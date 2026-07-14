package com.google.firebase;

import I2.f;
import androidx.annotation.Keep;
import b3.AbstractC0242q;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import r2.c;
import u1.C0667b;
import w1.InterfaceC0696a;
import w1.InterfaceC0697b;
import w1.InterfaceC0698c;
import w1.InterfaceC0699d;
import x1.C0721a;
import x1.g;
import x1.o;

@Keep
/* loaded from: classes.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0721a> getComponents() {
        c a4 = C0721a.a(new o(InterfaceC0696a.class, AbstractC0242q.class));
        a4.a(new g(new o(InterfaceC0696a.class, Executor.class), 1, 0));
        a4.f6055f = C0667b.f6211g;
        C0721a b4 = a4.b();
        c a5 = C0721a.a(new o(InterfaceC0698c.class, AbstractC0242q.class));
        a5.a(new g(new o(InterfaceC0698c.class, Executor.class), 1, 0));
        a5.f6055f = C0667b.f6212h;
        C0721a b5 = a5.b();
        c a6 = C0721a.a(new o(InterfaceC0697b.class, AbstractC0242q.class));
        a6.a(new g(new o(InterfaceC0697b.class, Executor.class), 1, 0));
        a6.f6055f = C0667b.f6213i;
        C0721a b6 = a6.b();
        c a7 = C0721a.a(new o(InterfaceC0699d.class, AbstractC0242q.class));
        a7.a(new g(new o(InterfaceC0699d.class, Executor.class), 1, 0));
        a7.f6055f = C0667b.f6214j;
        return f.C(b4, b5, b6, a7.b());
    }
}
