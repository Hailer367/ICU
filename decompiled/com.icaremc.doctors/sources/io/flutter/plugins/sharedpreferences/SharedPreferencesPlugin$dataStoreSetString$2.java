package io.flutter.plugins.sharedpreferences;

import O.c;
import Q0.j;
import T0.d;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import c1.p;

@e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$dataStoreSetString$2 extends h implements p {
    final /* synthetic */ O.e $stringKey;
    final /* synthetic */ String $value;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$dataStoreSetString$2(O.e eVar, String str, d dVar) {
        super(2, dVar);
        this.$stringKey = eVar;
        this.$value = str;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        SharedPreferencesPlugin$dataStoreSetString$2 sharedPreferencesPlugin$dataStoreSetString$2 = new SharedPreferencesPlugin$dataStoreSetString$2(this.$stringKey, this.$value, dVar);
        sharedPreferencesPlugin$dataStoreSetString$2.L$0 = obj;
        return sharedPreferencesPlugin$dataStoreSetString$2;
    }

    @Override // c1.p
    public final Object invoke(c cVar, d dVar) {
        return ((SharedPreferencesPlugin$dataStoreSetString$2) create(cVar, dVar)).invokeSuspend(j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        c cVar = (c) this.L$0;
        U0.a aVar = U0.a.f780c;
        if (this.label == 0) {
            AbstractC0051a.V(obj);
            cVar.e(this.$stringKey, this.$value);
            return j.f722a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
