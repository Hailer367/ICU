package com.google.firebase.datastorage;

import K.InterfaceC0034i;
import O.c;
import O.g;
import Q0.j;
import T0.d;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import c1.l;
import c1.p;
import l1.InterfaceC0242u;

@e(c = "com.google.firebase.datastorage.JavaDataStorage$editSync$1", f = "JavaDataStorage.kt", l = {220}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class JavaDataStorage$editSync$1 extends h implements p {
    final /* synthetic */ l $transform;
    int label;
    final /* synthetic */ JavaDataStorage this$0;

    @e(c = "com.google.firebase.datastorage.JavaDataStorage$editSync$1$1", f = "JavaDataStorage.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.datastorage.JavaDataStorage$editSync$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends h implements p {
        final /* synthetic */ l $transform;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, d dVar) {
            super(2, dVar);
            this.$transform = lVar;
        }

        @Override // V0.a
        public final d create(Object obj, d dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, dVar);
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
                this.$transform.invoke((c) this.L$0);
                return j.f722a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaDataStorage$editSync$1(JavaDataStorage javaDataStorage, l lVar, d dVar) {
        super(2, dVar);
        this.this$0 = javaDataStorage;
        this.$transform = lVar;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        return new JavaDataStorage$editSync$1(this.this$0, this.$transform, dVar);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        ThreadLocal threadLocal;
        ThreadLocal threadLocal2;
        ThreadLocal threadLocal3;
        InterfaceC0034i interfaceC0034i;
        U0.a aVar = U0.a.f780c;
        int i2 = this.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    AbstractC0051a.V(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                AbstractC0051a.V(obj);
                threadLocal2 = this.this$0.editLock;
                Object obj2 = threadLocal2.get();
                Boolean bool = Boolean.TRUE;
                if (!kotlin.jvm.internal.h.a(obj2, bool)) {
                    threadLocal3 = this.this$0.editLock;
                    threadLocal3.set(bool);
                    interfaceC0034i = this.this$0.dataStore;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, null);
                    this.label = 1;
                    obj = android.support.v4.media.session.a.l(interfaceC0034i, anonymousClass1, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    throw new IllegalStateException("Don't call JavaDataStorage.edit() from within an existing edit() callback.\nThis causes deadlocks, and is generally indicative of a code smell.\nInstead, either pass around the initial `MutablePreferences` instance, or don't do everything in a single callback. ");
                }
            }
            return (g) obj;
        } finally {
            threadLocal = this.this$0.editLock;
            threadLocal.set(Boolean.FALSE);
        }
    }

    @Override // c1.p
    public final Object invoke(InterfaceC0242u interfaceC0242u, d dVar) {
        return ((JavaDataStorage$editSync$1) create(interfaceC0242u, dVar)).invokeSuspend(j.f722a);
    }
}
