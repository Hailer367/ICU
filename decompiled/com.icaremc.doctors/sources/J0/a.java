package J0;

import android.content.Intent;
import android.util.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

/* loaded from: classes.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler, EventChannel.StreamHandler, ActivityAware, PluginRegistry.NewIntentListener {

    /* renamed from: c, reason: collision with root package name */
    public MethodChannel f330c;

    /* renamed from: d, reason: collision with root package name */
    public EventChannel f331d;

    /* renamed from: e, reason: collision with root package name */
    public EventChannel.EventSink f332e;

    /* renamed from: f, reason: collision with root package name */
    public ActivityPluginBinding f333f;

    /* renamed from: g, reason: collision with root package name */
    public String f334g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f335h = false;

    /* renamed from: i, reason: collision with root package name */
    public String f336i;

    public final boolean a(Intent intent) {
        String str;
        if (intent == null) {
            return false;
        }
        Log.d("com.llfbandit.app_links", intent.toString());
        if ((intent.getFlags() & 1048576) == 1048576) {
            return false;
        }
        String action = intent.getAction();
        if (!"android.intent.action.SEND".equals(action) && !"android.intent.action.SEND_MULTIPLE".equals(action) && !"android.intent.action.SENDTO".equals(action)) {
            str = intent.getDataString();
            if (str != null) {
                Log.d("com.llfbandit.app_links", "Handled intent: action: " + action + " / data: " + str);
            }
        } else {
            str = null;
        }
        if (str == null) {
            return false;
        }
        if (this.f334g == null) {
            this.f334g = str;
        }
        this.f336i = str;
        EventChannel.EventSink eventSink = this.f332e;
        if (eventSink != null) {
            this.f335h = true;
            eventSink.success(str);
        }
        return true;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.f333f = activityPluginBinding;
        activityPluginBinding.addOnNewIntentListener(this);
        a(activityPluginBinding.getActivity().getIntent());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.llfbandit.app_links/messages");
        this.f330c = methodChannel;
        methodChannel.setMethodCallHandler(this);
        EventChannel eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "com.llfbandit.app_links/events");
        this.f331d = eventChannel;
        eventChannel.setStreamHandler(this);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        this.f332e = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivity() {
        ActivityPluginBinding activityPluginBinding = this.f333f;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeOnNewIntentListener(this);
        }
        this.f333f = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f330c.setMethodCallHandler(null);
        this.f331d.setStreamHandler(null);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        String str;
        this.f332e = eventSink;
        if (!this.f335h && (str = this.f334g) != null) {
            this.f335h = true;
            eventSink.success(str);
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getLatestLink")) {
            result.success(this.f336i);
        } else if (methodCall.method.equals("getInitialLink")) {
            result.success(this.f334g);
        } else {
            result.notImplemented();
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public final boolean onNewIntent(Intent intent) {
        return a(intent);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        this.f333f = activityPluginBinding;
        activityPluginBinding.addOnNewIntentListener(this);
    }
}
