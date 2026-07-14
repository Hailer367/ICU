package com.pichillilorenzo.flutter_inappwebview_android.tracing;

import android.webkit.TracingConfig;
import android.webkit.TracingController;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import h2.l;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p0.AbstractC0565d;
import p0.k;
import p0.m;
import q0.C0597b;
import q0.o;
import q0.x;
import q0.z;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class TracingControllerChannelDelegate extends ChannelDelegateImpl {
    private TracingControllerManager tracingControllerManager;

    public TracingControllerChannelDelegate(TracingControllerManager tracingControllerManager, C0644p c0644p) {
        super(c0644p);
        this.tracingControllerManager = tracingControllerManager;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.tracingControllerManager = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        boolean isTracing;
        TracingController tracingController;
        FileOutputStream fileOutputStream;
        boolean stop;
        TracingController tracingController2;
        TracingConfig.Builder addCategories;
        TracingConfig.Builder addCategories2;
        TracingConfig.Builder tracingMode;
        TracingConfig build;
        TracingController tracingController3;
        TracingControllerManager.init();
        m mVar = TracingControllerManager.tracingController;
        String str = c0641m.f6155a;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1647175624:
                if (str.equals("isTracing")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    c4 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                if (mVar != null) {
                    o oVar = (o) mVar;
                    C0597b c0597b = x.f5926u;
                    if (c0597b.a()) {
                        if (oVar.f5882a == null) {
                            tracingController = TracingController.getInstance();
                            oVar.f5882a = tracingController;
                        }
                        isTracing = oVar.f5882a.isTracing();
                    } else if (c0597b.b()) {
                        if (oVar.f5883b == null) {
                            oVar.f5883b = z.f5932a.getTracingController();
                        }
                        isTracing = oVar.f5883b.isTracing();
                    } else {
                        throw x.a();
                    }
                    interfaceC0643o.success(Boolean.valueOf(isTracing));
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 1:
                if (mVar != null && AbstractC0565d.a("TRACING_CONTROLLER_BASIC_USAGE")) {
                    String str2 = (String) c0641m.a("filePath");
                    if (str2 != null) {
                        try {
                            fileOutputStream = new FileOutputStream(str2);
                        } catch (FileNotFoundException e4) {
                            e4.printStackTrace();
                            interfaceC0643o.success(Boolean.FALSE);
                            return;
                        }
                    } else {
                        fileOutputStream = null;
                    }
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    o oVar2 = (o) mVar;
                    C0597b c0597b2 = x.f5926u;
                    if (c0597b2.a()) {
                        if (oVar2.f5882a == null) {
                            tracingController2 = TracingController.getInstance();
                            oVar2.f5882a = tracingController2;
                        }
                        stop = oVar2.f5882a.stop(fileOutputStream, newSingleThreadExecutor);
                    } else if (c0597b2.b()) {
                        if (oVar2.f5883b == null) {
                            oVar2.f5883b = z.f5932a.getTracingController();
                        }
                        stop = oVar2.f5883b.stop(fileOutputStream, newSingleThreadExecutor);
                    } else {
                        throw x.a();
                    }
                    interfaceC0643o.success(Boolean.valueOf(stop));
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 2:
                if (mVar != null && AbstractC0565d.a("TRACING_CONTROLLER_BASIC_USAGE")) {
                    Map<String, Object> map = (Map) c0641m.a("settings");
                    TracingSettings tracingSettings = new TracingSettings();
                    tracingSettings.parse2(map);
                    k buildTracingConfig = TracingControllerManager.buildTracingConfig(tracingSettings);
                    o oVar3 = (o) mVar;
                    if (buildTracingConfig != null) {
                        int i4 = buildTracingConfig.f5804c;
                        ArrayList arrayList = buildTracingConfig.f5803b;
                        int i5 = buildTracingConfig.f5802a;
                        C0597b c0597b3 = x.f5926u;
                        if (c0597b3.a()) {
                            if (oVar3.f5882a == null) {
                                tracingController3 = TracingController.getInstance();
                                oVar3.f5882a = tracingController3;
                            }
                            TracingController tracingController4 = oVar3.f5882a;
                            addCategories = l.i().addCategories(i5);
                            addCategories2 = addCategories.addCategories(arrayList);
                            tracingMode = addCategories2.setTracingMode(i4);
                            build = tracingMode.build();
                            tracingController4.start(build);
                        } else if (c0597b3.b()) {
                            if (oVar3.f5883b == null) {
                                oVar3.f5883b = z.f5932a.getTracingController();
                            }
                            oVar3.f5883b.start(i5, arrayList, i4);
                        } else {
                            throw x.a();
                        }
                        interfaceC0643o.success(Boolean.TRUE);
                        return;
                    }
                    throw new IllegalArgumentException("Tracing config must be non null");
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            default:
                interfaceC0643o.notImplemented();
                return;
        }
    }
}
