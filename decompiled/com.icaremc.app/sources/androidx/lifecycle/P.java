package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0192y;
import i0.C0362e;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class P implements V {

    /* renamed from: a, reason: collision with root package name */
    public final Application f2986a;

    /* renamed from: b, reason: collision with root package name */
    public final U f2987b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f2988c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0208o f2989d;

    /* renamed from: e, reason: collision with root package name */
    public final C0362e f2990e;

    public P(Application application, AbstractActivityC0192y abstractActivityC0192y, Bundle bundle) {
        U u3;
        this.f2990e = abstractActivityC0192y.getSavedStateRegistry();
        this.f2989d = abstractActivityC0192y.getLifecycle();
        this.f2988c = bundle;
        this.f2986a = application;
        if (application != null) {
            if (U.f2998c == null) {
                U.f2998c = new U(application);
            }
            u3 = U.f2998c;
            T2.h.b(u3);
        } else {
            u3 = new U(null);
        }
        this.f2987b = u3;
    }

    @Override // androidx.lifecycle.V
    public final S a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return c(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.V
    public final S b(Class cls, a0.c cVar) {
        Constructor a4;
        T t3 = T.f2997b;
        LinkedHashMap linkedHashMap = cVar.f2215a;
        String str = (String) linkedHashMap.get(t3);
        if (str != null) {
            if (linkedHashMap.get(M.f2978a) != null && linkedHashMap.get(M.f2979b) != null) {
                Application application = (Application) linkedHashMap.get(T.f2996a);
                boolean isAssignableFrom = AbstractC0194a.class.isAssignableFrom(cls);
                if (isAssignableFrom && application != null) {
                    a4 = Q.a(cls, Q.f2991a);
                } else {
                    a4 = Q.a(cls, Q.f2992b);
                }
                if (a4 == null) {
                    return this.f2987b.b(cls, cVar);
                }
                if (isAssignableFrom && application != null) {
                    return Q.b(cls, a4, application, M.c(cVar));
                }
                return Q.b(cls, a4, M.c(cVar));
            }
            if (this.f2989d != null) {
                return c(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15, types: [androidx.lifecycle.W, java.lang.Object] */
    public final S c(Class cls, String str) {
        Constructor a4;
        S b4;
        Object obj;
        Application application;
        AbstractC0208o abstractC0208o = this.f2989d;
        if (abstractC0208o != null) {
            boolean isAssignableFrom = AbstractC0194a.class.isAssignableFrom(cls);
            if (isAssignableFrom && this.f2986a != null) {
                a4 = Q.a(cls, Q.f2991a);
            } else {
                a4 = Q.a(cls, Q.f2992b);
            }
            if (a4 == null) {
                if (this.f2986a != null) {
                    return this.f2987b.a(cls);
                }
                if (W.f3000a == null) {
                    W.f3000a = new Object();
                }
                W w2 = W.f3000a;
                T2.h.b(w2);
                return w2.a(cls);
            }
            C0362e c0362e = this.f2990e;
            T2.h.b(c0362e);
            Bundle bundle = this.f2988c;
            Bundle a5 = c0362e.a(str);
            Class[] clsArr = J.f2969f;
            J b5 = M.b(a5, bundle);
            K k = new K(str, b5);
            k.h(abstractC0208o, c0362e);
            EnumC0207n enumC0207n = ((C0214v) abstractC0208o).f3024c;
            if (enumC0207n != EnumC0207n.f3015g && enumC0207n.compareTo(EnumC0207n.f3017i) < 0) {
                abstractC0208o.a(new C0199f(abstractC0208o, c0362e));
            } else {
                c0362e.d();
            }
            if (isAssignableFrom && (application = this.f2986a) != null) {
                b4 = Q.b(cls, a4, application, b5);
            } else {
                b4 = Q.b(cls, a4, b5);
            }
            synchronized (b4.f2993a) {
                try {
                    obj = b4.f2993a.get("androidx.lifecycle.savedstate.vm.tag");
                    if (obj == 0) {
                        b4.f2993a.put("androidx.lifecycle.savedstate.vm.tag", k);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj != 0) {
                k = obj;
            }
            if (b4.f2995c) {
                S.a(k);
            }
            return b4;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }
}
