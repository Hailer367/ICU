package y2;

import A2.q;
import A2.t;
import D2.J;
import P1.w;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.lifecycle.A;
import androidx.lifecycle.AbstractC0217y;
import d2.C0264e;
import f1.AbstractC0286a;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundService;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingReceiver;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import o.B1;
import p1.AbstractC0579h;
import p1.C0580i;
import p1.C0585n;
import p2.InterfaceC0586a;
import q1.AbstractC0602b;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import s2.InterfaceC0647s;
import x.H;
import x2.RunnableC0724c;

/* loaded from: classes.dex */
public class f implements FlutterFirebasePlugin, InterfaceC0642n, InterfaceC0647s, o2.c, InterfaceC0586a {

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f6601f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public C0644p f6602g;

    /* renamed from: h, reason: collision with root package name */
    public Activity f6603h;

    /* renamed from: i, reason: collision with root package name */
    public final h f6604i;

    /* renamed from: j, reason: collision with root package name */
    public e f6605j;
    public final h k;

    /* renamed from: l, reason: collision with root package name */
    public e f6606l;

    /* renamed from: m, reason: collision with root package name */
    public w f6607m;

    /* renamed from: n, reason: collision with root package name */
    public Map f6608n;

    /* renamed from: o, reason: collision with root package name */
    public g f6609o;

    /* JADX WARN: Type inference failed for: r0v5, types: [y2.h, androidx.lifecycle.y] */
    /* JADX WARN: Type inference failed for: r0v6, types: [y2.h, androidx.lifecycle.y] */
    public f() {
        if (h.f6613l == null) {
            h.f6613l = new AbstractC0217y();
        }
        this.f6604i = h.f6613l;
        if (h.f6614m == null) {
            h.f6614m = new AbstractC0217y();
        }
        this.k = h.f6614m;
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public final AbstractC0579h didReinitializeFirebaseCore() {
        C0580i c0580i = new C0580i();
        FlutterFirebasePlugin.cachedThreadPool.execute(new x2.e(c0580i, 1));
        return c0580i.f5821a;
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public final AbstractC0579h getPluginConstantsForFirebaseApp(u1.f fVar) {
        C0580i c0580i = new C0580i();
        FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(fVar, c0580i, 2));
        return c0580i.f5821a;
    }

    @Override // p2.InterfaceC0586a
    public final void onAttachedToActivity(p2.b bVar) {
        B1 b12 = (B1) bVar;
        b12.b(this);
        ((HashSet) b12.f5416h).add(this.f6609o);
        Activity activity = (Activity) b12.f5414f;
        this.f6603h = activity;
        if (activity.getIntent() != null && this.f6603h.getIntent().getExtras() != null && (this.f6603h.getIntent().getFlags() & 1048576) != 1048576) {
            onNewIntent(this.f6603h.getIntent());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [y2.e] */
    /* JADX WARN: Type inference failed for: r4v3, types: [y2.e, androidx.lifecycle.A] */
    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        Context context = bVar.f5785a;
        Log.d("FLTFireContextHolder", "received application context.");
        AbstractC0286a.f3704c = context;
        C0644p c0644p = new C0644p(bVar.f5787c, "plugins.flutter.io/firebase_messaging");
        this.f6602g = c0644p;
        c0644p.b(this);
        this.f6609o = new g();
        final int i4 = 0;
        ?? r4 = new A(this) { // from class: y2.e

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ f f6600g;

            {
                this.f6600g = this;
            }

            @Override // androidx.lifecycle.A
            public final void v(Object obj) {
                switch (i4) {
                    case 0:
                        this.f6600g.f6602g.a("Messaging#onMessage", k3.b.v((w) obj), null);
                        return;
                    default:
                        this.f6600g.f6602g.a("Messaging#onTokenRefresh", (String) obj, null);
                        return;
                }
            }
        };
        this.f6605j = r4;
        final int i5 = 1;
        this.f6606l = new A(this) { // from class: y2.e

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ f f6600g;

            {
                this.f6600g = this;
            }

            @Override // androidx.lifecycle.A
            public final void v(Object obj) {
                switch (i5) {
                    case 0:
                        this.f6600g.f6602g.a("Messaging#onMessage", k3.b.v((w) obj), null);
                        return;
                    default:
                        this.f6600g.f6602g.a("Messaging#onTokenRefresh", (String) obj, null);
                        return;
                }
            }
        };
        this.f6604i.c(r4);
        this.k.c(this.f6606l);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_messaging", this);
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivity() {
        this.f6603h = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivityForConfigChanges() {
        this.f6603h = null;
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        this.k.e(this.f6606l);
        this.f6604i.e(this.f6605j);
    }

    @Override // s2.InterfaceC0642n
    public final void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        C0585n c0585n;
        long intValue;
        long intValue2;
        q qVar;
        String str = c0641m.f6155a;
        Object obj = c0641m.f6156b;
        str.getClass();
        final int i4 = 2;
        final int i5 = 1;
        final int i6 = 0;
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1704007366:
                if (str.equals("Messaging#getInitialMessage")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1661255137:
                if (str.equals("Messaging#setAutoInitEnabled")) {
                    c4 = 1;
                    break;
                }
                break;
            case -657665041:
                if (str.equals("Messaging#deleteToken")) {
                    c4 = 2;
                    break;
                }
                break;
            case 421314579:
                if (str.equals("Messaging#unsubscribeFromTopic")) {
                    c4 = 3;
                    break;
                }
                break;
            case 506322569:
                if (str.equals("Messaging#subscribeToTopic")) {
                    c4 = 4;
                    break;
                }
                break;
            case 607887267:
                if (str.equals("Messaging#setDeliveryMetricsExportToBigQuery")) {
                    c4 = 5;
                    break;
                }
                break;
            case 928431066:
                if (str.equals("Messaging#startBackgroundIsolate")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1165917248:
                if (str.equals("Messaging#sendMessage")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1231338975:
                if (str.equals("Messaging#requestPermission")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1243856389:
                if (str.equals("Messaging#getNotificationSettings")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1459336962:
                if (str.equals("Messaging#getToken")) {
                    c4 = '\n';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                final C0580i c0580i = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable(this) { // from class: y2.c

                    /* renamed from: g, reason: collision with root package name */
                    public final /* synthetic */ f f6594g;

                    {
                        this.f6594g = this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
                    /* JADX WARN: Type inference failed for: r0v15 */
                    /* JADX WARN: Type inference failed for: r0v16 */
                    /* JADX WARN: Type inference failed for: r0v17 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        Map map;
                        boolean z;
                        ?? r02;
                        switch (i6) {
                            case 0:
                                C0580i c0580i2 = c0580i;
                                f fVar = this.f6594g;
                                HashMap hashMap = fVar.f6601f;
                                try {
                                    w wVar = fVar.f6607m;
                                    if (wVar != null) {
                                        HashMap v3 = k3.b.v(wVar);
                                        Map map2 = fVar.f6608n;
                                        if (map2 != null) {
                                            v3.put("notification", map2);
                                        }
                                        c0580i2.b(v3);
                                        fVar.f6607m = null;
                                        fVar.f6608n = null;
                                        return;
                                    }
                                    Activity activity = fVar.f6603h;
                                    if (activity == null) {
                                        c0580i2.b(null);
                                        return;
                                    }
                                    Intent intent = activity.getIntent();
                                    if (intent != null && intent.getExtras() != null) {
                                        String string = intent.getExtras().getString("google.message_id");
                                        if (string == null) {
                                            string = intent.getExtras().getString("message_id");
                                        }
                                        if (string != null && hashMap.get(string) == null) {
                                            w wVar2 = (w) FlutterFirebaseMessagingReceiver.f4411a.get(string);
                                            if (wVar2 == null) {
                                                HashMap b4 = P1.A.c().b(string);
                                                if (b4 != null) {
                                                    wVar2 = k3.b.k(b4);
                                                    if (b4.get("notification") != null) {
                                                        map = (Map) b4.get("notification");
                                                        P1.A.c().g(string);
                                                    }
                                                }
                                                map = null;
                                                P1.A.c().g(string);
                                            } else {
                                                map = null;
                                            }
                                            if (wVar2 == null) {
                                                c0580i2.b(null);
                                                return;
                                            }
                                            hashMap.put(string, Boolean.TRUE);
                                            HashMap v4 = k3.b.v(wVar2);
                                            if (wVar2.c() == null && map != null) {
                                                v4.put("notification", map);
                                            }
                                            c0580i2.b(v4);
                                            return;
                                        }
                                        c0580i2.b(null);
                                        return;
                                    }
                                    c0580i2.b(null);
                                    return;
                                } catch (Exception e4) {
                                    c0580i2.a(e4);
                                    return;
                                }
                            case 1:
                                f fVar2 = this.f6594g;
                                C0580i c0580i3 = c0580i;
                                HashMap hashMap2 = new HashMap();
                                try {
                                    if (AbstractC0286a.f3704c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        fVar2.f6609o.a(fVar2.f6603h, new O0.j(7, hashMap2, c0580i3), new J(24, c0580i3));
                                    } else {
                                        hashMap2.put("authorizationStatus", 1);
                                        c0580i3.b(hashMap2);
                                    }
                                    return;
                                } catch (Exception e5) {
                                    c0580i3.a(e5);
                                    return;
                                }
                            default:
                                f fVar3 = this.f6594g;
                                C0580i c0580i4 = c0580i;
                                try {
                                    HashMap hashMap3 = new HashMap();
                                    if (Build.VERSION.SDK_INT >= 33) {
                                        if (AbstractC0286a.f3704c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                            r02 = 1;
                                        } else {
                                            r02 = 0;
                                        }
                                    } else {
                                        r02 = new H(fVar3.f6603h).f6329b.areNotificationsEnabled();
                                    }
                                    hashMap3.put("authorizationStatus", Integer.valueOf((int) r02));
                                    c0580i4.b(hashMap3);
                                    return;
                                } catch (Exception e6) {
                                    c0580i4.a(e6);
                                    return;
                                }
                        }
                    }
                });
                c0585n = c0580i.f5821a;
                break;
            case 1:
                C0580i c0580i2 = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new d(this, (Map) obj, c0580i2));
                c0585n = c0580i2.f5821a;
                break;
            case 2:
                C0580i c0580i3 = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new x2.e(c0580i3, 3));
                c0585n = c0580i3.f5821a;
                break;
            case 3:
                C0580i c0580i4 = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new d((Map) obj, c0580i4, 0));
                c0585n = c0580i4.f5821a;
                break;
            case 4:
                C0580i c0580i5 = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new d((Map) obj, c0580i5, 3));
                c0585n = c0580i5.f5821a;
                break;
            case 5:
                C0580i c0580i6 = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new d((Map) obj, c0580i6, 1));
                c0585n = c0580i6.f5821a;
                break;
            case 6:
                Map map = (Map) obj;
                Object obj2 = map.get("pluginCallbackHandle");
                Object obj3 = map.get("userCallbackHandle");
                if (obj2 instanceof Long) {
                    intValue = ((Long) obj2).longValue();
                } else if (obj2 instanceof Integer) {
                    intValue = ((Integer) obj2).intValue();
                } else {
                    throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'pluginCallbackHandle'.");
                }
                if (obj3 instanceof Long) {
                    intValue2 = ((Long) obj3).longValue();
                } else if (obj3 instanceof Integer) {
                    intValue2 = ((Integer) obj3).intValue();
                } else {
                    throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'userCallbackHandle'.");
                }
                Activity activity = this.f6603h;
                if (activity != null) {
                    qVar = q.x(activity.getIntent());
                } else {
                    qVar = null;
                }
                List list = FlutterFirebaseMessagingBackgroundService.f4409m;
                Context context = AbstractC0286a.f3704c;
                if (context == null) {
                    Log.e("FLTFireBGExecutor", "Context is null, cannot continue.");
                } else {
                    context.getSharedPreferences("io.flutter.firebase.messaging.callback", 0).edit().putLong("callback_handle", intValue).apply();
                }
                AbstractC0286a.f3704c.getSharedPreferences("io.flutter.firebase.messaging.callback", 0).edit().putLong("user_callback_handle", intValue2).apply();
                if (FlutterFirebaseMessagingBackgroundService.f4410n != null) {
                    Log.w("FLTFireMsgService", "Attempted to start a duplicate background isolate. Returning...");
                } else {
                    t tVar = new t(28);
                    FlutterFirebaseMessagingBackgroundService.f4410n = tVar;
                    tVar.Y(intValue, qVar);
                }
                c0585n = AbstractC0602b.A(null);
                break;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                C0580i c0580i7 = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new d((Map) obj, c0580i7, 4));
                c0585n = c0580i7.f5821a;
                break;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                if (Build.VERSION.SDK_INT >= 33) {
                    final C0580i c0580i8 = new C0580i();
                    FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable(this) { // from class: y2.c

                        /* renamed from: g, reason: collision with root package name */
                        public final /* synthetic */ f f6594g;

                        {
                            this.f6594g = this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
                        /* JADX WARN: Type inference failed for: r0v15 */
                        /* JADX WARN: Type inference failed for: r0v16 */
                        /* JADX WARN: Type inference failed for: r0v17 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            Map map2;
                            boolean z;
                            ?? r02;
                            switch (i5) {
                                case 0:
                                    C0580i c0580i22 = c0580i8;
                                    f fVar = this.f6594g;
                                    HashMap hashMap = fVar.f6601f;
                                    try {
                                        w wVar = fVar.f6607m;
                                        if (wVar != null) {
                                            HashMap v3 = k3.b.v(wVar);
                                            Map map22 = fVar.f6608n;
                                            if (map22 != null) {
                                                v3.put("notification", map22);
                                            }
                                            c0580i22.b(v3);
                                            fVar.f6607m = null;
                                            fVar.f6608n = null;
                                            return;
                                        }
                                        Activity activity2 = fVar.f6603h;
                                        if (activity2 == null) {
                                            c0580i22.b(null);
                                            return;
                                        }
                                        Intent intent = activity2.getIntent();
                                        if (intent != null && intent.getExtras() != null) {
                                            String string = intent.getExtras().getString("google.message_id");
                                            if (string == null) {
                                                string = intent.getExtras().getString("message_id");
                                            }
                                            if (string != null && hashMap.get(string) == null) {
                                                w wVar2 = (w) FlutterFirebaseMessagingReceiver.f4411a.get(string);
                                                if (wVar2 == null) {
                                                    HashMap b4 = P1.A.c().b(string);
                                                    if (b4 != null) {
                                                        wVar2 = k3.b.k(b4);
                                                        if (b4.get("notification") != null) {
                                                            map2 = (Map) b4.get("notification");
                                                            P1.A.c().g(string);
                                                        }
                                                    }
                                                    map2 = null;
                                                    P1.A.c().g(string);
                                                } else {
                                                    map2 = null;
                                                }
                                                if (wVar2 == null) {
                                                    c0580i22.b(null);
                                                    return;
                                                }
                                                hashMap.put(string, Boolean.TRUE);
                                                HashMap v4 = k3.b.v(wVar2);
                                                if (wVar2.c() == null && map2 != null) {
                                                    v4.put("notification", map2);
                                                }
                                                c0580i22.b(v4);
                                                return;
                                            }
                                            c0580i22.b(null);
                                            return;
                                        }
                                        c0580i22.b(null);
                                        return;
                                    } catch (Exception e4) {
                                        c0580i22.a(e4);
                                        return;
                                    }
                                case 1:
                                    f fVar2 = this.f6594g;
                                    C0580i c0580i32 = c0580i8;
                                    HashMap hashMap2 = new HashMap();
                                    try {
                                        if (AbstractC0286a.f3704c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            fVar2.f6609o.a(fVar2.f6603h, new O0.j(7, hashMap2, c0580i32), new J(24, c0580i32));
                                        } else {
                                            hashMap2.put("authorizationStatus", 1);
                                            c0580i32.b(hashMap2);
                                        }
                                        return;
                                    } catch (Exception e5) {
                                        c0580i32.a(e5);
                                        return;
                                    }
                                default:
                                    f fVar3 = this.f6594g;
                                    C0580i c0580i42 = c0580i8;
                                    try {
                                        HashMap hashMap3 = new HashMap();
                                        if (Build.VERSION.SDK_INT >= 33) {
                                            if (AbstractC0286a.f3704c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                                r02 = 1;
                                            } else {
                                                r02 = 0;
                                            }
                                        } else {
                                            r02 = new H(fVar3.f6603h).f6329b.areNotificationsEnabled();
                                        }
                                        hashMap3.put("authorizationStatus", Integer.valueOf((int) r02));
                                        c0580i42.b(hashMap3);
                                        return;
                                    } catch (Exception e6) {
                                        c0580i42.a(e6);
                                        return;
                                    }
                            }
                        }
                    });
                    c0585n = c0580i8.f5821a;
                    break;
                } else {
                    final C0580i c0580i9 = new C0580i();
                    FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable(this) { // from class: y2.c

                        /* renamed from: g, reason: collision with root package name */
                        public final /* synthetic */ f f6594g;

                        {
                            this.f6594g = this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
                        /* JADX WARN: Type inference failed for: r0v15 */
                        /* JADX WARN: Type inference failed for: r0v16 */
                        /* JADX WARN: Type inference failed for: r0v17 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            Map map2;
                            boolean z;
                            ?? r02;
                            switch (i4) {
                                case 0:
                                    C0580i c0580i22 = c0580i9;
                                    f fVar = this.f6594g;
                                    HashMap hashMap = fVar.f6601f;
                                    try {
                                        w wVar = fVar.f6607m;
                                        if (wVar != null) {
                                            HashMap v3 = k3.b.v(wVar);
                                            Map map22 = fVar.f6608n;
                                            if (map22 != null) {
                                                v3.put("notification", map22);
                                            }
                                            c0580i22.b(v3);
                                            fVar.f6607m = null;
                                            fVar.f6608n = null;
                                            return;
                                        }
                                        Activity activity2 = fVar.f6603h;
                                        if (activity2 == null) {
                                            c0580i22.b(null);
                                            return;
                                        }
                                        Intent intent = activity2.getIntent();
                                        if (intent != null && intent.getExtras() != null) {
                                            String string = intent.getExtras().getString("google.message_id");
                                            if (string == null) {
                                                string = intent.getExtras().getString("message_id");
                                            }
                                            if (string != null && hashMap.get(string) == null) {
                                                w wVar2 = (w) FlutterFirebaseMessagingReceiver.f4411a.get(string);
                                                if (wVar2 == null) {
                                                    HashMap b4 = P1.A.c().b(string);
                                                    if (b4 != null) {
                                                        wVar2 = k3.b.k(b4);
                                                        if (b4.get("notification") != null) {
                                                            map2 = (Map) b4.get("notification");
                                                            P1.A.c().g(string);
                                                        }
                                                    }
                                                    map2 = null;
                                                    P1.A.c().g(string);
                                                } else {
                                                    map2 = null;
                                                }
                                                if (wVar2 == null) {
                                                    c0580i22.b(null);
                                                    return;
                                                }
                                                hashMap.put(string, Boolean.TRUE);
                                                HashMap v4 = k3.b.v(wVar2);
                                                if (wVar2.c() == null && map2 != null) {
                                                    v4.put("notification", map2);
                                                }
                                                c0580i22.b(v4);
                                                return;
                                            }
                                            c0580i22.b(null);
                                            return;
                                        }
                                        c0580i22.b(null);
                                        return;
                                    } catch (Exception e4) {
                                        c0580i22.a(e4);
                                        return;
                                    }
                                case 1:
                                    f fVar2 = this.f6594g;
                                    C0580i c0580i32 = c0580i9;
                                    HashMap hashMap2 = new HashMap();
                                    try {
                                        if (AbstractC0286a.f3704c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            fVar2.f6609o.a(fVar2.f6603h, new O0.j(7, hashMap2, c0580i32), new J(24, c0580i32));
                                        } else {
                                            hashMap2.put("authorizationStatus", 1);
                                            c0580i32.b(hashMap2);
                                        }
                                        return;
                                    } catch (Exception e5) {
                                        c0580i32.a(e5);
                                        return;
                                    }
                                default:
                                    f fVar3 = this.f6594g;
                                    C0580i c0580i42 = c0580i9;
                                    try {
                                        HashMap hashMap3 = new HashMap();
                                        if (Build.VERSION.SDK_INT >= 33) {
                                            if (AbstractC0286a.f3704c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                                r02 = 1;
                                            } else {
                                                r02 = 0;
                                            }
                                        } else {
                                            r02 = new H(fVar3.f6603h).f6329b.areNotificationsEnabled();
                                        }
                                        hashMap3.put("authorizationStatus", Integer.valueOf((int) r02));
                                        c0580i42.b(hashMap3);
                                        return;
                                    } catch (Exception e6) {
                                        c0580i42.a(e6);
                                        return;
                                    }
                            }
                        }
                    });
                    c0585n = c0580i9.f5821a;
                    break;
                }
            case '\t':
                final C0580i c0580i10 = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable(this) { // from class: y2.c

                    /* renamed from: g, reason: collision with root package name */
                    public final /* synthetic */ f f6594g;

                    {
                        this.f6594g = this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
                    /* JADX WARN: Type inference failed for: r0v15 */
                    /* JADX WARN: Type inference failed for: r0v16 */
                    /* JADX WARN: Type inference failed for: r0v17 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        Map map2;
                        boolean z;
                        ?? r02;
                        switch (i4) {
                            case 0:
                                C0580i c0580i22 = c0580i10;
                                f fVar = this.f6594g;
                                HashMap hashMap = fVar.f6601f;
                                try {
                                    w wVar = fVar.f6607m;
                                    if (wVar != null) {
                                        HashMap v3 = k3.b.v(wVar);
                                        Map map22 = fVar.f6608n;
                                        if (map22 != null) {
                                            v3.put("notification", map22);
                                        }
                                        c0580i22.b(v3);
                                        fVar.f6607m = null;
                                        fVar.f6608n = null;
                                        return;
                                    }
                                    Activity activity2 = fVar.f6603h;
                                    if (activity2 == null) {
                                        c0580i22.b(null);
                                        return;
                                    }
                                    Intent intent = activity2.getIntent();
                                    if (intent != null && intent.getExtras() != null) {
                                        String string = intent.getExtras().getString("google.message_id");
                                        if (string == null) {
                                            string = intent.getExtras().getString("message_id");
                                        }
                                        if (string != null && hashMap.get(string) == null) {
                                            w wVar2 = (w) FlutterFirebaseMessagingReceiver.f4411a.get(string);
                                            if (wVar2 == null) {
                                                HashMap b4 = P1.A.c().b(string);
                                                if (b4 != null) {
                                                    wVar2 = k3.b.k(b4);
                                                    if (b4.get("notification") != null) {
                                                        map2 = (Map) b4.get("notification");
                                                        P1.A.c().g(string);
                                                    }
                                                }
                                                map2 = null;
                                                P1.A.c().g(string);
                                            } else {
                                                map2 = null;
                                            }
                                            if (wVar2 == null) {
                                                c0580i22.b(null);
                                                return;
                                            }
                                            hashMap.put(string, Boolean.TRUE);
                                            HashMap v4 = k3.b.v(wVar2);
                                            if (wVar2.c() == null && map2 != null) {
                                                v4.put("notification", map2);
                                            }
                                            c0580i22.b(v4);
                                            return;
                                        }
                                        c0580i22.b(null);
                                        return;
                                    }
                                    c0580i22.b(null);
                                    return;
                                } catch (Exception e4) {
                                    c0580i22.a(e4);
                                    return;
                                }
                            case 1:
                                f fVar2 = this.f6594g;
                                C0580i c0580i32 = c0580i10;
                                HashMap hashMap2 = new HashMap();
                                try {
                                    if (AbstractC0286a.f3704c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        fVar2.f6609o.a(fVar2.f6603h, new O0.j(7, hashMap2, c0580i32), new J(24, c0580i32));
                                    } else {
                                        hashMap2.put("authorizationStatus", 1);
                                        c0580i32.b(hashMap2);
                                    }
                                    return;
                                } catch (Exception e5) {
                                    c0580i32.a(e5);
                                    return;
                                }
                            default:
                                f fVar3 = this.f6594g;
                                C0580i c0580i42 = c0580i10;
                                try {
                                    HashMap hashMap3 = new HashMap();
                                    if (Build.VERSION.SDK_INT >= 33) {
                                        if (AbstractC0286a.f3704c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                            r02 = 1;
                                        } else {
                                            r02 = 0;
                                        }
                                    } else {
                                        r02 = new H(fVar3.f6603h).f6329b.areNotificationsEnabled();
                                    }
                                    hashMap3.put("authorizationStatus", Integer.valueOf((int) r02));
                                    c0580i42.b(hashMap3);
                                    return;
                                } catch (Exception e6) {
                                    c0580i42.a(e6);
                                    return;
                                }
                        }
                    }
                });
                c0585n = c0580i10.f5821a;
                break;
            case '\n':
                C0580i c0580i11 = new C0580i();
                FlutterFirebasePlugin.cachedThreadPool.execute(new x2.e(this, c0580i11));
                c0585n = c0580i11.f5821a;
                break;
            default:
                ((r2.i) interfaceC0643o).notImplemented();
                return;
        }
        c0585n.h(new C0264e(this, (r2.i) interfaceC0643o));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    @Override // s2.InterfaceC0647s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onNewIntent(android.content.Intent r8) {
        /*
            r7 = this;
            android.os.Bundle r0 = r8.getExtras()
            if (r0 != 0) goto L7
            goto L57
        L7:
            android.os.Bundle r0 = r8.getExtras()
            java.lang.String r1 = "google.message_id"
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto L1d
            android.os.Bundle r0 = r8.getExtras()
            java.lang.String r1 = "message_id"
            java.lang.String r0 = r0.getString(r1)
        L1d:
            if (r0 != 0) goto L20
            goto L57
        L20:
            java.util.HashMap r1 = io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingReceiver.f4411a
            java.lang.Object r2 = r1.get(r0)
            P1.w r2 = (P1.w) r2
            java.lang.String r3 = "notification"
            r4 = 0
            if (r2 != 0) goto L54
            P1.A r5 = P1.A.c()
            java.util.HashMap r5 = r5.b(r0)
            if (r5 == 0) goto L54
            P1.w r2 = k3.b.k(r5)
            java.lang.String r6 = "message"
            java.lang.Object r5 = r5.get(r6)
            java.util.Objects.requireNonNull(r5)
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r5.get(r3)
            if (r6 != 0) goto L4d
            goto L54
        L4d:
            java.lang.Object r5 = r5.get(r3)
            java.util.Map r5 = (java.util.Map) r5
            goto L55
        L54:
            r5 = r4
        L55:
            if (r2 != 0) goto L59
        L57:
            r8 = 0
            return r8
        L59:
            r7.f6607m = r2
            r7.f6608n = r5
            r1.remove(r0)
            java.util.HashMap r0 = k3.b.v(r2)
            P1.v r1 = r2.c()
            if (r1 != 0) goto L71
            java.util.Map r1 = r7.f6608n
            if (r1 == 0) goto L71
            r0.put(r3, r1)
        L71:
            s2.p r1 = r7.f6602g
            java.lang.String r2 = "Messaging#onMessageOpenedApp"
            r1.a(r2, r0, r4)
            android.app.Activity r0 = r7.f6603h
            r0.setIntent(r8)
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.f.onNewIntent(android.content.Intent):boolean");
    }

    @Override // p2.InterfaceC0586a
    public final void onReattachedToActivityForConfigChanges(p2.b bVar) {
        B1 b12 = (B1) bVar;
        b12.b(this);
        this.f6603h = (Activity) b12.f5414f;
    }
}
