package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.AbstractC0208o;

@Keep
/* loaded from: classes.dex */
public class HiddenLifecycleReference {
    private final AbstractC0208o lifecycle;

    public HiddenLifecycleReference(AbstractC0208o abstractC0208o) {
        this.lifecycle = abstractC0208o;
    }

    public AbstractC0208o getLifecycle() {
        return this.lifecycle;
    }
}
