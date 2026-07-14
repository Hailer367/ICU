package io.flutter.plugins.firebase.messaging;

import android.app.Activity;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FlutterFirebasePermissionManager implements PluginRegistry.RequestPermissionsResultListener {
    private static final String REQUEST_IN_PROGRESS_ERROR = "A request for permissions is already running, please wait for it to finish before doing another request.";
    private RequestPermissionsSuccessCallback successCallback;
    private final Object requestLock = new Object();
    private final int permissionCode = 240;
    private boolean requestInProgress = false;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface RequestPermissionsSuccessCallback {
        void onSuccess(int i2);
    }

    private boolean setRequestInProgress(RequestPermissionsSuccessCallback requestPermissionsSuccessCallback) {
        synchronized (this.requestLock) {
            try {
                if (this.requestInProgress) {
                    return false;
                }
                this.requestInProgress = true;
                this.successCallback = requestPermissionsSuccessCallback;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback;
        synchronized (this.requestLock) {
            int i3 = 0;
            if (this.requestInProgress && i2 == 240 && (requestPermissionsSuccessCallback = this.successCallback) != null) {
                this.successCallback = null;
                this.requestInProgress = false;
                if (iArr.length > 0 && iArr[0] == 0) {
                    i3 = 1;
                }
                requestPermissionsSuccessCallback.onSuccess(i3);
                return true;
            }
            return false;
        }
    }

    public void requestPermissions(Activity activity, RequestPermissionsSuccessCallback requestPermissionsSuccessCallback, ErrorCallback errorCallback) {
        if (activity == null) {
            errorCallback.onError("Unable to detect current Android Activity.");
        } else {
            if (!setRequestInProgress(requestPermissionsSuccessCallback)) {
                errorCallback.onError(REQUEST_IN_PROGRESS_ERROR);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.POST_NOTIFICATIONS");
            android.support.v4.media.session.a.D(activity, (String[]) arrayList.toArray(new String[0]), 240);
        }
    }
}
