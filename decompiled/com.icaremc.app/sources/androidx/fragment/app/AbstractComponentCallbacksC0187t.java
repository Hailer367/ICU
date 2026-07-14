package androidx.fragment.app;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.AbstractC0217y;
import androidx.lifecycle.C0214v;
import androidx.lifecycle.EnumC0207n;
import androidx.lifecycle.InterfaceC0202i;
import androidx.lifecycle.InterfaceC0212t;
import i0.C0362e;
import i0.C0363f;
import i0.InterfaceC0364g;
import j.AbstractActivityC0416k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.fragment.app.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractComponentCallbacksC0187t implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0212t, androidx.lifecycle.Y, InterfaceC0202i, InterfaceC0364g {

    /* renamed from: W, reason: collision with root package name */
    public static final Object f2902W = new Object();

    /* renamed from: A, reason: collision with root package name */
    public AbstractComponentCallbacksC0187t f2903A;

    /* renamed from: B, reason: collision with root package name */
    public int f2904B;

    /* renamed from: C, reason: collision with root package name */
    public int f2905C;

    /* renamed from: D, reason: collision with root package name */
    public String f2906D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f2907E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f2908F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f2909G;

    /* renamed from: I, reason: collision with root package name */
    public boolean f2911I;

    /* renamed from: J, reason: collision with root package name */
    public ViewGroup f2912J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f2913K;

    /* renamed from: M, reason: collision with root package name */
    public C0186s f2915M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f2916N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f2917O;
    public String P;

    /* renamed from: Q, reason: collision with root package name */
    public EnumC0207n f2918Q;

    /* renamed from: R, reason: collision with root package name */
    public C0214v f2919R;

    /* renamed from: S, reason: collision with root package name */
    public final androidx.lifecycle.z f2920S;

    /* renamed from: T, reason: collision with root package name */
    public C0363f f2921T;

    /* renamed from: U, reason: collision with root package name */
    public final ArrayList f2922U;

    /* renamed from: V, reason: collision with root package name */
    public final r f2923V;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f2925g;

    /* renamed from: h, reason: collision with root package name */
    public SparseArray f2926h;

    /* renamed from: i, reason: collision with root package name */
    public Bundle f2927i;
    public Bundle k;

    /* renamed from: l, reason: collision with root package name */
    public AbstractComponentCallbacksC0187t f2929l;

    /* renamed from: n, reason: collision with root package name */
    public int f2931n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2933p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2934q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2935r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2936s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2937t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2938u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2939v;

    /* renamed from: w, reason: collision with root package name */
    public int f2940w;

    /* renamed from: x, reason: collision with root package name */
    public P f2941x;

    /* renamed from: y, reason: collision with root package name */
    public C0191x f2942y;

    /* renamed from: f, reason: collision with root package name */
    public int f2924f = -1;

    /* renamed from: j, reason: collision with root package name */
    public String f2928j = UUID.randomUUID().toString();

    /* renamed from: m, reason: collision with root package name */
    public String f2930m = null;

    /* renamed from: o, reason: collision with root package name */
    public Boolean f2932o = null;
    public Q z = new P();

    /* renamed from: H, reason: collision with root package name */
    public final boolean f2910H = true;

    /* renamed from: L, reason: collision with root package name */
    public boolean f2914L = true;

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.fragment.app.P, androidx.fragment.app.Q] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.lifecycle.z, androidx.lifecycle.y] */
    public AbstractComponentCallbacksC0187t() {
        new F.b(8, this);
        this.f2918Q = EnumC0207n.f3018j;
        this.f2920S = new AbstractC0217y();
        new AtomicInteger();
        this.f2922U = new ArrayList();
        this.f2923V = new r(this);
        f();
    }

    public abstract A a();

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.fragment.app.s, java.lang.Object] */
    public final C0186s b() {
        if (this.f2915M == null) {
            ?? obj = new Object();
            Object obj2 = f2902W;
            obj.f2898g = obj2;
            obj.f2899h = obj2;
            obj.f2900i = obj2;
            obj.f2901j = null;
            this.f2915M = obj;
        }
        return this.f2915M;
    }

    public final P c() {
        if (this.f2942y != null) {
            return this.z;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final int d() {
        EnumC0207n enumC0207n = this.f2918Q;
        if (enumC0207n != EnumC0207n.f3015g && this.f2903A != null) {
            return Math.min(enumC0207n.ordinal(), this.f2903A.d());
        }
        return enumC0207n.ordinal();
    }

    public final P e() {
        P p3 = this.f2941x;
        if (p3 != null) {
            return p3;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final void f() {
        Bundle bundle;
        this.f2919R = new C0214v(this);
        this.f2921T = new C0363f(this);
        ArrayList arrayList = this.f2922U;
        r rVar = this.f2923V;
        if (!arrayList.contains(rVar)) {
            if (this.f2924f >= 0) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = rVar.f2891a;
                abstractComponentCallbacksC0187t.f2921T.a();
                androidx.lifecycle.M.d(abstractComponentCallbacksC0187t);
                Bundle bundle2 = abstractComponentCallbacksC0187t.f2925g;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle("registryState");
                } else {
                    bundle = null;
                }
                abstractComponentCallbacksC0187t.f2921T.b(bundle);
                return;
            }
            arrayList.add(rVar);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.fragment.app.P, androidx.fragment.app.Q] */
    public final void g() {
        f();
        this.P = this.f2928j;
        this.f2928j = UUID.randomUUID().toString();
        this.f2933p = false;
        this.f2934q = false;
        this.f2936s = false;
        this.f2937t = false;
        this.f2938u = false;
        this.f2940w = 0;
        this.f2941x = null;
        this.z = new P();
        this.f2942y = null;
        this.f2904B = 0;
        this.f2905C = 0;
        this.f2906D = null;
        this.f2907E = false;
        this.f2908F = false;
    }

    @Override // androidx.lifecycle.InterfaceC0202i
    public final a0.b getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = u().getApplicationContext();
        while (true) {
            if (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            } else {
                application = null;
                break;
            }
        }
        if (application == null && P.J(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + u().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        a0.c cVar = new a0.c(0);
        LinkedHashMap linkedHashMap = cVar.f2215a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.T.f2996a, application);
        }
        linkedHashMap.put(androidx.lifecycle.M.f2978a, this);
        linkedHashMap.put(androidx.lifecycle.M.f2979b, this);
        Bundle bundle = this.k;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.M.f2980c, bundle);
        }
        return cVar;
    }

    @Override // androidx.lifecycle.InterfaceC0212t
    public final AbstractC0208o getLifecycle() {
        return this.f2919R;
    }

    @Override // i0.InterfaceC0364g
    public final C0362e getSavedStateRegistry() {
        return this.f2921T.f4101b;
    }

    @Override // androidx.lifecycle.Y
    public final androidx.lifecycle.X getViewModelStore() {
        if (this.f2941x != null) {
            if (d() != 1) {
                HashMap hashMap = this.f2941x.f2748N.f2785f;
                androidx.lifecycle.X x3 = (androidx.lifecycle.X) hashMap.get(this.f2928j);
                if (x3 == null) {
                    androidx.lifecycle.X x4 = new androidx.lifecycle.X();
                    hashMap.put(this.f2928j, x4);
                    return x4;
                }
                return x3;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean h() {
        boolean h3;
        if (!this.f2907E) {
            P p3 = this.f2941x;
            if (p3 != null) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2903A;
                p3.getClass();
                if (abstractComponentCallbacksC0187t == null) {
                    h3 = false;
                } else {
                    h3 = abstractComponentCallbacksC0187t.h();
                }
                if (h3) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean i() {
        if (this.f2940w > 0) {
            return true;
        }
        return false;
    }

    public abstract void j();

    public void k(int i4, int i5, Intent intent) {
        if (P.J(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i4 + " resultCode: " + i5 + " data: " + intent);
        }
    }

    public void l(Context context) {
        AbstractActivityC0416k abstractActivityC0416k;
        this.f2911I = true;
        C0191x c0191x = this.f2942y;
        if (c0191x == null) {
            abstractActivityC0416k = null;
        } else {
            abstractActivityC0416k = c0191x.f2948f;
        }
        if (abstractActivityC0416k != null) {
            this.f2911I = true;
        }
    }

    public abstract void m(Bundle bundle);

    public abstract void n();

    public abstract void o();

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.f2911I = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AbstractActivityC0416k abstractActivityC0416k;
        C0191x c0191x = this.f2942y;
        if (c0191x == null) {
            abstractActivityC0416k = null;
        } else {
            abstractActivityC0416k = c0191x.f2948f;
        }
        if (abstractActivityC0416k != null) {
            abstractActivityC0416k.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f2911I = true;
    }

    public LayoutInflater p(Bundle bundle) {
        C0191x c0191x = this.f2942y;
        if (c0191x != null) {
            AbstractActivityC0416k abstractActivityC0416k = c0191x.f2952j;
            LayoutInflater cloneInContext = abstractActivityC0416k.getLayoutInflater().cloneInContext(abstractActivityC0416k);
            cloneInContext.setFactory2(this.z.f2755f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public abstract void q(Bundle bundle);

    public abstract void r();

    public abstract void s();

    public void t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.z.P();
        this.f2939v = true;
        getViewModelStore();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.f2928j);
        if (this.f2904B != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2904B));
        }
        if (this.f2906D != null) {
            sb.append(" tag=");
            sb.append(this.f2906D);
        }
        sb.append(")");
        return sb.toString();
    }

    public final Context u() {
        AbstractActivityC0416k abstractActivityC0416k;
        C0191x c0191x = this.f2942y;
        if (c0191x == null) {
            abstractActivityC0416k = null;
        } else {
            abstractActivityC0416k = c0191x.f2949g;
        }
        if (abstractActivityC0416k != null) {
            return abstractActivityC0416k;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final void v(int i4, int i5, int i6, int i7) {
        if (this.f2915M == null && i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            return;
        }
        b().f2893b = i4;
        b().f2894c = i5;
        b().f2895d = i6;
        b().f2896e = i7;
    }
}
