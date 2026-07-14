package io.flutter.plugins.sharedpreferences;

import Q0.j;
import T0.d;
import V0.c;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import android.content.Context;
import c1.p;
import kotlin.jvm.internal.q;
import l1.InterfaceC0242u;
import o1.w;

@e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1", f = "SharedPreferencesPlugin.kt", l = {188}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$getDouble$1 extends h implements p {
    final /* synthetic */ String $key;
    final /* synthetic */ q $value;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getDouble$1(String str, SharedPreferencesPlugin sharedPreferencesPlugin, q qVar, d dVar) {
        super(2, dVar);
        this.$key = str;
        this.this$0 = sharedPreferencesPlugin;
        this.$value = qVar;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        return new SharedPreferencesPlugin$getDouble$1(this.$key, this.this$0, this.$value, dVar);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        Context context;
        q qVar;
        U0.a aVar = U0.a.f780c;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                qVar = (q) this.L$2;
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            final O.e T2 = AbstractC0051a.T(this.$key);
            context = this.this$0.context;
            if (context != null) {
                final o1.d i3 = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).i();
                final SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
                o1.d dVar = new o1.d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1

                    /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass2<T> implements o1.e {
                        final /* synthetic */ O.e $preferencesKey$inlined;
                        final /* synthetic */ o1.e $this_unsafeFlow;
                        final /* synthetic */ SharedPreferencesPlugin this$0;

                        @e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit", v = 1)
                        /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* loaded from: classes.dex */
                        public static final class AnonymousClass1 extends c {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(d dVar) {
                                super(dVar);
                            }

                            @Override // V0.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(o1.e eVar, O.e eVar2, SharedPreferencesPlugin sharedPreferencesPlugin) {
                            this.$this_unsafeFlow = eVar;
                            this.$preferencesKey$inlined = eVar2;
                            this.this$0 = sharedPreferencesPlugin;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                        @Override // o1.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, T0.d r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                U0.a r1 = U0.a.f780c
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L37
                                if (r2 != r3) goto L2f
                                java.lang.Object r5 = r0.L$3
                                o1.e r5 = (o1.e) r5
                                java.lang.Object r5 = r0.L$1
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1$2$1 r5 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
                                a.AbstractC0051a.V(r6)
                                goto L65
                            L2f:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L37:
                                a.AbstractC0051a.V(r6)
                                o1.e r6 = r4.$this_unsafeFlow
                                O.g r5 = (O.g) r5
                                O.e r2 = r4.$preferencesKey$inlined
                                java.lang.Object r5 = r5.b(r2)
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r2 = r4.this$0
                                io.flutter.plugins.sharedpreferences.SharedPreferencesListEncoder r2 = io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.access$getListEncoder$p(r2)
                                java.lang.Object r5 = io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt.transformPref(r5, r2)
                                java.lang.Double r5 = (java.lang.Double) r5
                                r2 = 0
                                r0.L$0 = r2
                                r0.L$1 = r2
                                r0.L$2 = r2
                                r0.L$3 = r2
                                r2 = 0
                                r0.I$0 = r2
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L65
                                return r1
                            L65:
                                Q0.j r5 = Q0.j.f722a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getDouble$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, T0.d):java.lang.Object");
                        }
                    }

                    @Override // o1.d
                    public Object collect(o1.e eVar, d dVar2) {
                        Object collect = o1.d.this.collect(new AnonymousClass2(eVar, T2, sharedPreferencesPlugin), dVar2);
                        if (collect == U0.a.f780c) {
                            return collect;
                        }
                        return j.f722a;
                    }
                };
                q qVar2 = this.$value;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = qVar2;
                this.label = 1;
                Object c2 = w.c(dVar, this);
                if (c2 == aVar) {
                    return aVar;
                }
                qVar = qVar2;
                obj = c2;
            } else {
                kotlin.jvm.internal.h.g("context");
                throw null;
            }
        }
        qVar.f2789c = obj;
        return j.f722a;
    }

    @Override // c1.p
    public final Object invoke(InterfaceC0242u interfaceC0242u, d dVar) {
        return ((SharedPreferencesPlugin$getDouble$1) create(interfaceC0242u, dVar)).invokeSuspend(j.f722a);
    }
}
