package h2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import i2.C0368c;
import i2.C0369d;
import i2.C0371f;
import i2.C0373h;
import i2.InterfaceC0367b;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.platform.C0381e;
import j2.C0426a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import m2.C0447e;
import o.C0553y;
import p2.InterfaceC0586a;
import r2.C0623a;

/* renamed from: h2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0353f {

    /* renamed from: a, reason: collision with root package name */
    public AbstractActivityC0349b f3980a;

    /* renamed from: b, reason: collision with root package name */
    public C0368c f3981b;

    /* renamed from: c, reason: collision with root package name */
    public p f3982c;

    /* renamed from: d, reason: collision with root package name */
    public C0381e f3983d;

    /* renamed from: e, reason: collision with root package name */
    public C0553y f3984e;

    /* renamed from: f, reason: collision with root package name */
    public ViewTreeObserverOnPreDrawListenerC0351d f3985f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3986g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3987h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3989j;
    public Integer k;

    /* renamed from: l, reason: collision with root package name */
    public final C0350c f3990l = new C0350c(0, this);

    /* renamed from: i, reason: collision with root package name */
    public boolean f3988i = false;

    public C0353f(AbstractActivityC0349b abstractActivityC0349b) {
        this.f3980a = abstractActivityC0349b;
    }

    public final void a(C0371f c0371f) {
        String a4 = this.f3980a.a();
        if (a4 == null || a4.isEmpty()) {
            a4 = (String) ((C0447e) A2.t.O().f99g).f5206d.f1439c;
        }
        C0426a c0426a = new C0426a(a4, this.f3980a.d());
        String e4 = this.f3980a.e();
        if (e4 == null) {
            AbstractActivityC0349b abstractActivityC0349b = this.f3980a;
            abstractActivityC0349b.getClass();
            e4 = d(abstractActivityC0349b.getIntent());
            if (e4 == null) {
                e4 = "/";
            }
        }
        c0371f.f4139b = c0426a;
        c0371f.f4140c = e4;
        c0371f.f4141d = (List) this.f3980a.getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    public final void b() {
        if (!this.f3980a.h()) {
            AbstractActivityC0349b abstractActivityC0349b = this.f3980a;
            abstractActivityC0349b.getClass();
            Log.w("FlutterActivity", "FlutterActivity " + abstractActivityC0349b + " connection to the engine " + abstractActivityC0349b.f3973g.f3981b + " evicted by another attaching activity");
            C0353f c0353f = abstractActivityC0349b.f3973g;
            if (c0353f != null) {
                c0353f.e();
                abstractActivityC0349b.f3973g.f();
                return;
            }
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f3980a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    public final void c() {
        if (this.f3980a != null) {
        } else {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    public final String d(Intent intent) {
        boolean z;
        Uri data;
        AbstractActivityC0349b abstractActivityC0349b = this.f3980a;
        abstractActivityC0349b.getClass();
        try {
            Bundle f4 = abstractActivityC0349b.f();
            if (f4 != null && f4.containsKey("flutter_deeplinking_enabled")) {
                z = f4.getBoolean("flutter_deeplinking_enabled");
            } else {
                z = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            z = false;
        }
        if (z && (data = intent.getData()) != null) {
            return data.toString();
        }
        return null;
    }

    public final void e() {
        c();
        if (this.f3985f != null) {
            this.f3982c.getViewTreeObserver().removeOnPreDrawListener(this.f3985f);
            this.f3985f = null;
        }
        p pVar = this.f3982c;
        if (pVar != null) {
            pVar.a();
            p pVar2 = this.f3982c;
            pVar2.f4029m.remove(this.f3990l);
        }
    }

    public final void f() {
        if (!this.f3989j) {
            return;
        }
        c();
        this.f3980a.getClass();
        this.f3980a.getClass();
        AbstractActivityC0349b abstractActivityC0349b = this.f3980a;
        abstractActivityC0349b.getClass();
        if (abstractActivityC0349b.isChangingConfigurations()) {
            C0369d c0369d = this.f3981b.f4109d;
            if (c0369d.f()) {
                E2.a.b("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
                try {
                    c0369d.f4135g = true;
                    Iterator it = c0369d.f4132d.values().iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0586a) it.next()).onDetachedFromActivityForConfigChanges();
                    }
                    c0369d.d();
                    Trace.endSection();
                } finally {
                }
            } else {
                Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            }
        } else {
            this.f3981b.f4109d.c();
        }
        C0381e c0381e = this.f3983d;
        if (c0381e != null) {
            ((io.flutter.plugin.platform.s) c0381e.f4327c).f4391h = null;
            this.f3983d = null;
        }
        C0553y c0553y = this.f3984e;
        if (c0553y != null) {
            ((n.p) c0553y.f5750c).f5322g = null;
            c0553y.f5749b = null;
            this.f3984e = null;
        }
        this.f3980a.getClass();
        C0368c c0368c = this.f3981b;
        if (c0368c != null) {
            C0623a c0623a = c0368c.f4112g;
            c0623a.a(1, c0623a.f6046c);
        }
        if (this.f3980a.h()) {
            C0368c c0368c2 = this.f3981b;
            FlutterJNI flutterJNI = c0368c2.f4106a;
            Iterator it2 = c0368c2.f4126v.iterator();
            while (it2.hasNext()) {
                ((InterfaceC0367b) it2.next()).a();
            }
            C0369d c0369d2 = c0368c2.f4109d;
            c0369d2.e();
            HashMap hashMap = c0369d2.f4129a;
            Iterator it3 = new HashSet(hashMap.keySet()).iterator();
            while (it3.hasNext()) {
                Class cls = (Class) it3.next();
                o2.c cVar = (o2.c) hashMap.get(cls);
                if (cVar != null) {
                    E2.a.b("FlutterEngineConnectionRegistry#remove ".concat(cls.getSimpleName()));
                    try {
                        if (cVar instanceof InterfaceC0586a) {
                            if (c0369d2.f()) {
                                ((InterfaceC0586a) cVar).onDetachedFromActivity();
                            }
                            c0369d2.f4132d.remove(cls);
                        }
                        cVar.onDetachedFromEngine(c0369d2.f4131c);
                        hashMap.remove(cls);
                        Trace.endSection();
                    } finally {
                    }
                }
            }
            hashMap.clear();
            io.flutter.plugin.platform.r rVar = c0368c2.f4123s;
            SparseArray sparseArray = rVar.f4379q;
            while (sparseArray.size() > 0) {
                rVar.f4368B.s(sparseArray.keyAt(0));
            }
            io.flutter.plugin.platform.q qVar = c0368c2.f4124t;
            SparseArray sparseArray2 = qVar.f4358n;
            while (sparseArray2.size() > 0) {
                qVar.f4365u.s(sparseArray2.keyAt(0));
            }
            ((FlutterJNI) c0368c2.f4108c.f5058h).setPlatformMessageHandler(null);
            flutterJNI.removeEngineLifecycleListener(c0368c2.f4128x);
            flutterJNI.setDeferredComponentManager(null);
            flutterJNI.detachFromNativeAndReleaseResources();
            A2.t.O().getClass();
            C0368c.z.remove(Long.valueOf(c0368c2.f4127w));
            if (this.f3980a.c() != null) {
                if (C0373h.f4146c == null) {
                    C0373h.f4146c = new C0373h(1);
                }
                C0373h c0373h = C0373h.f4146c;
                c0373h.f4147a.remove(this.f3980a.c());
            }
            this.f3981b = null;
        }
        this.f3989j = false;
    }
}
