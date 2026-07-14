package com.pichillilorenzo.flutter_inappwebview_android.tracing;

import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import p0.AbstractC0565d;
import p0.k;
import p0.l;
import p0.m;
import s2.C0644p;

/* loaded from: classes.dex */
public class TracingControllerManager implements Disposable {
    protected static final String LOG_TAG = "TracingControllerMan";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_tracingcontroller";
    public static m tracingController;
    public TracingControllerChannelDelegate channelDelegate;
    public InAppWebViewFlutterPlugin plugin;

    public TracingControllerManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        this.channelDelegate = new TracingControllerChannelDelegate(this, new C0644p(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
    }

    public static k buildTracingConfig(TracingSettings tracingSettings) {
        int i4;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (Object obj : tracingSettings.categories) {
            if (obj instanceof String) {
                arrayList.addAll(Arrays.asList((String) obj));
            }
            if (obj instanceof Integer) {
                i5 |= new int[]{((Integer) obj).intValue()}[0];
            }
        }
        Integer num = tracingSettings.tracingMode;
        if (num != null) {
            i4 = num.intValue();
        } else {
            i4 = 1;
        }
        return new k(arrayList, i5, i4);
    }

    public static void init() {
        if (tracingController == null && AbstractC0565d.a("TRACING_CONTROLLER_BASIC_USAGE")) {
            tracingController = l.f5805a;
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        TracingControllerChannelDelegate tracingControllerChannelDelegate = this.channelDelegate;
        if (tracingControllerChannelDelegate != null) {
            tracingControllerChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.plugin = null;
    }
}
