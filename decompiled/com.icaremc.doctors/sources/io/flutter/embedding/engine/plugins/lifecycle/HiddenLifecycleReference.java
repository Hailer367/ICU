package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.AbstractC0146p;

@Keep
/* loaded from: classes.dex */
public class HiddenLifecycleReference {
    private final AbstractC0146p lifecycle;

    public HiddenLifecycleReference(AbstractC0146p abstractC0146p) {
        this.lifecycle = abstractC0146p;
    }

    public AbstractC0146p getLifecycle() {
        return this.lifecycle;
    }
}
