package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import b0.C0163e;
import b0.InterfaceC0165g;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class V implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final Application f1814a;

    /* renamed from: b, reason: collision with root package name */
    public final Z f1815b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f1816c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0146p f1817d;

    /* renamed from: e, reason: collision with root package name */
    public final C0163e f1818e;

    public V(Application application, InterfaceC0165g interfaceC0165g, Bundle bundle) {
        Z z;
        this.f1818e = interfaceC0165g.getSavedStateRegistry();
        this.f1817d = interfaceC0165g.getLifecycle();
        this.f1816c = bundle;
        this.f1814a = application;
        if (application != null) {
            if (Z.f1826c == null) {
                Z.f1826c = new Z(application);
            }
            z = Z.f1826c;
            kotlin.jvm.internal.h.b(z);
        } else {
            z = new Z(null);
        }
        this.f1815b = z;
    }

    @Override // androidx.lifecycle.a0
    public final X a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return c(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.a0
    public final X b(Class cls, T.c cVar) {
        Constructor a2;
        Y y = Y.f1825b;
        LinkedHashMap linkedHashMap = cVar.f768a;
        String str = (String) linkedHashMap.get(y);
        if (str != null) {
            if (linkedHashMap.get(S.f1806a) != null && linkedHashMap.get(S.f1807b) != null) {
                Application application = (Application) linkedHashMap.get(Y.f1824a);
                boolean isAssignableFrom = AbstractC0131a.class.isAssignableFrom(cls);
                if (isAssignableFrom && application != null) {
                    a2 = W.a(W.f1819a, cls);
                } else {
                    a2 = W.a(W.f1820b, cls);
                }
                if (a2 == null) {
                    return this.f1815b.b(cls, cVar);
                }
                if (isAssignableFrom && application != null) {
                    return W.b(cls, a2, application, S.c(cVar));
                }
                return W.b(cls, a2, S.c(cVar));
            }
            if (this.f1817d != null) {
                return c(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15, types: [androidx.lifecycle.b0, java.lang.Object] */
    public final X c(Class cls, String str) {
        Constructor a2;
        X b2;
        Object obj;
        Application application;
        AbstractC0146p abstractC0146p = this.f1817d;
        if (abstractC0146p != null) {
            boolean isAssignableFrom = AbstractC0131a.class.isAssignableFrom(cls);
            if (isAssignableFrom && this.f1814a != null) {
                a2 = W.a(W.f1819a, cls);
            } else {
                a2 = W.a(W.f1820b, cls);
            }
            if (a2 == null) {
                if (this.f1814a != null) {
                    return this.f1815b.a(cls);
                }
                if (b0.f1830a == null) {
                    b0.f1830a = new Object();
                }
                b0 b0Var = b0.f1830a;
                kotlin.jvm.internal.h.b(b0Var);
                return b0Var.a(cls);
            }
            C0163e c0163e = this.f1818e;
            kotlin.jvm.internal.h.b(c0163e);
            Bundle bundle = this.f1816c;
            Bundle a3 = c0163e.a(str);
            Class[] clsArr = O.f1797f;
            O b3 = S.b(a3, bundle);
            P p = new P(str, b3);
            p.b(abstractC0146p, c0163e);
            EnumC0145o enumC0145o = ((C0152w) abstractC0146p).f1855c;
            if (enumC0145o != EnumC0145o.f1845d && enumC0145o.compareTo(EnumC0145o.f1847f) < 0) {
                abstractC0146p.a(new C0137g(abstractC0146p, c0163e));
            } else {
                c0163e.d();
            }
            if (isAssignableFrom && (application = this.f1814a) != null) {
                b2 = W.b(cls, a2, application, b3);
            } else {
                b2 = W.b(cls, a2, b3);
            }
            synchronized (b2.f1821a) {
                try {
                    obj = b2.f1821a.get("androidx.lifecycle.savedstate.vm.tag");
                    if (obj == 0) {
                        b2.f1821a.put("androidx.lifecycle.savedstate.vm.tag", p);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj != 0) {
                p = obj;
            }
            if (b2.f1823c) {
                X.a(p);
            }
            return b2;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }
}
