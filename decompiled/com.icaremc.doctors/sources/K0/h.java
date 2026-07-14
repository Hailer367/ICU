package K0;

import Q0.j;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

/* loaded from: classes.dex */
public final class h implements FlutterPlugin, MethodChannel.MethodCallHandler, PluginRegistry.ActivityResultListener, Application.ActivityLifecycleCallbacks, ActivityAware, EventChannel.StreamHandler {

    /* renamed from: c, reason: collision with root package name */
    public MethodChannel f585c;

    /* renamed from: d, reason: collision with root package name */
    public EventChannel f586d;

    /* renamed from: e, reason: collision with root package name */
    public d f587e;

    /* renamed from: f, reason: collision with root package name */
    public EventChannel.EventSink f588f;

    /* renamed from: g, reason: collision with root package name */
    public a f589g;

    /* renamed from: h, reason: collision with root package name */
    public MethodChannel.Result f590h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f591i;

    /* renamed from: j, reason: collision with root package name */
    public AppUpdateInfo f592j;

    /* renamed from: k, reason: collision with root package name */
    public AppUpdateManager f593k;

    public final void a(MethodChannel.Result result, c1.a aVar) {
        Activity activity;
        if (this.f592j != null) {
            a aVar2 = this.f589g;
            if (aVar2 != null) {
                activity = aVar2.b();
            } else {
                activity = null;
            }
            if (activity != null) {
                if (this.f593k != null) {
                    aVar.invoke();
                    return;
                } else {
                    result.error("REQUIRE_CHECK_FOR_UPDATE", "Call checkForUpdate first!", null);
                    throw new IllegalArgumentException("kotlin.Unit");
                }
            }
            result.error("REQUIRE_FOREGROUND_ACTIVITY", "in_app_update requires a foreground activity", null);
            throw new IllegalArgumentException("kotlin.Unit");
        }
        result.error("REQUIRE_CHECK_FOR_UPDATE", "Call checkForUpdate first!", null);
        throw new IllegalArgumentException("kotlin.Unit");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        kotlin.jvm.internal.h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.h.e(activity, "activity");
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        MethodChannel.Result result;
        if (i2 == 1276) {
            Integer num = this.f591i;
            if (num != null && num.intValue() == 1) {
                if (i3 != -1) {
                    if (i3 != 0) {
                        if (i3 == 1 && (result = this.f590h) != null) {
                            result.error("IN_APP_UPDATE_FAILED", "Some other error prevented either the user from providing consent or the update to proceed.", null);
                        }
                    } else {
                        MethodChannel.Result result2 = this.f590h;
                        if (result2 != null) {
                            result2.error("USER_DENIED_UPDATE", String.valueOf(i3), null);
                        }
                    }
                } else {
                    MethodChannel.Result result3 = this.f590h;
                    if (result3 != null) {
                        result3.success(null);
                    }
                }
                this.f590h = null;
                return true;
            }
            Integer num2 = this.f591i;
            if (num2 != null && num2.intValue() == 0) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        MethodChannel.Result result4 = this.f590h;
                        if (result4 != null) {
                            result4.error("IN_APP_UPDATE_FAILED", String.valueOf(i3), null);
                        }
                        this.f590h = null;
                    }
                } else {
                    MethodChannel.Result result5 = this.f590h;
                    if (result5 != null) {
                        result5.error("USER_DENIED_UPDATE", String.valueOf(i3), null);
                    }
                    this.f590h = null;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Task<AppUpdateInfo> appUpdateInfo;
        kotlin.jvm.internal.h.e(activity, "activity");
        AppUpdateManager appUpdateManager = this.f593k;
        if (appUpdateManager != null && (appUpdateInfo = appUpdateManager.getAppUpdateInfo()) != null) {
            appUpdateInfo.addOnSuccessListener(new B0.h(4, new e(this, activity, 0)));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        kotlin.jvm.internal.h.e(activity, "activity");
        kotlin.jvm.internal.h.e(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        kotlin.jvm.internal.h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.h.e(activity, "activity");
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        kotlin.jvm.internal.h.e(activityPluginBinding, "activityPluginBinding");
        this.f589g = new f(activityPluginBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        kotlin.jvm.internal.h.e(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "de.ffuf.in_app_update/methods");
        this.f585c = methodChannel;
        methodChannel.setMethodCallHandler(this);
        EventChannel eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "de.ffuf.in_app_update/stateEvents");
        this.f586d = eventChannel;
        eventChannel.setStreamHandler(this);
        d dVar = new d(this, 0);
        this.f587e = dVar;
        AppUpdateManager appUpdateManager = this.f593k;
        if (appUpdateManager != null) {
            appUpdateManager.registerListener(dVar);
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        this.f588f = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivity() {
        this.f589g = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivityForConfigChanges() {
        this.f589g = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.h.e(binding, "binding");
        MethodChannel methodChannel = this.f585c;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
            EventChannel eventChannel = this.f586d;
            if (eventChannel != null) {
                eventChannel.setStreamHandler(null);
                AppUpdateManager appUpdateManager = this.f593k;
                if (appUpdateManager != null) {
                    d dVar = this.f587e;
                    if (dVar != null) {
                        appUpdateManager.unregisterListener(dVar);
                        return;
                    } else {
                        kotlin.jvm.internal.h.g("installStateUpdatedListener");
                        throw null;
                    }
                }
                return;
            }
            kotlin.jvm.internal.h.g("event");
            throw null;
        }
        kotlin.jvm.internal.h.g("channel");
        throw null;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.f588f = eventSink;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall call, final MethodChannel.Result result) {
        Activity activity;
        Application application;
        kotlin.jvm.internal.h.e(call, "call");
        kotlin.jvm.internal.h.e(result, "result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1873373639:
                    if (str.equals("performImmediateUpdate")) {
                        final int i2 = 1;
                        a(result, new c1.a(this) { // from class: K0.c

                            /* renamed from: d, reason: collision with root package name */
                            public final /* synthetic */ h f576d;

                            {
                                this.f576d = this;
                            }

                            @Override // c1.a
                            public final Object invoke() {
                                switch (i2) {
                                    case 0:
                                        h hVar = this.f576d;
                                        hVar.f591i = 0;
                                        hVar.f590h = result;
                                        AppUpdateManager appUpdateManager = hVar.f593k;
                                        if (appUpdateManager != null) {
                                            AppUpdateInfo appUpdateInfo = hVar.f592j;
                                            kotlin.jvm.internal.h.b(appUpdateInfo);
                                            a aVar = hVar.f589g;
                                            kotlin.jvm.internal.h.b(aVar);
                                            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, aVar.b(), AppUpdateOptions.defaultOptions(0), 1276);
                                        }
                                        AppUpdateManager appUpdateManager2 = hVar.f593k;
                                        if (appUpdateManager2 != null) {
                                            appUpdateManager2.registerListener(new d(hVar, 1));
                                        }
                                        return j.f722a;
                                    default:
                                        h hVar2 = this.f576d;
                                        hVar2.f591i = 1;
                                        hVar2.f590h = result;
                                        AppUpdateManager appUpdateManager3 = hVar2.f593k;
                                        if (appUpdateManager3 != null) {
                                            AppUpdateInfo appUpdateInfo2 = hVar2.f592j;
                                            kotlin.jvm.internal.h.b(appUpdateInfo2);
                                            a aVar2 = hVar2.f589g;
                                            kotlin.jvm.internal.h.b(aVar2);
                                            appUpdateManager3.startUpdateFlowForResult(appUpdateInfo2, aVar2.b(), AppUpdateOptions.defaultOptions(1), 1276);
                                        }
                                        return j.f722a;
                                }
                            }
                        });
                        return;
                    }
                    break;
                case -1541164682:
                    if (str.equals("startFlexibleUpdate")) {
                        final int i3 = 0;
                        a(result, new c1.a(this) { // from class: K0.c

                            /* renamed from: d, reason: collision with root package name */
                            public final /* synthetic */ h f576d;

                            {
                                this.f576d = this;
                            }

                            @Override // c1.a
                            public final Object invoke() {
                                switch (i3) {
                                    case 0:
                                        h hVar = this.f576d;
                                        hVar.f591i = 0;
                                        hVar.f590h = result;
                                        AppUpdateManager appUpdateManager = hVar.f593k;
                                        if (appUpdateManager != null) {
                                            AppUpdateInfo appUpdateInfo = hVar.f592j;
                                            kotlin.jvm.internal.h.b(appUpdateInfo);
                                            a aVar = hVar.f589g;
                                            kotlin.jvm.internal.h.b(aVar);
                                            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, aVar.b(), AppUpdateOptions.defaultOptions(0), 1276);
                                        }
                                        AppUpdateManager appUpdateManager2 = hVar.f593k;
                                        if (appUpdateManager2 != null) {
                                            appUpdateManager2.registerListener(new d(hVar, 1));
                                        }
                                        return j.f722a;
                                    default:
                                        h hVar2 = this.f576d;
                                        hVar2.f591i = 1;
                                        hVar2.f590h = result;
                                        AppUpdateManager appUpdateManager3 = hVar2.f593k;
                                        if (appUpdateManager3 != null) {
                                            AppUpdateInfo appUpdateInfo2 = hVar2.f592j;
                                            kotlin.jvm.internal.h.b(appUpdateInfo2);
                                            a aVar2 = hVar2.f589g;
                                            kotlin.jvm.internal.h.b(aVar2);
                                            appUpdateManager3.startUpdateFlowForResult(appUpdateInfo2, aVar2.b(), AppUpdateOptions.defaultOptions(1), 1276);
                                        }
                                        return j.f722a;
                                }
                            }
                        });
                        return;
                    }
                    break;
                case -1317168438:
                    if (str.equals("checkForUpdate")) {
                        a aVar = this.f589g;
                        if (aVar != null) {
                            activity = aVar.b();
                        } else {
                            activity = null;
                        }
                        if (activity != null) {
                            a aVar2 = this.f589g;
                            if (aVar2 != null) {
                                aVar2.a(this);
                            }
                            a aVar3 = this.f589g;
                            if (aVar3 != null && (application = aVar3.b().getApplication()) != null) {
                                application.registerActivityLifecycleCallbacks(this);
                            }
                            a aVar4 = this.f589g;
                            kotlin.jvm.internal.h.b(aVar4);
                            AppUpdateManager create = AppUpdateManagerFactory.create(aVar4.b());
                            this.f593k = create;
                            kotlin.jvm.internal.h.b(create);
                            Task<AppUpdateInfo> appUpdateInfo = create.getAppUpdateInfo();
                            kotlin.jvm.internal.h.d(appUpdateInfo, "getAppUpdateInfo(...)");
                            appUpdateInfo.addOnSuccessListener(new B0.h(5, new e(this, result, 1)));
                            appUpdateInfo.addOnFailureListener(new B0.h(6, result));
                            return;
                        }
                        result.error("REQUIRE_FOREGROUND_ACTIVITY", "in_app_update requires a foreground activity", null);
                        throw new IllegalArgumentException("kotlin.Unit");
                    }
                    break;
                case -193504755:
                    if (str.equals("completeFlexibleUpdate")) {
                        a(result, new b(0, this));
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        kotlin.jvm.internal.h.e(activityPluginBinding, "activityPluginBinding");
        this.f589g = new g(activityPluginBinding);
    }
}
