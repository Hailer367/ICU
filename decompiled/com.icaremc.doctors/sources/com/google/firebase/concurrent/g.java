package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2036a;

    public /* synthetic */ g(int i2) {
        this.f2036a = i2;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f2036a) {
            case 0:
                return ExecutorsRegistrar.f();
            case 1:
                return ExecutorsRegistrar.c();
            case 2:
                return ExecutorsRegistrar.h();
            case 3:
                return ExecutorsRegistrar.b();
            case 4:
                return FirebaseMessaging.k();
            default:
                return FirebaseMessaging.h();
        }
    }
}
