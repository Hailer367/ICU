package io.flutter.plugins.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.messaging.FlutterFirebasePermissionManager;
import java.util.HashMap;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements FlutterFirebasePermissionManager.RequestPermissionsSuccessCallback, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2423a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2424b;

    public /* synthetic */ d(Object obj, Object obj2) {
        this.f2423a = obj;
        this.f2424b = obj2;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((FlutterFirebaseMessagingPlugin) this.f2423a).lambda$onMethodCall$14((MethodChannel.Result) this.f2424b, task);
    }

    @Override // io.flutter.plugins.firebase.messaging.FlutterFirebasePermissionManager.RequestPermissionsSuccessCallback
    public void onSuccess(int i2) {
        FlutterFirebaseMessagingPlugin.lambda$requestPermissions$10((HashMap) this.f2423a, (TaskCompletionSource) this.f2424b, i2);
    }
}
