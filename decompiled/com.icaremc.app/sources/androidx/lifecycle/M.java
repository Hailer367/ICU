package androidx.lifecycle;

import android.os.Bundle;
import i0.C0359b;
import i0.C0362e;
import i0.InterfaceC0361d;
import i0.InterfaceC0364g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class M {

    /* renamed from: a, reason: collision with root package name */
    public static final T f2978a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final T f2979b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final T f2980c = new Object();

    public static final void a(S s3, C0362e c0362e, AbstractC0208o abstractC0208o) {
        Object obj;
        T2.h.e(c0362e, "registry");
        T2.h.e(abstractC0208o, "lifecycle");
        HashMap hashMap = s3.f2993a;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = s3.f2993a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        K k = (K) obj;
        if (k != null && !k.f2977h) {
            k.h(abstractC0208o, c0362e);
            EnumC0207n enumC0207n = ((C0214v) abstractC0208o).f3024c;
            if (enumC0207n != EnumC0207n.f3015g && enumC0207n.compareTo(EnumC0207n.f3017i) < 0) {
                abstractC0208o.a(new C0199f(abstractC0208o, c0362e));
            } else {
                c0362e.d();
            }
        }
    }

    public static J b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new J();
            }
            HashMap hashMap = new HashMap();
            for (String str : bundle2.keySet()) {
                T2.h.d(str, "key");
                hashMap.put(str, bundle2.get(str));
            }
            return new J(hashMap);
        }
        ClassLoader classLoader = J.class.getClassLoader();
        T2.h.b(classLoader);
        bundle.setClassLoader(classLoader);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                Object obj = parcelableArrayList.get(i4);
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i4));
            }
            return new J(linkedHashMap);
        }
        throw new IllegalStateException("Invalid bundle passed as restored state");
    }

    public static final J c(a0.c cVar) {
        N n3;
        Bundle bundle;
        LinkedHashMap linkedHashMap = cVar.f2215a;
        InterfaceC0364g interfaceC0364g = (InterfaceC0364g) linkedHashMap.get(f2978a);
        if (interfaceC0364g != null) {
            Y y3 = (Y) linkedHashMap.get(f2979b);
            if (y3 != null) {
                Bundle bundle2 = (Bundle) linkedHashMap.get(f2980c);
                String str = (String) linkedHashMap.get(T.f2997b);
                if (str != null) {
                    InterfaceC0361d b4 = interfaceC0364g.getSavedStateRegistry().b();
                    if (b4 instanceof N) {
                        n3 = (N) b4;
                    } else {
                        n3 = null;
                    }
                    if (n3 != null) {
                        O e4 = e(y3);
                        J j4 = (J) e4.f2985d.get(str);
                        if (j4 == null) {
                            Class[] clsArr = J.f2969f;
                            n3.b();
                            Bundle bundle3 = n3.f2983c;
                            if (bundle3 != null) {
                                bundle = bundle3.getBundle(str);
                            } else {
                                bundle = null;
                            }
                            Bundle bundle4 = n3.f2983c;
                            if (bundle4 != null) {
                                bundle4.remove(str);
                            }
                            Bundle bundle5 = n3.f2983c;
                            if (bundle5 != null && bundle5.isEmpty()) {
                                n3.f2983c = null;
                            }
                            J b5 = b(bundle, bundle2);
                            e4.f2985d.put(str, b5);
                            return b5;
                        }
                        return j4;
                    }
                    throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final void d(InterfaceC0364g interfaceC0364g) {
        EnumC0207n enumC0207n = ((C0214v) interfaceC0364g.getLifecycle()).f3024c;
        if (enumC0207n != EnumC0207n.f3015g && enumC0207n != EnumC0207n.f3016h) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (interfaceC0364g.getSavedStateRegistry().b() == null) {
            N n3 = new N(interfaceC0364g.getSavedStateRegistry(), (Y) interfaceC0364g);
            interfaceC0364g.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", n3);
            interfaceC0364g.getLifecycle().a(new C0359b(3, n3));
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.lifecycle.V, java.lang.Object] */
    public static final O e(Y y3) {
        a0.b bVar;
        ?? obj = new Object();
        X viewModelStore = y3.getViewModelStore();
        if (y3 instanceof InterfaceC0202i) {
            bVar = ((InterfaceC0202i) y3).getDefaultViewModelCreationExtras();
        } else {
            bVar = a0.a.f2214b;
        }
        return (O) new A2.t(viewModelStore, (V) obj, bVar).F(O.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
