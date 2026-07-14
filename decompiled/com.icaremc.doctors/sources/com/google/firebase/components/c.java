package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2002a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f2003b;

    public /* synthetic */ c(ComponentRegistrar componentRegistrar, int i2) {
        this.f2002a = i2;
        this.f2003b = componentRegistrar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f2002a) {
            case 0:
                return ComponentRuntime.c(this.f2003b);
            default:
                return ComponentRuntime.Builder.a(this.f2003b);
        }
    }
}
