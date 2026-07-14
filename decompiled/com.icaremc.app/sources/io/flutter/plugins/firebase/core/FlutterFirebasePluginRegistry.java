package io.flutter.plugins.firebase.core;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import p1.AbstractC0579h;
import p1.C0580i;
import q1.AbstractC0602b;
import u1.f;
import x2.RunnableC0724c;
import x2.e;

@Keep
/* loaded from: classes.dex */
public class FlutterFirebasePluginRegistry {
    private static final Map<String, FlutterFirebasePlugin> registeredPlugins = new WeakHashMap();

    public static AbstractC0579h didReinitializeFirebaseCore() {
        C0580i c0580i = new C0580i();
        FlutterFirebasePlugin.cachedThreadPool.execute(new e(c0580i, 0));
        return c0580i.f5821a;
    }

    public static AbstractC0579h getPluginConstantsForFirebaseApp(f fVar) {
        C0580i c0580i = new C0580i();
        FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(fVar, c0580i, 1));
        return c0580i.f5821a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$didReinitializeFirebaseCore$1(C0580i c0580i) {
        try {
            Iterator<Map.Entry<String, FlutterFirebasePlugin>> it = registeredPlugins.entrySet().iterator();
            while (it.hasNext()) {
                AbstractC0602b.c(it.next().getValue().didReinitializeFirebaseCore());
            }
            c0580i.b(null);
        } catch (Exception e4) {
            c0580i.a(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$0(f fVar, C0580i c0580i) {
        try {
            Map<String, FlutterFirebasePlugin> map = registeredPlugins;
            HashMap hashMap = new HashMap(map.size());
            for (Map.Entry<String, FlutterFirebasePlugin> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), AbstractC0602b.c(entry.getValue().getPluginConstantsForFirebaseApp(fVar)));
            }
            c0580i.b(hashMap);
        } catch (Exception e4) {
            c0580i.a(e4);
        }
    }

    public static void registerPlugin(String str, FlutterFirebasePlugin flutterFirebasePlugin) {
        registeredPlugins.put(str, flutterFirebasePlugin);
    }
}
