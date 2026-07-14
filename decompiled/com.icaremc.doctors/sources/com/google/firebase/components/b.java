package com.google.firebase.components;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.local.IidStore;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2000a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2001b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f2000a = i2;
        this.f2001b = obj;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        ComponentRegistrar instantiate;
        IidStore lambda$new$0;
        switch (this.f2000a) {
            case 0:
                instantiate = ComponentDiscovery.instantiate((String) this.f2001b);
                return instantiate;
            default:
                lambda$new$0 = FirebaseInstallations.lambda$new$0((FirebaseApp) this.f2001b);
                return lambda$new$0;
        }
    }
}
