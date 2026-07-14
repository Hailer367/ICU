package androidx.lifecycle;

import android.os.Bundle;
import b0.C0163e;
import b0.InterfaceC0162d;
import b0.InterfaceC0165g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class S {

    /* renamed from: a, reason: collision with root package name */
    public static final Y f1806a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Y f1807b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final Y f1808c = new Object();

    public static final void a(X x2, C0163e registry, AbstractC0146p lifecycle) {
        Object obj;
        kotlin.jvm.internal.h.e(registry, "registry");
        kotlin.jvm.internal.h.e(lifecycle, "lifecycle");
        HashMap hashMap = x2.f1821a;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = x2.f1821a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        P p = (P) obj;
        if (p != null && !p.f1805e) {
            p.b(lifecycle, registry);
            EnumC0145o enumC0145o = ((C0152w) lifecycle).f1855c;
            if (enumC0145o != EnumC0145o.f1845d && enumC0145o.compareTo(EnumC0145o.f1847f) < 0) {
                lifecycle.a(new C0137g(lifecycle, registry));
            } else {
                registry.d();
            }
        }
    }

    public static O b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new O();
            }
            HashMap hashMap = new HashMap();
            for (String key : bundle2.keySet()) {
                kotlin.jvm.internal.h.d(key, "key");
                hashMap.put(key, bundle2.get(key));
            }
            return new O(hashMap);
        }
        ClassLoader classLoader = O.class.getClassLoader();
        kotlin.jvm.internal.h.b(classLoader);
        bundle.setClassLoader(classLoader);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = parcelableArrayList.get(i2);
                kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i2));
            }
            return new O(linkedHashMap);
        }
        throw new IllegalStateException("Invalid bundle passed as restored state");
    }

    public static final O c(T.c cVar) {
        T t2;
        Bundle bundle;
        LinkedHashMap linkedHashMap = cVar.f768a;
        InterfaceC0165g interfaceC0165g = (InterfaceC0165g) linkedHashMap.get(f1806a);
        if (interfaceC0165g != null) {
            d0 d0Var = (d0) linkedHashMap.get(f1807b);
            if (d0Var != null) {
                Bundle bundle2 = (Bundle) linkedHashMap.get(f1808c);
                String str = (String) linkedHashMap.get(Y.f1825b);
                if (str != null) {
                    InterfaceC0162d b2 = interfaceC0165g.getSavedStateRegistry().b();
                    if (b2 instanceof T) {
                        t2 = (T) b2;
                    } else {
                        t2 = null;
                    }
                    if (t2 != null) {
                        LinkedHashMap linkedHashMap2 = e(d0Var).f1813d;
                        O o2 = (O) linkedHashMap2.get(str);
                        if (o2 == null) {
                            Class[] clsArr = O.f1797f;
                            t2.b();
                            Bundle bundle3 = t2.f1811c;
                            if (bundle3 != null) {
                                bundle = bundle3.getBundle(str);
                            } else {
                                bundle = null;
                            }
                            Bundle bundle4 = t2.f1811c;
                            if (bundle4 != null) {
                                bundle4.remove(str);
                            }
                            Bundle bundle5 = t2.f1811c;
                            if (bundle5 != null && bundle5.isEmpty()) {
                                t2.f1811c = null;
                            }
                            O b3 = b(bundle, bundle2);
                            linkedHashMap2.put(str, b3);
                            return b3;
                        }
                        return o2;
                    }
                    throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final void d(InterfaceC0165g interfaceC0165g) {
        EnumC0145o enumC0145o = ((C0152w) interfaceC0165g.getLifecycle()).f1855c;
        if (enumC0145o != EnumC0145o.f1845d && enumC0145o != EnumC0145o.f1846e) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (interfaceC0165g.getSavedStateRegistry().b() == null) {
            T t2 = new T(interfaceC0165g.getSavedStateRegistry(), (d0) interfaceC0165g);
            interfaceC0165g.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", t2);
            interfaceC0165g.getLifecycle().a(new C0135e(1, t2));
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.lifecycle.a0, java.lang.Object] */
    public static final U e(d0 d0Var) {
        T.b bVar;
        ?? obj = new Object();
        c0 viewModelStore = d0Var.getViewModelStore();
        if (d0Var instanceof InterfaceC0140j) {
            bVar = ((InterfaceC0140j) d0Var).getDefaultViewModelCreationExtras();
        } else {
            bVar = T.a.f767b;
        }
        return (U) new A0.g(viewModelStore, obj, bVar).c(U.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
