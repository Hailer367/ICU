package com.google.firebase.datastorage;

import K.InterfaceC0034i;
import O.c;
import Q0.j;
import T0.d;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import c1.p;
import l1.InterfaceC0242u;

@e(c = "com.google.firebase.datastorage.JavaDataStorage$putSync$1", f = "JavaDataStorage.kt", l = {145}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class JavaDataStorage$putSync$1 extends h implements p {
    final /* synthetic */ O.e $key;
    final /* synthetic */ T $value;
    int label;
    final /* synthetic */ JavaDataStorage this$0;

    @e(c = "com.google.firebase.datastorage.JavaDataStorage$putSync$1$1", f = "JavaDataStorage.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.datastorage.JavaDataStorage$putSync$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends h implements p {
        final /* synthetic */ O.e $key;
        final /* synthetic */ T $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(O.e eVar, T t2, d dVar) {
            super(2, dVar);
            this.$key = eVar;
            this.$value = t2;
        }

        @Override // V0.a
        public final d create(Object obj, d dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$key, this.$value, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c1.p
        public final Object invoke(c cVar, d dVar) {
            return ((AnonymousClass1) create(cVar, dVar)).invokeSuspend(j.f722a);
        }

        @Override // V0.a
        public final Object invokeSuspend(Object obj) {
            U0.a aVar = U0.a.f780c;
            if (this.label == 0) {
                AbstractC0051a.V(obj);
                ((c) this.L$0).e(this.$key, this.$value);
                return j.f722a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaDataStorage$putSync$1(JavaDataStorage javaDataStorage, O.e eVar, T t2, d dVar) {
        super(2, dVar);
        this.this$0 = javaDataStorage;
        this.$key = eVar;
        this.$value = t2;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        return new JavaDataStorage$putSync$1(this.this$0, this.$key, this.$value, dVar);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        InterfaceC0034i interfaceC0034i;
        U0.a aVar = U0.a.f780c;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0051a.V(obj);
        interfaceC0034i = this.this$0.dataStore;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$key, this.$value, null);
        this.label = 1;
        Object l2 = android.support.v4.media.session.a.l(interfaceC0034i, anonymousClass1, this);
        if (l2 == aVar) {
            return aVar;
        }
        return l2;
    }

    @Override // c1.p
    public final Object invoke(InterfaceC0242u interfaceC0242u, d dVar) {
        return ((JavaDataStorage$putSync$1) create(interfaceC0242u, dVar)).invokeSuspend(j.f722a);
    }
}
