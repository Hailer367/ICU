package j;

import I.T;
import I.Y;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import m.AbstractC0438b;
import o.C0515f;
import o.C0523j;
import o.C0543t;
import o.E1;
import o.InterfaceC0536p0;
import o.x1;
import t.C0661j;

/* renamed from: j.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class LayoutInflaterFactory2C0393A extends AbstractC0420o implements n.l, LayoutInflater.Factory2 {
    public static final C0661j m0 = new C0661j(0);

    /* renamed from: n0, reason: collision with root package name */
    public static final int[] f4823n0 = {R.attr.windowBackground};

    /* renamed from: o0, reason: collision with root package name */
    public static final boolean f4824o0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: p0, reason: collision with root package name */
    public static final boolean f4825p0 = true;

    /* renamed from: A, reason: collision with root package name */
    public ActionBarContextView f4826A;

    /* renamed from: B, reason: collision with root package name */
    public PopupWindow f4827B;

    /* renamed from: C, reason: collision with root package name */
    public RunnableC0421p f4828C;

    /* renamed from: E, reason: collision with root package name */
    public boolean f4830E;

    /* renamed from: F, reason: collision with root package name */
    public ViewGroup f4831F;

    /* renamed from: G, reason: collision with root package name */
    public TextView f4832G;

    /* renamed from: H, reason: collision with root package name */
    public View f4833H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f4834I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f4835J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f4836K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f4837L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f4838M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f4839N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f4840O;
    public boolean P;

    /* renamed from: Q, reason: collision with root package name */
    public z[] f4841Q;

    /* renamed from: R, reason: collision with root package name */
    public z f4842R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f4843S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f4844T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f4845U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f4846V;

    /* renamed from: W, reason: collision with root package name */
    public Configuration f4847W;

    /* renamed from: X, reason: collision with root package name */
    public final int f4848X;

    /* renamed from: Y, reason: collision with root package name */
    public int f4849Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f4850Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f4851a0;

    /* renamed from: b0, reason: collision with root package name */
    public w f4852b0;

    /* renamed from: c0, reason: collision with root package name */
    public w f4853c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f4854d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f4855e0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f4857g0;

    /* renamed from: h0, reason: collision with root package name */
    public Rect f4858h0;

    /* renamed from: i0, reason: collision with root package name */
    public Rect f4859i0;

    /* renamed from: j0, reason: collision with root package name */
    public C0396D f4860j0;

    /* renamed from: k0, reason: collision with root package name */
    public OnBackInvokedDispatcher f4861k0;

    /* renamed from: l0, reason: collision with root package name */
    public OnBackInvokedCallback f4862l0;

    /* renamed from: o, reason: collision with root package name */
    public final Object f4863o;

    /* renamed from: p, reason: collision with root package name */
    public final Context f4864p;

    /* renamed from: q, reason: collision with root package name */
    public Window f4865q;

    /* renamed from: r, reason: collision with root package name */
    public v f4866r;

    /* renamed from: s, reason: collision with root package name */
    public final Object f4867s;

    /* renamed from: t, reason: collision with root package name */
    public AbstractC0406a f4868t;

    /* renamed from: u, reason: collision with root package name */
    public m.j f4869u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f4870v;

    /* renamed from: w, reason: collision with root package name */
    public InterfaceC0536p0 f4871w;

    /* renamed from: x, reason: collision with root package name */
    public C0422q f4872x;

    /* renamed from: y, reason: collision with root package name */
    public r f4873y;
    public AbstractC0438b z;

    /* renamed from: D, reason: collision with root package name */
    public Y f4829D = null;

    /* renamed from: f0, reason: collision with root package name */
    public final RunnableC0421p f4856f0 = new RunnableC0421p(this, 0);

    public LayoutInflaterFactory2C0393A(Context context, Window window, InterfaceC0417l interfaceC0417l, Object obj) {
        AbstractActivityC0416k abstractActivityC0416k = null;
        this.f4848X = -100;
        this.f4864p = context;
        this.f4867s = interfaceC0417l;
        this.f4863o = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (context instanceof AbstractActivityC0416k) {
                        abstractActivityC0416k = (AbstractActivityC0416k) context;
                        break;
                    } else if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    break;
                }
            }
            if (abstractActivityC0416k != null) {
                this.f4848X = ((LayoutInflaterFactory2C0393A) abstractActivityC0416k.getDelegate()).f4848X;
            }
        }
        if (this.f4848X == -100) {
            String name = this.f4863o.getClass().getName();
            C0661j c0661j = m0;
            Integer num = (Integer) c0661j.get(name);
            if (num != null) {
                this.f4848X = num.intValue();
                c0661j.remove(this.f4863o.getClass().getName());
            }
        }
        if (window != null) {
            p(window);
        }
        C0543t.c();
    }

    public static E.e q(Context context) {
        E.e eVar;
        E.e eVar2;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 33 || (eVar = AbstractC0420o.f4996h) == null) {
            return null;
        }
        E.f fVar = eVar.f454a;
        E.e b4 = t.b(context.getApplicationContext().getResources().getConfiguration());
        if (fVar.f455a.isEmpty()) {
            eVar2 = E.e.f453b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i4 = 0; i4 < b4.f454a.f455a.size() + fVar.f455a.size(); i4++) {
                if (i4 < fVar.f455a.size()) {
                    locale = fVar.f455a.get(i4);
                } else {
                    locale = b4.f454a.f455a.get(i4 - fVar.f455a.size());
                }
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
            }
            eVar2 = new E.e(new E.f(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        if (eVar2.f454a.f455a.isEmpty()) {
            return b4;
        }
        return eVar2;
    }

    public static Configuration u(Context context, int i4, E.e eVar, Configuration configuration, boolean z) {
        int i5;
        if (i4 != 1) {
            if (i4 != 2) {
                if (z) {
                    i5 = 0;
                } else {
                    i5 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                }
            } else {
                i5 = 32;
            }
        } else {
            i5 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i5 | (configuration2.uiMode & (-49));
        if (eVar != null) {
            t.d(configuration2, eVar);
        }
        return configuration2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r2 <= r5) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [j.z, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j.z A(int r5) {
        /*
            r4 = this;
            j.z[] r0 = r4.f4841Q
            r1 = 0
            if (r0 == 0) goto L8
            int r2 = r0.length
            if (r2 > r5) goto L15
        L8:
            int r2 = r5 + 1
            j.z[] r2 = new j.z[r2]
            if (r0 == 0) goto L12
            int r3 = r0.length
            java.lang.System.arraycopy(r0, r1, r2, r1, r3)
        L12:
            r4.f4841Q = r2
            r0 = r2
        L15:
            r2 = r0[r5]
            if (r2 != 0) goto L24
            j.z r2 = new j.z
            r2.<init>()
            r2.f5019a = r5
            r2.f5031n = r1
            r0[r5] = r2
        L24:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.A(int):j.z");
    }

    public final void B() {
        x();
        if (this.f4836K && this.f4868t == null) {
            Object obj = this.f4863o;
            if (obj instanceof Activity) {
                this.f4868t = new Q((Activity) obj, this.f4837L);
            } else if (obj instanceof Dialog) {
                this.f4868t = new Q((Dialog) obj);
            }
            AbstractC0406a abstractC0406a = this.f4868t;
            if (abstractC0406a != null) {
                abstractC0406a.o(this.f4857g0);
            }
        }
    }

    public final void C(int i4) {
        this.f4855e0 = (1 << i4) | this.f4855e0;
        if (!this.f4854d0) {
            View decorView = this.f4865q.getDecorView();
            WeakHashMap weakHashMap = T.f702a;
            decorView.postOnAnimation(this.f4856f0);
            this.f4854d0 = true;
        }
    }

    public final int D(Context context, int i4) {
        if (i4 != -100) {
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != 1 && i4 != 2) {
                        if (i4 == 3) {
                            if (this.f4853c0 == null) {
                                this.f4853c0 = new w(this, context);
                            }
                            return this.f4853c0.e();
                        }
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return z(context).e();
                }
            }
            return i4;
        }
        return -1;
    }

    public final boolean E() {
        boolean z = this.f4843S;
        this.f4843S = false;
        z A3 = A(0);
        if (A3.f5030m) {
            if (!z) {
                t(A3, true);
                return true;
            }
        } else {
            AbstractC0438b abstractC0438b = this.z;
            if (abstractC0438b != null) {
                abstractC0438b.a();
                return true;
            }
            B();
            AbstractC0406a abstractC0406a = this.f4868t;
            if (abstractC0406a == null || !abstractC0406a.b()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
    
        if (r2.k.getCount() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0155, code lost:
    
        if (r2 != null) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(j.z r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.F(j.z, android.view.KeyEvent):void");
    }

    public final boolean G(z zVar, int i4, KeyEvent keyEvent) {
        n.n nVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((!zVar.k && !H(zVar, keyEvent)) || (nVar = zVar.f5026h) == null) {
            return false;
        }
        return nVar.performShortcut(i4, keyEvent, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d5, code lost:
    
        if (r13.f5026h == null) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H(j.z r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.H(j.z, android.view.KeyEvent):boolean");
    }

    public final void I() {
        if (!this.f4830E) {
        } else {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void J() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.f4861k0 != null && (A(0).f5030m || this.z != null)) {
                z = true;
            }
            if (z && this.f4862l0 == null) {
                this.f4862l0 = u.b(this.f4861k0, this);
            } else if (!z && (onBackInvokedCallback = this.f4862l0) != null) {
                u.c(this.f4861k0, onBackInvokedCallback);
            }
        }
    }

    @Override // j.AbstractC0420o
    public final void a() {
        LayoutInflater from = LayoutInflater.from(this.f4864p);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (!(from.getFactory2() instanceof LayoutInflaterFactory2C0393A)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // j.AbstractC0420o
    public final void b() {
        if (this.f4868t != null) {
            B();
            if (!this.f4868t.g()) {
                C(0);
            }
        }
    }

    @Override // j.AbstractC0420o
    public final void d() {
        String str;
        this.f4844T = true;
        o(false, true);
        y();
        Object obj = this.f4863o;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = AbstractC0286a.r(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e4) {
                    throw new IllegalArgumentException(e4);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                AbstractC0406a abstractC0406a = this.f4868t;
                if (abstractC0406a == null) {
                    this.f4857g0 = true;
                } else {
                    abstractC0406a.o(true);
                }
            }
            synchronized (AbstractC0420o.f5000m) {
                AbstractC0420o.f(this);
                AbstractC0420o.f4999l.add(new WeakReference(this));
            }
        }
        this.f4847W = new Configuration(this.f4864p.getResources().getConfiguration());
        this.f4845U = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // j.AbstractC0420o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4863o
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = j.AbstractC0420o.f5000m
            monitor-enter(r0)
            j.AbstractC0420o.f(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f4854d0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f4865q
            android.view.View r0 = r0.getDecorView()
            j.p r1 = r3.f4856f0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.f4846V = r0
            int r0 = r3.f4848X
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f4863o
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            t.j r0 = j.LayoutInflaterFactory2C0393A.m0
            java.lang.Object r1 = r3.f4863o
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f4848X
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            t.j r0 = j.LayoutInflaterFactory2C0393A.m0
            java.lang.Object r1 = r3.f4863o
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            j.a r0 = r3.f4868t
            if (r0 == 0) goto L63
            r0.j()
        L63:
            j.w r0 = r3.f4852b0
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            j.w r0 = r3.f4853c0
            if (r0 == 0) goto L71
            r0.c()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.e():void");
    }

    @Override // j.AbstractC0420o
    public final boolean g(int i4) {
        if (i4 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i4 = 108;
        } else if (i4 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i4 = 109;
        }
        if (this.f4840O && i4 == 108) {
            return false;
        }
        if (this.f4836K && i4 == 1) {
            this.f4836K = false;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 5) {
                    if (i4 != 10) {
                        if (i4 != 108) {
                            if (i4 != 109) {
                                return this.f4865q.requestFeature(i4);
                            }
                            I();
                            this.f4837L = true;
                            return true;
                        }
                        I();
                        this.f4836K = true;
                        return true;
                    }
                    I();
                    this.f4838M = true;
                    return true;
                }
                I();
                this.f4835J = true;
                return true;
            }
            I();
            this.f4834I = true;
            return true;
        }
        I();
        this.f4840O = true;
        return true;
    }

    @Override // n.l
    public final boolean h(n.n nVar, MenuItem menuItem) {
        int i4;
        z zVar;
        Window.Callback callback = this.f4865q.getCallback();
        if (callback != null && !this.f4846V) {
            n.n k = nVar.k();
            z[] zVarArr = this.f4841Q;
            if (zVarArr != null) {
                i4 = zVarArr.length;
            } else {
                i4 = 0;
            }
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    zVar = zVarArr[i5];
                    if (zVar != null && zVar.f5026h == k) {
                        break;
                    }
                    i5++;
                } else {
                    zVar = null;
                    break;
                }
            }
            if (zVar != null) {
                return callback.onMenuItemSelected(zVar.f5019a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r6.f() != false) goto L20;
     */
    @Override // n.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(n.n r6) {
        /*
            r5 = this;
            o.p0 r6 = r5.f4871w
            r0 = 1
            r1 = 0
            if (r6 == 0) goto Ld3
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.e()
            o.q0 r6 = r6.f2329j
            o.x1 r6 = (o.x1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f5734a
            int r2 = r6.getVisibility()
            if (r2 != 0) goto Ld3
            androidx.appcompat.widget.ActionMenuView r6 = r6.f2474f
            if (r6 == 0) goto Ld3
            boolean r6 = r6.f2353x
            if (r6 == 0) goto Ld3
            android.content.Context r6 = r5.f4864p
            android.view.ViewConfiguration r6 = android.view.ViewConfiguration.get(r6)
            boolean r6 = r6.hasPermanentMenuKey()
            if (r6 == 0) goto L4a
            o.p0 r6 = r5.f4871w
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.e()
            o.q0 r6 = r6.f2329j
            o.x1 r6 = (o.x1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f5734a
            androidx.appcompat.widget.ActionMenuView r6 = r6.f2474f
            if (r6 == 0) goto Ld3
            o.j r6 = r6.f2354y
            if (r6 == 0) goto Ld3
            o.h r2 = r6.z
            if (r2 != 0) goto L4a
            boolean r6 = r6.f()
            if (r6 == 0) goto Ld3
        L4a:
            android.view.Window r6 = r5.f4865q
            android.view.Window$Callback r6 = r6.getCallback()
            o.p0 r2 = r5.f4871w
            androidx.appcompat.widget.ActionBarOverlayLayout r2 = (androidx.appcompat.widget.ActionBarOverlayLayout) r2
            r2.e()
            o.q0 r2 = r2.f2329j
            o.x1 r2 = (o.x1) r2
            androidx.appcompat.widget.Toolbar r2 = r2.f5734a
            boolean r2 = r2.o()
            r3 = 108(0x6c, float:1.51E-43)
            if (r2 == 0) goto L8c
            o.p0 r0 = r5.f4871w
            androidx.appcompat.widget.ActionBarOverlayLayout r0 = (androidx.appcompat.widget.ActionBarOverlayLayout) r0
            r0.e()
            o.q0 r0 = r0.f2329j
            o.x1 r0 = (o.x1) r0
            androidx.appcompat.widget.Toolbar r0 = r0.f5734a
            androidx.appcompat.widget.ActionMenuView r0 = r0.f2474f
            if (r0 == 0) goto L7e
            o.j r0 = r0.f2354y
            if (r0 == 0) goto L7e
            boolean r0 = r0.c()
        L7e:
            boolean r0 = r5.f4846V
            if (r0 != 0) goto Ld2
            j.z r0 = r5.A(r1)
            n.n r0 = r0.f5026h
            r6.onPanelClosed(r3, r0)
            return
        L8c:
            if (r6 == 0) goto Ld2
            boolean r2 = r5.f4846V
            if (r2 != 0) goto Ld2
            boolean r2 = r5.f4854d0
            if (r2 == 0) goto La9
            int r2 = r5.f4855e0
            r0 = r0 & r2
            if (r0 == 0) goto La9
            android.view.Window r0 = r5.f4865q
            android.view.View r0 = r0.getDecorView()
            j.p r2 = r5.f4856f0
            r0.removeCallbacks(r2)
            r2.run()
        La9:
            j.z r0 = r5.A(r1)
            n.n r2 = r0.f5026h
            if (r2 == 0) goto Ld2
            boolean r4 = r0.f5032o
            if (r4 != 0) goto Ld2
            android.view.View r4 = r0.f5025g
            boolean r1 = r6.onPreparePanel(r1, r4, r2)
            if (r1 == 0) goto Ld2
            n.n r0 = r0.f5026h
            r6.onMenuOpened(r3, r0)
            o.p0 r6 = r5.f4871w
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.e()
            o.q0 r6 = r6.f2329j
            o.x1 r6 = (o.x1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f5734a
            r6.u()
        Ld2:
            return
        Ld3:
            j.z r6 = r5.A(r1)
            r6.f5031n = r0
            r5.t(r6, r1)
            r0 = 0
            r5.F(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.i(n.n):void");
    }

    @Override // j.AbstractC0420o
    public final void j(int i4) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f4831F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f4864p).inflate(i4, viewGroup);
        this.f4866r.a(this.f4865q.getCallback());
    }

    @Override // j.AbstractC0420o
    public final void k(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f4831F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f4866r.a(this.f4865q.getCallback());
    }

    @Override // j.AbstractC0420o
    public final void l(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f4831F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f4866r.a(this.f4865q.getCallback());
    }

    @Override // j.AbstractC0420o
    public final void m(CharSequence charSequence) {
        this.f4870v = charSequence;
        InterfaceC0536p0 interfaceC0536p0 = this.f4871w;
        if (interfaceC0536p0 != null) {
            interfaceC0536p0.setWindowTitle(charSequence);
            return;
        }
        AbstractC0406a abstractC0406a = this.f4868t;
        if (abstractC0406a != null) {
            abstractC0406a.s(charSequence);
            return;
        }
        TextView textView = this.f4832G;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0192  */
    /* JADX WARN: Type inference failed for: r2v0, types: [j.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v14, types: [m.b, m.f, java.lang.Object, n.l] */
    @Override // j.AbstractC0420o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final m.AbstractC0438b n(m.InterfaceC0437a r9) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.n(m.a):m.b");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0230 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.o(boolean, boolean):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:68:0x01e4
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            Method dump skipped, instructions count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void p(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.f4865q == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof v)) {
                v vVar = new v(this, callback);
                this.f4866r = vVar;
                window.setCallback(vVar);
                Context context = this.f4864p;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f4823n0);
                if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
                    C0543t a4 = C0543t.a();
                    synchronized (a4) {
                        drawable = a4.f5709a.d(context, resourceId, true);
                    }
                } else {
                    drawable = null;
                }
                if (drawable != null) {
                    window.setBackgroundDrawable(drawable);
                }
                obtainStyledAttributes.recycle();
                this.f4865q = window;
                if (Build.VERSION.SDK_INT >= 33 && (onBackInvokedDispatcher = this.f4861k0) == null) {
                    Object obj = this.f4863o;
                    if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f4862l0) != null) {
                        u.c(onBackInvokedDispatcher, onBackInvokedCallback);
                        this.f4862l0 = null;
                    }
                    if (obj instanceof Activity) {
                        Activity activity = (Activity) obj;
                        if (activity.getWindow() != null) {
                            this.f4861k0 = u.a(activity);
                            J();
                            return;
                        }
                    }
                    this.f4861k0 = null;
                    J();
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final void r(int i4, z zVar, n.n nVar) {
        if (nVar == null) {
            if (zVar == null && i4 >= 0) {
                z[] zVarArr = this.f4841Q;
                if (i4 < zVarArr.length) {
                    zVar = zVarArr[i4];
                }
            }
            if (zVar != null) {
                nVar = zVar.f5026h;
            }
        }
        if ((zVar == null || zVar.f5030m) && !this.f4846V) {
            v vVar = this.f4866r;
            Window.Callback callback = this.f4865q.getCallback();
            vVar.getClass();
            try {
                vVar.f5012j = true;
                callback.onPanelClosed(i4, nVar);
            } finally {
                vVar.f5012j = false;
            }
        }
    }

    public final void s(n.n nVar) {
        C0523j c0523j;
        if (this.P) {
            return;
        }
        this.P = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f4871w;
        actionBarOverlayLayout.e();
        ActionMenuView actionMenuView = ((x1) actionBarOverlayLayout.f2329j).f5734a.f2474f;
        if (actionMenuView != null && (c0523j = actionMenuView.f2354y) != null) {
            c0523j.c();
            C0515f c0515f = c0523j.f5619y;
            if (c0515f != null && c0515f.b()) {
                c0515f.f5369i.dismiss();
            }
        }
        Window.Callback callback = this.f4865q.getCallback();
        if (callback != null && !this.f4846V) {
            callback.onPanelClosed(108, nVar);
        }
        this.P = false;
    }

    public final void t(z zVar, boolean z) {
        y yVar;
        InterfaceC0536p0 interfaceC0536p0;
        if (z && zVar.f5019a == 0 && (interfaceC0536p0 = this.f4871w) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0536p0;
            actionBarOverlayLayout.e();
            if (((x1) actionBarOverlayLayout.f2329j).f5734a.o()) {
                s(zVar.f5026h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f4864p.getSystemService("window");
        if (windowManager != null && zVar.f5030m && (yVar = zVar.f5023e) != null) {
            windowManager.removeView(yVar);
            if (z) {
                r(zVar.f5019a, zVar, null);
            }
        }
        zVar.k = false;
        zVar.f5029l = false;
        zVar.f5030m = false;
        zVar.f5024f = null;
        zVar.f5031n = true;
        if (this.f4842R == zVar) {
            this.f4842R = null;
        }
        if (zVar.f5019a == 0) {
            J();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r4.dispatchKeyEvent(r7) != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f0, code lost:
    
        if (r7.c() != false) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.LayoutInflaterFactory2C0393A.v(android.view.KeyEvent):boolean");
    }

    public final void w(int i4) {
        z A3 = A(i4);
        if (A3.f5026h != null) {
            Bundle bundle = new Bundle();
            A3.f5026h.t(bundle);
            if (bundle.size() > 0) {
                A3.f5033p = bundle;
            }
            A3.f5026h.w();
            A3.f5026h.clear();
        }
        A3.f5032o = true;
        A3.f5031n = true;
        if ((i4 == 108 || i4 == 0) && this.f4871w != null) {
            z A4 = A(0);
            A4.k = false;
            H(A4, null);
        }
    }

    public final void x() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.f4830E) {
            Context context2 = this.f4864p;
            int[] iArr = AbstractC0357a.f4075j;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            if (obtainStyledAttributes.hasValue(117)) {
                if (obtainStyledAttributes.getBoolean(126, false)) {
                    g(1);
                } else if (obtainStyledAttributes.getBoolean(117, false)) {
                    g(108);
                }
                if (obtainStyledAttributes.getBoolean(118, false)) {
                    g(109);
                }
                if (obtainStyledAttributes.getBoolean(119, false)) {
                    g(10);
                }
                this.f4839N = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
                y();
                this.f4865q.getDecorView();
                LayoutInflater from = LayoutInflater.from(context2);
                if (!this.f4840O) {
                    if (this.f4839N) {
                        viewGroup = (ViewGroup) from.inflate(com.icaremc.app.R.layout.abc_dialog_title_material, (ViewGroup) null);
                        this.f4837L = false;
                        this.f4836K = false;
                    } else if (this.f4836K) {
                        TypedValue typedValue = new TypedValue();
                        context2.getTheme().resolveAttribute(com.icaremc.app.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            context = new m.e(context2, typedValue.resourceId);
                        } else {
                            context = context2;
                        }
                        viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(com.icaremc.app.R.layout.abc_screen_toolbar, (ViewGroup) null);
                        InterfaceC0536p0 interfaceC0536p0 = (InterfaceC0536p0) viewGroup.findViewById(com.icaremc.app.R.id.decor_content_parent);
                        this.f4871w = interfaceC0536p0;
                        interfaceC0536p0.setWindowCallback(this.f4865q.getCallback());
                        if (this.f4837L) {
                            ((ActionBarOverlayLayout) this.f4871w).d(109);
                        }
                        if (this.f4834I) {
                            ((ActionBarOverlayLayout) this.f4871w).d(2);
                        }
                        if (this.f4835J) {
                            ((ActionBarOverlayLayout) this.f4871w).d(5);
                        }
                    } else {
                        viewGroup = null;
                    }
                } else {
                    viewGroup = this.f4838M ? (ViewGroup) from.inflate(com.icaremc.app.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(com.icaremc.app.R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (viewGroup != null) {
                    C0422q c0422q = new C0422q(this);
                    WeakHashMap weakHashMap = T.f702a;
                    I.K.c(viewGroup, c0422q);
                    if (this.f4871w == null) {
                        this.f4832G = (TextView) viewGroup.findViewById(com.icaremc.app.R.id.title);
                    }
                    Method method = E1.f5440a;
                    try {
                        Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
                        if (!method2.isAccessible()) {
                            method2.setAccessible(true);
                        }
                        method2.invoke(viewGroup, null);
                    } catch (IllegalAccessException e4) {
                        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e4);
                    } catch (NoSuchMethodException unused) {
                        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                    } catch (InvocationTargetException e5) {
                        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e5);
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.icaremc.app.R.id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f4865q.findViewById(R.id.content);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(R.id.content);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.f4865q.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new r(this));
                    this.f4831F = viewGroup;
                    Object obj = this.f4863o;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.f4870v;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        InterfaceC0536p0 interfaceC0536p02 = this.f4871w;
                        if (interfaceC0536p02 != null) {
                            interfaceC0536p02.setWindowTitle(charSequence);
                        } else {
                            AbstractC0406a abstractC0406a = this.f4868t;
                            if (abstractC0406a != null) {
                                abstractC0406a.s(charSequence);
                            } else {
                                TextView textView = this.f4832G;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f4831F.findViewById(R.id.content);
                    View decorView = this.f4865q.getDecorView();
                    contentFrameLayout2.f2364l.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    WeakHashMap weakHashMap2 = T.f702a;
                    if (contentFrameLayout2.isLaidOut()) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(iArr);
                    obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(122)) {
                        obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(123)) {
                        obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(120)) {
                        obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(121)) {
                        obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.f4830E = true;
                    z A3 = A(0);
                    if (!this.f4846V && A3.f5026h == null) {
                        C(108);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f4836K + ", windowActionBarOverlay: " + this.f4837L + ", android:windowIsFloating: " + this.f4839N + ", windowActionModeOverlay: " + this.f4838M + ", windowNoTitle: " + this.f4840O + " }");
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void y() {
        if (this.f4865q == null) {
            Object obj = this.f4863o;
            if (obj instanceof Activity) {
                p(((Activity) obj).getWindow());
            }
        }
        if (this.f4865q != null) {
        } else {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final x z(Context context) {
        if (this.f4852b0 == null) {
            if (A2.t.k == null) {
                Context applicationContext = context.getApplicationContext();
                A2.t.k = new A2.t(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f4852b0 = new w(this, A2.t.k);
        }
        return this.f4852b0;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
