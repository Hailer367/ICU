package h2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import b3.AbstractC0226a;
import b3.AbstractC0245u;
import b3.EnumC0244t;
import b3.I;
import b3.N;
import b3.P;
import i2.C0368c;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.platform.InterfaceC0382f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import n2.C0460a;
import q1.AbstractC0602b;
import s2.C0644p;
import s2.InterfaceC0634f;
import t2.C0664a;
import u2.InterfaceC0668a;
import v0.C0679b;
import v0.C0680c;
import v0.C0684g;
import v0.C0686i;
import v0.C0687j;
import v0.InterfaceC0685h;

/* loaded from: classes.dex */
public final class p extends FrameLayout implements InterfaceC0668a, y {

    /* renamed from: A, reason: collision with root package name */
    public final A2.q f4015A;

    /* renamed from: B, reason: collision with root package name */
    public final M.a f4016B;

    /* renamed from: C, reason: collision with root package name */
    public final n f4017C;

    /* renamed from: D, reason: collision with root package name */
    public final C0350c f4018D;

    /* renamed from: E, reason: collision with root package name */
    public m f4019E;

    /* renamed from: F, reason: collision with root package name */
    public int f4020F;

    /* renamed from: G, reason: collision with root package name */
    public int f4021G;

    /* renamed from: H, reason: collision with root package name */
    public q f4022H;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f4023f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4024g;

    /* renamed from: h, reason: collision with root package name */
    public final C0356i f4025h;

    /* renamed from: i, reason: collision with root package name */
    public final k f4026i;

    /* renamed from: j, reason: collision with root package name */
    public C0354g f4027j;
    public View k;

    /* renamed from: l, reason: collision with root package name */
    public View f4028l;

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f4029m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4030n;

    /* renamed from: o, reason: collision with root package name */
    public C0368c f4031o;

    /* renamed from: p, reason: collision with root package name */
    public final HashSet f4032p;

    /* renamed from: q, reason: collision with root package name */
    public io.flutter.plugin.platform.s f4033q;

    /* renamed from: r, reason: collision with root package name */
    public io.flutter.plugin.editing.j f4034r;

    /* renamed from: s, reason: collision with root package name */
    public io.flutter.plugin.editing.g f4035s;

    /* renamed from: t, reason: collision with root package name */
    public C0664a f4036t;

    /* renamed from: u, reason: collision with root package name */
    public A2.t f4037u;

    /* renamed from: v, reason: collision with root package name */
    public C0348a f4038v;

    /* renamed from: w, reason: collision with root package name */
    public io.flutter.view.j f4039w;

    /* renamed from: x, reason: collision with root package name */
    public TextServicesManager f4040x;

    /* renamed from: y, reason: collision with root package name */
    public R1.c f4041y;
    public final io.flutter.embedding.engine.renderer.i z;

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object, h2.q] */
    public p(AbstractActivityC0349b abstractActivityC0349b, C0356i c0356i) {
        super(abstractActivityC0349b, null);
        this.f4023f = new AtomicBoolean(true);
        this.f4024g = false;
        this.f4029m = new HashSet();
        this.f4032p = new HashSet();
        this.z = new io.flutter.embedding.engine.renderer.i();
        this.f4015A = new A2.q(25, this);
        this.f4016B = new M.a(this, new Handler(Looper.getMainLooper()), 1);
        this.f4017C = new n(this);
        this.f4018D = new C0350c(1, this);
        this.f4022H = new Object();
        this.f4025h = c0356i;
        this.k = c0356i;
        b();
    }

    /* JADX WARN: Type inference failed for: r0v36, types: [android.view.View, io.flutter.embedding.engine.renderer.m] */
    public final void a() {
        Objects.toString(this.f4031o);
        if (!c()) {
            return;
        }
        Iterator it = this.f4032p.iterator();
        if (!it.hasNext()) {
            getContext().getContentResolver().unregisterContentObserver(this.f4016B);
            io.flutter.plugin.platform.r rVar = this.f4031o.f4123s;
            SparseArray sparseArray = rVar.f4379q;
            SparseArray sparseArray2 = rVar.f4380r;
            SparseArray sparseArray3 = rVar.f4382t;
            for (int i4 = 0; i4 < sparseArray3.size(); i4++) {
                rVar.f4372i.removeView((io.flutter.plugin.platform.k) sparseArray3.valueAt(i4));
            }
            for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
                rVar.f4372i.removeView((C0460a) sparseArray2.valueAt(i5));
            }
            rVar.c();
            SparseArray sparseArray4 = rVar.f4381s;
            if (rVar.f4372i == null) {
                Log.e("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
            } else {
                for (int i6 = 0; i6 < sparseArray4.size(); i6++) {
                    rVar.f4372i.removeView((View) sparseArray4.valueAt(i6));
                }
                sparseArray4.clear();
            }
            rVar.f4372i = null;
            rVar.f4384v = false;
            for (int i7 = 0; i7 < sparseArray.size(); i7++) {
                ((InterfaceC0382f) sparseArray.valueAt(i7)).onFlutterViewDetached();
            }
            io.flutter.plugin.platform.q qVar = this.f4031o.f4124t;
            SparseArray sparseArray5 = qVar.f4358n;
            SparseArray sparseArray6 = qVar.f4359o;
            for (int i8 = 0; i8 < sparseArray6.size(); i8++) {
                qVar.f4354i.removeView((C0460a) sparseArray6.valueAt(i8));
            }
            Surface surface = qVar.f4363s;
            if (surface != null) {
                surface.release();
                qVar.f4363s = null;
                qVar.f4364t = null;
            }
            qVar.f4354i = null;
            for (int i9 = 0; i9 < sparseArray5.size(); i9++) {
                ((InterfaceC0382f) sparseArray5.valueAt(i9)).onFlutterViewDetached();
            }
            this.f4031o.f4123s.o();
            this.f4031o.f4124t.o();
            io.flutter.view.j jVar = this.f4039w;
            jVar.f4528u = true;
            jVar.f4513e.o();
            jVar.f4526s = null;
            AccessibilityManager accessibilityManager = jVar.f4511c;
            accessibilityManager.removeAccessibilityStateChangeListener(jVar.f4529v);
            accessibilityManager.removeTouchExplorationStateChangeListener(jVar.f4530w);
            jVar.f4514f.unregisterContentObserver(jVar.f4531x);
            A2.t tVar = jVar.f4510b;
            tVar.f101i = null;
            ((FlutterJNI) tVar.f100h).setAccessibilityDelegate(null);
            this.f4039w = null;
            this.f4034r.f4288b.restartInput(this);
            this.f4034r.c();
            int size = ((HashSet) this.f4037u.f100h).size();
            if (size > 0) {
                Log.w("KeyboardManager", "A KeyboardManager was destroyed with " + size + " unhandled redispatch event(s).");
            }
            io.flutter.plugin.editing.g gVar = this.f4035s;
            if (gVar != null) {
                gVar.f4275a.f5322g = null;
                SpellCheckerSession spellCheckerSession = gVar.f4277c;
                if (spellCheckerSession != null) {
                    spellCheckerSession.close();
                }
            }
            io.flutter.plugin.platform.s sVar = this.f4033q;
            if (sVar != null) {
                ((n.p) sVar.f4391h).f5322g = null;
            }
            io.flutter.embedding.engine.renderer.j jVar2 = this.f4031o.f4107b;
            this.f4030n = false;
            jVar2.g(this.f4018D);
            FlutterJNI flutterJNI = jVar2.f4233a;
            if (this.f4024g) {
                flutterJNI.removeResizingFlutterUiListener(this.f4017C);
            }
            jVar2.j();
            flutterJNI.setSemanticsEnabled(false);
            View view = this.f4028l;
            if (view != null && this.k == this.f4027j) {
                this.k = view;
            }
            this.k.a();
            C0354g c0354g = this.f4027j;
            if (c0354g != null) {
                c0354g.f3991f.close();
                removeView(this.f4027j);
                this.f4027j = null;
            }
            this.f4028l = null;
            this.f4031o = null;
            return;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.view.View
    public final void autofill(SparseArray sparseArray) {
        P1.y yVar;
        P1.y yVar2;
        CharSequence textValue;
        io.flutter.plugin.editing.j jVar = this.f4034r;
        if (Build.VERSION.SDK_INT < 26) {
            jVar.getClass();
            return;
        }
        r2.m mVar = jVar.f4292f;
        if (mVar != null && jVar.f4293g != null && (yVar = mVar.f6105j) != null) {
            HashMap hashMap = new HashMap();
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                r2.m mVar2 = (r2.m) jVar.f4293g.get(sparseArray.keyAt(i4));
                if (mVar2 != null && (yVar2 = mVar2.f6105j) != null) {
                    String str = (String) yVar2.f1469f;
                    textValue = com.dexterous.flutterlocalnotifications.a.k(sparseArray.valueAt(i4)).getTextValue();
                    String charSequence = textValue.toString();
                    r2.o oVar = new r2.o(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (str.equals((String) yVar.f1469f)) {
                        jVar.f4294h.f(oVar);
                    } else {
                        hashMap.put(str, oVar);
                    }
                }
            }
            io.flutter.plugin.platform.s sVar = jVar.f4290d;
            int i5 = jVar.f4291e.f3915c;
            sVar.getClass();
            hashMap.size();
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                r2.o oVar2 = (r2.o) entry.getValue();
                hashMap2.put((String) entry.getKey(), io.flutter.plugin.platform.s.z(oVar2.f6111a, oVar2.f6112b, oVar2.f6113c, -1, -1));
            }
            ((C0644p) sVar.f4390g).a("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i5), hashMap2), null);
        }
    }

    public final void b() {
        C0356i c0356i = this.f4025h;
        if (c0356i != null) {
            addView(c0356i);
        } else {
            k kVar = this.f4026i;
            if (kVar != null) {
                addView(kVar);
            } else {
                addView(this.f4027j);
            }
        }
        this.f4024g = AbstractC0602b.I(getContext());
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, io.flutter.embedding.engine.renderer.m] */
    public final boolean c() {
        C0368c c0368c = this.f4031o;
        if (c0368c != null && c0368c.f4107b == this.k.getAttachedRenderer()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean checkInputConnectionProxy(View view) {
        C0368c c0368c = this.f4031o;
        if (c0368c != null) {
            HashMap hashMap = c0368c.f4123s.f4378p;
            if (view == null || !hashMap.containsKey(view.getContext())) {
                return false;
            }
            View view2 = (View) hashMap.get(view.getContext());
            if (view2 == view) {
                return true;
            }
            return view2.checkInputConnectionProxy(view);
        }
        return super.checkInputConnectionProxy(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        if (r1 != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.p.d():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if ((c() && this.f4037u.M(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public final void e() {
        if (!c()) {
            Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        float f4 = getResources().getDisplayMetrics().density;
        io.flutter.embedding.engine.renderer.i iVar = this.z;
        iVar.f4212a = f4;
        iVar.f4230t = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        io.flutter.embedding.engine.renderer.j jVar = this.f4031o.f4107b;
        jVar.getClass();
        int i4 = iVar.f4213b;
        ArrayList arrayList = iVar.f4232v;
        ArrayList arrayList2 = iVar.f4231u;
        if (i4 == 0) {
            int i5 = iVar.f4215d;
            int i6 = iVar.f4216e;
            if (i5 <= 0 && i6 <= 0) {
                return;
            }
        } else {
            int i7 = iVar.f4214c;
            if (i7 == 0) {
                int i8 = iVar.f4217f;
                int i9 = iVar.f4218g;
                if (i8 <= 0 && i9 <= 0) {
                    return;
                }
            } else if (i4 <= 0 || i7 <= 0 || iVar.f4212a <= 0.0f) {
                return;
            }
        }
        arrayList2.size();
        arrayList.size();
        int size = arrayList.size() + arrayList2.size();
        int[] iArr = new int[size * 4];
        int[] iArr2 = new int[size];
        int[] iArr3 = new int[size];
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            io.flutter.embedding.engine.renderer.a aVar = (io.flutter.embedding.engine.renderer.a) arrayList2.get(i10);
            int i11 = i10 * 4;
            Rect rect = aVar.f4192a;
            iArr[i11] = rect.left;
            iArr[i11 + 1] = rect.top;
            iArr[i11 + 2] = rect.right;
            iArr[i11 + 3] = rect.bottom;
            iArr2[i10] = R.i.b(aVar.f4193b);
            iArr3[i10] = R.i.b(aVar.f4194c);
        }
        int size2 = arrayList2.size() * 4;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            io.flutter.embedding.engine.renderer.a aVar2 = (io.flutter.embedding.engine.renderer.a) arrayList.get(i12);
            int i13 = (i12 * 4) + size2;
            Rect rect2 = aVar2.f4192a;
            iArr[i13] = rect2.left;
            iArr[i13 + 1] = rect2.top;
            iArr[i13 + 2] = rect2.right;
            iArr[i13 + 3] = rect2.bottom;
            iArr2[arrayList2.size() + i12] = R.i.b(aVar2.f4193b);
            iArr3[arrayList2.size() + i12] = R.i.b(aVar2.f4194c);
        }
        jVar.f4233a.setViewportMetrics(iVar.f4212a, iVar.f4213b, iVar.f4214c, iVar.f4219h, iVar.f4220i, iVar.f4221j, iVar.k, iVar.f4222l, iVar.f4223m, iVar.f4224n, iVar.f4225o, iVar.f4226p, iVar.f4227q, iVar.f4228r, iVar.f4229s, iVar.f4230t, iArr, iArr2, iArr3, iVar.f4215d, iVar.f4216e, iVar.f4217f, iVar.f4218g);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.j jVar = this.f4039w;
        if (jVar != null && jVar.f4511c.isEnabled()) {
            return this.f4039w;
        }
        return null;
    }

    public C0368c getAttachedFlutterEngine() {
        return this.f4031o;
    }

    public InterfaceC0634f getBinaryMessenger() {
        return this.f4031o.f4108c;
    }

    public C0354g getCurrentImageSurface() {
        return this.f4027j;
    }

    public io.flutter.embedding.engine.renderer.i getViewportMetrics() {
        return this.z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x01b5, code lost:
    
        r1 = r18.getDisplayCutout();
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets r18) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.p.onApplyWindowInsets(android.view.WindowInsets):android.view.WindowInsets");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [e3.d] */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        R1.c cVar;
        Executor dVar;
        super.onAttachedToWindow();
        try {
            C0684g c0684g = InterfaceC0685h.f6280e;
            Context context = getContext();
            c0684g.getClass();
            cVar = new R1.c(25, new io.flutter.plugin.platform.s(C0684g.a(context)));
        } catch (NoClassDefFoundError unused) {
            cVar = null;
        }
        this.f4041y = cVar;
        Activity B3 = AbstractC0602b.B(getContext());
        R1.c cVar2 = this.f4041y;
        if (cVar2 != null && B3 != null) {
            this.f4019E = new m(0, this);
            Context context2 = getContext();
            if (Build.VERSION.SDK_INT >= 28) {
                dVar = C.b.f(context2);
            } else {
                dVar = new E.d(new Handler(context2.getMainLooper()), 0);
            }
            m mVar = this.f4019E;
            io.flutter.plugin.platform.s sVar = (io.flutter.plugin.platform.s) cVar2.f1532g;
            T2.h.e(dVar, "executor");
            T2.h.e(mVar, "consumer");
            io.flutter.plugin.platform.s sVar2 = (io.flutter.plugin.platform.s) sVar.f4391h;
            C0679b c0679b = (C0679b) sVar.f4390g;
            c0679b.getClass();
            C0686i c0686i = new C0686i(c0679b, B3, null);
            d3.a aVar = d3.a.f3492f;
            K2.j jVar = K2.j.f942f;
            e3.c cVar3 = new e3.c(c0686i, jVar, -2, aVar);
            i3.e eVar = b3.A.f3236a;
            c3.c cVar4 = g3.n.f3803a;
            if (cVar4.e(b3.r.f3295g) == null) {
                e3.c cVar5 = cVar3;
                if (!cVar4.equals(jVar)) {
                    cVar5 = f3.k.a(cVar3, cVar4, 0, null, 6);
                }
                LinkedHashMap linkedHashMap = (LinkedHashMap) sVar2.f4391h;
                ReentrantLock reentrantLock = (ReentrantLock) sVar2.f4390g;
                reentrantLock.lock();
                try {
                    if (linkedHashMap.get(mVar) == null) {
                        K2.i i4 = new I(dVar);
                        if (i4.e(b3.r.f3295g) == null) {
                            i4 = i4.j(new P());
                        }
                        t0.a aVar2 = new t0.a(cVar5, mVar, null);
                        EnumC0244t enumC0244t = EnumC0244t.f3296f;
                        K2.i a4 = AbstractC0245u.a(i4, jVar, true);
                        i3.e eVar2 = b3.A.f3236a;
                        if (a4 != eVar2 && a4.e(K2.e.f941f) == null) {
                            a4 = a4.j(eVar2);
                        }
                        AbstractC0226a abstractC0226a = new AbstractC0226a(a4, true);
                        abstractC0226a.T(enumC0244t, abstractC0226a, aVar2);
                        linkedHashMap.put(mVar, abstractC0226a);
                    }
                    return;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + cVar4).toString());
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f4031o != null) {
            this.f4036t.b(configuration);
            d();
            AbstractC0602b.f(getContext(), this.f4031o);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        if (r2.f6110c != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r17) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.p.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        m mVar;
        R1.c cVar = this.f4041y;
        if (cVar != null && (mVar = this.f4019E) != null) {
            io.flutter.plugin.platform.s sVar = (io.flutter.plugin.platform.s) ((io.flutter.plugin.platform.s) cVar.f1532g).f4391h;
            LinkedHashMap linkedHashMap = (LinkedHashMap) sVar.f4391h;
            ReentrantLock reentrantLock = (ReentrantLock) sVar.f4390g;
            reentrantLock.lock();
            try {
                N n3 = (N) linkedHashMap.get(mVar);
                if (n3 != null) {
                    n3.b(null);
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        this.f4019E = null;
        this.f4041y = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z;
        if (c()) {
            C0348a c0348a = this.f4038v;
            Context context = getContext();
            c0348a.getClass();
            boolean isFromSource = motionEvent.isFromSource(2);
            if (motionEvent.getActionMasked() != 7 && motionEvent.getActionMasked() != 8) {
                z = false;
            } else {
                z = true;
            }
            if (isFromSource && z) {
                int b4 = C0348a.b(motionEvent.getActionMasked());
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
                allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                c0348a.a(motionEvent, motionEvent.getActionIndex(), b4, 0, C0348a.f3965f, allocateDirect, context);
                if (allocateDirect.position() % 288 == 0) {
                    c0348a.f3966a.f4233a.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
                    return true;
                }
                throw new AssertionError("Packet position is not on field boundary.");
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        if (!c()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f4039w.f(motionEvent, false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        this.f4020F = View.MeasureSpec.getMode(i4);
        this.f4021G = View.MeasureSpec.getMode(i5);
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i4) {
        Rect rect;
        super.onProvideAutofillVirtualStructure(viewStructure, i4);
        io.flutter.plugin.editing.j jVar = this.f4034r;
        if (Build.VERSION.SDK_INT >= 26) {
            if (jVar.f4293g != null) {
                String str = (String) jVar.f4292f.f6105j.f1469f;
                AutofillId autofillId = viewStructure.getAutofillId();
                for (int i5 = 0; i5 < jVar.f4293g.size(); i5++) {
                    int keyAt = jVar.f4293g.keyAt(i5);
                    P1.y yVar = ((r2.m) jVar.f4293g.valueAt(i5)).f6105j;
                    if (yVar != null) {
                        viewStructure.addChildCount(1);
                        ViewStructure newChild = viewStructure.newChild(i5);
                        newChild.setAutofillId(autofillId, keyAt);
                        String[] strArr = (String[]) yVar.f1470g;
                        if (strArr.length > 0) {
                            newChild.setAutofillHints(strArr);
                        }
                        newChild.setAutofillType(1);
                        newChild.setVisibility(0);
                        String str2 = (String) yVar.f1472i;
                        if (str2 != null) {
                            newChild.setHint(str2);
                        }
                        if (str.hashCode() == keyAt && (rect = jVar.f4298m) != null) {
                            newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), jVar.f4298m.height());
                            newChild.setAutofillValue(AutofillValue.forText(jVar.f4294h));
                        } else {
                            newChild.setDimens(0, 0, 0, 0, 1, 1);
                            newChild.setAutofillValue(AutofillValue.forText(((r2.o) yVar.f1471h).f6111a));
                        }
                    }
                }
                return;
            }
            return;
        }
        jVar.getClass();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        io.flutter.embedding.engine.renderer.i iVar = this.z;
        iVar.f4213b = i4;
        iVar.f4214c = i5;
        boolean z = this.f4024g;
        if (z && this.f4021G == 0) {
            iVar.f4217f = 0;
            iVar.f4218g = 8192;
        } else {
            iVar.f4217f = i5;
            iVar.f4218g = i5;
        }
        if (z && this.f4020F == 0) {
            iVar.f4215d = 0;
            iVar.f4216e = 8192;
        } else {
            iVar.f4215d = i4;
            iVar.f4216e = i4;
        }
        if (this.f4023f.compareAndSet(false, true)) {
            return;
        }
        e();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!c()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        this.f4038v.d(motionEvent, C0348a.f3965f);
        return true;
    }

    public void setDelegate(q qVar) {
        this.f4022H = qVar;
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        View view = this.k;
        if (view instanceof C0356i) {
            ((C0356i) view).setVisibility(i4);
        }
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List, java.lang.Object] */
    public void setWindowInfoListenerDisplayFeatures(C0687j c0687j) {
        C0679b c0679b;
        int i4;
        C0679b c0679b2 = C0679b.f6262i;
        ?? r9 = c0687j.f6284a;
        ArrayList arrayList = new ArrayList();
        for (C0680c c0680c : r9) {
            c0680c.f6268a.a().toString();
            s0.b bVar = c0680c.f6268a;
            if (bVar.f6127c - bVar.f6125a != 0 && bVar.f6128d - bVar.f6126b != 0) {
                c0679b = c0679b2;
            } else {
                c0679b = C0679b.f6261h;
            }
            int i5 = 2;
            if (c0679b == c0679b2) {
                i4 = 3;
            } else {
                i4 = 2;
            }
            C0679b c0679b3 = c0680c.f6270c;
            if (c0679b3 != C0679b.f6263j) {
                if (c0679b3 == C0679b.k) {
                    i5 = 3;
                } else {
                    i5 = 1;
                }
            }
            arrayList.add(new io.flutter.embedding.engine.renderer.a(bVar.a(), i4, i5));
        }
        ArrayList arrayList2 = this.z.f4231u;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        e();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object, h2.q] */
    public p(AbstractActivityC0349b abstractActivityC0349b, k kVar) {
        super(abstractActivityC0349b, null);
        this.f4023f = new AtomicBoolean(true);
        this.f4024g = false;
        this.f4029m = new HashSet();
        this.f4032p = new HashSet();
        this.z = new io.flutter.embedding.engine.renderer.i();
        this.f4015A = new A2.q(25, this);
        this.f4016B = new M.a(this, new Handler(Looper.getMainLooper()), 1);
        this.f4017C = new n(this);
        this.f4018D = new C0350c(1, this);
        this.f4022H = new Object();
        this.f4026i = kVar;
        this.k = kVar;
        b();
    }
}
