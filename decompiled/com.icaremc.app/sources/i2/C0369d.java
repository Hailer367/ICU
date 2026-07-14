package i2;

import android.content.Context;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.lifecycle.C0214v;
import h2.AbstractActivityC0349b;
import h2.C0353f;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.plugin.platform.q;
import io.flutter.plugin.platform.r;
import io.flutter.plugin.platform.s;
import j2.C0427b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import m2.C0447e;
import o.B1;
import p2.InterfaceC0586a;

/* renamed from: i2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0369d {

    /* renamed from: b, reason: collision with root package name */
    public final C0368c f4130b;

    /* renamed from: c, reason: collision with root package name */
    public final o2.b f4131c;

    /* renamed from: e, reason: collision with root package name */
    public C0353f f4133e;

    /* renamed from: f, reason: collision with root package name */
    public B1 f4134f;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4129a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f4132d = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public boolean f4135g = false;

    public C0369d(Context context, C0368c c0368c, C0447e c0447e) {
        new HashMap();
        new HashMap();
        new HashMap();
        this.f4130b = c0368c;
        this.f4131c = new o2.b(context, c0368c, c0368c.f4108c, c0368c.f4123s.f4369f, new R1.c(26, c0447e));
    }

    public final void a(o2.c cVar) {
        HashMap hashMap = this.f4129a;
        E2.a.b("FlutterEngineConnectionRegistry#add ".concat(cVar.getClass().getSimpleName()));
        try {
            if (hashMap.containsKey(cVar.getClass())) {
                Log.w("FlutterEngineCxnRegstry", "Attempted to register plugin (" + cVar + ") but it was already registered with this FlutterEngine (" + this.f4130b + ").");
                Trace.endSection();
                return;
            }
            cVar.toString();
            hashMap.put(cVar.getClass(), cVar);
            cVar.onAttachedToEngine(this.f4131c);
            if (cVar instanceof InterfaceC0586a) {
                InterfaceC0586a interfaceC0586a = (InterfaceC0586a) cVar;
                this.f4132d.put(cVar.getClass(), interfaceC0586a);
                if (f()) {
                    interfaceC0586a.onAttachedToActivity(this.f4134f);
                }
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
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, o.B1] */
    public final void b(AbstractActivityC0349b abstractActivityC0349b, C0214v c0214v) {
        boolean z;
        ?? obj = new Object();
        obj.f5416h = new HashSet();
        obj.f5417i = new HashSet();
        obj.f5418j = new HashSet();
        obj.k = new HashSet();
        new HashSet();
        obj.f5419l = new HashSet();
        obj.f5414f = abstractActivityC0349b;
        obj.f5415g = new HiddenLifecycleReference(c0214v);
        this.f4134f = obj;
        if (abstractActivityC0349b.getIntent() != null) {
            z = abstractActivityC0349b.getIntent().getBooleanExtra("enable-software-rendering", false);
        } else {
            z = false;
        }
        C0368c c0368c = this.f4130b;
        c0368c.f4123s.f4367A = z;
        s sVar = c0368c.f4125u;
        io.flutter.embedding.engine.renderer.j jVar = c0368c.f4107b;
        C0427b c0427b = c0368c.f4108c;
        r rVar = (r) sVar.f4390g;
        if (rVar.f4371h == null) {
            rVar.f4371h = abstractActivityC0349b;
            rVar.k = jVar;
            rVar.f4375m = new s(c0427b, 8);
            q qVar = (q) sVar.f4391h;
            if (qVar.f4353h == null) {
                qVar.f4353h = abstractActivityC0349b;
                s sVar2 = new s(c0427b, 7);
                qVar.f4356l = sVar2;
                sVar2.f4391h = qVar.f4365u;
                rVar.f4375m.f4391h = sVar;
                for (InterfaceC0586a interfaceC0586a : this.f4132d.values()) {
                    if (this.f4135g) {
                        interfaceC0586a.onReattachedToActivityForConfigChanges(this.f4134f);
                    } else {
                        interfaceC0586a.onAttachedToActivity(this.f4134f);
                    }
                }
                this.f4135g = false;
                return;
            }
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    public final void c() {
        if (f()) {
            E2.a.b("FlutterEngineConnectionRegistry#detachFromActivity");
            try {
                Iterator it = this.f4132d.values().iterator();
                while (it.hasNext()) {
                    ((InterfaceC0586a) it.next()).onDetachedFromActivity();
                }
                d();
                Trace.endSection();
                return;
            } catch (Throwable th) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
    }

    public final void d() {
        C0368c c0368c = this.f4130b;
        r rVar = c0368c.f4123s;
        s sVar = rVar.f4375m;
        if (sVar != null) {
            sVar.f4391h = null;
        }
        rVar.c();
        rVar.f4375m = null;
        rVar.f4371h = null;
        rVar.k = null;
        q qVar = c0368c.f4124t;
        s sVar2 = qVar.f4356l;
        if (sVar2 != null) {
            sVar2.f4391h = null;
        }
        Surface surface = qVar.f4363s;
        if (surface != null) {
            surface.release();
            qVar.f4363s = null;
            qVar.f4364t = null;
        }
        qVar.f4356l = null;
        qVar.f4353h = null;
        this.f4133e = null;
        this.f4134f = null;
    }

    public final void e() {
        if (f()) {
            c();
        }
    }

    public final boolean f() {
        if (this.f4133e != null) {
            return true;
        }
        return false;
    }
}
