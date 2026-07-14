package com.google.firebase.datatransport;

import H0.a;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import s0.e;
import t0.C0303a;
import v0.q;

@Keep
/* loaded from: classes.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public static /* synthetic */ e lambda$getComponents$0(ComponentContainer componentContainer) {
        q.b((Context) componentContainer.get(Context.class));
        return q.a().c(C0303a.f3641f);
    }

    public static /* synthetic */ e lambda$getComponents$1(ComponentContainer componentContainer) {
        q.b((Context) componentContainer.get(Context.class));
        return q.a().c(C0303a.f3641f);
    }

    public static /* synthetic */ e lambda$getComponents$2(ComponentContainer componentContainer) {
        q.b((Context) componentContainer.get(Context.class));
        return q.a().c(C0303a.f3640e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(e.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) Context.class)).factory(new a(0)).build(), Component.builder(Qualified.qualified(LegacyTransportBackend.class, e.class)).add(Dependency.required((Class<?>) Context.class)).factory(new a(1)).build(), Component.builder(Qualified.qualified(TransportBackend.class, e.class)).add(Dependency.required((Class<?>) Context.class)).factory(new a(2)).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
