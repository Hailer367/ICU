package com.github.dart_lang.jni_flutter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import o.B1;
import o2.c;
import p2.InterfaceC0586a;
import p2.b;

/* loaded from: classes.dex */
public class JniFlutterPlugin implements c, InterfaceC0586a {

    @SuppressLint({"StaticFieldLeak"})
    private static Context context;
    private static final ConcurrentHashMap<Long, JniFlutterPlugin> pluginMap = new ConcurrentHashMap<>();
    private volatile Activity activity;
    private long engineId;

    public static Activity getActivity(long j4) {
        JniFlutterPlugin jniFlutterPlugin = pluginMap.get(Long.valueOf(j4));
        Objects.requireNonNull(jniFlutterPlugin);
        return jniFlutterPlugin.activity;
    }

    public static Context getApplicationContext() {
        return context;
    }

    private void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override // p2.InterfaceC0586a
    public void onAttachedToActivity(b bVar) {
        setActivity((Activity) ((B1) bVar).f5414f);
    }

    @Override // o2.c
    public void onAttachedToEngine(o2.b bVar) {
        long j4 = bVar.f5786b.f4127w;
        this.engineId = j4;
        context = bVar.f5785a;
        pluginMap.put(Long.valueOf(j4), this);
    }

    @Override // p2.InterfaceC0586a
    public void onDetachedFromActivity() {
        setActivity(null);
    }

    @Override // p2.InterfaceC0586a
    public void onDetachedFromActivityForConfigChanges() {
        setActivity(null);
    }

    @Override // o2.c
    public void onDetachedFromEngine(o2.b bVar) {
        this.activity = null;
        pluginMap.remove(Long.valueOf(this.engineId));
    }

    @Override // p2.InterfaceC0586a
    public void onReattachedToActivityForConfigChanges(b bVar) {
        setActivity((Activity) ((B1) bVar).f5414f);
    }
}
