package b0;

import android.os.Bundle;
import androidx.fragment.app.M;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.InterfaceC0148s;
import androidx.lifecycle.InterfaceC0150u;
import androidx.lifecycle.S;
import androidx.lifecycle.X;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import d.k;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.h;

/* renamed from: b0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0160b implements InterfaceC0148s {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1971c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0165g f1972d;

    public /* synthetic */ C0160b(InterfaceC0165g interfaceC0165g, int i2) {
        this.f1971c = i2;
        this.f1972d = interfaceC0165g;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        switch (this.f1971c) {
            case 0:
                if (enumC0144n == EnumC0144n.ON_CREATE) {
                    interfaceC0150u.getLifecycle().b(this);
                    InterfaceC0165g interfaceC0165g = this.f1972d;
                    Bundle a2 = interfaceC0165g.getSavedStateRegistry().a("androidx.savedstate.Restarter");
                    if (a2 != null) {
                        ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                        if (stringArrayList != null) {
                            int size = stringArrayList.size();
                            int i2 = 0;
                            while (i2 < size) {
                                String str = stringArrayList.get(i2);
                                i2++;
                                String str2 = str;
                                try {
                                    Class<? extends U> asSubclass = Class.forName(str2, false, C0160b.class.getClassLoader()).asSubclass(InterfaceC0161c.class);
                                    h.d(asSubclass, "{\n                Class.…class.java)\n            }");
                                    try {
                                        Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                                        declaredConstructor.setAccessible(true);
                                        try {
                                            Object newInstance = declaredConstructor.newInstance(null);
                                            h.d(newInstance, "{\n                constr…wInstance()\n            }");
                                            if (interfaceC0165g instanceof d0) {
                                                c0 viewModelStore = ((d0) interfaceC0165g).getViewModelStore();
                                                C0163e savedStateRegistry = interfaceC0165g.getSavedStateRegistry();
                                                viewModelStore.getClass();
                                                LinkedHashMap linkedHashMap = viewModelStore.f1833a;
                                                Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                                                while (it.hasNext()) {
                                                    String key = (String) it.next();
                                                    h.e(key, "key");
                                                    X x2 = (X) linkedHashMap.get(key);
                                                    h.b(x2);
                                                    S.a(x2, savedStateRegistry, interfaceC0165g.getLifecycle());
                                                }
                                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                                    savedStateRegistry.d();
                                                }
                                            } else {
                                                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                                            }
                                        } catch (Exception e2) {
                                            throw new RuntimeException(O.a.m("Failed to instantiate ", str2), e2);
                                        }
                                    } catch (NoSuchMethodException e3) {
                                        throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
                                    }
                                } catch (ClassNotFoundException e4) {
                                    throw new RuntimeException(O.a.g("Class ", str2, " wasn't found"), e4);
                                }
                            }
                            return;
                        }
                        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                    }
                    return;
                }
                throw new AssertionError("Next event must be ON_CREATE");
            default:
                M m2 = (M) this.f1972d;
                k.access$ensureViewModelStore(m2);
                m2.getLifecycle().b(this);
                return;
        }
    }
}
