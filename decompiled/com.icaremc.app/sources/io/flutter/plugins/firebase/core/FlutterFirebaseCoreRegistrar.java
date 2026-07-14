package io.flutter.plugins.firebase.core;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import f1.AbstractC0286a;
import java.util.Collections;
import java.util.List;
import x1.C0721a;

@Keep
/* loaded from: classes.dex */
public class FlutterFirebaseCoreRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0721a> getComponents() {
        return Collections.singletonList(AbstractC0286a.c("flutter-fire-core", "4.10.0"));
    }
}
