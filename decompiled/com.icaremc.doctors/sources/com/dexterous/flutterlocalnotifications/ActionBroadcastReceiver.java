package com.dexterous.flutterlocalnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Keep;
import com.dexterous.flutterlocalnotifications.isolate.IsolatePreferences;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.EventChannel;
import io.flutter.view.FlutterCallbackInformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u.H;

/* loaded from: classes.dex */
public class ActionBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_TAPPED = "com.dexterous.flutterlocalnotifications.ActionBroadcastReceiver.ACTION_TAPPED";
    private static final String TAG = "ActionBroadcastReceiver";
    private static ActionEventSink actionEventSink;
    private static FlutterEngine engine;
    IsolatePreferences preferences;

    /* loaded from: classes.dex */
    public static class ActionEventSink implements EventChannel.StreamHandler {
        final List<Map<String, Object>> cache;
        private EventChannel.EventSink eventSink;

        public /* synthetic */ ActionEventSink(int i2) {
            this();
        }

        public void addItem(Map<String, Object> map) {
            EventChannel.EventSink eventSink = this.eventSink;
            if (eventSink != null) {
                eventSink.success(map);
            } else {
                this.cache.add(map);
            }
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onCancel(Object obj) {
            this.eventSink = null;
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onListen(Object obj, EventChannel.EventSink eventSink) {
            Iterator<Map<String, Object>> it = this.cache.iterator();
            while (it.hasNext()) {
                eventSink.success(it.next());
            }
            this.cache.clear();
            this.eventSink = eventSink;
        }

        private ActionEventSink() {
            this.cache = new ArrayList();
        }
    }

    public ActionBroadcastReceiver(IsolatePreferences isolatePreferences) {
        this.preferences = isolatePreferences;
    }

    private void initializeEventChannel(DartExecutor dartExecutor) {
        new EventChannel(dartExecutor.getBinaryMessenger(), "dexterous.com/flutter/local_notifications/actions").setStreamHandler(actionEventSink);
    }

    private void startEngine(Context context) {
        if (engine != null) {
            Log.e(TAG, "Engine is already initialised");
            return;
        }
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        flutterLoader.startInitialization(context);
        flutterLoader.ensureInitializationComplete(context, null);
        engine = new FlutterEngine(context);
        FlutterCallbackInformation lookupDispatcherHandle = this.preferences.lookupDispatcherHandle();
        if (lookupDispatcherHandle == null) {
            Log.w(TAG, "Callback information could not be retrieved");
            return;
        }
        DartExecutor dartExecutor = engine.getDartExecutor();
        initializeEventChannel(dartExecutor);
        dartExecutor.executeDartCallback(new DartExecutor.DartCallback(context.getAssets(), flutterLoader.findAppBundlePath(), lookupDispatcherHandle));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!ACTION_TAPPED.equalsIgnoreCase(intent.getAction())) {
            return;
        }
        IsolatePreferences isolatePreferences = this.preferences;
        if (isolatePreferences == null) {
            isolatePreferences = new IsolatePreferences(context);
        }
        this.preferences = isolatePreferences;
        Map<String, Object> extractNotificationResponseMap = FlutterLocalNotificationsPlugin.extractNotificationResponseMap(intent);
        int i2 = 0;
        if (intent.getBooleanExtra("cancelNotification", false)) {
            int intValue = ((Integer) extractNotificationResponseMap.get("notificationId")).intValue();
            Object obj = extractNotificationResponseMap.get("notificationTag");
            if (obj instanceof String) {
                new H(context).a(intValue, (String) obj);
            } else {
                new H(context).a(intValue, null);
            }
        }
        if (actionEventSink == null) {
            actionEventSink = new ActionEventSink(i2);
        }
        actionEventSink.addItem(extractNotificationResponseMap);
        startEngine(context);
    }

    @Keep
    public ActionBroadcastReceiver() {
    }
}
