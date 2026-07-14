package io.flutter.plugins.sharedpreferences;

import K.InterfaceC0034i;
import O.c;
import Q0.j;
import T0.d;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import android.content.Context;
import c1.p;
import l1.InterfaceC0242u;

@e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1", f = "SharedPreferencesPlugin.kt", l = {99}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$setInt$1 extends h implements p {
    final /* synthetic */ String $key;
    final /* synthetic */ long $value;
    Object L$0;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    @e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setInt$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends h implements p {
        final /* synthetic */ O.e $intKey;
        final /* synthetic */ long $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(O.e eVar, long j2, d dVar) {
            super(2, dVar);
            this.$intKey = eVar;
            this.$value = j2;
        }

        @Override // V0.a
        public final d create(Object obj, d dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$intKey, this.$value, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c1.p
        public final Object invoke(c cVar, d dVar) {
            return ((AnonymousClass1) create(cVar, dVar)).invokeSuspend(j.f722a);
        }

        @Override // V0.a
        public final Object invokeSuspend(Object obj) {
            c cVar = (c) this.L$0;
            U0.a aVar = U0.a.f780c;
            if (this.label == 0) {
                AbstractC0051a.V(obj);
                cVar.e(this.$intKey, new Long(this.$value));
                return j.f722a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$setInt$1(String str, SharedPreferencesPlugin sharedPreferencesPlugin, long j2, d dVar) {
        super(2, dVar);
        this.$key = str;
        this.this$0 = sharedPreferencesPlugin;
        this.$value = j2;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        return new SharedPreferencesPlugin$setInt$1(this.$key, this.this$0, this.$value, dVar);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        Context context;
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
            O.e F2 = AbstractC0051a.F(this.$key);
            context = this.this$0.context;
            if (context != null) {
                InterfaceC0034i sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(F2, this.$value, null);
                this.L$0 = null;
                this.label = 1;
                if (android.support.v4.media.session.a.l(sharedPreferencesDataStore, anonymousClass1, this) == aVar) {
                    return aVar;
                }
            } else {
                kotlin.jvm.internal.h.g("context");
                throw null;
            }
        }
        return j.f722a;
    }

    @Override // c1.p
    public final Object invoke(InterfaceC0242u interfaceC0242u, d dVar) {
        return ((SharedPreferencesPlugin$setInt$1) create(interfaceC0242u, dVar)).invokeSuspend(j.f722a);
    }
}
