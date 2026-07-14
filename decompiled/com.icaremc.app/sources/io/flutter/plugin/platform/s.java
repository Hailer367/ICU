package io.flutter.plugin.platform;

import I.T;
import I.Y;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import d2.C0264e;
import j.LayoutInflaterFactory2C0393A;
import j.O;
import j2.C0427b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import m.AbstractC0438b;
import m.InterfaceC0437a;
import org.json.JSONArray;
import org.json.JSONObject;
import p1.AbstractC0579h;
import p1.C0580i;
import p1.InterfaceC0574c;
import r1.InterfaceC0622c;
import s2.C0639k;
import s2.C0641m;
import s2.C0644p;
import s2.C0651w;
import s2.InterfaceC0630b;
import s2.InterfaceC0631c;
import s2.InterfaceC0632d;
import s2.InterfaceC0640l;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import s2.InterfaceC0645q;
import u2.InterfaceC0668a;
import v0.C0679b;
import v0.InterfaceC0685h;

/* loaded from: classes.dex */
public final class s implements l, r2.h, InterfaceC0437a, InterfaceC0622c, InterfaceC0574c, InterfaceC0642n, InterfaceC0631c, InterfaceC0632d, InterfaceC0685h {

    /* renamed from: i, reason: collision with root package name */
    public static h2.z f4388i;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4389f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4390g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4391h;

    public /* synthetic */ s(int i4, Object obj, Object obj2) {
        this.f4389f = i4;
        this.f4391h = obj;
        this.f4390g = obj2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:47:0x006c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0080 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int v(io.flutter.plugin.platform.s r11, org.json.JSONArray r12) {
        /*
            r11 = 0
            r0 = r11
            r1 = r0
            r2 = r1
        L4:
            int r3 = r12.length()
            r4 = 4
            r5 = 2
            r6 = 1
            if (r0 >= r3) goto L68
            java.lang.String r3 = r12.getString(r0)
            int[] r4 = R.i.c(r4)
            int r7 = r4.length
            r8 = r11
        L17:
            if (r8 >= r7) goto L5c
            r9 = r4[r8]
            r10 = 1
            if (r9 == r10) goto L32
            r10 = 2
            if (r9 == r10) goto L2f
            r10 = 3
            if (r9 == r10) goto L2c
            r10 = 4
            if (r9 != r10) goto L2a
            java.lang.String r10 = "DeviceOrientation.landscapeRight"
            goto L34
        L2a:
            r11 = 0
            throw r11
        L2c:
            java.lang.String r10 = "DeviceOrientation.landscapeLeft"
            goto L34
        L2f:
            java.lang.String r10 = "DeviceOrientation.portraitDown"
            goto L34
        L32:
            java.lang.String r10 = "DeviceOrientation.portraitUp"
        L34:
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L59
            int r3 = R.i.b(r9)
            if (r3 == 0) goto L51
            if (r3 == r6) goto L4e
            if (r3 == r5) goto L4b
            r4 = 3
            if (r3 == r4) goto L48
            goto L53
        L48:
            r1 = r1 | 8
            goto L53
        L4b:
            r1 = r1 | 2
            goto L53
        L4e:
            r1 = r1 | 4
            goto L53
        L51:
            r1 = r1 | 1
        L53:
            if (r2 != 0) goto L56
            r2 = r1
        L56:
            int r0 = r0 + 1
            goto L4
        L59:
            int r8 = r8 + 1
            goto L17
        L5c:
            java.lang.NoSuchFieldException r11 = new java.lang.NoSuchFieldException
            java.lang.String r12 = "No such DeviceOrientation: "
            java.lang.String r12 = r2.k.d(r12, r3)
            r11.<init>(r12)
            throw r11
        L68:
            if (r1 == 0) goto L85
            r12 = 8
            switch(r1) {
                case 2: goto L84;
                case 3: goto L7a;
                case 4: goto L82;
                case 5: goto L77;
                case 6: goto L7a;
                case 7: goto L7a;
                case 8: goto L81;
                case 9: goto L7a;
                case 10: goto L74;
                case 11: goto L73;
                case 12: goto L7a;
                case 13: goto L7a;
                case 14: goto L7a;
                case 15: goto L70;
                default: goto L6f;
            }
        L6f:
            goto L80
        L70:
            r11 = 13
            return r11
        L73:
            return r5
        L74:
            r11 = 11
            return r11
        L77:
            r11 = 12
            return r11
        L7a:
            if (r2 == r5) goto L84
            if (r2 == r4) goto L82
            if (r2 == r12) goto L81
        L80:
            return r6
        L81:
            return r12
        L82:
            r11 = 9
        L84:
            return r11
        L85:
            r11 = -1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.s.v(io.flutter.plugin.platform.s, org.json.JSONArray):int");
    }

    public static ArrayList w(s sVar, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            String string = jSONArray.getString(i4);
            for (r2.d dVar : r2.d.values()) {
                if (dVar.f6060f.equals(string)) {
                    int ordinal = dVar.ordinal();
                    if (ordinal != 0) {
                        if (ordinal == 1) {
                            arrayList.add(r2.d.BOTTOM_OVERLAYS);
                        }
                    } else {
                        arrayList.add(r2.d.TOP_OVERLAYS);
                    }
                }
            }
            throw new NoSuchFieldException(r2.k.d("No such SystemUiOverlay: ", string));
        }
        return arrayList;
    }

    public static int x(s sVar, String str) {
        String str2;
        for (int i4 : R.i.c(4)) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            str2 = "SystemUiMode.edgeToEdge";
                        } else {
                            throw null;
                        }
                    } else {
                        str2 = "SystemUiMode.immersiveSticky";
                    }
                } else {
                    str2 = "SystemUiMode.immersive";
                }
            } else {
                str2 = "SystemUiMode.leanBack";
            }
            if (str2.equals(str)) {
                int b4 = R.i.b(i4);
                if (b4 == 0) {
                    return 1;
                }
                if (b4 == 1) {
                    return 2;
                }
                if (b4 != 2) {
                    return 4;
                }
                return 3;
            }
        }
        throw new NoSuchFieldException(r2.k.d("No such SystemUiMode: ", str));
    }

    public static r2.c y(s sVar, JSONObject jSONObject) {
        Integer num;
        int i4;
        Boolean bool;
        Integer num2;
        Integer num3;
        Boolean bool2 = null;
        if (!jSONObject.isNull("statusBarColor")) {
            num = Integer.valueOf(jSONObject.getInt("statusBarColor"));
        } else {
            num = null;
        }
        int i5 = 0;
        if (!jSONObject.isNull("statusBarIconBrightness")) {
            i4 = A2.i.b(jSONObject.getString("statusBarIconBrightness"));
        } else {
            i4 = 0;
        }
        if (!jSONObject.isNull("systemStatusBarContrastEnforced")) {
            bool = Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced"));
        } else {
            bool = null;
        }
        if (!jSONObject.isNull("systemNavigationBarColor")) {
            num2 = Integer.valueOf(jSONObject.getInt("systemNavigationBarColor"));
        } else {
            num2 = null;
        }
        if (!jSONObject.isNull("systemNavigationBarIconBrightness")) {
            i5 = A2.i.b(jSONObject.getString("systemNavigationBarIconBrightness"));
        }
        int i6 = i5;
        if (!jSONObject.isNull("systemNavigationBarDividerColor")) {
            num3 = Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor"));
        } else {
            num3 = null;
        }
        if (!jSONObject.isNull("systemNavigationBarContrastEnforced")) {
            bool2 = Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced"));
        }
        return new r2.c(num, i4, bool, num2, i6, num3, bool2);
    }

    public static HashMap z(String str, int i4, int i5, int i6, int i7) {
        HashMap hashMap = new HashMap();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i4));
        hashMap.put("selectionExtent", Integer.valueOf(i5));
        hashMap.put("composingBase", Integer.valueOf(i6));
        hashMap.put("composingExtent", Integer.valueOf(i7));
        return hashMap;
    }

    @Override // r2.h
    public void a(r2.f fVar) {
        q qVar = (q) this.f4391h;
        if (qVar.l(fVar.f6070a) != null) {
            qVar.f4365u.a(fVar);
        } else {
            ((r) this.f4390g).f4368B.a(fVar);
        }
    }

    @Override // m.InterfaceC0437a
    public boolean b(AbstractC0438b abstractC0438b, Menu menu) {
        return ((InterfaceC0437a) this.f4390g).b(abstractC0438b, menu);
    }

    @Override // r2.h
    public void c(boolean z) {
        ((r) ((r) this.f4390g).f4368B.f4350g).f4385w = z;
    }

    @Override // io.flutter.plugin.platform.l
    public void d(io.flutter.view.j jVar) {
        ((r) this.f4390g).f4376n.f4320a = jVar;
        ((q) this.f4391h).f4357m.f4320a = jVar;
    }

    @Override // r2.h
    public void e(int i4, double d4, double d5) {
        if (((q) this.f4391h).l(i4) != null) {
            return;
        }
        ((r) this.f4390g).f4368B.e(i4, d4, d5);
    }

    @Override // r2.h
    public void f(int i4, int i5) {
        q qVar = (q) this.f4391h;
        if (qVar.l(i4) != null) {
            qVar.f4365u.f(i4, i5);
        } else {
            ((r) this.f4390g).f4368B.f(i4, i5);
        }
    }

    @Override // io.flutter.plugin.platform.l
    public boolean g(int i4) {
        q qVar = (q) this.f4391h;
        if (qVar.l(i4) != null) {
            qVar.getClass();
            return false;
        }
        return ((r) this.f4390g).g(i4);
    }

    @Override // s2.InterfaceC0632d
    public void h(ByteBuffer byteBuffer, j2.g gVar) {
        switch (this.f4389f) {
            case 13:
                P1.y yVar = (P1.y) this.f4391h;
                try {
                    ((InterfaceC0630b) this.f4390g).f(((InterfaceC0640l) yVar.f1471h).b(byteBuffer), new s(12, this, gVar));
                    return;
                } catch (RuntimeException e4) {
                    Log.e("BasicMessageChannel#" + ((String) yVar.f1469f), "Failed to handle message", e4);
                    gVar.a(null);
                    return;
                }
            default:
                C0644p c0644p = (C0644p) this.f4391h;
                InterfaceC0645q interfaceC0645q = c0644p.f6159c;
                try {
                    ((InterfaceC0642n) this.f4390g).onMethodCall(interfaceC0645q.d(byteBuffer), new r2.i(1, this, gVar));
                    return;
                } catch (RuntimeException e5) {
                    Log.e("MethodChannel#" + c0644p.f6158b, "Failed to handle method call", e5);
                    gVar.a(interfaceC0645q.b(e5.getMessage(), Log.getStackTraceString(e5)));
                    return;
                }
        }
    }

    @Override // r2.h
    public void i(r2.e eVar) {
        ((r) this.f4390g).f4368B.i(eVar);
    }

    @Override // r2.h
    public long j(r2.e eVar) {
        return ((r) this.f4390g).f4368B.j(eVar);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [j.l, java.lang.Object] */
    @Override // m.InterfaceC0437a
    public void k(AbstractC0438b abstractC0438b) {
        ((InterfaceC0437a) this.f4390g).k(abstractC0438b);
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) this.f4391h;
        if (layoutInflaterFactory2C0393A.f4827B != null) {
            layoutInflaterFactory2C0393A.f4865q.getDecorView().removeCallbacks(layoutInflaterFactory2C0393A.f4828C);
        }
        if (layoutInflaterFactory2C0393A.f4826A != null) {
            Y y3 = layoutInflaterFactory2C0393A.f4829D;
            if (y3 != null) {
                y3.b();
            }
            Y a4 = T.a(layoutInflaterFactory2C0393A.f4826A);
            a4.a(0.0f);
            layoutInflaterFactory2C0393A.f4829D = a4;
            a4.d(new j.s(2, this));
        }
        layoutInflaterFactory2C0393A.f4867s.onSupportActionModeFinished(layoutInflaterFactory2C0393A.z);
        layoutInflaterFactory2C0393A.z = null;
        ViewGroup viewGroup = layoutInflaterFactory2C0393A.f4831F;
        WeakHashMap weakHashMap = T.f702a;
        viewGroup.requestApplyInsets();
        layoutInflaterFactory2C0393A.J();
    }

    @Override // io.flutter.plugin.platform.l
    public View l(int i4) {
        q qVar = (q) this.f4391h;
        if (qVar.l(i4) != null) {
            return qVar.l(i4);
        }
        return ((r) this.f4390g).l(i4);
    }

    @Override // r2.h
    public void m(int i4) {
        q qVar = (q) this.f4391h;
        if (qVar.l(i4) != null) {
            qVar.f4365u.m(i4);
        } else {
            ((r) this.f4390g).f4368B.m(i4);
        }
    }

    @Override // r1.InterfaceC0622c
    public Object n() {
        return new q1.j(((A2.x) ((n.p) this.f4390g).f5322g).f117a, (q1.k) ((InterfaceC0622c) this.f4391h).n());
    }

    @Override // io.flutter.plugin.platform.l
    public void o() {
        ((r) this.f4390g).o();
        ((q) this.f4391h).o();
    }

    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        O o3 = (O) this.f4391h;
        if (((A2.t) o3.f4911g) == null) {
            ((r2.i) interfaceC0643o).success((Map) this.f4390g);
            return;
        }
        String str = c0641m.f6155a;
        str.getClass();
        if (!str.equals("getKeyboardState")) {
            ((r2.i) interfaceC0643o).notImplemented();
            return;
        }
        try {
            this.f4390g = Collections.unmodifiableMap(((h2.u) ((h2.x[]) ((A2.t) o3.f4911g).f99g)[0]).f4056g);
        } catch (IllegalStateException e4) {
            ((r2.i) interfaceC0643o).error("error", e4.getMessage(), null);
        }
        ((r2.i) interfaceC0643o).success((Map) this.f4390g);
    }

    @Override // r2.h
    public void p(r2.g gVar, C0264e c0264e) {
        if (((q) this.f4391h).l(gVar.f6085a) != null) {
            return;
        }
        ((r) this.f4390g).f4368B.p(gVar, c0264e);
    }

    @Override // p1.InterfaceC0574c
    public void q(AbstractC0579h abstractC0579h) {
        r1.o oVar = (r1.o) this.f4390g;
        C0580i c0580i = (C0580i) this.f4391h;
        synchronized (oVar.f6037f) {
            oVar.f6036e.remove(c0580i);
        }
    }

    @Override // m.InterfaceC0437a
    public boolean r(AbstractC0438b abstractC0438b, Menu menu) {
        ViewGroup viewGroup = ((LayoutInflaterFactory2C0393A) this.f4391h).f4831F;
        WeakHashMap weakHashMap = T.f702a;
        viewGroup.requestApplyInsets();
        return ((InterfaceC0437a) this.f4390g).r(abstractC0438b, menu);
    }

    @Override // r2.h
    public void s(int i4) {
        q qVar = (q) this.f4391h;
        if (qVar.l(i4) != null) {
            qVar.f4365u.s(i4);
        } else {
            ((r) this.f4390g).f4368B.s(i4);
        }
    }

    @Override // s2.InterfaceC0631c
    public void t(Object obj) {
        switch (this.f4389f) {
            case 10:
                A2.t tVar = (A2.t) this.f4391h;
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) tVar.f99g;
                r2.j jVar = (r2.j) this.f4390g;
                concurrentLinkedQueue.remove(jVar);
                if (!((ConcurrentLinkedQueue) tVar.f99g).isEmpty()) {
                    Log.e("SettingsChannel", "The queue becomes empty after removing config generation " + jVar.f6092a);
                    return;
                }
                return;
            default:
                ((j2.g) this.f4390g).a(((InterfaceC0640l) ((P1.y) ((s) this.f4391h).f4391h).f1471h).a(obj));
                return;
        }
    }

    @Override // m.InterfaceC0437a
    public boolean u(AbstractC0438b abstractC0438b, MenuItem menuItem) {
        return ((InterfaceC0437a) this.f4390g).u(abstractC0438b, menuItem);
    }

    public /* synthetic */ s(int i4, Object obj, Object obj2, boolean z) {
        this.f4389f = i4;
        this.f4390g = obj;
        this.f4391h = obj2;
    }

    public s(InterfaceC0668a interfaceC0668a, n.p pVar) {
        this.f4389f = 17;
        this.f4390g = interfaceC0668a;
        this.f4391h = pVar;
        pVar.f5322g = new n.p(19, this);
    }

    public s(O o3) {
        this.f4389f = 4;
        this.f4391h = o3;
        this.f4390g = new HashMap();
    }

    public s(int i4) {
        this.f4389f = i4;
        switch (i4) {
            case 15:
                this.f4390g = new ReentrantLock();
                this.f4391h = new LinkedHashMap();
                return;
            default:
                return;
        }
    }

    public s(C0679b c0679b) {
        this.f4389f = 16;
        s sVar = new s(15);
        this.f4390g = c0679b;
        this.f4391h = sVar;
    }

    public s(C0427b c0427b, int i4) {
        this.f4389f = i4;
        switch (i4) {
            case 6:
                n.p pVar = new n.p(11, this);
                C0644p c0644p = new C0644p(c0427b, "flutter/platform", C0639k.f6154a);
                this.f4390g = c0644p;
                c0644p.b(pVar);
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                n.p pVar2 = new n.p(12, this);
                C0644p c0644p2 = new C0644p(c0427b, "flutter/platform_views_2", C0651w.f6163a);
                this.f4390g = c0644p2;
                c0644p2.b(pVar2);
                return;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                O o3 = new O(12, this);
                C0644p c0644p3 = new C0644p(c0427b, "flutter/platform_views", C0651w.f6163a);
                this.f4390g = c0644p3;
                c0644p3.b(o3);
                return;
            case 9:
            case 10:
            default:
                n.p pVar3 = new n.p(9, this);
                C0644p c0644p4 = new C0644p(c0427b, "flutter/localization", C0639k.f6154a);
                this.f4390g = c0644p4;
                c0644p4.b(pVar3);
                return;
            case 11:
                n.p pVar4 = new n.p(17, this);
                C0644p c0644p5 = new C0644p(c0427b, "flutter/textinput", C0639k.f6154a);
                this.f4390g = c0644p5;
                c0644p5.b(pVar4);
                return;
        }
    }

    public s(C0427b c0427b, PackageManager packageManager) {
        this.f4389f = 9;
        O o3 = new O(13, this);
        this.f4390g = packageManager;
        new C0644p(c0427b, "flutter/processtext", C0651w.f6163a).b(o3);
    }
}
