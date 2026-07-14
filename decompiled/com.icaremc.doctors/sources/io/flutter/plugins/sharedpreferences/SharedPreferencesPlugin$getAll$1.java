package io.flutter.plugins.sharedpreferences;

import Q0.j;
import T0.d;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import c1.p;
import java.util.List;
import l1.InterfaceC0242u;

@e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getAll$1", f = "SharedPreferencesPlugin.kt", l = {150}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$getAll$1 extends h implements p {
    final /* synthetic */ List<String> $allowList;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getAll$1(SharedPreferencesPlugin sharedPreferencesPlugin, List<String> list, d dVar) {
        super(2, dVar);
        this.this$0 = sharedPreferencesPlugin;
        this.$allowList = list;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        return new SharedPreferencesPlugin$getAll$1(this.this$0, this.$allowList, dVar);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        Object prefs;
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
        SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
        List<String> list = this.$allowList;
        this.label = 1;
        prefs = sharedPreferencesPlugin.getPrefs(list, this);
        if (prefs == aVar) {
            return aVar;
        }
        return prefs;
    }

    @Override // c1.p
    public final Object invoke(InterfaceC0242u interfaceC0242u, d dVar) {
        return ((SharedPreferencesPlugin$getAll$1) create(interfaceC0242u, dVar)).invokeSuspend(j.f722a);
    }
}
