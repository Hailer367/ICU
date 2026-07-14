package com.google.firebase.datastorage;

import K.InterfaceC0034i;
import O.g;
import Q0.j;
import R0.s;
import T0.d;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import c1.p;
import l1.InterfaceC0242u;
import o1.w;

@e(c = "com.google.firebase.datastorage.JavaDataStorage$getAllSync$1", f = "JavaDataStorage.kt", l = {170}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class JavaDataStorage$getAllSync$1 extends h implements p {
    int label;
    final /* synthetic */ JavaDataStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaDataStorage$getAllSync$1(JavaDataStorage javaDataStorage, d dVar) {
        super(2, dVar);
        this.this$0 = javaDataStorage;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        return new JavaDataStorage$getAllSync$1(this.this$0, dVar);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        InterfaceC0034i interfaceC0034i;
        U0.a aVar = U0.a.f780c;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            interfaceC0034i = this.this$0.dataStore;
            o1.d i3 = interfaceC0034i.i();
            this.label = 1;
            obj = w.c(i3, this);
            if (obj == aVar) {
                return aVar;
            }
        }
        g gVar = (g) obj;
        if (gVar != null) {
            return gVar.a();
        }
        return s.f751c;
    }

    @Override // c1.p
    public final Object invoke(InterfaceC0242u interfaceC0242u, d dVar) {
        return ((JavaDataStorage$getAllSync$1) create(interfaceC0242u, dVar)).invokeSuspend(j.f722a);
    }
}
