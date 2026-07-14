package io.flutter.plugins.firebase.messaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.lifecycle.C;
import androidx.lifecycle.E;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import u.H;

/* loaded from: classes.dex */
public class FlutterFirebaseMessagingPlugin implements FlutterFirebasePlugin, MethodChannel.MethodCallHandler, PluginRegistry.NewIntentListener, FlutterPlugin, ActivityAware {
    private MethodChannel channel;
    private RemoteMessage initialMessage;
    private Map<String, Object> initialMessageNotification;
    private Activity mainActivity;
    FlutterFirebasePermissionManager permissionManager;
    private E remoteMessageObserver;
    private E tokenObserver;
    private final HashMap<String, Boolean> consumedInitialMessages = new HashMap<>();
    private final C liveDataRemoteMessage = FlutterFirebaseRemoteMessageLiveData.getInstance();
    private final C liveDataToken = FlutterFirebaseTokenLiveData.getInstance();

    /* renamed from: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends HashMap<String, Object> {
        final /* synthetic */ String val$token;

        public AnonymousClass1(String str) {
            this.val$token = str;
            put("token", str);
        }
    }

    /* renamed from: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends HashMap<String, Object> {
        final /* synthetic */ FirebaseMessaging val$firebaseMessaging;

        public AnonymousClass2(FirebaseMessaging firebaseMessaging) {
            this.val$firebaseMessaging = firebaseMessaging;
            put("isAutoInitEnabled", Boolean.valueOf(firebaseMessaging.isAutoInitEnabled()));
        }
    }

    private Boolean checkPermissions() {
        boolean z;
        if (ContextHolder.getApplicationContext().checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private Task<Void> deleteToken() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new f(1, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Map<String, Object> getExceptionDetails(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", "unknown");
        if (exc != null) {
            hashMap.put("message", exc.getMessage());
            return hashMap;
        }
        hashMap.put("message", "An unknown error has occurred.");
        return hashMap;
    }

    private Task<Map<String, Object>> getInitialMessage() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new g(this, taskCompletionSource, 3));
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Integer>> getPermissions() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new g(this, taskCompletionSource, 2));
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Object>> getToken() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new g(this, taskCompletionSource, 1));
        return taskCompletionSource.getTask();
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_messaging");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.permissionManager = new FlutterFirebasePermissionManager();
        final int i2 = 0;
        E e2 = new E(this) { // from class: io.flutter.plugins.firebase.messaging.h

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FlutterFirebaseMessagingPlugin f2432b;

            {
                this.f2432b = this;
            }

            @Override // androidx.lifecycle.E
            public final void a(Object obj) {
                switch (i2) {
                    case 0:
                        this.f2432b.lambda$initInstance$0((RemoteMessage) obj);
                        return;
                    default:
                        this.f2432b.lambda$initInstance$1((String) obj);
                        return;
                }
            }
        };
        this.remoteMessageObserver = e2;
        final int i3 = 1;
        this.tokenObserver = new E(this) { // from class: io.flutter.plugins.firebase.messaging.h

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FlutterFirebaseMessagingPlugin f2432b;

            {
                this.f2432b = this;
            }

            @Override // androidx.lifecycle.E
            public final void a(Object obj) {
                switch (i3) {
                    case 0:
                        this.f2432b.lambda$initInstance$0((RemoteMessage) obj);
                        return;
                    default:
                        this.f2432b.lambda$initInstance$1((String) obj);
                        return;
                }
            }
        };
        this.liveDataRemoteMessage.observeForever(e2);
        this.liveDataToken.observeForever(this.tokenObserver);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_messaging", this);
    }

    public static /* synthetic */ void lambda$deleteToken$2(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(FirebaseMessaging.getInstance().deleteToken());
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public /* synthetic */ void lambda$getInitialMessage$9(TaskCompletionSource taskCompletionSource) {
        Map<String, Object> map;
        try {
            RemoteMessage remoteMessage = this.initialMessage;
            if (remoteMessage != null) {
                Map<String, Object> remoteMessageToMap = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage);
                Map<String, Object> map2 = this.initialMessageNotification;
                if (map2 != null) {
                    remoteMessageToMap.put("notification", map2);
                }
                taskCompletionSource.setResult(remoteMessageToMap);
                this.initialMessage = null;
                this.initialMessageNotification = null;
                return;
            }
            Activity activity = this.mainActivity;
            if (activity == null) {
                taskCompletionSource.setResult(null);
                return;
            }
            Intent intent = activity.getIntent();
            if (intent != null && intent.getExtras() != null) {
                String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
                if (string == null) {
                    string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
                }
                if (string != null && this.consumedInitialMessages.get(string) == null) {
                    RemoteMessage remoteMessage2 = FlutterFirebaseMessagingReceiver.notifications.get(string);
                    if (remoteMessage2 == null) {
                        Map<String, Object> firebaseMessageMap = FlutterFirebaseMessagingStore.getInstance().getFirebaseMessageMap(string);
                        if (firebaseMessageMap != null) {
                            remoteMessage2 = FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(firebaseMessageMap);
                            if (firebaseMessageMap.get("notification") != null) {
                                map = uncheckedCastToMap(firebaseMessageMap.get("notification"));
                                FlutterFirebaseMessagingStore.getInstance().removeFirebaseMessage(string);
                            }
                        }
                        map = null;
                        FlutterFirebaseMessagingStore.getInstance().removeFirebaseMessage(string);
                    } else {
                        map = null;
                    }
                    if (remoteMessage2 == null) {
                        taskCompletionSource.setResult(null);
                        return;
                    }
                    this.consumedInitialMessages.put(string, Boolean.TRUE);
                    Map<String, Object> remoteMessageToMap2 = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage2);
                    if (remoteMessage2.getNotification() == null && map != null) {
                        remoteMessageToMap2.put("notification", map);
                    }
                    taskCompletionSource.setResult(remoteMessageToMap2);
                    return;
                }
                taskCompletionSource.setResult(null);
                return;
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void lambda$getPermissions$13(TaskCompletionSource taskCompletionSource) {
        int i2;
        try {
            HashMap hashMap = new HashMap();
            if (Build.VERSION.SDK_INT >= 33) {
                i2 = checkPermissions().booleanValue();
            } else {
                i2 = new H(this.mainActivity).f3699b.areNotificationsEnabled();
            }
            hashMap.put("authorizationStatus", Integer.valueOf(i2));
            taskCompletionSource.setResult(hashMap);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$15(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            HashMap hashMap = new HashMap();
            if (firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                hashMap.put("AUTO_INIT_ENABLED", Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
            }
            taskCompletionSource.setResult(hashMap);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public /* synthetic */ void lambda$getToken$3(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>((String) Tasks.await(FirebaseMessaging.getInstance().getToken())) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.1
                final /* synthetic */ String val$token;

                public AnonymousClass1(String str) {
                    this.val$token = str;
                    put("token", str);
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public /* synthetic */ void lambda$initInstance$0(RemoteMessage remoteMessage) {
        this.channel.invokeMethod("Messaging#onMessage", FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage));
    }

    public /* synthetic */ void lambda$initInstance$1(String str) {
        this.channel.invokeMethod("Messaging#onTokenRefresh", str);
    }

    public /* synthetic */ void lambda$onMethodCall$14(MethodChannel.Result result, Task task) {
        String str;
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = exception.getMessage();
        } else {
            str = null;
        }
        result.error("firebase_messaging", str, getExceptionDetails(exception));
    }

    public static /* synthetic */ void lambda$requestPermissions$10(Map map, TaskCompletionSource taskCompletionSource, int i2) {
        map.put("authorizationStatus", Integer.valueOf(i2));
        taskCompletionSource.setResult(map);
    }

    public static /* synthetic */ void lambda$requestPermissions$11(TaskCompletionSource taskCompletionSource, String str) {
        taskCompletionSource.setException(new Exception(str));
    }

    public /* synthetic */ void lambda$requestPermissions$12(final TaskCompletionSource taskCompletionSource) {
        HashMap hashMap = new HashMap();
        try {
            if (!checkPermissions().booleanValue()) {
                this.permissionManager.requestPermissions(this.mainActivity, new d(hashMap, taskCompletionSource), new ErrorCallback() { // from class: io.flutter.plugins.firebase.messaging.e
                    @Override // io.flutter.plugins.firebase.messaging.ErrorCallback
                    public final void onError(String str) {
                        FlutterFirebaseMessagingPlugin.lambda$requestPermissions$11(TaskCompletionSource.this, str);
                    }
                });
            } else {
                hashMap.put("authorizationStatus", 1);
                taskCompletionSource.setResult(hashMap);
            }
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static /* synthetic */ void lambda$sendMessage$6(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map).send(FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(map));
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public /* synthetic */ void lambda$setAutoInitEnabled$7(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            Object obj = map.get("enabled");
            Objects.requireNonNull(obj);
            firebaseMessagingForArguments.setAutoInitEnabled(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(new HashMap<String, Object>(firebaseMessagingForArguments) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.2
                final /* synthetic */ FirebaseMessaging val$firebaseMessaging;

                public AnonymousClass2(FirebaseMessaging firebaseMessagingForArguments2) {
                    this.val$firebaseMessaging = firebaseMessagingForArguments2;
                    put("isAutoInitEnabled", Boolean.valueOf(firebaseMessagingForArguments2.isAutoInitEnabled()));
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static /* synthetic */ void lambda$setDeliveryMetricsExportToBigQuery$8(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            Object obj = map.get("enabled");
            Objects.requireNonNull(obj);
            firebaseMessagingForArguments.setDeliveryMetricsExportToBigQuery(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static /* synthetic */ void lambda$subscribeToTopic$4(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            Object obj = map.get("topic");
            Objects.requireNonNull(obj);
            Tasks.await(firebaseMessagingForArguments.subscribeToTopic((String) obj));
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public static /* synthetic */ void lambda$unsubscribeFromTopic$5(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            Object obj = map.get("topic");
            Objects.requireNonNull(obj);
            Tasks.await(firebaseMessagingForArguments.unsubscribeFromTopic((String) obj));
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    private Task<Map<String, Integer>> requestPermissions() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new g(this, taskCompletionSource, 0));
        return taskCompletionSource.getTask();
    }

    private Task<Void> sendMessage(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(map, taskCompletionSource, 3));
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Object>> setAutoInitEnabled(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new A0.a(this, map, taskCompletionSource, 4));
        return taskCompletionSource.getTask();
    }

    private Task<Void> setDeliveryMetricsExportToBigQuery(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(map, taskCompletionSource, 1));
        return taskCompletionSource.getTask();
    }

    private Task<Void> subscribeToTopic(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(map, taskCompletionSource, 2));
        return taskCompletionSource.getTask();
    }

    private Map<String, Object> uncheckedCastToMap(Object obj) {
        return (Map) obj;
    }

    private Task<Void> unsubscribeFromTopic(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(map, taskCompletionSource, 0));
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new f(0, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new b(1, firebaseApp, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        activityPluginBinding.addRequestPermissionsResultListener(this.permissionManager);
        Activity activity = activityPluginBinding.getActivity();
        this.mainActivity = activity;
        if (activity.getIntent() != null && this.mainActivity.getIntent().getExtras() != null && (this.mainActivity.getIntent().getFlags() & 1048576) != 1048576) {
            onNewIntent(this.mainActivity.getIntent());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        ContextHolder.setApplicationContext(flutterPluginBinding.getApplicationContext());
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.liveDataToken.removeObserver(this.tokenObserver);
        this.liveDataRemoteMessage.removeObserver(this.remoteMessageObserver);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Task initialMessage;
        long intValue;
        long intValue2;
        FlutterShellArgs flutterShellArgs;
        String str = methodCall.method;
        str.getClass();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1704007366:
                if (str.equals("Messaging#getInitialMessage")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1661255137:
                if (str.equals("Messaging#setAutoInitEnabled")) {
                    c2 = 1;
                    break;
                }
                break;
            case -657665041:
                if (str.equals("Messaging#deleteToken")) {
                    c2 = 2;
                    break;
                }
                break;
            case 421314579:
                if (str.equals("Messaging#unsubscribeFromTopic")) {
                    c2 = 3;
                    break;
                }
                break;
            case 506322569:
                if (str.equals("Messaging#subscribeToTopic")) {
                    c2 = 4;
                    break;
                }
                break;
            case 607887267:
                if (str.equals("Messaging#setDeliveryMetricsExportToBigQuery")) {
                    c2 = 5;
                    break;
                }
                break;
            case 928431066:
                if (str.equals("Messaging#startBackgroundIsolate")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1165917248:
                if (str.equals("Messaging#sendMessage")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1231338975:
                if (str.equals("Messaging#requestPermission")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1243856389:
                if (str.equals("Messaging#getNotificationSettings")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1459336962:
                if (str.equals("Messaging#getToken")) {
                    c2 = '\n';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                initialMessage = getInitialMessage();
                break;
            case 1:
                initialMessage = setAutoInitEnabled((Map) methodCall.arguments());
                break;
            case 2:
                initialMessage = deleteToken();
                break;
            case 3:
                initialMessage = unsubscribeFromTopic((Map) methodCall.arguments());
                break;
            case 4:
                initialMessage = subscribeToTopic((Map) methodCall.arguments());
                break;
            case 5:
                initialMessage = setDeliveryMetricsExportToBigQuery((Map) methodCall.arguments());
                break;
            case 6:
                Map map = (Map) methodCall.arguments;
                Object obj = map.get("pluginCallbackHandle");
                Object obj2 = map.get("userCallbackHandle");
                if (obj instanceof Long) {
                    intValue = ((Long) obj).longValue();
                } else if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else {
                    throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'pluginCallbackHandle'.");
                }
                if (obj2 instanceof Long) {
                    intValue2 = ((Long) obj2).longValue();
                } else if (obj2 instanceof Integer) {
                    intValue2 = ((Integer) obj2).intValue();
                } else {
                    throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'userCallbackHandle'.");
                }
                Activity activity = this.mainActivity;
                if (activity != null) {
                    flutterShellArgs = FlutterShellArgs.fromIntent(activity.getIntent());
                } else {
                    flutterShellArgs = null;
                }
                FlutterFirebaseMessagingBackgroundService.setCallbackDispatcher(intValue);
                FlutterFirebaseMessagingBackgroundService.setUserCallbackHandle(intValue2);
                FlutterFirebaseMessagingBackgroundService.startBackgroundIsolate(intValue, flutterShellArgs);
                initialMessage = Tasks.forResult(null);
                break;
            case 7:
                initialMessage = sendMessage((Map) methodCall.arguments());
                break;
            case '\b':
                if (Build.VERSION.SDK_INT >= 33) {
                    initialMessage = requestPermissions();
                    break;
                } else {
                    initialMessage = getPermissions();
                    break;
                }
            case '\t':
                initialMessage = getPermissions();
                break;
            case '\n':
                initialMessage = getToken();
                break;
            default:
                result.notImplemented();
                return;
        }
        initialMessage.addOnCompleteListener(new d(this, result));
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        Map<String, Object> map;
        Map<String, Object> map2;
        Map<String, Object> firebaseMessageMap;
        if (intent.getExtras() == null) {
            return false;
        }
        String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
        if (string == null) {
            string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        if (string == null) {
            return false;
        }
        RemoteMessage remoteMessage = FlutterFirebaseMessagingReceiver.notifications.get(string);
        if (remoteMessage == null && (firebaseMessageMap = FlutterFirebaseMessagingStore.getInstance().getFirebaseMessageMap(string)) != null) {
            remoteMessage = FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(firebaseMessageMap);
            map = FlutterFirebaseMessagingUtils.getRemoteMessageNotificationForArguments(firebaseMessageMap);
        } else {
            map = null;
        }
        if (remoteMessage == null) {
            return false;
        }
        this.initialMessage = remoteMessage;
        this.initialMessageNotification = map;
        FlutterFirebaseMessagingReceiver.notifications.remove(string);
        Map<String, Object> remoteMessageToMap = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage);
        if (remoteMessage.getNotification() == null && (map2 = this.initialMessageNotification) != null) {
            remoteMessageToMap.put("notification", map2);
        }
        this.channel.invokeMethod("Messaging#onMessageOpenedApp", remoteMessageToMap);
        this.mainActivity.setIntent(intent);
        return true;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        this.mainActivity = activityPluginBinding.getActivity();
    }
}
