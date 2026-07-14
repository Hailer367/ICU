package d2;

import A2.t;
import A2.x;
import D2.J;
import D2.U;
import I0.q;
import T2.h;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import n.p;
import p1.AbstractC0581j;
import p1.C0585n;
import p2.InterfaceC0586a;
import q1.AbstractC0602b;
import q1.C0601a;
import q1.C0603c;
import q1.C0605e;
import q1.l;
import r1.InterfaceC0622c;
import r2.i;
import s2.C0635g;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0634f;
import s2.InterfaceC0636h;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import s2.InterfaceC0646r;

/* renamed from: d2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0265f implements o2.c, InterfaceC0642n, InterfaceC0646r, Application.ActivityLifecycleCallbacks, InterfaceC0586a, InterfaceC0636h {

    /* renamed from: f, reason: collision with root package name */
    public C0644p f3484f;

    /* renamed from: g, reason: collision with root package name */
    public t f3485g;

    /* renamed from: h, reason: collision with root package name */
    public C0261b f3486h;

    /* renamed from: i, reason: collision with root package name */
    public C0635g f3487i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0260a f3488j;
    public i k;

    /* renamed from: l, reason: collision with root package name */
    public Integer f3489l;

    /* renamed from: m, reason: collision with root package name */
    public C0601a f3490m;

    /* renamed from: n, reason: collision with root package name */
    public C0605e f3491n;

    public final void a(i iVar, S2.a aVar) {
        Activity activity;
        if (this.f3490m != null) {
            InterfaceC0260a interfaceC0260a = this.f3488j;
            if (interfaceC0260a != null) {
                activity = interfaceC0260a.p();
            } else {
                activity = null;
            }
            if (activity != null) {
                if (this.f3491n != null) {
                    aVar.a();
                    return;
                } else {
                    iVar.error("REQUIRE_CHECK_FOR_UPDATE", "Call checkForUpdate first!", null);
                    throw new IllegalArgumentException("kotlin.Unit");
                }
            }
            iVar.error("REQUIRE_FOREGROUND_ACTIVITY", "in_app_update requires a foreground activity", null);
            throw new IllegalArgumentException("kotlin.Unit");
        }
        iVar.error("REQUIRE_CHECK_FOR_UPDATE", "Call checkForUpdate first!", null);
        throw new IllegalArgumentException("kotlin.Unit");
    }

    @Override // s2.InterfaceC0636h
    public final void c(C0635g c0635g) {
        this.f3487i = c0635g;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        h.e(activity, "activity");
    }

    @Override // s2.InterfaceC0646r
    public final boolean onActivityResult(int i4, int i5, Intent intent) {
        i iVar;
        if (i4 == 1276) {
            Integer num = this.f3489l;
            if (num != null && num.intValue() == 1) {
                if (i5 != -1) {
                    if (i5 != 0) {
                        if (i5 == 1 && (iVar = this.k) != null) {
                            iVar.error("IN_APP_UPDATE_FAILED", "Some other error prevented either the user from providing consent or the update to proceed.", null);
                        }
                    } else {
                        i iVar2 = this.k;
                        if (iVar2 != null) {
                            iVar2.error("USER_DENIED_UPDATE", String.valueOf(i5), null);
                        }
                    }
                } else {
                    i iVar3 = this.k;
                    if (iVar3 != null) {
                        iVar3.success(null);
                    }
                }
                this.k = null;
                return true;
            }
            Integer num2 = this.f3489l;
            if (num2 != null && num2.intValue() == 0) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        return true;
                    }
                    i iVar4 = this.k;
                    if (iVar4 != null) {
                        iVar4.error("IN_APP_UPDATE_FAILED", String.valueOf(i5), null);
                    }
                    this.k = null;
                    return true;
                }
                i iVar5 = this.k;
                if (iVar5 != null) {
                    iVar5.error("USER_DENIED_UPDATE", String.valueOf(i5), null);
                }
                this.k = null;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        C0585n a4;
        h.e(activity, "activity");
        C0605e c0605e = this.f3491n;
        if (c0605e != null && (a4 = c0605e.a()) != null) {
            a4.b(AbstractC0581j.f5822a, new J(16, new U(2, this, activity)));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        h.e(activity, "activity");
        h.e(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        h.e(activity, "activity");
    }

    @Override // p2.InterfaceC0586a
    public final void onAttachedToActivity(p2.b bVar) {
        h.e(bVar, "activityPluginBinding");
        this.f3488j = new R1.c(17, bVar);
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        h.e(bVar, "flutterPluginBinding");
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        C0644p c0644p = new C0644p(interfaceC0634f, "de.ffuf.in_app_update/methods");
        this.f3484f = c0644p;
        c0644p.b(this);
        t tVar = new t(interfaceC0634f, "de.ffuf.in_app_update/stateEvents");
        this.f3485g = tVar;
        tVar.X(this);
        C0261b c0261b = new C0261b(this, 0);
        this.f3486h = c0261b;
        C0605e c0605e = this.f3491n;
        if (c0605e != null) {
            c0605e.b(c0261b);
        }
    }

    @Override // s2.InterfaceC0636h
    public final void onCancel() {
        this.f3487i = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivity() {
        this.f3488j = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivityForConfigChanges() {
        this.f3488j = null;
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        h.e(bVar, "binding");
        C0644p c0644p = this.f3484f;
        if (c0644p != null) {
            c0644p.b(null);
            t tVar = this.f3485g;
            if (tVar != null) {
                tVar.X(null);
                C0605e c0605e = this.f3491n;
                if (c0605e != null) {
                    C0261b c0261b = this.f3486h;
                    if (c0261b != null) {
                        synchronized (c0605e) {
                            C0603c c0603c = c0605e.f5952b;
                            synchronized (c0603c) {
                                c0603c.f5944a.o("unregisterListener", new Object[0]);
                                c0603c.f5947d.remove(c0261b);
                                c0603c.a();
                            }
                        }
                        return;
                    }
                    h.g("installStateUpdatedListener");
                    throw null;
                }
                return;
            }
            h.g("event");
            throw null;
        }
        h.g("channel");
        throw null;
    }

    @Override // s2.InterfaceC0642n
    public final void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        Activity activity;
        p pVar;
        Application application;
        h.e(c0641m, "call");
        String str = c0641m.f6155a;
        if (str != null) {
            switch (str.hashCode()) {
                case -1873373639:
                    if (str.equals("performImmediateUpdate")) {
                        final i iVar = (i) interfaceC0643o;
                        final int i4 = 1;
                        a(iVar, new S2.a(this) { // from class: d2.d

                            /* renamed from: g, reason: collision with root package name */
                            public final /* synthetic */ C0265f f3481g;

                            {
                                this.f3481g = this;
                            }

                            @Override // S2.a
                            public final Object a() {
                                switch (i4) {
                                    case 0:
                                        C0265f c0265f = this.f3481g;
                                        c0265f.f3489l = 0;
                                        c0265f.k = iVar;
                                        if (c0265f.f3491n != null) {
                                            C0601a c0601a = c0265f.f3490m;
                                            h.b(c0601a);
                                            InterfaceC0260a interfaceC0260a = c0265f.f3488j;
                                            h.b(interfaceC0260a);
                                            C0605e.c(c0601a, interfaceC0260a.p(), l.a(0));
                                        }
                                        C0605e c0605e = c0265f.f3491n;
                                        if (c0605e != null) {
                                            c0605e.b(new C0261b(c0265f, 1));
                                        }
                                        return H2.i.f681a;
                                    default:
                                        C0265f c0265f2 = this.f3481g;
                                        c0265f2.f3489l = 1;
                                        c0265f2.k = iVar;
                                        if (c0265f2.f3491n != null) {
                                            C0601a c0601a2 = c0265f2.f3490m;
                                            h.b(c0601a2);
                                            InterfaceC0260a interfaceC0260a2 = c0265f2.f3488j;
                                            h.b(interfaceC0260a2);
                                            C0605e.c(c0601a2, interfaceC0260a2.p(), l.a(1));
                                        }
                                        return H2.i.f681a;
                                }
                            }
                        });
                        return;
                    }
                    break;
                case -1541164682:
                    if (str.equals("startFlexibleUpdate")) {
                        final i iVar2 = (i) interfaceC0643o;
                        final int i5 = 0;
                        a(iVar2, new S2.a(this) { // from class: d2.d

                            /* renamed from: g, reason: collision with root package name */
                            public final /* synthetic */ C0265f f3481g;

                            {
                                this.f3481g = this;
                            }

                            @Override // S2.a
                            public final Object a() {
                                switch (i5) {
                                    case 0:
                                        C0265f c0265f = this.f3481g;
                                        c0265f.f3489l = 0;
                                        c0265f.k = iVar2;
                                        if (c0265f.f3491n != null) {
                                            C0601a c0601a = c0265f.f3490m;
                                            h.b(c0601a);
                                            InterfaceC0260a interfaceC0260a = c0265f.f3488j;
                                            h.b(interfaceC0260a);
                                            C0605e.c(c0601a, interfaceC0260a.p(), l.a(0));
                                        }
                                        C0605e c0605e = c0265f.f3491n;
                                        if (c0605e != null) {
                                            c0605e.b(new C0261b(c0265f, 1));
                                        }
                                        return H2.i.f681a;
                                    default:
                                        C0265f c0265f2 = this.f3481g;
                                        c0265f2.f3489l = 1;
                                        c0265f2.k = iVar2;
                                        if (c0265f2.f3491n != null) {
                                            C0601a c0601a2 = c0265f2.f3490m;
                                            h.b(c0601a2);
                                            InterfaceC0260a interfaceC0260a2 = c0265f2.f3488j;
                                            h.b(interfaceC0260a2);
                                            C0605e.c(c0601a2, interfaceC0260a2.p(), l.a(1));
                                        }
                                        return H2.i.f681a;
                                }
                            }
                        });
                        return;
                    }
                    break;
                case -1317168438:
                    if (str.equals("checkForUpdate")) {
                        InterfaceC0260a interfaceC0260a = this.f3488j;
                        if (interfaceC0260a != null) {
                            activity = interfaceC0260a.p();
                        } else {
                            activity = null;
                        }
                        if (activity != null) {
                            InterfaceC0260a interfaceC0260a2 = this.f3488j;
                            if (interfaceC0260a2 != null) {
                                interfaceC0260a2.g(this);
                            }
                            InterfaceC0260a interfaceC0260a3 = this.f3488j;
                            if (interfaceC0260a3 != null && (application = interfaceC0260a3.p().getApplication()) != null) {
                                application.registerActivityLifecycleCallbacks(this);
                            }
                            InterfaceC0260a interfaceC0260a4 = this.f3488j;
                            h.b(interfaceC0260a4);
                            Context p3 = interfaceC0260a4.p();
                            synchronized (AbstractC0602b.class) {
                                try {
                                    if (AbstractC0602b.f5943a == null) {
                                        Context applicationContext = p3.getApplicationContext();
                                        if (applicationContext != null) {
                                            p3 = applicationContext;
                                        }
                                        AbstractC0602b.f5943a = new p(new x(p3, false));
                                    }
                                    pVar = AbstractC0602b.f5943a;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            C0605e c0605e = (C0605e) ((InterfaceC0622c) pVar.f5322g).n();
                            this.f3491n = c0605e;
                            h.b(c0605e);
                            C0585n a4 = c0605e.a();
                            h.d(a4, "getAppUpdateInfo(...)");
                            i iVar3 = (i) interfaceC0643o;
                            J j4 = new J(17, new U(3, this, iVar3));
                            q qVar = AbstractC0581j.f5822a;
                            a4.b(qVar, j4);
                            a4.a(qVar, new C0264e(iVar3));
                            return;
                        }
                        ((i) interfaceC0643o).error("REQUIRE_FOREGROUND_ACTIVITY", "in_app_update requires a foreground activity", null);
                        throw new IllegalArgumentException("kotlin.Unit");
                    }
                    break;
                case -193504755:
                    if (str.equals("completeFlexibleUpdate")) {
                        a((i) interfaceC0643o, new C0262c(0, this));
                        return;
                    }
                    break;
            }
        }
        ((i) interfaceC0643o).notImplemented();
    }

    @Override // p2.InterfaceC0586a
    public final void onReattachedToActivityForConfigChanges(p2.b bVar) {
        h.e(bVar, "activityPluginBinding");
        this.f3488j = new A2.q(19, bVar);
    }
}
