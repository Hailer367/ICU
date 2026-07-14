package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0146p;
import io.flutter.embedding.android.ExclusiveAppComponent;

/* loaded from: classes.dex */
public interface ActivityControlSurface {
    void attachToActivity(ExclusiveAppComponent<Activity> exclusiveAppComponent, AbstractC0146p abstractC0146p);

    void detachFromActivity();

    void detachFromActivityForConfigChanges();

    boolean onActivityResult(int i2, int i3, Intent intent);

    void onNewIntent(Intent intent);

    boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);

    void onRestoreInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);

    void onUserLeaveHint();
}
