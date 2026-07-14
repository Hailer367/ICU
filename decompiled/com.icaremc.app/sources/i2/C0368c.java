package i2;

import A2.t;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.platform.q;
import io.flutter.plugin.platform.r;
import io.flutter.plugin.platform.s;
import j.O;
import j2.C0427b;
import java.util.HashMap;
import java.util.HashSet;
import m2.C0447e;
import n.p;
import o.C0541s;
import q1.AbstractC0602b;
import r2.C0623a;
import r2.l;
import s2.C0644p;
import s2.C0651w;
import t2.C0664a;
import v2.C0693b;

/* renamed from: i2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0368c implements E2.b {

    /* renamed from: y, reason: collision with root package name */
    public static long f4105y = 1;
    public static final HashMap z = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f4106a;

    /* renamed from: b, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.j f4107b;

    /* renamed from: c, reason: collision with root package name */
    public final C0427b f4108c;

    /* renamed from: d, reason: collision with root package name */
    public final C0369d f4109d;

    /* renamed from: e, reason: collision with root package name */
    public final C0664a f4110e;

    /* renamed from: f, reason: collision with root package name */
    public final t f4111f;

    /* renamed from: g, reason: collision with root package name */
    public final C0623a f4112g;

    /* renamed from: h, reason: collision with root package name */
    public final p f4113h;

    /* renamed from: i, reason: collision with root package name */
    public final O f4114i;

    /* renamed from: j, reason: collision with root package name */
    public final p f4115j;
    public final C0541s k;

    /* renamed from: l, reason: collision with root package name */
    public final s f4116l;

    /* renamed from: m, reason: collision with root package name */
    public final p f4117m;

    /* renamed from: n, reason: collision with root package name */
    public final p f4118n;

    /* renamed from: o, reason: collision with root package name */
    public final l f4119o;

    /* renamed from: p, reason: collision with root package name */
    public final p f4120p;

    /* renamed from: q, reason: collision with root package name */
    public final O f4121q;

    /* renamed from: r, reason: collision with root package name */
    public final s f4122r;

    /* renamed from: s, reason: collision with root package name */
    public final r f4123s;

    /* renamed from: t, reason: collision with root package name */
    public final q f4124t;

    /* renamed from: u, reason: collision with root package name */
    public final s f4125u;

    /* renamed from: v, reason: collision with root package name */
    public final HashSet f4126v;

    /* renamed from: w, reason: collision with root package name */
    public final long f4127w;

    /* renamed from: x, reason: collision with root package name */
    public final C0366a f4128x;

    public C0368c(Context context, String[] strArr) {
        this(context, null, new r(), strArr, true, false);
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [o.s, java.lang.Object] */
    public C0368c(Context context, FlutterJNI flutterJNI, r rVar, String[] strArr, boolean z3, boolean z4) {
        AssetManager assets;
        this.f4126v = new HashSet();
        this.f4128x = new C0366a(this);
        long j4 = f4105y;
        f4105y = 1 + j4;
        this.f4127w = j4;
        z.put(Long.valueOf(j4), this);
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        t O3 = t.O();
        if (flutterJNI == null) {
            Object obj = O3.f100h;
            flutterJNI = new FlutterJNI();
        }
        this.f4106a = flutterJNI;
        C0427b c0427b = new C0427b(flutterJNI, assets, this.f4127w);
        this.f4108c = c0427b;
        flutterJNI.setPlatformMessageHandler((j2.i) c0427b.f5060j);
        t.O().getClass();
        this.f4111f = new t(c0427b, flutterJNI);
        new C0644p(c0427b, "flutter/deferredcomponent", C0651w.f6163a).b(new O(8, new Object()));
        t.O().getClass();
        new HashMap();
        this.f4112g = new C0623a(c0427b);
        s sVar = new s(c0427b, 5);
        this.f4113h = new p(c0427b, 10);
        this.f4114i = new O(c0427b, 11);
        this.f4115j = new p(c0427b, 7);
        this.f4116l = new s(c0427b, 6);
        s sVar2 = new s(c0427b, context.getPackageManager());
        C0644p c0644p = new C0644p(c0427b, "flutter/restoration", C0651w.f6163a);
        ?? obj2 = new Object();
        obj2.f5695d = false;
        obj2.f5696e = false;
        p pVar = new p(13, (Object) obj2);
        obj2.f5692a = c0644p;
        obj2.f5694c = z4;
        c0644p.b(pVar);
        this.k = obj2;
        this.f4117m = new p(c0427b, 14);
        this.f4118n = new p(c0427b, 15);
        l lVar = new l(c0427b);
        this.f4119o = lVar;
        this.f4120p = new p(c0427b, 16);
        this.f4121q = new O(c0427b, 17);
        this.f4122r = new s(c0427b, 11);
        C0664a c0664a = new C0664a(context, sVar);
        this.f4110e = c0664a;
        C0447e c0447e = (C0447e) O3.f99g;
        if (!flutterJNI.isAttached()) {
            c0447e.d(context.getApplicationContext());
            c0447e.a(context, strArr);
        }
        q qVar = new q();
        qVar.f4351f = rVar.f4369f;
        qVar.f4355j = flutterJNI;
        rVar.f4373j = flutterJNI;
        flutterJNI.addEngineLifecycleListener(this.f4128x);
        flutterJNI.setPlatformViewsController(rVar);
        flutterJNI.setPlatformViewsController2(qVar);
        flutterJNI.setLocalizationPlugin(c0664a);
        O3.getClass();
        flutterJNI.setDeferredComponentManager(null);
        flutterJNI.setSettingsChannel(lVar);
        if (!flutterJNI.isAttached()) {
            flutterJNI.attachToNative();
            if (!flutterJNI.isAttached()) {
                throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
            }
        }
        this.f4107b = new io.flutter.embedding.engine.renderer.j(flutterJNI);
        this.f4123s = rVar;
        this.f4124t = qVar;
        s sVar3 = new s(0);
        sVar3.f4390g = rVar;
        sVar3.f4391h = qVar;
        this.f4125u = sVar3;
        C0369d c0369d = new C0369d(context.getApplicationContext(), this, c0447e);
        this.f4109d = c0369d;
        c0664a.b(context.getResources().getConfiguration());
        if (z3 && c0447e.f5206d.f1437a) {
            android.support.v4.media.session.a.t(this);
        }
        AbstractC0602b.f(context, this);
        c0369d.a(new C0693b(sVar2));
    }
}
