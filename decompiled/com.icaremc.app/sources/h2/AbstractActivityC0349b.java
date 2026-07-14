package h2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.C0214v;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.InterfaceC0212t;
import i2.C0368c;
import i2.C0369d;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.platform.C0381e;
import j.O;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import o.B1;
import r2.C0623a;
import s2.C0644p;
import s2.InterfaceC0646r;
import s2.InterfaceC0647s;
import s2.InterfaceC0648t;

/* renamed from: h2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0349b extends Activity implements InterfaceC0352e, InterfaceC0212t {

    /* renamed from: j, reason: collision with root package name */
    public static final int f3971j = View.generateViewId();

    /* renamed from: f, reason: collision with root package name */
    public boolean f3972f = false;

    /* renamed from: g, reason: collision with root package name */
    public C0353f f3973g;

    /* renamed from: h, reason: collision with root package name */
    public final C0214v f3974h;

    /* renamed from: i, reason: collision with root package name */
    public final OnBackInvokedCallback f3975i;

    public AbstractActivityC0349b() {
        OnBackInvokedCallback jVar;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 33) {
            jVar = null;
        } else if (i4 >= 34) {
            jVar = new d0.k(1, this);
        } else {
            jVar = new d0.j(1, this);
        }
        this.f3975i = jVar;
        this.f3974h = new C0214v(this);
    }

    public final String a() {
        String dataString;
        if ((getApplicationInfo().flags & 2) != 0 && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    public final int b() {
        if (getIntent().hasExtra("background_mode")) {
            String stringExtra = getIntent().getStringExtra("background_mode");
            if (stringExtra != null) {
                if (stringExtra.equals("opaque")) {
                    return 1;
                }
                if (stringExtra.equals("transparent")) {
                    return 2;
                }
                throw new IllegalArgumentException("No enum constant io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.".concat(stringExtra));
            }
            throw new NullPointerException("Name is null");
        }
        return 1;
    }

    public final String c() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    public final String d() {
        String str;
        if (getIntent().hasExtra("dart_entrypoint")) {
            return getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            Bundle f4 = f();
            if (f4 != null) {
                str = f4.getString("io.flutter.Entrypoint");
            } else {
                str = null;
            }
            if (str != null) {
                return str;
            }
            return "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    public final String e() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle f4 = f();
            if (f4 != null) {
                return f4.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final Bundle f() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public final void g(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedDispatcher onBackInvokedDispatcher2;
        if (z && !this.f3972f) {
            if (Build.VERSION.SDK_INT >= 33) {
                onBackInvokedDispatcher2 = getOnBackInvokedDispatcher();
                onBackInvokedDispatcher2.registerOnBackInvokedCallback(0, this.f3975i);
                this.f3972f = true;
                return;
            }
            return;
        }
        if (!z && this.f3972f && Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f3975i);
            this.f3972f = false;
        }
    }

    @Override // androidx.lifecycle.InterfaceC0212t
    public final AbstractC0208o getLifecycle() {
        return this.f3974h;
    }

    public final boolean h() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        if (c() == null && !this.f3973g.f3986g) {
            return getIntent().getBooleanExtra("destroy_engine_with_activity", true);
        }
        return booleanExtra;
    }

    public final boolean i() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        if (c() != null) {
            return false;
        }
        return true;
    }

    public final boolean j(String str) {
        C0353f c0353f = this.f3973g;
        if (c0353f == null) {
            Log.w("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after release.");
            return false;
        }
        if (!c0353f.f3989j) {
            Log.w("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after detach.");
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i4, int i5, Intent intent) {
        if (j("onActivityResult")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            if (c0353f.f3981b != null) {
                Objects.toString(intent);
                C0369d c0369d = c0353f.f3981b.f4109d;
                if (c0369d.f()) {
                    E2.a.b("FlutterEngineConnectionRegistry#onActivityResult");
                    try {
                        B1 b12 = c0369d.f4134f;
                        b12.getClass();
                        Iterator it = new HashSet((HashSet) b12.f5417i).iterator();
                        while (true) {
                            boolean z = false;
                            while (it.hasNext()) {
                                if (((InterfaceC0646r) it.next()).onActivityResult(i4, i5, intent) || z) {
                                    z = true;
                                }
                            }
                            Trace.endSection();
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        if (j("onBackPressed")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            C0368c c0368c = c0353f.f3981b;
            if (c0368c != null) {
                ((C0644p) c0368c.f4114i.f4911g).a("popRoute", null, null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(53:1|2|(1:6)|8|(1:10)|11|(2:13|(4:15|(1:17)|18|(2:20|21))(2:23|(4:25|(3:27|88|34)|40|(1:42)(2:43|44))(1:45)))|46|47|48|(1:50)|51|52|(1:54)|55|(1:57)(1:177)|58|(2:60|(1:62)(2:63|(1:65)(1:66)))|67|(4:69|70|71|(1:73)(2:162|(1:164)(2:165|166)))(1:176)|74|(1:76)|77|(1:79)|(1:81)(1:161)|82|(3:84|(1:86)(1:155)|87)(3:156|(1:158)(1:160)|159)|88|(8:90|(1:92)|93|(2:95|(3:97|(1:99)|100)(2:101|102))|103|(1:105)|106|107)|108|(1:110)|111|112|113|114|(2:(1:151)(1:118)|119)(1:152)|120|(2:123|121)|124|125|(2:128|126)|129|130|(2:133|131)|134|135|(2:138|136)|139|(2:142|140)|143|144|(8:146|(1:148)|93|(0)|103|(0)|106|107)(2:149|150)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0303, code lost:
    
        android.util.Log.e("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0455  */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, o.y] */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.view.View, io.flutter.embedding.engine.renderer.m] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.AbstractActivityC0349b.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onDestroy();
        if (j("onDestroy")) {
            this.f3973g.e();
            this.f3973g.f();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f3975i);
            this.f3972f = false;
        }
        C0353f c0353f = this.f3973g;
        if (c0353f != null) {
            c0353f.f3980a = null;
            c0353f.f3981b = null;
            c0353f.f3982c = null;
            c0353f.f3983d = null;
            c0353f.f3984e = null;
            this.f3973g = null;
        }
        this.f3974h.e(EnumC0206m.ON_DESTROY);
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (j("onNewIntent")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            C0368c c0368c = c0353f.f3981b;
            if (c0368c != null) {
                C0369d c0369d = c0368c.f4109d;
                if (c0369d.f()) {
                    E2.a.b("FlutterEngineConnectionRegistry#onNewIntent");
                    try {
                        Iterator it = ((HashSet) c0369d.f4134f.f5418j).iterator();
                        while (it.hasNext()) {
                            ((InterfaceC0647s) it.next()).onNewIntent(intent);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } else {
                    Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
                }
                String d4 = c0353f.d(intent);
                if (d4 != null && !d4.isEmpty()) {
                    O o3 = c0353f.f3981b.f4114i;
                    o3.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("location", d4);
                    ((C0644p) o3.f4911g).a("pushRouteInformation", hashMap, null);
                    return;
                }
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        if (j("onPause")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            c0353f.f3980a.getClass();
            C0368c c0368c = c0353f.f3981b;
            if (c0368c != null) {
                C0623a c0623a = c0368c.f4112g;
                c0623a.a(3, c0623a.f6046c);
            }
        }
        this.f3974h.e(EnumC0206m.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        if (j("onPostResume")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            if (c0353f.f3981b != null) {
                C0381e c0381e = c0353f.f3983d;
                if (c0381e != null) {
                    c0381e.c();
                }
                c0353f.f3981b.f4123s.k();
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        if (j("onRequestPermissionsResult")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            if (c0353f.f3981b != null) {
                Arrays.toString(strArr);
                Arrays.toString(iArr);
                C0369d c0369d = c0353f.f3981b.f4109d;
                if (c0369d.f()) {
                    E2.a.b("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
                    try {
                        Iterator it = ((HashSet) c0369d.f4134f.f5416h).iterator();
                        while (true) {
                            boolean z = false;
                            while (it.hasNext()) {
                                if (((InterfaceC0648t) it.next()).onRequestPermissionsResult(i4, strArr, iArr) || z) {
                                    z = true;
                                }
                            }
                            Trace.endSection();
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f3974h.e(EnumC0206m.ON_RESUME);
        if (j("onResume")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            c0353f.f3981b.f4107b.i();
            c0353f.f3980a.getClass();
            C0368c c0368c = c0353f.f3981b;
            if (c0368c != null) {
                C0623a c0623a = c0368c.f4112g;
                c0623a.a(2, c0623a.f6046c);
            }
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (j("onSaveInstanceState")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            if (c0353f.f3980a.i()) {
                bundle.putByteArray("framework", (byte[]) c0353f.f3981b.k.f5697f);
            }
            c0353f.f3980a.getClass();
            Bundle bundle2 = new Bundle();
            C0369d c0369d = c0353f.f3981b.f4109d;
            if (c0369d.f()) {
                E2.a.b("FlutterEngineConnectionRegistry#onSaveInstanceState");
                try {
                    Iterator it = ((HashSet) c0369d.f4134f.f5419l).iterator();
                    if (!it.hasNext()) {
                        Trace.endSection();
                    } else {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    }
                } catch (Throwable th) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            }
            bundle.putBundle("plugins", bundle2);
            if (c0353f.f3980a.c() != null && !c0353f.f3980a.h()) {
                bundle.putBoolean("enableOnBackInvokedCallbackState", c0353f.f3980a.f3972f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStart() {
        /*
            r6 = this;
            super.onStart()
            androidx.lifecycle.v r0 = r6.f3974h
            androidx.lifecycle.m r1 = androidx.lifecycle.EnumC0206m.ON_START
            r0.e(r1)
            java.lang.String r0 = "onStart"
            boolean r0 = r6.j(r0)
            if (r0 == 0) goto Lc2
            h2.f r0 = r6.f3973g
            r0.c()
            h2.b r1 = r0.f3980a
            java.lang.String r1 = r1.c()
            if (r1 == 0) goto L21
            goto Lb5
        L21:
            i2.c r1 = r0.f3981b
            j2.b r1 = r1.f4108c
            boolean r1 = r1.f5057g
            if (r1 == 0) goto L2b
            goto Lb5
        L2b:
            h2.b r1 = r0.f3980a
            java.lang.String r1 = r1.e()
            if (r1 != 0) goto L44
            h2.b r1 = r0.f3980a
            r1.getClass()
            android.content.Intent r1 = r1.getIntent()
            java.lang.String r1 = r0.d(r1)
            if (r1 != 0) goto L44
            java.lang.String r1 = "/"
        L44:
            h2.b r2 = r0.f3980a
            r2.getClass()
            r3 = 0
            android.os.Bundle r2 = r2.f()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L57
            if (r2 == 0) goto L57
            java.lang.String r4 = "io.flutter.EntrypointUri"
            java.lang.String r2 = r2.getString(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L57
            goto L58
        L57:
            r2 = r3
        L58:
            h2.b r4 = r0.f3980a
            r4.d()
            i2.c r4 = r0.f3981b
            j.O r4 = r4.f4114i
            java.lang.Object r4 = r4.f4911g
            s2.p r4 = (s2.C0644p) r4
            java.lang.String r5 = "setInitialRoute"
            r4.a(r5, r1, r3)
            h2.b r1 = r0.f3980a
            java.lang.String r1 = r1.a()
            if (r1 == 0) goto L78
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L86
        L78:
            A2.t r1 = A2.t.O()
            java.lang.Object r1 = r1.f99g
            m2.e r1 = (m2.C0447e) r1
            P1.r r1 = r1.f5206d
            java.lang.Object r1 = r1.f1439c
            java.lang.String r1 = (java.lang.String) r1
        L86:
            if (r2 != 0) goto L94
            j2.a r2 = new j2.a
            h2.b r3 = r0.f3980a
            java.lang.String r3 = r3.d()
            r2.<init>(r1, r3)
            goto La0
        L94:
            j2.a r3 = new j2.a
            h2.b r4 = r0.f3980a
            java.lang.String r4 = r4.d()
            r3.<init>(r1, r2, r4)
            r2 = r3
        La0:
            i2.c r1 = r0.f3981b
            j2.b r1 = r1.f4108c
            h2.b r3 = r0.f3980a
            android.content.Intent r3 = r3.getIntent()
            java.lang.String r4 = "dart_entrypoint_args"
            java.io.Serializable r3 = r3.getSerializableExtra(r4)
            java.util.List r3 = (java.util.List) r3
            r1.d(r2, r3)
        Lb5:
            java.lang.Integer r1 = r0.k
            if (r1 == 0) goto Lc2
            h2.p r0 = r0.f3982c
            int r1 = r1.intValue()
            r0.setVisibility(r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.AbstractActivityC0349b.onStart():void");
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (j("onStop")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            c0353f.f3980a.getClass();
            C0368c c0368c = c0353f.f3981b;
            if (c0368c != null) {
                C0623a c0623a = c0368c.f4112g;
                c0623a.a(5, c0623a.f6046c);
            }
            c0353f.k = Integer.valueOf(c0353f.f3982c.getVisibility());
            c0353f.f3982c.setVisibility(8);
            C0368c c0368c2 = c0353f.f3981b;
            if (c0368c2 != null) {
                c0368c2.f4107b.f(40);
            }
        }
        this.f3974h.e(EnumC0206m.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i4) {
        super.onTrimMemory(i4);
        if (j("onTrimMemory")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            C0368c c0368c = c0353f.f3981b;
            if (c0368c != null) {
                if (c0353f.f3988i && i4 >= 10) {
                    FlutterJNI flutterJNI = (FlutterJNI) c0368c.f4108c.f5058h;
                    if (flutterJNI.isAttached()) {
                        flutterJNI.notifyLowMemoryWarning();
                    }
                    O o3 = c0353f.f3981b.f4121q;
                    o3.getClass();
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("type", "memoryPressure");
                    ((P1.y) o3.f4911g).v(hashMap, null);
                }
                c0353f.f3981b.f4107b.f(i4);
                io.flutter.plugin.platform.r rVar = c0353f.f3981b.f4123s;
                if (i4 < 40) {
                    rVar.getClass();
                    return;
                }
                Iterator it = rVar.f4377o.values().iterator();
                while (it.hasNext()) {
                    ((io.flutter.plugin.platform.E) it.next()).f4317h.setSurface(null);
                }
            }
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        if (j("onUserLeaveHint")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            C0368c c0368c = c0353f.f3981b;
            if (c0368c != null) {
                C0369d c0369d = c0368c.f4109d;
                if (c0369d.f()) {
                    E2.a.b("FlutterEngineConnectionRegistry#onUserLeaveHint");
                    try {
                        Iterator it = ((HashSet) c0369d.f4134f.k).iterator();
                        if (!it.hasNext()) {
                            Trace.endSection();
                            return;
                        } else {
                            if (it.next() == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        }
                    } catch (Throwable th) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (j("onWindowFocusChanged")) {
            C0353f c0353f = this.f3973g;
            c0353f.c();
            c0353f.f3980a.getClass();
            C0368c c0368c = c0353f.f3981b;
            if (c0368c != null) {
                C0623a c0623a = c0368c.f4112g;
                if (z) {
                    c0623a.a(c0623a.f6044a, true);
                } else {
                    c0623a.a(c0623a.f6044a, false);
                }
            }
        }
    }
}
