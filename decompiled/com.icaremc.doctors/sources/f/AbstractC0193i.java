package f;

import a.AbstractC0051a;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.EnumC0145o;
import androidx.lifecycle.InterfaceC0148s;
import androidx.lifecycle.InterfaceC0150u;
import g.AbstractC0199b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/* renamed from: f.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0193i {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2265a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2266b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2267c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2268d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient LinkedHashMap f2269e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f2270f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f2271g = new Bundle();

    public final boolean a(int i2, int i3, Intent intent) {
        InterfaceC0186b interfaceC0186b;
        String str = (String) this.f2265a.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        C0190f c0190f = (C0190f) this.f2269e.get(str);
        if (c0190f != null) {
            interfaceC0186b = c0190f.f2257a;
        } else {
            interfaceC0186b = null;
        }
        if (interfaceC0186b != null) {
            ArrayList arrayList = this.f2268d;
            if (arrayList.contains(str)) {
                c0190f.f2257a.a(c0190f.f2258b.c(i3, intent));
                arrayList.remove(str);
                return true;
            }
        }
        this.f2270f.remove(str);
        this.f2271g.putParcelable(str, new C0185a(i3, intent));
        return true;
    }

    public abstract void b(int i2, AbstractC0199b abstractC0199b, Object obj);

    public final C0192h c(final String key, InterfaceC0150u interfaceC0150u, final AbstractC0199b contract, final InterfaceC0186b callback) {
        kotlin.jvm.internal.h.e(key, "key");
        kotlin.jvm.internal.h.e(contract, "contract");
        kotlin.jvm.internal.h.e(callback, "callback");
        AbstractC0146p lifecycle = interfaceC0150u.getLifecycle();
        C0152w c0152w = (C0152w) lifecycle;
        if (c0152w.f1855c.compareTo(EnumC0145o.f1847f) < 0) {
            e(key);
            LinkedHashMap linkedHashMap = this.f2267c;
            C0191g c0191g = (C0191g) linkedHashMap.get(key);
            if (c0191g == null) {
                c0191g = new C0191g(lifecycle);
            }
            InterfaceC0148s interfaceC0148s = new InterfaceC0148s() { // from class: f.d
                @Override // androidx.lifecycle.InterfaceC0148s
                public final void a(InterfaceC0150u interfaceC0150u2, EnumC0144n enumC0144n) {
                    AbstractC0193i abstractC0193i = AbstractC0193i.this;
                    LinkedHashMap linkedHashMap2 = abstractC0193i.f2269e;
                    EnumC0144n enumC0144n2 = EnumC0144n.ON_START;
                    String str = key;
                    if (enumC0144n2 == enumC0144n) {
                        Bundle bundle = abstractC0193i.f2271g;
                        LinkedHashMap linkedHashMap3 = abstractC0193i.f2270f;
                        AbstractC0199b abstractC0199b = contract;
                        InterfaceC0186b interfaceC0186b = callback;
                        linkedHashMap2.put(str, new C0190f(abstractC0199b, interfaceC0186b));
                        if (linkedHashMap3.containsKey(str)) {
                            Object obj = linkedHashMap3.get(str);
                            linkedHashMap3.remove(str);
                            interfaceC0186b.a(obj);
                        }
                        C0185a c0185a = (C0185a) AbstractC0051a.z(bundle, str, C0185a.class);
                        if (c0185a != null) {
                            bundle.remove(str);
                            interfaceC0186b.a(abstractC0199b.c(c0185a.f2250c, c0185a.f2251d));
                            return;
                        }
                        return;
                    }
                    if (EnumC0144n.ON_STOP == enumC0144n) {
                        linkedHashMap2.remove(str);
                    } else if (EnumC0144n.ON_DESTROY == enumC0144n) {
                        abstractC0193i.f(str);
                    }
                }
            };
            c0191g.f2259a.a(interfaceC0148s);
            c0191g.f2260b.add(interfaceC0148s);
            linkedHashMap.put(key, c0191g);
            return new C0192h(this, key, contract, 0);
        }
        throw new IllegalStateException(("LifecycleOwner " + interfaceC0150u + " is attempting to register while current state is " + c0152w.f1855c + ". LifecycleOwners must call register before they are STARTED.").toString());
    }

    public final C0192h d(String key, AbstractC0199b abstractC0199b, InterfaceC0186b interfaceC0186b) {
        kotlin.jvm.internal.h.e(key, "key");
        e(key);
        this.f2269e.put(key, new C0190f(abstractC0199b, interfaceC0186b));
        LinkedHashMap linkedHashMap = this.f2270f;
        if (linkedHashMap.containsKey(key)) {
            Object obj = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            interfaceC0186b.a(obj);
        }
        Bundle bundle = this.f2271g;
        C0185a c0185a = (C0185a) AbstractC0051a.z(bundle, key, C0185a.class);
        if (c0185a != null) {
            bundle.remove(key);
            interfaceC0186b.a(abstractC0199b.c(c0185a.f2250c, c0185a.f2251d));
        }
        return new C0192h(this, key, abstractC0199b, 1);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.f2266b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        C0189e c0189e = new C0189e(0);
        Iterator it = new j1.a(new j1.c(c0189e, new R0.a(1, c0189e))).iterator();
        while (it.hasNext()) {
            Number number = (Number) it.next();
            Integer valueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.f2265a;
            if (!linkedHashMap2.containsKey(valueOf)) {
                int intValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(intValue), str);
                linkedHashMap.put(str, Integer.valueOf(intValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void f(String key) {
        Integer num;
        kotlin.jvm.internal.h.e(key, "key");
        if (!this.f2268d.contains(key) && (num = (Integer) this.f2266b.remove(key)) != null) {
            this.f2265a.remove(num);
        }
        this.f2269e.remove(key);
        LinkedHashMap linkedHashMap = this.f2270f;
        if (linkedHashMap.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + linkedHashMap.get(key));
            linkedHashMap.remove(key);
        }
        Bundle bundle = this.f2271g;
        if (bundle.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((C0185a) AbstractC0051a.z(bundle, key, C0185a.class)));
            bundle.remove(key);
        }
        LinkedHashMap linkedHashMap2 = this.f2267c;
        C0191g c0191g = (C0191g) linkedHashMap2.get(key);
        if (c0191g != null) {
            ArrayList arrayList = c0191g.f2260b;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                c0191g.f2259a.b((InterfaceC0148s) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(key);
        }
    }
}
