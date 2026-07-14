package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.lifecycle.AbstractC0146p;

/* loaded from: classes.dex */
public interface ServiceControlSurface {
    void attachToService(Service service, AbstractC0146p abstractC0146p, boolean z);

    void detachFromService();

    void onMoveToBackground();

    void onMoveToForeground();
}
