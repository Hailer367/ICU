package i0;

import T2.h;
import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0192y;
import androidx.fragment.app.AbstractComponentCallbacksC0187t;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.InterfaceC0201h;
import androidx.lifecycle.InterfaceC0212t;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.S;
import androidx.lifecycle.X;
import androidx.lifecycle.Y;
import androidx.lifecycle.r;
import e.l;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import r2.k;

/* renamed from: i0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0359b implements r {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4092f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f4093g;

    public /* synthetic */ C0359b(int i4, Object obj) {
        this.f4092f = i4;
        this.f4093g = obj;
    }

    @Override // androidx.lifecycle.r
    public final void d(InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
        switch (this.f4092f) {
            case 0:
                InterfaceC0364g interfaceC0364g = (InterfaceC0364g) this.f4093g;
                if (enumC0206m == EnumC0206m.ON_CREATE) {
                    interfaceC0212t.getLifecycle().b(this);
                    Bundle a4 = interfaceC0364g.getSavedStateRegistry().a("androidx.savedstate.Restarter");
                    if (a4 != null) {
                        ArrayList<String> stringArrayList = a4.getStringArrayList("classes_to_restore");
                        if (stringArrayList != null) {
                            int size = stringArrayList.size();
                            int i4 = 0;
                            while (i4 < size) {
                                String str = stringArrayList.get(i4);
                                i4++;
                                String str2 = str;
                                try {
                                    Class<? extends U> asSubclass = Class.forName(str2, false, C0359b.class.getClassLoader()).asSubclass(InterfaceC0360c.class);
                                    h.d(asSubclass, "{\n                Class.…class.java)\n            }");
                                    try {
                                        Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                                        declaredConstructor.setAccessible(true);
                                        try {
                                            Object newInstance = declaredConstructor.newInstance(null);
                                            h.d(newInstance, "{\n                constr…wInstance()\n            }");
                                            if (interfaceC0364g instanceof Y) {
                                                X viewModelStore = ((Y) interfaceC0364g).getViewModelStore();
                                                C0362e savedStateRegistry = interfaceC0364g.getSavedStateRegistry();
                                                viewModelStore.getClass();
                                                LinkedHashMap linkedHashMap = viewModelStore.f3001a;
                                                Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                                                while (it.hasNext()) {
                                                    String str3 = (String) it.next();
                                                    h.e(str3, "key");
                                                    S s3 = (S) linkedHashMap.get(str3);
                                                    h.b(s3);
                                                    M.a(s3, savedStateRegistry, interfaceC0364g.getLifecycle());
                                                }
                                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                                    savedStateRegistry.d();
                                                }
                                            } else {
                                                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                                            }
                                        } catch (Exception e4) {
                                            throw new RuntimeException(k.d("Failed to instantiate ", str2), e4);
                                        }
                                    } catch (NoSuchMethodException e5) {
                                        throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
                                    }
                                } catch (ClassNotFoundException e6) {
                                    throw new RuntimeException(k.b("Class ", str2, " wasn't found"), e6);
                                }
                            }
                            return;
                        }
                        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                    }
                    return;
                }
                throw new AssertionError("Next event must be ON_CREATE");
            case 1:
                if (enumC0206m == EnumC0206m.ON_STOP) {
                    ((AbstractComponentCallbacksC0187t) this.f4093g).getClass();
                    return;
                }
                return;
            case 2:
                new HashMap();
                InterfaceC0201h[] interfaceC0201hArr = (InterfaceC0201h[]) this.f4093g;
                if (interfaceC0201hArr.length <= 0) {
                    if (interfaceC0201hArr.length <= 0) {
                        return;
                    }
                    InterfaceC0201h interfaceC0201h = interfaceC0201hArr[0];
                    throw null;
                }
                InterfaceC0201h interfaceC0201h2 = interfaceC0201hArr[0];
                throw null;
            case 3:
                if (enumC0206m == EnumC0206m.ON_CREATE) {
                    interfaceC0212t.getLifecycle().b(this);
                    ((N) this.f4093g).b();
                    return;
                } else {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + enumC0206m).toString());
                }
            default:
                AbstractActivityC0192y abstractActivityC0192y = (AbstractActivityC0192y) this.f4093g;
                l.access$ensureViewModelStore(abstractActivityC0192y);
                abstractActivityC0192y.getLifecycle().b(this);
                return;
        }
    }
}
