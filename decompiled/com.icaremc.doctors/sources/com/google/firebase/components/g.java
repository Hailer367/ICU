package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2009a;

    public /* synthetic */ g(int i2) {
        this.f2009a = i2;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f2009a) {
            case 0:
                return OptionalProvider.a();
            default:
                return Collections.EMPTY_SET;
        }
    }
}
