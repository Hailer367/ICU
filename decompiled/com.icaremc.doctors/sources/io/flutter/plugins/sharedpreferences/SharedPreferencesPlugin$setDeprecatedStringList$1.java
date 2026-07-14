package io.flutter.plugins.sharedpreferences;

import Q0.j;
import T0.d;
import V0.e;
import V0.h;
import a.AbstractC0051a;
import c1.p;
import l1.InterfaceC0242u;

@e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDeprecatedStringList$1", f = "SharedPreferencesPlugin.kt", l = {128}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$setDeprecatedStringList$1 extends h implements p {
    final /* synthetic */ String $key;
    final /* synthetic */ String $valueString;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$setDeprecatedStringList$1(SharedPreferencesPlugin sharedPreferencesPlugin, String str, String str2, d dVar) {
        super(2, dVar);
        this.this$0 = sharedPreferencesPlugin;
        this.$key = str;
        this.$valueString = str2;
    }

    @Override // V0.a
    public final d create(Object obj, d dVar) {
        return new SharedPreferencesPlugin$setDeprecatedStringList$1(this.this$0, this.$key, this.$valueString, dVar);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        Object dataStoreSetString;
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
            SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
            String str = this.$key;
            String str2 = this.$valueString;
            this.label = 1;
            dataStoreSetString = sharedPreferencesPlugin.dataStoreSetString(str, str2, this);
            if (dataStoreSetString == aVar) {
                return aVar;
            }
        }
        return j.f722a;
    }

    @Override // c1.p
    public final Object invoke(InterfaceC0242u interfaceC0242u, d dVar) {
        return ((SharedPreferencesPlugin$setDeprecatedStringList$1) create(interfaceC0242u, dVar)).invokeSuspend(j.f722a);
    }
}
