package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.lifecycle.AbstractC0146p;

/* loaded from: classes.dex */
public interface ContentProviderControlSurface {
    void attachToContentProvider(ContentProvider contentProvider, AbstractC0146p abstractC0146p);

    void detachFromContentProvider();
}
