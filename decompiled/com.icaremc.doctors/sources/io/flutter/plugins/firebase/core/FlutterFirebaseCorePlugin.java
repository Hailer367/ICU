package io.flutter.plugins.firebase.core;

import B0.h;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class FlutterFirebaseCorePlugin implements FlutterPlugin, GeneratedAndroidFirebaseCore.FirebaseCoreHostApi, GeneratedAndroidFirebaseCore.FirebaseAppHostApi {
    public static Map<String, String> customAuthDomain = new HashMap();
    private Context applicationContext;
    private boolean coreInitialized = false;

    private Task<GeneratedAndroidFirebaseCore.CoreInitializeResponse> firebaseAppToMap(FirebaseApp firebaseApp) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new A0.a(this, firebaseApp, taskCompletionSource, 3));
        return taskCompletionSource.getTask();
    }

    private GeneratedAndroidFirebaseCore.CoreFirebaseOptions firebaseOptionsToMap(FirebaseOptions firebaseOptions) {
        GeneratedAndroidFirebaseCore.CoreFirebaseOptions.Builder builder = new GeneratedAndroidFirebaseCore.CoreFirebaseOptions.Builder();
        builder.setApiKey(firebaseOptions.getApiKey());
        builder.setAppId(firebaseOptions.getApplicationId());
        if (firebaseOptions.getGcmSenderId() != null) {
            builder.setMessagingSenderId(firebaseOptions.getGcmSenderId());
        }
        if (firebaseOptions.getProjectId() != null) {
            builder.setProjectId(firebaseOptions.getProjectId());
        }
        builder.setDatabaseURL(firebaseOptions.getDatabaseUrl());
        builder.setStorageBucket(firebaseOptions.getStorageBucket());
        builder.setTrackingId(firebaseOptions.getGaTrackingId());
        return builder.build();
    }

    public static /* synthetic */ void lambda$delete$8(String str, TaskCompletionSource taskCompletionSource) {
        try {
            try {
                FirebaseApp.getInstance(str).delete();
            } catch (IllegalStateException unused) {
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public /* synthetic */ void lambda$firebaseAppToMap$0(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            GeneratedAndroidFirebaseCore.CoreInitializeResponse.Builder builder = new GeneratedAndroidFirebaseCore.CoreInitializeResponse.Builder();
            builder.setName(firebaseApp.getName());
            builder.setOptions(firebaseOptionsToMap(firebaseApp.getOptions()));
            builder.setIsAutomaticDataCollectionEnabled(Boolean.valueOf(firebaseApp.isDataCollectionDefaultEnabled()));
            builder.setPluginConstants((Map) Tasks.await(FlutterFirebasePluginRegistry.getPluginConstantsForFirebaseApp(firebaseApp)));
            taskCompletionSource.setResult(builder.build());
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public /* synthetic */ void lambda$initializeApp$3(GeneratedAndroidFirebaseCore.CoreFirebaseOptions coreFirebaseOptions, String str, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseOptions build = new FirebaseOptions.Builder().setApiKey(coreFirebaseOptions.getApiKey()).setApplicationId(coreFirebaseOptions.getAppId()).setDatabaseUrl(coreFirebaseOptions.getDatabaseURL()).setGcmSenderId(coreFirebaseOptions.getMessagingSenderId()).setProjectId(coreFirebaseOptions.getProjectId()).setStorageBucket(coreFirebaseOptions.getStorageBucket()).setGaTrackingId(coreFirebaseOptions.getTrackingId()).build();
            try {
                Looper.prepare();
            } catch (Exception unused) {
            }
            if (coreFirebaseOptions.getAuthDomain() != null) {
                customAuthDomain.put(str, coreFirebaseOptions.getAuthDomain());
            }
            taskCompletionSource.setResult((GeneratedAndroidFirebaseCore.CoreInitializeResponse) Tasks.await(firebaseAppToMap(FirebaseApp.initializeApp(this.applicationContext, build, str))));
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public /* synthetic */ void lambda$initializeCore$4(TaskCompletionSource taskCompletionSource) {
        try {
            if (!this.coreInitialized) {
                this.coreInitialized = true;
            } else {
                Tasks.await(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
            }
            List<FirebaseApp> apps = FirebaseApp.getApps(this.applicationContext);
            ArrayList arrayList = new ArrayList(apps.size());
            Iterator<FirebaseApp> it = apps.iterator();
            while (it.hasNext()) {
                arrayList.add((GeneratedAndroidFirebaseCore.CoreInitializeResponse) Tasks.await(firebaseAppToMap(it.next())));
            }
            taskCompletionSource.setResult(arrayList);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static /* synthetic */ void lambda$listenToResponse$1(GeneratedAndroidFirebaseCore.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
        } else {
            result.error(task.getException());
        }
    }

    public static /* synthetic */ void lambda$listenToVoidResponse$2(GeneratedAndroidFirebaseCore.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(task.getException());
        }
    }

    public /* synthetic */ void lambda$optionsFromResource$5(TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseOptions fromResource = FirebaseOptions.fromResource(this.applicationContext);
            if (fromResource == null) {
                taskCompletionSource.setException(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
            } else {
                taskCompletionSource.setResult(firebaseOptionsToMap(fromResource));
            }
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static /* synthetic */ void lambda$setAutomaticDataCollectionEnabled$6(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseApp.getInstance(str).setDataCollectionDefaultEnabled(bool);
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static /* synthetic */ void lambda$setAutomaticResourceManagementEnabled$7(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseApp.getInstance(str).setAutomaticResourceManagementEnabled(bool.booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    private <T> void listenToResponse(TaskCompletionSource<T> taskCompletionSource, GeneratedAndroidFirebaseCore.Result<T> result) {
        taskCompletionSource.getTask().addOnCompleteListener(new h(12, result));
    }

    private void listenToVoidResponse(TaskCompletionSource<Void> taskCompletionSource, GeneratedAndroidFirebaseCore.VoidResult voidResult) {
        taskCompletionSource.getTask().addOnCompleteListener(new h(11, voidResult));
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi
    public void delete(String str, GeneratedAndroidFirebaseCore.VoidResult voidResult) {
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new B0.e(2, str, taskCompletionSource));
        listenToVoidResponse(taskCompletionSource, voidResult);
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi
    public void initializeApp(final String str, final GeneratedAndroidFirebaseCore.CoreFirebaseOptions coreFirebaseOptions, GeneratedAndroidFirebaseCore.Result<GeneratedAndroidFirebaseCore.CoreInitializeResponse> result) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.a
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseCorePlugin.this.lambda$initializeApp$3(coreFirebaseOptions, str, taskCompletionSource);
            }
        });
        listenToResponse(taskCompletionSource, result);
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi
    public void initializeCore(GeneratedAndroidFirebaseCore.Result<List<GeneratedAndroidFirebaseCore.CoreInitializeResponse>> result) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(this, taskCompletionSource, 1));
        listenToResponse(taskCompletionSource, result);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.setUp(flutterPluginBinding.getBinaryMessenger(), this);
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.setUp(flutterPluginBinding.getBinaryMessenger(), this);
        this.applicationContext = flutterPluginBinding.getApplicationContext();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.applicationContext = null;
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.setUp(flutterPluginBinding.getBinaryMessenger(), null);
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.setUp(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi
    public void optionsFromResource(GeneratedAndroidFirebaseCore.Result<GeneratedAndroidFirebaseCore.CoreFirebaseOptions> result) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(this, taskCompletionSource, 0));
        listenToResponse(taskCompletionSource, result);
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi
    public void setAutomaticDataCollectionEnabled(String str, Boolean bool, GeneratedAndroidFirebaseCore.VoidResult voidResult) {
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new b(str, bool, taskCompletionSource, 1));
        listenToVoidResponse(taskCompletionSource, voidResult);
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi
    public void setAutomaticResourceManagementEnabled(String str, Boolean bool, GeneratedAndroidFirebaseCore.VoidResult voidResult) {
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new b(str, bool, taskCompletionSource, 0));
        listenToVoidResponse(taskCompletionSource, voidResult);
    }
}
