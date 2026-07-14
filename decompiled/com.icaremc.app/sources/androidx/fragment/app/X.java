package androidx.fragment.app;

import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.EnumC0207n;
import i0.C0359b;
import j.AbstractActivityC0416k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import t.C0662k;

/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public final E0.a f2802a;

    /* renamed from: b, reason: collision with root package name */
    public final P1.y f2803b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractComponentCallbacksC0187t f2804c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2805d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f2806e = -1;

    public X(E0.a aVar, P1.y yVar, AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        this.f2802a = aVar;
        this.f2803b = yVar;
        this.f2804c = abstractComponentCallbacksC0187t;
    }

    public final void a() {
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + abstractComponentCallbacksC0187t);
        }
        Bundle bundle = abstractComponentCallbacksC0187t.f2925g;
        if (bundle != null) {
            bundle.getBundle("savedInstanceState");
        }
        abstractComponentCallbacksC0187t.z.P();
        abstractComponentCallbacksC0187t.f2924f = 3;
        abstractComponentCallbacksC0187t.f2911I = false;
        abstractComponentCallbacksC0187t.j();
        if (abstractComponentCallbacksC0187t.f2911I) {
            if (P.J(3)) {
                Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + abstractComponentCallbacksC0187t);
            }
            abstractComponentCallbacksC0187t.f2925g = null;
            Q q2 = abstractComponentCallbacksC0187t.z;
            q2.f2741G = false;
            q2.f2742H = false;
            q2.f2748N.f2788i = false;
            q2.u(4);
            this.f2802a.h(abstractComponentCallbacksC0187t, false);
            return;
        }
        throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onActivityCreated()");
    }

    public final void b() {
        X x3;
        Bundle bundle;
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "moveto ATTACHED: " + abstractComponentCallbacksC0187t);
        }
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = abstractComponentCallbacksC0187t.f2929l;
        P1.y yVar = this.f2803b;
        if (abstractComponentCallbacksC0187t2 != null) {
            x3 = (X) ((HashMap) yVar.f1470g).get(abstractComponentCallbacksC0187t2.f2928j);
            if (x3 != null) {
                abstractComponentCallbacksC0187t.f2930m = abstractComponentCallbacksC0187t.f2929l.f2928j;
                abstractComponentCallbacksC0187t.f2929l = null;
            } else {
                throw new IllegalStateException("Fragment " + abstractComponentCallbacksC0187t + " declared target fragment " + abstractComponentCallbacksC0187t.f2929l + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = abstractComponentCallbacksC0187t.f2930m;
            if (str != null) {
                x3 = (X) ((HashMap) yVar.f1470g).get(str);
                if (x3 == null) {
                    StringBuilder sb = new StringBuilder("Fragment ");
                    sb.append(abstractComponentCallbacksC0187t);
                    sb.append(" declared target fragment ");
                    throw new IllegalStateException(r2.k.c(sb, abstractComponentCallbacksC0187t.f2930m, " that does not belong to this FragmentManager!"));
                }
            } else {
                x3 = null;
            }
        }
        if (x3 != null) {
            x3.j();
        }
        P p3 = abstractComponentCallbacksC0187t.f2941x;
        abstractComponentCallbacksC0187t.f2942y = p3.f2770v;
        abstractComponentCallbacksC0187t.f2903A = p3.f2772x;
        E0.a aVar = this.f2802a;
        aVar.n(abstractComponentCallbacksC0187t, false);
        ArrayList arrayList = abstractComponentCallbacksC0187t.f2922U;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t3 = ((r) obj).f2891a;
            abstractComponentCallbacksC0187t3.f2921T.a();
            androidx.lifecycle.M.d(abstractComponentCallbacksC0187t3);
            Bundle bundle2 = abstractComponentCallbacksC0187t3.f2925g;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("registryState");
            } else {
                bundle = null;
            }
            abstractComponentCallbacksC0187t3.f2921T.b(bundle);
        }
        arrayList.clear();
        abstractComponentCallbacksC0187t.z.b(abstractComponentCallbacksC0187t.f2942y, abstractComponentCallbacksC0187t.a(), abstractComponentCallbacksC0187t);
        abstractComponentCallbacksC0187t.f2924f = 0;
        abstractComponentCallbacksC0187t.f2911I = false;
        abstractComponentCallbacksC0187t.l(abstractComponentCallbacksC0187t.f2942y.f2949g);
        if (abstractComponentCallbacksC0187t.f2911I) {
            Iterator it = abstractComponentCallbacksC0187t.f2941x.f2763o.iterator();
            while (it.hasNext()) {
                ((V) it.next()).a(abstractComponentCallbacksC0187t);
            }
            Q q2 = abstractComponentCallbacksC0187t.z;
            q2.f2741G = false;
            q2.f2742H = false;
            q2.f2748N.f2788i = false;
            q2.u(0);
            aVar.i(abstractComponentCallbacksC0187t, false);
            return;
        }
        throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onAttach()");
    }

    public final int c() {
        Object obj;
        Object obj2;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (abstractComponentCallbacksC0187t.f2941x == null) {
            return abstractComponentCallbacksC0187t.f2924f;
        }
        int i4 = this.f2806e;
        int ordinal = abstractComponentCallbacksC0187t.f2918Q.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        i4 = Math.min(i4, -1);
                    }
                } else {
                    i4 = Math.min(i4, 5);
                }
            } else {
                i4 = Math.min(i4, 1);
            }
        } else {
            i4 = Math.min(i4, 0);
        }
        if (abstractComponentCallbacksC0187t.f2936s) {
            if (abstractComponentCallbacksC0187t.f2937t) {
                i4 = Math.max(this.f2806e, 2);
            } else if (this.f2806e < 4) {
                i4 = Math.min(i4, abstractComponentCallbacksC0187t.f2924f);
            } else {
                i4 = Math.min(i4, 1);
            }
        }
        if (!abstractComponentCallbacksC0187t.f2933p) {
            i4 = Math.min(i4, 1);
        }
        ViewGroup viewGroup = abstractComponentCallbacksC0187t.f2912J;
        if (viewGroup != null) {
            C0181m e4 = C0181m.e(viewGroup, abstractComponentCallbacksC0187t.e());
            e4.getClass();
            ArrayList arrayList = e4.f2869b;
            int size = arrayList.size();
            int i5 = 0;
            while (true) {
                obj = null;
                if (i5 < size) {
                    obj2 = arrayList.get(i5);
                    i5++;
                    ((c0) obj2).getClass();
                    if (T2.h.a(null, abstractComponentCallbacksC0187t)) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            ArrayList arrayList2 = e4.f2870c;
            int size2 = arrayList2.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size2) {
                    break;
                }
                Object obj3 = arrayList2.get(i6);
                i6++;
                ((c0) obj3).getClass();
                if (T2.h.a(null, abstractComponentCallbacksC0187t)) {
                    obj = obj3;
                    break;
                }
            }
        }
        if (abstractComponentCallbacksC0187t.f2934q) {
            if (abstractComponentCallbacksC0187t.i()) {
                i4 = Math.min(i4, 1);
            } else {
                i4 = Math.min(i4, -1);
            }
        }
        if (abstractComponentCallbacksC0187t.f2913K && abstractComponentCallbacksC0187t.f2924f < 5) {
            i4 = Math.min(i4, 4);
        }
        if (abstractComponentCallbacksC0187t.f2935r && abstractComponentCallbacksC0187t.f2912J != null) {
            i4 = Math.max(i4, 3);
        }
        if (P.J(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i4 + " for " + abstractComponentCallbacksC0187t);
        }
        return i4;
    }

    public final void d() {
        Bundle bundle;
        Bundle bundle2;
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "moveto CREATED: " + abstractComponentCallbacksC0187t);
        }
        Bundle bundle3 = abstractComponentCallbacksC0187t.f2925g;
        if (bundle3 != null) {
            bundle = bundle3.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        if (!abstractComponentCallbacksC0187t.f2917O) {
            E0.a aVar = this.f2802a;
            aVar.o(abstractComponentCallbacksC0187t, false);
            abstractComponentCallbacksC0187t.z.P();
            abstractComponentCallbacksC0187t.f2924f = 1;
            abstractComponentCallbacksC0187t.f2911I = false;
            abstractComponentCallbacksC0187t.f2919R.a(new C0359b(1, abstractComponentCallbacksC0187t));
            abstractComponentCallbacksC0187t.m(bundle);
            abstractComponentCallbacksC0187t.f2917O = true;
            if (abstractComponentCallbacksC0187t.f2911I) {
                abstractComponentCallbacksC0187t.f2919R.e(EnumC0206m.ON_CREATE);
                aVar.j(abstractComponentCallbacksC0187t, false);
                return;
            } else {
                throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onCreate()");
            }
        }
        abstractComponentCallbacksC0187t.f2924f = 1;
        Bundle bundle4 = abstractComponentCallbacksC0187t.f2925g;
        if (bundle4 != null && (bundle2 = bundle4.getBundle("childFragmentManager")) != null) {
            abstractComponentCallbacksC0187t.z.U(bundle2);
            Q q2 = abstractComponentCallbacksC0187t.z;
            q2.f2741G = false;
            q2.f2742H = false;
            q2.f2748N.f2788i = false;
            q2.u(1);
        }
    }

    public final void e() {
        Bundle bundle;
        String str;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (abstractComponentCallbacksC0187t.f2936s) {
            return;
        }
        if (P.J(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + abstractComponentCallbacksC0187t);
        }
        Bundle bundle2 = abstractComponentCallbacksC0187t.f2925g;
        ViewGroup viewGroup = null;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        LayoutInflater p3 = abstractComponentCallbacksC0187t.p(bundle);
        ViewGroup viewGroup2 = abstractComponentCallbacksC0187t.f2912J;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i4 = abstractComponentCallbacksC0187t.f2905C;
            if (i4 != 0) {
                if (i4 != -1) {
                    viewGroup = (ViewGroup) abstractComponentCallbacksC0187t.f2941x.f2771w.b(i4);
                    if (viewGroup == null) {
                        if (!abstractComponentCallbacksC0187t.f2938u) {
                            try {
                                str = abstractComponentCallbacksC0187t.u().getResources().getResourceName(abstractComponentCallbacksC0187t.f2905C);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(abstractComponentCallbacksC0187t.f2905C) + " (" + str + ") for fragment " + abstractComponentCallbacksC0187t);
                        }
                    } else if (!(viewGroup instanceof B)) {
                        Y.c cVar = Y.d.f2016a;
                        Y.d.b(new Y.a(abstractComponentCallbacksC0187t, "Attempting to add fragment " + abstractComponentCallbacksC0187t + " to container " + viewGroup + " which is not a FragmentContainerView"));
                        Y.d.a(abstractComponentCallbacksC0187t).getClass();
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + abstractComponentCallbacksC0187t + " for a container view with no id");
                }
            }
        }
        abstractComponentCallbacksC0187t.f2912J = viewGroup;
        abstractComponentCallbacksC0187t.t(p3, viewGroup, bundle);
        abstractComponentCallbacksC0187t.f2924f = 2;
    }

    public final void f() {
        boolean z;
        boolean z3;
        AbstractComponentCallbacksC0187t e4;
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "movefrom CREATED: " + abstractComponentCallbacksC0187t);
        }
        boolean z4 = true;
        int i4 = 0;
        if (abstractComponentCallbacksC0187t.f2934q && !abstractComponentCallbacksC0187t.i()) {
            z = true;
        } else {
            z = false;
        }
        P1.y yVar = this.f2803b;
        if (z) {
            yVar.x(abstractComponentCallbacksC0187t.f2928j, null);
        }
        if (!z) {
            U u3 = (U) yVar.f1472i;
            if (u3.f2783d.containsKey(abstractComponentCallbacksC0187t.f2928j) && u3.f2786g) {
                z3 = u3.f2787h;
            } else {
                z3 = true;
            }
            if (!z3) {
                String str = abstractComponentCallbacksC0187t.f2930m;
                if (str != null && (e4 = yVar.e(str)) != null && e4.f2909G) {
                    abstractComponentCallbacksC0187t.f2929l = e4;
                }
                abstractComponentCallbacksC0187t.f2924f = 0;
                return;
            }
        }
        C0191x c0191x = abstractComponentCallbacksC0187t.f2942y;
        if (c0191x != null) {
            z4 = ((U) yVar.f1472i).f2787h;
        } else {
            AbstractActivityC0416k abstractActivityC0416k = c0191x.f2949g;
            if (abstractActivityC0416k != null) {
                z4 = true ^ abstractActivityC0416k.isChangingConfigurations();
            }
        }
        if (z || z4) {
            ((U) yVar.f1472i).c(abstractComponentCallbacksC0187t, false);
        }
        abstractComponentCallbacksC0187t.z.l();
        abstractComponentCallbacksC0187t.f2919R.e(EnumC0206m.ON_DESTROY);
        abstractComponentCallbacksC0187t.f2924f = 0;
        abstractComponentCallbacksC0187t.f2911I = false;
        abstractComponentCallbacksC0187t.f2917O = false;
        abstractComponentCallbacksC0187t.f2911I = true;
        if (abstractComponentCallbacksC0187t.f2911I) {
            this.f2802a.k(abstractComponentCallbacksC0187t, false);
            ArrayList h3 = yVar.h();
            int size = h3.size();
            while (i4 < size) {
                Object obj = h3.get(i4);
                i4++;
                X x3 = (X) obj;
                if (x3 != null) {
                    AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = x3.f2804c;
                    if (abstractComponentCallbacksC0187t.f2928j.equals(abstractComponentCallbacksC0187t2.f2930m)) {
                        abstractComponentCallbacksC0187t2.f2929l = abstractComponentCallbacksC0187t;
                        abstractComponentCallbacksC0187t2.f2930m = null;
                    }
                }
            }
            String str2 = abstractComponentCallbacksC0187t.f2930m;
            if (str2 != null) {
                abstractComponentCallbacksC0187t.f2929l = yVar.e(str2);
            }
            yVar.s(this);
            return;
        }
        throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onDestroy()");
    }

    public final void g() {
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + abstractComponentCallbacksC0187t);
        }
        ViewGroup viewGroup = abstractComponentCallbacksC0187t.f2912J;
        abstractComponentCallbacksC0187t.z.u(1);
        abstractComponentCallbacksC0187t.f2924f = 1;
        abstractComponentCallbacksC0187t.f2911I = false;
        abstractComponentCallbacksC0187t.n();
        if (abstractComponentCallbacksC0187t.f2911I) {
            A2.t tVar = new A2.t(abstractComponentCallbacksC0187t.getViewModelStore(), b0.b.f3204e);
            String canonicalName = b0.b.class.getCanonicalName();
            if (canonicalName != null) {
                C0662k c0662k = ((b0.b) tVar.F(b0.b.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).f3205d;
                if (c0662k.f6199h <= 0) {
                    abstractComponentCallbacksC0187t.f2939v = false;
                    this.f2802a.v(abstractComponentCallbacksC0187t, false);
                    abstractComponentCallbacksC0187t.f2912J = null;
                    abstractComponentCallbacksC0187t.f2920S.f(null);
                    abstractComponentCallbacksC0187t.f2937t = false;
                    return;
                }
                c0662k.f6198g[0].getClass();
                throw new ClassCastException();
            }
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onDestroyView()");
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.fragment.app.P, androidx.fragment.app.Q] */
    public final void h() {
        boolean z;
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + abstractComponentCallbacksC0187t);
        }
        abstractComponentCallbacksC0187t.f2924f = -1;
        abstractComponentCallbacksC0187t.f2911I = false;
        abstractComponentCallbacksC0187t.o();
        if (abstractComponentCallbacksC0187t.f2911I) {
            Q q2 = abstractComponentCallbacksC0187t.z;
            if (!q2.f2743I) {
                q2.l();
                abstractComponentCallbacksC0187t.z = new P();
            }
            this.f2802a.l(abstractComponentCallbacksC0187t, false);
            abstractComponentCallbacksC0187t.f2924f = -1;
            abstractComponentCallbacksC0187t.f2942y = null;
            abstractComponentCallbacksC0187t.f2903A = null;
            abstractComponentCallbacksC0187t.f2941x = null;
            if (!abstractComponentCallbacksC0187t.f2934q || abstractComponentCallbacksC0187t.i()) {
                U u3 = (U) this.f2803b.f1472i;
                if (u3.f2783d.containsKey(abstractComponentCallbacksC0187t.f2928j) && u3.f2786g) {
                    z = u3.f2787h;
                } else {
                    z = true;
                }
                if (!z) {
                    return;
                }
            }
            if (P.J(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + abstractComponentCallbacksC0187t);
            }
            abstractComponentCallbacksC0187t.g();
            return;
        }
        throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onDetach()");
    }

    public final void i() {
        Bundle bundle;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (abstractComponentCallbacksC0187t.f2936s && abstractComponentCallbacksC0187t.f2937t && !abstractComponentCallbacksC0187t.f2939v) {
            if (P.J(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + abstractComponentCallbacksC0187t);
            }
            Bundle bundle2 = abstractComponentCallbacksC0187t.f2925g;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("savedInstanceState");
            } else {
                bundle = null;
            }
            abstractComponentCallbacksC0187t.t(abstractComponentCallbacksC0187t.p(bundle), null, bundle);
        }
    }

    public final void j() {
        P1.y yVar = this.f2803b;
        boolean z = this.f2805d;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (z) {
            if (P.J(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + abstractComponentCallbacksC0187t);
                return;
            }
            return;
        }
        try {
            this.f2805d = true;
            boolean z3 = false;
            while (true) {
                int c4 = c();
                int i4 = abstractComponentCallbacksC0187t.f2924f;
                if (c4 != i4) {
                    if (c4 > i4) {
                        switch (i4 + 1) {
                            case 0:
                                b();
                                break;
                            case 1:
                                d();
                                break;
                            case 2:
                                i();
                                e();
                                break;
                            case 3:
                                a();
                                break;
                            case 4:
                                abstractComponentCallbacksC0187t.f2924f = 4;
                                break;
                            case 5:
                                n();
                                break;
                            case 6:
                                abstractComponentCallbacksC0187t.f2924f = 6;
                                break;
                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                m();
                                break;
                        }
                    } else {
                        switch (i4 - 1) {
                            case -1:
                                h();
                                break;
                            case 0:
                                f();
                                break;
                            case 1:
                                g();
                                abstractComponentCallbacksC0187t.f2924f = 1;
                                break;
                            case 2:
                                abstractComponentCallbacksC0187t.f2937t = false;
                                abstractComponentCallbacksC0187t.f2924f = 2;
                                break;
                            case 3:
                                if (P.J(3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + abstractComponentCallbacksC0187t);
                                }
                                abstractComponentCallbacksC0187t.f2924f = 3;
                                break;
                            case 4:
                                o();
                                break;
                            case 5:
                                abstractComponentCallbacksC0187t.f2924f = 5;
                                break;
                            case 6:
                                k();
                                break;
                        }
                    }
                    z3 = true;
                } else {
                    if (!z3 && i4 == -1 && abstractComponentCallbacksC0187t.f2934q && !abstractComponentCallbacksC0187t.i()) {
                        if (P.J(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + abstractComponentCallbacksC0187t);
                        }
                        ((U) yVar.f1472i).c(abstractComponentCallbacksC0187t, true);
                        yVar.s(this);
                        if (P.J(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + abstractComponentCallbacksC0187t);
                        }
                        abstractComponentCallbacksC0187t.g();
                    }
                    if (abstractComponentCallbacksC0187t.f2916N) {
                        P p3 = abstractComponentCallbacksC0187t.f2941x;
                        if (p3 != null && abstractComponentCallbacksC0187t.f2933p && P.K(abstractComponentCallbacksC0187t)) {
                            p3.f2740F = true;
                        }
                        abstractComponentCallbacksC0187t.f2916N = false;
                        abstractComponentCallbacksC0187t.z.o();
                    }
                    this.f2805d = false;
                    return;
                }
            }
        } catch (Throwable th) {
            this.f2805d = false;
            throw th;
        }
    }

    public final void k() {
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "movefrom RESUMED: " + abstractComponentCallbacksC0187t);
        }
        abstractComponentCallbacksC0187t.z.u(5);
        abstractComponentCallbacksC0187t.f2919R.e(EnumC0206m.ON_PAUSE);
        abstractComponentCallbacksC0187t.f2924f = 6;
        abstractComponentCallbacksC0187t.f2911I = true;
        this.f2802a.m(abstractComponentCallbacksC0187t, false);
    }

    public final void l(ClassLoader classLoader) {
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        Bundle bundle = abstractComponentCallbacksC0187t.f2925g;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            if (abstractComponentCallbacksC0187t.f2925g.getBundle("savedInstanceState") == null) {
                abstractComponentCallbacksC0187t.f2925g.putBundle("savedInstanceState", new Bundle());
            }
            try {
                abstractComponentCallbacksC0187t.f2926h = abstractComponentCallbacksC0187t.f2925g.getSparseParcelableArray("viewState");
                abstractComponentCallbacksC0187t.f2927i = abstractComponentCallbacksC0187t.f2925g.getBundle("viewRegistryState");
                W w2 = (W) abstractComponentCallbacksC0187t.f2925g.getParcelable("state");
                if (w2 != null) {
                    abstractComponentCallbacksC0187t.f2930m = w2.f2799q;
                    abstractComponentCallbacksC0187t.f2931n = w2.f2800r;
                    abstractComponentCallbacksC0187t.f2914L = w2.f2801s;
                }
                if (!abstractComponentCallbacksC0187t.f2914L) {
                    abstractComponentCallbacksC0187t.f2913K = true;
                }
            } catch (BadParcelableException e4) {
                throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + abstractComponentCallbacksC0187t, e4);
            }
        }
    }

    public final void m() {
        View view;
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "moveto RESUMED: " + abstractComponentCallbacksC0187t);
        }
        C0186s c0186s = abstractComponentCallbacksC0187t.f2915M;
        if (c0186s == null) {
            view = null;
        } else {
            view = c0186s.f2901j;
        }
        if (view != null) {
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            }
        }
        abstractComponentCallbacksC0187t.b().f2901j = null;
        abstractComponentCallbacksC0187t.z.P();
        abstractComponentCallbacksC0187t.z.A(true);
        abstractComponentCallbacksC0187t.f2924f = 7;
        abstractComponentCallbacksC0187t.f2911I = false;
        abstractComponentCallbacksC0187t.f2911I = true;
        if (abstractComponentCallbacksC0187t.f2911I) {
            abstractComponentCallbacksC0187t.f2919R.e(EnumC0206m.ON_RESUME);
            Q q2 = abstractComponentCallbacksC0187t.z;
            q2.f2741G = false;
            q2.f2742H = false;
            q2.f2748N.f2788i = false;
            q2.u(7);
            this.f2802a.p(abstractComponentCallbacksC0187t, false);
            this.f2803b.x(abstractComponentCallbacksC0187t.f2928j, null);
            abstractComponentCallbacksC0187t.f2925g = null;
            abstractComponentCallbacksC0187t.f2926h = null;
            abstractComponentCallbacksC0187t.f2927i = null;
            return;
        }
        throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onResume()");
    }

    public final void n() {
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "moveto STARTED: " + abstractComponentCallbacksC0187t);
        }
        abstractComponentCallbacksC0187t.z.P();
        abstractComponentCallbacksC0187t.z.A(true);
        abstractComponentCallbacksC0187t.f2924f = 5;
        abstractComponentCallbacksC0187t.f2911I = false;
        abstractComponentCallbacksC0187t.r();
        if (abstractComponentCallbacksC0187t.f2911I) {
            abstractComponentCallbacksC0187t.f2919R.e(EnumC0206m.ON_START);
            Q q2 = abstractComponentCallbacksC0187t.z;
            q2.f2741G = false;
            q2.f2742H = false;
            q2.f2748N.f2788i = false;
            q2.u(5);
            this.f2802a.s(abstractComponentCallbacksC0187t, false);
            return;
        }
        throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onStart()");
    }

    public final void o() {
        boolean J3 = P.J(3);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2804c;
        if (J3) {
            Log.d("FragmentManager", "movefrom STARTED: " + abstractComponentCallbacksC0187t);
        }
        Q q2 = abstractComponentCallbacksC0187t.z;
        q2.f2742H = true;
        q2.f2748N.f2788i = true;
        q2.u(4);
        abstractComponentCallbacksC0187t.f2919R.e(EnumC0206m.ON_STOP);
        abstractComponentCallbacksC0187t.f2924f = 4;
        abstractComponentCallbacksC0187t.f2911I = false;
        abstractComponentCallbacksC0187t.s();
        if (abstractComponentCallbacksC0187t.f2911I) {
            this.f2802a.t(abstractComponentCallbacksC0187t, false);
            return;
        }
        throw new AndroidRuntimeException("Fragment " + abstractComponentCallbacksC0187t + " did not call through to super.onStop()");
    }

    public X(E0.a aVar, P1.y yVar, ClassLoader classLoader, I i4, Bundle bundle) {
        this.f2802a = aVar;
        this.f2803b = yVar;
        W w2 = (W) bundle.getParcelable("state");
        AbstractComponentCallbacksC0187t a4 = i4.a(w2.f2789f);
        a4.f2928j = w2.f2790g;
        a4.f2936s = w2.f2791h;
        a4.f2938u = true;
        a4.f2904B = w2.f2792i;
        a4.f2905C = w2.f2793j;
        a4.f2906D = w2.k;
        a4.f2909G = w2.f2794l;
        a4.f2934q = w2.f2795m;
        a4.f2908F = w2.f2796n;
        a4.f2907E = w2.f2797o;
        a4.f2918Q = EnumC0207n.values()[w2.f2798p];
        a4.f2930m = w2.f2799q;
        a4.f2931n = w2.f2800r;
        a4.f2914L = w2.f2801s;
        this.f2804c = a4;
        a4.f2925g = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        P p3 = a4.f2941x;
        if (p3 != null && (p3.f2741G || p3.f2742H)) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        a4.k = bundle2;
        if (P.J(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a4);
        }
    }

    public X(E0.a aVar, P1.y yVar, AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, Bundle bundle) {
        this.f2802a = aVar;
        this.f2803b = yVar;
        this.f2804c = abstractComponentCallbacksC0187t;
        abstractComponentCallbacksC0187t.f2926h = null;
        abstractComponentCallbacksC0187t.f2927i = null;
        abstractComponentCallbacksC0187t.f2940w = 0;
        abstractComponentCallbacksC0187t.f2937t = false;
        abstractComponentCallbacksC0187t.f2933p = false;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = abstractComponentCallbacksC0187t.f2929l;
        abstractComponentCallbacksC0187t.f2930m = abstractComponentCallbacksC0187t2 != null ? abstractComponentCallbacksC0187t2.f2928j : null;
        abstractComponentCallbacksC0187t.f2929l = null;
        abstractComponentCallbacksC0187t.f2925g = bundle;
        abstractComponentCallbacksC0187t.k = bundle.getBundle("arguments");
    }
}
